package com.mcdenny.musicalapp.UI;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.mcdenny.musicalapp.R;
import com.mcdenny.musicalapp.adapters.ArtistAdapter;
import com.mcdenny.musicalapp.model.Artist;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ArtistFragment.OnArtistSelectedListener} interface
 * to handle interaction events.
 */
public class ArtistFragment extends android.support.v4.app.Fragment {

    private OnArtistSelectedListener mListener;

    public ArtistFragment() {
        // Required empty public constructor
    }

    public static ArtistFragment newInstance() {
        return new ArtistFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_view_item, container, false);

        final ArrayList<Artist> artists = new ArrayList<>();
        artists.add(new Artist("Ed-Sheeran", R.drawable.perfect));
        artists.add(new Artist("Chris Brown", R.drawable.freaky_friday));
        artists.add(new Artist("Patoranking", R.drawable.perfect));
        artists.add(new Artist("Ed-Sheeran", R.drawable.perfect));
        artists.add(new Artist("Chris Brown", R.drawable.freaky_friday));
        artists.add(new Artist("Sarkodie", R.drawable.perfect));
        artists.add(new Artist("Beyonce", R.drawable.perfect));
        artists.add(new Artist("Lil Dicky", R.drawable.freaky_friday));
        artists.add(new Artist("Patoranking", R.drawable.perfect));
        artists.add(new Artist("Ed-Sheeran", R.drawable.perfect));
        artists.add(new Artist("Chris Brown", R.drawable.chrisb));
        artists.add(new Artist("Kygo ", R.drawable.kygo));


        ArtistAdapter artistAdapter = new ArtistAdapter(view.getContext(), artists);
        GridView gridView = view.findViewById(R.id.music_grid_list);
        gridView.setAdapter(artistAdapter);


        // Pass data to the Activity
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Artist selectedArtist = artists.get(position);
                mListener.onArtistSelected(selectedArtist);
            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnArtistSelectedListener) {
            mListener = (OnArtistSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnArtistSelectedListener");
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
    public interface OnArtistSelectedListener {
        // TODO: Update argument type and name
        void onArtistSelected(Artist artist);
    }
}
