package tv.inair.weather.util;

import tv.inair.apptemplate.R;

/**
 * Created by Synyster on 5/30/14.
 */
public class IconMapper {
  public static int getWeatherResource(String iconId, int wId) {
    // Log.d("App", "Id ["+id+"]");
    if (wId == 500)
      return R.drawable.w500d;

    if (wId == 501)
      return R.drawable.w501d;

    if (wId == 212)
      return R.drawable.w212d;

    if (iconId.equals("01d"))
      return R.drawable.w01d;
    else if (iconId.equals("01n"))
      return R.drawable.w01n;
    else if (iconId.equals("02d") || iconId.equals("02n"))
      return R.drawable.w02d;
    else if (iconId.equals("03d") || iconId.equals("03n"))
      return R.drawable.w03d;
    else if (iconId.equals("03d") || iconId.equals("03n"))
      return R.drawable.w03d;
    else if (iconId.equals("04d") || iconId.equals("04n"))
      return R.drawable.w04d;
    else if (iconId.equals("09d") || iconId.equals("09n"))
      return R.drawable.w500d;
    else if (iconId.equals("10d") || iconId.equals("10n"))
      return R.drawable.w501d;
    else if (iconId.equals("11d") || iconId.equals("11n"))
      return R.drawable.w212d;
    else if (iconId.equals("13d") || iconId.equals("13n"))
      return R.drawable.w13d;
    else if (iconId.equals("50d") || iconId.equals("50n"))
      return R.drawable.w50d;

    return R.drawable.w01d;

  }
}
