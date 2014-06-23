package tv.inair.weather.util;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Synyster on 29/05/14.
 */
public class WeatherUtil {

  public static String getLanguage(String val) {
    if (val == null)
      return "en";

    if (val.equalsIgnoreCase("system"))
      return Locale.getDefault().getLanguage();

    return null;
  }


  public static String convertDate(long unixTime) {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(unixTime * 1000);
    sdf.setTimeZone(cal.getTimeZone());
    return sdf.format(cal.getTime());
  }
}
