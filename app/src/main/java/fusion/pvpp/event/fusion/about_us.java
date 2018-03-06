package fusion.pvpp.event.fusion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class about_us extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        mAdView = (AdView) findViewById(R.id.adView_about_us);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
