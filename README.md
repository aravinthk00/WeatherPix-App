Here’s a simple, clean `README.md` for your **WeatherPix** app, including section placeholders for screenshots.

---

## 🌤️ WeatherPix - Android Weather Forecast App

**WeatherPix** is a simple Android app built with **MVVM**, **DataBinding**, and **WeatherAPI** to display a 5-day weather forecast for selected Indian cities using beautiful background gradients based on weather conditions.

---

### 🖼️ Screenshots
![WeatherPix APP](https://github.com/user-attachments/assets/7eb2c5fb-f4aa-486a-9b96-a342eba8e9c0)
---

### 🔧 Features

* 🌆 Select Indian cities: Chennai, Mumbai, Bengaluru, Delhi, Kolkata, Kochi, Mysore
* 🌦️ Fetch 5-day forecast from [WeatherAPI](https://www.weatherapi.com/)
* 🎨 Weather-specific background gradients (Sunny, Cloudy, Clear)
* ♻️ Clean MVVM Architecture with DataBinding
* 📶 Uses Retrofit for networking

---

### 📲 Demo

```
1. Select a city from dropdown
2. Weather for the next 5 days is fetched
3. Each day shows condition, date, and temperature (avg/min/max)
```

---

### 🏗️ Tech Stack

* MVVM (Model-View-ViewModel)
* Retrofit + GSON
* DataBinding
* Java
* RecyclerView
* WeatherAPI

---

### 📁 Project Structure

```
WeatherPix/
├── adapter/
│   └── ForecastAdapter.java
├── model/
│   └── WeatherResponse.java
├── network/
│   ├── ApiClient.java
│   └── ApiService.java
├── viewmodel/
│   └── WeatherViewModel.java
├── view/
│   └── MainActivity.java
└── res/
    ├── layout/
    ├── drawable/
    └── values/
```

---

### 🔑 API Key

Replace the `API_KEY` in `ApiService.java` or `WeatherViewModel.java` with your own key from:

👉 [https://www.weatherapi.com/](https://www.weatherapi.com/)

---

### 🚀 Getting Started

1. Clone the repo
2. Add your API key
3. Build and run on Android Studio

---

Let me know if you want a markdown file version or if you'd like me to generate actual screenshots for placeholders.
