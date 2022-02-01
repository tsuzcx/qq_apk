import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class rpc
{
  private static String adv = "";
  private static String adw = "";
  private static volatile boolean aiq;
  
  public static String V(Context paramContext)
  {
    bS(paramContext);
    return adv;
  }
  
  public static String W(Context paramContext)
  {
    bS(paramContext);
    return adw;
  }
  
  public static boolean ak(Context paramContext)
  {
    return AppNetConnInfo.isNetSupport();
  }
  
  public static String al(Context paramContext)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext != null)
        {
          paramContext = alkz.a(paramContext);
          if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.getSSID())))
          {
            paramContext = paramContext.getSSID().replace("\"", "");
            return paramContext;
          }
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return "";
      }
      paramContext = "";
    }
  }
  
  private static void bS(Context paramContext)
  {
    if ((!aiq) && (paramContext != null))
    {
      paramContext = paramContext.getApplicationContext();
      aiq = true;
      AppNetConnInfo.registerNetChangeReceiver(paramContext, new rpd(paramContext));
      bT(paramContext);
    }
  }
  
  private static void bT(Context paramContext)
  {
    WifiInfo localWifiInfo;
    if (paramContext != null)
    {
      localWifiInfo = alkz.a((WifiManager)paramContext.getSystemService("wifi"));
      if (localWifiInfo != null)
      {
        if (!TextUtils.isEmpty(localWifiInfo.getBSSID())) {
          break label55;
        }
        paramContext = "";
        adv = paramContext;
        if (!TextUtils.isEmpty(adv)) {
          break label63;
        }
      }
    }
    label55:
    label63:
    for (paramContext = "";; paramContext = localWifiInfo.getSSID())
    {
      adw = paramContext;
      return;
      paramContext = localWifiInfo.getBSSID();
      break;
    }
  }
  
  public static boolean hasInternet(Context paramContext)
  {
    return AppNetConnInfo.isNetSupport();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rpc
 * JD-Core Version:    0.7.0.1
 */