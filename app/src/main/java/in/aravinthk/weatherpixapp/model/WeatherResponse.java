package in.aravinthk.weatherpixapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {
    public Forecast forecast;

    public static class Forecast {
        public List<ForecastDay> forecastday;
    }

    public static class ForecastDay {
        public String date;
        public Day day;
    }

    public static class Day {
        public double avgtemp_c;
        public double maxtemp_c;
        public double mintemp_c;
        public String condition_text;

        @SerializedName("condition")
        public Condition condition;
    }

    public static class Condition {
        public String text;
    }
}

