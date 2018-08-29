package com.mcdenny.musicalapp.UI;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.mcdenny.musicalapp.R;
import com.mcdenny.musicalapp.adapters.AlbumAdapter;
import com.mcdenny.musicalapp.adapters.ArtistAdapter;
import com.mcdenny.musicalapp.model.Album;
import com.mcdenny.musicalapp.model.Artist;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumFragment extends android.support.v4.app.Fragment{
    private OnAlbumSelectedListener mListener;

    public AlbumFragment() {
        // Required empty public constructor
    }

    public static AlbumFragment newInstance() {
        return new AlbumFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_view_item, container, false);

        final ArrayList<Album> albums = new ArrayList<>();
        albums.add(new Album("Perfect", "Ed-Sheeran", R.drawable.perfect));
        albums.add(new Album("Loyal", "Chris Brown", R.drawable.chrisb));
        albums.add(new Album("Tokyayitaba", "Radio &Weasel", R.drawable.weasel));
        albums.add(new Album("Nothing", "Kygo", R.drawable.kygo));
        albums.add(new Album("Perfect", "Ed-Sheeran", R.drawable.perfect));
        albums.add(new Album("Loyal", "Chris Brown", R.drawable.chrisb));
        albums.add(new Album("Tokyayitaba", "Radio &Weasel", R.drawable.weasel));
        albums.add(new Album("Nothing", "Kygo", R.drawable.kygo));
        albums.add(new Album("Perfect", "Ed-Sheeran", R.drawable.perfect));
        albums.add(new Album("Loyal", "Chris Brown", R.drawable.chrisb));
        albums.add(new Album("Tokyayitaba", "Radio &Weasel", R.drawable.weasel));
        albums.add(new Album("Nothing", "Kygo", R.drawable.kygo));

        AlbumAdapter albumAdapter = new AlbumAdapter(view.getContext(), albums);
        GridView gridView = view.findViewById(R.id.music_grid_list);
        gridView.setAdapter(albumAdapter);


        // Pass data to the Activity
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Album selectedAlbum = albums.get(position);
                mListener.onAlbumSelected(selectedAlbum);
            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AlbumFragment.OnAlbumSelectedListener) {
            mListener = (AlbumFragment.OnAlbumSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnAlbumSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnAlbumSelectedListener {
        // TODO: Update argument type and name
        void onAlbumSelected(Album album);
    }

}
