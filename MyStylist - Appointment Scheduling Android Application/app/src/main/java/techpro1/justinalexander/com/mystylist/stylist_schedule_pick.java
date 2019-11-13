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

public class stylist_schedule_pick extends AppCompatActivity {
    Button confirm;
    String date3, time3;
    TextView displaydate4, displaytime4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stylist_schedule_pick);

        Intent intent = getIntent();
        String final_date2 = intent.getStringExtra("date");
        String final_time2 = intent.getStringExtra("time");

        displaytime4 = findViewById(R.id.display_time9);
        displaydate4 = findViewById(R.id.display_date9);

        displaydate4.setText(final_date2);
        displaytime4.setText(final_time2);

        confirm = findViewById(R.id.confirmme3);
        confirm.setOnClickListener(v -> {
            final String date = displaydate4.getText().toString();
            final String time = displaytime4.getText().toString();

            Response.Listener<String> responseListener = response -> {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        Intent intent1 = new Intent(stylist_schedule_pick.this, stylist_appt_booked.class);
                        date3 = displaydate4.getText().toString();
                        time3 = displaytime4.getText().toString();
                        intent1.putExtra("date", date3);
                        intent1.putExtra("time", time3);
                        stylist_schedule_pick.this.startActivity(intent1);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(stylist_schedule_pick.this);
                        builder.setMessage("Update Failed").setNegativeButton("Retry", null).create().show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            };
            book_activity registerRequest2 = new book_activity(date,time,responseListener);
            RequestQueue queue = Volley.newRequestQueue(stylist_schedule_pick.this);
            queue.add(registerRequest2);



        });
    }
}
