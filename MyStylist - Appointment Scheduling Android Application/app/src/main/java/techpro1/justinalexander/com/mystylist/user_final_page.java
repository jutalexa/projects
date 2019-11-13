package techpro1.justinalexander.com.mystylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class user_final_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_final_page);


        Intent intent = getIntent();
        final String final_date = intent.getStringExtra("date");
        final String final_time = intent.getStringExtra("time");

    }
}
