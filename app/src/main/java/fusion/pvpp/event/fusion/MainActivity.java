package fusion.pvpp.event.fusion;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import fusion.pvpp.event.fusion.Registration.Register;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    private FirebaseAnalytics mFirebaseAnalytics;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mAdView = (AdView) findViewById(R.id.adView_main);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if(id == R.id.event)
        {
            Intent intent = new Intent(this,tabtest.class);
            startActivity(intent);
            finish();
        }
        if(id == R.id.schedule)
        {
            Intent intent = new Intent(this,schedule.class);
            startActivity(intent);
        }
        if(id == R.id.reg)
        {
            Intent intent = new Intent(this,Register.class);
            startActivity(intent);
        }
        if (id == R.id.member) {
            Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.develop) {
        Intent intent = new Intent(this, Developed.class);
            startActivity(intent);
        } else if (id == R.id.about_us) {
           Intent intent = new Intent(this,about_us.class);
            startActivity(intent);
        }
        else if (id == R.id.shareOption) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=fusion.pvpp.event.fusion");

            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        }
        else if (id == R.id.nav_update) {
            Uri uri = Uri.parse("market://details?id=fusion.pvpp.event.fusion");
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);

            // After pressing back button from google play will continue to app
            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET |
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);

            startActivity(goToMarket);
        }
        else if (id == R.id.feedbackOption) {
            Intent intent = new Intent(this, FeedbackActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void doSomething(View v){

        if(v.getId()==R.id.image1){
            Intent i = new Intent(this,About_fusion.class);
            startActivity(i);
        }
        if(v.getId()==R.id.image2){
            Intent i2 = new Intent(this,about_us.class);
            startActivity(i2);
        }
        if(v.getId()==R.id.image3){
            Intent i2 = new Intent(this,tabtest.class);
            startActivity(i2);
        }
//        if(v.getId()==R.id.image5){
//            Intent i2 = new Intent(this,Visitweb.class);
//            startActivity(i2);
//        }
//
//        if(v.getId()==R.id.image6){
//            Intent i2 = new Intent(this,Web.class);
//            startActivity(i2);
//        }
//        if(v.getId()==R.id.cont){
//            Intent i2 = new Intent(this,Contactus.class);
//            startActivity(i2);
//        }
//        if(v.getId()==R.id.dev){
//            Intent i2 = new Intent(this,Developed.class);
//            startActivity(i2);
//        }
        if(v.getId()==R.id.scduele){
            Intent i2 = new Intent(this,schedule.class);
            startActivity(i2);
        }

    }

}

