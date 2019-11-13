package techpro1.justinalexander.com.mystylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class stylist_viewavail extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;
    private String message;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stylist_viewavail);

        mTextViewResult = findViewById(R.id.display);
        Button buttonParse = findViewById(R.id.updateme2);


        mQueue = Volley.newRequestQueue(this);

        buttonParse.setOnClickListener(v -> jsonParse());

    }



    private void jsonParse() {



        String url = "https://cgi.sice.indiana.edu/~jutalexa/stylistviewappts.php";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        for (int i = 1; i < response.length(); i++) {
                            JSONObject avail = response.getJSONObject(i);

                            String date1 = (String) avail.get("date");
                            String time1 = (String) avail.get("time");


                            message += date1 + "," + time1 + "\n" ;

/*                               String date1 =(String)avail.get("date");
                            String time1 =(String) avail.get("time");*/
                        }

                            mTextViewResult.setText(message);






                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    },
                error -> error.printStackTrace());

                            mQueue.add(request);

    }}


//                            for (int i = 0 ; i < jsonobject.length(); i++) {
//                                JSONObject avail = (JSONObject) jsonobject.getJSONObject(String.valueOf(i));
//
//                                String date1 = avail.getString("date");
//                                String time1 = avail.getString("time");
//                                //mTextViewResult.setText(date1 + ", " + time1 + "\n\n");
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//






