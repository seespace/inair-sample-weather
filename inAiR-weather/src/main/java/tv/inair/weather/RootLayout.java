package tv.inair.weather;

import android.os.Bundle;

import inair.app.IABaseRootLayout;
import inair.view.UIViewGroup;

/**
 * Created by Synyster on 6/10/14.
 */
public class RootLayout extends IABaseRootLayout {
  @Override
  public void onInitialize(Bundle bundle) {
    setRootContentView(new UIViewGroup(this));
    addChildLayout(new LayeredNavigationLayout());
  }
}
