package tv.inair.weather;

import inair.app.InAiRApplication;
import tv.inair.weather.modelview.MainViewModel;

/**
 * Application class of inAiR
 * <p>Copyright (c) 2014 SeeSpace.co. All rights reserved.</p>
 */
public class Application extends InAiRApplication {
  /**
   * View model of main layout
   * <p/>
   * Should be singleton and create on Application instance
   */
  public static MainViewModel mainViewModel;

  @Override
  protected void onInitialize() {
    super.onInitialize();
    mainViewModel = new MainViewModel();
  }
}