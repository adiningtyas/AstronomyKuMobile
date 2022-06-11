package apps.jobcourse.astronomyku3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class NasaActivity extends AppCompatActivity {

    Button nasa_loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nasa);

        nasa_loc = findViewById(R.id.nasa_loc);

        nasa_loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotomaps = new Intent(NasaActivity.this, MapsActivity.class);
                startActivity(gotomaps);
            }
        });
    }
}