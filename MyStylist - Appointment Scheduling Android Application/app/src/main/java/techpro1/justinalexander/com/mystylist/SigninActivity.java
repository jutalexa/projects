package techpro1.justinalexander.com.mystylist;



import android.content.Intent;

import android.support.v7.app.AlertDialog;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;


import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;



import com.android.volley.RequestQueue;

import com.android.volley.Response;

import com.android.volley.toolbox.Volley;



import org.json.JSONException;

import org.json.JSONObject;



public class SigninActivity extends AppCompatActivity {



  @Override

  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_login);



    final EditText etUsername = findViewById(R.id.EmailLogin);

    final EditText etPassword = findViewById(R.id.userlname);

    final Button bLogin = findViewById(R.id.login);

    final TextView registerLink =  findViewById(R.id.userregister);

    final TextView stylistlink =  findViewById(R.id.stylistlogin);





    registerLink.setOnClickListener(v -> {

      Intent registerIntent = new Intent(SigninActivity.this, regiater_activity.class);

      SigninActivity.this.startActivity(registerIntent);

    });



    stylistlink.setOnClickListener(v -> {

      Intent registerIntent = new Intent(SigninActivity.this, stylistlogin.class);

      SigninActivity.this.startActivity(registerIntent);

    });





    bLogin.setOnClickListener(v -> {

      final String email = etUsername.getText().toString();

      final String password = etPassword.getText().toString();



      Response.Listener<String> responseListener =   response -> {

        try {

          JSONObject jsonResponse = new JSONObject(response);

          boolean success = jsonResponse.getBoolean("success");



          if (success) {

            Intent intent = new Intent(SigninActivity.this, MainActivity.class);

            SigninActivity.this.startActivity(intent);

          } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(SigninActivity.this);

            builder.setMessage("Login Failed")

                    .setNegativeButton("Retry", null)

                    .create()

                    .show();

          }



        } catch (JSONException e) {

          e.printStackTrace();

        }

      };



      LoginRequest loginRequest = new LoginRequest(email, password, responseListener);

      RequestQueue queue = Volley.newRequestQueue(SigninActivity.this);

      queue.add(loginRequest);

    });



//      startActivity(new Intent(this,MainActivity.class));

  }

}



