package techpro1.justinalexander.com.mystylist;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://cgi.sice.indiana.edu/~jutalexa/register.php";
    private Map<String, String> params;

    public RegisterRequest(String firstname, String lastname, String email, String password, String phone, String gender, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("firstname", firstname);
        params.put("lastname", lastname);
        params.put("email", email);
        params.put("password", password);
        params.put("phone", phone);
        params.put("gender", gender);
    }
    public Map<String, String> getParams(){

        return params;
    }
}