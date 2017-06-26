package com.darkroom.fayadhahmad.thedarkroom;

import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public Film currentFilm;

    public void initiateC41(View view) {
        CheckBox stopBox = (CheckBox)findViewById(( R.id.checkBox));
        CheckBox stopBox2 = (CheckBox)findViewById(( R.id.checkBox2));

        if (stopBox.isChecked()) {
            currentFilm = initiateC41(1);
        } else if (stopBox2.isChecked()) {
            currentFilm = initiateC41(2);
        } else {
            currentFilm = initiateC41(0);
        }

        final TextView countdown = (TextView)findViewById(R.id.textView4);

        double times[] = currentFilm.getDevelopTimes();

        countdown.setText("00:00");


            long t = (long)(times[0] * 60 * 1000);
            new CountDownTimer(t, 1000) {

                @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
                public void onTick(long millisUntilFinished) {
                    countdown.setText(hmsTimeFormatter(millisUntilFinished));
                }

                public void onFinish() {
                    countdown.setText("Done!");
                }
            }.start();


    }

    /**
     * Converts millisecond to Minutes, Seconds for the Countdown, formats to String.
     *
     * @param milliSeconds
     * @return HH:mm:ss time formatted string
     */
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    private String hmsTimeFormatter(long milliSeconds) {

        String hms = String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliSeconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)));

        return hms;


    }

    private Film initiateC41(int pushedStops) {

        String colorDevelopers[] = {"Developer", "Blix", "Stabilizer", "Water"};

        double developTimes[] = {3.5, 6.5, 3, 1};

        Film color = new Film("C41", 0, colorDevelopers, developTimes,
                30, 4, 38.9 );

        if (pushedStops == 1 || pushedStops == 2) {
            color.isPushed(pushedStops, 1.25, 1.5);
        }

        return color;
    }

    private Film initiateE6(int pushedStops) {
        String colorDevelopers[] = {"First Developer", "Color Developer", "Blix", "Water"};

        double developTimes[] = {6.5, 4.5, 6.5};

        Film e6 = new Film("E6", 1, colorDevelopers, developTimes, 30,
                4, 38.5);

        if (pushedStops == 1 || pushedStops == 2) {
            e6.isPushed(pushedStops, 1.24, 1.615);
        }

        return e6;
    }


}
