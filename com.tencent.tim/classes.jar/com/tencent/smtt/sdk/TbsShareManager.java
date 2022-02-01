package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class TbsShareManager
{
  private static Context a;
  private static boolean b;
  private static String c = null;
  private static String d = "";
  private static String e = null;
  private static int f = 0;
  private static String g = null;
  private static boolean h = false;
  private static boolean i = false;
  private static boolean j = false;
  private static String k = null;
  private static boolean l = false;
  private static boolean m = false;
  public static boolean mHasQueryed = false;
  
  private static int a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      paramContext = new File(new File(FileUtil.a(getPackageContext(paramContext, paramString, false), paramInt)), TbsDownloader.getBackupFileName(false));
      if ((paramContext.exists()) && (paramContext.canRead())) {
        return a.b(paramContext);
      }
      TbsLog.i("TbsShareManager", "getSDCoreVersion,file not exist" + paramContext);
      return 0;
    }
    catch (Throwable paramContext)
    {
      TbsLog.i("TbsShareManager", "getSDCoreVersion exception,pkg=" + paramString + ", package not found.");
    }
    return 0;
  }
  
  static int a(Context paramContext, boolean paramBoolean)
  {
    b(paramContext, paramBoolean);
    return f;
  }
  
  static String a()
  {
    return e;
  }
  
  static void a(Context paramContext)
  {
    TbsLog.i("TbsShareManager", "shareTbsCore #1");
    try
    {
      TbsLinuxToolsJni localTbsLinuxToolsJni = new TbsLinuxToolsJni(paramContext);
      a(paramContext, localTbsLinuxToolsJni, q.a().r(paramContext));
      paramContext = q.a().s(paramContext);
      TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir is " + paramContext.getAbsolutePath());
      localTbsLinuxToolsJni.a(paramContext.getAbsolutePath(), "755");
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir error is " + paramContext.getMessage() + " ## " + paramContext.getCause());
      paramContext.printStackTrace();
    }
  }
  
  private static void a(Context paramContext, int paramInt)
  {
    if (!TbsPVConfig.getInstance(a).isDisableHostBackupCore())
    {
      if (q.a().u(paramContext))
      {
        Object localObject1 = new String[5];
        localObject1[0] = "com.tencent.tbs";
        localObject1[1] = "com.tencent.mm";
        localObject1[2] = "com.tencent.mobileqq";
        localObject1[3] = "com.qzone";
        localObject1[4] = paramContext.getPackageName();
        TbsLog.i("TbsShareManager", "find host backup core to unzip #1" + Log.getStackTraceString(new Throwable()));
        int i1 = localObject1.length;
        int n = 0;
        String str1;
        int i2;
        Object localObject2;
        if (n < i1)
        {
          str1 = localObject1[n];
          i2 = getBackupCoreVersion(paramContext, str1);
          if (paramInt != i2) {
            break label438;
          }
          TbsLog.i("TbsShareManager", "installCoreWithUnzip getBackupCoreVersion ok, packageName is " + str1 + " result version is " + i2);
          localObject2 = getPackageContext(paramContext, str1, false);
          if (!q.a().g((Context)localObject2)) {
            TbsLog.i("TbsShareManager", "find host backup core to unzip,verify app failed,pkgName=" + str1);
          }
        }
        for (;;)
        {
          n += 1;
          break;
          localObject2 = getBackupCoreFile(paramContext, str1);
          if (!a.a(paramContext, (File)localObject2, 0L, paramInt))
          {
            TbsLog.i("TbsShareManager", "find host backup core to unzip,verify apk failed,pkgName=" + str1 + ";apk=" + ((File)localObject2).getAbsolutePath());
          }
          else
          {
            TbsLog.i("TbsShareManager", "find host backup core to unzip normal coreVersion is " + paramInt + " packageName is " + str1);
            localObject1 = "";
            try
            {
              str1 = str1.substring(str1.length() - 2);
              localObject1 = str1;
            }
            catch (Throwable localThrowable1)
            {
              for (;;)
              {
                TbsLog.i("TbsDownload", "throwable is " + Log.getStackTraceString(localThrowable1));
              }
            }
            com.tencent.smtt.utils.q.a("7is" + paramInt + (String)localObject1);
            localObject1 = "coreVersionIs" + paramInt;
            com.tencent.smtt.utils.q.a(a, "copy_host_core_v2", (String)localObject1);
            q.a().a(paramContext, (File)localObject2, paramInt);
            for (;;)
            {
              q.a().b();
              return;
              label438:
              TbsLog.i("TbsShareManager", "installCoreWithUnzip getBackupCoreVersion fail, packageName is " + localThrowable1 + " result version is " + i2);
              i2 = getBackupDecoupleCoreVersion(paramContext, localThrowable1);
              if (paramInt == i2)
              {
                TbsLog.i("TbsShareManager", "installCoreWithUnzip getBackupDecoupleCoreVersion ok, packageName is " + localThrowable1 + " result version is " + i2);
                localObject2 = getPackageContext(paramContext, localThrowable1, false);
                if (!q.a().g((Context)localObject2)) {
                  break;
                }
                localObject2 = getBackupDecoupleCoreFile(paramContext, localThrowable1);
                if (!a.a(paramContext, (File)localObject2, 0L, paramInt)) {
                  break;
                }
                TbsLog.i("TbsShareManager", "find host backup core to unzip decouple coreVersion is " + paramInt + " packageName is " + localThrowable1);
                localObject1 = "";
                try
                {
                  String str2 = localThrowable1.substring(localThrowable1.length() - 2);
                  localObject1 = str2;
                }
                catch (Throwable localThrowable2)
                {
                  for (;;)
                  {
                    TbsLog.i("TbsDownload", "throwable is " + Log.getStackTraceString(localThrowable2));
                  }
                }
                com.tencent.smtt.utils.q.a("7is" + paramInt + (String)localObject1);
                localObject1 = "coreVersionIs" + paramInt;
                com.tencent.smtt.utils.q.a(a, "copy_host_core_v2", (String)localObject1);
                q.a().a(paramContext, (File)localObject2, paramInt);
                continue;
              }
              TbsLog.i("TbsShareManager", "installCoreWithUnzip getBackupDecoupleCoreVersion fail, packageName is " + localThrowable2 + " result version is " + i2);
              i2 = getStableCoreVersion(paramContext, localThrowable2);
              if (paramInt != i2) {
                break label1084;
              }
              TbsLog.i("TbsShareManager", "installCoreWithUnzip getStableCoreVersion ok, packageName is " + localThrowable2 + " result version is " + i2);
              localObject2 = getPackageContext(paramContext, localThrowable2, false);
              if (!q.a().g((Context)localObject2))
              {
                TbsLog.i("TbsShareManager", "find host backup core to unzip,verify app failed,pkgName=" + localThrowable2);
                break;
              }
              localObject2 = getStableCoreFile(paramContext, localThrowable2);
              if (!a.a(paramContext, (File)localObject2, 0L, paramInt))
              {
                TbsLog.i("TbsShareManager", "find host backup core to unzip,verify apk failed,pkgName=" + localThrowable2 + ";apk=" + ((File)localObject2).getAbsolutePath());
                break;
              }
              TbsLog.i("TbsShareManager", "find host backup core to unzip normal coreVersion is " + paramInt + " packageName is " + localThrowable2);
              localObject1 = "";
              try
              {
                String str3 = localThrowable2.substring(localThrowable2.length() - 2);
                localObject1 = str3;
              }
              catch (Throwable localThrowable3)
              {
                for (;;)
                {
                  TbsLog.i("TbsDownload", "throwable is " + Log.getStackTraceString(localThrowable3));
                }
              }
              com.tencent.smtt.utils.q.a("7is" + paramInt + (String)localObject1);
              localObject1 = "coreVersionIs" + paramInt;
              com.tencent.smtt.utils.q.a(a, "copy_host_core_v2", (String)localObject1);
              q.a().a(paramContext, (File)localObject2, paramInt);
            }
            label1084:
            TbsLog.i("TbsShareManager", "installCoreWithUnzip getBackupCoreVersion fail, packageName is " + localThrowable3 + " result version is " + i2);
          }
        }
      }
      TbsLog.i("TbsShareManager", "installCoreWithUnzip do nothing #2");
      return;
    }
    TbsLog.i("TbsShareManager", "installCoreWithUnzip do nothing #1");
  }
  
  private static void a(Context paramContext, TbsLinuxToolsJni paramTbsLinuxToolsJni, File paramFile)
  {
    TbsLog.i("TbsShareManager", "shareAllDirsAndFiles #1");
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {
      return;
    }
    TbsLog.i("TbsShareManager", "shareAllDirsAndFiles dir is " + paramFile.getAbsolutePath());
    paramTbsLinuxToolsJni.a(paramFile.getAbsolutePath(), "755");
    paramFile = paramFile.listFiles();
    int i1 = paramFile.length;
    int n = 0;
    label77:
    File localFile;
    if (n < i1)
    {
      localFile = paramFile[n];
      if (!localFile.isFile()) {
        break label145;
      }
      if (localFile.getAbsolutePath().indexOf(".so") <= 0) {
        break label129;
      }
      paramTbsLinuxToolsJni.a(localFile.getAbsolutePath(), "755");
    }
    for (;;)
    {
      n += 1;
      break label77;
      break;
      label129:
      paramTbsLinuxToolsJni.a(localFile.getAbsolutePath(), "644");
      continue;
      label145:
      if (localFile.isDirectory()) {
        a(paramContext, paramTbsLinuxToolsJni, localFile);
      } else {
        TbsLog.e("TbsShareManager", "unknown file type.", true);
      }
    }
  }
  
  static void b(Context paramContext)
  {
    try
    {
      a(paramContext, new TbsLinuxToolsJni(paramContext), q.a().q(paramContext));
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  static boolean b(Context paramContext, boolean paramBoolean)
  {
    if (i(paramContext)) {
      return true;
    }
    if (paramBoolean) {
      QbSdk.a(paramContext, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
    }
    return false;
  }
  
  static String c(Context paramContext)
  {
    j(paramContext);
    return e;
  }
  
  /* Error */
  private static void c(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: ldc_w 342
    //   10: invokestatic 345	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   13: astore 9
    //   15: aload 9
    //   17: ifnonnull +28 -> 45
    //   20: iconst_0
    //   21: ifeq +11 -> 32
    //   24: new 347	java/lang/NullPointerException
    //   27: dup
    //   28: invokespecial 348	java/lang/NullPointerException:<init>	()V
    //   31: athrow
    //   32: iconst_0
    //   33: ifeq +11 -> 44
    //   36: new 347	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 348	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: return
    //   45: new 350	java/io/BufferedInputStream
    //   48: dup
    //   49: new 352	java/io/FileInputStream
    //   52: dup
    //   53: aload 9
    //   55: invokespecial 355	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   58: invokespecial 358	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore_3
    //   62: new 360	java/util/Properties
    //   65: dup
    //   66: invokespecial 361	java/util/Properties:<init>	()V
    //   69: astore 6
    //   71: aload 6
    //   73: aload_3
    //   74: invokevirtual 364	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   77: aload 6
    //   79: ldc_w 366
    //   82: iconst_0
    //   83: invokestatic 369	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   86: invokevirtual 373	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   89: pop
    //   90: iload_1
    //   91: ifeq +64 -> 155
    //   94: invokestatic 135	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   97: aload_0
    //   98: invokevirtual 139	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   101: invokevirtual 150	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   104: astore 7
    //   106: aload_0
    //   107: invokevirtual 377	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   110: invokevirtual 200	android/content/Context:getPackageName	()Ljava/lang/String;
    //   113: astore 8
    //   115: aload_0
    //   116: invokestatic 382	com/tencent/smtt/utils/b:e	(Landroid/content/Context;)I
    //   119: istore_2
    //   120: aload 6
    //   122: ldc_w 384
    //   125: aload 8
    //   127: invokevirtual 373	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   130: pop
    //   131: aload 6
    //   133: ldc_w 386
    //   136: aload 7
    //   138: invokevirtual 373	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   141: pop
    //   142: aload 6
    //   144: ldc_w 388
    //   147: iload_2
    //   148: invokestatic 390	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   151: invokevirtual 373	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   154: pop
    //   155: new 392	java/io/BufferedOutputStream
    //   158: dup
    //   159: new 394	java/io/FileOutputStream
    //   162: dup
    //   163: aload 9
    //   165: invokespecial 395	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   168: invokespecial 398	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   171: astore_0
    //   172: aload 6
    //   174: aload_0
    //   175: aconst_null
    //   176: invokevirtual 402	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   179: aload_3
    //   180: ifnull +7 -> 187
    //   183: aload_3
    //   184: invokevirtual 405	java/io/BufferedInputStream:close	()V
    //   187: aload_0
    //   188: ifnull -144 -> 44
    //   191: aload_0
    //   192: invokevirtual 406	java/io/BufferedOutputStream:close	()V
    //   195: return
    //   196: astore_0
    //   197: return
    //   198: astore 4
    //   200: aconst_null
    //   201: astore_0
    //   202: aload 5
    //   204: astore_3
    //   205: aload 4
    //   207: invokevirtual 169	java/lang/Throwable:printStackTrace	()V
    //   210: aload_0
    //   211: ifnull +7 -> 218
    //   214: aload_0
    //   215: invokevirtual 405	java/io/BufferedInputStream:close	()V
    //   218: aload_3
    //   219: ifnull -175 -> 44
    //   222: aload_3
    //   223: invokevirtual 406	java/io/BufferedOutputStream:close	()V
    //   226: return
    //   227: astore_0
    //   228: return
    //   229: astore_0
    //   230: aconst_null
    //   231: astore_3
    //   232: aload_3
    //   233: ifnull +7 -> 240
    //   236: aload_3
    //   237: invokevirtual 405	java/io/BufferedInputStream:close	()V
    //   240: aload 4
    //   242: ifnull +8 -> 250
    //   245: aload 4
    //   247: invokevirtual 406	java/io/BufferedOutputStream:close	()V
    //   250: aload_0
    //   251: athrow
    //   252: astore_0
    //   253: goto -221 -> 32
    //   256: astore_0
    //   257: return
    //   258: astore_3
    //   259: goto -72 -> 187
    //   262: astore_0
    //   263: goto -45 -> 218
    //   266: astore_3
    //   267: goto -27 -> 240
    //   270: astore_3
    //   271: goto -21 -> 250
    //   274: astore_0
    //   275: goto -43 -> 232
    //   278: astore 5
    //   280: aload_0
    //   281: astore 4
    //   283: aload 5
    //   285: astore_0
    //   286: goto -54 -> 232
    //   289: astore 4
    //   291: aload_0
    //   292: astore 5
    //   294: aload 4
    //   296: astore_0
    //   297: aload_3
    //   298: astore 4
    //   300: aload 5
    //   302: astore_3
    //   303: goto -71 -> 232
    //   306: astore 4
    //   308: aload_3
    //   309: astore_0
    //   310: aload 5
    //   312: astore_3
    //   313: goto -108 -> 205
    //   316: astore 4
    //   318: aload_3
    //   319: astore 5
    //   321: aload_0
    //   322: astore_3
    //   323: aload 5
    //   325: astore_0
    //   326: goto -121 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	paramContext	Context
    //   0	329	1	paramBoolean	boolean
    //   119	29	2	n	int
    //   61	176	3	localObject1	Object
    //   258	1	3	localException1	Exception
    //   266	1	3	localException2	Exception
    //   270	28	3	localException3	Exception
    //   302	21	3	localObject2	Object
    //   1	1	4	localObject3	Object
    //   198	48	4	localThrowable1	Throwable
    //   281	1	4	localContext	Context
    //   289	6	4	localObject4	Object
    //   298	1	4	localObject5	Object
    //   306	1	4	localThrowable2	Throwable
    //   316	1	4	localThrowable3	Throwable
    //   4	199	5	localObject6	Object
    //   278	6	5	localObject7	Object
    //   292	32	5	localObject8	Object
    //   69	104	6	localProperties	java.util.Properties
    //   104	33	7	str1	String
    //   113	13	8	str2	String
    //   13	151	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   191	195	196	java/lang/Exception
    //   6	15	198	java/lang/Throwable
    //   45	62	198	java/lang/Throwable
    //   222	226	227	java/lang/Exception
    //   6	15	229	finally
    //   45	62	229	finally
    //   24	32	252	java/lang/Exception
    //   36	44	256	java/lang/Exception
    //   183	187	258	java/lang/Exception
    //   214	218	262	java/lang/Exception
    //   236	240	266	java/lang/Exception
    //   245	250	270	java/lang/Exception
    //   62	90	274	finally
    //   94	155	274	finally
    //   155	172	274	finally
    //   172	179	278	finally
    //   205	210	289	finally
    //   62	90	306	java/lang/Throwable
    //   94	155	306	java/lang/Throwable
    //   155	172	306	java/lang/Throwable
    //   172	179	316	java/lang/Throwable
  }
  
  static int d(Context paramContext)
  {
    return a(paramContext, true);
  }
  
  private static String[] d(Context paramContext, boolean paramBoolean)
  {
    String[] arrayOfString;
    if (QbSdk.getOnlyDownload())
    {
      arrayOfString = new String[1];
      arrayOfString[0] = paramContext.getApplicationContext().getPackageName();
    }
    do
    {
      return arrayOfString;
      arrayOfString = getCoreProviderAppList();
    } while (!paramBoolean);
    return new String[] { paramContext.getApplicationContext().getPackageName() };
  }
  
  static Context e(Context paramContext)
  {
    Object localObject2 = null;
    j(paramContext);
    Object localObject1 = localObject2;
    if (g != null)
    {
      localObject1 = getPackageContext(paramContext, g, true);
      if (q.a().g((Context)localObject1)) {
        break label48;
      }
      localObject1 = localObject2;
    }
    label48:
    for (;;)
    {
      if (c != null) {
        localObject1 = a;
      }
      return localObject1;
    }
  }
  
  /* Error */
  static String f(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: aload_0
    //   7: ldc_w 342
    //   10: invokestatic 345	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnonnull +23 -> 38
    //   18: aload 4
    //   20: astore_0
    //   21: iconst_0
    //   22: ifeq +11 -> 33
    //   25: new 347	java/lang/NullPointerException
    //   28: dup
    //   29: invokespecial 348	java/lang/NullPointerException:<init>	()V
    //   32: athrow
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: areturn
    //   38: new 350	java/io/BufferedInputStream
    //   41: dup
    //   42: new 352	java/io/FileInputStream
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 355	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   50: invokespecial 358	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   53: astore_2
    //   54: aload_2
    //   55: astore_0
    //   56: new 360	java/util/Properties
    //   59: dup
    //   60: invokespecial 361	java/util/Properties:<init>	()V
    //   63: astore_3
    //   64: aload_2
    //   65: astore_0
    //   66: aload_3
    //   67: aload_2
    //   68: invokevirtual 364	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   71: aload_2
    //   72: astore_0
    //   73: aload_3
    //   74: ldc_w 384
    //   77: ldc 30
    //   79: invokevirtual 421	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   82: astore_3
    //   83: aload_2
    //   84: astore_0
    //   85: ldc 30
    //   87: aload_3
    //   88: invokevirtual 425	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   91: istore_1
    //   92: iload_1
    //   93: ifne +16 -> 109
    //   96: aload_2
    //   97: ifnull +7 -> 104
    //   100: aload_2
    //   101: invokevirtual 405	java/io/BufferedInputStream:close	()V
    //   104: aload_3
    //   105: astore_0
    //   106: goto -73 -> 33
    //   109: aload 4
    //   111: astore_0
    //   112: aload_2
    //   113: ifnull -80 -> 33
    //   116: aload_2
    //   117: invokevirtual 405	java/io/BufferedInputStream:close	()V
    //   120: aload 4
    //   122: astore_0
    //   123: goto -90 -> 33
    //   126: astore_0
    //   127: aload 4
    //   129: astore_0
    //   130: goto -97 -> 33
    //   133: astore_3
    //   134: aconst_null
    //   135: astore_2
    //   136: aload_2
    //   137: astore_0
    //   138: aload_3
    //   139: invokevirtual 169	java/lang/Throwable:printStackTrace	()V
    //   142: aload 4
    //   144: astore_0
    //   145: aload_2
    //   146: ifnull -113 -> 33
    //   149: aload_2
    //   150: invokevirtual 405	java/io/BufferedInputStream:close	()V
    //   153: aload 4
    //   155: astore_0
    //   156: goto -123 -> 33
    //   159: astore_0
    //   160: aload 4
    //   162: astore_0
    //   163: goto -130 -> 33
    //   166: astore_2
    //   167: aconst_null
    //   168: astore_0
    //   169: aload_0
    //   170: ifnull +7 -> 177
    //   173: aload_0
    //   174: invokevirtual 405	java/io/BufferedInputStream:close	()V
    //   177: aload_2
    //   178: athrow
    //   179: astore_0
    //   180: ldc 2
    //   182: monitorexit
    //   183: aload_0
    //   184: athrow
    //   185: astore_0
    //   186: aload 4
    //   188: astore_0
    //   189: goto -156 -> 33
    //   192: astore_0
    //   193: goto -89 -> 104
    //   196: astore_0
    //   197: goto -20 -> 177
    //   200: astore_2
    //   201: goto -32 -> 169
    //   204: astore_3
    //   205: goto -69 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramContext	Context
    //   91	2	1	bool	boolean
    //   53	97	2	localBufferedInputStream	java.io.BufferedInputStream
    //   166	12	2	localObject1	Object
    //   200	1	2	localObject2	Object
    //   63	42	3	localObject3	Object
    //   133	6	3	localThrowable1	Throwable
    //   204	1	3	localThrowable2	Throwable
    //   1	186	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   116	120	126	java/lang/Exception
    //   6	14	133	java/lang/Throwable
    //   38	54	133	java/lang/Throwable
    //   149	153	159	java/lang/Exception
    //   6	14	166	finally
    //   38	54	166	finally
    //   25	33	179	finally
    //   100	104	179	finally
    //   116	120	179	finally
    //   149	153	179	finally
    //   173	177	179	finally
    //   177	179	179	finally
    //   25	33	185	java/lang/Exception
    //   100	104	192	java/lang/Exception
    //   173	177	196	java/lang/Exception
    //   56	64	200	finally
    //   66	71	200	finally
    //   73	83	200	finally
    //   85	92	200	finally
    //   138	142	200	finally
    //   56	64	204	java/lang/Throwable
    //   66	71	204	java/lang/Throwable
    //   73	83	204	java/lang/Throwable
    //   85	92	204	java/lang/Throwable
  }
  
  public static int findCoreForThirdPartyApp(Context paramContext)
  {
    n(paramContext);
    TbsLog.i("TbsShareManager", "findCoreForThirdPartyApp", "core_info mAvailableCoreVersion is " + f + " mAvailableCorePath is " + e + " mSrcPackageName is " + g);
    if ((g != null) && (g.equals("AppDefined"))) {
      if (f != q.a().a(c))
      {
        f = 0;
        e = null;
        g = null;
        TbsLog.w("TbsShareManager", "findCoreForThirdPartyApp", "check AppDefined core is error src is " + f + " dest is " + q.a().a(c));
      }
    }
    for (;;)
    {
      if ((f > 0) && (h))
      {
        f = 0;
        e = null;
        g = null;
        TbsLog.i("TbsShareManager", "findCoreForThirdPartyApp", "mCoreDisabled");
      }
      return f;
      if ((!k(paramContext)) && (!l(paramContext)))
      {
        f = 0;
        e = null;
        g = null;
        TbsLog.w("TbsShareManager", "findCoreForThirdPartyApp", "checkCoreInfo is false and checkCoreInOthers is false ");
      }
    }
  }
  
  public static boolean forceLoadX5FromTBSDemo(Context paramContext)
  {
    return false;
  }
  
  public static void forceToLoadX5ForThirdApp(Context paramContext, boolean paramBoolean) {}
  
  static String g(Context paramContext)
  {
    try
    {
      n(paramContext);
      if (e != null)
      {
        if (TextUtils.isEmpty(e)) {
          return null;
        }
        paramContext = new StringBuilder(e);
        paramContext.append(File.separator);
        paramContext.append("res.apk");
        return paramContext.toString();
      }
    }
    catch (Throwable paramContext)
    {
      Log.e("", "getTbsResourcesPath exception: " + Log.getStackTraceString(paramContext));
    }
    return null;
  }
  
  public static File getBackupCoreFile(Context paramContext, String paramString)
  {
    return getSDCoreFile(paramContext, paramString, 3);
  }
  
  public static int getBackupCoreVersion(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, 3);
  }
  
  public static File getBackupDecoupleCoreFile(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new File(new File(FileUtil.a(getPackageContext(paramContext, paramString, false), 4)), TbsDownloader.getBackupFileName(true));
      boolean bool = paramContext.exists();
      if (bool) {
        return paramContext;
      }
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static int getBackupDecoupleCoreVersion(Context paramContext, String paramString)
  {
    int i1 = 0;
    try
    {
      paramContext = new File(new File(FileUtil.a(getPackageContext(paramContext, paramString, false), 4)), TbsDownloader.getBackupFileName(true));
      int n = i1;
      if (paramContext.exists())
      {
        n = i1;
        if (paramContext.canRead()) {
          n = a.b(paramContext);
        }
      }
      return n;
    }
    catch (Throwable paramContext)
    {
      TbsLog.i("TbsShareManager", "getBackupDecoupleCoreVersion exception,pkg=" + paramString + ",package not found.");
    }
    return 0;
  }
  
  public static boolean getCoreDisabled()
  {
    return h;
  }
  
  public static boolean getCoreFormOwn()
  {
    return l;
  }
  
  public static String[] getCoreProviderAppList()
  {
    return new String[] { "com.tencent.tbs", "com.tencent.mm", "com.tencent.mobileqq", "com.qzone", "com.tencent.qqlite" };
  }
  
  public static int getCoreShareDecoupleCoreVersion(Context paramContext, String paramString)
  {
    return 0;
  }
  
  public static String getHostCorePathAppDefined()
  {
    return c;
  }
  
  public static long getHostCoreVersions(Context paramContext)
  {
    String[] arrayOfString = getCoreProviderAppList();
    int i1 = arrayOfString.length;
    long l2 = 0L;
    int n = 0;
    if (n < i1)
    {
      String str = arrayOfString[n];
      long l1;
      if (str.equalsIgnoreCase("com.tencent.mm")) {
        l1 = l2 + getSharedTbsCoreVersion(paramContext, str) * 10000000000L;
      }
      for (;;)
      {
        n += 1;
        l2 = l1;
        break;
        if (str.equalsIgnoreCase("com.tencent.mobileqq"))
        {
          l1 = l2 + getSharedTbsCoreVersion(paramContext, str) * 100000L;
        }
        else
        {
          l1 = l2;
          if (str.equalsIgnoreCase("com.qzone")) {
            l1 = l2 + getSharedTbsCoreVersion(paramContext, str);
          }
        }
      }
    }
    return l2;
  }
  
  public static Context getPackageContext(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if ((!paramContext.getPackageName().equals(paramString)) && (!"com.tencent.tbs".equals(paramString)) && ((TbsPVConfig.getInstance(paramContext).isEnableNoCoreGray()) || (Build.VERSION.SDK_INT >= 29)))
      {
        TbsLog.i("TbsShareManager", "getPackageContext,ctx=" + paramContext + ";pkgName=" + paramString + ";isShare=" + paramBoolean);
        return null;
      }
      paramContext = paramContext.createPackageContext(paramString, 2);
      Log.d("TbsDownload", "getPackageContext context is " + paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      Log.d("TbsDownload", "getPackageContext stack is " + Log.getStackTraceString(paramContext));
    }
    return null;
  }
  
  public static File getSDCoreFile(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      paramContext = new File(new File(FileUtil.a(getPackageContext(paramContext, paramString, false), paramInt)), TbsDownloader.getBackupFileName(false));
      if (paramContext.exists())
      {
        boolean bool = paramContext.canRead();
        if (bool) {
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static int getSharedTbsCoreVersion(Context paramContext, String paramString)
  {
    paramContext = getPackageContext(paramContext, paramString, true);
    if (paramContext != null) {
      return q.a().j(paramContext);
    }
    return 0;
  }
  
  public static File getStableCoreFile(Context paramContext, String paramString)
  {
    return getSDCoreFile(paramContext, paramString, 4);
  }
  
  public static int getStableCoreVersion(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, 4);
  }
  
  public static String getStableCoreZeroReason()
  {
    return d;
  }
  
  public static File getTbsShareFile(Context paramContext, String paramString)
  {
    paramContext = q.a().s(paramContext);
    if (paramContext == null) {
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if ((paramContext != null) && (paramContext.exists())) {
      return paramContext;
    }
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static int getTbsStableCoreVersion(Context paramContext, int paramInt)
  {
    int n;
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = getPackageContext(paramContext, "com.tencent.mm", false);
        if (localObject == null)
        {
          localObject = new File(FileUtil.a(paramContext, "com.tencent.mm", 4, true));
          localObject = new File((File)localObject, TbsDownloader.getBackupFileName(false, paramInt));
          TbsLog.i("TbsDownload", "getTbsStableCoreVersion, coreStable is " + ((File)localObject).getAbsolutePath());
          d = "none";
          if ((((File)localObject).exists()) && (((File)localObject).canRead()))
          {
            n = a.b((File)localObject);
            if (n > 0) {
              break;
            }
            return a.a(paramContext, (File)localObject, paramInt);
          }
        }
        else
        {
          localObject = new File(FileUtil.a((Context)localObject, 4));
          continue;
        }
        TbsLog.i("TbsDownload", "getTbsStableCoreVersion,core stable not exist" + localObject);
      }
      catch (Throwable paramContext)
      {
        TbsLog.i("TbsDownload", "getTbsStableCoreVersion stack is " + Log.getStackTraceString(paramContext));
        d = Log.getStackTraceString(paramContext);
        return 0;
      }
      d = ((File)localObject).getAbsolutePath() + " exist is " + ((File)localObject).exists() + " canRead is " + ((File)localObject).canRead();
    }
    return n;
  }
  
  /* Error */
  static int h(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 94
    //   7: ldc_w 566
    //   10: invokestatic 115	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: aconst_null
    //   14: astore 4
    //   16: aload_0
    //   17: ldc_w 342
    //   20: invokestatic 345	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   23: astore_0
    //   24: aload_0
    //   25: ifnonnull +46 -> 71
    //   28: ldc 94
    //   30: ldc_w 568
    //   33: invokestatic 115	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: iload_2
    //   37: istore_1
    //   38: iconst_0
    //   39: ifeq +11 -> 50
    //   42: new 347	java/lang/NullPointerException
    //   45: dup
    //   46: invokespecial 348	java/lang/NullPointerException:<init>	()V
    //   49: athrow
    //   50: ldc 2
    //   52: monitorexit
    //   53: iload_1
    //   54: ireturn
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 569	java/lang/Exception:printStackTrace	()V
    //   60: iload_2
    //   61: istore_1
    //   62: goto -12 -> 50
    //   65: astore_0
    //   66: ldc 2
    //   68: monitorexit
    //   69: aload_0
    //   70: athrow
    //   71: new 350	java/io/BufferedInputStream
    //   74: dup
    //   75: new 352	java/io/FileInputStream
    //   78: dup
    //   79: aload_0
    //   80: invokespecial 355	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   83: invokespecial 358	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: astore_3
    //   87: new 360	java/util/Properties
    //   90: dup
    //   91: invokespecial 361	java/util/Properties:<init>	()V
    //   94: astore_0
    //   95: aload_0
    //   96: aload_3
    //   97: invokevirtual 364	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   100: aload_0
    //   101: ldc_w 571
    //   104: ldc 30
    //   106: invokevirtual 421	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   109: astore_0
    //   110: ldc 30
    //   112: aload_0
    //   113: invokevirtual 425	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   116: ifne +45 -> 161
    //   119: ldc 94
    //   121: ldc_w 573
    //   124: invokestatic 115	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_0
    //   128: invokestatic 578	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   131: iconst_0
    //   132: invokestatic 584	java/lang/Math:max	(II)I
    //   135: istore_2
    //   136: iload_2
    //   137: istore_1
    //   138: aload_3
    //   139: ifnull -89 -> 50
    //   142: aload_3
    //   143: invokevirtual 405	java/io/BufferedInputStream:close	()V
    //   146: iload_2
    //   147: istore_1
    //   148: goto -98 -> 50
    //   151: astore_0
    //   152: aload_0
    //   153: invokevirtual 569	java/lang/Exception:printStackTrace	()V
    //   156: iload_2
    //   157: istore_1
    //   158: goto -108 -> 50
    //   161: ldc 94
    //   163: ldc_w 586
    //   166: invokestatic 115	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: iload_2
    //   170: istore_1
    //   171: aload_3
    //   172: ifnull -122 -> 50
    //   175: aload_3
    //   176: invokevirtual 405	java/io/BufferedInputStream:close	()V
    //   179: iload_2
    //   180: istore_1
    //   181: goto -131 -> 50
    //   184: astore_0
    //   185: aload_0
    //   186: invokevirtual 569	java/lang/Exception:printStackTrace	()V
    //   189: iload_2
    //   190: istore_1
    //   191: goto -141 -> 50
    //   194: astore_3
    //   195: aload 4
    //   197: astore_0
    //   198: aload_3
    //   199: invokevirtual 169	java/lang/Throwable:printStackTrace	()V
    //   202: aload_0
    //   203: ifnull +7 -> 210
    //   206: aload_0
    //   207: invokevirtual 405	java/io/BufferedInputStream:close	()V
    //   210: ldc 94
    //   212: ldc_w 588
    //   215: invokestatic 115	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: bipush 254
    //   220: istore_1
    //   221: goto -171 -> 50
    //   224: astore_0
    //   225: aload_0
    //   226: invokevirtual 569	java/lang/Exception:printStackTrace	()V
    //   229: goto -19 -> 210
    //   232: astore_0
    //   233: aconst_null
    //   234: astore_3
    //   235: aload_3
    //   236: ifnull +7 -> 243
    //   239: aload_3
    //   240: invokevirtual 405	java/io/BufferedInputStream:close	()V
    //   243: aload_0
    //   244: athrow
    //   245: astore_3
    //   246: aload_3
    //   247: invokevirtual 569	java/lang/Exception:printStackTrace	()V
    //   250: goto -7 -> 243
    //   253: astore_0
    //   254: goto -19 -> 235
    //   257: astore 4
    //   259: aload_0
    //   260: astore_3
    //   261: aload 4
    //   263: astore_0
    //   264: goto -29 -> 235
    //   267: astore 4
    //   269: aload_3
    //   270: astore_0
    //   271: aload 4
    //   273: astore_3
    //   274: goto -76 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	paramContext	Context
    //   37	184	1	n	int
    //   1	189	2	i1	int
    //   86	90	3	localBufferedInputStream	java.io.BufferedInputStream
    //   194	5	3	localThrowable1	Throwable
    //   234	6	3	localObject1	Object
    //   245	2	3	localException	Exception
    //   260	14	3	localObject2	Object
    //   14	182	4	localObject3	Object
    //   257	5	4	localObject4	Object
    //   267	5	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   42	50	55	java/lang/Exception
    //   5	13	65	finally
    //   42	50	65	finally
    //   56	60	65	finally
    //   142	146	65	finally
    //   152	156	65	finally
    //   175	179	65	finally
    //   185	189	65	finally
    //   206	210	65	finally
    //   210	218	65	finally
    //   225	229	65	finally
    //   239	243	65	finally
    //   243	245	65	finally
    //   246	250	65	finally
    //   142	146	151	java/lang/Exception
    //   175	179	184	java/lang/Exception
    //   16	24	194	java/lang/Throwable
    //   28	36	194	java/lang/Throwable
    //   71	87	194	java/lang/Throwable
    //   206	210	224	java/lang/Exception
    //   16	24	232	finally
    //   28	36	232	finally
    //   71	87	232	finally
    //   239	243	245	java/lang/Exception
    //   87	136	253	finally
    //   161	169	253	finally
    //   198	202	257	finally
    //   87	136	267	java/lang/Throwable
    //   161	169	267	java/lang/Throwable
  }
  
  static boolean i(Context paramContext)
  {
    TbsLog.i("TbsShareManager", "isShareTbsCoreAvailableInner", "#1# mAvailableCoreVersion: " + f);
    try
    {
      if (f == 0) {
        findCoreForThirdPartyApp(paramContext);
      }
      if (f == 0)
      {
        TbsLog.w("TbsShareManager", "isShareTbsCoreAvailableInner", "can not findCoreForThirdPartyApp");
        return false;
      }
      if (c == null)
      {
        TbsLog.i("TbsShareManager", "isShareTbsCoreAvailableInner", "#2# check if the installed version is online version");
        if ((f != 0) && (getSharedTbsCoreVersion(paramContext, g) == f)) {
          return true;
        }
      }
      else if ((f != 0) && (q.a().a(c) == f))
      {
        return true;
      }
      TbsLog.i("TbsShareManager", "isShareTbsCoreAvailableInner", "#3# Core Resource path has been changed!");
      if (l(paramContext)) {
        return true;
      }
      TbsLog.i("TbsShareManager", "isShareTbsCoreAvailableInner", "#4# Can not find core in others, mAvailableCoreVersion is " + f);
      TbsCoreLoadStat.getInstance().a(paramContext, 418, new Throwable("mAvailableCoreVersion=" + f + "; mSrcPackageName=" + g + "; getSharedTbsCoreVersion(ctx, mSrcPackageName) is " + getSharedTbsCoreVersion(paramContext, g) + "; getHostCoreVersions is " + getHostCoreVersions(paramContext)));
      e = null;
      f = 0;
      TbsLog.w("TbsShareManager", "isShareTbsCoreAvailableInner", "[share] conflict x5core cannot share");
      QbSdk.a(paramContext, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
      return false;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      TbsLog.w("TbsShareManager", "isShareTbsCoreAvailableInner", "final available core inner false.");
    }
    return false;
  }
  
  public static boolean isThirdPartyApp(Context paramContext)
  {
    for (;;)
    {
      int n;
      try
      {
        if ((a != null) && (a.equals(paramContext.getApplicationContext()))) {
          return b;
        }
        a = paramContext.getApplicationContext();
        paramContext = a.getPackageName();
        String[] arrayOfString = getCoreProviderAppList();
        int i1 = arrayOfString.length;
        n = 0;
        if (n < i1)
        {
          if (!paramContext.equals(arrayOfString[n])) {
            break label78;
          }
          b = false;
          return false;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        b = true;
        return true;
      }
      label78:
      n += 1;
    }
  }
  
  static boolean j(Context paramContext)
  {
    return b(paramContext, true);
  }
  
  private static boolean k(Context paramContext)
  {
    if (g == null) {}
    while (f != getSharedTbsCoreVersion(paramContext, g)) {
      return false;
    }
    return true;
  }
  
  private static boolean l(Context paramContext)
  {
    if (QbSdk.getOnlyDownload()) {}
    for (;;)
    {
      return false;
      String[] arrayOfString = getCoreProviderAppList();
      int i1 = arrayOfString.length;
      int n = 0;
      while (n < i1)
      {
        String str = arrayOfString[n];
        if ((f > 0) && (f == getSharedTbsCoreVersion(paramContext, str)))
        {
          Context localContext = getPackageContext(paramContext, str, true);
          if (q.a().g(paramContext))
          {
            e = q.a().b(paramContext, localContext).getAbsolutePath();
            g = str;
            return true;
          }
        }
        n += 1;
      }
    }
  }
  
  private static boolean m(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    writeProperties(paramContext, Integer.toString(0), "", "", Integer.toString(0));
    return true;
  }
  
  /* Error */
  private static void n(Context paramContext)
  {
    // Byte code:
    //   0: ldc 94
    //   2: new 96	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 645
    //   12: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: getstatic 50	com/tencent/smtt/sdk/TbsShareManager:m	Z
    //   18: invokevirtual 522	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   21: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 115	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: getstatic 50	com/tencent/smtt/sdk/TbsShareManager:m	Z
    //   30: ifeq +4 -> 34
    //   33: return
    //   34: ldc 2
    //   36: monitorenter
    //   37: getstatic 50	com/tencent/smtt/sdk/TbsShareManager:m	Z
    //   40: ifeq +13 -> 53
    //   43: ldc 2
    //   45: monitorexit
    //   46: return
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    //   53: aload_0
    //   54: ldc_w 342
    //   57: invokestatic 345	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   60: astore_0
    //   61: ldc 94
    //   63: new 96	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   70: ldc_w 647
    //   73: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_0
    //   77: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 115	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload_0
    //   87: ifnonnull +27 -> 114
    //   90: iconst_0
    //   91: ifeq +11 -> 102
    //   94: new 347	java/lang/NullPointerException
    //   97: dup
    //   98: invokespecial 348	java/lang/NullPointerException:<init>	()V
    //   101: athrow
    //   102: ldc 2
    //   104: monitorexit
    //   105: return
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual 569	java/lang/Exception:printStackTrace	()V
    //   111: goto -9 -> 102
    //   114: new 350	java/io/BufferedInputStream
    //   117: dup
    //   118: new 352	java/io/FileInputStream
    //   121: dup
    //   122: aload_0
    //   123: invokespecial 355	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   126: invokespecial 358	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   129: astore_1
    //   130: aload_1
    //   131: astore_0
    //   132: new 360	java/util/Properties
    //   135: dup
    //   136: invokespecial 361	java/util/Properties:<init>	()V
    //   139: astore_2
    //   140: aload_1
    //   141: astore_0
    //   142: aload_2
    //   143: aload_1
    //   144: invokevirtual 364	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   147: aload_1
    //   148: astore_0
    //   149: aload_2
    //   150: ldc_w 571
    //   153: ldc 30
    //   155: invokevirtual 421	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   158: astore_3
    //   159: aload_1
    //   160: astore_0
    //   161: ldc 94
    //   163: new 96	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 649
    //   173: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_3
    //   177: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 115	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload_1
    //   187: astore_0
    //   188: ldc 30
    //   190: aload_3
    //   191: invokevirtual 425	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifne +45 -> 239
    //   197: aload_1
    //   198: astore_0
    //   199: aload_3
    //   200: invokestatic 578	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   203: iconst_0
    //   204: invokestatic 584	java/lang/Math:max	(II)I
    //   207: putstatic 36	com/tencent/smtt/sdk/TbsShareManager:f	I
    //   210: aload_1
    //   211: astore_0
    //   212: ldc 94
    //   214: new 96	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 651
    //   224: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: getstatic 36	com/tencent/smtt/sdk/TbsShareManager:f	I
    //   230: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   233: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 115	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload_1
    //   240: astore_0
    //   241: aload_2
    //   242: ldc_w 384
    //   245: ldc 30
    //   247: invokevirtual 421	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   250: astore_3
    //   251: aload_1
    //   252: astore_0
    //   253: ldc 30
    //   255: aload_3
    //   256: invokevirtual 425	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   259: ifne +9 -> 268
    //   262: aload_1
    //   263: astore_0
    //   264: aload_3
    //   265: putstatic 38	com/tencent/smtt/sdk/TbsShareManager:g	Ljava/lang/String;
    //   268: aload_1
    //   269: astore_0
    //   270: getstatic 38	com/tencent/smtt/sdk/TbsShareManager:g	Ljava/lang/String;
    //   273: ifnull +34 -> 307
    //   276: aload_1
    //   277: astore_0
    //   278: getstatic 172	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   281: ifnull +26 -> 307
    //   284: aload_1
    //   285: astore_0
    //   286: getstatic 38	com/tencent/smtt/sdk/TbsShareManager:g	Ljava/lang/String;
    //   289: getstatic 172	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   292: invokevirtual 200	android/content/Context:getPackageName	()Ljava/lang/String;
    //   295: invokevirtual 425	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   298: ifeq +103 -> 401
    //   301: aload_1
    //   302: astore_0
    //   303: iconst_1
    //   304: putstatic 48	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   307: aload_1
    //   308: astore_0
    //   309: aload_2
    //   310: ldc_w 386
    //   313: ldc 30
    //   315: invokevirtual 421	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   318: astore_3
    //   319: aload_1
    //   320: astore_0
    //   321: ldc 30
    //   323: aload_3
    //   324: invokevirtual 425	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   327: ifne +9 -> 336
    //   330: aload_1
    //   331: astore_0
    //   332: aload_3
    //   333: putstatic 34	com/tencent/smtt/sdk/TbsShareManager:e	Ljava/lang/String;
    //   336: aload_1
    //   337: astore_0
    //   338: aload_2
    //   339: ldc_w 388
    //   342: ldc 30
    //   344: invokevirtual 421	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   347: astore_3
    //   348: aload_1
    //   349: astore_0
    //   350: ldc 30
    //   352: aload_3
    //   353: invokevirtual 425	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   356: ifne +9 -> 365
    //   359: aload_1
    //   360: astore_0
    //   361: aload_3
    //   362: putstatic 46	com/tencent/smtt/sdk/TbsShareManager:k	Ljava/lang/String;
    //   365: aload_1
    //   366: astore_0
    //   367: aload_2
    //   368: ldc_w 366
    //   371: ldc_w 653
    //   374: invokevirtual 421	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   377: invokestatic 658	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   380: putstatic 40	com/tencent/smtt/sdk/TbsShareManager:h	Z
    //   383: aload_1
    //   384: astore_0
    //   385: iconst_1
    //   386: putstatic 50	com/tencent/smtt/sdk/TbsShareManager:m	Z
    //   389: aload_1
    //   390: ifnull +7 -> 397
    //   393: aload_1
    //   394: invokevirtual 405	java/io/BufferedInputStream:close	()V
    //   397: ldc 2
    //   399: monitorexit
    //   400: return
    //   401: aload_1
    //   402: astore_0
    //   403: iconst_0
    //   404: putstatic 48	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   407: goto -100 -> 307
    //   410: astore_2
    //   411: aload_1
    //   412: astore_0
    //   413: aload_2
    //   414: invokevirtual 169	java/lang/Throwable:printStackTrace	()V
    //   417: aload_1
    //   418: ifnull -21 -> 397
    //   421: aload_1
    //   422: invokevirtual 405	java/io/BufferedInputStream:close	()V
    //   425: goto -28 -> 397
    //   428: astore_0
    //   429: aload_0
    //   430: invokevirtual 569	java/lang/Exception:printStackTrace	()V
    //   433: goto -36 -> 397
    //   436: astore_0
    //   437: aload_0
    //   438: invokevirtual 569	java/lang/Exception:printStackTrace	()V
    //   441: goto -44 -> 397
    //   444: astore_1
    //   445: aconst_null
    //   446: astore_0
    //   447: aload_0
    //   448: ifnull +7 -> 455
    //   451: aload_0
    //   452: invokevirtual 405	java/io/BufferedInputStream:close	()V
    //   455: aload_1
    //   456: athrow
    //   457: astore_0
    //   458: aload_0
    //   459: invokevirtual 569	java/lang/Exception:printStackTrace	()V
    //   462: goto -7 -> 455
    //   465: astore_1
    //   466: goto -19 -> 447
    //   469: astore_2
    //   470: aconst_null
    //   471: astore_1
    //   472: goto -61 -> 411
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	paramContext	Context
    //   129	293	1	localBufferedInputStream	java.io.BufferedInputStream
    //   444	12	1	localObject1	Object
    //   465	1	1	localObject2	Object
    //   471	1	1	localObject3	Object
    //   139	229	2	localProperties	java.util.Properties
    //   410	4	2	localThrowable1	Throwable
    //   469	1	2	localThrowable2	Throwable
    //   158	204	3	str	String
    // Exception table:
    //   from	to	target	type
    //   37	46	47	finally
    //   48	51	47	finally
    //   94	102	47	finally
    //   102	105	47	finally
    //   107	111	47	finally
    //   393	397	47	finally
    //   397	400	47	finally
    //   421	425	47	finally
    //   429	433	47	finally
    //   437	441	47	finally
    //   451	455	47	finally
    //   455	457	47	finally
    //   458	462	47	finally
    //   94	102	106	java/lang/Exception
    //   132	140	410	java/lang/Throwable
    //   142	147	410	java/lang/Throwable
    //   149	159	410	java/lang/Throwable
    //   161	186	410	java/lang/Throwable
    //   188	197	410	java/lang/Throwable
    //   199	210	410	java/lang/Throwable
    //   212	239	410	java/lang/Throwable
    //   241	251	410	java/lang/Throwable
    //   253	262	410	java/lang/Throwable
    //   264	268	410	java/lang/Throwable
    //   270	276	410	java/lang/Throwable
    //   278	284	410	java/lang/Throwable
    //   286	301	410	java/lang/Throwable
    //   303	307	410	java/lang/Throwable
    //   309	319	410	java/lang/Throwable
    //   321	330	410	java/lang/Throwable
    //   332	336	410	java/lang/Throwable
    //   338	348	410	java/lang/Throwable
    //   350	359	410	java/lang/Throwable
    //   361	365	410	java/lang/Throwable
    //   367	383	410	java/lang/Throwable
    //   385	389	410	java/lang/Throwable
    //   403	407	410	java/lang/Throwable
    //   421	425	428	java/lang/Exception
    //   393	397	436	java/lang/Exception
    //   53	86	444	finally
    //   114	130	444	finally
    //   451	455	457	java/lang/Exception
    //   132	140	465	finally
    //   142	147	465	finally
    //   149	159	465	finally
    //   161	186	465	finally
    //   188	197	465	finally
    //   199	210	465	finally
    //   212	239	465	finally
    //   241	251	465	finally
    //   253	262	465	finally
    //   264	268	465	finally
    //   270	276	465	finally
    //   278	284	465	finally
    //   286	301	465	finally
    //   303	307	465	finally
    //   309	319	465	finally
    //   321	330	465	finally
    //   332	336	465	finally
    //   338	348	465	finally
    //   350	359	465	finally
    //   361	365	465	finally
    //   367	383	465	finally
    //   385	389	465	finally
    //   403	407	465	finally
    //   413	417	465	finally
    //   53	86	469	java/lang/Throwable
    //   114	130	469	java/lang/Throwable
  }
  
  public static void setHostCorePathAppDefined(String paramString)
  {
    c = paramString;
  }
  
  public static void writeCoreInfoForThirdPartyApp(Context paramContext, int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    label154:
    Object localObject1;
    label319:
    Object localObject2;
    label669:
    Object localObject3;
    for (;;)
    {
      try
      {
        TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersion is " + paramInt);
        if (paramInt == 0)
        {
          m(paramContext);
          TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-401);
          return;
        }
        n = h(paramContext);
        TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromConfig is " + n);
        if (n < 0)
        {
          paramContext = "coreVersionFromConfigIs" + n;
          com.tencent.smtt.utils.q.a(a, "error_coreinfo_core", paramContext);
          TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-402);
          continue;
        }
        if (paramInt != n) {
          break label319;
        }
      }
      finally {}
      if (d(paramContext) != 0) {
        break label1394;
      }
      localObject1 = "coreVersionIs" + paramInt;
      localObject1 = (String)localObject1 + "_" + "shareCoreCanNotUse=is=" + bool;
      localObject1 = (String)localObject1 + "_" + "isInstallCore=is=" + paramBoolean;
      com.tencent.smtt.utils.q.a(a, "core_same_write", (String)localObject1);
      if ((bool) && (!paramBoolean))
      {
        localObject1 = "coreVersionIs" + paramInt;
        com.tencent.smtt.utils.q.a(a, "copy_host_core", (String)localObject1);
        a(paramContext, paramInt);
      }
      c(paramContext, paramBoolean);
      TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-403);
      continue;
      if (paramInt < n)
      {
        m(paramContext);
        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-404);
        paramContext = "coreVersionFromConfigIs" + n;
        paramContext = paramContext + "_" + "coreVersion=is=" + paramInt;
        com.tencent.smtt.utils.q.a(a, "error_coreinfo_core", paramContext);
      }
      else
      {
        n = q.a().j(paramContext);
        TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromCoreShare is " + n);
        if (paramInt < n)
        {
          m(paramContext);
          TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-404);
          paramContext = "coreVersionFromCoreShareIs" + n;
          paramContext = paramContext + "_" + "coreVersion=is=" + paramInt;
          com.tencent.smtt.utils.q.a(a, "error_coreinfo_core", paramContext);
        }
        else
        {
          localObject2 = d(paramContext, paramBoolean);
          if (c == null) {
            break;
          }
          if (paramInt == q.a().a(c))
          {
            writeProperties(paramContext, Integer.toString(paramInt), "AppDefined", c, Integer.toString(1));
            try
            {
              localObject1 = getTbsShareFile(paramContext, "core_info");
              if ((j) || (localObject1 == null)) {
                continue;
              }
              localObject2 = new TbsLinuxToolsJni(a);
              ((TbsLinuxToolsJni)localObject2).a(((File)localObject1).getAbsolutePath(), "644");
              ((TbsLinuxToolsJni)localObject2).a(q.a().s(paramContext).getAbsolutePath(), "755");
              j = true;
            }
            catch (Throwable paramContext)
            {
              paramContext.printStackTrace();
            }
          }
          else
          {
            if (paramInt <= q.a().a(c)) {
              break;
            }
            i1 = localObject2.length;
            n = 0;
            if (n >= i1) {
              break;
            }
            localObject1 = localObject2[n];
            if (paramInt != getSharedTbsCoreVersion(paramContext, (String)localObject1)) {
              break label1400;
            }
            localObject3 = getPackageContext(paramContext, (String)localObject1, true);
            localObject1 = q.a().r((Context)localObject3).getAbsolutePath();
            b.e(paramContext);
            if (!q.a().g((Context)localObject3)) {
              break label1400;
            }
            localObject2 = new File(c);
            localObject1 = new File((String)localObject1);
            localObject3 = new TbsShareManager.1();
            try
            {
              FileUtil.a((File)localObject1, (File)localObject2, (FileFilter)localObject3);
              writeProperties(paramContext, Integer.toString(paramInt), "AppDefined", c, Integer.toString(1));
              localObject1 = getTbsShareFile(paramContext, "core_info");
              if ((!j) && (localObject1 != null))
              {
                localObject2 = new TbsLinuxToolsJni(a);
                ((TbsLinuxToolsJni)localObject2).a(((File)localObject1).getAbsolutePath(), "644");
                ((TbsLinuxToolsJni)localObject2).a(q.a().s(paramContext).getAbsolutePath(), "755");
                j = true;
              }
            }
            catch (Throwable paramContext)
            {
              paramContext.printStackTrace();
            }
          }
        }
      }
    }
    int i1 = localObject2.length;
    int n = 0;
    for (;;)
    {
      if (n < i1) {
        localObject1 = localObject2[n];
      }
      for (;;)
      {
        try
        {
          int i2;
          for (;;)
          {
            i2 = getSharedTbsCoreVersion(paramContext, (String)localObject1);
            if (paramInt == i2)
            {
              TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp getSharedTbsCoreVersion ok,  packageName is " + (String)localObject1 + " result version is " + paramInt);
              Object localObject4 = getPackageContext(paramContext, (String)localObject1, true);
              if (localObject4 == null) {
                break label1407;
              }
              localObject3 = q.a().r((Context)localObject4).getAbsolutePath();
              i2 = b.e(paramContext);
              if (!q.a().g((Context)localObject4)) {
                break label1407;
              }
              if (!((String)localObject1).equals(paramContext.getApplicationContext().getPackageName()))
              {
                TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + paramInt);
                n.a(a).a("remove_old_core", 1);
              }
              localObject4 = "packageName=is=" + (String)localObject1;
              localObject4 = (String)localObject4 + "_" + "coreVersion=is=" + paramInt;
              com.tencent.smtt.utils.q.a(a, "write_core_info", (String)localObject4);
              writeProperties(paramContext, Integer.toString(paramInt), (String)localObject1, (String)localObject3, Integer.toString(i2));
              try
              {
                localObject1 = ((String)localObject1).substring(((String)localObject1).length() - 2);
                com.tencent.smtt.utils.q.a("9is" + paramInt + (String)localObject1);
                try
                {
                  localObject1 = getTbsShareFile(paramContext, "core_info");
                  if ((!j) && (localObject1 != null))
                  {
                    localObject3 = new TbsLinuxToolsJni(a);
                    ((TbsLinuxToolsJni)localObject3).a(((File)localObject1).getAbsolutePath(), "644");
                    ((TbsLinuxToolsJni)localObject3).a(q.a().s(paramContext).getAbsolutePath(), "755");
                    j = true;
                  }
                }
                catch (Throwable localThrowable2)
                {
                  for (;;)
                  {
                    String str;
                    localThrowable2.printStackTrace();
                  }
                }
                n = 1;
                if ((n != 0) || (paramBoolean)) {
                  break;
                }
                TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp ready to installCoreWithUnzip ");
                localObject1 = "coreVersionIs" + paramInt;
                com.tencent.smtt.utils.q.a(a, "copy_host_core", (String)localObject1);
                a(paramContext, paramInt);
              }
              catch (Throwable localThrowable1)
              {
                for (;;)
                {
                  TbsLog.i("TbsDownload", "throwable is " + Log.getStackTraceString(localThrowable1));
                  str = "";
                }
              }
            }
          }
          TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp getSharedTbsCoreVersion fail,  packageName is " + localException + " result version is " + i2);
        }
        catch (Exception localException)
        {
          TbsLog.i(localException);
        }
        break label1407;
        n = 0;
      }
      label1394:
      bool = false;
      break label154;
      label1400:
      n += 1;
      break label669;
      label1407:
      n += 1;
    }
  }
  
  /* Error */
  public static void writeProperties(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 6
    //   9: ldc 94
    //   11: new 96	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 741
    //   21: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc_w 743
    //   31: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 745
    //   41: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_3
    //   45: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 115	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: ldc 94
    //   56: new 96	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 747
    //   66: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: new 57	java/lang/Throwable
    //   72: dup
    //   73: ldc_w 749
    //   76: invokespecial 621	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   79: invokestatic 209	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   82: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 115	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_0
    //   92: ldc_w 342
    //   95: invokestatic 345	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   98: astore_0
    //   99: aload_0
    //   100: ifnonnull +54 -> 154
    //   103: getstatic 172	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   106: invokestatic 670	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   109: sipush -405
    //   112: invokevirtual 674	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   115: iconst_0
    //   116: ifeq +11 -> 127
    //   119: new 347	java/lang/NullPointerException
    //   122: dup
    //   123: invokespecial 348	java/lang/NullPointerException:<init>	()V
    //   126: athrow
    //   127: iconst_0
    //   128: ifeq +11 -> 139
    //   131: new 347	java/lang/NullPointerException
    //   134: dup
    //   135: invokespecial 348	java/lang/NullPointerException:<init>	()V
    //   138: athrow
    //   139: return
    //   140: astore_0
    //   141: aload_0
    //   142: invokevirtual 569	java/lang/Exception:printStackTrace	()V
    //   145: goto -18 -> 127
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 569	java/lang/Exception:printStackTrace	()V
    //   153: return
    //   154: new 350	java/io/BufferedInputStream
    //   157: dup
    //   158: new 352	java/io/FileInputStream
    //   161: dup
    //   162: aload_0
    //   163: invokespecial 355	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   166: invokespecial 358	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   169: astore 7
    //   171: new 360	java/util/Properties
    //   174: dup
    //   175: invokespecial 361	java/util/Properties:<init>	()V
    //   178: astore 10
    //   180: aload 10
    //   182: aload 7
    //   184: invokevirtual 364	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   187: aload_1
    //   188: invokestatic 578	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   191: istore 5
    //   193: iload 5
    //   195: ifeq +121 -> 316
    //   198: aload 10
    //   200: ldc_w 571
    //   203: aload_1
    //   204: invokevirtual 373	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   207: pop
    //   208: aload 10
    //   210: ldc_w 366
    //   213: iconst_0
    //   214: invokestatic 369	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   217: invokevirtual 373	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   220: pop
    //   221: aload 10
    //   223: ldc_w 384
    //   226: aload_2
    //   227: invokevirtual 373	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   230: pop
    //   231: aload 10
    //   233: ldc_w 386
    //   236: aload_3
    //   237: invokevirtual 373	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   240: pop
    //   241: aload 10
    //   243: ldc_w 388
    //   246: aload 4
    //   248: invokevirtual 373	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   251: pop
    //   252: new 392	java/io/BufferedOutputStream
    //   255: dup
    //   256: new 394	java/io/FileOutputStream
    //   259: dup
    //   260: aload_0
    //   261: invokespecial 395	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   264: invokespecial 398	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   267: astore_0
    //   268: aload 10
    //   270: aload_0
    //   271: aconst_null
    //   272: invokevirtual 402	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   275: iconst_0
    //   276: putstatic 50	com/tencent/smtt/sdk/TbsShareManager:m	Z
    //   279: getstatic 172	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   282: invokestatic 670	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   285: sipush -406
    //   288: invokevirtual 674	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   291: aload 7
    //   293: ifnull +8 -> 301
    //   296: aload 7
    //   298: invokevirtual 405	java/io/BufferedInputStream:close	()V
    //   301: aload_0
    //   302: ifnull -163 -> 139
    //   305: aload_0
    //   306: invokevirtual 406	java/io/BufferedOutputStream:close	()V
    //   309: return
    //   310: astore_0
    //   311: aload_0
    //   312: invokevirtual 569	java/lang/Exception:printStackTrace	()V
    //   315: return
    //   316: aload 10
    //   318: ldc_w 366
    //   321: iconst_1
    //   322: invokestatic 369	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   325: invokevirtual 373	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   328: pop
    //   329: goto -77 -> 252
    //   332: astore_2
    //   333: aload 7
    //   335: astore_0
    //   336: aload 8
    //   338: astore_1
    //   339: aload_2
    //   340: invokevirtual 169	java/lang/Throwable:printStackTrace	()V
    //   343: aload_0
    //   344: ifnull +7 -> 351
    //   347: aload_0
    //   348: invokevirtual 405	java/io/BufferedInputStream:close	()V
    //   351: aload_1
    //   352: ifnull -213 -> 139
    //   355: aload_1
    //   356: invokevirtual 406	java/io/BufferedOutputStream:close	()V
    //   359: return
    //   360: astore_0
    //   361: aload_0
    //   362: invokevirtual 569	java/lang/Exception:printStackTrace	()V
    //   365: return
    //   366: astore_1
    //   367: aload_1
    //   368: invokevirtual 569	java/lang/Exception:printStackTrace	()V
    //   371: goto -70 -> 301
    //   374: astore_0
    //   375: aload_0
    //   376: invokevirtual 569	java/lang/Exception:printStackTrace	()V
    //   379: goto -28 -> 351
    //   382: astore_0
    //   383: aconst_null
    //   384: astore 7
    //   386: aload 9
    //   388: astore_1
    //   389: aload 7
    //   391: ifnull +8 -> 399
    //   394: aload 7
    //   396: invokevirtual 405	java/io/BufferedInputStream:close	()V
    //   399: aload_1
    //   400: ifnull +7 -> 407
    //   403: aload_1
    //   404: invokevirtual 406	java/io/BufferedOutputStream:close	()V
    //   407: aload_0
    //   408: athrow
    //   409: astore_2
    //   410: aload_2
    //   411: invokevirtual 569	java/lang/Exception:printStackTrace	()V
    //   414: goto -15 -> 399
    //   417: astore_1
    //   418: aload_1
    //   419: invokevirtual 569	java/lang/Exception:printStackTrace	()V
    //   422: goto -15 -> 407
    //   425: astore 11
    //   427: iload 6
    //   429: istore 5
    //   431: goto -238 -> 193
    //   434: astore_0
    //   435: aload 9
    //   437: astore_1
    //   438: goto -49 -> 389
    //   441: astore_2
    //   442: aload_0
    //   443: astore_1
    //   444: aload_2
    //   445: astore_0
    //   446: goto -57 -> 389
    //   449: astore_2
    //   450: aload_0
    //   451: astore 7
    //   453: aload_2
    //   454: astore_0
    //   455: goto -66 -> 389
    //   458: astore_2
    //   459: aconst_null
    //   460: astore_0
    //   461: aload 8
    //   463: astore_1
    //   464: goto -125 -> 339
    //   467: astore_2
    //   468: aload_0
    //   469: astore_1
    //   470: aload 7
    //   472: astore_0
    //   473: goto -134 -> 339
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	476	0	paramContext	Context
    //   0	476	1	paramString1	String
    //   0	476	2	paramString2	String
    //   0	476	3	paramString3	String
    //   0	476	4	paramString4	String
    //   191	239	5	n	int
    //   7	421	6	i1	int
    //   169	302	7	localObject1	Object
    //   4	458	8	localObject2	Object
    //   1	435	9	localObject3	Object
    //   178	139	10	localProperties	java.util.Properties
    //   425	1	11	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   119	127	140	java/lang/Exception
    //   131	139	148	java/lang/Exception
    //   305	309	310	java/lang/Exception
    //   171	187	332	java/lang/Throwable
    //   187	193	332	java/lang/Throwable
    //   198	252	332	java/lang/Throwable
    //   252	268	332	java/lang/Throwable
    //   316	329	332	java/lang/Throwable
    //   355	359	360	java/lang/Exception
    //   296	301	366	java/lang/Exception
    //   347	351	374	java/lang/Exception
    //   91	99	382	finally
    //   103	115	382	finally
    //   154	171	382	finally
    //   394	399	409	java/lang/Exception
    //   403	407	417	java/lang/Exception
    //   187	193	425	java/lang/Exception
    //   171	187	434	finally
    //   187	193	434	finally
    //   198	252	434	finally
    //   252	268	434	finally
    //   316	329	434	finally
    //   268	291	441	finally
    //   339	343	449	finally
    //   91	99	458	java/lang/Throwable
    //   103	115	458	java/lang/Throwable
    //   154	171	458	java/lang/Throwable
    //   268	291	467	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsShareManager
 * JD-Core Version:    0.7.0.1
 */