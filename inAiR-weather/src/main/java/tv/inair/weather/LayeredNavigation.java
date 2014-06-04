package tv.inair.weather;

import android.os.Bundle;

import inair.app.IALayeredNavigation;
import tv.inair.weather.modelview.WeatherViewModel;

/**
 * Created by Synyster on 6/3/14.
 */
public class LayeredNavigation extends IALayeredNavigation {
  @Override
  public void onInitialize(Bundle bundle) {
    for (WeatherViewModel weatherViewModel : Application.mainViewModel.weatherViewModels) {
      WeatherLayout weatherLayout = new WeatherLayout();
      weatherLayout.setDataContext(weatherViewModel);
      addLayer(weatherLayout);
    }
  }
}
