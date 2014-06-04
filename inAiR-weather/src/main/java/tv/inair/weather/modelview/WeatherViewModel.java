package tv.inair.weather.modelview;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
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
import inair.data.ViewModel;
import tv.inair.weather.R;
import tv.inair.weather.Application;
import tv.inair.weather.util.IconMapper;
import tv.inair.weather.util.WeatherUtil;

/**
 * Created by Synyster on 5/27/14.
 */
public class WeatherViewModel extends ViewModel {


  public ObservableCollection<ForecastItemViewModel> obsForecastItems = new ObservableCollection<>();
  Resources res;
  private String layerTitle = "";
  private WeatherClient client;
  private WeatherConfig config;
  private String cityId = "";
  private float currentImageWidth = 10.0f;
  private float currentImageHeight = 10.0f;
  private String cityName = "";
  private String condition = "";
  private String temp = "";
  private float tempSize = 100.0f;
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
  private String pressure = "";
  //region Alpha
  private float textAlpha = 1.0f;
  //region Size
  private float textWidth = 500.0f;
  private float textHeight = 100.0f;
  //region Color
  private int textColor = Color.WHITE;
  //region TextContent
  //region TextSize
  private float textSize = 25.0f;
  //region Position
  private float textPositionX = 100.0f;
  private float textPositionY = 100.0f;
  private float textPositionZ = 100.0f;
  //region IMAGE PROPERTIES
  //region Alpha
  private float imageAlpha = 0.2f;
  //region Size
  private float imageWidth = 100.0f;
  private float imageHeight = 100.0f;
  //region Position
  private float imagePositionX = 100.0f;
  private float imagePositionY = 100.0f;
  private float imagePositionZ = 100.0f;
  //region Source
  private Drawable imageSrc = null;
  private BitmapDrawable currentImageSrc;

  // Constructor
  public WeatherViewModel(String cityId) {
    this.cityId = cityId;

    currentImageSrc = (BitmapDrawable) resources.getDrawable(R.drawable.sun);

    for (int i = 0; i < 6; i++) {
      obsForecastItems.add(new ForecastItemViewModel());
    }

    // Config wClient & wConfig
    client = WeatherClientDefault.getInstance();
    client.init(Application.getAppContext());

    config = new WeatherConfig();
    config.unitSystem = WeatherConfig.UNIT_SYSTEM.M;
    config.lang = "en";
    config.maxResult = 5;
    config.numDays = 6;

    try {
      IWeatherProvider provider = WeatherProviderFactory.createProvider(new OpenweathermapProviderType(), config);
      client.setProvider(provider);
    } catch (Throwable t) {
      Log.d("App", "Error");
    }
    refresh();
  }

  public String getLayerTitle() {
    return layerTitle;
  }

  public void setLayerTitle(String layerTitle) {
    this.layerTitle = layerTitle;
    notifyPropertyChanged("layerTitle");
  }

  public float getTempSize() {
    return tempSize;
  }

  public void setTempSize(float tempSize) {
    this.tempSize = tempSize;
    notifyPropertyChanged("tempSize");
  }

  private WeatherConfig.UNIT_SYSTEM getUnitSystem() {
    return tempUnit.substring(1, 2).equals("F") ? WeatherConfig.UNIT_SYSTEM.M : WeatherConfig.UNIT_SYSTEM.I;
  }

  public BitmapDrawable getCurrentImageSrc() {
    return currentImageSrc;
  }

