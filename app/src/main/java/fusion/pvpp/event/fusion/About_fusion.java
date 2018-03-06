package fusion.pvpp.event.fusion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.ads.AdView;
public class About_fusion extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_fusion);
    }
}
