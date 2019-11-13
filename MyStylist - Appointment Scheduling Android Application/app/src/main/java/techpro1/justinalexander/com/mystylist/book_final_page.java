package techpro1.justinalexander.com.mystylist;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class book_final_page extends AppCompatActivity {
    TextView display_time, display_date;
    Button confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_final_page);

        display_time = findViewById(R.id.display_time8);
        display_date = findViewById(R.id.display_date8);
        confirm = findViewById(R.id.confirm6);




        Intent intent = getIntent();
        String final_date = intent.getStringExtra("date");
        String final_time = intent.getStringExtra("time");




        display_date.setText(final_date);
        display_time.setText(final_time);



        confirm.setOnClickListener(v -> {
            final String date = display_date.getText().toString();
            final String time = display_time.getText().toString();

            Response.Listener<String> responseListener = response -> {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        Intent intent1 = new Intent(book_final_page.this, user_booked_appt.class);
                        String final_time2 = display_date.getText().toString();
                        String final_date2 = display_time.getText().toString();

                        intent1.putExtra("time",final_time2);
                        intent1.putExtra("date",final_date2);

                        book_final_page.this.startActivity(intent1);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(book_final_page.this);
                        builder.setMessage("Booking Failed").setNegativeButton("Retry", null).create().show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            };
            user_book_request registerRequest1 = new user_book_request(date,time,responseListener);
            RequestQueue queue = Volley.newRequestQueue(book_final_page.this);
            queue.add(registerRequest1);





        });


    }
}


