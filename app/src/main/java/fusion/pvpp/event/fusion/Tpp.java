package fusion.pvpp.event.fusion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import fusion.pvpp.event.fusion.Registration.Register;

import com.google.android.gms.ads.AdView;
/**
 * Created by root on 14/2/16.
 */
public class Tpp extends AppCompatActivity {
    private AdView mAdViewtpp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tpp);

//        mAdViewtpp = (AdView) findViewById(R.id.adViewtpp);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdViewtpp.loadAd(adRequest);
    }
    public void register(View view)
    {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }
}
