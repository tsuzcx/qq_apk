package com.tencent.token;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.tencent.halley.common.c;

public class cb
{
  public static String a;
  public static String b = "";
  private static final String c = cb.class.getSimpleName();
  private static String d = "cmwap";
  private static String e = "3gwap";
  private static String f = "uniwap";
  private static String g = "ctwap";
  private static String h;
  private static Context i;
  private static volatile boolean j;
  private static String k = "";
  private static String l = "";
  private static volatile int m = 0;
  private static int n = 0;
  private static volatile boolean o = false;
  private static String p = "";
  
  static
  {
    a = "nonetwork";
    h = "wifi";
    j = true;
  }
  
  public static String a()
  {
    for (;;)
    {
      try
      {
        switch (m)
        {
        case 1: 
          str = "unknown";
          return str;
        }
      }
      finally {}
      String str = "ssid_" + k + l;
      continue;
      str = "apn_" + b;
      continue;
      str = "4Gapn_" + b;
    }
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      i = paramContext;
      b();
      g();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  /* Error */
  public static boolean a(Integer paramInteger)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: iload_3
    //   6: istore_2
    //   7: aload_0
    //   8: invokevirtual 116	java/lang/Integer:intValue	()I
    //   11: iconst_1
    //   12: if_icmpeq +25 -> 37
    //   15: iload_3
    //   16: istore_2
    //   17: aload_0
    //   18: invokevirtual 116	java/lang/Integer:intValue	()I
    //   21: iconst_2
    //   22: if_icmpeq +15 -> 37
    //   25: aload_0
    //   26: invokevirtual 116	java/lang/Integer:intValue	()I
    //   29: istore_1
    //   30: iload_1
    //   31: iconst_3
    //   32: if_icmpne +10 -> 42
    //   35: iload_3
    //   36: istore_2
    //   37: ldc 2
    //   39: monitorexit
    //   40: iload_2
    //   41: ireturn
    //   42: iconst_0
    //   43: istore_2
    //   44: goto -7 -> 37
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	paramInteger	Integer
    //   29	4	1	i1	int
    //   6	38	2	bool1	boolean
    //   1	35	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   7	15	47	finally
    //   17	30	47	finally
  }
  
  public static void b()
  {
    for (;;)
    {
      int i1;
      try
      {
        c.b(c, "updateApn");
        localObject1 = ((ConnectivityManager)i.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localObject1 != null) {
          continue;
        }
        b = "";
        m = 0;
        o = false;
        p = "";
        j = false;
        b = a;
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        localThrowable.printStackTrace();
        continue;
      }
      finally {}
      return;
      if ((((NetworkInfo)localObject1).isAvailable()) && (((NetworkInfo)localObject1).isConnected()))
      {
        j = true;
        i1 = ((NetworkInfo)localObject1).getType();
        if (i1 == 1)
        {
          m = 1;
          o = false;
          p = "";
          localObject1 = ((WifiManager)i.getSystemService("wifi")).getConnectionInfo();
          k = ((WifiInfo)localObject1).getSSID();
          l = ((WifiInfo)localObject1).getBSSID();
          b = h;
        }
      }
      else
      {
        j = false;
        b = a;
        continue;
      }
      String str = localObject2.getExtraInfo();
      if (str == null)
      {
        b = "";
        m = 0;
        o = false;
        p = "";
      }
      else
      {
        b = str.trim().toLowerCase();
        if (i1 == 0)
        {
          i1 = localObject2.getSubtype();
          if ((i1 != 1) && (i1 != 2) && (i1 != 4)) {
            break label269;
          }
          m = 2;
        }
        for (;;)
        {
          n = h().intValue();
          if (!b.contains(e)) {
            break label289;
          }
          o = true;
          p = "10.0.0.172";
          break;
          label269:
          if (i1 == 13) {
            m = 4;
          } else {
            m = 3;
          }
        }
        label289:
        if (b.contains(d))
        {
          o = true;
          p = "10.0.0.172";
        }
        else if (b.contains(f))
        {
          o = true;
          p = "10.0.0.172";
        }
        else if (b.contains(g))
        {
          o = true;
          p = "10.0.0.200";
        }
        else
        {
          o = false;
          p = "";
        }
      }
    }
  }
  
  public static boolean c()
  {
    return m == 1;
  }
  
  public static int d()
  {
    try
    {
      int i1 = m;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int e()
  {
    try
    {
      int i1 = n;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean f()
  {
    return j;
  }
  
  private static void g()
  {
    try
    {
      c.b(c, "showApnInfo... Apn:" + b + ",sIsNetworkOk:" + j + ",sNetType:" + m + ",sIsProxy:" + o + ",sProxyAddress:" + p);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static Integer h()
  {
    int i3 = 3;
    int i2 = 2;
    int i1 = 1;
    for (;;)
    {
      Object localObject4;
      try
      {
        if (m == 1)
        {
          localObject1 = k;
          if ((localObject1 == null) || (((String)localObject1).length() <= 0))
          {
            localObject1 = Integer.valueOf(0);
            n = ((Integer)localObject1).intValue();
            i1 = n;
            return Integer.valueOf(i1);
          }
          localObject1 = ((String)localObject1).toLowerCase();
          if (!((String)localObject1).contains("cmcc")) {
            break label366;
          }
          if (!((String)localObject1).contains("chinanet")) {
            break label363;
          }
          i1 = i3;
          if (!((String)localObject1).contains("chinaunicom")) {
            break label360;
          }
          i1 = i2;
          localObject1 = Integer.valueOf(i1);
          continue;
        }
        if ((m != 2) && (m != 3)) {
          break label353;
        }
        localObject4 = i;
        Object localObject1 = b;
        localObject4 = (TelephonyManager)((Context)localObject4).getSystemService("phone");
        if ((localObject4 == null) || (((TelephonyManager)localObject4).getSimState() != 5)) {
          break label240;
        }
        localObject4 = ((TelephonyManager)localObject4).getSimOperator();
        if (((String)localObject4).length() <= 0) {
          break label240;
        }
        if ((((String)localObject4).equals("46000")) || (((String)localObject4).equals("46002")))
        {
          localObject1 = Integer.valueOf(1);
          n = ((Integer)localObject1).intValue();
          continue;
        }
        if (!((String)localObject4).equals("46001")) {
          break label222;
        }
      }
      finally {}
      Object localObject3 = Integer.valueOf(2);
      continue;
      label222:
      if (((String)localObject4).equals("46003"))
      {
        localObject3 = Integer.valueOf(3);
      }
      else
      {
        label240:
        if (localObject3 != null)
        {
          localObject3 = ((String)localObject3).toLowerCase();
          if ((((String)localObject3).contains("cmnet")) || (((String)localObject3).contains("cmwap")))
          {
            localObject3 = Integer.valueOf(1);
            continue;
          }
          if ((((String)localObject3).contains("uninet")) || (((String)localObject3).contains("uniwap")) || (((String)localObject3).contains("3gnet")) || (((String)localObject3).contains("3gwap")))
          {
            localObject3 = Integer.valueOf(2);
            continue;
          }
          if ((((String)localObject3).contains("ctnet")) || (((String)localObject3).contains("ctwap")))
          {
            localObject3 = Integer.valueOf(3);
            continue;
          }
        }
        localObject3 = Integer.valueOf(0);
        continue;
        label353:
        n = 0;
        continue;
        label360:
        continue;
        label363:
        continue;
        label366:
        i1 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cb
 * JD-Core Version:    0.7.0.1
 */