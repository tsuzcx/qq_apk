package btmsdkobf;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.lang.reflect.Method;

public class i
{
  private static boolean Q = false;
  private static j R;
  private static j S;
  private static j T;
  private static j U;
  private static Object V = new Object();
  private static HandlerThread W = null;
  private static Handler X = null;
  private static String Y = null;
  private static String Z = null;
  private static String aa = null;
  private static String ab = null;
  private static String ac = null;
  private static volatile i ad = null;
  private static volatile h ae = null;
  private static Context mContext;
  
  private static void a(Context paramContext, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
    case 2: 
      T = new j(ad, 2, paramString);
      paramContext.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_".concat(String.valueOf(paramString))), false, T);
      String str = paramContext.getPackageName();
      if (!str.equals(paramString))
      {
        U = new j(ad, 2, str);
        paramContext.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_".concat(String.valueOf(str))), false, U);
        return;
      }
      break;
    case 1: 
      S = new j(ad, 1, paramString);
      paramContext.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_".concat(String.valueOf(paramString))), false, S);
      return;
    case 0: 
      R = new j(ad, 0, null);
      paramContext.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, R);
      return;
    }
  }
  
  public static i c(Context paramContext)
  {
    if (ad == null) {
      try
      {
        if (ad == null)
        {
          mContext = paramContext.getApplicationContext();
          ad = new i();
        }
      }
      finally {}
    }
    if (ae == null) {
      try
      {
        if (ae == null)
        {
          mContext = paramContext.getApplicationContext();
          e();
          ae = new h(mContext);
          h();
        }
      }
      finally {}
    }
    return ad;
  }
  
  private void c(int paramInt, String paramString)
  {
    Message localMessage = X.obtainMessage();
    localMessage.what = 11;
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt);
    if ((paramInt == 1) || (paramInt == 2)) {
      localBundle.putString("appid", paramString);
    }
    localMessage.setData(localBundle);
    X.sendMessage(localMessage);
  }
  
  private static void e()
  {
    HandlerThread localHandlerThread = new HandlerThread("SqlWorkThread");
    W = localHandlerThread;
    localHandlerThread.start();
    X = new Handler(W.getLooper())
    {
      public final void handleMessage(Message arg1)
      {
        if (???.what == 11)
        {
          int i = ???.getData().getInt("type");
          ??? = ???.getData().getString("appid");
          try
          {
            i.d(i.i().a(i, ???));
          }
          catch (Exception ???)
          {
            new StringBuilder("readException:").append(???.toString());
            ???.printStackTrace();
          }
          synchronized (i.j())
          {
            i.j().notify();
            return;
          }
        }
      }
    };
  }
  
  public static String getProperty(String paramString1, String paramString2)
  {
    try
    {
      Class localClass = Class.forName("com.tencent.token.bi");
      paramString1 = (String)localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { paramString1, "unknown" });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1 = paramString1;
      paramString1.printStackTrace();
      return paramString2;
    }
    finally {}
    return paramString2;
  }
  
  public static void h()
  {
    Q = "1".equals(getProperty("persist.sys.identifierid.supported", "0"));
  }
  
  public void b(int paramInt, String paramString)
  {
    for (;;)
    {
      synchronized (V)
      {
        c(paramInt, paramString);
        long l = SystemClock.uptimeMillis();
        try
        {
          V.wait(2000L);
        }
        catch (InterruptedException paramString)
        {
          paramString.printStackTrace();
        }
        if (SystemClock.uptimeMillis() - l < 2000L) {
          if (paramInt == 4) {}
        }
        switch (paramInt)
        {
        case 2: 
          if (Y != null)
          {
            ab = Y;
            Y = null;
          }
          break;
        case 1: 
          if (Y != null)
          {
            aa = Y;
            Y = null;
          }
          break;
        case 0: 
          Z = Y;
          Y = null;
          continue;
          ac = Y;
          Y = null;
          return;
        }
      }
    }
  }
  
  public boolean f()
  {
    return Q;
  }
  
  public String g()
  {
    if (!f()) {
      return null;
    }
    String str = Z;
    if (str != null) {
      return str;
    }
    b(0, null);
    if (R == null) {
      a(mContext, 0, null);
    }
    return Z;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.i
 * JD-Core Version:    0.7.0.1
 */