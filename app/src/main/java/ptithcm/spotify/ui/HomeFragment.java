package ptithcm.spotify.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import ptithcm.spotify.R;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

//        RecyclerView topSongsRecycleView = view.findViewById(R.id.topSongsRecycleView);
//        RecyclerView topSingersRecycleView = view.findViewById(R.id.topArtistsRecycleView);
//
//        HomeSongs[] songs = {
//                new HomeSongs(R.drawable.spotify_icon_green, "So Far Away", "Avenged Sevenfold"),
//                new HomeSongs(R.drawable.spotify_icon_green, "Ahora", "Yeika"),
//                new HomeSongs(R.drawable.spotify_icon_green, "It Was a Good Day", "Ice Cub"),
//                new HomeSongs(R.drawable.spotify_icon_green, "The Law", "Leonard Cohen"),
//                new HomeSongs(R.drawable.spotify_icon_green, "Lovely Day", "Bill Withers"),
//        };
//
//        HomeArtists[] singers = {
//                new HomeArtists(R.drawable.spotify_icon_green, "Rihanna"),
//                new HomeArtists(R.drawable.spotify_icon_green, "Yeika"),
//                new HomeArtists(R.drawable.spotify_icon_green, "Ice Cub"),
//                new HomeArtists(R.drawable.spotify_icon_green, "Avenged Sevenfold"),
//                new HomeArtists(R.drawable.spotify_icon_green, "Blump"),
//        };
//
//
//        topSongsRecycleView.setAdapter(new SongsAdapter(songs));
//
//        topSingersRecycleView.setAdapter(new ArtistsAdapter(Arrays.asList(singers)));
//
//
//        topSongsRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
//        topSingersRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        return view;
    }
}
