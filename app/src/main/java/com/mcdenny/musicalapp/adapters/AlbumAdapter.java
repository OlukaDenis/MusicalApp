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
import com.mcdenny.musicalapp.model.Album;

import java.util.List;

public class AlbumAdapter extends ArrayAdapter<Album> {

    public AlbumAdapter(@NonNull Context context, List<Album> albumList) {
        super(context, 0, albumList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View albumRows = convertView;

        if (albumRows == null){
            albumRows = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_layout, parent, false);
        }

        Album currentAlbum = getItem(position);
        if (currentAlbum != null){
            TextView title = albumRows.findViewById(R.id.album_title);
            title.setText(currentAlbum.getAlbumTitle());

            TextView artist = albumRows.findViewById(R.id.album_artist);
            artist.setText(currentAlbum.getAlbumArtist());

            ImageView cover = albumRows.findViewById(R.id.album_cover);
            cover.setImageResource(currentAlbum.getAlbumCover());
        }
        return albumRows;
    }
}
