package com.mwojnar.GameObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Align;
import com.mwojnar.Assets.AssetLoader;
import com.playgon.GameEngine.ControllerEvent;
import com.playgon.GameEngine.Entity;
import com.playgon.GameEngine.TouchEvent;
import com.playgon.GameWorld.GameRenderer;
import com.playgon.GameWorld.GameWorld;

import java.util.List;

public class ConversationHandler extends Entity {
    private Conversation conversation = null;
    private Question[] conversations = null;
    private TextBubble button1 = null, button2 = null;
    private Question currentQuestion = null;
    private boolean otherTurn = true;
    private int currentConversation = 0, goodEndings = 0, badEndings = 0;
    private String currentPerson = "";

    public ConversationHandler(GameWorld world, Question[] conversations) {
        super(world);
        conversation = new Conversation(world, 700, this);
        world.createEntity(conversation);
        this.conversations = conversations;
        this.currentQuestion = conversations[0];
        currentPerson = currentQuestion.getPersonName();
        setDepth(100002);
        handleQuestion();
    }

    private void generateButtons() {
        if (!currentQuestion.getIsEnding()) {
            if (button1 != null)
                button1.destroy();
            if (button2 != null)
                button2.destroy();
            button1 = new TextBubble(getWorld(), AssetLoader.buttonTexture, 50, 300, -115);
            button1.setHandler(this);
            button1.setFont(AssetLoader.buttonFont);
            button1.setText(currentQuestion.getAnswer1());
            button1.setAnswerNumber(0);
            button1.setPressedTexture(AssetLoader.buttonPressedTexture);
            button1.setPos(getWorld().getGameDimensions().x / 4 - button1.getWidth() / 2.0f, 832.0f, false);
            button1.setDepth(100001);
            button1.setTextColor(Color.WHITE);
            getWorld().createEntity(button1);
            if (currentQuestion.getAnswer2() != "") {
                button2 = new TextBubble(getWorld(), AssetLoader.buttonTexture, 50, 300, -115);
                button2.setHandler(this);
                button2.setFont(AssetLoader.buttonFont);
                button2.setText(currentQuestion.getAnswer2());
                button2.setAnswerNumber(1);
                button2.setPressedTexture(AssetLoader.buttonPressedTexture);
                button2.setPos(getWorld().getGameDimensions().x * 3 / 4 - button2.getWidth() / 2.0f, 832.0f, false);
                button2.setDepth(100001);
                button2.setTextColor(Color.WHITE);
                getWorld().createEntity(button2);
            }
        }
    }

    @Override
    public void update(float delta, List<TouchEvent> touchEventList, List<Character> charactersTyped, List<Integer> keysFirstDown, List<Integer> keysFirstUp, List<Integer> keysDown, List<ControllerEvent> controllerEvents) {
        super.update(delta, touchEventList, charactersTyped, keysFirstDown, keysFirstUp, keysDown, controllerEvents);

        if (otherTurn && currentQuestion != null) {
            handleQuestion();
            otherTurn = false;
        }
    }

    @Override
    public void draw(GameRenderer renderer) {
        super.draw(renderer);

        GlyphLayout layout = new GlyphLayout();
        layout.setText(AssetLoader.buttonFont, currentPerson, Color.WHITE, 300, Align.left, true);

        AssetLoader.buttonFont.draw(renderer.getBatcher(), layout, getWorld().getGameDimensions().x / 2.0f - layout.width / 2.0f, 75.0f);
    }

    public void buttonEffect(int effect) {
        if (button1 != null)
            button1.destroy();
        if (button2 != null)
            button2.destroy();
        if (effect == 2) {
            transitionToNextConversation();
            return;
        }
        if (effect == 0) {
            conversation.addText(currentQuestion.getAnswer1(), false);
            currentQuestion = currentQuestion.getAnswer1Question();
        } else {
            conversation.addText(currentQuestion.getAnswer2(), false);
            currentQuestion = currentQuestion.getAnswer2Question();
        }
        otherTurn = true;
        handleQuestion();
    }

    public void handleQuestion() {
        otherTurn = false;
        conversation.setIsWaiting(true);
    }

    private void transitionToNextConversation() {
        conversation.clear();
        conversation.destroy();
        conversation = new Conversation(getWorld(), 700, this);
        getWorld().createEntity(conversation);
        currentConversation++;
        if (currentConversation < conversations.length) {
            currentQuestion = conversations[currentConversation];
            currentPerson = currentQuestion.getPersonName();
            handleQuestion();
        } else {
            endGame();
        }
    }

    public void trueHandleQuestion() {
        if (currentQuestion.getIsEnding()) {
            conversation.addText(currentQuestion.getQuestionText(), true);
            if (currentQuestion.getEndingType() == 0) {
                goodEndings++;
                conversation.addGrayText("User has left the chatroom");
            }
            if (currentQuestion.getEndingType() == 1) {
                badEndings++;
                conversation.addGrayText("You have been blocked by this user");
            }
            currentQuestion = null;
            TextBubble nextButton = new TextBubble(getWorld(), AssetLoader.buttonTexture, 50, 300, -115);
            nextButton.setHandler(this);
            nextButton.setFont(AssetLoader.buttonFont);
            nextButton.setText("NEXT");
            nextButton.setTextColor(Color.WHITE);
            nextButton.setPos(getWorld().getGameDimensions().x / 2 - nextButton.getWidth() / 2.0f, 832.0f, false);
            nextButton.setAnswerNumber(2);
            nextButton.setPressedTexture(AssetLoader.buttonPressedTexture);
            nextButton.setDepth(100001);
            getWorld().createEntity(nextButton);
            button1 = nextButton;
            return;
        }
        if (currentQuestion.getIsAutoReply()) {
            conversation.addText(currentQuestion.getQuestionText(), true);
            otherTurn = true;
            buttonEffect(0);
        } else if (currentQuestion.getIsTransition()) {
            conversation.addText(currentQuestion.getQuestionText(), true);
            currentQuestion = currentQuestion.getAnswer1Question();
            otherTurn = true;
        } else {
            conversation.addText(currentQuestion.getQuestionText(), true);
            otherTurn = false;
            generateButtons();
        }
    }

    private void endGame() {
        if (badEndings > goodEndings) {
            Entity entity = new Entity(getWorld());
            entity.setSprite(AssetLoader.spriteEndBad);
            entity.setScale(1080.0f / 1920.0f);
            entity.setDepth(10000000);
            getWorld().createEntity(entity);
        } else {
            Entity entity = new Entity(getWorld());
            entity.setSprite(AssetLoader.spriteEndGood);
            entity.setScale(1080.0f / 1920.0f);
            entity.setDepth(10000000);
            getWorld().createEntity(entity);
        }
    }
}
