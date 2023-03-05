package ptithcm.spotify.ui;

import ptithcm.spotify.SpotifyApplication;

public interface IMainActivity {
    void hideProgressBar();
    void showProgressBar();
    void onCategorySelected(String category);
    void setActionBarTitle(String title);
    void playPause();
    SpotifyApplication getMyApplicationInstance();
}
