package techpro1.justinalexander.com.mystylist;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class user_time_picker extends AppCompatActivity {

    TextView selectedTime, display_me;
    TimePickerDialog timePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    String amPm, final_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_time_picker);

        Button bookit = findViewById(R.id.update_button_time);
        display_me = findViewById(R.id.displayme);


        Intent intent1 = getIntent();
        String final_date = intent1.getStringExtra("date");

        display_me.setText(final_date);


        selectedTime = findViewById(R.id.choose_me_time);


        selectedTime.setOnClickListener(v -> {

            calendar = Calendar.getInstance();
            currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            currentMinute = calendar.get(Calendar.MINUTE);

            timePickerDialog = new TimePickerDialog(user_time_picker.this, (view, hourOfDay, minute) -> {
                if (hourOfDay >= 12) {
                    amPm = "PM";
                } else {
                    amPm = "AM";
                }
                //selectedTime.setText(String.format("%02d:%02d", hourOfDay, minute) + amPm);
                selectedTime.setText(hourOfDay + ":" + minute + amPm);
                final_time = selectedTime.getText().toString();

            }, 0,0,false);
            timePickerDialog.show();

        });




        bookit.setOnClickListener(v -> {
            Intent intent = new Intent(user_time_picker.this, stylist_schedule_pick.class);
            intent.putExtra("date", final_date);
            intent.putExtra("time",final_time);
            user_time_picker.this.startActivity(intent);


        });


    }
}


