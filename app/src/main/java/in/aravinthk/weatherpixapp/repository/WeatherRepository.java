package in.aravinthk.weatherpixapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import in.aravinthk.weatherpixapp.model.WeatherResponse;
import in.aravinthk.weatherpixapp.network.ApiClient;
import in.aravinthk.weatherpixapp.network.WeatherApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {
    private final WeatherApi api;

    public WeatherRepository() {
        api = ApiClient.getClient();
    }

    public LiveData<List<WeatherResponse.ForecastDay>> getWeather(String city) {
        MutableLiveData<List<WeatherResponse.ForecastDay>> data = new MutableLiveData<>();

        api.getForecast("76e388f78b504af39fa62232251904", city, 5).enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {

                System.out.println("onResponse : "+ response.body() + call.request().url() );
                if (response.isSuccessful()) {
                    assert response.body() != null;

                    System.out.println("Response  : " + response.body());
                    data.setValue(response.body().forecast.forecastday);
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {

                System.out.println("onFailure : "+call.request().url() );
                System.out.println("onFailure : "+ t.getMessage() );

                data.setValue(null);
            }
        });

        return data;
    }
}

