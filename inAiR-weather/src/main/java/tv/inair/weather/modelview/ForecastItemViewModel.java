package tv.inair.weather.modelview;

import android.graphics.drawable.Drawable;

import inair.data.ViewModel;
import tv.inair.weather.R;

/**
 * Created by Synyster on 6/2/14.
 */
public class ForecastItemViewModel extends ViewModel {
  private String dailyDay = "";
  private String dailyDate = "";
  private int dailyImageSrc = R.drawable.cloud;
  private String dailyCondition = "";
  private String dailyTempMax = "";
  private String dailyTempMin = "";
  private float textSize = 25.0f;
  private float textAlpha = 1.0f;

  // Constructor
  public ForecastItemViewModel() {
  }

  public String getDailyDay() {
    return dailyDay;
  }

  public void setDailyDay(String dailyDay) {
    this.dailyDay = dailyDay;
    notifyPropertyChanged("dailyDay");
  }

  public String getDailyDate() {
    return dailyDate;
  }

  public void setDailyDate(String dailyDate) {
    this.dailyDate = dailyDate;
    notifyPropertyChanged("dailyDate");
  }

  public Drawable getDailyImageSrc() {
    return resources.getDrawable(dailyImageSrc);
  }

  public void setDailyImageSrc(int dailyImageSrc) {
    this.dailyImageSrc = dailyImageSrc;
    notifyPropertyChanged("dailyImageSrc");
  }

  public String getDailyCondition() {
    return dailyCondition;
  }

  public void setDailyCondition(String dailyCondition) {
    this.dailyCondition = dailyCondition;
    notifyPropertyChanged("dailyCondition");
  }

  public String getDailyTempMax() {
    return dailyTempMax;
  }

  public void setDailyTempMax(String dailyTempMax) {
    this.dailyTempMax = dailyTempMax;
    notifyPropertyChanged("dailyTempMax");
  }

  public String getDailyTempMin() {
    return dailyTempMin;
  }

  public void setDailyTempMin(String dailyTempMin) {
    this.dailyTempMin = dailyTempMin;
    notifyPropertyChanged("dailyTempMin");
  }

  public float getTextAlpha() {
    return textAlpha;
  }

  public void setTextAlpha(float textAlpha) {
    this.textAlpha = textAlpha;
    notifyPropertyChanged("textAlpha");
  }

  public float getTextSize() {
    return textSize;
  }

  public void setTextSize(float textSize) {
    this.textSize = textSize;
    notifyPropertyChanged("textSize");
  }
}