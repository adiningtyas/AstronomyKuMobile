package apps.jobcourse.astronomyku3.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import apps.jobcourse.astronomyku3.models.ApodRandomResponse;
import apps.jobcourse.astronomyku3.models.ApodRepository;

public class ApodRandomViewModel extends AndroidViewModel {
    private ApodRepository apodRepository = new ApodRepository();
    public LiveData<ApodRandomResponse> getApodRandomLiveData(){
        return apodRandomLiveData;
    }
    public LiveData<ApodRandomResponse> apodRandomLiveData;
    public ApodRandomViewModel(@NonNull Application application) {
        super(application);

        apodRandomLiveData = apodRepository.getApodLiveData();
    }

    public void fetchApodData() {
        apodRandomLiveData = apodRepository.getRandomApodData();
    }
}