  public void setCurrentImageSrc(BitmapDrawable currentImageSrc) {
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
  //endregion

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
  //endregion

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
  //endregion

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

  public String getPressure() {
    return pressure;
  }

  public void setPressure(String pressure) {
    this.pressure = pressure;
    notifyPropertyChanged("pressure");
  }

  public float getTextAlpha() {
    return textAlpha;
  }

  public void setTextAlpha(float textAlpha) {
    this.textAlpha = textAlpha;
    notifyPropertyChanged("textAlpha");
  }

  public float getTextWidth() {
    return textWidth;
  }

  public void setTextWidth(float textWidth) {
    this.textWidth = textWidth;
    notifyPropertyChanged("textWidth");
  }

  public float getTextHeight() {
    return textHeight;
  }

  public void setTextHeight(float textHeight) {
    this.textHeight = textHeight;
    notifyPropertyChanged("textHeight");
  }

  public int getTextColor() {
    return textColor;
  }

  public void setTextColor(int textColor) {
    this.textColor = textColor;
    notifyPropertyChanged("textColor");
  }

  public float getTextSize() {
    return textSize;
  }

  public void setTextSize(float textSize) {
    this.textSize = textSize;
    notifyPropertyChanged("textSize");
  }
  public float getTextPositionX() {
    return textPositionX;
  }

  public void setTextPositionX(float textPositionX) {
    this.textPositionX = textPositionX;
    notifyPropertyChanged("textPositionX");
  }

  public float getTextPositionY() {
    return textPositionY;
  }

  public void setTextPositionY(float textPositionY) {
    this.textPositionY = textPositionY;
    notifyPropertyChanged("textPositionY");
  }

  public float getTextPositionZ() {
    return textPositionZ;
  }

  public void setTextPositionZ(float textPositionZ) {
    this.textPositionZ = textPositionZ;
    notifyPropertyChanged("textPositionZ");
  }

  public float getImageAlpha() {
    return imageAlpha;
  }

  public void setImageAlpha(float imageAlpha) {
    this.imageAlpha = imageAlpha;
    notifyPropertyChanged("imageAlpha");
  }

  public float getImageWidth() {
    return imageWidth;
  }

  public void setImageWidth(float imageWidth) {
    this.imageWidth = imageWidth;
    notifyPropertyChanged("imageWidth");
  }

  public float getImageHeight() {
    return imageHeight;
  }

  public void setImageHeight(float imageHeight) {
    this.imageHeight = imageHeight;
    notifyPropertyChanged("imageHeight");
  }

  public float getImagePositionX() {
    return imagePositionX;
  }

  public void setImagePositionX(float imagePositionX) {
    this.imagePositionX = imagePositionX;
    notifyPropertyChanged("imagePositionX");
  }

  public float getImagePositionY() {
    return imagePositionY;
  }

  public void setImagePositionY(float imagePositionY) {
    this.imagePositionY = imagePositionY;
    notifyPropertyChanged("imagePositionY");
  }

  public float getImagePositionZ() {
    return imagePositionZ;
  }

  public void setImagePositionZ(float imagePositionZ) {
    this.imagePositionZ = imagePositionZ;
    notifyPropertyChanged("imagePositionZ");
  }

  public Drawable getImageSrc() {
    return imageSrc;
  }

  public void setImageSrc(Drawable imageSrc) {
    this.imageSrc = imageSrc;
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

  public void changeUnit() {
    System.out.println(config.unitSystem);
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
        setLayerTitle(currentWeather.location.getCity() + ", " + currentWeather.location.getCountry());
        setCondition(currentWeather.currentCondition.getCondition() + "(" + currentWeather.currentCondition.getDescr() + ")");
        setTemp("" + (int) currentWeather.temperature.getTemp());
        setTempUnit(currentWeather.getUnit().tempUnit);
        if (currentWeather.temperature.getTemp() < 10) {
          setTempSize(100.0f);
          setTempUnitX(50.0f);
          setTempMaxX(65.0f);
        } else if (currentWeather.temperature.getTemp() > 10 ) {
          setTempSize(100.0f);
          setTempUnitX(105.0f);
          setTempMaxX(120.0f);
          if (currentWeather.temperature.getTemp() >= 100) {
            System.out.println("here");
            setTempSize(90.0f);
          }
        }
        setTempMax("" + currentWeather.temperature.getMaxTemp());
        setTempMin("" + currentWeather.temperature.getMinTemp());
        setWindSpeed(currentWeather.wind.getSpeed() + currentWeather.getUnit().speedUnit + " " + (int) currentWeather.wind.getDeg() + "°");
        setCurrentImageWidth(100.0f);
        setCurrentImageHeight(100.0f);
        setCurrentImageSrc((BitmapDrawable) resources.getDrawable(IconMapper.getWeatherResource(currentWeather.currentCondition.getIcon(), currentWeather.currentCondition.getWeatherId())));
        setHumidity(currentWeather.currentCondition.getHumidity() + "%");
        setSunrise(WeatherUtil.convertDate(currentWeather.location.getSunrise()));
        setSunset(WeatherUtil.convertDate(currentWeather.location.getSunset()));
        setCloud(currentWeather.clouds.getPerc() + "%");
        setPressure(currentWeather.currentCondition.getPressure() + currentWeather.getUnit().pressureUnit);
        if (currentWeather.rain.getTime() != null && currentWeather.rain.getAmmount() != 0) {
          setRain(currentWeather.rain.getTime() + ":" + currentWeather.rain.getAmmount());
        } else
          setRain("-----");
        setPressure("" + currentWeather.currentCondition.getPressure() + currentWeather.getUnit().pressureUnit);
      }

      @Override
      public void onWeatherError(WeatherLibException e) {
      }

      @Override
      public void onConnectionError(Throwable throwable) {
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
        float posX = 420.0f;
        float posY = 400.0f;
        for (int i = 0; i < 6; i++) {
          DayForecast forecast = weatherForecast.getForecast(i);
          gc.add(GregorianCalendar.DAY_OF_MONTH, 1);
          obsForecastItems.get(i).setPosX(posX);
          posY += 40.0f;
          obsForecastItems.get(i).setPosY(posY);
          obsForecastItems.get(i).setDailyDay(sdfDay.format(gc.getTime()));
          obsForecastItems.get(i).setDailyDate(sdfMonth.format(gc.getTime()));
          obsForecastItems.get(i).setDailyImageSrc((BitmapDrawable) resources.getDrawable(IconMapper.getWeatherResource(forecast.weather.currentCondition.getIcon(), forecast.weather.currentCondition.getWeatherId())));
          obsForecastItems.get(i).setDailyCondition(forecast.weather.currentCondition.getDescr());
          obsForecastItems.get(i).setDailyTempMax("" + (int) forecast.forecastTemp.max + "°");
          obsForecastItems.get(i).setDailyTempMin("" + (int) forecast.forecastTemp.min + "°");
        }
      }

      @Override
      public void onWeatherError(WeatherLibException e) {
      }

      @Override
      public void onConnectionError(Throwable throwable) {
      }
    });
  }
}
