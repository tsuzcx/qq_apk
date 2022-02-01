package com.weiyun.sdk.util;

import alkz;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.log.Log;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.ByteOrder;
import java.util.Enumeration;
import java.util.HashMap;

public class NetworkUtils
{
  public static final String APN_NAME_WIFI = "wifi";
  public static final int CN_2G = 1;
  public static final int CN_3G = 2;
  public static final int CN_4G = 5;
  public static final int CN_ALL = -1;
  public static final int CN_NONE = 0;
  public static final int CN_PCNET = 4;
  public static final int CN_WIFI = 3;
  private static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
  private static final String TAG = "NetworkUtils";
  private static final HashMap<String, NetworkProxy> sAPNProxies = new HashMap();
  
  static
  {
    sAPNProxies.put("cmwap", new NetworkProxy("10.0.0.172", 80));
    sAPNProxies.put("3gwap", new NetworkProxy("10.0.0.172", 80));
    sAPNProxies.put("uniwap", new NetworkProxy("10.0.0.172", 80));
    sAPNProxies.put("ctwap", new NetworkProxy("10.0.0.200", 80));
  }
  
  public static String convert2IP(int paramInt)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = localStringBuffer1.append(paramInt & 0xFF).append('.');
    paramInt >>>= 8;
    localStringBuffer2 = localStringBuffer2.append(paramInt & 0xFF).append('.');
    paramInt >>>= 8;
    localStringBuffer2.append(paramInt & 0xFF).append('.').append(paramInt >>> 8 & 0xFF);
    return localStringBuffer1.toString();
  }
  
  /* Error */
  public static String getAPN(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokestatic 98	com/weiyun/sdk/util/NetworkUtils:getActiveNetworkInfo	(Landroid/content/Context;)Landroid/net/NetworkInfo;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnonnull +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: aload 4
    //   17: invokevirtual 104	android/net/NetworkInfo:getType	()I
    //   20: iconst_1
    //   21: if_icmpne +19 -> 40
    //   24: ldc 11
    //   26: astore_0
    //   27: aload_0
    //   28: astore_1
    //   29: aload_0
    //   30: ifnull +8 -> 38
    //   33: aload_0
    //   34: invokevirtual 109	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   37: astore_1
    //   38: aload_1
    //   39: areturn
    //   40: aload 4
    //   42: invokevirtual 104	android/net/NetworkInfo:getType	()I
    //   45: ifne +165 -> 210
    //   48: getstatic 114	android/os/Build$VERSION:SDK_INT	I
    //   51: bipush 16
    //   53: if_icmpgt +152 -> 205
    //   56: aload_0
    //   57: invokevirtual 120	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   60: getstatic 46	com/weiyun/sdk/util/NetworkUtils:PREFERRED_APN_URI	Landroid/net/Uri;
    //   63: aconst_null
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: invokestatic 126	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   70: astore_0
    //   71: aload_0
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_0
    //   75: aload_2
    //   76: ifnull +32 -> 108
    //   79: aload_2
    //   80: invokeinterface 132 1 0
    //   85: ifeq +23 -> 108
    //   88: aload_2
    //   89: aload_2
    //   90: ldc 134
    //   92: invokeinterface 138 2 0
    //   97: invokeinterface 141 2 0
    //   102: astore_1
    //   103: aload_1
    //   104: astore_0
    //   105: goto -30 -> 75
    //   108: aload_0
    //   109: astore_1
    //   110: aload_2
    //   111: ifnull +11 -> 122
    //   114: aload_2
    //   115: invokeinterface 144 1 0
    //   120: aload_0
    //   121: astore_1
    //   122: aload_1
    //   123: astore_0
    //   124: aload_1
    //   125: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   128: ifeq -101 -> 27
    //   131: aload 4
    //   133: invokevirtual 153	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   136: astore_0
    //   137: goto -110 -> 27
    //   140: astore_1
    //   141: aconst_null
    //   142: astore_3
    //   143: aload_2
    //   144: astore_0
    //   145: aload_3
    //   146: astore_2
    //   147: aload_1
    //   148: invokevirtual 156	java/lang/Throwable:printStackTrace	()V
    //   151: aload_2
    //   152: astore_1
    //   153: aload_0
    //   154: ifnull -32 -> 122
    //   157: aload_0
    //   158: invokeinterface 144 1 0
    //   163: aload_2
    //   164: astore_1
    //   165: goto -43 -> 122
    //   168: astore_0
    //   169: aconst_null
    //   170: astore_2
    //   171: aload_2
    //   172: ifnull +9 -> 181
    //   175: aload_2
    //   176: invokeinterface 144 1 0
    //   181: aload_0
    //   182: athrow
    //   183: astore_0
    //   184: goto -13 -> 171
    //   187: astore_1
    //   188: aload_0
    //   189: astore_2
    //   190: aload_1
    //   191: astore_0
    //   192: goto -21 -> 171
    //   195: astore_1
    //   196: aload_2
    //   197: astore_3
    //   198: aload_0
    //   199: astore_2
    //   200: aload_3
    //   201: astore_0
    //   202: goto -55 -> 147
    //   205: aconst_null
    //   206: astore_1
    //   207: goto -85 -> 122
    //   210: aconst_null
    //   211: astore_0
    //   212: goto -185 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramContext	Context
    //   28	97	1	localObject1	Object
    //   140	8	1	localThrowable1	Throwable
    //   152	13	1	localObject2	Object
    //   187	4	1	localObject3	Object
    //   195	1	1	localThrowable2	Throwable
    //   206	1	1	localObject4	Object
    //   1	199	2	localObject5	Object
    //   142	59	3	localObject6	Object
    //   6	126	4	localNetworkInfo	NetworkInfo
    // Exception table:
    //   from	to	target	type
    //   56	71	140	java/lang/Throwable
    //   56	71	168	finally
    //   79	103	183	finally
    //   147	151	187	finally
    //   79	103	195	java/lang/Throwable
  }
  
  public static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      Log.e("NetworkUtils", "fail to get active network info", paramContext);
    }
    return null;
  }
  
  public static String getDns(Context paramContext)
  {
    DhcpInfo localDhcpInfo = ((WifiManager)paramContext.getSystemService("wifi")).getDhcpInfo();
    paramContext = "none";
    if (localDhcpInfo != null) {
      paramContext = convert2IP(localDhcpInfo.dns1) + "," + convert2IP(localDhcpInfo.dns2);
    }
    return paramContext;
  }
  
  public static long getHostOrderIp(int paramInt)
  {
    if (isLittleEndian())
    {
      long l = Long.parseLong(Integer.toHexString(paramInt), 16);
      return l >> 24 | l << 24 | (0xFF00 & l) << 8 | (0xFF0000 & l) >> 8;
    }
    return Long.parseLong(Integer.toHexString(paramInt), 16);
  }
  
  public static String getLocalIpAddress(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    Object localObject2 = "";
    paramContext = (Context)localObject2;
    for (;;)
    {
      try
      {
        localObject1 = getWifiConfigAddress(localContext);
        paramContext = (Context)localObject2;
        if (isWifiEnable(localContext))
        {
          paramContext = (Context)localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            return localObject1;
          }
        }
        paramContext = (Context)localObject2;
        Enumeration localEnumeration1 = alkz.getNetworkInterfaces();
        paramContext = (Context)localObject2;
        if (localEnumeration1.hasMoreElements())
        {
          paramContext = (Context)localObject2;
          Enumeration localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
          localObject1 = localObject2;
          localObject2 = localObject1;
          paramContext = (Context)localObject1;
          if (!localEnumeration2.hasMoreElements()) {
            continue;
          }
          paramContext = (Context)localObject1;
          localObject2 = (InetAddress)localEnumeration2.nextElement();
          paramContext = (Context)localObject1;
          if (((InetAddress)localObject2).isLoopbackAddress()) {
            continue;
          }
          paramContext = (Context)localObject1;
          if (!(localObject2 instanceof Inet4Address)) {
            continue;
          }
          paramContext = (Context)localObject1;
          localObject1 = ((InetAddress)localObject2).getHostAddress();
          paramContext = (Context)localObject1;
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject1;
        boolean bool;
        Log.e("NetworkUtils", "Fail to get IpAddress:" + localThrowable1.toString());
        return paramContext;
      }
      try
      {
        if (!isWifiApEnabled(localContext)) {
          return paramContext;
        }
        bool = paramContext.startsWith("192.168");
        if (bool) {
          return paramContext;
        }
        localObject1 = paramContext;
      }
      catch (Throwable localThrowable2) {}
    }
    return localObject2;
    return paramContext;
  }
  
  public static int getNetWorkType(Context paramContext)
  {
    int j = getNetWorkTypeImpl(getNetworkInfo(paramContext));
    int i = j;
    if (j == 5) {
      i = 2;
    }
    return i;
  }
  
  private static int getNetWorkTypeImpl(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {
      Log.i("NetworkUtils", "net info is null");
    }
    int i;
    do
    {
      return 0;
      if (!paramNetworkInfo.isAvailable())
      {
        Log.i("NetworkUtils", "net is unavailable. net.type:" + paramNetworkInfo.getType() + " net.subtype:" + paramNetworkInfo.getSubtype() + " net.typename:" + paramNetworkInfo.getTypeName());
        return 0;
      }
      i = paramNetworkInfo.getType();
      int j = paramNetworkInfo.getSubtype();
      if (i == 1) {
        return 3;
      }
      if ((i == 0) || (i == 4) || (i == 5) || (i == 2) || (i == 3))
      {
        switch (j)
        {
        case 0: 
        default: 
          return 0;
        case 1: 
          return 1;
        case 7: 
          return 1;
        case 4: 
          return 1;
        case 2: 
          return 1;
        case 5: 
          return 2;
        case 6: 
          return 2;
        case 8: 
          return 2;
        case 10: 
          return 2;
        case 9: 
          return 2;
        case 3: 
          return 2;
        case 11: 
          return 1;
        case 12: 
          return 2;
        case 13: 
          return 5;
        case 14: 
          return 2;
        }
        return 2;
      }
    } while ((i != 6) && (i != 9));
    return 3;
  }
  
  @Deprecated
  public static NetworkInfo getNetworkInfo(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    return getActiveNetworkInfo(localContext);
  }
  
  public static int getNetworkTypeForReport(Context paramContext)
  {
    int i = getNetWorkTypeImpl(getActiveNetworkInfo(paramContext));
    if (i == 3) {
      return 1;
    }
    if (i == 1) {
      return 2;
    }
    if (i == 2) {
      return 3;
    }
    if (i == 5) {
      return 4;
    }
    return 0;
  }
  
  public static int getPacketSize(Context paramContext)
  {
    int i = getNetWorkType(paramContext);
    if (i == 2) {
      return 32768;
    }
    if (i == 1) {
      return 16384;
    }
    if (i == 3) {
      return 65536;
    }
    return -1;
  }
  
  public static NetworkProxy getProxy(Context paramContext)
  {
    if (!isMobileConnected(paramContext)) {}
    String str;
    int i;
    do
    {
      return null;
      str = getProxyHost(paramContext);
      i = getProxyPort(paramContext);
    } while ((TextUtils.isEmpty(str)) || (i < 0));
    return new NetworkProxy(str, i);
  }
  
  public static NetworkProxy getProxy(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return getProxy(paramContext);
    }
    return getProxyByAPN(paramContext);
  }
  
  public static NetworkProxy getProxyByAPN(Context paramContext)
  {
    if (!isMobileConnected(paramContext)) {
      return null;
    }
    paramContext = getAPN(paramContext);
    paramContext = (NetworkProxy)sAPNProxies.get(paramContext);
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = paramContext.copy()) {
      return paramContext;
    }
  }
  
  private static String getProxyHost(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11) {
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }
  
  private static int getProxyPort(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    for (int i = Proxy.getDefaultPort();; i = -1) {
      for (;;)
      {
        int j;
        if (i >= 0)
        {
          j = i;
          if (i <= 65535) {}
        }
        else
        {
          j = -1;
        }
        return j;
        paramContext = System.getProperty("http.proxyPort");
        if (!TextUtils.isEmpty(paramContext)) {
          try
          {
            i = Integer.parseInt(paramContext);
          }
          catch (NumberFormatException paramContext)
          {
            paramContext.printStackTrace();
          }
        }
      }
    }
  }
  
  public static String getWifiBSSID(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    paramContext = getWifiInfo(localContext);
    if ((paramContext != null) && (paramContext.getBSSID() != null)) {
      return paramContext.getBSSID().toLowerCase().replaceAll(":", "-");
    }
    return null;
  }
  
  public static String getWifiConfigAddress(Context paramContext)
  {
    label59:
    for (;;)
    {
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        WifiInfo localWifiInfo = alkz.a(paramContext);
        if (localWifiInfo != null)
        {
          int i = localWifiInfo.getIpAddress();
          if (i != 0) {
            break label59;
          }
          i = paramContext.getDhcpInfo().ipAddress;
          paramContext = longToIP(getHostOrderIp(i));
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        Log.e("NetworkUtils", "fail to get wifi info", paramContext);
      }
      return "";
    }
  }
  
  public static WifiInfo getWifiInfo(Context paramContext)
  {
    try
    {
      paramContext = alkz.a((WifiManager)paramContext.getSystemService("wifi"));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      Log.e("NetworkUtils", "fail to get wifi info", paramContext);
    }
    return null;
  }
  
  public static String getWifiMacAddress(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    paramContext = getWifiInfo(localContext);
    if (paramContext != null)
    {
      paramContext = alkz.c(paramContext);
      if (paramContext != null) {
        return paramContext.toLowerCase().replaceAll(":", "-");
      }
      Log.w("NetworkUtils", "mac address is null!");
    }
    for (;;)
    {
      return null;
      Log.w("NetworkUtils", "can *NOT* get connect info when get mac address!");
    }
  }
  
  public static String getWifiName(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    paramContext = getWifiInfo(localContext);
    if ((paramContext != null) && (paramContext.getSSID() != null)) {
      return paramContext.getSSID();
    }
    return null;
  }
  
  public static int getWifiSignalStrength(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    paramContext = getWifiInfo(localContext);
    if (paramContext == null) {
      return 0;
    }
    return paramContext.getRssi();
  }
  
  @Deprecated
  public static boolean hasInternet(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    return isNetworkConnected(localContext);
  }
  
  public static boolean isBigEndian()
  {
    return ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
  }
  
  public static boolean isCnwapConnection(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    paramContext = getActiveNetworkInfo(localContext);
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = paramContext.getExtraInfo();
    } while ((paramContext == null) || (!paramContext.toLowerCase().contains("wap")));
    return true;
  }
  
  public static boolean isLittleEndian()
  {
    return ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
  }
  
  public static boolean isMobileConnected(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = getActiveNetworkInfo(paramContext);
    } while ((paramContext == null) || (paramContext.getType() != 0));
    return true;
  }
  
  @Deprecated
  public static boolean isMobileNetwork(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    return isMobileConnected(localContext);
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = getActiveNetworkInfo(paramContext);
    } while ((paramContext == null) || (!paramContext.isConnected()));
    return true;
  }
  
  public static boolean isNetworkConnectedOrConnecting(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getAllNetworkInfo();
      if (paramContext != null)
      {
        int j = paramContext.length;
        int i = 0;
        while (i < j)
        {
          boolean bool = paramContext[i].isConnectedOrConnecting();
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      Log.e("NetworkUtils", "fail to get network info", paramContext);
    }
  }
  
  @Deprecated
  public static boolean isWIFI(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    return isWifiConnected(localContext);
  }
  
  public static boolean isWifiApEnabled(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      Method localMethod = paramContext.getClass().getDeclaredMethod("isWifiApEnabled", new Class[0]);
      if (localMethod != null)
      {
        paramContext = localMethod.invoke(paramContext, new Object[0]);
        if (paramContext != null)
        {
          boolean bool = Boolean.parseBoolean(paramContext.toString());
          return bool;
        }
      }
    }
    catch (Throwable paramContext)
    {
      Log.w("NetworkUtils", "fail to get wifi ap state", paramContext);
    }
    return false;
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    boolean bool = true;
    if (paramContext == null) {
      return false;
    }
    paramContext = getActiveNetworkInfo(paramContext);
    if ((paramContext != null) && (paramContext.getType() == 1)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean isWifiEnable(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    return ((WifiManager)paramContext.getSystemService("wifi")).isWifiEnabled();
  }
  
  public static String longToIP(long paramLong)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.insert(0, paramLong & 0xFF).insert(0, '.');
    paramLong >>>= 8;
    localStringBuilder2 = localStringBuilder2.insert(0, paramLong & 0xFF).insert(0, '.');
    paramLong >>>= 8;
    localStringBuilder2.insert(0, paramLong & 0xFF).insert(0, '.').insert(0, paramLong >>> 8 & 0xFF);
    return localStringBuilder1.toString();
  }
  
  @Deprecated
  public static void setContext(Context paramContext) {}
  
  public static class NetworkProxy
    implements Cloneable
  {
    public final String host;
    public final int port;
    
    NetworkProxy(String paramString, int paramInt)
    {
      this.host = paramString;
      this.port = paramInt;
    }
    
    final NetworkProxy copy()
    {
      try
      {
        NetworkProxy localNetworkProxy = (NetworkProxy)clone();
        return localNetworkProxy;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
      return null;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (!(paramObject instanceof NetworkProxy))) {
          break;
        }
        paramObject = (NetworkProxy)paramObject;
      } while ((TextUtils.equals(this.host, paramObject.host)) && (this.port == paramObject.port));
      return false;
    }
    
    public String toString()
    {
      return this.host + ":" + this.port;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.util.NetworkUtils
 * JD-Core Version:    0.7.0.1
 */