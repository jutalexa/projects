package techpro1.justinalexander.com.mystylist;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    Button buttonParse;
    Button bookit1;
    EditText user_date, user_time;
    TextView textview2;
    RequestQueue mQueue;
    String message;
    //ArrayList<String> mylist;
    //ArrayAdapter adapter;
    //ListView userlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        textview2 = findViewById(R.id.display2);
        user_date = findViewById(R.id.usertime);
        user_time = findViewById(R.id.userdate);
        buttonParse = findViewById(R.id.updateme3);
        bookit1 = findViewById(R.id.bookit);





        mQueue = Volley.newRequestQueue(this);


        buttonParse.setOnClickListener(v -> jsonParse1());


        bookit1.setOnClickListener(v -> {

            final String date = user_date.getText().toString();
            final String time = user_time.getText().toString();
            Intent intent = new Intent(Main2Activity.this, book_final_page.class);
            intent.putExtra("time",date);
            intent.putExtra("date",time);
            Main2Activity.this.startActivity(intent);
//
//                user_book_request loginRequest1 = new user_book_request(date, time, responseListener);
//                RequestQueue queue = Volley.newRequestQueue(Main2Activity.this);
//                queue.add(loginRequest1);
        });





    }

    private void jsonParse1() {


        String url = "https://cgi.sice.indiana.edu/~jutalexa/displaytime.php";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        for (int i = 1; i < response.length(); i++) {
                            JSONObject avail = response.getJSONObject(i);

                            //mylist = new ArrayList<>();

                            String date1 = (String) avail.get("date");
                            String time1 = (String) avail.get("time");
                            //String[] mystring = {"dog","cat"};
                            //ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mystring);
                            //ListView userlist = findViewById(R.id._dynamic);

                            //userlist.setAdapter(adapter);





                            message +=  date1 + "," + time1 + "\n" ;


/*                               String date1 =(String)avail.get("date");
                            String time1 =(String) avail.get("time");*/
                        }

                        textview2.setText(message);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                },
                Throwable::printStackTrace);

        mQueue.add(request);

    }
}




