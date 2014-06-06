package tv.inair.weather.modelview;

import inair.collection.ObservableCollection;
import inair.data.ViewModel;

/**
 * Created by Synyster on 6/3/14.
 */
public class MainViewModel extends ViewModel {
  public ObservableCollection<WeatherViewModel> weatherViewModels = new ObservableCollection<>();

  private String[] cityId = {"5391959", "1581130", "1566083", "5128581", "5124925"};

  public MainViewModel() {
    for (int i = 0; i < cityId.length; i++) {
      weatherViewModels.add(new WeatherViewModel(cityId[i]));
    }
  }
}
