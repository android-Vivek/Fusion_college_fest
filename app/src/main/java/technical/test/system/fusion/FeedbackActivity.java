package technical.test.system.fusion;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {


    Button btn_feedback;
    EditText etMail_feedback_message;
    String emailMessege;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        etMail_feedback_message = (EditText) findViewById(R.id.etMail_feedback_message);

        btn_feedback = (Button) findViewById(R.id.btn_feedback);
        btn_feedback.setOnClickListener(this);
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
