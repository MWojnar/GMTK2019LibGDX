package com.mwojnar.Game.desktop;

import com.badlogic.gdx.files.FileHandle;
import com.playgon.GameEngine.BackendHandler;

import org.tritonus.share.sampled.file.TAudioFileFormat;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class DesktopBackendHandler implements BackendHandler {
    @Override
    public int getSoundLengthMilliseconds(FileHandle fileHandle) {
        File file = fileHandle.file();
		AudioInputStream audioInputStream = null;
		InputStream inputStream = fileHandle.read();
		try {
		    inputStream = new BufferedInputStream(inputStream);
			audioInputStream = AudioSystem.getAudioInputStream(inputStream);
		} catch (UnsupportedAudioFileException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (audioInputStream != null) {
			AudioFormat format = audioInputStream.getFormat();
            long frames = audioInputStream.getFrameLength();
			return (int) ((frames / format.getFrameRate()) * 1000);
		} else {
			Mp3InputStream stream = new Mp3InputStream(fileHandle.read());
			try {
				while (stream.read() != -1){}
			} catch (IOException e) {
				e.printStackTrace();
				return 5000;
			}
			return stream.length;
			//return (int) ((frames / frameRate) * 1000);
			/*AudioFileFormat fileFormat = null;
            try {
                fileFormat = AudioSystem.getAudioFileFormat(fileHandle.read());
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (fileFormat != null && fileFormat instanceof TAudioFileFormat) {
                Map<?, ?> properties = ((TAudioFileFormat) fileFormat).properties();
                String key = "duration";
                Long microseconds = (Long) properties.get(key);
                return (int) (microseconds / 1000);
            }*/
        }
		//return 5000;
    }
}
