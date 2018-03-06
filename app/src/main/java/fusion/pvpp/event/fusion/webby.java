package fusion.pvpp.event.fusion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import fusion.pvpp.event.fusion.Registration.Register;

import com.google.android.gms.ads.AdView;
public class webby extends AppCompatActivity {
    private AdView mAdVieweb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webby);
//        mAdVieweb = (AdView) findViewById(R.id.adViewweb);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdVieweb.loadAd(adRequest);
    }
    public void register(View view)
    {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }
}
