package apps.jobcourse.astronomyku3.services;

import apps.jobcourse.astronomyku3.models.ApodRandomResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApodApiService {
    @GET("planetary/apod?api_key=Fl1zcM4nhK3pZ2b1zxOI5OBiDE2YEI1IZGl7KWio")
    Call<ApodRandomResponse> fetchRandomApod();
}
