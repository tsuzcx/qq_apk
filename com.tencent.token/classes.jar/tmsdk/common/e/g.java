package tmsdk.common.e;

import android.content.Context;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

public final class g
{
  private static String a = "tms_";
  private static String b = "[com.android.internal.telephony.ITelephony]";
  private static String c = "[com.android.internal.telephony.ITelephonyRegistry]";
  private static Boolean d = null;
  
  public static String a()
  {
    return "android_id";
  }
  
  public static String a(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
  }
  
  public static String b()
  {
    return Build.MODEL;
  }
  
  public static String b(Context paramContext)
  {
    String str = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
    paramContext = str;
    if (str == null) {
      paramContext = "000000000000000";
    }
    return paramContext;
  }
  
  public static String c(Context paramContext)
  {
    WifiInfo localWifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    paramContext = null;
    if (localWifiInfo != null) {
      paramContext = localWifiInfo.getMacAddress();
    }
    return paramContext;
  }
  
  public static int d(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int e(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int f(Context paramContext)
  {
    return j.a(b(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.e.g
 * JD-Core Version:    0.7.0.1
 */