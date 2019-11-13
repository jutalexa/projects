package techpro1.justinalexander.com.mystylist;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class book_activity extends StringRequest {

  private static final String REGISTER_REQUEST_URL = "http://cgi.sice.indiana.edu/~jutalexa/stylistavail.php";
  private Map<String, String> params;

  public book_activity(String date, String time, Response.Listener<String> listener) {
    super(Request.Method.POST, REGISTER_REQUEST_URL, listener, null);
    params = new HashMap<>();
    params.put("date", date);
    params.put("time", time);

  }
  public Map<String, String> getParams(){

    return params;
  }
}
