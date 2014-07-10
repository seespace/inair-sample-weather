package tv.inair.weather.view;

import android.os.Bundle;

import inair.app.IABaseRootLayout;
import tv.inair.weather.Application;
import tv.inair.weather.R;

/**
 * Created by Synyster on 6/10/14.
 */
public class RootLayout extends IABaseRootLayout {
  @Override
  public void onInitialize(Bundle bundle) {
    setAndBindRootContentView(R.layout.layered_view, Application.mainViewModel);
//    setRootContentView(new UIViewGroup(this));
//    addChildLayout(new LayeredNavigationLayout());
  }
}
