package com.tencent.mobileqq.msf.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
{
  static INetInfoHandler a;
  static boolean b = false;
  static String c = "";
  static String d = "";
  static BroadcastReceiver e = new c();
  private static String f = "MSF.D.AppNetInfoImpl";
  private static final String g = "http://3gimg.qq.com/ping.html";
  private static int h = 0;
  private static AtomicBoolean i = new AtomicBoolean(false);
  private static final byte j = 0;
  private static final byte k = 1;
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "NONE";
    case 1: 
      return "MOBILE";
    case 2: 
      return "WiFi";
    }
    return "WiFi";
  }
  
  public static void a()
    throws Exception
  {
    Object localObject = (HttpURLConnection)new URL("http://3gimg.qq.com/ping.html").openConnection();
    ((HttpURLConnection)localObject).setDoOutput(true);
    ((HttpURLConnection)localObject).setDoInput(true);
    ((HttpURLConnection)localObject).setRequestMethod("GET");
    ((HttpURLConnection)localObject).setUseCaches(false);
    ((HttpURLConnection)localObject).setInstanceFollowRedirects(false);
    ((HttpURLConnection)localObject).setReadTimeout(60000);
    ((HttpURLConnection)localObject).connect();
    byte[] arrayOfByte = new byte[8];
    ((HttpURLConnection)localObject).getInputStream().read(arrayOfByte);
    ((HttpURLConnection)localObject).getInputStream().close();
    ((HttpURLConnection)localObject).disconnect();
    localObject = new String(arrayOfByte);
    if ("Poduct3G".equals(localObject))
    {
      a(true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(f, 2, "wifi ping resp content is " + (String)localObject);
    }
    b = true;
  }
  
  public static void a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    a(paramContext.getActiveNetworkInfo());
    paramContext = paramContext.getNetworkInfo(0);
    if (paramContext != null) {}
    try
    {
      c = paramContext.getExtraInfo();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.d(f, 1, "get currentAPN error " + paramContext);
    }
  }
  
  public static void a(Context paramContext, INetInfoHandler paramINetInfoHandler)
  {
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(e, localIntentFilter);
    a = paramINetInfoHandler;
  }
  
  public static void a(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo != null) {
      str = paramNetworkInfo.getTypeName();
    }
    while (!QLog.isColorLevel()) {
      try
      {
        String str;
        d = paramNetworkInfo.getSubtypeName();
        if (str.toLowerCase().contains("mobile_mms")) {
          return;
        }
      }
      catch (Exception localException)
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                QLog.d(f, 1, "get subtypeName error " + localException);
              }
              QLog.d(f, 1, "currentAPN:" + c + ". received networkInfo: " + paramNetworkInfo.getDetailedState() + " :" + paramNetworkInfo);
              if (paramNetworkInfo.getDetailedState() != NetworkInfo.DetailedState.CONNECTED) {
                break;
              }
              if (1 == paramNetworkInfo.getType())
              {
                k();
                return;
              }
            } while (!b(paramNetworkInfo));
            j();
            return;
          } while ((paramNetworkInfo.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED) && (paramNetworkInfo.getDetailedState() != NetworkInfo.DetailedState.FAILED) && (paramNetworkInfo.getDetailedState() != NetworkInfo.DetailedState.IDLE) && (paramNetworkInfo.getDetailedState() != NetworkInfo.DetailedState.SUSPENDED));
          if (1 == paramNetworkInfo.getType())
          {
            m();
            return;
          }
        } while (!b(paramNetworkInfo));
        l();
        return;
      }
    }
    QLog.d(f, 2, "currentAPN:" + c + ". NetworkInfo: " + paramNetworkInfo);
  }
  
  private static void a(boolean paramBoolean)
  {
    i.set(paramBoolean);
  }
  
  private static void b(int paramInt)
  {
    int n = 1;
    for (;;)
    {
      int m;
      try
      {
        if (h == paramInt)
        {
          if (QLog.isColorLevel()) {
            QLog.d(f, 2, "found repeat net event , now is " + b() + " now:" + paramInt + " last:" + h);
          }
          return;
        }
        if (paramInt <= 0) {
          break label170;
        }
        a(true);
        QLog.d(f, 1, "netchange " + a(h) + " to " + a(paramInt));
        if (paramInt != 1) {
          break label270;
        }
        if (h == 0) {
          break label260;
        }
        if (h != -2) {
          break label177;
        }
      }
      finally {}
      h = paramInt;
      if (m != -1)
      {
        c(m);
        continue;
        label170:
        a(false);
        continue;
        label177:
        m = n;
        if (h != 2)
        {
          m = n;
          if (h != 3)
          {
            for (;;)
            {
              label198:
              if ((h == 0) || (h == -2)) {
                break label283;
              }
              if (h == 1)
              {
                m = 3;
                break;
              }
              label260:
              label270:
              do
              {
                if (h == 1)
                {
                  m = 4;
                  break;
                }
                if (h != 2)
                {
                  m = h;
                  if (m != 3) {}
                }
                else
                {
                  m = 5;
                  break;
                  m = 0;
                  break;
                }
                m = -1;
                break;
                if (paramInt == 2) {
                  break label198;
                }
              } while (paramInt != 3);
            }
            label283:
            m = 2;
          }
        }
      }
    }
  }
  
  public static boolean b()
  {
    return i.get();
  }
  
  public static boolean b(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo.getType() == 0) || (50 == paramNetworkInfo.getType());
  }
  
  public static int c()
  {
    if (d())
    {
      if (b) {
        return 3;
      }
      return 2;
    }
    if (e()) {
      return 1;
    }
    return 0;
  }
  
  private static void c(int paramInt)
  {
    if (a != null)
    {
      b localb = new b(paramInt);
      localb.setName("notifyNetInfoChangeThread");
      localb.start();
    }
  }
  
  public static boolean d()
  {
    return (h == 2) || (h == 3);
  }
  
  public static boolean e()
  {
    return h == 1;
  }
  
  public static boolean f()
  {
    return b;
  }
  
  public static String g()
  {
    return c;
  }
  
  public static String h()
  {
    return d;
  }
  
  private static void j()
  {
    b(h | 0x1);
  }
  
  private static void k()
  {
    b(h | 0x2);
  }
  
  private static void l()
  {
    b(h & 0xFFFFFFFE);
  }
  
  private static void m()
  {
    b(h & 0xFFFFFFFD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.a
 * JD-Core Version:    0.7.0.1
 */