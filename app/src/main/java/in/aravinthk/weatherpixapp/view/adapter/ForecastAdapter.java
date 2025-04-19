package in.aravinthk.weatherpixapp.view.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

import in.aravinthk.weatherpixapp.R;
import in.aravinthk.weatherpixapp.model.WeatherResponse;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {
    private List<WeatherResponse.ForecastDay> forecastList = new ArrayList<>();

    public void setForecastList(List<WeatherResponse.ForecastDay> list) {
        forecastList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_forecast, parent, false);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
        WeatherResponse.ForecastDay forecastDay = forecastList.get(position);
        holder.textDate.setText(forecastDay.date);
        holder.textCondition.setText(String.format("Condition: %s", forecastDay.day.condition.text));
        holder.textTemp.setText(String.format("Avg: %s°C  |  Max: %s°C  |  Min: %s°C", forecastDay.day.avgtemp_c, forecastDay.day.maxtemp_c, forecastDay.day.mintemp_c));

        String condition = forecastDay.day.condition.text.toLowerCase();
        if (condition.contains("sunny")) {
            holder.forecastCard.setBackgroundResource(R.drawable.bg_sunny);
            holder.forecastConditionImg.setImageResource(R.drawable.clear);
        } else if (condition.contains("cloudy") || condition.contains("rain")) {
            holder.forecastCard.setBackgroundResource(R.drawable.bg_cloudy);
            holder.forecastConditionImg.setImageResource(R.drawable.cloudy);

        } else if (condition.contains("clear")) {
            holder.forecastCard.setBackgroundResource(R.drawable.bg_clear);
            holder.forecastConditionImg.setImageResource(R.drawable.clear);

        } else {
            // fallback/default
            holder.itemView.setBackgroundColor(Color.LTGRAY);
        }
    }

    @Override
    public int getItemCount() {
        return forecastList.size();
    }

    static class ForecastViewHolder extends RecyclerView.ViewHolder {
        TextView textDate, textCondition, textTemp;
        ConstraintLayout forecastCard;
        ShapeableImageView forecastConditionImg;

        public ForecastViewHolder(@NonNull View itemView) {
            super(itemView);
            textDate = itemView.findViewById(R.id.textDate);
            textCondition = itemView.findViewById(R.id.textCondition);
            textTemp = itemView.findViewById(R.id.textTemp);
            forecastCard = itemView.findViewById(R.id.forecastCardView);
            forecastConditionImg = itemView.findViewById(R.id.forecastConditionImgView);
        }
    }
}
