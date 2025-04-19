package in.aravinthk.weatherpixapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.List;

import in.aravinthk.weatherpixapp.model.WeatherResponse;
import in.aravinthk.weatherpixapp.repository.WeatherRepository;

public class WeatherViewModel extends ViewModel {
    private final WeatherRepository repo;
    public final MutableLiveData<String> selectedCity = new MutableLiveData<>();
    public final LiveData<List<WeatherResponse.ForecastDay>> weatherList;

    public WeatherViewModel() {
        repo = new WeatherRepository();
        weatherList = Transformations.switchMap(selectedCity, repo::getWeather);
    }

    public void setCity(String city) {
        selectedCity.setValue(city);
    }
}

