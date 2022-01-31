package btmsdkobf;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;

public class ei
{
  public static int og = 4;
  public static String oh = null;
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
    if (paramString == null) {}
    do
    {
      return;
      if (paramString.contains("cmwap"))
      {
        on = "cmwap";
        oo = 0;
        return;
      }
      if (paramString.contains("cmnet"))
      {
        on = "cmnet";
        oo = 1;
        return;
      }
      if (paramString.contains("3gwap"))
      {
        on = "3gwap";
        oo = 2;
        return;
      }
      if (paramString.contains("3gnet"))
      {
        on = "3gnet";
        oo = 3;
        return;
      }
      if (paramString.contains("uniwap"))
      {
        on = "uniwap";
        oo = 4;
        return;
      }
      if (paramString.contains("uninet"))
      {
        on = "uninet";
        oo = 5;
        return;
      }
      if (paramString.contains("ctwap"))
      {
        on = "ctwap";
        oo = 6;
        return;
      }
      if (paramString.contains("ctnet"))
      {
        on = "ctnet";
        oo = 7;
        return;
      }
    } while (!paramString.contains("#777"));
    on = "#777";
    oo = 8;
  }
  
  private static boolean M(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 0);
  }
  
  private static int a(Context paramContext, NetworkInfo paramNetworkInfo)
  {
    int i = 1;
    if (paramNetworkInfo == null) {
      return 0;
    }
    try
    {
      if (1 == paramNetworkInfo.getType()) {
        return i;
      }
      if (paramNetworkInfo.getType() == 0)
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null)
        {
          i = paramContext.getNetworkType();
          switch (i)
          {
          default: 
            i = 17;
            break;
          case 1: 
            i = 2;
            break;
          case 2: 
            i = 3;
            break;
          case 3: 
            i = 4;
            break;
          case 8: 
            i = 5;
            break;
          case 9: 
            i = 6;
            break;
          case 10: 
            i = 7;
            break;
          case 4: 
            i = 8;
            break;
          case 5: 
            i = 9;
            break;
          case 6: 
            i = 10;
            break;
          case 7: 
            i = 11;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      i = 0;
    }
    i = 0;
    return i;
  }
  
  public static void l(Context paramContext)
  {
    try
    {
      localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      try
      {
        og = 0;
        om = 4;
        if (localNetworkInfo == null) {
          break label365;
        }
        i = localNetworkInfo.getType();
        String str1 = localNetworkInfo.getExtraInfo();
        if (str1 != null) {
          break label85;
        }
        og = 0;
        if (i != 1) {
          break label96;
        }
        og = 4;
        ok = false;
        om = 3;
        on = "unknown";
        oo = 9;
      }
      catch (Exception localException)
      {
        int i;
        label70:
        String str2;
        break label70;
      }
      op = a(paramContext, localNetworkInfo);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        NetworkInfo localNetworkInfo = null;
        continue;
        label85:
        str2 = localNullPointerException.trim().toLowerCase();
        continue;
        label96:
        M(str2);
        if (str2 == null) {
          og = 0;
        }
        for (;;)
        {
          ok = false;
          if (!M(og)) {
            break;
          }
          oh = Proxy.getDefaultHost();
          oi = Proxy.getDefaultPort();
          if (oh != null) {
            oh = oh.trim();
          }
          if ((oh == null) || ("".equals(oh))) {
            break label354;
          }
          ok = true;
          og = 2;
          if (!"10.0.0.200".equals(oh)) {
            break label347;
          }
          oj = 1;
          break;
          if ((str2.contains("cmwap")) || (str2.contains("uniwap")) || (str2.contains("3gwap")) || (str2.contains("ctwap")))
          {
            om = 1;
            if (str2.contains("3gwap")) {
              om = 2;
            }
            og = 2;
          }
          else if ((str2.contains("cmnet")) || (str2.contains("uninet")) || (str2.contains("3gnet")) || (str2.contains("ctnet")))
          {
            om = 1;
            if ((str2.contains("3gnet")) || (str2.contains("ctnet"))) {
              om = 2;
            }
            og = 1;
          }
          else if (str2.contains("#777"))
          {
            om = 2;
            og = 0;
          }
          else
          {
            og = 0;
          }
        }
        label347:
        oj = 0;
        continue;
        label354:
        ok = false;
        og = 1;
        continue;
        label365:
        i = -1;
        str2 = null;
      }
    }
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
    }
    finally {}
    l(paramContext);
    ol = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ei
 * JD-Core Version:    0.7.0.1
 */