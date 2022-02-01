package com.tencent.token;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.token.global.RqdApplication;

public final class xl
{
  static Context a;
  static boolean b = false;
  static String c;
  static final Object d = new Object();
  
  public static Context a()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return null;
    }
    Context localContext2 = kx.b;
    Context localContext1 = localContext2;
    if (localContext2 == null) {
      localContext1 = a;
    }
    return localContext1;
  }
  
  @SuppressLint({"MissingPermission"})
  static kx.a a(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        kx.a locala;
        if ((paramString.contains("getDeviceId")) || (paramString.contains("getImei")) || (paramString.contains("getMeid")))
        {
          ??? = Thread.currentThread().getStackTrace();
          int j = ???.length;
          i = 0;
          if (i < j)
          {
            locala = ???[i];
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(locala.getFileName());
            localStringBuilder.append("||");
            localStringBuilder.append(locala.getClassName());
            localStringBuilder.append("||");
            localStringBuilder.append(locala.getMethodName());
            if (!localStringBuilder.toString().contains("com.tencent.halley")) {
              break label503;
            }
            paramString = new kx.a();
            paramString.b = true;
            paramString.a = "";
            return paramString;
          }
        }
        if ("getDeviceId".equals(paramString))
        {
          locala = new kx.a();
          synchronized (d)
          {
            if (b)
            {
              paramString = c;
            }
            else
            {
              try
              {
                paramString = ((TelephonyManager)RqdApplication.c().getSystemService("phone")).getDeviceId();
              }
              catch (Exception paramString)
              {
                auq.a("get imei err", paramString);
                paramString = null;
              }
              c = paramString;
              b = true;
            }
            locala.b = true;
            locala.a = paramString;
            return locala;
          }
        }
        if (paramString.contains("getConnectionInfo"))
        {
          paramString = new StringBuilder("getConnectionInfo, sAllowWifiScanResultOptionForce[");
          paramString.append(xp.b);
          paramString.append("]");
          if (((xp.a) || (xp.b)) && (rw.a().b())) {
            return null;
          }
          b();
          paramString = new kx.a();
          paramString.b = true;
          return paramString;
        }
        if (paramString.contains("listen"))
        {
          if ((xp.a) && (rw.a().b())) {
            return null;
          }
          b();
          paramString = new kx.a();
          paramString.b = true;
          return paramString;
        }
        if ((paramString.compareTo("getScanResults") != 0) && (paramString.compareTo("getConfiguredNetworks") != 0)) {
          if (paramString.compareTo("startScan") != 0) {
            break;
          }
        }
        ??? = new StringBuilder("getWifiListOption[");
        ((StringBuilder)???).append(rw.a().b());
        ((StringBuilder)???).append("]");
        ??? = new StringBuilder("wifi list Force[");
        ((StringBuilder)???).append(xp.b);
        ((StringBuilder)???).append("]");
        if (!rw.a().a.a("kiawl", false))
        {
          if (xp.b) {
            return null;
          }
          ??? = new kx.a();
          ((kx.a)???).a = null;
          ((kx.a)???).b = true;
          if (paramString.compareTo("startScan") == 0) {
            ((kx.a)???).a = Boolean.FALSE;
          }
          return ???;
        }
        return null;
      }
      catch (Throwable paramString)
      {
        return null;
      }
      label503:
      i += 1;
    }
    return null;
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i < 21) {
        return;
      }
      Object localObject = a;
      if (localObject != null) {
        return;
      }
      a = paramContext;
      kx.a = new kv()
      {
        public final boolean a()
        {
          boolean bool = rw.a().b();
          StringBuilder localStringBuilder = new StringBuilder("isAllow:[");
          localStringBuilder.append(bool);
          localStringBuilder.append("]");
          return bool;
        }
        
        public final boolean b()
        {
          StringBuilder localStringBuilder = new StringBuilder("SysInvokeControlerService.sAllowLocation:[");
          localStringBuilder.append(xp.a);
          localStringBuilder.append("]");
          return (xp.a) && (rw.a().b());
        }
      };
      localObject = new kw()
      {
        public final kx.a a(String paramAnonymousString)
        {
          return xl.a(paramAnonymousString);
        }
      };
      ajh.f.a.a = ((kw)localObject);
      if (rw.a().b())
      {
        kx.a(paramContext, 28L);
        return;
      }
      kx.a(paramContext, 30L);
      return;
    }
    finally {}
  }
  
  @SuppressLint({"LongLogTag"})
  private static void b()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localStackTraceElement.getFileName());
      localStringBuilder.append("||");
      localStringBuilder.append(localStackTraceElement.getClassName());
      localStringBuilder.append("||");
      localStringBuilder.append(localStackTraceElement.getMethodName());
      localStringBuilder.append("||");
      localStringBuilder.append(localStackTraceElement.getLineNumber());
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xl
 * JD-Core Version:    0.7.0.1
 */