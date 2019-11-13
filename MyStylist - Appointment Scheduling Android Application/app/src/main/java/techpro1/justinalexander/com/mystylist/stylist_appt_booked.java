package techpro1.justinalexander.com.mystylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class stylist_appt_booked extends AppCompatActivity {
    TextView displaytime3, displaydate3;
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_final_page);
        home = findViewById(R.id.confirmme2);
        home.setOnClickListener(v -> {
            Intent intent = new Intent(stylist_appt_booked.this, stylisthome.class);
            stylist_appt_booked.this.startActivity(intent);
        });
        Intent intent = getIntent();
        String final_date2 = intent.getStringExtra("date");
        String final_time2 = intent.getStringExtra("time");

        displaytime3 = findViewById(R.id.display_time8);
        displaydate3 = findViewById(R.id.display_date8);

        displaydate3.setText(final_date2);
        displaytime3.setText(final_time2);

    }
}
