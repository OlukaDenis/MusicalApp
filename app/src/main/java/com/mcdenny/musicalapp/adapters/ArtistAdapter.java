package com.mcdenny.musicalapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mcdenny.musicalapp.R;
import com.mcdenny.musicalapp.model.Artist;

import java.util.List;

public class ArtistAdapter extends ArrayAdapter<Artist> {

    public ArtistAdapter(@NonNull Context context, List<Artist> artistList) {
        super(context, 0, artistList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View artistRows = convertView;

        if(artistRows == null){
            artistRows = LayoutInflater.from(getContext()).inflate(
                    R.layout.artist_layout, parent, false);
        }

        Artist currentArtist = getItem(position);
        if (currentArtist != null){
            TextView aName = artistRows.findViewById(R.id.artist_name);
            aName.setText(currentArtist.getArtistName());

            ImageView aPhoto = artistRows.findViewById(R.id.artist_picture);
            aPhoto.setImageResource(currentArtist.getArtistPhoto());
        }

        return artistRows;
    }
}
