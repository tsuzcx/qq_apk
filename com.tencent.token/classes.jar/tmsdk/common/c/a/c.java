package tmsdk.common.c.a;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;

public class c
{
  public static int a = 4;
  public static String b;
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
      b(paramContext);
      f = true;
      return;
    }
    finally {}
  }
  
  private static void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
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
    if (paramString.contains("#777"))
    {
      h = "#777";
      i = 8;
    }
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 0);
  }
  
  public static void b(Context paramContext)
  {
    paramContext = null;
    Object localObject;
    try
    {
      NetworkInfo localNetworkInfo = tmsdk.common.b.a().a();
    }
    catch (NullPointerException localNullPointerException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getActiveNetworkInfo NullPointerException--- \n");
      localStringBuilder.append(localNullPointerException.getMessage());
      localStringBuilder.toString();
      localObject = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("networkInfo : ");
    localStringBuilder.append(localObject);
    localStringBuilder.toString();
    int j = -1;
    try
    {
      a = 0;
      g = 4;
      if (localObject != null)
      {
        j = ((NetworkInfo)localObject).getType();
        paramContext = new StringBuilder();
        paramContext.append("type: ");
        paramContext.append(((NetworkInfo)localObject).getType());
        paramContext.toString();
        paramContext = new StringBuilder();
        paramContext.append("typeName: ");
        paramContext.append(((NetworkInfo)localObject).getTypeName());
        paramContext.toString();
        paramContext = ((NetworkInfo)localObject).getExtraInfo();
        if (paramContext == null) {
          a = 0;
        } else {
          paramContext = paramContext.trim().toLowerCase();
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("extraInfo : ");
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).toString();
      if (j == 1)
      {
        a = 4;
        e = false;
        g = 3;
        h = "unknown";
        i = 9;
      }
      else
      {
        a(paramContext);
        if (paramContext == null)
        {
          a = 0;
        }
        else if ((!paramContext.contains("cmwap")) && (!paramContext.contains("uniwap")) && (!paramContext.contains("3gwap")) && (!paramContext.contains("ctwap")))
        {
          if ((!paramContext.contains("cmnet")) && (!paramContext.contains("uninet")) && (!paramContext.contains("3gnet")) && (!paramContext.contains("ctnet")))
          {
            if (paramContext.contains("#777"))
            {
              g = 2;
              a = 0;
            }
            else
            {
              a = 0;
            }
          }
          else
          {
            g = 1;
            if ((paramContext.contains("3gnet")) || (paramContext.contains("ctnet"))) {
              g = 2;
            }
            a = 1;
          }
        }
        else
        {
          g = 1;
          if (paramContext.contains("3gwap")) {
            g = 2;
          }
          a = 2;
        }
        e = false;
        if (a(a))
        {
          b = Proxy.getDefaultHost();
          c = Proxy.getDefaultPort();
          if (b != null) {
            b = b.trim();
          }
          if ((b != null) && (!"".equals(b)))
          {
            e = true;
            a = 2;
            if ("10.0.0.200".equals(b)) {
              d = 1;
            } else {
              d = 0;
            }
          }
          else
          {
            e = false;
            a = 1;
          }
        }
      }
      paramContext = new StringBuilder();
      paramContext.append("NETWORK_TYPE : ");
      paramContext.append(g);
      paramContext.toString();
      paramContext = new StringBuilder();
      paramContext.append("M_APN_TYPE : ");
      paramContext.append(a);
      paramContext.toString();
      paramContext = new StringBuilder();
      paramContext.append("M_USE_PROXY : ");
      paramContext.append(e);
      paramContext.toString();
      paramContext = new StringBuilder();
      paramContext.append("M_APN_PROXY : ");
      paramContext.append(b);
      paramContext.toString();
      paramContext = new StringBuilder();
      paramContext.append("M_APN_PORT : ");
      paramContext.append(c);
      paramContext.toString();
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    paramContext = new StringBuilder();
    paramContext.append("init() Apn.APN_NAME_VALUE: ");
    paramContext.append(i);
    paramContext.append(" APN_NAME_DRI: ");
    paramContext.append(h);
    paramContext.append(" NETWORK_TYPE: ");
    paramContext.append(g);
    paramContext.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.c.a.c
 * JD-Core Version:    0.7.0.1
 */