package com.example.lurzeood.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lurzeood on 2017/5/12 0012.
 */

public class BeatBox {

    private static final String TAG = "BeatBox";

    private static final String SOUNDS_FOLDER = "sample_sounds";

    private static final int MAX_SOUNDDS = 5;

    private AssetManager mAssets;

    private List<Sound> mSounds = new ArrayList<>();

    private SoundPool mSoundPool;

    public BeatBox(Context context){
        mAssets = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDDS, AudioManager.STREAM_MUSIC,0);
        LoadSounds();
    }

    public void play(Sound sound){
        Integer soundId = sound.getSoundId();
        if (soundId == null){
            return;
        }
        mSoundPool.play(soundId,1.0f,1.0f,1,0,1.0f);
    }

    public void release(){
        mSoundPool.release();
    }

    private void LoadSounds(){
        String[] soundNames;
        try {
            soundNames = mAssets.list(SOUNDS_FOLDER);
            Log.i(TAG,"Found" + soundNames.length + "sounds");
        } catch (IOException e) {
            Log.e(TAG,"Cound not list assets",e);
            return;
        }

        for (String filename : soundNames){
            try {
                String assetPath = SOUNDS_FOLDER + "/" + filename;
                Sound sound = new Sound(assetPath);
                load(sound);
                mSounds.add(sound);
            } catch (IOException e) {
                Log.e(TAG,"Coule not load sound "+ filename,e);
            }
        }
    }

    private void load(Sound sound) throws IOException {
        AssetFileDescriptor afd = mAssets.openFd(sound.getAssetPath());
        int soundId = mSoundPool.load(afd,1);
        sound.setSoundId(soundId);
    }

    public List<Sound> getSounds(){
        return mSounds;
    }

}
