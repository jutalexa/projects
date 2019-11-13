package techpro1.justinalexander.com.mystylist;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class user_book_request extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://cgi.sice.indiana.edu/~jutalexa/stylistappt.php";
    private Map<String, String> params;

    public user_book_request(String date, String time, Response.Listener<String> listener) {
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("date", date);
        params.put("time", time);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
