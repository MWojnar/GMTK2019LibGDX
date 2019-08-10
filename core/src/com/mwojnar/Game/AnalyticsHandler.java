package com.mwojnar.Game;

public interface AnalyticsHandler {
	
	public void sendData(String category, String action, String label);
	public void sendData(String category, String action, String label, long value);
	
	public void dispatch();
	
}