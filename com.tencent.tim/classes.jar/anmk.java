import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class anmk
{
  private static long amh;
  
  public static void eT(Context paramContext)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().remove("splash_ad_uin_long").apply();
    amh = 0L;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return paramContext.getDefaultDisplay().getWidth();
  }
  
  public static long q(Context paramContext)
  {
    if (amh == 0L) {
      amh = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("splash_ad_uin_long", 0L);
    }
    return amh;
  }
  
  public static void q(Context paramContext, long paramLong)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("splash_ad_uin_long", paramLong).apply();
    amh = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anmk
 * JD-Core Version:    0.7.0.1
 */