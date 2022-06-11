package apps.jobcourse.astronomyku3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class ApodActivity extends AppCompatActivity {

    private ImageView mImageView;
    private Button mButton;
    private TextView mTextViewTitle;
    private TextView mTextViewExplanation;
    private TextView mTextViewDate;
    private TextView mTextViewCopyright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apod);

        mImageView = findViewById(R.id.image_view);
        mButton = findViewById(R.id.random_btn);
        mTextViewTitle = findViewById(R.id.text_view_title);
        mTextViewDate = findViewById(R.id.text_view_date);
        mTextViewCopyright = findViewById(R.id.text_view_copyright);
        mTextViewExplanation = findViewById(R.id.text_view_explanation);



        apps.jobcourse.astronomyku3.viewmodels.ApodRandomViewModel apodRandomViewModel = new apps.jobcourse.astronomyku3.viewmodels.ApodRandomViewModel(getApplication());
        observeApodVM(apodRandomViewModel);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apodRandomViewModel.fetchApodData();
            }
        });
    }

    public void observeApodVM(apps.jobcourse.astronomyku3.viewmodels.ApodRandomViewModel vm){
        vm.getApodRandomLiveData().observe(this, apodRandomResponse -> {
            Picasso.get().load(apodRandomResponse.getUrl()).into(mImageView);
            mTextViewTitle.setText(apodRandomResponse.getTitle());
            mTextViewExplanation.setText(apodRandomResponse.getExplanation());
            mTextViewDate.setText(apodRandomResponse.getDate());
            mTextViewCopyright.setText(apodRandomResponse.getCopyright());

        });
    }
}