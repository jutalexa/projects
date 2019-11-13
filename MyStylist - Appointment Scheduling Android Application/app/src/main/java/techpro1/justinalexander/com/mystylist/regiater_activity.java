package techpro1.justinalexander.com.mystylist;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class regiater_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        final EditText uemail = findViewById(R.id.useremail);
        final EditText upassword = findViewById(R.id.userpassword);
        final EditText fname = findViewById(R.id.userfname);
        final EditText lname = findViewById(R.id.userlname);
        final EditText uphone = findViewById(R.id.userphone);
        final EditText ugender = findViewById(R.id.usergender);


        final Button register_button = findViewById(R.id.register);

        register_button.setOnClickListener(v -> {
            final String firstname = fname.getText().toString();
            final String lastname = lname.getText().toString();
            final String email = uemail.getText().toString();
            final String password = upassword.getText().toString();
            final String phone = uphone.getText().toString();
            final String gender = ugender.getText().toString();



            Response.Listener<String> responseListener = response -> {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        Intent intent = new Intent(regiater_activity.this, SigninActivity.class);
                        regiater_activity.this.startActivity(intent);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(regiater_activity.this);
                        builder.setMessage("register Failed").setNegativeButton("Retry", null).create().show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            };
            RegisterRequest registerRequest = new RegisterRequest(firstname, lastname, email, password, phone, gender, responseListener);
            RequestQueue queue = Volley.newRequestQueue(regiater_activity.this);
            queue.add(registerRequest);
        });





    }
}
