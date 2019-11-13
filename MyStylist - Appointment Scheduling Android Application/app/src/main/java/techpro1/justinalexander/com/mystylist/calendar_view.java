package techpro1.justinalexander.com.mystylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class calendar_view extends AppCompatActivity {

    TextView date;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.calendar_main);

            final CalendarView calendarView;

            calendarView = findViewById(R.id.calenderView);
            date = findViewById(R.id.date);


            calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
                String mydate = (month+1) + "/" + dayOfMonth + "/" + year;
                date.setText(mydate);
                Intent intent = new Intent(calendar_view.this, user_time_picker.class);
                final String final_date = date.getText().toString();
                intent.putExtra("date", final_date);
                calendar_view.this.startActivity(intent);
            });



        }
    }


