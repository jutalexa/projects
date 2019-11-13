package techpro1.justinalexander.com.mystylist;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button appointment = findViewById(R.id.book_appt);
        final Button service = findViewById(R.id.services);



        appointment.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            MainActivity.this.startActivity(intent);
        });

        service.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ServicePrice.class);
            MainActivity.this.startActivity(intent);
        });



    }
}