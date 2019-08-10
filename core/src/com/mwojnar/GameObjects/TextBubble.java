package com.mwojnar.GameObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.mwojnar.Assets.AssetLoader;
import com.playgon.GameEngine.ControllerEvent;
import com.playgon.GameEngine.Entity;
import com.playgon.GameEngine.Mask;
import com.playgon.GameEngine.TouchEvent;
import com.playgon.GameWorld.GameRenderer;
import com.playgon.GameWorld.GameWorld;
import com.playgon.Utils.TiledDrawableYDown;

import java.util.List;

public class TextBubble extends Entity {

    private TextureRegion mainTexture = null, pressedTexture = null;
    private TextureRegion[][] subParts = null, pressedSubParts = null;
    private String text = "";
    private ConversationHandler handler = null;
    private int answerNumber = -1;
    private int excess = 0, maxWidth = 100, offset = 0;
    private TouchEvent heldEvent = null;
    private boolean isPressed = false;
    private Color textColor = new Color(0, 0, .65f, 1.0f);
    private BitmapFont font = AssetLoader.debugFont;

    public TextBubble(GameWorld myWorld, TextureRegion mainTexture, int excess, int maxWidth, int offset) {
        super(myWorld);
        this.mainTexture = mainTexture;
        pressedTexture = mainTexture;
        this.excess = excess;
        this.maxWidth = maxWidth;
        this.offset = offset;
        int subRegionWidth = (int)Math.ceil(mainTexture.getRegionWidth() / 3.0f);
        int subRegionHeight = (int)Math.ceil(mainTexture.getRegionHeight() / 3.0f);
        subParts = new TextureRegion[][] {{new TextureRegion(mainTexture, 0, 0, subRegionWidth - excess, subRegionHeight - excess), new TextureRegion(mainTexture, subRegionWidth - excess, 0, subRegionWidth + excess * 2, subRegionHeight - excess), new TextureRegion(mainTexture, subRegionWidth * 2 + excess, 0, subRegionWidth - excess, subRegionHeight - excess)},
                {new TextureRegion(mainTexture, 0, subRegionHeight - excess, subRegionWidth - excess, subRegionHeight + excess * 2), new TextureRegion(mainTexture, subRegionWidth - excess, subRegionHeight - excess, subRegionWidth + excess * 2, subRegionHeight + excess * 2), new TextureRegion(mainTexture, subRegionWidth * 2 + excess, subRegionHeight - excess, subRegionWidth - excess, subRegionHeight + excess * 2)},
                {new TextureRegion(mainTexture, 0, subRegionHeight * 2 + excess, subRegionWidth - excess, subRegionHeight - excess), new TextureRegion(mainTexture, subRegionWidth - excess, subRegionHeight * 2 + excess, subRegionWidth + excess * 2, subRegionHeight - excess), new TextureRegion(mainTexture, subRegionWidth * 2 + excess, subRegionHeight * 2 + excess, subRegionWidth - excess, subRegionHeight - excess)}};
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                subParts[y][x].flip(false, true);
            }
        }
        pressedSubParts = new TextureRegion[][] {{new TextureRegion(pressedTexture, 0, 0, subRegionWidth - excess, subRegionHeight - excess), new TextureRegion(pressedTexture, subRegionWidth - excess, 0, subRegionWidth + excess * 2, subRegionHeight - excess), new TextureRegion(pressedTexture, subRegionWidth * 2 + excess, 0, subRegionWidth - excess, subRegionHeight - excess)},
                {new TextureRegion(pressedTexture, 0, subRegionHeight - excess, subRegionWidth - excess, subRegionHeight + excess * 2), new TextureRegion(pressedTexture, subRegionWidth - excess, subRegionHeight - excess, subRegionWidth + excess * 2, subRegionHeight + excess * 2), new TextureRegion(pressedTexture, subRegionWidth * 2 + excess, subRegionHeight - excess, subRegionWidth - excess, subRegionHeight + excess * 2)},
                {new TextureRegion(pressedTexture, 0, subRegionHeight * 2 + excess, subRegionWidth - excess, subRegionHeight - excess), new TextureRegion(pressedTexture, subRegionWidth - excess, subRegionHeight * 2 + excess, subRegionWidth + excess * 2, subRegionHeight - excess), new TextureRegion(pressedTexture, subRegionWidth * 2 + excess, subRegionHeight * 2 + excess, subRegionWidth - excess, subRegionHeight - excess)}};
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                pressedSubParts[y][x].flip(false, true);
            }
        }
    }

    public void setPressedTexture(TextureRegion pressedTexture) {
        this.pressedTexture = pressedTexture;
        int subRegionWidth = (int)Math.ceil(mainTexture.getRegionWidth() / 3.0f);
        int subRegionHeight = (int)Math.ceil(mainTexture.getRegionHeight() / 3.0f);
        pressedSubParts = new TextureRegion[][] {{new TextureRegion(pressedTexture, 0, 0, subRegionWidth - excess, subRegionHeight - excess), new TextureRegion(pressedTexture, subRegionWidth - excess, 0, subRegionWidth + excess * 2, subRegionHeight - excess), new TextureRegion(pressedTexture, subRegionWidth * 2 + excess, 0, subRegionWidth - excess, subRegionHeight - excess)},
                {new TextureRegion(pressedTexture, 0, subRegionHeight - excess, subRegionWidth - excess, subRegionHeight + excess * 2), new TextureRegion(pressedTexture, subRegionWidth - excess, subRegionHeight - excess, subRegionWidth + excess * 2, subRegionHeight + excess * 2), new TextureRegion(pressedTexture, subRegionWidth * 2 + excess, subRegionHeight - excess, subRegionWidth - excess, subRegionHeight + excess * 2)},
                {new TextureRegion(pressedTexture, 0, subRegionHeight * 2 + excess, subRegionWidth - excess, subRegionHeight - excess), new TextureRegion(pressedTexture, subRegionWidth - excess, subRegionHeight * 2 + excess, subRegionWidth + excess * 2, subRegionHeight - excess), new TextureRegion(pressedTexture, subRegionWidth * 2 + excess, subRegionHeight * 2 + excess, subRegionWidth - excess, subRegionHeight - excess)}};
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                pressedSubParts[y][x].flip(false, true);
            }
        }
    }

    public void setHandler(ConversationHandler handler) {
        this.handler = handler;
    }

    public void setAnswerNumber(int answerNumber) {
        this.answerNumber = answerNumber;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

    @Override
    public void update(float delta, List<TouchEvent> touchEventList, List<Character> charactersTyped, List<Integer> keysFirstDown, List<Integer> keysFirstUp, List<Integer> keysDown, List<ControllerEvent> controllerEvents) {
        super.update(delta, touchEventList, charactersTyped, keysFirstDown, keysFirstUp, keysDown, controllerEvents);

        if (heldEvent == null && handler != null) {
            isPressed = false;
            for (TouchEvent touchEvent : touchEventList) {
                if (touchEvent.type == TouchEvent.Type.TOUCH_DOWN && collidingWithPoint(touchEvent.point, false)) {
                    heldEvent = touchEvent;
                    break;
                }
            }
        }
        if (heldEvent != null && handler != null) {
            if (heldEvent.type == TouchEvent.Type.TOUCH_UP || heldEvent.type == TouchEvent.Type.DEAD) {
                if (collidingWithPoint(heldEvent.point, false)) {
                    handler.buttonEffect(answerNumber);
                }
                heldEvent = null;
                isPressed = false;
            } else if (collidingWithPoint(heldEvent.point, false)) {
                isPressed = true;
            } else {
                isPressed = false;
            }
        }
    }

    @Override
    public void draw(GameRenderer renderer) {
        TextureRegion[][] parts = isPressed ? pressedSubParts : subParts;
        GlyphLayout layout = new GlyphLayout();
        layout.setText(font, text, textColor, maxWidth, Align.left, true);
        float subRegionWidth = mainTexture.getRegionWidth() / 3.0f;
        float subRegionHeight = mainTexture.getRegionHeight() / 3.0f;
        TiledDrawableYDown tiledDrawable = new TiledDrawableYDown(parts[1][1]);
        tiledDrawable.draw(renderer.getBatcher(), getPos(false).x + subRegionWidth - excess + offset, getPos(false).y + subRegionHeight - excess + offset, layout.width, layout.height);
        tiledDrawable = new TiledDrawableYDown(parts[0][1]);
        tiledDrawable.draw(renderer.getBatcher(), getPos(false).x + subRegionWidth - excess + offset, getPos(false).y + offset, layout.width, subRegionHeight - excess);
        tiledDrawable = new TiledDrawableYDown(parts[1][0]);
        tiledDrawable.draw(renderer.getBatcher(), getPos(false).x + offset, getPos(false).y + subRegionHeight - excess + offset, subRegionWidth - excess, layout.height);
        tiledDrawable = new TiledDrawableYDown(parts[2][1]);
        tiledDrawable.draw(renderer.getBatcher(), getPos(false).x + subRegionWidth - excess + offset, getPos(false).y + subRegionHeight + layout.height - excess + offset, layout.width, subRegionHeight - excess);
        tiledDrawable = new TiledDrawableYDown(parts[1][2]);
        tiledDrawable.draw(renderer.getBatcher(), getPos(false).x + subRegionWidth + layout.width - excess + offset, getPos(false).y + subRegionHeight - excess + offset, subRegionWidth - excess, layout.height);
        renderer.getBatcher().draw(parts[0][0], getPos(false).x + offset, getPos(false).y + offset);
        renderer.getBatcher().draw(parts[0][2], getPos(false).x + subRegionWidth + layout.width - excess + offset, getPos(false).y + offset);
        renderer.getBatcher().draw(parts[2][0], getPos(false).x + offset, getPos(false).y + subRegionHeight + layout.height - excess + offset);
        renderer.getBatcher().draw(parts[2][2], getPos(false).x + subRegionWidth + layout.width - excess + offset, getPos(false).y + subRegionHeight + layout.height - excess + offset);
        font.draw(renderer.getBatcher(), layout, getPos(false).x + subRegionWidth - excess + offset, getPos(false).y + subRegionHeight - excess + offset);
    }

    public void setText(String text) {
        this.text = text;
        setMask(new Mask(this, getWidth(), getHeight()));
    }

    public String getText() {
        return text;
    }

    public float getHeight() {
        GlyphLayout layout = new GlyphLayout();
        layout.setText(font, text, textColor, maxWidth, Align.left, true);
        int subRegionHeight = (int)Math.ceil(mainTexture.getRegionHeight() / 3.0f);
        return (subRegionHeight - excess) * 2 + layout.height + offset * 2;
    }

    public float getWidth() {
        GlyphLayout layout = new GlyphLayout();
        layout.setText(font, text, textColor, maxWidth, Align.left, true);
        int subRegionWidth = (int)Math.ceil(mainTexture.getRegionWidth() / 3.0f);
        return (subRegionWidth - excess) * 2 + layout.width + offset * 2;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public void setFont(BitmapFont font) {
        this.font = font;
    }
}
