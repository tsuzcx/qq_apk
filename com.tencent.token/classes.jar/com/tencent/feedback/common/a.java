package com.tencent.feedback.common;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static String a = null;
  private static Boolean b = null;
  private static Boolean c = null;
  private static boolean d = false;
  private static ActivityManager e;
  
  /* Error */
  public static String a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 29	java/io/FileReader
    //   5: dup
    //   6: new 31	java/lang/StringBuilder
    //   9: dup
    //   10: ldc 33
    //   12: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: iload_0
    //   16: invokevirtual 41	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: ldc 43
    //   21: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokespecial 51	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   30: astore_3
    //   31: aload_3
    //   32: astore_2
    //   33: sipush 128
    //   36: newarray char
    //   38: astore 4
    //   40: aload_3
    //   41: astore_2
    //   42: aload_3
    //   43: aload 4
    //   45: invokevirtual 55	java/io/FileReader:read	([C)I
    //   48: pop
    //   49: aload_3
    //   50: astore_2
    //   51: iload_1
    //   52: aload 4
    //   54: arraylength
    //   55: if_icmpge +17 -> 72
    //   58: aload 4
    //   60: iload_1
    //   61: caload
    //   62: ifeq +10 -> 72
    //   65: iload_1
    //   66: iconst_1
    //   67: iadd
    //   68: istore_1
    //   69: goto -20 -> 49
    //   72: aload_3
    //   73: astore_2
    //   74: new 57	java/lang/String
    //   77: dup
    //   78: aload 4
    //   80: invokespecial 60	java/lang/String:<init>	([C)V
    //   83: iconst_0
    //   84: iload_1
    //   85: invokevirtual 64	java/lang/String:substring	(II)Ljava/lang/String;
    //   88: astore 4
    //   90: aload 4
    //   92: astore_2
    //   93: aload_3
    //   94: invokevirtual 67	java/io/FileReader:close	()V
    //   97: aload_2
    //   98: areturn
    //   99: astore 4
    //   101: aconst_null
    //   102: astore_3
    //   103: aload_3
    //   104: astore_2
    //   105: aload 4
    //   107: invokestatic 72	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   110: ifne +10 -> 120
    //   113: aload_3
    //   114: astore_2
    //   115: aload 4
    //   117: invokevirtual 75	java/lang/Throwable:printStackTrace	()V
    //   120: iload_0
    //   121: invokestatic 78	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   124: astore 4
    //   126: aload 4
    //   128: astore_2
    //   129: aload_3
    //   130: ifnull -33 -> 97
    //   133: aload_3
    //   134: invokevirtual 67	java/io/FileReader:close	()V
    //   137: aload 4
    //   139: areturn
    //   140: astore_2
    //   141: aload 4
    //   143: areturn
    //   144: astore_3
    //   145: aconst_null
    //   146: astore_2
    //   147: aload_2
    //   148: ifnull +7 -> 155
    //   151: aload_2
    //   152: invokevirtual 67	java/io/FileReader:close	()V
    //   155: aload_3
    //   156: athrow
    //   157: astore_3
    //   158: aload_2
    //   159: areturn
    //   160: astore_2
    //   161: goto -6 -> 155
    //   164: astore_3
    //   165: goto -18 -> 147
    //   168: astore 4
    //   170: goto -67 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramInt	int
    //   1	84	1	i	int
    //   32	97	2	localObject1	Object
    //   140	1	2	localThrowable1	Throwable
    //   146	13	2	str1	String
    //   160	1	2	localThrowable2	Throwable
    //   30	104	3	localFileReader	java.io.FileReader
    //   144	12	3	localObject2	Object
    //   157	1	3	localThrowable3	Throwable
    //   164	1	3	localObject3	Object
    //   38	53	4	localObject4	Object
    //   99	17	4	localThrowable4	Throwable
    //   124	18	4	str2	String
    //   168	1	4	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	31	99	java/lang/Throwable
    //   133	137	140	java/lang/Throwable
    //   2	31	144	finally
    //   93	97	157	java/lang/Throwable
    //   151	155	160	java/lang/Throwable
    //   33	40	164	finally
    //   42	49	164	finally
    //   51	58	164	finally
    //   74	90	164	finally
    //   105	113	164	finally
    //   115	120	164	finally
    //   33	40	168	java/lang/Throwable
    //   42	49	168	java/lang/Throwable
    //   51	58	168	java/lang/Throwable
    //   74	90	168	java/lang/Throwable
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.get("APPKEY_DENGTA");
      if (paramContext != null)
      {
        paramContext = paramContext.toString();
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      e.a("rqdp{  no appkey !!}", new Object[0]);
    }
    return "";
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {}
    do
    {
      for (;;)
      {
        return null;
        try
        {
          paramContext = paramContext.getPackageManager().getApplicationInfo(paramString, 0);
          if (paramContext != null)
          {
            paramContext = paramContext.sourceDir;
            return paramContext;
          }
        }
        catch (Throwable paramContext) {}
      }
    } while (e.a(paramContext));
    paramContext.printStackTrace();
    return null;
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getPackageName();
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.trim().length() <= 0)) {
      return false;
    }
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if ((paramContext == null) || (paramContext.size() == 0))
      {
        e.b("rqdp{  no running proc}", new Object[0]);
        return false;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.importance == 100)
        {
          String[] arrayOfString = localRunningAppProcessInfo.pkgList;
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            if (paramString.equals(arrayOfString[i]))
            {
              e.b("rqdp{  current seen pn:}%s", new Object[] { localRunningAppProcessInfo.processName });
              return true;
            }
            i += 1;
          }
        }
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      if (!e.a(paramContext)) {
        paramContext.printStackTrace();
      }
      e.b("rqdp{  current unseen pn:}%s", new Object[] { paramString });
    }
  }
  
  public static String c(Context paramContext)
  {
    int j = 0;
    Object localObject;
    if (paramContext == null) {
      localObject = null;
    }
    int i;
    for (;;)
    {
      try
      {
        localObject = paramContext.getPackageManager().getPackageInfo((String)localObject, 0);
        paramContext = ((PackageInfo)localObject).versionName;
        m = ((PackageInfo)localObject).versionCode;
        if ((paramContext != null) && (paramContext.trim().length() > 0)) {
          continue;
        }
        paramContext = "";
      }
      catch (Throwable paramContext)
      {
        int m;
        if (e.a(paramContext)) {
          continue;
        }
        paramContext.printStackTrace();
        paramContext = null;
        continue;
      }
      finally {}
      return paramContext;
      localObject = paramContext.getPackageName();
      continue;
      localObject = paramContext.toCharArray();
      i = 0;
    }
    for (;;)
    {
      int k;
      if (i < localObject.length)
      {
        k = j;
        if (localObject[i] == '.') {
          k = j + 1;
        }
      }
      else
      {
        if (j < 3) {
          paramContext = paramContext + "." + m;
        }
        for (;;)
        {
          e.a("rqdp{  version:} %s", new Object[] { paramContext });
          break;
        }
      }
      i += 1;
      j = k;
    }
  }
  
  private static boolean c(Context paramContext, String paramString)
  {
    e.b("rqdp{  AppInfo.isContainReadLogPermission() start}", new Object[0]);
    if ((paramContext == null) || (paramString == null) || (paramString.trim().length() <= 0)) {
      return false;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
      if (paramContext != null)
      {
        int j = paramContext.length;
        int i = 0;
        while (i < j)
        {
          boolean bool = paramString.equals(paramContext[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      if (!e.a(paramContext)) {
        paramContext.printStackTrace();
      }
      return false;
    }
    finally
    {
      e.b("rqdp{  AppInfo.isContainReadLogPermission() end}", new Object[0]);
    }
  }
  
  public static String d(Context paramContext)
  {
    e.b("rqdp{AppInfo.getUUID() Start}", new Object[0]);
    if (paramContext == null)
    {
      e.d("context == null", new Object[0]);
      return "";
    }
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
        if ((paramContext == null) || (paramContext.metaData == null))
        {
          e.d("appInfo == null || appInfo.metaData == null", new Object[0]);
          return "";
        }
        paramContext = paramContext.metaData.get("com.tencent.rdm.uuid");
        if (paramContext != null)
        {
          paramContext = paramContext.toString();
          Log.d("rqdp{ RDMUUID }:%s", paramContext);
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        if (!e.a(paramContext)) {
          paramContext.printStackTrace();
        }
        e.d(paramContext.toString(), new Object[0]);
        return "";
      }
      paramContext = "";
    }
  }
  
  /* Error */
  public static boolean e(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 233
    //   7: iconst_0
    //   8: anewarray 4	java/lang/Object
    //   11: invokestatic 148	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   14: pop
    //   15: aload_0
    //   16: ifnonnull +8 -> 24
    //   19: ldc 2
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: getstatic 19	com/tencent/feedback/common/a:b	Ljava/lang/Boolean;
    //   27: ifnonnull +15 -> 42
    //   30: aload_0
    //   31: ldc 235
    //   33: invokestatic 237	com/tencent/feedback/common/a:c	(Landroid/content/Context;Ljava/lang/String;)Z
    //   36: invokestatic 242	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   39: putstatic 19	com/tencent/feedback/common/a:b	Ljava/lang/Boolean;
    //   42: getstatic 19	com/tencent/feedback/common/a:b	Ljava/lang/Boolean;
    //   45: invokevirtual 245	java/lang/Boolean:booleanValue	()Z
    //   48: istore_1
    //   49: goto -30 -> 19
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramContext	Context
    //   1	48	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	15	52	finally
    //   24	42	52	finally
    //   42	49	52	finally
  }
  
  /* Error */
  public static boolean f(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 248
    //   7: iconst_0
    //   8: anewarray 4	java/lang/Object
    //   11: invokestatic 148	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   14: pop
    //   15: aload_0
    //   16: ifnonnull +8 -> 24
    //   19: ldc 2
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: getstatic 21	com/tencent/feedback/common/a:c	Ljava/lang/Boolean;
    //   27: ifnonnull +15 -> 42
    //   30: aload_0
    //   31: ldc 250
    //   33: invokestatic 237	com/tencent/feedback/common/a:c	(Landroid/content/Context;Ljava/lang/String;)Z
    //   36: invokestatic 242	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   39: putstatic 21	com/tencent/feedback/common/a:c	Ljava/lang/Boolean;
    //   42: getstatic 21	com/tencent/feedback/common/a:c	Ljava/lang/Boolean;
    //   45: invokevirtual 245	java/lang/Boolean:booleanValue	()Z
    //   48: istore_1
    //   49: goto -30 -> 19
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramContext	Context
    //   1	48	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	15	52	finally
    //   24	42	52	finally
    //   42	49	52	finally
  }
  
  public static boolean g(Context paramContext)
  {
    return b(paramContext, paramContext.getPackageName());
  }
  
  public static String h(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = a(paramContext, paramContext.getPackageName());
    if (paramContext == null)
    {
      e.d("rqdp{  No found the apk file on the device,please check it!}", new Object[0]);
      return null;
    }
    return com.tencent.feedback.proguard.a.b(paramContext);
  }
  
  public static String i(Context paramContext)
  {
    int i = -1;
    try
    {
      int j = Process.myPid();
      i = j;
      paramContext = a(j);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      if (!e.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return i + ":" + paramContext.getClass().getName() + ":" + paramContext.getMessage();
  }
  
  public static boolean j(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (e == null) {
      e = (ActivityManager)paramContext.getSystemService("activity");
    }
    try
    {
      paramContext = new ActivityManager.MemoryInfo();
      e.getMemoryInfo(paramContext);
      boolean bool = paramContext.lowMemory;
      return bool;
    }
    catch (Throwable paramContext)
    {
      if (!e.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.common.a
 * JD-Core Version:    0.7.0.1
 */