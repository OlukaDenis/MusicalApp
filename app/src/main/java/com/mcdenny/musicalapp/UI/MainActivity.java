package com.mcdenny.musicalapp.UI;

import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.mcdenny.musicalapp.R;
import com.mcdenny.musicalapp.adapters.MusicPagerAdapter;
import com.mcdenny.musicalapp.model.Album;
import com.mcdenny.musicalapp.model.Artist;
import com.mcdenny.musicalapp.model.Song;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity
        implements AlbumFragment.OnAlbumSelectedListener, ArtistFragment.OnArtistSelectedListener, SongFragment.OnSongSelectedListener {

    public static final String SELECTED_ALBUM = "SELECTED_ALBUM";
    public static final String SELECTED_ARTIST = "SELECTED_ARTIST";
    public static final String SELECTED_SONG = "SELECTED_SONG";
    private MusicPagerAdapter musicPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // To remove the shadow
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setElevation(0);
        }

        // Create the tabs
        musicPagerAdapter = new MusicPagerAdapter(getSupportFragmentManager());
        musicPagerAdapter.setPageTitles(initPagesTitles());

        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(musicPagerAdapter);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        LinearLayout linearLayout =(LinearLayout)findViewById(R.id.playing_layout);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PlayingActivity.class);
                startActivity(intent);
            }
        });
    }

    private String[] initPagesTitles() {
        String[] pageTitles = new String[MusicPagerAdapter.tabCount];
        pageTitles[0] = getResources().getString(R.string.songs);
        pageTitles[1] = getResources().getString(R.string.artists);
        pageTitles[2] = getResources().getString(R.string.albums);
        return pageTitles;
    }

    @Override
    public void onAlbumSelected(Album album) {
        Intent playActivity = new Intent(MainActivity.this, PlayingActivity.class);
        
        startActivity(playActivity);
    }

    @Override
    public void onArtistSelected(Artist artist) {
        Intent playActivity = new Intent(MainActivity.this, PlayingActivity.class);

        startActivity(playActivity);
    }

    @Override
    public void onSongSelected(Song song) {
        Intent playActivity = new Intent(MainActivity.this, PlayingActivity.class);

        startActivity(playActivity);

    }
}
