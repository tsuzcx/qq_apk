package com.tencent.token;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;

public final class xx
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
    Context localContext2 = ll.b;
    Context localContext1 = localContext2;
    if (localContext2 == null) {
      localContext1 = a;
    }
    return localContext1;
  }
  
  @SuppressLint({"MissingPermission"})
  static ll.a a(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        ll.a locala;
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
              break label480;
            }
            paramString = new ll.a();
            paramString.b = true;
            paramString.a = "";
            return paramString;
          }
        }
        if ("getDeviceId".equals(paramString))
        {
          locala = new ll.a();
          synchronized (d)
          {
            if (b)
            {
              paramString = c;
            }
            else
            {
              paramString = "00000000000042";
              c = "00000000000042";
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
          paramString.append(yb.b);
          paramString.append("]");
          if (((yb.a) || (yb.b)) && (sj.a().b())) {
            return null;
          }
          b();
          paramString = new ll.a();
          paramString.b = true;
          return paramString;
        }
        if (paramString.contains("listen"))
        {
          if ((yb.a) && (sj.a().b())) {
            return null;
          }
          b();
          paramString = new ll.a();
          paramString.b = true;
          return paramString;
        }
        if ((paramString.compareTo("getScanResults") != 0) && (paramString.compareTo("getConfiguredNetworks") != 0)) {
          if (paramString.compareTo("startScan") != 0) {
            break;
          }
        }
        ??? = new StringBuilder("getWifiListOption[");
        ((StringBuilder)???).append(sj.a().b());
        ((StringBuilder)???).append("]");
        ??? = new StringBuilder("wifi list Force[");
        ((StringBuilder)???).append(yb.b);
        ((StringBuilder)???).append("]");
        if (!sj.a().a.a("kiawl", false))
        {
          if (yb.b) {
            return null;
          }
          ??? = new ll.a();
          ((ll.a)???).a = null;
          ((ll.a)???).b = true;
          if (paramString.compareTo("startScan") == 0) {
            ((ll.a)???).a = Boolean.FALSE;
          }
          return ???;
        }
        return null;
      }
      catch (Throwable paramString)
      {
        return null;
      }
      label480:
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
      ll.a = new lj()
      {
        public final boolean a()
        {
          boolean bool = sj.a().b();
          StringBuilder localStringBuilder = new StringBuilder("isAllow:[");
          localStringBuilder.append(bool);
          localStringBuilder.append("]");
          return bool;
        }
        
        public final boolean b()
        {
          StringBuilder localStringBuilder = new StringBuilder("SysInvokeControlerService.sAllowLocation:[");
          localStringBuilder.append(yb.a);
          localStringBuilder.append("]");
          return (yb.a) && (sj.a().b());
        }
      };
      localObject = new lk()
      {
        public final ll.a a(String paramAnonymousString)
        {
          return xx.a(paramAnonymousString);
        }
      };
      akf.f.a.a = ((lk)localObject);
      if (sj.a().b())
      {
        ll.a(paramContext, 28L);
        return;
      }
      ll.a(paramContext, 30L);
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
 * Qualified Name:     com.tencent.token.xx
 * JD-Core Version:    0.7.0.1
 */