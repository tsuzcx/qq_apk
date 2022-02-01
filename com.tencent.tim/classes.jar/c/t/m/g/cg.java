package c.t.m.g;

import alkz;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import java.util.Collections;
import java.util.List;

public final class cg
{
  public static boolean a = false;
  private static long b = 0L;
  private static boolean c = false;
  
  public static boolean a(WifiManager paramWifiManager)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramWifiManager != null) {}
    for (bool1 = bool2;; bool1 = bool2)
    {
      try
      {
        if (System.currentTimeMillis() - b <= 4000L) {
          break label55;
        }
        bool1 = bool2;
        bool2 = paramWifiManager.startScan();
        bool1 = bool2;
        c = bool2;
        bool1 = bool2;
        b = System.currentTimeMillis();
        bool1 = bool2;
      }
      catch (Exception paramWifiManager)
      {
        for (;;)
        {
          label55:
          a = true;
        }
      }
      finally {}
      return bool1;
      bool1 = bool2;
      bool2 = c;
    }
  }
  
  public static boolean a(ap paramap)
  {
    boolean bool2 = false;
    try
    {
      paramap = paramap.g;
      boolean bool1 = bool2;
      if (paramap != null)
      {
        boolean bool3 = paramap.isWifiEnabled();
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable paramap) {}
    return false;
  }
  
  public static List<ScanResult> b(WifiManager paramWifiManager)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramWifiManager != null) {
      localObject1 = localObject2;
    }
    try
    {
      paramWifiManager = paramWifiManager.getScanResults();
      localObject1 = paramWifiManager;
      a = false;
      localObject1 = paramWifiManager;
    }
    catch (Exception paramWifiManager)
    {
      for (;;)
      {
        a = true;
      }
    }
    paramWifiManager = (WifiManager)localObject1;
    if (localObject1 == null) {
      paramWifiManager = Collections.emptyList();
    }
    return paramWifiManager;
  }
  
  @SuppressLint({"NewApi"})
  public static boolean b(ap paramap)
  {
    paramap = paramap.g;
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramap != null) {}
    try
    {
      boolean bool3 = paramap.isWifiEnabled();
      bool1 = bool3;
      if (!bool3)
      {
        bool1 = bool3;
        bool2 = bool3;
        if (Build.VERSION.SDK_INT >= 18)
        {
          bool2 = bool3;
          bool1 = paramap.isScanAlwaysAvailable();
        }
      }
      return bool1;
    }
    catch (Throwable paramap) {}
    return bool2;
  }
  
  public static String c(ap paramap)
  {
    Object localObject = paramap.a;
    if (localObject == null) {
      return "{}";
    }
    try
    {
      paramap = (WifiManager)((Context)localObject).getSystemService("wifi");
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if ((paramap != null) && (localObject != null))
      {
        paramap = alkz.a(paramap);
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
        if ((paramap != null) && (localObject != null) && (((NetworkInfo)localObject).isConnected()))
        {
          localObject = paramap.getBSSID();
          if ((localObject == null) || (((String)localObject).equals("000000000000")) || (((String)localObject).equals("00-00-00-00-00-00")) || (((String)localObject).equals("00:00:00:00:00:00"))) {
            break label225;
          }
          int i = paramap.getRssi();
          if ((i < -100) || (i > -20)) {
            break label228;
          }
          paramap = paramap.getSSID().replace("\"", "").replace("|", "");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("{");
          localStringBuilder.append("\"mac\":\"");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("\",\"rssi\":");
          localStringBuilder.append(i);
          localStringBuilder.append(",\"ssid\":\"");
          localStringBuilder.append(paramap);
          localStringBuilder.append("\"}");
          paramap = localStringBuilder.toString();
          return paramap;
        }
        return "{}";
      }
    }
    catch (Exception paramap)
    {
      return "{}";
    }
    return "{}";
    label225:
    return "{}";
    label228:
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.cg
 * JD-Core Version:    0.7.0.1
 */