package com.darkroom.fayadhahmad.thedarkroom.Activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.darkroom.fayadhahmad.thedarkroom.Fragments.BWFragment;
import com.darkroom.fayadhahmad.thedarkroom.Fragments.ColorFragment;
import com.darkroom.fayadhahmad.thedarkroom.Fragments.SlideFragment;
import com.darkroom.fayadhahmad.thedarkroom.R;

public class DarkRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dark_room);

        //Using key, value load the corresponding fragment
        String key = getIntent().getStringExtra("KEY");
        assert key != null;
        switch (key) {
            case "COLOR": {
                ColorFragment fragment = new ColorFragment();
                loadFragment(fragment);
                break;
            }
            case "BW": {
                BWFragment fragment = new BWFragment();
                loadFragment(fragment);
                break;
            }
            case "SLIDE": {
                SlideFragment fragment = new SlideFragment();
                loadFragment(fragment);
                break;
            }
        }
    }

    /**
     * Method to load a fragment in the fragment_container view on DarkRoomActivity
     *
     * @param fragment, The Fragment to be loaded
     */
    public void loadFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit();
    }
}
