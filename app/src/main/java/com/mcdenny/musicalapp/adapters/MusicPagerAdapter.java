package com.mcdenny.musicalapp.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mcdenny.musicalapp.UI.AlbumFragment;
import com.mcdenny.musicalapp.UI.ArtistFragment;
import com.mcdenny.musicalapp.UI.SongFragment;

public class MusicPagerAdapter extends FragmentPagerAdapter {
    public static final int tabCount = 3;
    private String[] pageTitles;

    public MusicPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SongFragment.newInstance();
            case 1:
                return ArtistFragment.newInstance();
            case 2:
                return AlbumFragment.newInstance();
        }
        return null;

    }

    public void setPageTitles(String[] pageTitles) {
        this.pageTitles = pageTitles;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position < tabCount) {
            return pageTitles[position];
        }
        return null;
    }
}

