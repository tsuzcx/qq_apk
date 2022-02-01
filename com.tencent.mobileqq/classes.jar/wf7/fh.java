package wf7;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;

public class fh
{
  public static int pO = 4;
  public static String pP;
  public static int pQ = 80;
  public static byte pR = 0;
  public static boolean pS = false;
  public static boolean pT = false;
  public static byte pU = 4;
  public static String pV = "unknown";
  public static byte pW = 9;
  public static int pX = 17;
  
  private static void H(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (paramString.contains("cmwap"))
    {
      pV = "cmwap";
      pW = 0;
      return;
    }
    if (paramString.contains("cmnet"))
    {
      pV = "cmnet";
      pW = 1;
      return;
    }
    if (paramString.contains("3gwap"))
    {
      pV = "3gwap";
      pW = 2;
      return;
    }
    if (paramString.contains("3gnet"))
    {
      pV = "3gnet";
      pW = 3;
      return;
    }
    if (paramString.contains("uniwap"))
    {
      pV = "uniwap";
      pW = 4;
      return;
    }
    if (paramString.contains("uninet"))
    {
      pV = "uninet";
      pW = 5;
      return;
    }
    if (paramString.contains("ctwap"))
    {
      pV = "ctwap";
      pW = 6;
      return;
    }
    if (paramString.contains("ctnet"))
    {
      pV = "ctnet";
      pW = 7;
      return;
    }
    if (paramString.contains("#777"))
    {
      pV = "#777";
      pW = 8;
    }
  }
  
  private static int a(Context paramContext, NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {
      return 0;
    }
    try
    {
      if (1 == paramNetworkInfo.getType()) {
        return 1;
      }
      if (paramNetworkInfo.getType() == 0)
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null)
        {
          int i = paramContext.getNetworkType();
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
          return 2;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  private static boolean ap(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 0);
  }
  
  public static void m(Context paramContext)
  {
    if (pT) {
      return;
    }
    try
    {
      if (pT) {
        return;
      }
      n(paramContext);
      pT = true;
      return;
    }
    finally {}
  }
  
  public static void n(Context paramContext)
  {
    String str = null;
    try
    {
      localNetworkInfo = fi.getActiveNetworkInfo();
    }
    catch (NullPointerException localNullPointerException)
    {
      NetworkInfo localNetworkInfo;
      label10:
      int i;
      break label10;
    }
    localNetworkInfo = null;
    i = -1;
    try
    {
      pO = 0;
      pU = 4;
      if (localNetworkInfo != null)
      {
        i = localNetworkInfo.getType();
        str = localNetworkInfo.getExtraInfo();
        if (str == null) {
          pO = 0;
        } else {
          str = str.trim().toLowerCase();
        }
      }
      if (i == 1)
      {
        pO = 4;
        pS = false;
        pU = 3;
        pV = "unknown";
        pW = 9;
      }
      else
      {
        H(str);
        if (str == null)
        {
          pO = 0;
        }
        else
        {
          boolean bool = str.contains("cmwap");
          if ((!bool) && (!str.contains("uniwap")) && (!str.contains("3gwap")) && (!str.contains("ctwap")))
          {
            bool = str.contains("cmnet");
            if ((!bool) && (!str.contains("uninet")) && (!str.contains("3gnet")) && (!str.contains("ctnet")))
            {
              if (str.contains("#777"))
              {
                pU = 2;
                pO = 0;
              }
              else
              {
                pO = 0;
              }
            }
            else
            {
              pU = 1;
              if ((str.contains("3gnet")) || (str.contains("ctnet"))) {
                pU = 2;
              }
              pO = 1;
            }
          }
          else
          {
            pU = 1;
            if (str.contains("3gwap")) {
              pU = 2;
            }
            pO = 2;
          }
        }
        pS = false;
        if (ap(pO))
        {
          pP = Proxy.getDefaultHost();
          pQ = Proxy.getDefaultPort();
          if (pP != null) {
            pP = pP.trim();
          }
          if ((pP != null) && (!"".equals(pP)))
          {
            pS = true;
            pO = 2;
            if ("10.0.0.200".equals(pP)) {
              pR = 1;
            } else {
              pR = 0;
            }
          }
          else
          {
            pS = false;
            pO = 1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    pX = a(paramContext, localNetworkInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.fh
 * JD-Core Version:    0.7.0.1
 */