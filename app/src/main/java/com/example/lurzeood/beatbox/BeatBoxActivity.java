package com.example.lurzeood.beatbox;

import android.support.v4.app.Fragment;

public class BeatBoxActivity extends SinglefragmentActivity {


    @Override
    protected Fragment createFragment() {
        return BeatBoxFragment.newInstance();
    }
}
