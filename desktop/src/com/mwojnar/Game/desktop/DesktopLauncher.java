package com.mwojnar.Game.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mwojnar.Screens.GameScreen;
import com.mwojnar.Game.GMTKGame;

public class DesktopLauncher {
    public static void main (String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("JusTALK");
        config.setWindowedMode((int)(1080.0f * 1080.0f / 1920.0f), 1080);
        //config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
        new Lwjgl3Application(new GMTKGame(arg, GameScreen.class, new DesktopBackendHandler()), config);
    }
}