package techpro1.justinalexander.com.mystylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class stylistlogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stylist_login);

        final EditText Semail = findViewById(R.id.semail);
        final EditText Spassword = findViewById(R.id.spassword);
        final Button Slogin = findViewById(R.id.slogin);




        Slogin.setOnClickListener(v -> {
            final String email = Semail.getText().toString();
            final String password = Spassword.getText().toString();

            Response.Listener<String> responseListener = response -> {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        Intent intent = new Intent(stylistlogin.this, stylisthome.class);
                        stylistlogin.this.startActivity(intent);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(stylistlogin.this);
                        builder.setMessage("Login Failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            };

            stylist_login_request loginRequest = new stylist_login_request(email, password, responseListener);
            RequestQueue queue = Volley.newRequestQueue(stylistlogin.this);
            queue.add(loginRequest);
        });
    }
}


