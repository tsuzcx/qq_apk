package com.tencent.bugly.crashreport.common.info;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.bugly.proguard.x;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppInfo
{
  private static ActivityManager a;
  
  static
  {
    "@buglyAllChannel@".split(",");
    "@buglyAllChannelPriority@".split(",");
  }
  
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
    //   12: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: iload_0
    //   16: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: ldc 42
    //   21: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokespecial 50	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   30: astore_3
    //   31: aload_3
    //   32: astore_2
    //   33: sipush 512
    //   36: newarray char
    //   38: astore 4
    //   40: aload_3
    //   41: astore_2
    //   42: aload_3
    //   43: aload 4
    //   45: invokevirtual 54	java/io/FileReader:read	([C)I
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
    //   74: new 14	java/lang/String
    //   77: dup
    //   78: aload 4
    //   80: invokespecial 57	java/lang/String:<init>	([C)V
    //   83: iconst_0
    //   84: iload_1
    //   85: invokevirtual 61	java/lang/String:substring	(II)Ljava/lang/String;
    //   88: astore 4
    //   90: aload 4
    //   92: astore_2
    //   93: aload_3
    //   94: invokevirtual 64	java/io/FileReader:close	()V
    //   97: aload_2
    //   98: areturn
    //   99: astore 4
    //   101: aconst_null
    //   102: astore_3
    //   103: aload_3
    //   104: astore_2
    //   105: aload 4
    //   107: invokestatic 69	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   110: ifne +10 -> 120
    //   113: aload_3
    //   114: astore_2
    //   115: aload 4
    //   117: invokevirtual 72	java/lang/Throwable:printStackTrace	()V
    //   120: iload_0
    //   121: invokestatic 75	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   124: astore 4
    //   126: aload 4
    //   128: astore_2
    //   129: aload_3
    //   130: ifnull -33 -> 97
    //   133: aload_3
    //   134: invokevirtual 64	java/io/FileReader:close	()V
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
    //   152: invokevirtual 64	java/io/FileReader:close	()V
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
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageName();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      if (!x.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static List<String> a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    try
    {
      paramMap = (String)paramMap.get("BUGLY_DISABLE");
      if ((paramMap != null) && (paramMap.length() != 0))
      {
        paramMap = paramMap.split(",");
        int i = 0;
        while (i < paramMap.length)
        {
          paramMap[i] = paramMap[i].trim();
          i += 1;
        }
        paramMap = Arrays.asList(paramMap);
        return paramMap;
      }
    }
    catch (Throwable paramMap)
    {
      if (!x.a(paramMap)) {
        paramMap.printStackTrace();
      }
      return null;
    }
    return null;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.trim().length() <= 0)) {}
    for (;;)
    {
      return false;
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
          if (x.a(paramContext)) {}
        }
      }
      catch (Throwable paramContext) {}
    }
    paramContext.printStackTrace();
    return false;
  }
  
  public static PackageInfo b(Context paramContext)
  {
    try
    {
      String str = a(paramContext);
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      if (!x.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public static String c(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      for (;;)
      {
        return null;
        try
        {
          PackageManager localPackageManager = paramContext.getPackageManager();
          paramContext = paramContext.getApplicationInfo();
          if ((localPackageManager != null) && (paramContext != null))
          {
            paramContext = localPackageManager.getApplicationLabel(paramContext);
            if (paramContext != null)
            {
              paramContext = paramContext.toString();
              return paramContext;
            }
          }
        }
        catch (Throwable paramContext) {}
      }
    } while (x.a(paramContext));
    paramContext.printStackTrace();
    return null;
  }
  
  public static Map<String, String> d(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
        if (paramContext.metaData == null) {
          break label256;
        }
        HashMap localHashMap = new HashMap();
        Object localObject = paramContext.metaData.get("BUGLY_DISABLE");
        if (localObject != null) {
          localHashMap.put("BUGLY_DISABLE", localObject.toString());
        }
        localObject = paramContext.metaData.get("BUGLY_APPID");
        if (localObject != null) {
          localHashMap.put("BUGLY_APPID", localObject.toString());
        }
        localObject = paramContext.metaData.get("BUGLY_APP_CHANNEL");
        if (localObject != null) {
          localHashMap.put("BUGLY_APP_CHANNEL", localObject.toString());
        }
        localObject = paramContext.metaData.get("BUGLY_APP_VERSION");
        if (localObject != null) {
          localHashMap.put("BUGLY_APP_VERSION", localObject.toString());
        }
        localObject = paramContext.metaData.get("BUGLY_ENABLE_DEBUG");
        if (localObject != null) {
          localHashMap.put("BUGLY_ENABLE_DEBUG", localObject.toString());
        }
        localObject = paramContext.metaData.get("com.tencent.rdm.uuid");
        if (localObject != null) {
          localHashMap.put("com.tencent.rdm.uuid", localObject.toString());
        }
        localObject = paramContext.metaData.get("BUGLY_APP_BUILD_NO");
        if (localObject != null) {
          localHashMap.put("BUGLY_APP_BUILD_NO", localObject.toString());
        }
        localObject = paramContext.metaData.get("BUGLY_AREA");
        paramContext = localHashMap;
        if (localObject != null)
        {
          localHashMap.put("BUGLY_AREA", localObject.toString());
          paramContext = localHashMap;
        }
        return paramContext;
      }
      catch (Throwable paramContext) {}
      if (x.a(paramContext)) {
        break;
      }
      paramContext.printStackTrace();
      return null;
      label256:
      paramContext = null;
    }
  }
  
  public static boolean e(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (a == null) {
      a = (ActivityManager)paramContext.getSystemService("activity");
    }
    try
    {
      paramContext = new ActivityManager.MemoryInfo();
      a.getMemoryInfo(paramContext);
      if (paramContext.lowMemory)
      {
        x.c("Memory is low.", new Object[0]);
        return true;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      if (!x.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.info.AppInfo
 * JD-Core Version:    0.7.0.1
 */