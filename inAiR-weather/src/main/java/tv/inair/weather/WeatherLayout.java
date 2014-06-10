package tv.inair.weather;

import android.os.Bundle;

import inair.app.IABaseLayeredItemLayout;
import tv.inair.weather.modelview.ForecastItemViewModel;
import tv.inair.weather.modelview.WeatherViewModel;

/**
 * Created by Linh Nguyen.
 * Copyright (c) 2014 InAir. All rights reserved.
 */
public class WeatherLayout extends IABaseLayeredItemLayout {
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
}
