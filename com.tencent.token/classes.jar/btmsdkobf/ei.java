package btmsdkobf;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;

public class ei
{
  public static int og = 4;
  public static String oh;
  public static int oi = 80;
  public static byte oj = 0;
  public static boolean ok = false;
  public static boolean ol = false;
  public static byte om = 4;
  public static String on = "unknown";
  public static byte oo = 9;
  public static int op = 17;
  
  private static void M(String paramString)
  {
    if (paramString == null) {
      return;
    }
    byte b;
    if (paramString.contains("cmwap"))
    {
      on = "cmwap";
      b = 0;
    }
    for (;;)
    {
      oo = b;
      return;
      if (paramString.contains("cmnet"))
      {
        on = "cmnet";
        b = 1;
      }
      else if (paramString.contains("3gwap"))
      {
        on = "3gwap";
        b = 2;
      }
      else if (paramString.contains("3gnet"))
      {
        on = "3gnet";
        b = 3;
      }
      else if (paramString.contains("uniwap"))
      {
        on = "uniwap";
        b = 4;
      }
      else if (paramString.contains("uninet"))
      {
        on = "uninet";
        b = 5;
      }
      else if (paramString.contains("ctwap"))
      {
        on = "ctwap";
        b = 6;
      }
      else if (paramString.contains("ctnet"))
      {
        on = "ctnet";
        b = 7;
      }
      else
      {
        if (!paramString.contains("#777")) {
          break;
        }
        on = "#777";
        b = 8;
      }
    }
  }
  
  private static boolean M(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 0);
  }
  
  private static int a(Context paramContext, NetworkInfo paramNetworkInfo)
  {
    int j = 0;
    if (paramNetworkInfo == null) {
      return 0;
    }
    try
    {
      if (1 == paramNetworkInfo.getType()) {
        return 1;
      }
      int i = j;
      if (paramNetworkInfo.getType() == 0)
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        i = j;
        if (paramContext != null)
        {
          i = paramContext.getNetworkType();
          switch (i)
          {
          default: 
            return 17;
          case 10: 
            return 7;
          case 9: 
            return 6;
          case 8: 
            return 5;
          case 7: 
            return 11;
          case 6: 
            return 10;
          case 5: 
            return 9;
          case 4: 
            return 8;
          case 3: 
            return 4;
          case 2: 
            return 3;
          }
          i = 2;
        }
      }
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static void l(Context paramContext)
  {
    String str = null;
    try
    {
      localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    }
    catch (NullPointerException localNullPointerException)
    {
      NetworkInfo localNetworkInfo;
      label18:
      int i;
      break label18;
    }
    localNetworkInfo = null;
    i = -1;
    try
    {
      og = 0;
      om = 4;
      if (localNetworkInfo != null)
      {
        i = localNetworkInfo.getType();
        str = localNetworkInfo.getExtraInfo();
        if (str == null) {
          og = 0;
        } else {
          str = str.trim().toLowerCase();
        }
      }
      if (i == 1)
      {
        og = 4;
        ok = false;
        om = 3;
        on = "unknown";
        oo = 9;
      }
      else
      {
        M(str);
        if (str == null) {}
        for (;;)
        {
          og = 0;
          break label256;
          if ((str.contains("cmwap")) || (str.contains("uniwap")) || (str.contains("3gwap")) || (str.contains("ctwap"))) {
            break label235;
          }
          if ((str.contains("cmnet")) || (str.contains("uninet")) || (str.contains("3gnet")) || (str.contains("ctnet"))) {
            break;
          }
          if (str.contains("#777")) {
            om = 2;
          }
        }
        om = 1;
        if ((str.contains("3gnet")) || (str.contains("ctnet"))) {
          om = 2;
        }
        og = 1;
        break label256;
        label235:
        om = 1;
        if (str.contains("3gwap")) {
          om = 2;
        }
        og = 2;
        label256:
        ok = false;
        if (M(og))
        {
          oh = Proxy.getDefaultHost();
          oi = Proxy.getDefaultPort();
          if (oh != null) {
            oh = oh.trim();
          }
          if ((oh != null) && (!"".equals(oh)))
          {
            ok = true;
            og = 2;
            if ("10.0.0.200".equals(oh)) {
              oj = 1;
            } else {
              oj = 0;
            }
          }
          else
          {
            ok = false;
            og = 1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      label354:
      break label354;
    }
    op = a(paramContext, localNetworkInfo);
  }
  
  public static void n(Context paramContext)
  {
    if (ol) {
      return;
    }
    try
    {
      if (ol) {
        return;
      }
      l(paramContext);
      ol = true;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ei
 * JD-Core Version:    0.7.0.1
 */