package wf7;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings.Secure;
import android.support.annotation.NonNull;

public class dj
{
  private static final String TAG = "dj";
  
  public static boolean c(@NonNull Context paramContext)
  {
    if (dk.bJ() < 19) {
      return true;
    }
    return paramContext.getPackageManager().checkPermission("android.permission.ACCESS_COARSE_LOCATION", paramContext.getPackageName()) == 0;
  }
  
  public static boolean d(@NonNull Context paramContext)
  {
    if (dk.bJ() < 19) {
      return true;
    }
    return paramContext.getPackageManager().checkPermission("android.permission.ACCESS_FINE_LOCATION", paramContext.getPackageName()) == 0;
  }
  
  public static boolean e(@NonNull Context paramContext)
  {
    int i = dk.bJ();
    boolean bool = true;
    if (i < 19) {
      return true;
    }
    if (!c(paramContext))
    {
      if (d(paramContext)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean f(@NonNull Context paramContext)
  {
    if (dk.bJ() < 23) {
      return true;
    }
    return paramContext.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", paramContext.getPackageName()) == 0;
  }
  
  @TargetApi(19)
  public static boolean g(@NonNull Context paramContext)
  {
    if (dk.bJ() < 23) {
      return true;
    }
    boolean bool = false;
    try
    {
      int i = Settings.Secure.getInt(paramContext.getContentResolver(), "location_mode");
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.dj
 * JD-Core Version:    0.7.0.1
 */