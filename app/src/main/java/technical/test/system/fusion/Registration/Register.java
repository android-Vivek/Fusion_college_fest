package technical.test.system.fusion.Registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import technical.test.system.fusion.R;

public class Register extends AppCompatActivity {

    EditText etname,etemail,etmobile,etevent;
  String name,email,mobile,event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
         etname = (EditText)findViewById(R.id.etname);
        etemail = (EditText)findViewById(R.id.etemail);
        etmobile = (EditText)findViewById(R.id.editText3);
        etevent = (EditText)findViewById(R.id.editText4);
    }
    public void submit(View view)
    {
        name = etname.getText().toString();
       email = etemail.getText().toString();
        mobile = etmobile.getText().toString();
         event = etevent.getText().toString();
        Toast.makeText(this, "We will Contact you Soon", Toast.LENGTH_SHORT).show();
        Log.d("checkpoint",name+": name  & email:"+email+mobile+"\n"+event);
    }
}
