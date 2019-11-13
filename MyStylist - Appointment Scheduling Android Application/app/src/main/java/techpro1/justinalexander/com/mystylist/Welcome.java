package techpro1.justinalexander.com.mystylist;





import android.content.Intent;

import android.os.Bundle;

import android.os.Handler;

import android.support.v7.app.AppCompatActivity;



public class Welcome extends AppCompatActivity {



  @Override

  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_welcom);



    new Handler().postDelayed(new Runnable() {

      @Override

      public void run() {

        startActivity(new Intent(getApplicationContext(), SigninActivity.class));

        finish();

      }

    }, 3 * 1000);



  }



}
