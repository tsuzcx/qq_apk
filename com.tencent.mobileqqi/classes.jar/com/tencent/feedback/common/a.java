package com.tencent.feedback.common;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static String a = null;
  private static Boolean b = null;
  private static Boolean c = null;
  
  /* Error */
  public static android.util.SparseArray<String> a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_0
    //   4: istore_1
    //   5: new 25	android/util/SparseArray
    //   8: dup
    //   9: invokespecial 28	android/util/SparseArray:<init>	()V
    //   12: astore 5
    //   14: invokestatic 34	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   17: ldc 36
    //   19: invokevirtual 40	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   22: astore_3
    //   23: aload_3
    //   24: ifnull +316 -> 340
    //   27: new 42	java/io/BufferedReader
    //   30: dup
    //   31: new 44	java/io/InputStreamReader
    //   34: dup
    //   35: aload_3
    //   36: invokevirtual 50	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   39: invokespecial 53	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   42: invokespecial 56	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_3
    //   46: ldc 58
    //   48: invokestatic 64	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   51: astore 6
    //   53: aload_3
    //   54: invokevirtual 68	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   57: astore 7
    //   59: aload_3
    //   60: astore 4
    //   62: aload 7
    //   64: ifnull +279 -> 343
    //   67: iload_1
    //   68: iconst_1
    //   69: iadd
    //   70: istore_2
    //   71: iload_2
    //   72: istore_1
    //   73: iload_2
    //   74: iconst_1
    //   75: if_icmpeq -22 -> 53
    //   78: aload 6
    //   80: aload 7
    //   82: invokevirtual 72	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   85: invokevirtual 78	java/util/regex/Matcher:matches	()Z
    //   88: ifne +30 -> 118
    //   91: ldc 80
    //   93: iconst_1
    //   94: anewarray 4	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: aload 7
    //   101: aastore
    //   102: invokestatic 85	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: aload_3
    //   106: invokevirtual 88	java/io/BufferedReader:close	()V
    //   109: aconst_null
    //   110: areturn
    //   111: astore_3
    //   112: aload_3
    //   113: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   116: aconst_null
    //   117: areturn
    //   118: aload 7
    //   120: invokevirtual 96	java/lang/String:trim	()Ljava/lang/String;
    //   123: ldc 98
    //   125: invokevirtual 102	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   128: astore 4
    //   130: aload 4
    //   132: ifnull +11 -> 143
    //   135: aload 4
    //   137: arraylength
    //   138: bipush 9
    //   140: if_icmpge +30 -> 170
    //   143: ldc 80
    //   145: iconst_1
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload 7
    //   153: aastore
    //   154: invokestatic 85	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aload_3
    //   158: invokevirtual 88	java/io/BufferedReader:close	()V
    //   161: aconst_null
    //   162: areturn
    //   163: astore_3
    //   164: aload_3
    //   165: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   168: aconst_null
    //   169: areturn
    //   170: iload_2
    //   171: istore_1
    //   172: aload 4
    //   174: iconst_0
    //   175: aaload
    //   176: invokestatic 108	android/os/Process:getUidForName	(Ljava/lang/String;)I
    //   179: iload_0
    //   180: if_icmpne -127 -> 53
    //   183: new 110	java/lang/StringBuffer
    //   186: dup
    //   187: invokespecial 111	java/lang/StringBuffer:<init>	()V
    //   190: astore 7
    //   192: bipush 8
    //   194: istore_1
    //   195: iload_1
    //   196: aload 4
    //   198: arraylength
    //   199: if_icmpge +74 -> 273
    //   202: iload_1
    //   203: bipush 8
    //   205: if_icmple +31 -> 236
    //   208: aload 7
    //   210: new 113	java/lang/StringBuilder
    //   213: dup
    //   214: ldc 115
    //   216: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   219: aload 4
    //   221: iload_1
    //   222: aaload
    //   223: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokevirtual 128	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   232: pop
    //   233: goto +163 -> 396
    //   236: aload 7
    //   238: aload 4
    //   240: iload_1
    //   241: aaload
    //   242: invokevirtual 128	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   245: pop
    //   246: goto +150 -> 396
    //   249: astore 4
    //   251: aload 4
    //   253: invokevirtual 129	java/lang/Exception:printStackTrace	()V
    //   256: aload_3
    //   257: ifnull -148 -> 109
    //   260: aload_3
    //   261: invokevirtual 88	java/io/BufferedReader:close	()V
    //   264: aconst_null
    //   265: areturn
    //   266: astore_3
    //   267: aload_3
    //   268: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   271: aconst_null
    //   272: areturn
    //   273: aload 7
    //   275: invokevirtual 130	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   278: astore 7
    //   280: aload 5
    //   282: aload 4
    //   284: iconst_1
    //   285: aaload
    //   286: invokestatic 135	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   289: aload 7
    //   291: invokevirtual 139	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   294: ldc 141
    //   296: iconst_2
    //   297: anewarray 4	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: aload 4
    //   304: iconst_1
    //   305: aaload
    //   306: aastore
    //   307: dup
    //   308: iconst_1
    //   309: aload 7
    //   311: aastore
    //   312: invokestatic 143	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   315: iload_2
    //   316: istore_1
    //   317: goto -264 -> 53
    //   320: astore 5
    //   322: aload_3
    //   323: astore 4
    //   325: aload 5
    //   327: astore_3
    //   328: aload 4
    //   330: ifnull +8 -> 338
    //   333: aload 4
    //   335: invokevirtual 88	java/io/BufferedReader:close	()V
    //   338: aload_3
    //   339: athrow
    //   340: aconst_null
    //   341: astore 4
    //   343: aload 4
    //   345: ifnull +8 -> 353
    //   348: aload 4
    //   350: invokevirtual 88	java/io/BufferedReader:close	()V
    //   353: aload 5
    //   355: areturn
    //   356: astore_3
    //   357: aload_3
    //   358: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   361: goto -8 -> 353
    //   364: astore 4
    //   366: aload 4
    //   368: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   371: goto -33 -> 338
    //   374: astore_3
    //   375: goto -47 -> 328
    //   378: astore 5
    //   380: aload_3
    //   381: astore 4
    //   383: aload 5
    //   385: astore_3
    //   386: goto -58 -> 328
    //   389: astore 4
    //   391: aconst_null
    //   392: astore_3
    //   393: goto -142 -> 251
    //   396: iload_1
    //   397: iconst_1
    //   398: iadd
    //   399: istore_1
    //   400: goto -205 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	paramInt	int
    //   4	396	1	i	int
    //   70	246	2	j	int
    //   22	84	3	localObject1	Object
    //   111	47	3	localIOException1	java.io.IOException
    //   163	98	3	localIOException2	java.io.IOException
    //   266	57	3	localIOException3	java.io.IOException
    //   327	12	3	localSparseArray1	android.util.SparseArray<String>
    //   356	2	3	localIOException4	java.io.IOException
    //   374	7	3	localObject2	Object
    //   385	8	3	localObject3	Object
    //   1	238	4	localObject4	Object
    //   249	54	4	localException1	Exception
    //   323	26	4	localObject5	Object
    //   364	3	4	localIOException5	java.io.IOException
    //   381	1	4	localObject6	Object
    //   389	1	4	localException2	Exception
    //   12	269	5	localSparseArray	android.util.SparseArray
    //   320	34	5	localSparseArray2	android.util.SparseArray<String>
    //   378	6	5	localObject7	Object
    //   51	28	6	localPattern	java.util.regex.Pattern
    //   57	253	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   105	109	111	java/io/IOException
    //   157	161	163	java/io/IOException
    //   46	53	249	java/lang/Exception
    //   53	59	249	java/lang/Exception
    //   78	105	249	java/lang/Exception
    //   118	130	249	java/lang/Exception
    //   135	143	249	java/lang/Exception
    //   143	157	249	java/lang/Exception
    //   172	192	249	java/lang/Exception
    //   195	202	249	java/lang/Exception
    //   208	233	249	java/lang/Exception
    //   236	246	249	java/lang/Exception
    //   273	315	249	java/lang/Exception
    //   260	264	266	java/io/IOException
    //   46	53	320	finally
    //   53	59	320	finally
    //   78	105	320	finally
    //   118	130	320	finally
    //   135	143	320	finally
    //   143	157	320	finally
    //   172	192	320	finally
    //   195	202	320	finally
    //   208	233	320	finally
    //   236	246	320	finally
    //   273	315	320	finally
    //   348	353	356	java/io/IOException
    //   333	338	364	java/io/IOException
    //   5	23	374	finally
    //   27	46	374	finally
    //   251	256	378	finally
    //   5	23	389	java/lang/Exception
    //   27	46	389	java/lang/Exception
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.get("APPKEY_DENGTA");
        if (paramContext != null)
        {
          paramContext = paramContext.toString();
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        e.a("rqdp{  no appkey !!}", new Object[0]);
        paramContext = "";
      }
      finally {}
    }
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == paramInt) {
        return localRunningAppProcessInfo.processName;
      }
    }
    return "unknown";
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {}
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
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).edit().putString(paramString1, paramString2).commit();
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getPackageName();
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).getString(paramString1, paramString2);
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
        if ((localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.processName.equals(paramString)))
        {
          e.b("rqdp{  current seen proc:}%s", new Object[] { localRunningAppProcessInfo.processName });
          return true;
        }
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      e.d("rqdp{  Failed to judge }[%s]", new Object[] { paramContext.getLocalizedMessage() });
      e.b("rqdp{  current unseen proc:}%s", new Object[] { paramString });
    }
    return false;
  }
  
  public static String c(Context paramContext)
  {
    Object localObject2 = null;
    int i = 0;
    Object localObject1;
    if (paramContext == null) {
      localObject1 = null;
    }
    for (;;)
    {
      try
      {
        localObject1 = paramContext.getPackageManager().getPackageInfo((String)localObject1, 0);
        paramContext = ((PackageInfo)localObject1).versionName;
        m = ((PackageInfo)localObject1).versionCode;
        if ((paramContext != null) && (paramContext.length() > 0)) {
          continue;
        }
        paramContext = "";
      }
      catch (Exception paramContext)
      {
        int m;
        paramContext.printStackTrace();
        e.d(paramContext.toString(), new Object[0]);
        paramContext = localObject2;
        continue;
      }
      finally {}
      return paramContext;
      localObject1 = paramContext.getPackageName();
      continue;
      localObject1 = paramContext.toCharArray();
    }
    int k;
    for (int j = 0;; j = k)
    {
      if (i < localObject1.length)
      {
        k = j;
        if (localObject1[i] == '.') {
          k = j + 1;
        }
      }
      else
      {
        if (j < 3)
        {
          e.a("rqdp{  add versionCode} %s", new Object[] { Integer.valueOf(m) });
          paramContext = paramContext + "." + m;
        }
        for (;;)
        {
          e.a("rqdp{  version:} %s", new Object[] { paramContext });
          break;
        }
      }
      i += 1;
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
      paramContext.printStackTrace();
      return false;
    }
    finally
    {
      e.b("rqdp{  AppInfo.isContainReadLogPermission() end}", new Object[0]);
    }
  }
  
  /* Error */
  public static String d(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 324
    //   6: iconst_0
    //   7: anewarray 4	java/lang/Object
    //   10: invokestatic 143	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   13: aload_0
    //   14: ifnonnull +11 -> 25
    //   17: ldc 150
    //   19: astore_0
    //   20: ldc 2
    //   22: monitorexit
    //   23: aload_0
    //   24: areturn
    //   25: aload_0
    //   26: invokevirtual 156	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   29: aload_0
    //   30: invokevirtual 159	android/content/Context:getPackageName	()Ljava/lang/String;
    //   33: sipush 128
    //   36: invokevirtual 165	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   39: astore_0
    //   40: aload_0
    //   41: ifnull +10 -> 51
    //   44: aload_0
    //   45: getfield 171	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   48: ifnonnull +25 -> 73
    //   51: ldc 150
    //   53: astore_0
    //   54: ldc_w 326
    //   57: iconst_0
    //   58: anewarray 4	java/lang/Object
    //   61: invokestatic 143	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: goto -44 -> 20
    //   67: astore_0
    //   68: ldc 2
    //   70: monitorexit
    //   71: aload_0
    //   72: athrow
    //   73: aload_0
    //   74: getfield 171	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   77: ldc_w 328
    //   80: invokevirtual 179	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   83: astore_0
    //   84: aload_0
    //   85: ifnull +21 -> 106
    //   88: aload_0
    //   89: invokevirtual 180	java/lang/Object:toString	()Ljava/lang/String;
    //   92: astore_0
    //   93: ldc_w 326
    //   96: iconst_0
    //   97: anewarray 4	java/lang/Object
    //   100: invokestatic 143	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: goto -83 -> 20
    //   106: ldc_w 326
    //   109: iconst_0
    //   110: anewarray 4	java/lang/Object
    //   113: invokestatic 143	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: ldc 150
    //   118: astore_0
    //   119: goto -99 -> 20
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 227	java/lang/Throwable:printStackTrace	()V
    //   127: ldc_w 326
    //   130: iconst_0
    //   131: anewarray 4	java/lang/Object
    //   134: invokestatic 143	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: goto -21 -> 116
    //   140: astore_0
    //   141: ldc_w 326
    //   144: iconst_0
    //   145: anewarray 4	java/lang/Object
    //   148: invokestatic 143	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: aload_0
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	13	67	finally
    //   54	64	67	finally
    //   93	103	67	finally
    //   106	116	67	finally
    //   127	137	67	finally
    //   141	153	67	finally
    //   25	40	122	java/lang/Throwable
    //   44	51	122	java/lang/Throwable
    //   73	84	122	java/lang/Throwable
    //   88	93	122	java/lang/Throwable
    //   25	40	140	finally
    //   44	51	140	finally
    //   73	84	140	finally
    //   88	93	140	finally
    //   123	127	140	finally
  }
  
  /* Error */
  public static boolean e(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 332
    //   8: iconst_0
    //   9: anewarray 4	java/lang/Object
    //   12: invokestatic 143	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   15: aload_0
    //   16: ifnonnull +8 -> 24
    //   19: ldc 2
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: getstatic 15	com/tencent/feedback/common/a:b	Ljava/lang/Boolean;
    //   27: ifnonnull +16 -> 43
    //   30: aload_0
    //   31: ldc_w 334
    //   34: invokestatic 336	com/tencent/feedback/common/a:c	(Landroid/content/Context;Ljava/lang/String;)Z
    //   37: invokestatic 341	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   40: putstatic 15	com/tencent/feedback/common/a:b	Ljava/lang/Boolean;
    //   43: getstatic 15	com/tencent/feedback/common/a:b	Ljava/lang/Boolean;
    //   46: invokevirtual 344	java/lang/Boolean:booleanValue	()Z
    //   49: istore_1
    //   50: goto -31 -> 19
    //   53: astore_0
    //   54: ldc 2
    //   56: monitorexit
    //   57: aload_0
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	paramContext	Context
    //   1	49	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	15	53	finally
    //   24	43	53	finally
    //   43	50	53	finally
  }
  
  /* Error */
  public static boolean f(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 347
    //   8: iconst_0
    //   9: anewarray 4	java/lang/Object
    //   12: invokestatic 143	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   15: aload_0
    //   16: ifnonnull +8 -> 24
    //   19: ldc 2
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: getstatic 17	com/tencent/feedback/common/a:c	Ljava/lang/Boolean;
    //   27: ifnonnull +16 -> 43
    //   30: aload_0
    //   31: ldc_w 349
    //   34: invokestatic 336	com/tencent/feedback/common/a:c	(Landroid/content/Context;Ljava/lang/String;)Z
    //   37: invokestatic 341	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   40: putstatic 17	com/tencent/feedback/common/a:c	Ljava/lang/Boolean;
    //   43: getstatic 17	com/tencent/feedback/common/a:c	Ljava/lang/Boolean;
    //   46: invokevirtual 344	java/lang/Boolean:booleanValue	()Z
    //   49: istore_1
    //   50: goto -31 -> 19
    //   53: astore_0
    //   54: ldc 2
    //   56: monitorexit
    //   57: aload_0
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	paramContext	Context
    //   1	49	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	15	53	finally
    //   24	43	53	finally
    //   43	50	53	finally
  }
  
  public static String g(Context paramContext)
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
    return com.tencent.feedback.proguard.a.a(com.tencent.feedback.proguard.a.a(paramContext, "SHA-1"), false);
  }
  
  public static String h(Context paramContext)
  {
    try
    {
      int i = Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i)
        {
          paramContext = localRunningAppProcessInfo.processName;
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.common.a
 * JD-Core Version:    0.7.0.1
 */