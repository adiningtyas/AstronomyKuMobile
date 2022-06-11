package apps.jobcourse.astronomyku3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    Animation app_splash, bottom_totop;
    ImageView app_logo;
    TextView app_title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        //load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        bottom_totop =AnimationUtils.loadAnimation(this,R.anim.app_splash);
        app_logo = findViewById(R.id.app_logo);
        app_title =findViewById(R.id.app_title);

        app_logo.startAnimation(app_splash);
        app_title.startAnimation(bottom_totop);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //merubah activity
                Intent gotomain = new Intent(SplashActivity.this, DashboardActivity.class);
                startActivity(gotomain);
                finish();
            }
        },2000);

    }
}
