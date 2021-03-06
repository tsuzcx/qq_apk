import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;

public class mev
{
  public static String Y(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    return paramContext.widthPixels + "_" + paramContext.heightPixels;
  }
  
  public static double a(Context paramContext)
  {
    return Settings.System.getInt(paramContext.getContentResolver(), "screen_brightness", 255) * 1.0F / 255.0F;
  }
  
  public static boolean ar(Context paramContext)
  {
    boolean bool = ((AudioManager)paramContext.getSystemService("audio")).isWiredHeadsetOn();
    if (BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1) == 2) {}
    for (int i = 1; (bool) || (i != 0); i = 0) {
      return true;
    }
    return false;
  }
  
  public static double b(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    int i = paramContext.getStreamVolume(3);
    int j = paramContext.getStreamMaxVolume(3);
    return i * 1.0D / j;
  }
  
  public static String getDeviceModel()
  {
    return Build.MODEL;
  }
  
  public static int getNetType()
  {
    return aroc.getNetType(null);
  }
  
  public static double r()
  {
    double d = 1.0D;
    if (Build.VERSION.SDK_INT >= 21) {
      d = ((BatteryManager)BaseApplicationImpl.getApplication().getSystemService("batterymanager")).getIntProperty(4) / 100.0D;
    }
    Intent localIntent;
    do
    {
      return d;
      localIntent = new ContextWrapper(BaseApplicationImpl.getApplication().getApplicationContext()).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    } while (localIntent.getIntExtra("level", -1) * 1.0D / localIntent.getIntExtra("scale", -1) == 0.0D);
    return localIntent.getIntExtra("scale", -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mev
 * JD-Core Version:    0.7.0.1
 */