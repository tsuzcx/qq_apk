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
import android.util.Log;
import java.lang.reflect.Method;

public class i
{
  private static boolean Q = false;
  private static j R = null;
  private static j S = null;
  private static j T = null;
  private static j U = null;
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
    }
    String str;
    do
    {
      return;
      R = new j(ad, 0, null);
      paramContext.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, R);
      return;
      S = new j(ad, 1, paramString);
      paramContext.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + paramString), false, S);
      return;
      T = new j(ad, 2, paramString);
      paramContext.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + paramString), false, T);
      str = paramContext.getPackageName();
    } while (str.equals(paramString));
    U = new j(ad, 2, str);
    paramContext.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), false, U);
  }
  
  /* Error */
  public static i c(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 63	btmsdkobf/i:ad	Lbtmsdkobf/i;
    //   3: ifnonnull +32 -> 35
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 63	btmsdkobf/i:ad	Lbtmsdkobf/i;
    //   12: ifnonnull +20 -> 32
    //   15: aload_0
    //   16: invokevirtual 123	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: putstatic 125	btmsdkobf/i:mContext	Landroid/content/Context;
    //   22: new 2	btmsdkobf/i
    //   25: dup
    //   26: invokespecial 126	btmsdkobf/i:<init>	()V
    //   29: putstatic 63	btmsdkobf/i:ad	Lbtmsdkobf/i;
    //   32: ldc 2
    //   34: monitorexit
    //   35: getstatic 65	btmsdkobf/i:ae	Lbtmsdkobf/h;
    //   38: ifnonnull +41 -> 79
    //   41: ldc 2
    //   43: monitorenter
    //   44: getstatic 65	btmsdkobf/i:ae	Lbtmsdkobf/h;
    //   47: ifnonnull +29 -> 76
    //   50: aload_0
    //   51: invokevirtual 123	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   54: putstatic 125	btmsdkobf/i:mContext	Landroid/content/Context;
    //   57: invokestatic 129	btmsdkobf/i:e	()V
    //   60: new 131	btmsdkobf/h
    //   63: dup
    //   64: getstatic 125	btmsdkobf/i:mContext	Landroid/content/Context;
    //   67: invokespecial 134	btmsdkobf/h:<init>	(Landroid/content/Context;)V
    //   70: putstatic 65	btmsdkobf/i:ae	Lbtmsdkobf/h;
    //   73: invokestatic 137	btmsdkobf/i:h	()V
    //   76: ldc 2
    //   78: monitorexit
    //   79: getstatic 63	btmsdkobf/i:ad	Lbtmsdkobf/i;
    //   82: areturn
    //   83: astore_0
    //   84: ldc 2
    //   86: monitorexit
    //   87: aload_0
    //   88: athrow
    //   89: astore_0
    //   90: ldc 2
    //   92: monitorexit
    //   93: aload_0
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   9	32	83	finally
    //   32	35	83	finally
    //   84	87	83	finally
    //   44	76	89	finally
    //   76	79	89	finally
    //   90	93	89	finally
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
    W = new HandlerThread("SqlWorkThread");
    W.start();
    X = new Handler(W.getLooper())
    {
      public void handleMessage(Message arg1)
      {
        if (???.what == 11)
        {
          int i = ???.getData().getInt("type");
          ??? = ???.getData().getString("appid");
          try
          {
            i.d(i.i().a(i, ???));
            Log.e("VMS_IDLG_SDK_Client", "message type valid");
          }
          catch (Exception ???)
          {
            synchronized (i.j())
            {
              i.j().notify();
              return;
              ??? = ???;
              Log.e("VMS_IDLG_SDK_Client", "readException:" + ???.toString());
              ???.printStackTrace();
            }
          }
        }
      }
    };
  }
  
  public static String getProperty(String paramString1, String paramString2)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
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
          if (SystemClock.uptimeMillis() - l >= 2000L) {
            break label178;
          }
          switch (paramInt)
          {
          case 3: 
            return;
          }
        }
        catch (InterruptedException paramString)
        {
          paramString.printStackTrace();
          continue;
        }
      }
      Z = Y;
      Y = null;
      continue;
      if (Y != null)
      {
        aa = Y;
        Y = null;
      }
      else
      {
        Log.e("VMS_IDLG_SDK_Client", "get vaid failed");
        continue;
        if (Y != null)
        {
          ab = Y;
          Y = null;
        }
        for (;;)
        {
          ac = Y;
          Y = null;
          break;
          Log.e("VMS_IDLG_SDK_Client", "get aaid failed");
        }
        label178:
        Log.d("VMS_IDLG_SDK_Client", "query timeout");
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
    if (Z != null) {
      return Z;
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