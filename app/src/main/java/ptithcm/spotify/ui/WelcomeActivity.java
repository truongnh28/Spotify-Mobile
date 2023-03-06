package ptithcm.spotify.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ptithcm.spotify.R;
import ptithcm.spotify.helper.SessionManager;

public class WelcomeActivity extends AppCompatActivity {
    Button btnCreateAccount;
    Button btnSignIn;
    SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        session = new SessionManager(this);

        if(session.isLoggedIn()) {
            Intent intent = new Intent(WelcomeActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }

        btnCreateAccount = findViewById(R.id.btn_welcome_create_account);
        btnSignIn = findViewById(R.id.btn_welcome_sign_in);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
