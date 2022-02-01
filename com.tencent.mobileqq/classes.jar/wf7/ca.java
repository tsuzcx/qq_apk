package wf7;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.util.List;

public final class ca
{
  private static WifiManager gO;
  private static boolean gP = false;
  private static boolean gQ = false;
  
  public static String D(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 8 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 16 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  public static void a(WifiManager paramWifiManager)
  {
    gO = paramWifiManager;
  }
  
  private static void aF()
  {
    System.currentTimeMillis();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int i = -20;
    while (i > -120)
    {
      int j;
      try
      {
        j = WifiManager.calculateSignalLevel(i, 100);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        j = -1;
      }
      localSparseIntArray.put(j, localSparseIntArray.get(j, 0) + 1);
      i -= 1;
    }
    if (localSparseIntArray.size() < 20) {
      gQ = true;
    }
    System.currentTimeMillis();
    gP = true;
  }
  
  public static String aG()
  {
    WifiInfo localWifiInfo = getConnectionInfo();
    if ((localWifiInfo != null) && (!TextUtils.isEmpty(localWifiInfo.getBSSID()))) {
      return localWifiInfo.getBSSID();
    }
    return "";
  }
  
  public static String aH()
  {
    DhcpInfo localDhcpInfo = getDhcpInfo();
    if (localDhcpInfo == null) {
      return "";
    }
    return D(localDhcpInfo.gateway);
  }
  
  public static String aI()
  {
    WifiInfo localWifiInfo = getConnectionInfo();
    if (localWifiInfo != null) {
      return j(localWifiInfo.getSSID());
    }
    return "Unkown";
  }
  
  public static boolean b(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity")).getNetworkInfo(1);
      if (paramContext != null)
      {
        boolean bool = paramContext.isConnected();
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static int calculateSignalLevel(int paramInt1, int paramInt2)
  {
    if (!gP) {
      aF();
    }
    if (!gQ) {}
    try
    {
      int i = WifiManager.calculateSignalLevel(paramInt1, paramInt2);
      return i;
    }
    catch (Throwable localThrowable)
    {
      label23:
      float f;
      break label23;
    }
    if (paramInt1 <= -100) {
      return 0;
    }
    if (paramInt1 >= -55) {
      return paramInt2 - 1;
    }
    f = paramInt2 - 1;
    return (int)((paramInt1 + 100) * f / 45.0F);
  }
  
  public static int compareSignalLevel(int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = WifiManager.compareSignalLevel(paramInt1, paramInt2);
      return paramInt1;
    }
    catch (Throwable localThrowable)
    {
      label8:
      break label8;
    }
    return 0;
  }
  
  public static List<WifiConfiguration> getConfiguredNetworks()
  {
    try
    {
      List localList = gO.getConfiguredNetworks();
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
      WifiInfo localWifiInfo = gO.getConnectionInfo();
      return localWifiInfo;
    }
    catch (Throwable localThrowable)
    {
      label9:
      break label9;
    }
    return null;
  }
  
  public static DhcpInfo getDhcpInfo()
  {
    try
    {
      DhcpInfo localDhcpInfo = gO.getDhcpInfo();
      return localDhcpInfo;
    }
    catch (Throwable localThrowable)
    {
      label9:
      break label9;
    }
    return null;
  }
  
  public static List<ScanResult> getScanResults()
  {
    try
    {
      List localList = gO.getScanResults();
      return localList;
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
      boolean bool = gO.isWifiEnabled();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      label9:
      break label9;
    }
    return false;
  }
  
  private static String j(String paramString)
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
      boolean bool = gO.removeNetwork(paramInt);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      label10:
      break label10;
    }
    return false;
  }
  
  public static boolean saveConfiguration()
  {
    try
    {
      boolean bool = gO.saveConfiguration();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      label9:
      break label9;
    }
    return false;
  }
  
  public static boolean startScan()
  {
    try
    {
      boolean bool = gO.startScan();
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
 * Qualified Name:     wf7.ca
 * JD-Core Version:    0.7.0.1
 */