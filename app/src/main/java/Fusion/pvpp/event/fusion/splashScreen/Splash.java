package Fusion.pvpp.event.fusion.splashScreen;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import Fusion.pvpp.event.fusion.MainActivity;
import Fusion.pvpp.event.fusion.R;

public class Splash extends Activity implements Isplash   {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        ImageView imageView= (ImageView) findViewById(R.id.imageView);
        Animation an= AnimationUtils.loadAnimation(this,R.anim.topdown);
        imageView.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
               finishAnimation();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });


    }

    @Override
    public void finishAnimation() {
        Intent intent=new Intent(Splash.this,MainActivity.class);
        startActivity(intent);
    }
}

