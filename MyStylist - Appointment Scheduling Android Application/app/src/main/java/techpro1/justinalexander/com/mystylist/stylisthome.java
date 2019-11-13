package techpro1.justinalexander.com.mystylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class stylisthome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stylist_home);

        final Button appointments = findViewById(R.id.appointment);
        final Button availiablitys =  findViewById(R.id.myavailiablity);
        final Button services = findViewById(R.id.services);

        availiablitys.setOnClickListener(v -> {
            Intent intent = new Intent(stylisthome.this,  calendar_view.class);
            stylisthome.this.startActivity(intent);
        });

        services.setOnClickListener(v -> {
            Intent intent = new Intent(stylisthome.this, ServicePrice.class);
            stylisthome.this.startActivity(intent);
        });
        appointments.setOnClickListener(v -> {
            Intent intent = new Intent(stylisthome.this, stylist_viewavail.class);
            stylisthome.this.startActivity(intent);
        });
    }
}