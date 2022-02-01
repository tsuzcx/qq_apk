package wf7;

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
  private static final String TAG = "ha";
  private static final WifiManager sD;
  
  static
  {
    Context localContext = gv.dE();
    WifiManager localWifiManager = gu.G(localContext);
    if (localWifiManager == null) {
      localWifiManager = (WifiManager)localContext.getSystemService("wifi");
    }
    sD = localWifiManager;
  }
  
  private static boolean W(String paramString)
  {
    paramString = j(paramString);
    boolean bool2 = Y(paramString);
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    Object localObject = sD.getConfiguredNetworks();
    if (localObject == null) {
      return false;
    }
    int i = dk.bJ();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WifiConfiguration localWifiConfiguration = (WifiConfiguration)((Iterator)localObject).next();
      if (TextUtils.equals(j(localWifiConfiguration.SSID), paramString)) {
        if (i < 23) {
          bool1 = removeNetwork(localWifiConfiguration.networkId);
        } else {
          bool1 = disableNetwork(localWifiConfiguration.networkId);
        }
      }
    }
    return bool1;
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
        int k = paramString[i] & 0xFF;
        if (k < 16) {
          localStringBuilder.append("0");
        }
        localStringBuilder.append(Integer.toHexString(k));
        i += 1;
      }
      return localStringBuilder.toString();
    }
    catch (NoSuchAlgorithmException|UnsupportedEncodingException paramString) {}
    return "";
  }
  
  public static boolean disableNetwork(int paramInt)
  {
    try
    {
      boolean bool = sD.disableNetwork(paramInt);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      label10:
      break label10;
    }
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
    catch (Throwable localThrowable)
    {
      label9:
      break label9;
    }
    return null;
  }
  
  public static WifiInfo getConnectionInfo()
  {
    try
    {
      WifiInfo localWifiInfo = sD.getConnectionInfo();
      return localWifiInfo;
    }
    catch (Throwable localThrowable)
    {
      label9:
      break label9;
    }
    return null;
  }
  
  public static boolean isWifiEnabled()
  {
    try
    {
      boolean bool = sD.isWifiEnabled();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      label9:
      break label9;
    }
    return false;
  }
  
  public static String j(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int i = paramString.length();
    String str = paramString;
    if (i > 1)
    {
      str = paramString;
      if (paramString.charAt(0) == '"')
      {
        i -= 1;
        str = paramString;
        if (paramString.charAt(i) == '"') {
          str = paramString.substring(1, i);
        }
      }
    }
    return str;
  }
  
  public static boolean removeNetwork(int paramInt)
  {
    try
    {
      boolean bool = sD.removeNetwork(paramInt);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      label10:
      break label10;
    }
    return false;
  }
  
  public static boolean startScan()
  {
    try
    {
      boolean bool = sD.startScan();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      label9:
      break label9;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.ha
 * JD-Core Version:    0.7.0.1
 */