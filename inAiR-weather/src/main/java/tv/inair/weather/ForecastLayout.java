package tv.inair.weather;

import android.os.Bundle;

import inair.app.IABaseLayout;
import inair.app.IAChildLayout;
import inair.view.UITextView;

/**
 * Created by Synyster on 6/2/14.
 */
public class ForecastLayout extends IABaseLayout {
  @Override
  public void onInitialize(Bundle bundle) {
    setRootContentView(R.layout.forecast_item);
  }
}
