package com.mwojnar.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.controllers.Controllers;
import com.mwojnar.Assets.AssetLoader;
import com.mwojnar.GameWorld.GMTKRenderer;
import com.mwojnar.GameWorld.GMTKWorld;
import com.playgon.GameWorld.GameRenderer;
import com.playgon.GameWorld.GameWorld;
import com.playgon.Helpers.InputHandler;

public class GameScreen implements Screen {

	private GameWorld world;
	private GameRenderer renderer;
	private float runTime;

	// This is the constructor, not the class declaration
	public GameScreen() {

		AssetLoader.load();
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		float gameHeight = 1080;
		float gameWidth = gameHeight * 1080.0f / 1920.0f;
		Gdx.input.setCatchBackKey(true);
		Gdx.input.setCatchMenuKey(false);
		
		world = new GMTKWorld();
		InputHandler inputHandler = new InputHandler(world, screenWidth / gameWidth, screenHeight / gameHeight);
		Gdx.input.setInputProcessor(inputHandler);
		Controllers.addListener(inputHandler);
		renderer = new GMTKRenderer(world, (int) gameWidth, (int) gameHeight);
		world.setRenderer(renderer);
		
	}
	
	@Override
	public void render(float delta) {
		runTime += delta;
		world.update(delta);
		renderer.render(delta, runTime);
	}
	
	@Override
	public void resize(int width, int height) {}

	@Override
	public void show() {}

	@Override
	public void hide() {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void dispose() {
		
		AssetLoader.dispose();
		
	}

}