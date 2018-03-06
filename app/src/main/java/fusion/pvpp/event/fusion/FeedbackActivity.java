package fusion.pvpp.event.fusion;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {


    Button btn_feedback;
    EditText etMail_feedback_message;
    String emailMessege;
    private static final String TAG = "MainActivity";

    private AdView mAdView1;
    NativeExpressAdView mAdViewNative;

    private static String LOG_TAG = "EXAMPLE";
    VideoController mVideoController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        etMail_feedback_message = (EditText) findViewById(R.id.etMail_feedback_message);

        btn_feedback = (Button) findViewById(R.id.btn_feedback);
        btn_feedback.setOnClickListener(this);

        mAdView1 = (AdView) findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView1.loadAd(adRequest);


        mAdViewNative = (NativeExpressAdView) findViewById(R.id.adViewnative);

        // Set its video options.
        mAdViewNative.setVideoOptions(new VideoOptions.Builder()
                .setStartMuted(true)
                .build());

        // The VideoController can be used to get lifecycle events and info about an ad's video
        // asset. One will always be returned by getVideoController, even if the ad has no video
        // asset.
        mVideoController = mAdViewNative.getVideoController();
        mVideoController.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
            @Override
            public void onVideoEnd() {
                Log.d(LOG_TAG, "Video playback is finished.");
                super.onVideoEnd();
            }
        });

        // Set an AdListener for the AdView, so the Activity can take action when an ad has finished
        // loading.
        mAdViewNative.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                if (mVideoController.hasVideoContent()) {
                    Log.d(LOG_TAG, "Received an ad that contains a video asset.");
                } else {
                    Log.d(LOG_TAG, "Received an ad that does not contain a video asset.");
                }
            }
        });

        mAdViewNative.loadAd(new AdRequest.Builder().build());
    }

    @Override
    public void onClick(View v)
    {
        if (v == btn_feedback)
        {
            emailMessege = etMail_feedback_message.getText().toString();

            if (emailMessege.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "Please Enter Feedback", Toast.LENGTH_SHORT).show();
            }
            else
            {
                sendFeedback();
            }
        }
    }

    private void sendFeedback()
    {
        final Intent feedbckIntent = new Intent(Intent.ACTION_SEND);
        feedbckIntent.setType("text/html");
        feedbckIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ getString(R.string.mail_feedback_email) });
        feedbckIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.mail_feedback_subject));
        feedbckIntent.putExtra(Intent.EXTRA_TEXT, emailMessege);
        startActivity(Intent.createChooser(feedbckIntent, getString(R.string.title_send_feedback)));
    }


}
