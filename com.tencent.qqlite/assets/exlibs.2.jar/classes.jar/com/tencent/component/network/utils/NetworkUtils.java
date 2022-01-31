package com.tencent.component.network.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.component.network.downloader.impl.ipc.Const;
import java.util.HashMap;

public class NetworkUtils
{
  public static final String APN_NAME_WIFI = "wifi";
  private static final Uri a = Uri.parse("content://telephony/carriers/preferapn");
  private static final HashMap<String, NetworkProxy> b;
  
  static
  {
    HashMap localHashMap = new HashMap();
    b = localHashMap;
    localHashMap.put("cmwap", new NetworkProxy("10.0.0.172", 80));
    b.put("3gwap", new NetworkProxy("10.0.0.172", 80));
    b.put("uniwap", new NetworkProxy("10.0.0.172", 80));
    b.put("ctwap", new NetworkProxy("10.0.0.200", 80));
  }
  
  private static int a()
  {
    if (PlatformUtil.version() < 11) {}
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
        String str = System.getProperty("http.proxyPort");
        if (!a(str)) {
          try
          {
            i = Integer.parseInt(str);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
          }
        }
      }
    }
  }
  
  private static String a(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt & 0xFF).append(".");
    localStringBuffer.append(paramInt >> 8 & 0xFF).append(".");
    localStringBuffer.append(paramInt >> 16 & 0xFF).append(".");
    localStringBuffer.append(paramInt >>> 24);
    return localStringBuffer.toString();
  }
  
  private static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  /* Error */
  public static String getAPN(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokestatic 123	com/tencent/component/network/utils/NetworkUtils:getActiveNetworkInfo	(Landroid/content/Context;)Landroid/net/NetworkInfo;
    //   6: astore 5
    //   8: aload 5
    //   10: ifnonnull +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: aload 5
    //   17: invokevirtual 128	android/net/NetworkInfo:getType	()I
    //   20: iconst_1
    //   21: if_icmpne +19 -> 40
    //   24: ldc 14
    //   26: astore_0
    //   27: aload_0
    //   28: astore_2
    //   29: aload_0
    //   30: ifnull +8 -> 38
    //   33: aload_0
    //   34: invokevirtual 131	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   37: astore_2
    //   38: aload_2
    //   39: areturn
    //   40: aload 5
    //   42: invokevirtual 128	android/net/NetworkInfo:getType	()I
    //   45: ifne +171 -> 216
    //   48: invokestatic 67	com/tencent/component/network/utils/PlatformUtil:version	()I
    //   51: bipush 17
    //   53: if_icmpge +158 -> 211
    //   56: aload_0
    //   57: invokevirtual 137	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   60: getstatic 31	com/tencent/component/network/utils/NetworkUtils:a	Landroid/net/Uri;
    //   63: aconst_null
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: invokevirtual 143	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   70: astore_0
    //   71: aload_0
    //   72: astore_3
    //   73: aconst_null
    //   74: astore_0
    //   75: aload_3
    //   76: ifnull +14 -> 90
    //   79: aload_3
    //   80: invokeinterface 149 1 0
    //   85: istore_1
    //   86: iload_1
    //   87: ifne +35 -> 122
    //   90: aload_0
    //   91: astore_2
    //   92: aload_3
    //   93: ifnull +11 -> 104
    //   96: aload_3
    //   97: invokeinterface 152 1 0
    //   102: aload_0
    //   103: astore_2
    //   104: aload_2
    //   105: astore_0
    //   106: aload_2
    //   107: invokestatic 158	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifeq -83 -> 27
    //   113: aload 5
    //   115: invokevirtual 161	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   118: astore_0
    //   119: goto -92 -> 27
    //   122: aload_3
    //   123: aload_3
    //   124: ldc 163
    //   126: invokeinterface 166 2 0
    //   131: invokeinterface 169 2 0
    //   136: astore_2
    //   137: aload_2
    //   138: astore_0
    //   139: goto -64 -> 75
    //   142: astore_2
    //   143: aconst_null
    //   144: astore 4
    //   146: aload_3
    //   147: astore_0
    //   148: aload 4
    //   150: astore_3
    //   151: aload_2
    //   152: invokevirtual 170	java/lang/Throwable:printStackTrace	()V
    //   155: aload_3
    //   156: astore_2
    //   157: aload_0
    //   158: ifnull -54 -> 104
    //   161: aload_0
    //   162: invokeinterface 152 1 0
    //   167: aload_3
    //   168: astore_2
    //   169: goto -65 -> 104
    //   172: astore_0
    //   173: aconst_null
    //   174: astore_3
    //   175: aload_3
    //   176: ifnull +9 -> 185
    //   179: aload_3
    //   180: invokeinterface 152 1 0
    //   185: aload_0
    //   186: athrow
    //   187: astore_0
    //   188: goto -13 -> 175
    //   191: astore_2
    //   192: aload_0
    //   193: astore_3
    //   194: aload_2
    //   195: astore_0
    //   196: goto -21 -> 175
    //   199: astore_2
    //   200: aload_3
    //   201: astore 4
    //   203: aload_0
    //   204: astore_3
    //   205: aload 4
    //   207: astore_0
    //   208: goto -57 -> 151
    //   211: aconst_null
    //   212: astore_2
    //   213: goto -109 -> 104
    //   216: aconst_null
    //   217: astore_0
    //   218: goto -191 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	paramContext	Context
    //   85	2	1	bool	boolean
    //   28	110	2	localObject1	Object
    //   142	10	2	localThrowable1	Throwable
    //   156	13	2	localObject2	Object
    //   191	4	2	localObject3	Object
    //   199	1	2	localThrowable2	Throwable
    //   212	1	2	localObject4	Object
    //   1	204	3	localObject5	Object
    //   144	62	4	localObject6	Object
    //   6	108	5	localNetworkInfo	NetworkInfo
    // Exception table:
    //   from	to	target	type
    //   56	71	142	java/lang/Throwable
    //   56	71	172	finally
    //   79	86	187	finally
    //   122	137	187	finally
    //   151	155	191	finally
    //   79	86	199	java/lang/Throwable
    //   122	137	199	java/lang/Throwable
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
      Const.d("NetworkUtil", "fail to get active network info", paramContext);
    }
    return null;
  }
  
  public static DNS getDNS(Context paramContext)
  {
    DNS localDNS = new DNS();
    if ((paramContext != null) && (isWifiConnected(paramContext)))
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getDhcpInfo();
      if (paramContext != null)
      {
        localDNS.primary = a(paramContext.dns1);
        localDNS.secondary = a(paramContext.dns2);
      }
    }
    if ((localDNS.primary == null) && (localDNS.secondary == null))
    {
      localDNS.primary = d.a("net.dns1");
      localDNS.secondary = d.a("net.dns2");
    }
    return localDNS;
  }
  
  public static NetworkProxy getProxy(Context paramContext)
  {
    if (!isMobileConnected(paramContext)) {
      return null;
    }
    if (PlatformUtil.version() < 11) {}
    for (paramContext = Proxy.getDefaultHost();; paramContext = System.getProperty("http.proxyHost"))
    {
      int i = a();
      if ((a(paramContext)) || (i < 0)) {
        break;
      }
      return new NetworkProxy(paramContext, i);
    }
    return null;
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
    paramContext = (NetworkProxy)b.get(paramContext);
    if (paramContext == null) {
      return null;
    }
    return paramContext.a();
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
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = getActiveNetworkInfo(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static boolean isNetworkUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
        return true;
      }
    } while (URLUtil.isFileUrl(paramString));
    return URLUtil.isNetworkUrl(paramString);
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = getActiveNetworkInfo(paramContext);
    } while ((paramContext == null) || (paramContext.getType() != 1));
    return true;
  }
  
  public static final class DNS
  {
    public String primary;
    public String secondary;
    
    public final String toString()
    {
      return this.primary + "," + this.secondary;
    }
  }
  
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
    
    final NetworkProxy a()
    {
      try
      {
        NetworkProxy localNetworkProxy = (NetworkProxy)clone();
        return localNetworkProxy;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        localCloneNotSupportedException.printStackTrace();
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.NetworkUtils
 * JD-Core Version:    0.7.0.1
 */