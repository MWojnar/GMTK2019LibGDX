package com.mwojnar.Game.android;

import android.content.res.AssetFileDescriptor;
import android.media.MediaMetadataRetriever;

import com.badlogic.gdx.backends.android.AndroidFileHandle;
import com.badlogic.gdx.files.FileHandle;
import com.playgon.GameEngine.BackendHandler;

import java.io.IOException;

public class AndroidBackendHandler implements BackendHandler {
    @Override
    public int getSoundLengthMilliseconds(FileHandle fileHandle) {
        AndroidFileHandle aHandle = (AndroidFileHandle)fileHandle;
        try {
            AssetFileDescriptor descriptor = aHandle.getAssetFileDescriptor();
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            String length = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            return Integer.parseInt(length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 5000;
    }
}
