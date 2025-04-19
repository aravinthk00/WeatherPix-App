package in.aravinthk.weatherpixapp.network;

import in.aravinthk.weatherpixapp.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("forecast.json")
    Call<WeatherResponse> getForecast(
            @Query("key") String apiKey,
            @Query("q") String city,
            @Query("days") int days
    );
}

