package com.tencent.feedback.common;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static String a;
  private static Boolean b;
  private static Boolean c;
  private static boolean d = false;
  private static ActivityManager e;
  
  /* Error */
  public static String a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: new 22	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 24
    //   13: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: astore 4
    //   18: aload_3
    //   19: astore_2
    //   20: aload 4
    //   22: iload_0
    //   23: invokevirtual 32	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_3
    //   28: astore_2
    //   29: aload 4
    //   31: ldc 34
    //   33: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_3
    //   38: astore_2
    //   39: new 39	java/io/FileReader
    //   42: dup
    //   43: aload 4
    //   45: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 44	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   51: astore_3
    //   52: sipush 128
    //   55: newarray char
    //   57: astore_2
    //   58: aload_3
    //   59: aload_2
    //   60: invokevirtual 48	java/io/FileReader:read	([C)I
    //   63: pop
    //   64: iconst_0
    //   65: istore_1
    //   66: goto +106 -> 172
    //   69: new 50	java/lang/String
    //   72: dup
    //   73: aload_2
    //   74: invokespecial 53	java/lang/String:<init>	([C)V
    //   77: iconst_0
    //   78: iload_1
    //   79: invokevirtual 57	java/lang/String:substring	(II)Ljava/lang/String;
    //   82: astore_2
    //   83: aload_3
    //   84: invokevirtual 60	java/io/FileReader:close	()V
    //   87: aload_2
    //   88: areturn
    //   89: astore 4
    //   91: aload_3
    //   92: astore_2
    //   93: aload 4
    //   95: astore_3
    //   96: goto +55 -> 151
    //   99: astore_2
    //   100: aload_2
    //   101: astore 4
    //   103: goto +12 -> 115
    //   106: astore_3
    //   107: goto +44 -> 151
    //   110: astore 4
    //   112: aload 5
    //   114: astore_3
    //   115: aload_3
    //   116: astore_2
    //   117: aload 4
    //   119: invokestatic 65	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   122: ifne +10 -> 132
    //   125: aload_3
    //   126: astore_2
    //   127: aload 4
    //   129: invokevirtual 68	java/lang/Throwable:printStackTrace	()V
    //   132: aload_3
    //   133: astore_2
    //   134: iload_0
    //   135: invokestatic 71	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   138: astore 4
    //   140: aload_3
    //   141: ifnull +7 -> 148
    //   144: aload_3
    //   145: invokevirtual 60	java/io/FileReader:close	()V
    //   148: aload 4
    //   150: areturn
    //   151: aload_2
    //   152: ifnull +7 -> 159
    //   155: aload_2
    //   156: invokevirtual 60	java/io/FileReader:close	()V
    //   159: aload_3
    //   160: athrow
    //   161: astore_3
    //   162: aload_2
    //   163: areturn
    //   164: astore_2
    //   165: aload 4
    //   167: areturn
    //   168: astore_2
    //   169: goto -10 -> 159
    //   172: iload_1
    //   173: sipush 128
    //   176: if_icmpge -107 -> 69
    //   179: aload_2
    //   180: iload_1
    //   181: caload
    //   182: ifeq -113 -> 69
    //   185: iload_1
    //   186: iconst_1
    //   187: iadd
    //   188: istore_1
    //   189: goto -17 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramInt	int
    //   65	124	1	i	int
    //   6	87	2	localObject1	Object
    //   99	2	2	localThrowable1	Throwable
    //   116	47	2	localObject2	Object
    //   164	1	2	localThrowable2	Throwable
    //   168	12	2	localThrowable3	Throwable
    //   4	92	3	localObject3	Object
    //   106	1	3	localObject4	Object
    //   114	46	3	localObject5	Object
    //   161	1	3	localThrowable4	Throwable
    //   16	28	4	localStringBuilder	StringBuilder
    //   89	5	4	localObject6	Object
    //   101	1	4	localThrowable5	Throwable
    //   110	18	4	localThrowable6	Throwable
    //   138	28	4	str	String
    //   1	112	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   52	64	89	finally
    //   69	83	89	finally
    //   52	64	99	java/lang/Throwable
    //   69	83	99	java/lang/Throwable
    //   7	18	106	finally
    //   20	27	106	finally
    //   29	37	106	finally
    //   39	52	106	finally
    //   117	125	106	finally
    //   127	132	106	finally
    //   134	140	106	finally
    //   7	18	110	java/lang/Throwable
    //   20	27	110	java/lang/Throwable
    //   29	37	110	java/lang/Throwable
    //   39	52	110	java/lang/Throwable
    //   83	87	161	java/lang/Throwable
    //   144	148	164	java/lang/Throwable
    //   155	159	168	java/lang/Throwable
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.get("APPKEY_DENGTA");
      if (paramContext == null) {
        break label51;
      }
      paramContext = paramContext.toString();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label41:
      label51:
      break label41;
    }
    e.a("rqdp{  no appkey !!}", new Object[0]);
    return "";
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (paramString == null) {
        return null;
      }
      try
      {
        paramContext = paramContext.getPackageManager().getApplicationInfo(paramString, 0);
        if (paramContext != null)
        {
          paramContext = paramContext.sourceDir;
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        if (!e.a(paramContext)) {
          paramContext.printStackTrace();
        }
      }
      return null;
    }
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
    if ((paramContext != null) && (paramString != null)) {
      if (paramString.trim().length() <= 0) {
        return false;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        if ((paramContext != null) && (paramContext.size() != 0))
        {
          paramContext = paramContext.iterator();
          if (paramContext.hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
            if (localRunningAppProcessInfo.importance != 100) {
              continue;
            }
            String[] arrayOfString = localRunningAppProcessInfo.pkgList;
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            if (!paramString.equals(arrayOfString[i])) {
              break label177;
            }
            e.b("rqdp{  current seen pn:}%s", new Object[] { localRunningAppProcessInfo.processName });
            return true;
          }
        }
        else
        {
          e.b("rqdp{  no running proc}", new Object[0]);
          return false;
        }
      }
      catch (Throwable paramContext)
      {
        if (!e.a(paramContext)) {
          paramContext.printStackTrace();
        }
        e.b("rqdp{  current unseen pn:}%s", new Object[] { paramString });
        return false;
      }
      return false;
      label177:
      i += 1;
    }
  }
  
  /* Error */
  public static String c(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnonnull +9 -> 13
    //   7: aconst_null
    //   8: astore 5
    //   10: goto +9 -> 19
    //   13: aload_0
    //   14: invokevirtual 83	android/content/Context:getPackageName	()Ljava/lang/String;
    //   17: astore 5
    //   19: aload_0
    //   20: invokevirtual 80	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   23: aload 5
    //   25: iconst_0
    //   26: invokevirtual 180	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   29: astore_0
    //   30: aload_0
    //   31: getfield 185	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   34: astore 5
    //   36: aload_0
    //   37: getfield 188	android/content/pm/PackageInfo:versionCode	I
    //   40: istore 4
    //   42: aload 5
    //   44: ifnull +111 -> 155
    //   47: aload 5
    //   49: invokevirtual 117	java/lang/String:trim	()Ljava/lang/String;
    //   52: invokevirtual 121	java/lang/String:length	()I
    //   55: ifgt +6 -> 61
    //   58: goto +97 -> 155
    //   61: aload 5
    //   63: invokevirtual 192	java/lang/String:toCharArray	()[C
    //   66: astore_0
    //   67: iconst_0
    //   68: istore_1
    //   69: iconst_0
    //   70: istore_2
    //   71: iload_1
    //   72: aload_0
    //   73: arraylength
    //   74: if_icmpge +20 -> 94
    //   77: iload_2
    //   78: istore_3
    //   79: aload_0
    //   80: iload_1
    //   81: caload
    //   82: bipush 46
    //   84: if_icmpne +103 -> 187
    //   87: iload_2
    //   88: iconst_1
    //   89: iadd
    //   90: istore_3
    //   91: goto +96 -> 187
    //   94: aload 5
    //   96: astore_0
    //   97: iload_2
    //   98: iconst_3
    //   99: if_icmpge +37 -> 136
    //   102: new 22	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   109: astore_0
    //   110: aload_0
    //   111: aload 5
    //   113: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload_0
    //   118: ldc 196
    //   120: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_0
    //   125: iload 4
    //   127: invokevirtual 32	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_0
    //   132: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: astore_0
    //   136: ldc 198
    //   138: iconst_1
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload_0
    //   145: aastore
    //   146: invokestatic 109	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   149: pop
    //   150: ldc 2
    //   152: monitorexit
    //   153: aload_0
    //   154: areturn
    //   155: ldc 2
    //   157: monitorexit
    //   158: ldc 74
    //   160: areturn
    //   161: astore_0
    //   162: goto +20 -> 182
    //   165: astore_0
    //   166: aload_0
    //   167: invokestatic 65	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   170: ifne +7 -> 177
    //   173: aload_0
    //   174: invokevirtual 68	java/lang/Throwable:printStackTrace	()V
    //   177: ldc 2
    //   179: monitorexit
    //   180: aconst_null
    //   181: areturn
    //   182: ldc 2
    //   184: monitorexit
    //   185: aload_0
    //   186: athrow
    //   187: iload_1
    //   188: iconst_1
    //   189: iadd
    //   190: istore_1
    //   191: iload_3
    //   192: istore_2
    //   193: goto -122 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	paramContext	Context
    //   68	123	1	i	int
    //   70	123	2	j	int
    //   78	114	3	k	int
    //   40	86	4	m	int
    //   8	104	5	str	String
    // Exception table:
    //   from	to	target	type
    //   13	19	161	finally
    //   19	42	161	finally
    //   47	58	161	finally
    //   61	67	161	finally
    //   71	77	161	finally
    //   102	136	161	finally
    //   136	150	161	finally
    //   166	177	161	finally
    //   13	19	165	java/lang/Throwable
    //   19	42	165	java/lang/Throwable
    //   47	58	165	java/lang/Throwable
    //   61	67	165	java/lang/Throwable
    //   71	77	165	java/lang/Throwable
    //   102	136	165	java/lang/Throwable
    //   136	150	165	java/lang/Throwable
  }
  
  /* Error */
  private static boolean c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 200
    //   2: iconst_0
    //   3: anewarray 4	java/lang/Object
    //   6: invokestatic 172	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   9: pop
    //   10: aload_0
    //   11: ifnull +124 -> 135
    //   14: aload_1
    //   15: ifnull +120 -> 135
    //   18: aload_1
    //   19: invokevirtual 117	java/lang/String:trim	()Ljava/lang/String;
    //   22: invokevirtual 121	java/lang/String:length	()I
    //   25: ifgt +5 -> 30
    //   28: iconst_0
    //   29: ireturn
    //   30: aload_0
    //   31: invokevirtual 80	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   34: aload_0
    //   35: invokevirtual 83	android/content/Context:getPackageName	()Ljava/lang/String;
    //   38: sipush 4096
    //   41: invokevirtual 180	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   44: getfield 203	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   47: astore_0
    //   48: aload_0
    //   49: ifnull +62 -> 111
    //   52: aload_0
    //   53: arraylength
    //   54: istore_3
    //   55: iconst_0
    //   56: istore_2
    //   57: iload_2
    //   58: iload_3
    //   59: if_icmpge +52 -> 111
    //   62: aload_1
    //   63: aload_0
    //   64: iload_2
    //   65: aaload
    //   66: invokevirtual 165	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: istore 4
    //   71: iload 4
    //   73: ifeq +15 -> 88
    //   76: ldc 205
    //   78: iconst_0
    //   79: anewarray 4	java/lang/Object
    //   82: invokestatic 172	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   85: pop
    //   86: iconst_1
    //   87: ireturn
    //   88: iload_2
    //   89: iconst_1
    //   90: iadd
    //   91: istore_2
    //   92: goto -35 -> 57
    //   95: astore_0
    //   96: goto +27 -> 123
    //   99: astore_0
    //   100: aload_0
    //   101: invokestatic 65	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   104: ifne +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 68	java/lang/Throwable:printStackTrace	()V
    //   111: ldc 205
    //   113: iconst_0
    //   114: anewarray 4	java/lang/Object
    //   117: invokestatic 172	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   120: pop
    //   121: iconst_0
    //   122: ireturn
    //   123: ldc 205
    //   125: iconst_0
    //   126: anewarray 4	java/lang/Object
    //   129: invokestatic 172	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   132: pop
    //   133: aload_0
    //   134: athrow
    //   135: iconst_0
    //   136: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramContext	Context
    //   0	137	1	paramString	String
    //   56	36	2	i	int
    //   54	6	3	j	int
    //   69	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   30	48	95	finally
    //   52	55	95	finally
    //   62	71	95	finally
    //   100	111	95	finally
    //   30	48	99	java/lang/Throwable
    //   52	55	99	java/lang/Throwable
    //   62	71	99	java/lang/Throwable
  }
  
  public static String d(Context paramContext)
  {
    e.b("rqdp{AppInfo.getUUID() Start}", new Object[0]);
    if (paramContext == null)
    {
      e.d("context == null", new Object[0]);
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        paramContext = paramContext.metaData.get("com.tencent.rdm.uuid");
        if (paramContext != null) {
          return paramContext.toString();
        }
      }
      else
      {
        e.d("appInfo == null || appInfo.metaData == null", new Object[0]);
        return "";
      }
    }
    catch (Throwable paramContext)
    {
      if (!e.a(paramContext)) {
        paramContext.printStackTrace();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.toString());
      e.d(localStringBuilder.toString(), new Object[0]);
      return "";
    }
    return "";
  }
  
  public static boolean e(Context paramContext)
  {
    try
    {
      e.b("rqdp{  Read Log Permittion! start}", new Object[0]);
      if (paramContext == null) {
        return false;
      }
      if (b == null) {
        b = Boolean.valueOf(c(paramContext, "android.permission.READ_LOGS"));
      }
      boolean bool = b.booleanValue();
      return bool;
    }
    finally {}
  }
  
  public static boolean f(Context paramContext)
  {
    try
    {
      e.b("rqdp{  Read write Permittion! start}", new Object[0]);
      if (paramContext == null) {
        return false;
      }
      if (c == null) {
        c = Boolean.valueOf(c(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE"));
      }
      boolean bool = c.booleanValue();
      return bool;
    }
    finally {}
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
    int i;
    try
    {
      i = Process.myPid();
      try
      {
        paramContext = a(i);
        return paramContext;
      }
      catch (Throwable paramContext) {}
      if (e.a(paramContext)) {
        break label29;
      }
    }
    catch (Throwable paramContext)
    {
      i = -1;
    }
    paramContext.printStackTrace();
    label29:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append(":");
    localStringBuilder.append(paramContext.getClass().getName());
    localStringBuilder.append(":");
    localStringBuilder.append(paramContext.getMessage());
    return localStringBuilder.toString();
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