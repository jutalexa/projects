package techpro1.justinalexander.com.mystylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class user_booked_appt extends AppCompatActivity {
    Button home, email;
    TextView displaytime3, displaydate3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_booked_appt);

        home = findViewById(R.id.confirm);
        home.setOnClickListener(v -> {
            Intent intent = new Intent(user_booked_appt.this, MainActivity.class);
            user_booked_appt.this.startActivity(intent);
        });
        Intent intent = getIntent();
        String final_date2 = intent.getStringExtra("date");
        String final_time2 = intent.getStringExtra("time");

        displaytime3 = findViewById(R.id.display_time8);
        displaydate3 = findViewById(R.id.display_date8);

        displaydate3.setText(final_date2);
        displaytime3.setText(final_time2);
    }}

       /* email = (Button)findViewById(R.id.button);

        email.setOnClickListener(v -> {
            Intent intent1 = new Intent(user_booked_appt.this, MainActivity.class);
            sendEmail();

        email.setOnClickListener(v1 -> {
            Intent intent2 = new Intent(user_booked_appt.this, MainActivity.class);
            user_booked_appt.this.startActivity(intent2);
            sendEmail();
        });

    protected void sendEmail() {
        Log.i("Send email", "Congrats! Your appointment has been scheduled.");

        String[] FROM = {"someone@gmail.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, FROM);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email.", "");
        }

        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(user_booked_appt.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();

        } }
        });
    }}
*/
