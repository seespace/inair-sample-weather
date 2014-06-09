package tv.inair.weather;

import android.os.Bundle;

import inair.app.IABaseLayeredItem;
import tv.inair.weather.modelview.ForecastItemViewModel;
import tv.inair.weather.modelview.WeatherViewModel;

/**
 * Created by Linh Nguyen.
 * Copyright (c) 2014 InAir. All rights reserved.
 */
public class WeatherLayout extends IABaseLayeredItem {
  private WeatherViewModel weatherViewModel;

  @Override
  public void onInitialize(Bundle savedInstanceState) {
    setRootContentView(R.layout.weather_layout);

    weatherViewModel = ((WeatherViewModel) getDataContext());

    for (ForecastItemViewModel forecastItem : weatherViewModel.obsForecastItems) {
      ForecastLayout forecastLayout = new ForecastLayout();
      forecastLayout.setDataContext(forecastItem);
      addChildLayout(forecastLayout);
    }
  }

  @Override
  public void processDebugKeyPress(int id) {
    switch (id) {
      case inair.sdk.R.id.downBtn:
        break;
      case inair.sdk.R.id.upBtn:
        break;
      case inair.sdk.R.id.enterBtn:
        weatherViewModel.changeUnit();
        break;
      case inair.sdk.R.id.endBtn:
        break;
      case inair.sdk.R.id.leftBtn:
        break;
      case inair.sdk.R.id.rightBtn:
        break;
    }
  }
}
