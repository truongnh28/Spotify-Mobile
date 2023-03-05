package ptithcm.spotify.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONException;
import org.json.JSONObject;
import java.nio.charset.StandardCharsets;
import ptithcm.spotify.R;
import ptithcm.spotify.helper.SessionManager;
import ptithcm.spotify.util.Constants;
import ptithcm.spotify.util.HttpUtils;
import ptithcm.spotify.util.VolleyCallback;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_USER_TO_MAIN = "KEY_USER_TO_MAIN";
    public static final String KEY_PASSWORD_TO_MAIN = "KEY_PASSWORD_TO_MAIN";
    public static final String KEY_USER_FROM_REGISTER = "KEY_USER_FROM_REGISTER";
    public static final int REQUEST_CODE_REGISTER = 1;
    private Context context;
    private EditText editUserName;
    private EditText editPassword;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = this;
        session = new SessionManager(this);

        if(session.isLoggedIn()) {
            Intent intent = new Intent(context, HomeActivity.class);
            startActivity(intent);
            finish();
        }
        init();
    }

    private void init() {
        editUserName = (EditText) findViewById(R.id.edit_login_username);
        editPassword = (EditText) findViewById(R.id.edit_login_password);
        findViewById(R.id.btn_login_sign_in).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_login_sign_in) {
            login();
        }
    }

    private void login() {
        String userName = editUserName.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        if (validateInput(userName, password)) {
            loginProcess(userName, password, new VolleyCallback() {
                @Override
                public void handleCallback() {
                    Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, HomeActivity.class);
                    startActivity(intent);
                    session.setLogin(true);
                }
            }, new VolleyCallback() {
                @Override
                public void handleCallback() {
                    Toast.makeText(LoginActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_REGISTER && resultCode == Activity.RESULT_OK) {
            String userName = data.getStringExtra(KEY_USER_FROM_REGISTER);
            editUserName.setText(userName);
            editPassword.requestFocus();
        }
    }
    private boolean validateInput(String userName, String password) {
        if (TextUtils.isEmpty(password)) {
            editPassword.requestFocus();
            editPassword.setError(context.getResources().getString(R.string.error_field_required));
            return false;
        }
        if (TextUtils.isEmpty(userName)) {
            editUserName.requestFocus();
            editUserName.setError(context.getResources().getString(R.string.error_field_required));
            return false;
        }
        return true;
    }

    private void loginProcess(String userName, String password, final VolleyCallback success, final VolleyCallback err) {
        try {
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("username", userName);
            jsonBody.put("password", password);
            final String mRequestBody = jsonBody.toString();

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Constants.getLoginEndpoint(), new JSONObject(), new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.i("LOG_RESPONSE", String.valueOf(response));
                    success.handleCallback();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("LOG_RESPONSE", error.toString());
                    err.handleCallback();
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }
                @Override
                public byte[] getBody() {
                    return mRequestBody.getBytes(StandardCharsets.UTF_8);
                }
            };
            HttpUtils.getInstance(this).getRequestQueue().add(jsonObjectRequest);
        } catch (JSONException e) {
            e.printStackTrace();
            err.handleCallback();
        }
    }
}
