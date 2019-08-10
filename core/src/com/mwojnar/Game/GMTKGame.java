package com.mwojnar.Game;

import java.lang.reflect.InvocationTargetException;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.playgon.GameEngine.BackendHandler;
import com.playgon.GameEngine.PlaygonSoundManager;
import com.playgon.GameEngine.Sound;
import com.playgon.GameEngine.PlaygonSound;

public class GMTKGame extends Game {
	
	public static String[] args = null;
	private Class<Screen> screenClass = null;
	public static AnalyticsHandler analyticsHandler = null;
	private static BackendHandler backendHandler = null;
	
	public static Sound createSound(FileHandle fileHandle, PlaygonSoundManager manager, int maxInstances, boolean prioritized) {

		int length = backendHandler.getSoundLengthMilliseconds(fileHandle);
		PlaygonSound playSound = new PlaygonSound();
		playSound.length = length;
		playSound.manager = manager;
		playSound.maxInstances = maxInstances;
		playSound.prioritized = prioritized;
		Sound sound = playSound;
		sound.load(fileHandle);
		return sound;
		
	}
	
	public static Sound createSound(com.badlogic.gdx.audio.Sound libGDXSound, FileHandle fileHandle, PlaygonSoundManager manager, int maxInstances, boolean prioritized) {

		if (backendHandler != null) {
			int length = backendHandler.getSoundLengthMilliseconds(fileHandle);
			PlaygonSound playSound = new PlaygonSound();
			playSound.length = length;
			playSound.manager = manager;
			playSound.maxInstances = maxInstances;
			playSound.prioritized = prioritized;
			Sound sound = playSound;
			sound.load(libGDXSound);
			return sound;
		}
		return null;
		
	}

	public static Sound createSound() {

		return new PlaygonSound();

	}
	
	public GMTKGame(Class<?> screenClass, BackendHandler backendHandler) {
		
		super();
		this.screenClass = (Class<Screen>) screenClass;
		this.backendHandler = backendHandler;
		
	}
	
	public GMTKGame(String[] args, Class<?> screenClass, BackendHandler backendHandler) {
		
		super();
		this.screenClass = (Class<Screen>) screenClass;
		GMTKGame.args = args;
		this.backendHandler = backendHandler;
		
	}
	
	public GMTKGame(AnalyticsHandler analyticsHandler, Class<?> screenClass, BackendHandler backendHandler) {
		
		super();
		this.screenClass = (Class<Screen>) screenClass;
		this.analyticsHandler = analyticsHandler;
		this.backendHandler = backendHandler;
		
	}
	
	public GMTKGame(AnalyticsHandler analyticsHandler, String[] args, Class<?> screenClass, BackendHandler backendHandler) {
		
		super();
		this.screenClass = (Class<Screen>) screenClass;
		GMTKGame.args = args;
		this.analyticsHandler = analyticsHandler;
		this.backendHandler = backendHandler;
		
	}
	
	@Override
	public void create() {
		
		try {
			setScreen((Screen) screenClass.getConstructors()[0].newInstance());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}
	
}