package com.mwojnar.GameObjects;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.mwojnar.Assets.AssetLoader;
import com.playgon.GameEngine.ControllerEvent;
import com.playgon.GameEngine.Entity;
import com.playgon.GameEngine.TouchEvent;
import com.playgon.GameWorld.GameWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Conversation extends Entity {
    private float bottomY = 0.0f;
    private List<TextBubble> textList = new ArrayList<TextBubble>();
    private Random rand = new Random();
    private boolean isWaiting = false;
    private int timer = 0;
    private Entity ellipse = null;
    private ConversationHandler handler = null;

    public Conversation(GameWorld myWorld, float bottomY, ConversationHandler handler) {
        super(myWorld);
        this.bottomY = bottomY;
        this.handler = handler;
    }

    @Override
    public void update(float delta, List<TouchEvent> touchEventList, List<Character> charactersTyped, List<Integer> keysFirstDown, List<Integer> keysFirstUp, List<Integer> keysDown, List<ControllerEvent> controllerEvents) {
        super.update(delta, touchEventList, charactersTyped, keysFirstDown, keysFirstUp, keysDown, controllerEvents);

        timer--;
        if (timer <= 0) {
            timer = 0;
            if (isWaiting)
                setIsWaiting(false);
        }

        //if (keysFirstDown.contains(Input.Keys.BACKSPACE))
            //addRandomText();
    }

    /*private void addRandomText() {
        switch (rand.nextInt(10)) {
            case 0: addText("This is some random text."); break;
            case 1: addText("What are we doing right now?"); break;
            case 2: addText("Yeah..."); break;
            case 3: addText("What?"); break;
            case 4: addText("Well how do you do?  This is an incredibly long sentence to test the limits of the system.  I hope you enjoy reading it.  I know I sure didn't enjoy writing it.  I could be programming right now, but I had to create some sample text and whatnot."); break;
            case 5: addText("Banjo Kazooie is in Smash!"); break;
            case 6: addText("But why though?"); break;
            case 7: addText("100 bottles of beer on the wall..."); break;
            case 8: addText("Zzzzzzzzzzzzz..."); break;
            case 9: addText("That should do it."); break;
        }
    }*/

    public void addText(String textData, boolean otherTurn) {
        if (otherTurn)
            setIsWaiting(false);
        TextBubble newText = new TextBubble(getWorld(), otherTurn ? AssetLoader.blueTextBubbleTexture : AssetLoader.greenTextBubbleTexture, 75, 300, -115);
        newText.setText(textData);
        newText.setPos(0.0f, bottomY - newText.getHeight(), false);
        if (!otherTurn)
            newText.setPos(getWorld().getGameDimensions().x - newText.getWidth(), newText.getPos(false).y, false);
        otherTurn = !otherTurn;
        for (TextBubble text : textList) {
            text.setPos(text.getPos(false).x, text.getPos(false).y - newText.getHeight(), false);
        }
        getWorld().createEntity(newText);
        textList.add(newText);
    }

    public void addGrayText(String textData) {
        setIsWaiting(false);
        TextBubble newText = new TextBubble(getWorld(), AssetLoader.buttonGrayTexture, 75, 300, -115);
        newText.setText(textData);
        newText.setTextColor(Color.WHITE);
        newText.setPos(0.0f, bottomY - newText.getHeight(), false);
        for (TextBubble text : textList) {
            text.setPos(text.getPos(false).x, text.getPos(false).y - newText.getHeight(), false);
        }
        getWorld().createEntity(newText);
        textList.add(newText);
    }

    public void setIsWaiting(boolean isWaiting) {
        boolean trueHandleQuestion = false;
        if (!this.isWaiting && isWaiting) {
            for (TextBubble text : textList) {
                text.setPos(text.getPos(false).x, text.getPos(false).y - 75, false);
            }
            timer = 180;
            ellipse = new Entity(getWorld());
            ellipse.setSprite(AssetLoader.spriteEllipse);
            ellipse.setAnimationSpeed(3);
            ellipse.setPos(110.0f, bottomY - 50.0f, false);
            getWorld().createEntity(ellipse);
        } else if (this.isWaiting && !isWaiting) {
            for (TextBubble text : textList) {
                text.setPos(text.getPos(false).x, text.getPos(false).y + 75, false);
            }
            if (ellipse != null)
                ellipse.destroy();
            ellipse = null;
            if (handler != null) {
                trueHandleQuestion = true;
            }
        }
        this.isWaiting = isWaiting;
        if (trueHandleQuestion)
            handler.trueHandleQuestion();
    }

    public void clear() {
        for (TextBubble text : textList) {
            text.destroy();
        }
        textList.clear();
    }

    public boolean getIsWaiting(boolean isWaiting) {
        return isWaiting;
    }
}
