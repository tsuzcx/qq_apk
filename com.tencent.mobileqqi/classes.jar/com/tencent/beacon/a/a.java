package com.tencent.beacon.a;

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
        com.tencent.beacon.d.a.d("no appkey !! ", new Object[0]);
        paramContext = "";
      }
      finally {}
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("DENGTA_META", 0).edit().putString("key_channelpath", paramString).commit();
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).edit().putString(paramString1, paramString2).commit();
  }
  
  /* Error */
  public static String b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnonnull +11 -> 15
    //   7: ldc 16
    //   9: astore_0
    //   10: ldc 2
    //   12: monitorexit
    //   13: aload_0
    //   14: areturn
    //   15: aconst_null
    //   16: astore_3
    //   17: aconst_null
    //   18: astore 4
    //   20: aload_0
    //   21: invokevirtual 92	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   24: astore 6
    //   26: aload_0
    //   27: ldc 60
    //   29: iconst_0
    //   30: invokevirtual 64	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   33: ldc 72
    //   35: ldc 16
    //   37: invokeinterface 96 3 0
    //   42: astore 5
    //   44: aload 5
    //   46: astore_2
    //   47: aload 5
    //   49: ldc 16
    //   51: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   54: ifeq +33 -> 87
    //   57: ldc 104
    //   59: astore_2
    //   60: aload_0
    //   61: ldc 60
    //   63: iconst_0
    //   64: invokevirtual 64	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   67: invokeinterface 70 1 0
    //   72: ldc 72
    //   74: ldc 104
    //   76: invokeinterface 78 3 0
    //   81: invokeinterface 82 1 0
    //   86: pop
    //   87: new 106	java/lang/StringBuilder
    //   90: dup
    //   91: ldc 108
    //   93: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload_2
    //   97: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: iconst_0
    //   104: anewarray 4	java/lang/Object
    //   107: invokestatic 119	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload_2
    //   111: ldc 16
    //   113: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   116: ifne +301 -> 417
    //   119: aload 6
    //   121: aload_2
    //   122: invokevirtual 125	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   125: astore_2
    //   126: new 127	java/util/Properties
    //   129: dup
    //   130: invokespecial 129	java/util/Properties:<init>	()V
    //   133: astore_3
    //   134: aload_3
    //   135: aload_2
    //   136: invokevirtual 133	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   139: aload_3
    //   140: ldc 135
    //   142: ldc 16
    //   144: invokevirtual 138	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   147: astore_3
    //   148: new 106	java/lang/StringBuilder
    //   151: dup
    //   152: ldc 140
    //   154: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: aload_3
    //   158: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: iconst_0
    //   165: anewarray 4	java/lang/Object
    //   168: invokestatic 119	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: ldc 16
    //   173: aload_3
    //   174: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   177: istore_1
    //   178: iload_1
    //   179: ifne +34 -> 213
    //   182: aload_3
    //   183: astore_0
    //   184: aload_2
    //   185: ifnull -175 -> 10
    //   188: aload_2
    //   189: invokevirtual 145	java/io/InputStream:close	()V
    //   192: aload_3
    //   193: astore_0
    //   194: goto -184 -> 10
    //   197: astore_0
    //   198: aload_0
    //   199: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   202: aload_3
    //   203: astore_0
    //   204: goto -194 -> 10
    //   207: astore_0
    //   208: ldc 2
    //   210: monitorexit
    //   211: aload_0
    //   212: athrow
    //   213: aload_2
    //   214: astore 4
    //   216: aload_3
    //   217: astore_2
    //   218: aload 4
    //   220: astore_3
    //   221: aload_2
    //   222: astore 4
    //   224: aload_3
    //   225: ifnull +186 -> 411
    //   228: aload_3
    //   229: invokevirtual 145	java/io/InputStream:close	()V
    //   232: aload_0
    //   233: invokevirtual 22	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   236: aload_0
    //   237: invokevirtual 26	android/content/Context:getPackageName	()Ljava/lang/String;
    //   240: sipush 128
    //   243: invokevirtual 32	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   246: getfield 38	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   249: ldc 150
    //   251: invokevirtual 46	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   254: astore_3
    //   255: aload_2
    //   256: astore_0
    //   257: aload_3
    //   258: ifnull -248 -> 10
    //   261: aload_3
    //   262: invokevirtual 49	java/lang/Object:toString	()Ljava/lang/String;
    //   265: astore_0
    //   266: goto -256 -> 10
    //   269: astore_3
    //   270: aload_3
    //   271: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   274: goto -42 -> 232
    //   277: astore_2
    //   278: ldc 16
    //   280: astore_2
    //   281: aload_0
    //   282: ldc 60
    //   284: iconst_0
    //   285: invokevirtual 64	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   288: invokeinterface 70 1 0
    //   293: ldc 72
    //   295: ldc 16
    //   297: invokeinterface 78 3 0
    //   302: invokeinterface 82 1 0
    //   307: pop
    //   308: ldc 152
    //   310: iconst_0
    //   311: anewarray 4	java/lang/Object
    //   314: invokestatic 155	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   317: aload_2
    //   318: astore 4
    //   320: aload_3
    //   321: ifnull +90 -> 411
    //   324: aload_3
    //   325: invokevirtual 145	java/io/InputStream:close	()V
    //   328: goto -96 -> 232
    //   331: astore_3
    //   332: aload_3
    //   333: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   336: goto -104 -> 232
    //   339: astore_0
    //   340: aconst_null
    //   341: astore_2
    //   342: aload_2
    //   343: ifnull +7 -> 350
    //   346: aload_2
    //   347: invokevirtual 145	java/io/InputStream:close	()V
    //   350: aload_0
    //   351: athrow
    //   352: astore_2
    //   353: aload_2
    //   354: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   357: goto -7 -> 350
    //   360: astore_0
    //   361: ldc 157
    //   363: iconst_0
    //   364: anewarray 4	java/lang/Object
    //   367: invokestatic 119	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   370: aload_2
    //   371: astore_0
    //   372: goto -362 -> 10
    //   375: astore_0
    //   376: goto -34 -> 342
    //   379: astore_0
    //   380: aload_3
    //   381: astore_2
    //   382: goto -40 -> 342
    //   385: astore_3
    //   386: ldc 16
    //   388: astore 4
    //   390: aload_2
    //   391: astore_3
    //   392: aload 4
    //   394: astore_2
    //   395: goto -114 -> 281
    //   398: astore 4
    //   400: aload_3
    //   401: astore 4
    //   403: aload_2
    //   404: astore_3
    //   405: aload 4
    //   407: astore_2
    //   408: goto -127 -> 281
    //   411: aload 4
    //   413: astore_2
    //   414: goto -182 -> 232
    //   417: ldc 16
    //   419: astore_2
    //   420: aload 4
    //   422: astore_3
    //   423: goto -202 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	paramContext	Context
    //   177	2	1	bool	boolean
    //   46	210	2	localObject1	Object
    //   277	1	2	localException1	Exception
    //   280	67	2	str1	String
    //   352	19	2	localIOException1	java.io.IOException
    //   381	39	2	localObject2	Object
    //   16	246	3	localObject3	Object
    //   269	56	3	localIOException2	java.io.IOException
    //   331	50	3	localIOException3	java.io.IOException
    //   385	1	3	localException2	Exception
    //   391	32	3	localObject4	Object
    //   18	375	4	localObject5	Object
    //   398	1	4	localException3	Exception
    //   401	20	4	localObject6	Object
    //   42	6	5	str2	String
    //   24	96	6	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   188	192	197	java/io/IOException
    //   20	26	207	finally
    //   188	192	207	finally
    //   198	202	207	finally
    //   228	232	207	finally
    //   232	255	207	finally
    //   261	266	207	finally
    //   270	274	207	finally
    //   324	328	207	finally
    //   332	336	207	finally
    //   346	350	207	finally
    //   350	352	207	finally
    //   353	357	207	finally
    //   361	370	207	finally
    //   228	232	269	java/io/IOException
    //   26	44	277	java/lang/Exception
    //   47	57	277	java/lang/Exception
    //   60	87	277	java/lang/Exception
    //   87	126	277	java/lang/Exception
    //   324	328	331	java/io/IOException
    //   26	44	339	finally
    //   47	57	339	finally
    //   60	87	339	finally
    //   87	126	339	finally
    //   346	350	352	java/io/IOException
    //   232	255	360	java/lang/Throwable
    //   261	266	360	java/lang/Throwable
    //   126	148	375	finally
    //   148	178	375	finally
    //   281	317	379	finally
    //   126	148	385	java/lang/Exception
    //   148	178	398	java/lang/Exception
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).getString(paramString1, paramString2);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("DENGTA_META", 0).edit().putString("key_initsdktimes", paramString).commit();
  }
  
  public static void c(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("DENGTA_META", 0).edit().putString("key_initsdkdate", paramString).commit();
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        com.tencent.beacon.d.a.d("context == null return null", new Object[0]);
        return bool2;
      }
      finally {}
      boolean bool1 = bool3;
      try
      {
        String str2 = paramContext.getApplicationContext().getSharedPreferences("DENGTA_META", 0).getString("APPKEY_DENGTA", null);
        bool1 = bool3;
        String str1 = a(paramContext);
        if (str2 != null)
        {
          bool1 = bool3;
          if (str2.equals(str1)) {}
        }
        else
        {
          bool3 = true;
          bool2 = true;
          bool1 = bool3;
          paramContext = paramContext.getApplicationContext().getSharedPreferences("DENGTA_META", 0).edit();
          bool1 = bool3;
          paramContext.putString("APPKEY_DENGTA", str1);
          bool1 = bool3;
          paramContext.commit();
        }
      }
      catch (Exception paramContext)
      {
        com.tencent.beacon.d.a.b("updateLocalAPPKEY fail!", new Object[0]);
        paramContext.printStackTrace();
        bool2 = bool1;
      }
    }
  }
  
  public static boolean d(Context paramContext)
  {
    if (paramContext == null) {
      com.tencent.beacon.d.a.d("context == null return null", new Object[0]);
    }
    for (;;)
    {
      return false;
      try
      {
        String str2 = paramContext.getApplicationContext().getSharedPreferences("DENGTA_META", 0).getString("APPVER_DENGTA", null);
        String str1 = f(paramContext);
        if (str2 != null)
        {
          bool = str2.equals(str1);
          if (bool) {}
        }
        else
        {
          bool = true;
          com.tencent.beacon.d.a.b("updateLocalAPPKEY fail!", new Object[0]);
        }
      }
      catch (Exception paramContext)
      {
        try
        {
          paramContext = paramContext.getApplicationContext().getSharedPreferences("DENGTA_META", 0).edit();
          paramContext.putString("APPVER_DENGTA", str1);
          paramContext.commit();
          return true;
        }
        catch (Exception paramContext)
        {
          boolean bool;
          break;
        }
        paramContext = paramContext;
        bool = false;
      }
    }
    paramContext.printStackTrace();
    return bool;
  }
  
  private static boolean d(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.trim().length() <= 0)) {
      return false;
    }
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if ((paramContext == null) || (paramContext.size() == 0))
      {
        com.tencent.beacon.d.a.b("no running proc", new Object[0]);
        return false;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        Object localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).importance == 100)
        {
          localObject = ((ActivityManager.RunningAppProcessInfo)localObject).pkgList;
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            boolean bool = paramString.equals(localObject[i]);
            if (bool) {
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
      paramContext.printStackTrace();
      com.tencent.beacon.d.a.d("Failed to judge }[%s]", new Object[] { paramContext.getLocalizedMessage() });
    }
  }
  
  public static String e(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getPackageName();
  }
  
  public static String f(Context paramContext)
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
        com.tencent.beacon.d.a.d(paramContext.toString(), new Object[0]);
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
          com.tencent.beacon.d.a.a("add versionCode: %s", new Object[] { Integer.valueOf(m) });
          paramContext = paramContext + "." + m;
        }
        for (;;)
        {
          com.tencent.beacon.d.a.a("version: %s", new Object[] { paramContext });
          break;
        }
      }
      i += 1;
    }
  }
  
  public static boolean g(Context paramContext)
  {
    return d(paramContext, paramContext.getPackageName());
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
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.a.a
 * JD-Core Version:    0.7.0.1
 */