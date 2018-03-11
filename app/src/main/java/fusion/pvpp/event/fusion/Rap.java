package fusion.pvpp.event.fusion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import fusion.pvpp.event.fusion.Registration.Register;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Rap extends AppCompatActivity {
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_rap);
        mAdView = (AdView) findViewById(R.id.adViewRap);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
    public void register(View view)
    {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }
}
