package com.mcdenny.musicalapp.UI;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.mcdenny.musicalapp.R;
import com.mcdenny.musicalapp.adapters.SongAdapter;
import com.mcdenny.musicalapp.model.Album;
import com.mcdenny.musicalapp.model.Song;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongFragment extends android.support.v4.app.Fragment {
    private OnSongSelectedListener mListener;

    public SongFragment() {
        // Required empty public constructor
    }

    public static SongFragment newInstance() {
        return new SongFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.list_view, container, false);

       final ArrayList<Song> songs = new ArrayList<>();
       songs.add(new Song("Perfect", "3:48", "Ed-Sheeran"));
       songs.add(new Song("Nothing", "4:01", "Kygo"));
       songs.add(new Song("Freaky Friday", "3:30", "Chris Brown ft Lil Dicky"));
       songs.add(new Song("Audio", "4:00", "Diplo ft Sia, Labrinth"));
       songs.add(new Song("Girls like you", "3:50", "Maroon 5 ft Cardi B"));
       songs.add(new Song("Mpa", "3:32", "Becky 256"));
       songs.add(new Song("Fuck love", "2:29", "XXXtentacion"));
       songs.add(new Song("Suh different", "4:40", "Patoranking"));
       songs.add(new Song("Rude", "3:01", "Magic"));
       songs.add(new Song("Very well", "4:00", "King saha ft Dj Slick stuart, Dj Roja"));
       songs.add(new Song("So long my friend", "2:20", "Yung Bans"));

        SongAdapter songAdapter = new SongAdapter(view.getContext(), songs);
        ListView listView = view.findViewById(R.id.music_list);
        listView.setAdapter(songAdapter);

        // Pass data to the Activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song selectedSong = songs.get(position);
                mListener.onSongSelected(selectedSong);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SongFragment.OnSongSelectedListener) {
            mListener = (SongFragment.OnSongSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSongSelectedListener");
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
    public interface OnSongSelectedListener {
        // TODO: Update argument type and name
        void onSongSelected(Song song);
    }

}
