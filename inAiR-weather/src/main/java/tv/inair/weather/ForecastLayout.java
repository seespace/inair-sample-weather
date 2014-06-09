package tv.inair.weather;

import android.os.Bundle;

import inair.app.IAChildLayout;
import inair.view.UITextView;

/**
 * Created by Synyster on 6/2/14.
 */
public class ForecastLayout extends IAChildLayout {
  UITextView forecast;
  @Override
  public void onInitialize(Bundle bundle) {
    setRootContentView(R.layout.forecast_item);
  }
}
