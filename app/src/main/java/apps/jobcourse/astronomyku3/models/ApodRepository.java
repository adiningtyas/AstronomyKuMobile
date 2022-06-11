package apps.jobcourse.astronomyku3.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import apps.jobcourse.astronomyku3.services.ApodApiClient;
import apps.jobcourse.astronomyku3.services.ApodApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApodRepository {
    private ApodApiService apodApiService;

    public MutableLiveData<ApodRandomResponse> getApodLiveData(){
        return apodLiveData;
    }

    private MutableLiveData<ApodRandomResponse> apodLiveData = new MutableLiveData<>();

    public ApodRepository(){
        apodApiService = ApodApiClient.getRetrofitInstance().create(ApodApiService.class);
    }

    public LiveData<ApodRandomResponse> getRandomApodData(){
        apodApiService.fetchRandomApod().enqueue(new Callback<ApodRandomResponse>() {
            @Override
            public void onResponse(Call<ApodRandomResponse> call, Response<ApodRandomResponse> response) {
                apodLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ApodRandomResponse> call, Throwable t) {
                apodLiveData.setValue(null);
            }
        });

        return apodLiveData;
    }
}
