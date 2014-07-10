package tv.inair.weather.modelview;

import android.graphics.drawable.Drawable;
import android.util.Log;

import com.survivingwithandroid.weather.lib.WeatherClient;
import com.survivingwithandroid.weather.lib.WeatherClientDefault;
import com.survivingwithandroid.weather.lib.WeatherConfig;
import com.survivingwithandroid.weather.lib.exception.WeatherLibException;
import com.survivingwithandroid.weather.lib.model.CurrentWeather;
import com.survivingwithandroid.weather.lib.model.DayForecast;
import com.survivingwithandroid.weather.lib.model.WeatherForecast;
import com.survivingwithandroid.weather.lib.provider.IWeatherProvider;
import com.survivingwithandroid.weather.lib.provider.WeatherProviderFactory;
import com.survivingwithandroid.weather.lib.provider.openweathermap.OpenweathermapProviderType;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import inair.collection.ObservableCollection;
import inair.data.LayeredItemViewData;
import inair.data.ViewModel;
import tv.inair.weather.Application;
import tv.inair.weather.R;
import tv.inair.weather.util.IconMapper;
import tv.inair.weather.util.WeatherUtil;

/**
 * Created by Synyster on 5/27/14.
 */
public class WeatherViewModel extends ViewModel implements LayeredItemViewData {

  public ObservableCollection<ForecastItemViewModel> obsForecastItems = new ObservableCollection<ForecastItemViewModel>();
  private CharSequence title = "";
  private WeatherClient client;
  private WeatherConfig config;
  private String cityId = "";
  private float currentImageWidth = 10.0f;
  private float currentImageHeight = 10.0f;
  private String cityName = "";
  private String condition = "";
  private String temp = "";
  private float tempSize = 100.0f;
  private float tempY = -15.0f;
  private String tempUnit  = "°C";
  private float tempUnitX = 0.0f;
  private String tempMax = "";
  private String tempMin = "";
  private float tempMaxX = 0.0f;
  private String windSpeed = "";
  private String windDeg = "";
  private String humidity = "";
  private String unitTemp = "";
  private String sunset = "";
  private String sunrise = "";
  private String cloud = "";
  private String rain = "";
  private int currentImageSrc = R.drawable.sun;

  // Constructor
  public WeatherViewModel(String cityId) {
    this.cityId = cityId;

    // Config weather client & weather config
    client = WeatherClientDefault.getInstance();
    client.init(Application.getAppContext());

    config = new WeatherConfig();
    config.unitSystem = WeatherConfig.UNIT_SYSTEM.M;
    config.lang = "en";
    config.maxResult = 5;
    config.numDays = 6;

    for (int i = 0; i < config.numDays; i++) {
      obsForecastItems.add(new ForecastItemViewModel());
    }

    try {
      IWeatherProvider provider = WeatherProviderFactory.createProvider(new OpenweathermapProviderType(), config);
      client.setProvider(provider);
    } catch (Throwable t) {
      Log.d("App", "Error");
    }
    refresh();
  }

