package com.tencent.mobileqq.startup.step;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Process;
import android.text.TextUtils;
import anpc;
import avfw;
import avgf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class InstallPlugins
  extends Step
{
  public static a a;
  public static b a;
  public static final String[] gU = { "qzone_plugin.apk", "qwallet_plugin.apk", "dingdong_plugin.apk" };
  
  private static void QK(String paramString)
  {
    try
    {
      File localFile1 = PluginUtils.getPluginInstallDir(BaseApplicationImpl.sApplication);
      File localFile2 = new File(localFile1, paramString);
      if (localFile2.exists()) {
        localFile2.delete();
      }
      avgf.c(paramString, localFile1);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("plugin_tag.InstallPlugins", 1, "", paramString);
      }
    }
    QLog.d("plugin_tag.InstallPlugins", 1, "uninstallPlugin");
  }
  
  /* Error */
  private static boolean bE(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 40	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: astore 5
    //   5: new 48	java/io/File
    //   8: dup
    //   9: aload 5
    //   11: invokestatic 46	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginInstallDir	(Landroid/content/Context;)Ljava/io/File;
    //   14: aload_0
    //   15: invokespecial 51	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: astore 6
    //   20: aload 6
    //   22: invokevirtual 55	java/io/File:exists	()Z
    //   25: ifeq +22 -> 47
    //   28: ldc 22
    //   30: aload_0
    //   31: invokevirtual 86	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +13 -> 47
    //   37: ldc 66
    //   39: iconst_1
    //   40: ldc 88
    //   42: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: iconst_1
    //   46: ireturn
    //   47: aload_0
    //   48: invokestatic 94	com/tencent/mobileqq/pluginsdk/PluginStatic:getClassLoader	(Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   51: ifnull +13 -> 64
    //   54: ldc 66
    //   56: iconst_1
    //   57: ldc 96
    //   59: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: iconst_1
    //   63: ireturn
    //   64: aload_0
    //   65: invokestatic 98	com/tencent/mobileqq/startup/step/InstallPlugins:QK	(Ljava/lang/String;)V
    //   68: aconst_null
    //   69: astore_3
    //   70: aload 5
    //   72: aload_0
    //   73: aload 6
    //   75: invokestatic 102	com/tencent/mobileqq/pluginsdk/PluginUtils:extractPluginAndGetMd5Code	(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Ljava/lang/String;
    //   78: astore 4
    //   80: aload 4
    //   82: astore_3
    //   83: aload_3
    //   84: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   87: ifne +256 -> 343
    //   90: aload 5
    //   92: aload_0
    //   93: invokestatic 112	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginLibPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   96: invokevirtual 116	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   99: astore 4
    //   101: aload 6
    //   103: invokevirtual 116	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   106: aload 4
    //   108: invokestatic 120	com/tencent/mobileqq/pluginsdk/PluginUtils:extractLibs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   111: astore 4
    //   113: ldc 66
    //   115: iconst_1
    //   116: new 122	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   123: ldc 125
    //   125: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload 4
    //   130: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload 4
    //   141: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifeq +199 -> 343
    //   147: aload_0
    //   148: aload 6
    //   150: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   153: invokestatic 140	avgh:cp	(Ljava/lang/String;Ljava/lang/String;)Z
    //   156: ifeq +187 -> 343
    //   159: aload 5
    //   161: aload_0
    //   162: invokestatic 144	com/tencent/mobileqq/pluginsdk/PluginStatic:getOrCreateClassLoader	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   165: astore 4
    //   167: aload 4
    //   169: aload_1
    //   170: invokevirtual 150	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   173: astore 4
    //   175: ldc 66
    //   177: iconst_1
    //   178: new 122	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   185: ldc 152
    //   187: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_1
    //   191: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: aload 4
    //   202: ifnull +141 -> 343
    //   205: new 154	cooperation/plugin/PluginInfo
    //   208: dup
    //   209: invokespecial 155	cooperation/plugin/PluginInfo:<init>	()V
    //   212: astore_1
    //   213: aload_1
    //   214: aload_0
    //   215: putfield 159	cooperation/plugin/PluginInfo:mID	Ljava/lang/String;
    //   218: aload_1
    //   219: aload_3
    //   220: putfield 162	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   223: aload_1
    //   224: iconst_1
    //   225: putfield 166	cooperation/plugin/PluginInfo:mUpdateType	I
    //   228: aload_1
    //   229: iconst_0
    //   230: putfield 169	cooperation/plugin/PluginInfo:mInstallType	I
    //   233: aload_1
    //   234: iconst_4
    //   235: putfield 172	cooperation/plugin/PluginInfo:mState	I
    //   238: aload_1
    //   239: aload 6
    //   241: invokevirtual 176	java/io/File:length	()J
    //   244: putfield 180	cooperation/plugin/PluginInfo:mLength	J
    //   247: aload_1
    //   248: aload 6
    //   250: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   253: putfield 183	cooperation/plugin/PluginInfo:mInstalledPath	Ljava/lang/String;
    //   256: aload_1
    //   257: invokestatic 186	avgh:FP	()Ljava/lang/String;
    //   260: putfield 189	cooperation/plugin/PluginInfo:mFingerPrint	Ljava/lang/String;
    //   263: aload_1
    //   264: aload 5
    //   266: invokestatic 46	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginInstallDir	(Landroid/content/Context;)Ljava/io/File;
    //   269: invokestatic 192	avgf:a	(Lcooperation/plugin/PluginInfo;Ljava/io/File;)V
    //   272: ldc 66
    //   274: iconst_1
    //   275: ldc 194
    //   277: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: iconst_1
    //   281: ireturn
    //   282: astore 4
    //   284: invokestatic 200	aqhq:getAvailableInnernalMemorySize	()F
    //   287: fstore_2
    //   288: ldc 202
    //   290: iconst_1
    //   291: new 122	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   298: ldc 204
    //   300: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 6
    //   305: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   308: ldc 209
    //   310: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: fload_2
    //   314: invokevirtual 212	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   317: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: aload 4
    //   322: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   325: goto -242 -> 83
    //   328: astore_1
    //   329: ldc 66
    //   331: iconst_1
    //   332: ldc 76
    //   334: aload_1
    //   335: invokestatic 215	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   338: aload_0
    //   339: invokestatic 218	com/tencent/mobileqq/pluginsdk/PluginStatic:removeClassLoader	(Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   342: pop
    //   343: aload_0
    //   344: invokestatic 98	com/tencent/mobileqq/startup/step/InstallPlugins:QK	(Ljava/lang/String;)V
    //   347: new 220	android/content/Intent
    //   350: dup
    //   351: ldc 222
    //   353: invokespecial 224	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   356: astore_1
    //   357: aload_1
    //   358: invokestatic 230	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   361: invokevirtual 235	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   364: invokevirtual 239	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   367: pop
    //   368: aload_1
    //   369: ldc 241
    //   371: getstatic 244	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   374: invokevirtual 248	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   377: pop
    //   378: aload_1
    //   379: ldc 250
    //   381: aload_0
    //   382: invokevirtual 248	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   385: pop
    //   386: aload 5
    //   388: aload_1
    //   389: invokevirtual 256	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   392: ldc 66
    //   394: iconst_1
    //   395: ldc_w 258
    //   398: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   401: iconst_0
    //   402: ireturn
    //   403: astore_1
    //   404: ldc 66
    //   406: iconst_1
    //   407: ldc 76
    //   409: aload_1
    //   410: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   413: goto -70 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	paramString1	String
    //   0	416	1	paramString2	String
    //   287	27	2	f	float
    //   69	151	3	localObject1	Object
    //   78	123	4	localObject2	Object
    //   282	39	4	localException	Exception
    //   3	384	5	localBaseApplicationImpl	BaseApplicationImpl
    //   18	286	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   70	80	282	java/lang/Exception
    //   167	200	328	java/lang/Exception
    //   205	280	328	java/lang/Exception
    //   90	167	403	java/lang/Exception
    //   329	343	403	java/lang/Exception
  }
  
  public static void dRQ()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqStartupStepInstallPlugins$a != null)
      {
        Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        if (localObject1 != null)
        {
          localObject1 = ((AppRuntime)localObject1).getAccount();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            anpc.a(BaseApplicationImpl.getApplication()).collectPerformance((String)localObject1, "qzonePrePluginInstall", jdField_a_of_type_ComTencentMobileqqStartupStepInstallPlugins$a.cIK, jdField_a_of_type_ComTencentMobileqqStartupStepInstallPlugins$a.cost, 0L, null, null);
          }
          QLog.i("plugin_tag.InstallPlugins", 1, "install qzone:" + jdField_a_of_type_ComTencentMobileqqStartupStepInstallPlugins$a.cIK + ",cost:" + jdField_a_of_type_ComTencentMobileqqStartupStepInstallPlugins$a.cost);
        }
        jdField_a_of_type_ComTencentMobileqqStartupStepInstallPlugins$a = null;
      }
      return;
    }
    finally {}
  }
  
  public static boolean ps(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = gU;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (TextUtils.equals(arrayOfString[i], paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  /* Error */
  public static void report(int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 313	com/tencent/mobileqq/startup/step/InstallPlugins:jdField_a_of_type_ComTencentMobileqqStartupStepInstallPlugins$b	Lcom/tencent/mobileqq/startup/step/InstallPlugins$b;
    //   6: ifnull +132 -> 138
    //   9: invokestatic 265	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   12: invokevirtual 269	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +117 -> 134
    //   20: aload_2
    //   21: invokevirtual 274	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   24: astore_2
    //   25: aload_2
    //   26: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: ifne +105 -> 134
    //   32: new 315	java/util/HashMap
    //   35: dup
    //   36: invokespecial 316	java/util/HashMap:<init>	()V
    //   39: astore_3
    //   40: aload_3
    //   41: ldc_w 318
    //   44: getstatic 313	com/tencent/mobileqq/startup/step/InstallPlugins:jdField_a_of_type_ComTencentMobileqqStartupStepInstallPlugins$b	Lcom/tencent/mobileqq/startup/step/InstallPlugins$b;
    //   47: getfield 321	com/tencent/mobileqq/startup/step/InstallPlugins$b:errorCode	I
    //   50: invokestatic 325	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   53: invokevirtual 329	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   56: pop
    //   57: aload_3
    //   58: ldc_w 331
    //   61: iload_0
    //   62: invokestatic 325	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   65: invokevirtual 329	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   68: pop
    //   69: invokestatic 265	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   72: invokestatic 279	anpc:a	(Landroid/content/Context;)Lanpc;
    //   75: astore 4
    //   77: new 122	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   84: getstatic 313	com/tencent/mobileqq/startup/step/InstallPlugins:jdField_a_of_type_ComTencentMobileqqStartupStepInstallPlugins$b	Lcom/tencent/mobileqq/startup/step/InstallPlugins$b;
    //   87: getfield 334	com/tencent/mobileqq/startup/step/InstallPlugins$b:ceO	Ljava/lang/String;
    //   90: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc_w 336
    //   96: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: astore 5
    //   104: getstatic 313	com/tencent/mobileqq/startup/step/InstallPlugins:jdField_a_of_type_ComTencentMobileqqStartupStepInstallPlugins$b	Lcom/tencent/mobileqq/startup/step/InstallPlugins$b;
    //   107: getfield 321	com/tencent/mobileqq/startup/step/InstallPlugins$b:errorCode	I
    //   110: ifne +32 -> 142
    //   113: iconst_1
    //   114: istore_1
    //   115: aload 4
    //   117: aload_2
    //   118: aload 5
    //   120: iload_1
    //   121: getstatic 313	com/tencent/mobileqq/startup/step/InstallPlugins:jdField_a_of_type_ComTencentMobileqqStartupStepInstallPlugins$b	Lcom/tencent/mobileqq/startup/step/InstallPlugins$b;
    //   124: getfield 339	com/tencent/mobileqq/startup/step/InstallPlugins$b:amq	I
    //   127: i2l
    //   128: lconst_0
    //   129: aload_3
    //   130: aconst_null
    //   131: invokevirtual 292	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   134: aconst_null
    //   135: putstatic 313	com/tencent/mobileqq/startup/step/InstallPlugins:jdField_a_of_type_ComTencentMobileqqStartupStepInstallPlugins$b	Lcom/tencent/mobileqq/startup/step/InstallPlugins$b;
    //   138: ldc 2
    //   140: monitorexit
    //   141: return
    //   142: iconst_0
    //   143: istore_1
    //   144: goto -29 -> 115
    //   147: astore_2
    //   148: ldc 2
    //   150: monitorexit
    //   151: aload_2
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramInt	int
    //   114	30	1	bool	boolean
    //   15	103	2	localObject1	Object
    //   147	5	2	localObject2	Object
    //   39	91	3	localHashMap	java.util.HashMap
    //   75	41	4	localanpc	anpc
    //   102	17	5	str	String
    // Exception table:
    //   from	to	target	type
    //   3	16	147	finally
    //   20	113	147	finally
    //   115	134	147	finally
    //   134	138	147	finally
  }
  
  protected boolean doStep()
  {
    long l = System.currentTimeMillis();
    QLog.i("plugin_tag.InstallPlugins", 1, " install");
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getMobileQQ().peekAppRuntime();
    Object localObject3;
    if (localObject1 != null)
    {
      QLog.i("plugin_tag.InstallPlugins", 1, "preinstall by pluginmanger");
      localObject1 = (avfw)((QQAppInterface)localObject1).getManager(27);
      localObject3 = gU;
      int j = localObject3.length;
      int i = 0;
      while (i < j)
      {
        ((avfw)localObject1).installPlugin(localObject3[i], null);
        i += 1;
      }
      try
      {
        Thread.sleep(5000L);
        QLog.d("plugin_tag.InstallPlugins", 1, " install" + (System.currentTimeMillis() - l));
        return true;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    for (;;)
    {
      try
      {
        Object localObject2 = ((ActivityManager)BaseApplicationImpl.sApplication.getSystemService("activity")).getRunningAppProcesses();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
            if (!((ActivityManager.RunningAppProcessInfo)localObject3).processName.endsWith(":qzone")) {
              break label295;
            }
            Process.killProcess(((ActivityManager.RunningAppProcessInfo)localObject3).pid);
            QLog.d("plugin_tag.InstallPlugins", 1, "kill qzone");
            continue;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.d("plugin_tag.InstallPlugins", 1, "", localThrowable);
        QLog.i("plugin_tag.InstallPlugins", 1, "qzone");
        jdField_a_of_type_ComTencentMobileqqStartupStepInstallPlugins$a = new a();
        jdField_a_of_type_ComTencentMobileqqStartupStepInstallPlugins$a.cIK = bE("qzone_plugin.apk", "com.qzone.Foo");
        jdField_a_of_type_ComTencentMobileqqStartupStepInstallPlugins$a.cost = (System.currentTimeMillis() - l);
        QLog.i("plugin_tag.InstallPlugins", 1, "qwallet");
        bE("qwallet_plugin.apk", "com.qwallet.utils.Foo");
      }
      label295:
      if (((ActivityManager.RunningAppProcessInfo)localObject3).processName.endsWith(":tool"))
      {
        Process.killProcess(((ActivityManager.RunningAppProcessInfo)localObject3).pid);
        QLog.d("plugin_tag.InstallPlugins", 1, "kill tool");
      }
    }
  }
  
  public static class a
  {
    public boolean cIK = false;
    long cost = -1L;
  }
  
  public static class b
  {
    public int amq;
    public String ceO;
    public int errorCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InstallPlugins
 * JD-Core Version:    0.7.0.1
 */