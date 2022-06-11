package apps.jobcourse.astronomyku3.API;

import apps.jobcourse.astronomyku3.Model.ResponseModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRequestData {
    @GET("planet_api.php")
    Call<ResponseModel> getJSON();
}