  @Override
  public CharSequence getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
    notifyPropertyChanged("title");
  }

  public float getTempSize() {
    return tempSize;
  }

  public void setTempSize(float tempSize) {
    this.tempSize = tempSize;
    notifyPropertyChanged("tempSize");
  }

  public float getTempY() {
    return tempY;
  }

  public void setTempY(float tempY) {
    this.tempY = tempY;
    notifyPropertyChanged("tempY");
  }

  public Drawable getCurrentImageSrc() {
    return resources.getDrawable(currentImageSrc);
  }

  public void setCurrentImageSrc(int currentImageSrc) {
    this.currentImageSrc = currentImageSrc;
    notifyPropertyChanged("currentImageSrc");
  }

  public String getTempUnit() {
    return tempUnit;
  }

  public void setTempUnit(String tempUnit) {
    this.tempUnit = tempUnit;
    notifyPropertyChanged("tempUnit");
  }

  public String getHumidity() {
    return humidity;
  }

  public void setHumidity(String humidity) {
    this.humidity = humidity;
    notifyPropertyChanged("humidity");
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
    notifyPropertyChanged("cityName");
  }

  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
    notifyPropertyChanged("condition");
  }

  public String getTemp() {
    return temp;
  }

  public void setTemp(String temp) {
    this.temp = temp;
    notifyPropertyChanged("temp");
  }

  public String getWindSpeed() {
    return windSpeed;
  }

  public void setWindSpeed(String windSpeed) {
    this.windSpeed = windSpeed;
    notifyPropertyChanged("windSpeed");
  }

  public String getWindDeg() {
    return windDeg;
  }

  public void setWindDeg(String windDeg) {
    this.windDeg = windDeg;
    notifyPropertyChanged("windDeg");
  }

  public String getUnitTemp() {
    return unitTemp;
  }

  public void setUnitTemp(String unitTemp) {
    this.unitTemp = unitTemp;
    notifyPropertyChanged("unitTemp");
  }

  public String getTempMin() {
    return tempMin;
  }

  public void setTempMin(String tempMin) {
    this.tempMin = tempMin;
    notifyPropertyChanged("tempMin");
  }

  public String getTempMax() {
    return tempMax;
  }

  public void setTempMax(String tempMax) {
    this.tempMax = tempMax;
    notifyPropertyChanged("tempMax");
  }

  public String getSunset() {
    return sunset;
  }

  public void setSunset(String sunset) {
    this.sunset = sunset;
    notifyPropertyChanged("sunset");
  }

  public String getSunrise() {
    return sunrise;
  }

  public void setSunrise(String sunrise) {
    this.sunrise = sunrise;
    notifyPropertyChanged("sunrise");
  }

  public String getCloud() {
    return cloud;
  }

  public void setCloud(String cloud) {
    this.cloud = cloud;
    notifyPropertyChanged("cloud");
  }

  public String getRain() {
    return rain;
  }

  public void setRain(String rain) {
    this.rain = rain;
    notifyPropertyChanged("rain");
  }

  public Float getTempUnitX() {
    return tempUnitX;
  }

  public void setTempUnitX(Float tempUnitX) {
    this.tempUnitX = tempUnitX;
    notifyPropertyChanged("tempUnitX");
  }

  public float getTempMaxX() {
    return tempMaxX;
  }

  public void setTempMaxX(float tempMaxX) {
    this.tempMaxX = tempMaxX;
    notifyPropertyChanged("tempMaxX");
  }

  public float getCurrentImageHeight() {
    return currentImageHeight;
  }

  public void setCurrentImageHeight(float currentImageHeight) {
    this.currentImageHeight = currentImageHeight;
    notifyPropertyChanged("currentImageHeight");
  }

  public float getCurrentImageWidth() {
    return currentImageWidth;
  }

  public void setCurrentImageWidth(float currentImageWidth) {
    this.currentImageWidth = currentImageWidth;
    notifyPropertyChanged("currentImageWidth");
  }

  private WeatherConfig.UNIT_SYSTEM getUnitSystem() {
    return tempUnit.substring(1, 2).equals("F") ? WeatherConfig.UNIT_SYSTEM.M : WeatherConfig.UNIT_SYSTEM.I;
  }

  public void changeUnit() {
    client = WeatherClientDefault.getInstance();
    config = new WeatherConfig();
    config.unitSystem = getUnitSystem();
    config.lang = "en";
    config.maxResult = 5;
    config.numDays = 6;

    client.updateWeatherConfig(config);
    refresh();
  }

  public void refresh() {
    // Get Current Condition
    client.getCurrentCondition(cityId, new WeatherClient.WeatherEventListener() {
      @Override
      public void onWeatherRetrieved(CurrentWeather currentWeather) {
        setTitle(currentWeather.location.getCity() + ", " + currentWeather.location.getCountry());
        setCondition(currentWeather.currentCondition.getCondition() + "(" + currentWeather.currentCondition.getDescr() + ")");
        setTempUnit(currentWeather.getUnit().tempUnit);
        int temp = (int) currentWeather.temperature.getTemp();
        float tY = -15.0f;
        float tSize = 100.0f;
        float tUnitX = 105.0f;
        float tMaxX = 120.0f;

        if (temp < 10) {
          tUnitX = 50.0f;
          tMaxX = 65.0f;
        } else if (temp >= 100) {
          tSize = 70.0f;
          tY = 5.0f;
        }

        setTemp("" + temp);
        setTempSize(tSize);
        setTempY(tY);
        setTempUnitX(tUnitX);
        setTempMaxX(tMaxX);

        setTempMax("" + currentWeather.temperature.getMaxTemp());
        setTempMin("" + currentWeather.temperature.getMinTemp());
        setWindSpeed(currentWeather.wind.getSpeed() + currentWeather.getUnit().speedUnit + " " + (int) currentWeather.wind.getDeg() + "°");
        setCurrentImageWidth(100.0f);
        setCurrentImageHeight(100.0f);
        setCurrentImageSrc(IconMapper.getWeatherResource(currentWeather.currentCondition.getIcon(), currentWeather.currentCondition.getWeatherId()));
        setHumidity(currentWeather.currentCondition.getHumidity() + "%");
        setSunrise(WeatherUtil.convertDate(currentWeather.location.getSunrise()));
        setSunset(WeatherUtil.convertDate(currentWeather.location.getSunset()));
        setCloud(currentWeather.clouds.getPerc() + "%");
        if (currentWeather.rain.getTime() != null && currentWeather.rain.getAmmount() != 0) {
          setRain(currentWeather.rain.getTime() + ":" + currentWeather.rain.getAmmount());
        } else
          setRain("-----");
      }

      @Override
      public void onWeatherError(WeatherLibException e) {
        e.printStackTrace();
      }

      @Override
      public void onConnectionError(Throwable throwable) {
        throwable.printStackTrace();
      }
    });

    // Get forecast weather for the next days
    client.getForecastWeather(cityId, new WeatherClient.ForecastWeatherEventListener() {
      @Override
      public void onWeatherRetrieved(WeatherForecast weatherForecast) {
        SimpleDateFormat sdfDay = new SimpleDateFormat("EEEE");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MMM, dd");
        Date d = new Date();
        Calendar gc = new GregorianCalendar();
        gc.setTime(d);
        for (int i = 0; i < 6; i++) {
          DayForecast forecast = weatherForecast.getForecast(i);
          gc.add(GregorianCalendar.DAY_OF_MONTH, 1);
          obsForecastItems.get(i).setDailyDay(sdfDay.format(gc.getTime()));
          obsForecastItems.get(i).setDailyDate(sdfMonth.format(gc.getTime()));
          obsForecastItems.get(i).setDailyImageSrc(IconMapper.getWeatherResource(forecast.weather.currentCondition.getIcon(), forecast.weather.currentCondition.getWeatherId()));
          obsForecastItems.get(i).setDailyCondition(forecast.weather.currentCondition.getDescr());
          obsForecastItems.get(i).setDailyTempMax("" + (int) forecast.forecastTemp.max + "°");
          obsForecastItems.get(i).setDailyTempMin("" + (int) forecast.forecastTemp.min + "°");
        }
      }

      @Override
      public void onWeatherError(WeatherLibException e) {
        e.printStackTrace();
      }

      @Override
      public void onConnectionError(Throwable throwable) {
        throwable.printStackTrace();
      }
    });
  }
}
