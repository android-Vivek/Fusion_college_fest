package fusion.pvpp.event.fusion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

public class schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        TabHost tabHost;

            TabHost host = (TabHost)findViewById(R.id.tabHost);
            host.setup();

            //Tab 1
            TabHost.TabSpec spec = host.newTabSpec("Tab One");
            spec.setContent(R.id.linearLayout);
            spec.setIndicator("DAY\n\t1");
            host.addTab(spec);

            //Tab 2
            spec = host.newTabSpec("Tab Two");
            spec.setContent(R.id.linearLayout2);
            spec.setIndicator("DAY\n\t2");
            host.addTab(spec);

            //Tab 3
            spec = host.newTabSpec("Tab Three");
            spec.setContent(R.id.linearLayout3);
            spec.setIndicator("DAY\n\t3");
            host.addTab(spec);
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.linearLayout4);
        spec.setIndicator("DAY\n\t4");

        host.addTab(spec);
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.linearLayout5);
        spec.setIndicator("DAY\n\t5");
        host.addTab(spec);

        }


}
