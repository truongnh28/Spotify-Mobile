package ptithcm.spotify.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ptithcm.spotify.R;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView navView;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navView = findViewById(R.id.nav_view);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit();
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.btn_nav_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.btn_nav_search:
                        //TODO: handle Search fragment
                        fragment = new HomeFragment();
//                        fragment = new Search();
                        break;
                    case R.id.btn_nav_library:
                        //TODO: handle Library fragment
                        fragment = new HomeFragment();
//                        fragment = new LibraryMainFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
                return true;
            }
        });
    }
}
