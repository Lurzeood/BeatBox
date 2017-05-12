package com.example.lurzeood.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
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

    private AssetManager mAssets;

    private List<Sound> mSounds = new ArrayList<>();

    public BeatBox(Context context){
        mAssets = context.getAssets();
        LoadSounds();
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
            String assetPath = SOUNDS_FOLDER + "/" + filename;
            Sound sound = new Sound(assetPath);
            mSounds.add(sound);
        }
    }

    public List<Sound> getSounds(){
        return mSounds;
    }

}
