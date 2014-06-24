package tv.inair.weather;

import android.os.Bundle;

import inair.app.IABaseLayeredItemLayout;
import inair.event.AnonymousHandler;
import inair.event.Delegate;
import inair.input.TouchEventArgs;
import inair.view.UIView;
import tv.inair.weather.modelview.WeatherViewModel;

/**
 * Created by Linh Nguyen.
 * Copyright (c) 2014 InAir. All rights reserved.
 */
public class WeatherLayout extends IABaseLayeredItemLayout {

  @SuppressWarnings("unchecked")
  final Delegate<TouchEventArgs> doubleTapEventHandler = Delegate.createHandler(new AnonymousHandler<TouchEventArgs>() {
    @Override
    public void handler(Object sender, TouchEventArgs args) {
      WeatherViewModel vm = ((WeatherViewModel) getDataContext());
      vm.refresh();
    }
  }, TouchEventArgs.class);

  @Override
  public void onInitialize(Bundle savedInstanceState) {
    setRootContentView(R.layout.weather_layout);

    addHandlerForUIView(UIView.DoubleTapEvent, doubleTapEventHandler);
  }
}
