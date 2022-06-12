package apps.jobcourse.astronomyku3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class DashboardActivity extends AppCompatActivity {

    LinearLayout btn_planets, btn_apod, btn_about, btn_nasa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btn_planets = findViewById(R.id.planets);
        btn_apod = findViewById(R.id.apod);
        btn_nasa = findViewById(R.id.nasa);
        btn_about = findViewById(R.id.about);


        btn_apod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoapod = new Intent(DashboardActivity.this, ApodActivity.class);
                startActivity(gotoapod);
            }
        });

        btn_nasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotonasa = new Intent(DashboardActivity.this, NasaActivity.class);
                startActivity(gotonasa);
            }
        });

        btn_planets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoplanet = new Intent(DashboardActivity.this, PlanetActivity.class);
                startActivity(gotoplanet);
            }
        });

        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoabout = new Intent(DashboardActivity.this, AboutActivity.class);
                startActivity(gotoabout);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_notif) {
            Intent intent = new Intent(this, NotificationActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.action_language) {
            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}