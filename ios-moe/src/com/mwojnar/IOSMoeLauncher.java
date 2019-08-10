package com.mwojnar;

import com.badlogic.gdx.backends.iosmoe.IOSApplication;
import com.badlogic.gdx.backends.iosmoe.IOSApplicationConfiguration;
import org.moe.natj.general.Pointer;
import com.mwojnar.Game.GMTKGame;
import com.mwojnar.Screens.GameScreen;

import apple.uikit.UIView;
import apple.uikit.UIViewController;
import apple.uikit.c.UIKit;

public class IOSMoeLauncher extends IOSApplication.Delegate {

    protected IOSMoeLauncher(Pointer peer) {
        super(peer);
    }

    @Override
    protected IOSApplication createApplication() {
        IOSApplicationConfiguration config = new IOSApplicationConfiguration();
        config.useAccelerometer = false;
        config.orientationLandscape = true;
        config.orientationPortrait = false;
        UIViewController test;
        UIView test2;
        test2.safe
        return new IOSApplication(new GMTKGame(new String[] {}, GameScreen.class, new IOSBackendHandler()), config);
    }

    public static void main(String[] argv) {
        UIKit.UIApplicationMain(0, null, null, IOSMoeLauncher.class.getName());
    }
}
