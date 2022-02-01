package com.tencent.token;

import android.net.NetworkInfo;
import android.net.Proxy;

public class apa
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
  
  public static void a()
  {
    if (f) {
      return;
    }
    for (;;)
    {
      try
      {
        if (f) {
          return;
        }
        String str = null;
        Object localObject2;
        try
        {
          NetworkInfo localNetworkInfo = aow.a().a();
        }
        catch (NullPointerException localNullPointerException)
        {
          new StringBuilder(" getActiveNetworkInfo NullPointerException--- \n").append(localNullPointerException.getMessage());
          localObject2 = null;
        }
        new StringBuilder("networkInfo : ").append(localObject2);
        j = -1;
        try
        {
          a = 0;
          g = 4;
          if (localObject2 != null)
          {
            j = localObject2.getType();
            new StringBuilder("type: ").append(localObject2.getType());
            new StringBuilder("typeName: ").append(localObject2.getTypeName());
            str = localObject2.getExtraInfo();
            if (str == null) {
              a = 0;
            } else {
              str = str.trim().toLowerCase();
            }
          }
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
            if (str != null) {
              if (str.contains("cmwap"))
              {
                h = "cmwap";
                i = 0;
              }
              else if (str.contains("cmnet"))
              {
                h = "cmnet";
                i = 1;
              }
              else if (str.contains("3gwap"))
              {
                h = "3gwap";
                i = 2;
              }
              else if (str.contains("3gnet"))
              {
                h = "3gnet";
                i = 3;
              }
              else if (str.contains("uniwap"))
              {
                h = "uniwap";
                i = 4;
              }
              else if (str.contains("uninet"))
              {
                h = "uninet";
                i = 5;
              }
              else if (str.contains("ctwap"))
              {
                h = "ctwap";
                i = 6;
              }
              else if (str.contains("ctnet"))
              {
                h = "ctnet";
                i = 7;
              }
              else if (str.contains("#777"))
              {
                h = "#777";
                i = 8;
              }
            }
            if (str != null) {
              if ((!str.contains("cmwap")) && (!str.contains("uniwap")) && (!str.contains("3gwap")) && (!str.contains("ctwap")))
              {
                if ((!str.contains("cmnet")) && (!str.contains("uninet")) && (!str.contains("3gnet")) && (!str.contains("ctnet")))
                {
                  if (str.contains("#777")) {
                    g = 2;
                  }
                }
                else
                {
                  g = 1;
                  if ((str.contains("3gnet")) || (str.contains("ctnet"))) {
                    g = 2;
                  }
                  a = 1;
                  continue;
                }
              }
              else
              {
                g = 1;
                if (str.contains("3gwap")) {
                  g = 2;
                }
                a = 2;
                continue;
              }
            }
            a = 0;
            e = false;
            j = a;
            if (j == 2) {
              break label791;
            }
            if (j != 0) {
              break label786;
            }
            break label791;
            if (j != 0)
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
          new StringBuilder("NETWORK_TYPE : ").append(g);
          new StringBuilder("M_APN_TYPE : ").append(a);
          new StringBuilder("M_USE_PROXY : ").append(e);
          new StringBuilder("M_APN_PROXY : ").append(b);
          new StringBuilder("M_APN_PORT : ").append(c);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        StringBuilder localStringBuilder = new StringBuilder("init() Apn.APN_NAME_VALUE: ");
        localStringBuilder.append(i);
        localStringBuilder.append(" APN_NAME_DRI: ");
        localStringBuilder.append(h);
        localStringBuilder.append(" NETWORK_TYPE: ");
        localStringBuilder.append(g);
        f = true;
        return;
      }
      finally {}
      label786:
      int j = 0;
      continue;
      label791:
      j = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.apa
 * JD-Core Version:    0.7.0.1
 */