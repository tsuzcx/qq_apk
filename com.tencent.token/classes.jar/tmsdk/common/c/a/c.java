package tmsdk.common.c.a;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;

public class c
{
  public static int a = 4;
  public static String b = null;
  public static int c = 80;
  public static byte d = 0;
  public static boolean e = false;
  public static boolean f = false;
  public static byte g = 4;
  public static String h = "unknown";
  public static byte i = 9;
  
  public static void a(Context paramContext)
  {
    if (f) {
      return;
    }
    try
    {
      if (f) {
        return;
      }
    }
    finally {}
    b(paramContext);
    f = true;
  }
  
  private static void a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      if (paramString.contains("cmwap"))
      {
        h = "cmwap";
        i = 0;
        return;
      }
      if (paramString.contains("cmnet"))
      {
        h = "cmnet";
        i = 1;
        return;
      }
      if (paramString.contains("3gwap"))
      {
        h = "3gwap";
        i = 2;
        return;
      }
      if (paramString.contains("3gnet"))
      {
        h = "3gnet";
        i = 3;
        return;
      }
      if (paramString.contains("uniwap"))
      {
        h = "uniwap";
        i = 4;
        return;
      }
      if (paramString.contains("uninet"))
      {
        h = "uninet";
        i = 5;
        return;
      }
      if (paramString.contains("ctwap"))
      {
        h = "ctwap";
        i = 6;
        return;
      }
      if (paramString.contains("ctnet"))
      {
        h = "ctnet";
        i = 7;
        return;
      }
    } while (!paramString.contains("#777"));
    h = "#777";
    i = 8;
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 0);
  }
  
  public static void b(Context paramContext)
  {
    localObject = null;
    try
    {
      paramContext = tmsdk.common.b.a().a();
      new StringBuilder().append("networkInfo : ").append(paramContext).toString();
      try
      {
        a = 0;
        g = 4;
        if (paramContext == null) {
          break label626;
        }
        j = paramContext.getType();
        new StringBuilder().append("type: ").append(paramContext.getType()).toString();
        new StringBuilder().append("typeName: ").append(paramContext.getTypeName()).toString();
        paramContext = paramContext.getExtraInfo();
        if (paramContext != null) {
          break label338;
        }
        a = 0;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          int j;
          paramContext.printStackTrace();
          continue;
          if ((paramContext.contains("cmwap")) || (paramContext.contains("uniwap")) || (paramContext.contains("3gwap")) || (paramContext.contains("ctwap")))
          {
            g = 1;
            if (paramContext.contains("3gwap")) {
              g = 2;
            }
            a = 2;
          }
          else if ((paramContext.contains("cmnet")) || (paramContext.contains("uninet")) || (paramContext.contains("3gnet")) || (paramContext.contains("ctnet")))
          {
            g = 1;
            if ((paramContext.contains("3gnet")) || (paramContext.contains("ctnet"))) {
              g = 2;
            }
            a = 1;
          }
          else if (paramContext.contains("#777"))
          {
            g = 2;
            a = 0;
          }
          else
          {
            a = 0;
            continue;
            d = 0;
            continue;
            e = false;
            a = 1;
            continue;
            j = -1;
            paramContext = localObject;
          }
        }
      }
      new StringBuilder().append("extraInfo : ").append(paramContext).toString();
      if (j == 1)
      {
        a = 4;
        e = false;
        g = 3;
        h = "unknown";
        i = 9;
        new StringBuilder().append("NETWORK_TYPE : ").append(g).toString();
        new StringBuilder().append("M_APN_TYPE : ").append(a).toString();
        new StringBuilder().append("M_USE_PROXY : ").append(e).toString();
        new StringBuilder().append("M_APN_PROXY : ").append(b).toString();
        new StringBuilder().append("M_APN_PORT : ").append(c).toString();
        new StringBuilder().append("init() Apn.APN_NAME_VALUE: ").append(i).append(" APN_NAME_DRI: ").append(h).append(" NETWORK_TYPE: ").append(g).toString();
        return;
      }
    }
    catch (NullPointerException paramContext)
    {
      for (;;)
      {
        new StringBuilder().append(" getActiveNetworkInfo NullPointerException--- \n").append(paramContext.getMessage()).toString();
        paramContext = null;
        continue;
        label338:
        paramContext = paramContext.trim().toLowerCase();
        continue;
        a(paramContext);
        if (paramContext != null) {
          break;
        }
        a = 0;
        e = false;
        if (a(a))
        {
          b = Proxy.getDefaultHost();
          c = Proxy.getDefaultPort();
          if (b != null) {
            b = b.trim();
          }
          if ((b == null) || ("".equals(b))) {
            break label615;
          }
          e = true;
          a = 2;
          if (!"10.0.0.200".equals(b)) {
            break label608;
          }
          d = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.c.a.c
 * JD-Core Version:    0.7.0.1
 */