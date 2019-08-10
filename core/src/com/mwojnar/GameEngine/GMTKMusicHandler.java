package com.mwojnar.GameEngine;

import com.mwojnar.Assets.AssetLoader;
import com.playgon.GameEngine.MusicTemplate;
import com.playgon.Helpers.MusicHandler;

public class GMTKMusicHandler extends MusicHandler {
    @Override
    public void startMusic(MusicTemplate music) {
        if (AssetLoader.isPlayingMusic)
            super.startMusic(music);
    }
}
