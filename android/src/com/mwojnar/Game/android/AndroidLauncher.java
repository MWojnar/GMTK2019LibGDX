package com.mwojnar.Game.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.mwojnar.Dribble.android.R;
import com.mwojnar.Game.AnalyticsHandler;
import com.mwojnar.Game.GMTKGame;
import com.mwojnar.Screens.GameScreen;

public class AndroidLauncher extends AndroidApplication implements AnalyticsHandler {

	private Tracker globalTracker;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
		globalTracker = analytics.newTracker(R.xml.global_tracker);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new GMTKGame(this, GameScreen.class, new AndroidBackendHandler()), config);
	}

	@Override
	public void onStart() {
				super.onStart();
				GoogleAnalytics.getInstance(this).setDryRun(false);
				GoogleAnalytics.getInstance(this).reportActivityStart(this);
				GoogleAnalytics.getInstance(this).setLocalDispatchPeriod(60);
	}

	@Override
	public void onStop() {
				super.onStop();
				GoogleAnalytics.getInstance(this).reportActivityStop(this);
	}
	
	@Override
	public void sendData(String category, String action, String label) {

		globalTracker.send(new HitBuilders.EventBuilder().setCategory(category).setAction(action).setLabel(label).build());

	}
	
	@Override
	public void sendData(String category, String action, String label, long value) {

		globalTracker.send(new HitBuilders.EventBuilder().setCategory(category).setAction(action).setLabel(label).setValue(value).build());

	}

	@Override
	public void dispatch() {}
}