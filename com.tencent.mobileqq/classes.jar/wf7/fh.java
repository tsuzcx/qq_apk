package wf7;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;

public class fh
{
  public static int pO = 4;
  public static String pP = null;
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
    if (paramString == null) {}
    do
    {
      return;
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
    } while (!paramString.contains("#777"));
    pV = "#777";
    pW = 8;
  }
  
  private static int a(Context paramContext, NetworkInfo paramNetworkInfo)
  {
    int i = 1;
    if (paramNetworkInfo == null) {
      return 0;
    }
    try
    {
      if (1 != paramNetworkInfo.getType()) {
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
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      i = 0;
    }
    return i;
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
    }
    finally {}
    n(paramContext);
    pT = true;
  }
  
  public static void n(Context paramContext)
  {
    String str = null;
    try
    {
      NetworkInfo localNetworkInfo = fi.getActiveNetworkInfo();
      int i = -1;
      try
      {
        pO = 0;
        pU = 4;
        if (localNetworkInfo != null)
        {
          i = localNetworkInfo.getType();
          str = localNetworkInfo.getExtraInfo();
          if (str != null) {
            break label80;
          }
          pO = 0;
        }
        if (i != 1) {
          break label91;
        }
        pO = 4;
        pS = false;
        pU = 3;
        pV = "unknown";
        pW = 9;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject;
          localException.printStackTrace();
          continue;
          if ((localException.contains("cmwap")) || (localException.contains("uniwap")) || (localException.contains("3gwap")) || (localException.contains("ctwap")))
          {
            pU = 1;
            if (localException.contains("3gwap")) {
              pU = 2;
            }
            pO = 2;
          }
          else if ((localException.contains("cmnet")) || (localException.contains("uninet")) || (localException.contains("3gnet")) || (localException.contains("ctnet")))
          {
            pU = 1;
            if ((localException.contains("3gnet")) || (localException.contains("ctnet"))) {
              pU = 2;
            }
            pO = 1;
          }
          else if (localException.contains("#777"))
          {
            pU = 2;
            pO = 0;
          }
          else
          {
            pO = 0;
            continue;
            pR = 0;
            continue;
            pS = false;
            pO = 1;
          }
        }
      }
      pX = a(paramContext, localNetworkInfo);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        localObject = null;
        continue;
        label80:
        str = str.trim().toLowerCase();
        continue;
        label91:
        H(str);
        if (str != null) {
          break;
        }
        pO = 0;
        pS = false;
        if (ap(pO))
        {
          pP = Proxy.getDefaultHost();
          pQ = Proxy.getDefaultPort();
          if (pP != null) {
            pP = pP.trim();
          }
          if ((pP == null) || ("".equals(pP))) {
            break label357;
          }
          pS = true;
          pO = 2;
          if (!"10.0.0.200".equals(pP)) {
            break label350;
          }
          pR = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.fh
 * JD-Core Version:    0.7.0.1
 */