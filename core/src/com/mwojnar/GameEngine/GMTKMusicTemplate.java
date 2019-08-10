package com.mwojnar.GameEngine;

import com.badlogic.gdx.files.FileHandle;
import com.mwojnar.Assets.AssetLoader;
import com.playgon.GameEngine.MusicTemplate;

public class GMTKMusicTemplate extends MusicTemplate {
    public GMTKMusicTemplate(FileHandle musicLocation) {
        super(musicLocation);
    }

    @Override
    public void play() {
        if (AssetLoader.isPlayingMusic)
            super.play();
    }
}
