package com.example.lurzeood.beatbox;

/**
 * Created by Lurzeood on 2017/5/12 0012.
 */

public class Sound {

    private String mAssetPath;

    private String mName;

    public Sound(String assetPath) {
        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String filename = components[components.length-1];
        mName = filename.replace(".wav","");
    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public String getName() {
        return mName;
    }
}
