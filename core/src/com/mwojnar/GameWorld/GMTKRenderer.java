package com.mwojnar.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mwojnar.Assets.AssetLoader;
import com.mwojnar.GameEngine.GMTKText;
import com.playgon.GameWorld.GameRenderer;
import com.playgon.GameWorld.GameWorld;

import java.util.Random;

public class GMTKRenderer extends GameRenderer {
	
	public static int timeSinceStart = 0;
	public static GMTKText dribbleText = new GMTKText();
	private static boolean initialLoad = false;

	public GMTKRenderer(GameWorld world, int gameWidth, int gameHeight) {
		
		super(world, gameWidth, gameHeight);
		
	}

	private long stretchMultiple = 1, timer = 0;
	private Random rand = new Random();
	
	@Override
	public void render(float delta, float runTime) {

		timer++;
		if (AssetLoader.assetManager.update() || initialLoad) {

			//Sleep for 2 seconds to let sounds fully load
			if (!initialLoad)
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			initialLoad = true;
			if (!AssetLoader.loaded) {
				
				//AssetLoader.assetManager.finishLoading();
				AssetLoader.loaded = true;
				AssetLoader.postload();
				getMyWorld().initialize();
				
			}
			
			getBatcher().totalRenderCalls = 0;

			/*if (!((GMTKWorld)getMyWorld()).isLoading()) {
				long beforeTime = System.currentTimeMillis();
				super.render(delta, runTime);
				long afterTime = System.currentTimeMillis();
			}*/
			timeSinceStart++;
			if (timeSinceStart < 0) {
				
				timeSinceStart = 0;
				
			}
			
			if (!this.getMyWorld().isDebug()) {

				float scale = getDimensions().y / 240.0f;

				if (false/*((GMTKWorld)this.getMyWorld()).isShowFPS()*/) {

					SpriteBatch batch = getBatcher();
					batch.begin();
					//ShapeRenderer shapes = getShapeRenderer();
					//shapes.begin(ShapeType.Filled);
					//shapes.setColor(Color.BLACK);
					//shapes.rect(getCamPos(false).x, getCamPos(false).y, AssetLoader.debugFont.getBounds(Integer.toString((int)this.getMyWorld().getAverageFPS())).width * 2, AssetLoader.debugFont.getBounds(Integer.toString((int)this.getMyWorld().getTrueFPS())).height * 2);
					//shapes.end();
					float prevScale = AssetLoader.debugFont.getScaleX();
					Color prevColor = AssetLoader.debugFont.getColor();
					AssetLoader.debugFont.getData().setScale(2);
					AssetLoader.debugFont.setColor(Color.RED);
					//IntBuffer buf = BufferUtils.newIntBuffer(16);
					//Gdx.gl.glGetIntegerv(GL20.GL_MAX_TEXTURE_SIZE, buf);
					//int maxSize = buf.get(0);
					AssetLoader.debugFont.draw(batch, Integer.toString(/*maxSize*/(int)getMyWorld().getAverageFPS()), getCamPos(false).x, getCamPos(false).y + getDimensions().y - AssetLoader.debugFont.getLineHeight());
					AssetLoader.debugFont.getData().setScale(prevScale);
					AssetLoader.debugFont.setColor(prevColor);
					batch.end();

				}

			}
			super.render(delta, runTime);
			
		} else {
			
			Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			getBatcher().begin();
			getBatcher().draw(AssetLoader.wojworksTexture, getDimensions().x / 2.0f - AssetLoader.wojworksTexture.getWidth(), getDimensions().y / 2.0f - AssetLoader.wojworksTexture.getHeight(), AssetLoader.wojworksTexture.getWidth() * 2.0f, AssetLoader.wojworksTexture.getHeight() * 2.0f, 0, 0, AssetLoader.wojworksTexture.getWidth(), AssetLoader.wojworksTexture.getHeight(), false, true);
			getBatcher().end();
			getShapeRenderer().setAutoShapeType(true);
			getShapeRenderer().begin();
			getShapeRenderer().set(ShapeType.Filled);
			getShapeRenderer().setColor(Color.WHITE);
			getShapeRenderer().rect(0.0f, 210.0f, getDimensions().x * AssetLoader.assetManager.getProgress(), 10.0f);
			getShapeRenderer().end();
			
		}
		
	}
	
}