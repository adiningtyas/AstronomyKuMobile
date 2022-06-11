package apps.jobcourse.astronomyku3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class DashboardActivity extends AppCompatActivity {

    LinearLayout btn_planets, btn_apod, btn_maps, btn_nasa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btn_planets = findViewById(R.id.planets);
        btn_apod = findViewById(R.id.apod);
        btn_nasa = findViewById(R.id.nasa);


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
    }

}