package tv.inair.weather.view;

import android.os.Bundle;

import inair.app.IARootLayout;
import tv.inair.weather.Application;
import tv.inair.weather.R;

/**
 * Created by Synyster on 6/10/14.
 */
public class RootLayout extends IARootLayout {
  @Override
  public void onInitialize(Bundle bundle) {
    setAndBindRootContentView(R.layout.layered_view, Application.mainViewModel);
  }
}
