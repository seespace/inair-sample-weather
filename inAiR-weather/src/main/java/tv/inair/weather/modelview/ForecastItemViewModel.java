package tv.inair.weather.modelview;

import android.graphics.drawable.BitmapDrawable;

import inair.data.ViewModel;
import tv.inair.weather.R;

/**
 * Created by Synyster on 6/2/14.
 */
public class ForecastItemViewModel extends ViewModel {
  private String dailyDay;
  private String dailyDate;
  private BitmapDrawable dailyImageSrc;
  private String dailyCondition;
  private String dailyTempMax;
  private String dailyTempMin;
  private float posX;
  private float posY;
  private float textSize = 25.0f;
  private float textAlpha = 1.0f;

  public ForecastItemViewModel() {
    dailyDay = "Default";
    dailyDate = "";
    dailyCondition = "";
    dailyTempMax = "";
    dailyTempMin = "";
    dailyImageSrc = ((BitmapDrawable) resources.getDrawable(R.drawable.cloud));
    posX = 0.0f;
    posY = 0.0f;
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

  public BitmapDrawable getDailyImageSrc() {
    return dailyImageSrc;
  }

  public void setDailyImageSrc(BitmapDrawable dailyImageSrc) {
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

  public float getPosX() {
    return posX;
  }

  public void setPosX(float posX) {
    this.posX = posX;
    notifyPropertyChanged("posX");
  }

  public float getPosY() {
    return posY;
  }

  public void setPosY(float posY) {
    this.posY = posY;
    notifyPropertyChanged("posY");
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