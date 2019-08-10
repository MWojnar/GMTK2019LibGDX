package com.mwojnar.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.mwojnar.Assets.AssetLoader;
import com.mwojnar.GameObjects.ConversationHandler;
import com.mwojnar.GameObjects.Question;
import com.mwojnar.GameObjects.TitleScreen;
import com.playgon.GameEngine.Entity;
import com.playgon.GameWorld.GameWorld;

public class GMTKWorld extends GameWorld {

	private long framesSinceLevelCreation = 0;
	private final Object lockObj = new Object();

	public GMTKWorld() {
		
		super();
		/*Entity tempEntity = new Dribble(this);
		tempEntity.setPos(new Vector2(100, 50), true);
		createEntity(tempEntity);*/
		
		setUsingRegions(true);
		
	}
	
	@Override
	public void initialize() {
		
		setFPS(60);
		AssetLoader.musicHandler.startMusic(AssetLoader.musicMain);
		getRenderer().setUsingIntegerViewPosition(true);
		getRenderer().setClearColor(Color.WHITE);

        TitleScreen title = new TitleScreen(this);
        createEntity(title);
	}
	
	@Override
	public void update(float delta) {

		if (getKeysFirstDown().contains(Input.Keys.ESCAPE))
			Gdx.app.exit();
		if (AssetLoader.loaded) {

			super.update(delta);
			
		}
		
	}

	@Override
	protected void updateMain(float delta) {

		super.updateMain(delta);
		
	}

	public void clearWorld() {
		
		for (Entity entity : getEntityList()) {
			
			entity.destroy();
			
		}
		releaseEntities();
		resetBackgrounds();
		
	}

	public long getFramesSinceLevelCreation() {
		
		return framesSinceLevelCreation;
		
	}

}