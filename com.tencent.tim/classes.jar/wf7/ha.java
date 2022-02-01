package wf7;

import alkz;
import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;

public class ha
{
  private static final String TAG = ha.class.getSimpleName();
  private static final WifiManager sD;
  
  static
  {
    Context localContext = gv.dE();
    WifiManager localWifiManager = gu.G(localContext);
    if (localWifiManager != null) {}
    for (;;)
    {
      sD = localWifiManager;
      return;
      localWifiManager = (WifiManager)localContext.getSystemService("wifi");
    }
  }
  
  private static boolean W(String paramString)
  {
    paramString = j(paramString);
    if (!Y(paramString)) {}
    do
    {
      return false;
      localObject = sD.getConfiguredNetworks();
    } while (localObject == null);
    int i = dk.bJ();
    Object localObject = ((List)localObject).iterator();
    boolean bool = false;
    WifiConfiguration localWifiConfiguration;
    if (((Iterator)localObject).hasNext())
    {
      localWifiConfiguration = (WifiConfiguration)((Iterator)localObject).next();
      if (!TextUtils.equals(j(localWifiConfiguration.SSID), paramString)) {
        break label105;
      }
      if (i < 23) {
        bool = removeNetwork(localWifiConfiguration.networkId);
      }
    }
    label105:
    for (;;)
    {
      break;
      bool = disableNetwork(localWifiConfiguration.networkId);
      continue;
      return bool;
    }
  }
  
  @Nullable
  public static WifiConfiguration X(String paramString)
  {
    Object localObject = getConfiguredNetworks();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WifiConfiguration localWifiConfiguration = (WifiConfiguration)((Iterator)localObject).next();
        if (TextUtils.equals(j(localWifiConfiguration.SSID), paramString)) {
          return localWifiConfiguration;
        }
      }
    }
    return null;
  }
  
  public static boolean Y(String paramString)
  {
    return (paramString != null) && (!paramString.equals("<unknown ssid>")) && (!paramString.equals("0x"));
  }
  
  public static String Z(String paramString)
  {
    try
    {
      paramString = MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"));
      StringBuilder localStringBuilder = new StringBuilder(paramString.length * 2);
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        int k = paramString[i];
        if ((k & 0xFF) < 16) {
          localStringBuilder.append("0");
        }
        localStringBuilder.append(Integer.toHexString(k & 0xFF));
        i += 1;
      }
      return localStringBuilder.toString();
    }
    catch (NoSuchAlgorithmException paramString)
    {
      return "";
    }
    catch (UnsupportedEncodingException paramString)
    {
      return "";
    }
  }
  
  public static boolean disableNetwork(int paramInt)
  {
    try
    {
      boolean bool = sD.disableNetwork(paramInt);
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static String fj()
  {
    WifiInfo localWifiInfo = getConnectionInfo();
    if (localWifiInfo != null) {
      return localWifiInfo.getSSID();
    }
    return null;
  }
  
  public static boolean fk()
  {
    String str = fj();
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return W(str);
  }
  
  @Nullable
  public static List<WifiConfiguration> getConfiguredNetworks()
  {
    try
    {
      List localList = sD.getConfiguredNetworks();
      return localList;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static WifiInfo getConnectionInfo()
  {
    try
    {
      WifiInfo localWifiInfo = alkz.a(sD);
      return localWifiInfo;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static boolean isWifiEnabled()
  {
    try
    {
      boolean bool = sD.isWifiEnabled();
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static String j(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    int i;
    do
    {
      do
      {
        do
        {
          return str;
          i = paramString.length();
          str = paramString;
        } while (i <= 1);
        str = paramString;
      } while (paramString.charAt(0) != '"');
      str = paramString;
    } while (paramString.charAt(i - 1) != '"');
    return paramString.substring(1, i - 1);
  }
  
  public static boolean removeNetwork(int paramInt)
  {
    try
    {
      boolean bool = sD.removeNetwork(paramInt);
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static boolean startScan()
  {
    try
    {
      boolean bool = sD.startScan();
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.ha
 * JD-Core Version:    0.7.0.1
 */