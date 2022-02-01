import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.patch.QZonePatchService.1;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class avxj
{
  private static avxj a;
  private static String cOn;
  private static volatile boolean dps;
  private static int ezs;
  private static Object lock = new Object();
  
  private static String GE()
  {
    File localFile = PluginUtils.getInstalledPluginPath(BaseApplicationImpl.sApplication, "qzone_plugin.apk");
    if (localFile != null) {
      return localFile.getAbsolutePath();
    }
    return null;
  }
  
  public static avxj a()
  {
    if (a == null) {}
    synchronized (lock)
    {
      if (a == null) {
        a = new avxj();
      }
      return a;
    }
  }
  
  private static DexClassLoader a(Context paramContext, String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      paramContext = new DexClassLoader(paramString, paramContext.getDir("dex", 0).getAbsolutePath(), paramString, paramClassLoader);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      log("preCompileMergePatch failed :" + paramContext.getMessage() + "  stacktrace: " + Log.getStackTraceString(paramContext));
    }
    return null;
  }
  
  public static void aar(String paramString)
  {
    int i = ga(paramString);
    ezs = i;
    acf(i);
  }
  
  private static void acf(int paramInt)
  {
    LocalMultiProcConfig.putInt(AppSetting.nT() + "p_ver", paramInt);
  }
  
  private static void as(Context paramContext, String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      log("start to merge...");
      if ((iP() == 0L) || (bl() == 0L)) {
        eCu();
      }
      if (bo() == 0L) {
        eCt();
      }
      String str2 = GE();
      String str1;
      if (str2 != null)
      {
        if ((iP() != 0L) && (iP() != getFileLength(paramString1)))
        {
          eCu();
          nL(getFileLength(paramString1));
        }
        str1 = cE(paramString2);
        if ((bl() != 0L) && (bl() == getFileLength(str1))) {
          break label263;
        }
        eCu();
        log("---> merge :" + str1);
        if (!avxh.G(str2, paramString1, str1)) {
          break label259;
        }
        nM(getFileLength(str1));
        paramString1 = cF(paramString2);
        if ((bo() != 0L) && (bo() == getFileLength(paramString1))) {
          break label302;
        }
        eCt();
        log("---> compile :" + paramString1);
        if (a(paramContext, str1, paramContext.getClassLoader()) != null)
        {
          nN(getFileLength(paramString1));
          log("---> succeed to merge and compile, merge len:" + getFileLength(str1) + "   odex len:" + getFileLength(paramString1));
        }
      }
      for (;;)
      {
        log("end to merge...");
        return;
        label259:
        eCu();
        return;
        label263:
        log("---> merge : not merge share_pref len:" + bl() + "  file len:" + getFileLength(str1));
        break;
        label302:
        log("---> merge : not compile share_pref len:" + bo() + " file len:" + getFileLength(paramString1));
      }
    }
    log("not need to merge...");
  }
  
  private static long bl()
  {
    return LocalMultiProcConfig.getLong(avpq.getQUA3() + "p_merge_len", 0L);
  }
  
  private static long bo()
  {
    return LocalMultiProcConfig.getLong(avpq.getQUA3() + "p_merge_odex_len", 0L);
  }
  
  private static String cE(String paramString)
  {
    paramString = paramString + ".jar";
    File localFile = BaseApplicationImpl.getContext().getDir("patchs_merge", 0);
    return localFile.getAbsolutePath() + File.separator + paramString;
  }
  
  private static String cF(String paramString)
  {
    paramString = paramString + ".dex";
    File localFile = BaseApplicationImpl.getContext().getDir("dex", 0);
    return localFile.getAbsolutePath() + File.separator + paramString;
  }
  
  private static void eCr()
  {
    log(acfp.m(2131713214));
    cOn = null;
    Object localObject1 = BaseApplicationImpl.getContext().getDir("patchs", 0);
    long l;
    int i;
    Object localObject3;
    if (((File)localObject1).exists())
    {
      Object localObject2 = avpq.getQUA3() + "p_len";
      l = LocalMultiProcConfig.getLong((String)localObject2, 0L);
      log((String)localObject2 + " = " + l);
      log(acfp.m(2131713209) + l);
      localObject2 = ((File)localObject1).listFiles();
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        int j = localObject2.length;
        i = 0;
        if (i < j)
        {
          localObject3 = localObject2[i];
          if (localObject3 != null) {}
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (!localObject3.isDirectory()) {
        if (l != localObject3.length()) {
          localObject3.delete();
        } else {
          try
          {
            localObject1 = PluginStatic.encodeFile(localObject3.getAbsolutePath()).toLowerCase();
            String str2 = localObject3.getName();
            str3 = str2.substring(0, str2.length() - ".jar".length());
            if (((String)localObject1 + ".jar").endsWith(str2.toLowerCase()))
            {
              cOn = str3;
              if (!TextUtils.isEmpty(cOn)) {
                break label409;
              }
              log(acfp.m(2131713208));
              return;
            }
          }
          catch (Exception localException)
          {
            String str3;
            String str1;
            for (;;)
            {
              QLog.w("qz_patch", 1, QLog.getStackTraceString(localException));
              str1 = null;
            }
            localObject3.delete();
            eCu();
            avpw.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "qz_patch", 12, "patch verify failed: file md5: " + str1 + " but expected md5: " + str3, 1, System.currentTimeMillis());
            QLog.d("qz_patch", 1, "report [qz_patch] patch verify failed: file md5: " + str1 + " but expected md5: " + str3);
            cOn = null;
          }
        }
      }
    }
    label409:
    log("当前补丁包的md5是" + cOn);
  }
  
  private static void eCs()
  {
    int i = 0;
    if (Build.VERSION.SDK_INT < 24) {
      return;
    }
    Object localObject1 = BaseApplicationImpl.getContext().getDir("patchs_merge", 0);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2.isDirectory()) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2.delete();
        }
      }
    }
    nM(0L);
  }
  
  private static void eCt()
  {
    int i = 0;
    if (Build.VERSION.SDK_INT < 24) {
      return;
    }
    Object localObject1 = BaseApplicationImpl.getContext().getDir("dex", 0);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2.isDirectory()) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2.delete();
        }
      }
    }
    nN(0L);
  }
  
  private static void eCu()
  {
    eCs();
    eCt();
  }
  
  private static int ga(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return 0;
        paramString = Uri.parse(paramString).getLastPathSegment();
      } while (TextUtils.isEmpty(paramString));
      paramString = Pattern.compile("_r(\\d+)").matcher(paramString);
    } while (!paramString.find());
    paramString = paramString.group(1);
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  private static long getFileLength(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString.length();
    }
    return 0L;
  }
  
  private static String getPatchPath(String paramString)
  {
    paramString = paramString + ".jar";
    File localFile = BaseApplicationImpl.getContext().getDir("patchs", 0);
    return localFile.getAbsolutePath() + File.separator + paramString;
  }
  
  private static long iP()
  {
    return LocalMultiProcConfig.getLong(avpq.getQUA3() + "p_len", 0L);
  }
  
  private static void jt(String paramString1, String paramString2)
  {
    log(acfp.m(2131713212));
    if (TextUtils.isEmpty(paramString1)) {
      log(acfp.m(2131713217));
    }
    while (dps) {
      return;
    }
    dps = true;
    if (cOn == null)
    {
      QLog.d("qz_patch", 1, "本地没有补丁包");
      if (!"del".equals(paramString1)) {}
    }
    for (;;)
    {
      dps = false;
      return;
      if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2)))
      {
        ju(paramString1, paramString2);
        cOn = paramString1;
        continue;
        QLog.d("qz_patch", 1, "本地有补丁包");
        if (!cOn.equals(paramString1)) {
          break;
        }
        log(acfp.m(2131713213));
        as(BaseApplicationImpl.getContext(), getPatchPath(paramString1), paramString1);
      }
    }
    if ((paramString1.equals("del")) || (paramString1.equals("delete"))) {
      QLog.d("qz_patch", 1, "md5是del，直接删除旧的Patch");
    }
    for (;;)
    {
      int i;
      try
      {
        paramString1 = BaseApplicationImpl.getContext().getDir("patchs", 0);
        if (paramString1.exists())
        {
          paramString1 = paramString1.listFiles();
          int j = paramString1.length;
          i = 0;
          if (i < j)
          {
            paramString2 = paramString1[i];
            if (paramString2.isDirectory()) {
              break label374;
            }
            paramString2.delete();
          }
        }
      }
      catch (Throwable paramString1)
      {
        QLog.w("qz_patch", 1, QLog.getStackTraceString(paramString1));
      }
      for (;;)
      {
        avpw.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "qz_patch", 11, "clear patch:" + cOn, 1, System.currentTimeMillis());
        QLog.d("qz_patch", 1, "report [qz_patch] clear patch:" + cOn);
        break;
        LocalMultiProcConfig.putLong(avpq.getQUA3() + "p_len", 0L);
        cOn = null;
        eCu();
      }
      log(acfp.m(2131713210));
      eCu();
      if ((paramString2 == null) || (TextUtils.isEmpty(paramString2))) {
        break;
      }
      ju(paramString1, paramString2);
      cOn = paramString1;
      break;
      label374:
      i += 1;
    }
  }
  
  /* Error */
  private static void ju(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 401	avxj:getPatchPath	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore 7
    //   6: invokestatic 312	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   9: invokevirtual 316	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   12: checkcast 419	com/tencent/common/app/AppInterface
    //   15: aload_1
    //   16: new 40	java/io/File
    //   19: dup
    //   20: aload 7
    //   22: invokespecial 378	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: invokestatic 424	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)Z
    //   28: ifeq +389 -> 417
    //   31: new 65	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 425
    //   41: invokestatic 242	acfp:m	(I)Ljava/lang/String;
    //   44: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload 7
    //   49: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 90	avxj:log	(Ljava/lang/String;)V
    //   58: invokestatic 225	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   61: ldc 246
    //   63: iconst_0
    //   64: invokevirtual 230	com/tencent/qphone/base/util/BaseApplication:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   67: astore 7
    //   69: aload 7
    //   71: invokevirtual 250	java/io/File:exists	()Z
    //   74: ifeq +343 -> 417
    //   77: aload 7
    //   79: invokevirtual 259	java/io/File:listFiles	()[Ljava/io/File;
    //   82: astore 9
    //   84: aload 9
    //   86: arraylength
    //   87: istore_3
    //   88: iconst_0
    //   89: istore_2
    //   90: iload_2
    //   91: iload_3
    //   92: if_icmpge +325 -> 417
    //   95: aload 9
    //   97: iload_2
    //   98: aaload
    //   99: astore 10
    //   101: aload 10
    //   103: invokevirtual 262	java/io/File:isDirectory	()Z
    //   106: ifeq +6 -> 112
    //   109: goto +402 -> 511
    //   112: new 65	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   119: aload_0
    //   120: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc 221
    //   125: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: aload 10
    //   133: invokevirtual 281	java/io/File:getName	()Ljava/lang/String;
    //   136: invokevirtual 292	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   139: istore 4
    //   141: iload 4
    //   143: ifeq +354 -> 497
    //   146: aload 10
    //   148: invokevirtual 43	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   151: invokestatic 273	com/tencent/mobileqq/pluginsdk/PluginStatic:encodeFile	(Ljava/lang/String;)Ljava/lang/String;
    //   154: astore 7
    //   156: new 65	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   163: ldc_w 427
    //   166: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 7
    //   171: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 90	avxj:log	(Ljava/lang/String;)V
    //   180: aload_0
    //   181: aload 7
    //   183: invokevirtual 430	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   186: ifeq +252 -> 438
    //   189: ldc_w 432
    //   192: invokestatic 90	avxj:log	(Ljava/lang/String;)V
    //   195: new 65	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   202: invokestatic 211	avpq:getQUA3	()Ljava/lang/String;
    //   205: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc 252
    //   210: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: astore 7
    //   218: aload 10
    //   220: invokevirtual 265	java/io/File:length	()J
    //   223: lstore 5
    //   225: new 65	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   232: aload 7
    //   234: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: ldc 254
    //   239: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: lload 5
    //   244: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   247: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 90	avxj:log	(Ljava/lang/String;)V
    //   253: aload 7
    //   255: lload 5
    //   257: invokestatic 414	cooperation/qzone/LocalMultiProcConfig:putLong	(Ljava/lang/String;J)V
    //   260: ldc_w 301
    //   263: iconst_2
    //   264: new 65	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 434
    //   274: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_0
    //   278: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc_w 436
    //   284: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: lload 5
    //   289: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   292: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: aload_1
    //   299: invokestatic 438	avxj:aar	(Ljava/lang/String;)V
    //   302: invokestatic 312	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   305: invokevirtual 316	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   308: checkcast 318	com/tencent/mobileqq/app/QQAppInterface
    //   311: ldc_w 301
    //   314: bipush 10
    //   316: aconst_null
    //   317: invokestatic 441	avxj:w	(ILjava/lang/String;)I
    //   320: new 65	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   327: ldc_w 443
    //   330: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_0
    //   334: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: ldc_w 436
    //   340: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: lload 5
    //   345: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   348: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: iconst_1
    //   352: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   355: invokestatic 332	avpw:a	(Lmqq/app/AppRuntime;Ljava/lang/String;ILjava/lang/String;IJ)V
    //   358: ldc_w 301
    //   361: iconst_1
    //   362: new 65	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 445
    //   372: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: bipush 10
    //   377: aconst_null
    //   378: invokestatic 441	avxj:w	(ILjava/lang/String;)I
    //   381: invokevirtual 448	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   384: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: invokestatic 225	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   393: aload 10
    //   395: invokevirtual 43	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   398: aload_0
    //   399: invokestatic 403	avxj:as	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   402: goto +109 -> 511
    //   405: astore_0
    //   406: ldc_w 301
    //   409: iconst_1
    //   410: aload_0
    //   411: invokestatic 304	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   414: invokestatic 308	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: return
    //   418: astore 8
    //   420: aconst_null
    //   421: astore 7
    //   423: ldc_w 301
    //   426: iconst_1
    //   427: aload 8
    //   429: invokestatic 304	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   432: invokestatic 308	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   435: goto -255 -> 180
    //   438: ldc_w 450
    //   441: invokestatic 90	avxj:log	(Ljava/lang/String;)V
    //   444: ldc_w 301
    //   447: iconst_1
    //   448: new 65	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   455: ldc_w 452
    //   458: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload 7
    //   463: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: ldc_w 454
    //   469: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload_0
    //   473: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: ldc_w 456
    //   479: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   488: aload 10
    //   490: invokevirtual 268	java/io/File:delete	()Z
    //   493: pop
    //   494: goto +17 -> 511
    //   497: aload 10
    //   499: invokevirtual 268	java/io/File:delete	()Z
    //   502: pop
    //   503: goto +8 -> 511
    //   506: astore 8
    //   508: goto -85 -> 423
    //   511: iload_2
    //   512: iconst_1
    //   513: iadd
    //   514: istore_2
    //   515: goto -425 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	518	0	paramString1	String
    //   0	518	1	paramString2	String
    //   89	426	2	i	int
    //   87	6	3	j	int
    //   139	3	4	bool	boolean
    //   223	121	5	l	long
    //   4	458	7	localObject	Object
    //   418	10	8	localException1	Exception
    //   506	1	8	localException2	Exception
    //   82	14	9	arrayOfFile	File[]
    //   99	399	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   31	88	405	java/lang/Error
    //   101	109	405	java/lang/Error
    //   112	141	405	java/lang/Error
    //   146	156	405	java/lang/Error
    //   156	180	405	java/lang/Error
    //   180	402	405	java/lang/Error
    //   423	435	405	java/lang/Error
    //   438	494	405	java/lang/Error
    //   497	503	405	java/lang/Error
    //   146	156	418	java/lang/Exception
    //   156	180	506	java/lang/Exception
  }
  
  public static void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qz_patch", 2, paramString);
    }
  }
  
  private static void nL(long paramLong)
  {
    LocalMultiProcConfig.putLong(avpq.getQUA3() + "p_qzone_len", paramLong);
  }
  
  private static void nM(long paramLong)
  {
    LocalMultiProcConfig.putLong(avpq.getQUA3() + "p_merge_len", paramLong);
  }
  
  private static void nN(long paramLong)
  {
    LocalMultiProcConfig.putLong(avpq.getQUA3() + "p_merge_odex_len", paramLong);
  }
  
  public static int w(int paramInt, String paramString)
  {
    int i = paramInt;
    if (paramString == null) {
      i = paramInt + ezs * 10000;
    }
    return i;
  }
  
  public void js(String paramString1, String paramString2)
  {
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "isPatchEnable", 1) == 0) {
      return;
    }
    ThreadManager.postDownLoadTask(new QZonePatchService.1(this, paramString1, paramString2), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avxj
 * JD-Core Version:    0.7.0.1
 */