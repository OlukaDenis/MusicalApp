package com.mcdenny.musicalapp.UI;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mcdenny.musicalapp.R;

import java.util.Random;

public class PlayingActivity extends AppCompatActivity {
    private ImageView mFavorite;
    private ImageView mPlay;
    private SeekBar mseekBar;
    private TextView elapasedTime;
    private final long TIMER_INTERVAL = 1000;
    private boolean isPlaying;
    private boolean isPlayingRandom;
    private Random random;
    private MediaPlayer mediaPlayer;

    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        // For the up navigation
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //getting references to the views
        mFavorite = (ImageView) findViewById(R.id.addToFavorites);
        mPlay = (ImageView) findViewById(R.id.play);
        mseekBar = (SeekBar) findViewById(R.id.music_seekBar);
        elapasedTime = (TextView) findViewById(R.id.played_time);

        // Init variables

        isPlaying = false;
        isPlayingRandom = false;
        random = new Random();
        mediaPlayer = null;

        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlay.setImageResource(R.drawable.ic_pause);
                Toast.makeText(PlayingActivity.this, "Song playing", Toast.LENGTH_SHORT).show();
            }
        });


        mFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFavorite.setImageResource(R.drawable.ic_favorite);
                Toast.makeText(PlayingActivity.this, "Song added to favorites", Toast.LENGTH_SHORT).show();
            }
        });

        mseekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
