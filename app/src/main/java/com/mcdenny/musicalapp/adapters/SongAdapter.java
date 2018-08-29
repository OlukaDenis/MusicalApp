package com.mcdenny.musicalapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mcdenny.musicalapp.R;
import com.mcdenny.musicalapp.model.Song;

import java.util.List;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(@NonNull Context context, List<Song> songList) {
        super(context, 0, songList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View songRows = convertView;

        if (songRows == null) {
            songRows = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_layout, parent, false);
        }

        Song currentSong = getItem(position);
        if (currentSong != null) {
            TextView sName = songRows.findViewById(R.id.song_title);
            sName.setText(currentSong.getSongTitle());

            TextView sArtist = songRows.findViewById(R.id.song_artist);
            sArtist.setText(currentSong.getSongArtist());

            TextView sDuration = songRows.findViewById(R.id.song_duration);
            sDuration.setText(currentSong.getSongDuration());
        }

        return songRows;
    }
}
