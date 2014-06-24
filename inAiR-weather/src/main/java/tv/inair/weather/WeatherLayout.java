package tv.inair.weather;

import android.os.Bundle;

import inair.app.IABaseLayeredItemLayout;

/**
 * Created by Linh Nguyen.
 * Copyright (c) 2014 InAir. All rights reserved.
 */
public class WeatherLayout extends IABaseLayeredItemLayout {

  @Override
  public void onInitialize(Bundle savedInstanceState) {
    setRootContentView(R.layout.weather_layout);
  }
}
