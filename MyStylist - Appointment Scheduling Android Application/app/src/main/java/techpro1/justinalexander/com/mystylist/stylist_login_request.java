package techpro1.justinalexander.com.mystylist;import com.android.volley.Request;import com.android.volley.Response;import com.android.volley.toolbox.StringRequest;import java.util.HashMap;import java.util.Map;public class stylist_login_request extends StringRequest {    private static final String LOGIN_REQUEST_URL = "http://cgi.soic.indiana.edu/~jutalexa/login2.php";    private Map<String, String> params;    public stylist_login_request(String email, String password, Response.Listener<String> listener) {        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);        params = new HashMap<>();        params.put("email", email);        params.put("password", password);    }    @Override    public Map<String, String> getParams() {        return params;    }}