package in.aravinthk.weatherpixapp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import in.aravinthk.weatherpixapp.R;
import in.aravinthk.weatherpixapp.databinding.ActivityMainBinding;
import in.aravinthk.weatherpixapp.model.WeatherResponse;
import in.aravinthk.weatherpixapp.view.adapter.ForecastAdapter;
import in.aravinthk.weatherpixapp.viewmodel.WeatherViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private WeatherViewModel viewModel;
    private ForecastAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        ArrayAdapter<CharSequence> cityAdapter = ArrayAdapter.createFromResource(this,
                R.array.city_array, android.R.layout.simple_spinner_item);
        binding.spinner.setAdapter(cityAdapter);

        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String city = parent.getItemAtPosition(pos).toString();
                viewModel.setCity(city);
            }

            public void onNothingSelected(AdapterView<?> parent) {}
        });


        adapter = new ForecastAdapter();
        binding.recyclerForecast.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerForecast.setAdapter(adapter);

        viewModel.weatherList.observe(this, forecast -> {
            if (forecast != null) {
                adapter.setForecastList(forecast);
            } else {
                Toast.makeText(this, "Failed to load forecast", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
