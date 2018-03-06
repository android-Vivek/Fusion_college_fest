package fusion.pvpp.event.fusion.Registration;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;
import fusion.pvpp.event.fusion.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class Register extends AppCompatActivity {

    EditText etname, etemail, etmobile, etevent;
    String name, email, mobile, event;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Enquire Form");
         etname = (EditText)findViewById(R.id.etname);
        etemail = (EditText)findViewById(R.id.etemail);
        etmobile = (EditText)findViewById(R.id.editText3);
        etevent = (EditText)findViewById(R.id.editText4);
        if (InternetConnection.checkConnection(getApplicationContext())) {
            // Its Available...
        } else {
            Toast.makeText(this, "Please Check Internet Connection", Toast.LENGTH_SHORT).show();
        }

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }




    public void submit(View view)
    {
        String MobilePattern = "[0-9]{10}";
        if (InternetConnection.checkConnection(getApplicationContext())) {
            name = etname.getText().toString();
            email = etemail.getText().toString();
            mobile = etmobile.getText().toString();
            event = etevent.getText().toString();

            if (name.length()==0) {
                Toast.makeText(this, "Please Enter name", Toast.LENGTH_SHORT).show();
            }
            else {
                if (!email.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
                    Toast.makeText(this, "Invalid Email Id", Toast.LENGTH_SHORT).show();
                } else {
                    if (!mobile.matches(MobilePattern)) {
                        Toast.makeText(this, "Please Enter Valid Mobile number", Toast.LENGTH_SHORT).show();
                    } else {
                    if (etevent.length()==0) {
                        Toast.makeText(this, "Please Enter Event name", Toast.LENGTH_SHORT).show();
                    } else {
                            Toast.makeText(this, "We will Contact you Soon", Toast.LENGTH_SHORT).show();
                            Log.d("checkpoint", name + ": name  & email:" + email + mobile + "\n" + event);
                            volleyRequest();
                        }
                    }
                }
            }
    }
    else {
        Toast.makeText(this, "Please Check Internet Connection", Toast.LENGTH_SHORT).show();
    }
    }

    public void volleyRequest()
    {
        RequestQueue MyRequestQueue = Volley.newRequestQueue(this);
        String url = "http://watsup.online/demo/Insert.php";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response.toString());
                        finish();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Toast.makeText(Register.this, "Server Error", Toast.LENGTH_SHORT).show();
                        Log.d("Error.Response",""+ error);
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("name", name);
                params.put("email", email);
                params.put("number", mobile);
                params.put("event", event);
                return params;
            }
        };
        MyRequestQueue.add(postRequest);
    }

    public static class InternetConnection {

        /** CHECK WHETHER INTERNET CONNECTION IS AVAILABLE OR NOT */
        public static boolean checkConnection(Context context) {
            final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetworkInfo = connMgr.getActiveNetworkInfo();

            if (activeNetworkInfo != null) { // connected to the internet
              //  Toast.makeText(context, activeNetworkInfo.getTypeName(), Toast.LENGTH_SHORT).show();

                if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                    // connected to wifi
                    return true;
                } else if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                    // connected to the mobile provider's data plan
                    return true;
                }
            }
            return false;
        }
    }

}
