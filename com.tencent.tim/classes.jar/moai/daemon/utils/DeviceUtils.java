package moai.daemon.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.PowerManager;
import moai.daemon.DaemonManager;

public class DeviceUtils
{
  public static boolean isInstalled(String paramString)
  {
    boolean bool = false;
    try
    {
      paramString = DaemonManager.getContext().getPackageManager().getPackageInfo(paramString, 0);
      if (paramString != null) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static boolean isScreenOn()
  {
    Object localObject = DaemonManager.getContext();
    if (localObject == null) {
      return false;
    }
    localObject = (PowerManager)((Context)localObject).getSystemService("power");
    if (Build.VERSION.SDK_INT < 20) {
      return ((PowerManager)localObject).isScreenOn();
    }
    return ((PowerManager)localObject).isInteractive();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.daemon.utils.DeviceUtils
 * JD-Core Version:    0.7.0.1
 */