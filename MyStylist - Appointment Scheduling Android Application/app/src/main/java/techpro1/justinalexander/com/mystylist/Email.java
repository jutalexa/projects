package techpro1.justinalexander.com.mystylist;



import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;


public class Email extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_booked_appt);
        Button email = findViewById(R.id.confirm6);
        email.setOnClickListener(v -> {
            Intent intent = new Intent (Email.this, MainActivity.class);
            Email.this.startActivity(intent);
        });

    Intent emailIntent = new Intent(Intent.ACTION_SEND);
    emailIntent.setType("plain/text");
    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]
    {"Your email"});
    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email Subject");
    emailIntent.putExtra(Intent.EXTRA_TEXT, "Email Body");
    try{
    startActivity(Intent.createChooser(emailIntent,"Send mail..."));
    finish();
    Log.i("Finished sending email.","");}
    catch (android.content.ActivityNotFoundException ex){
    Toast.makeText(Email.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();}
    }

}

