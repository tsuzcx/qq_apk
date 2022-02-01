package com.tencent.mobileqq.minigame.gpkg;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import aqhq;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Process;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.FirstPageInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.MiniGamePluginInfo;
import com.tencent.mobileqq.mini.apkg.SubPkgInfo;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniAppStartState;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.utils.DebugUtil;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.mobileqq.mini.utils.WxapkgUnpacker;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class GpkgManager
{
  private static final String KEY_DOWNLOAD_GAME = "key_download_game";
  private static final String KEY_DOWNLOAD_PROGRESS_PERCENT = "key_download_process_percent";
  private static final String KEY_DOWNLOAD_PROGRESS_SIZE = "key_download_progress_size";
  private static final String KEY_DOWNLOAD_RESULT_OBJECT = "key_download_result_object";
  private static final String KEY_DOWNLOAD_RETCODE = "key_download_retcode";
  private static final String KEY_DOWNLOAD_RETSTRING = "key_download_retstring";
  private static final String KEY_DOWNLOAD_SAVEPATH = "key_download_savepath";
  private static final String KEY_DOWNLOAD_URL = "key_download_url";
  public static final int NO_PRELOAD = 0;
  public static final int PRELOAD_APPINFI = 1;
  public static final int PRELOAD_GPKG = 2;
  public static final String SUFFIX_TQAPKG = ".tqapkg";
  public static final String SUFFIX_WXAPKG = ".wxapkg";
  public static final String SUFFIX_ZIP = ".zip";
  private static final String TAG = "[minigame] GpkgManager";
  private static final int UNZIP_MAXCOUNT = 3;
  private static final int VALUE_DOWNLOAD_CANCEL = 0;
  private static final int VALUE_DOWNLOAD_FAIL = -1;
  private static final int VALUE_DOWNLOAD_PROGRESS = 2;
  private static final int VALUE_DOWNLOAD_SUCC = 1;
  public static volatile long downloadDuration;
  
  private static boolean checkOfflineResourceContent(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {
      paramString = paramString + File.separator + "offlineconfig.json";
    }
    try
    {
      paramString = new File(paramString);
      bool1 = bool2;
      if (paramString.exists())
      {
        paramString = FileUtils.readFileToString(paramString);
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString)) {
          bool1 = new JSONObject(paramString).optBoolean("offlineResourceReady", false);
        }
      }
      return bool1;
    }
    catch (Throwable paramString)
    {
      QLog.i("[minigame] GpkgManager", 1, "[Gpkg] checkOfflineResourceContent error:" + DebugUtil.getPrintableStackTrace(paramString));
    }
    return false;
  }
  
  private static boolean checkPkgFolderContent(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString + File.separator + "game.js";
      try
      {
        boolean bool = new File(paramString).exists();
        if (bool) {
          return true;
        }
      }
      catch (Throwable paramString)
      {
        QLog.i("[minigame] GpkgManager", 1, "[Gpkg] checkPkgFolderContent error:" + DebugUtil.getPrintableStackTrace(paramString));
      }
    }
    return false;
  }
  
  private static void downloadGpkgByResumableDownloader(MiniAppConfig paramMiniAppConfig, OnInitGpkgListener paramOnInitGpkgListener, String paramString, boolean paramBoolean)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null))
    {
      if (paramOnInitGpkgListener != null) {
        paramOnInitGpkgListener.onInitGpkgInfo(2002, null, "downloadGpkgByResumableDownloader fail invalid params, game config null", null);
      }
      QLog.e("[minigame] GpkgManager", 1, "[Gpkg]downloadGpkgByResumableDownloader fail invalid params, game config null");
      return;
    }
    if (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)) {
      MiniAppStartState.setApkgDownload(paramMiniAppConfig.config.appId, false);
    }
    long l2 = System.currentTimeMillis();
    Object localObject1 = null;
    long l1 = paramMiniAppConfig.config.fileSize;
    String str1;
    Object localObject2;
    Object localObject3;
    if (paramMiniAppConfig.config.firstPage != null)
    {
      str1 = paramMiniAppConfig.config.firstPage.subPkgName;
      if (paramMiniAppConfig.config.subpkgs != null)
      {
        localObject2 = paramMiniAppConfig.config.subpkgs.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SubPkgInfo)((Iterator)localObject2).next();
          if ((localObject3 != null) && (str1 != null) && (str1.equals(((SubPkgInfo)localObject3).subPkgName))) {
            if (((SubPkgInfo)localObject3).independent == 1)
            {
              localObject3 = ((SubPkgInfo)localObject3).downloadUrl;
              localObject2 = localObject1;
              localObject1 = localObject3;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = paramMiniAppConfig.config.downloadUrl;
      }
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        if (paramOnInitGpkgListener != null) {
          paramOnInitGpkgListener.onInitGpkgInfo(2025, null, "invalid gameConfig, downloadUrl null", null);
        }
        QLog.e("[minigame] GpkgManager", 1, "[Gpkg]downloadGpkgByResumableDownloader error, apkUrl:" + (String)localObject3);
        return;
        localObject1 = ((SubPkgInfo)localObject3).downloadUrl;
        l1 = ((SubPkgInfo)localObject3).fileSize;
      }
      for (;;)
      {
        break;
        localObject1 = MiniappDownloadUtil.getInstance().getDownloadMode((String)localObject3);
        int i;
        if (localObject1 == Downloader.DownloadMode.RangeMode)
        {
          i = MiniappDownloadUtil.getInstance().getRangeNumber(l1);
          if (i != 1) {
            break label542;
          }
          localObject1 = Downloader.DownloadMode.StrictMode;
        }
        label542:
        for (;;)
        {
          if (((String)localObject3).toLowerCase().endsWith(".zip")) {}
          for (String str2 = ".zip";; str2 = ".tqapkg")
          {
            str2 = ApkgManager.getPkgRoot(paramMiniAppConfig.config) + paramMiniAppConfig.config.appId + '_' + paramMiniAppConfig.config.version + str2;
            QLog.i("[minigame] GpkgManager", 1, "[Gpkg]download gpkgUrl=" + (String)localObject3 + ", subApkUrl=" + (String)localObject2 + ", independentPath=" + str1 + ", savePath=" + str2 + ", downloadMode=" + localObject1 + ", rangeNum=" + i);
            MiniReportManager.reportEventType(paramMiniAppConfig, 619, "1");
            MiniappDownloadUtil.getInstance().downloadApkg(paramMiniAppConfig, false, (String)localObject3, str2, true, new GpkgManager.4(paramMiniAppConfig, paramOnInitGpkgListener, l2, str2, paramString, (String)localObject2, str1, paramBoolean), (Downloader.DownloadMode)localObject1, i, l1, ApkgManager.getHeader((String)localObject3, paramMiniAppConfig), null);
            return;
            i = -1;
            break;
          }
        }
      }
      str1 = null;
      localObject2 = localObject1;
      localObject1 = null;
      continue;
      str1 = null;
      localObject2 = null;
      localObject1 = null;
    }
  }
  
  public static void downloadPkgInMainProcess(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, CmdCallback paramCmdCallback)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("[minigame] GpkgManager", 1, "[Gpkg] downloadPkgInMainProcess invalid param, downloadUrl:" + paramString1 + ",savePath:" + paramString2 + ",game config:" + paramMiniAppConfig);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_mini_app_config", paramMiniAppConfig);
    localBundle.putString("key_download_url", paramString1);
    localBundle.putString("key_download_savepath", paramString2);
    ApkgMainProcessManager.checkShouldDownloadInMainProcess(localBundle, new GpkgManager.8(paramCmdCallback));
  }
  
  public static void downloadSubPack(MiniGamePkg paramMiniGamePkg, String paramString, OnInitGpkgListener paramOnInitGpkgListener)
  {
    if ((paramMiniGamePkg == null) || (paramMiniGamePkg.appConfig == null) || (paramMiniGamePkg.appConfig.config == null)) {}
    MiniAppInfo localMiniAppInfo;
    String str2;
    String str3;
    String str1;
    do
    {
      do
      {
        return;
        localMiniAppInfo = paramMiniGamePkg.appConfig.config;
        str2 = paramMiniGamePkg.getRootPath(paramString);
        str3 = getSubPkgDownloadUrl(paramMiniGamePkg, paramString);
        str1 = ApkgManager.getApkgFolderPath(localMiniAppInfo);
        QLog.i("[minigame] GpkgManager subpackage", 1, "[Gpkg] downloadSubPack | downPage(subName)=" + paramString + "; subPackDownloadUrl=" + str3 + "; folder:" + str1);
        if (!TextUtils.isEmpty(str1)) {
          break;
        }
      } while (paramOnInitGpkgListener == null);
      paramOnInitGpkgListener.onInitGpkgInfo(2007, null, "downloadSubPack but pkg folder not exist", null);
      return;
      if (!new File(str1, str2).exists()) {
        break;
      }
    } while (paramOnInitGpkgListener == null);
    paramOnInitGpkgListener.onInitGpkgInfo(0, paramMiniGamePkg, "downloadSubPack succeed, sub pkg already exist", null);
    return;
    if (!TextUtils.isEmpty(str3))
    {
      long l = fileSizeFromPkgInfo(paramMiniGamePkg.appConfig, true, str3);
      paramString = MiniappDownloadUtil.getInstance().getDownloadMode(str3);
      int i;
      if (paramString == Downloader.DownloadMode.RangeMode)
      {
        i = MiniappDownloadUtil.getInstance().getRangeNumber(l);
        if (i == 1) {
          paramString = Downloader.DownloadMode.StrictMode;
        }
        if (!str3.toLowerCase().endsWith(".zip")) {
          break label331;
        }
      }
      label331:
      for (str1 = ".zip";; str1 = ".tqapkg")
      {
        str1 = ApkgManager.getPkgRoot(localMiniAppInfo) + localMiniAppInfo.appId + '_' + localMiniAppInfo.version + "_" + System.nanoTime() + str1;
        MiniReportManager.reportEventType(paramMiniGamePkg.appConfig, 613, "1");
        if (!GameWnsUtils.isForceDownloadInMainProcess()) {
          break label338;
        }
        downloadSubPkgInMainProcess(paramMiniGamePkg.appConfig, paramMiniGamePkg, str3, str1, str2, paramOnInitGpkgListener);
        return;
        i = -1;
        break;
      }
      label338:
      MiniappDownloadUtil.getInstance().downloadApkg(paramMiniGamePkg.appConfig, false, str3, str1, true, new GpkgManager.6(paramMiniGamePkg, str1, str2, paramOnInitGpkgListener), paramString, i, l, ApkgManager.getHeader(str3, paramMiniGamePkg.appConfig), null);
      return;
    }
    paramOnInitGpkgListener.onInitGpkgInfo(2008, null, "sub pkg download url empty", null);
  }
  
  public static void downloadSubPkgInMainProcess(MiniAppConfig paramMiniAppConfig, MiniGamePkg paramMiniGamePkg, String paramString1, String paramString2, String paramString3, OnInitGpkgListener paramOnInitGpkgListener)
  {
    downloadPkgInMainProcess(paramMiniAppConfig, paramString1, paramString2, new GpkgManager.7(paramMiniGamePkg, paramString2, paramString3, paramOnInitGpkgListener));
  }
  
  private static long fileSizeFromPkgInfo(MiniAppConfig paramMiniAppConfig, boolean paramBoolean, String paramString)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null))
    {
      if (paramBoolean)
      {
        if ((paramString != null) && (paramMiniAppConfig.config.subpkgs != null))
        {
          paramMiniAppConfig = paramMiniAppConfig.config.subpkgs.iterator();
          while (paramMiniAppConfig.hasNext())
          {
            SubPkgInfo localSubPkgInfo = (SubPkgInfo)paramMiniAppConfig.next();
            if ((localSubPkgInfo != null) && (paramString.equals(localSubPkgInfo.downloadUrl))) {
              return localSubPkgInfo.fileSize;
            }
          }
        }
        return 0L;
      }
      return paramMiniAppConfig.config.fileSize;
    }
    return 0L;
  }
  
  /* Error */
  private static String getGpkgFilePath(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokestatic 109	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: ldc 57
    //   13: aload_0
    //   14: invokestatic 438	ahbj:getExtension	(Ljava/lang/String;)Ljava/lang/String;
    //   17: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   20: ifeq +204 -> 224
    //   23: aload_0
    //   24: ldc 57
    //   26: new 111	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 440
    //   36: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokestatic 409	java/lang/System:nanoTime	()J
    //   42: invokevirtual 412	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   45: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokevirtual 444	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   51: astore 6
    //   53: aload_0
    //   54: ldc 57
    //   56: ldc 51
    //   58: invokevirtual 444	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   61: astore 5
    //   63: iconst_0
    //   64: istore_1
    //   65: aconst_null
    //   66: astore_3
    //   67: aload_0
    //   68: aload 6
    //   70: invokestatic 450	jqp:unZipFolder	(Ljava/lang/String;Ljava/lang/String;)I
    //   73: ifne +217 -> 290
    //   76: aload 6
    //   78: invokestatic 455	aqhq:fileExists	(Ljava/lang/String;)Z
    //   81: ifeq +209 -> 290
    //   84: aload 6
    //   86: iconst_0
    //   87: iconst_0
    //   88: invokestatic 459	ahbj:getFiles	(Ljava/lang/String;ZI)Ljava/util/ArrayList;
    //   91: astore 4
    //   93: aload 4
    //   95: ifnull +305 -> 400
    //   98: aload 4
    //   100: invokevirtual 465	java/util/ArrayList:size	()I
    //   103: ifle +297 -> 400
    //   106: aload 4
    //   108: invokevirtual 466	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   111: astore 4
    //   113: aload 4
    //   115: invokeinterface 231 1 0
    //   120: ifeq +280 -> 400
    //   123: aload 4
    //   125: invokeinterface 235 1 0
    //   130: checkcast 468	com/tencent/mobileqq/filemanager/data/FileInfo
    //   133: astore 7
    //   135: ldc 51
    //   137: aload 7
    //   139: invokevirtual 471	com/tencent/mobileqq/filemanager/data/FileInfo:getPath	()Ljava/lang/String;
    //   142: invokestatic 438	ahbj:getExtension	(Ljava/lang/String;)Ljava/lang/String;
    //   145: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   148: ifne +19 -> 167
    //   151: ldc 54
    //   153: aload 7
    //   155: invokevirtual 471	com/tencent/mobileqq/filemanager/data/FileInfo:getPath	()Ljava/lang/String;
    //   158: invokestatic 438	ahbj:getExtension	(Ljava/lang/String;)Ljava/lang/String;
    //   161: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   164: ifeq -51 -> 113
    //   167: aload 7
    //   169: invokevirtual 471	com/tencent/mobileqq/filemanager/data/FileInfo:getPath	()Ljava/lang/String;
    //   172: astore 4
    //   174: aload 4
    //   176: astore_3
    //   177: aload_3
    //   178: astore 4
    //   180: aload_3
    //   181: invokestatic 455	aqhq:fileExists	(Ljava/lang/String;)Z
    //   184: ifeq +109 -> 293
    //   187: new 118	java/io/File
    //   190: dup
    //   191: aload_3
    //   192: invokespecial 130	java/io/File:<init>	(Ljava/lang/String;)V
    //   195: new 118	java/io/File
    //   198: dup
    //   199: aload 5
    //   201: invokespecial 130	java/io/File:<init>	(Ljava/lang/String;)V
    //   204: invokestatic 475	aqhq:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   207: istore_2
    //   208: aload_3
    //   209: astore 4
    //   211: iload_2
    //   212: ifeq +81 -> 293
    //   215: aload 6
    //   217: iconst_0
    //   218: invokestatic 478	aqhq:delete	(Ljava/lang/String;Z)V
    //   221: aload 5
    //   223: astore_3
    //   224: aload_3
    //   225: invokestatic 481	ahbj:isFileExists	(Ljava/lang/String;)Z
    //   228: ifeq +153 -> 381
    //   231: aload_3
    //   232: astore 4
    //   234: aload_3
    //   235: aload_0
    //   236: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   239: ifne +11 -> 250
    //   242: aload_0
    //   243: iconst_0
    //   244: invokestatic 478	aqhq:delete	(Ljava/lang/String;Z)V
    //   247: aload_3
    //   248: astore 4
    //   250: ldc 60
    //   252: iconst_1
    //   253: new 111	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   260: ldc_w 483
    //   263: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 4
    //   268: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc_w 485
    //   274: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_0
    //   278: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload 4
    //   289: areturn
    //   290: aload_3
    //   291: astore 4
    //   293: iload_1
    //   294: iconst_1
    //   295: iadd
    //   296: istore_1
    //   297: aload 4
    //   299: astore_3
    //   300: iload_1
    //   301: iconst_3
    //   302: if_icmpge -78 -> 224
    //   305: aload 4
    //   307: astore_3
    //   308: goto -241 -> 67
    //   311: astore 4
    //   313: ldc 60
    //   315: iconst_1
    //   316: new 111	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   323: ldc_w 487
    //   326: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_0
    //   330: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: ldc_w 489
    //   336: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: aload 6
    //   341: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: ldc_w 491
    //   347: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: iload_1
    //   351: invokevirtual 315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: aload 4
    //   359: invokestatic 494	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   362: aload 6
    //   364: iconst_0
    //   365: invokestatic 478	aqhq:delete	(Ljava/lang/String;Z)V
    //   368: iload_1
    //   369: iconst_1
    //   370: iadd
    //   371: istore_1
    //   372: aload_3
    //   373: astore 4
    //   375: goto -78 -> 297
    //   378: astore_0
    //   379: aload_0
    //   380: athrow
    //   381: aload_0
    //   382: astore 4
    //   384: goto -134 -> 250
    //   387: astore 4
    //   389: aload 5
    //   391: astore_3
    //   392: goto -79 -> 313
    //   395: astore 4
    //   397: goto -84 -> 313
    //   400: goto -223 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	paramString	String
    //   64	308	1	i	int
    //   207	5	2	bool	boolean
    //   1	391	3	localObject1	Object
    //   91	215	4	localObject2	Object
    //   311	47	4	localThrowable1	Throwable
    //   373	10	4	localObject3	Object
    //   387	1	4	localThrowable2	Throwable
    //   395	1	4	localThrowable3	Throwable
    //   61	329	5	str1	String
    //   51	312	6	str2	String
    //   133	35	7	localFileInfo	com.tencent.mobileqq.filemanager.data.FileInfo
    // Exception table:
    //   from	to	target	type
    //   180	208	311	java/lang/Throwable
    //   67	93	378	finally
    //   98	113	378	finally
    //   113	167	378	finally
    //   167	174	378	finally
    //   180	208	378	finally
    //   215	221	378	finally
    //   313	368	378	finally
    //   215	221	387	java/lang/Throwable
    //   67	93	395	java/lang/Throwable
    //   98	113	395	java/lang/Throwable
    //   113	167	395	java/lang/Throwable
    //   167	174	395	java/lang/Throwable
  }
  
  public static void getGpkgInfoByConfig(MiniAppConfig paramMiniAppConfig, OnInitGpkgListener paramOnInitGpkgListener)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null))
    {
      QLog.e("[minigame] GpkgManager", 1, "[Gpkg] getGpkgInfoByConfig invalid request, game config null");
      if (paramOnInitGpkgListener != null) {
        paramOnInitGpkgListener.onInitGpkgInfo(2002, null, "getGpkgInfoByConfig invalid request, game config null", null);
      }
      return;
    }
    long l = SystemClock.uptimeMillis();
    paramOnInitGpkgListener = new GpkgManager.1(l, paramMiniAppConfig, paramOnInitGpkgListener);
    QLog.i("[minigame] GpkgManager", 1, "[Gpkg] getGpkgInfoByConfig checkMainProcess appid=" + paramMiniAppConfig.config.appId);
    ApkgMainProcessManager.checkShouldLoadPkgInMainProcess(paramMiniAppConfig, new GpkgManager.2(l, paramMiniAppConfig, paramOnInitGpkgListener), false);
  }
  
  private static Info getInfoFromDownloadResult(DownloadResult paramDownloadResult)
  {
    if (paramDownloadResult == null) {
      return null;
    }
    paramDownloadResult = paramDownloadResult.getReport();
    Info localInfo = new Info();
    localInfo.url = paramDownloadResult.url;
    localInfo.contentSize = paramDownloadResult.fileSize;
    localInfo.httpStatusCode = paramDownloadResult.httpStatus;
    localInfo.success = paramDownloadResult.isSucceed;
    localInfo.isFromReusedConnection = false;
    localInfo.timeCostMs = paramDownloadResult.downloadTime;
    localInfo.queueTimeMs = paramDownloadResult.t_wait;
    localInfo.dnsTimeMs = paramDownloadResult.t_prepare;
    localInfo.connectionTimeMs = paramDownloadResult.t_conn;
    localInfo.receiveTimeMs = paramDownloadResult.t_recvdata;
    localInfo.message = (localInfo.contentSize * 1000L / (localInfo.timeCostMs + 1L) + " B/S  [" + paramDownloadResult.remoteAddress + "] " + paramDownloadResult.url);
    return localInfo;
  }
  
  private static String getSubPkgDownloadUrl(MiniGamePkg paramMiniGamePkg, String paramString)
  {
    paramMiniGamePkg = paramMiniGamePkg.appConfig.config.subpkgs;
    if ((paramMiniGamePkg != null) && (paramMiniGamePkg.size() > 0) && (!TextUtils.isEmpty(paramString)))
    {
      paramMiniGamePkg = paramMiniGamePkg.iterator();
      while (paramMiniGamePkg.hasNext())
      {
        SubPkgInfo localSubPkgInfo = (SubPkgInfo)paramMiniGamePkg.next();
        if (paramString.equals(localSubPkgInfo.subPkgName)) {
          return localSubPkgInfo.downloadUrl;
        }
      }
    }
    return null;
  }
  
  public static void handleDownloadPkgInMainProcess(Bundle paramBundle, CmdCallback paramCmdCallback)
  {
    MiniAppConfig localMiniAppConfig = (MiniAppConfig)paramBundle.getParcelable("key_mini_app_config");
    String str = paramBundle.getString("key_download_url", "");
    paramBundle = paramBundle.getString("key_download_savepath", "");
    if ((localMiniAppConfig == null) || (localMiniAppConfig.config == null) || (TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramBundle))) {
      return;
    }
    MiniappDownloadUtil.getInstance().downloadApkg(localMiniAppConfig, true, str, paramBundle, true, new GpkgManager.9(paramCmdCallback), Downloader.DownloadMode.StrictMode, ApkgManager.getHeader(str, localMiniAppConfig));
  }
  
  private static void handleDownloadResult(boolean paramBoolean, int paramInt, long paramLong, float paramFloat, String paramString1, DownloadResult paramDownloadResult, MiniGamePkg paramMiniGamePkg, String paramString2, String paramString3, OnInitGpkgListener paramOnInitGpkgListener)
  {
    if (paramBoolean)
    {
      long l = -1L;
      paramLong = l;
      if (paramDownloadResult != null)
      {
        paramLong = l;
        if (paramDownloadResult.getContent() != null) {
          paramLong = paramDownloadResult.getContent().length;
        }
      }
      MiniReportManager.reportEventType(paramMiniGamePkg.appConfig, 614, String.valueOf(paramLong), "1");
      paramString1 = ApkgManager.getApkgFolderPath(paramMiniGamePkg.appConfig.config);
      paramDownloadResult = new File(paramString2);
      MiniReportManager.reportEventType(paramMiniGamePkg.appConfig, 615, "1");
      paramBoolean = WxapkgUnpacker.unpackSync(paramDownloadResult.getAbsolutePath(), paramString1, paramString3, true);
      paramDownloadResult = paramMiniGamePkg.appConfig;
      if (paramBoolean)
      {
        paramInt = 0;
        MiniReportManager.reportEventType(paramDownloadResult, 616, null, null, null, paramInt, "1", 0L, null);
        if (QLog.isColorLevel()) {
          QLog.d("[minigame] GpkgManager", 1, "downloadSubPack | getResPath :hasUnpack=" + paramBoolean + "; folderPath=" + paramString1 + "; subRoot=" + paramString3);
        }
        if (!paramBoolean) {
          break label220;
        }
        if (paramOnInitGpkgListener != null) {
          paramOnInitGpkgListener.onInitGpkgInfo(0, paramMiniGamePkg, "download sub pkg and unpack succeed", null);
        }
      }
    }
    label220:
    do
    {
      do
      {
        do
        {
          return;
          paramInt = 1;
          break;
        } while (paramOnInitGpkgListener == null);
        paramOnInitGpkgListener.onInitGpkgInfo(2011, null, "download sub pkg succeed, but unpack sub pkg fail", null);
        return;
        if (paramInt != 2) {
          break label270;
        }
      } while (paramOnInitGpkgListener == null);
      paramOnInitGpkgListener.onDownloadGpkgProgress(paramMiniGamePkg.appConfig.config, paramFloat, paramLong);
      return;
      if (paramInt != 0) {
        break label350;
      }
      MiniReportManager.reportEventType(paramMiniGamePkg.appConfig, 614, null, null, null, -9999, "1", 0L, null);
    } while (paramOnInitGpkgListener == null);
    label270:
    paramOnInitGpkgListener.onInitGpkgInfo(2009, null, "download sub pkg cancel", null);
    QLog.d("[minigame] GpkgManager", 2, "onDownloadCanceled() called with: s = [" + paramString1 + "]");
    return;
    label350:
    if (paramInt == -1)
    {
      if ((paramDownloadResult != null) && (paramDownloadResult.getStatus() != null))
      {
        if (paramDownloadResult.getStatus().exception2Code == 0) {
          break label480;
        }
        paramInt = paramDownloadResult.getStatus().exception2Code;
      }
      for (;;)
      {
        MiniReportManager.reportEventType(paramMiniGamePkg.appConfig, 614, null, null, null, paramInt, "1", paramDownloadResult.getProcess().duration, null);
        if (paramOnInitGpkgListener == null) {
          break;
        }
        paramOnInitGpkgListener.onInitGpkgInfo(2010, null, "download sub pkg fail", null);
        QLog.d("[minigame] GpkgManager", 2, "onDownloadFailed() called with: s = [" + paramString1 + "], downloadResult = [" + paramDownloadResult + "]");
        return;
        label480:
        if (paramDownloadResult.getStatus().httpStatus > 0) {
          paramInt = paramDownloadResult.getStatus().httpStatus;
        } else {
          paramInt = -99999;
        }
      }
    }
    paramOnInitGpkgListener.onInitGpkgInfo(2024, null, "download sub pkg fail", null);
  }
  
  private static void handleGpkgDownloadSuccess(String paramString1, String paramString2, MiniAppConfig paramMiniAppConfig, OnInitGpkgListener paramOnInitGpkgListener, String paramString3, String paramString4, boolean paramBoolean, DownloadResult paramDownloadResult)
  {
    File localFile = new File(paramString1);
    MiniReportManager.reportEventType(paramMiniAppConfig, 621, "1");
    boolean bool = WxapkgUnpacker.unpackSync(localFile.getAbsolutePath(), paramString2, "", true);
    int i;
    if (bool)
    {
      i = 0;
      MiniReportManager.reportEventType(paramMiniAppConfig, 622, null, null, null, i, "1", 0L, null);
      if (QLog.isColorLevel()) {
        QLog.i("[minigame] GpkgManager", 1, "[Gpkg] handleGpkgDownloadSuccess path:" + paramString1 + ",unpack:" + paramString2 + ",hasUnpack:" + bool);
      }
      if (!bool) {
        break label218;
      }
      paramString1 = MiniGamePkg.loadGamePkgFromFolderPath(paramString2, paramString4, paramMiniAppConfig, paramBoolean);
      if (paramString3 == null) {
        break label197;
      }
      QLog.i("[minigame] GpkgManager", 1, "[Gpkg] downloadSubPack after gpk succeed, subApkUrl=" + paramString3);
      MiniReportManager.reportEventType(paramMiniAppConfig, 1029, null, null, null, 0, "1", 0L, null);
      downloadSubPack(paramString1, paramString3, new GpkgManager.5(paramOnInitGpkgListener));
    }
    label197:
    label218:
    do
    {
      do
      {
        return;
        i = 1;
        break;
      } while (paramOnInitGpkgListener == null);
      paramOnInitGpkgListener.onInitGpkgInfo(0, paramString1, "download pkg and unpack succeed", getInfoFromDownloadResult(paramDownloadResult));
      return;
      MiniProgramLpReportDC04239.reportPageView(paramMiniAppConfig, "1", null, "load_fail", "unpkg_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "unpkg_fail", null, paramMiniAppConfig);
      QLog.e("[minigame] GpkgManager", 1, new Object[] { "[Gpkg]", " handleGpkgDownloadSuccess hasUnpack=", Boolean.valueOf(bool) });
    } while (paramOnInitGpkgListener == null);
    paramOnInitGpkgListener.onInitGpkgInfo(2005, null, "download pkg succeed but unpack fail", getInfoFromDownloadResult(paramDownloadResult));
  }
  
  public static boolean isGpkgValid(MiniAppConfig paramMiniAppConfig)
  {
    if (paramMiniAppConfig == null) {}
    do
    {
      return false;
      paramMiniAppConfig = ApkgManager.getApkgFolderPath(paramMiniAppConfig.config);
    } while (!new File(paramMiniAppConfig).exists());
    return checkPkgFolderContent(paramMiniAppConfig);
  }
  
  public static boolean isOfflineResourceReady(MiniAppConfig paramMiniAppConfig)
  {
    if (paramMiniAppConfig == null) {}
    do
    {
      return false;
      paramMiniAppConfig = ApkgManager.getApkgFolderPath(paramMiniAppConfig.config);
    } while ((!new File(paramMiniAppConfig).exists()) || (!checkPkgFolderContent(paramMiniAppConfig)));
    return checkOfflineResourceContent(paramMiniAppConfig);
  }
  
  private static void loadGpkgInMiniProcess(MiniAppConfig paramMiniAppConfig, OnInitGpkgListener paramOnInitGpkgListener)
  {
    performGetGpkgInfoByConfig(paramMiniAppConfig, paramOnInitGpkgListener, true);
  }
  
  private static void performDownloadGpkg(MiniAppConfig paramMiniAppConfig, OnInitGpkgListener paramOnInitGpkgListener, String paramString, boolean paramBoolean)
  {
    if (new File(paramString).exists())
    {
      if (checkPkgFolderContent(paramString))
      {
        QLog.i("[minigame] GpkgManager", 1, "[Gpkg] checkPkgFolderContent success");
        paramString = MiniGamePkg.loadGamePkgFromFolderPath(paramString, null, paramMiniAppConfig, paramBoolean);
        if (paramOnInitGpkgListener != null) {
          paramOnInitGpkgListener.onInitGpkgInfo(0, paramString, "gpkg exist, no need download", null);
        }
        if (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)) {
          MiniAppStartState.setApkgDownload(paramMiniAppConfig.config.appId, true);
        }
        return;
      }
      QLog.i("[minigame] GpkgManager", 1, "[Gpkg] checkPkgFolderContent failed, delete folder:" + paramString);
      aqhq.delete(paramString, false);
      QLog.i("[minigame] GpkgManager", 1, "[Gpkg] download gpkg by url1:" + paramMiniAppConfig.config.downloadUrl);
      downloadGpkgByResumableDownloader(paramMiniAppConfig, paramOnInitGpkgListener, paramString, paramBoolean);
      return;
    }
    QLog.i("[minigame] GpkgManager", 1, "[Gpkg] download gpkg by url2:" + paramMiniAppConfig.config.downloadUrl);
    downloadGpkgByResumableDownloader(paramMiniAppConfig, paramOnInitGpkgListener, paramString, paramBoolean);
  }
  
  private static void performDownloadGpkgPlugin(@NonNull MiniGamePluginInfo paramMiniGamePluginInfo, DownloadPluginCallback paramDownloadPluginCallback)
  {
    File localFile1 = new File(ApkgManager.getGpkgPluginFolderPath(paramMiniGamePluginInfo));
    if (localFile1.exists())
    {
      if (new File(localFile1, "plugin.js").exists())
      {
        QLog.i("[minigame] GpkgManager", 1, "[Gpkg] plugin existed:" + localFile1.getAbsolutePath() + " " + paramMiniGamePluginInfo);
        paramDownloadPluginCallback.onPluginDownloadComplete(true, null, null);
        return;
      }
      QLog.e("[minigame] GpkgManager", 1, "[Gpkg] plugin corrupted:" + localFile1.getAbsolutePath() + " " + paramMiniGamePluginInfo);
    }
    try
    {
      File localFile2 = File.createTempFile("gpkg_plugin_" + paramMiniGamePluginInfo.id, ".tqapkg");
      QLog.i("[minigame] GpkgManager", 1, "[Gpkg] start download plugin to:" + localFile1.getAbsolutePath() + " " + paramMiniGamePluginInfo);
      MiniappDownloadUtil.getInstance().download(paramMiniGamePluginInfo.url, localFile2.getAbsolutePath(), false, new GpkgManager.3(paramDownloadPluginCallback, paramMiniGamePluginInfo, localFile2, localFile1), Downloader.DownloadMode.StrictMode, null);
      return;
    }
    catch (IOException paramMiniGamePluginInfo)
    {
      paramDownloadPluginCallback.onPluginDownloadComplete(false, paramMiniGamePluginInfo, null);
    }
  }
  
  public static void performGetGpkgInfoByConfig(MiniAppConfig paramMiniAppConfig, OnInitGpkgListener paramOnInitGpkgListener, boolean paramBoolean)
  {
    MiniReportManager.addCostTimeEventAttachInfo(paramMiniAppConfig, 2, "0");
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null))
    {
      QLog.e("[minigame] GpkgManager", 1, "[Gpkg] getGpkgInfoByConfig invalid request, game config null");
      if (paramOnInitGpkgListener != null) {
        paramOnInitGpkgListener.onInitGpkgInfo(2002, null, "getGpkgInfoByConfig invalid request, game config null", null);
      }
      return;
    }
    QLog.i("[minigame] GpkgManager", 1, "[Gpkg] getGpkgInfoByConfig version:" + paramMiniAppConfig.config.version + ", appid=" + paramMiniAppConfig.config.appId + ",size=" + paramMiniAppConfig.config.fileSize);
    String str = ApkgManager.getApkgFolderPath(paramMiniAppConfig.config);
    QLog.i("[minigame] GpkgManager", 1, "[Gpkg] getGpkgInfoByConfig folderPath:" + str);
    if ((paramMiniAppConfig.config.verType != 3) && ((!paramMiniAppConfig.config.isSupportOffline) || (paramMiniAppConfig.launchParam.scene == 1011)))
    {
      QLog.i("[minigame] GpkgManager", 1, "[Gpkg]verType is not online " + paramMiniAppConfig.config.verType + ", delete path " + str);
      if (new File(str).exists()) {
        aqhq.delete(str, false);
      }
    }
    paramOnInitGpkgListener = new MergedOnInitListener(paramMiniAppConfig, paramOnInitGpkgListener);
    performDownloadGpkg(paramMiniAppConfig, paramOnInitGpkgListener, str, paramBoolean);
    if (paramMiniAppConfig.config.miniGamePluginInfo != null)
    {
      performDownloadGpkgPlugin(paramMiniAppConfig.config.miniGamePluginInfo, paramOnInitGpkgListener);
      return;
    }
    QLog.i("[minigame] GpkgManager", 1, "[Gpkg] game don't have plugin " + paramMiniAppConfig.config.name + " " + paramMiniAppConfig.config.appId);
    paramOnInitGpkgListener.onPluginDownloadComplete(true, null, null);
  }
  
  public static boolean pkgExists(MiniAppInfo paramMiniAppInfo)
  {
    return new File(ApkgManager.getApkgFolderPath(paramMiniAppInfo)).exists();
  }
  
  public static void preloadGpkgByConfig(MiniAppConfig paramMiniAppConfig)
  {
    ApkgMainProcessManager.checkShouldLoadPkgInMainProcess(paramMiniAppConfig, null, true);
  }
  
  public static void setOfflineResourceContent(MiniAppConfig paramMiniAppConfig, boolean paramBoolean)
  {
    if (paramMiniAppConfig == null) {}
    do
    {
      return;
      paramMiniAppConfig = ApkgManager.getApkgFolderPath(paramMiniAppConfig.config);
    } while (!new File(paramMiniAppConfig).exists());
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("offlineResourceReady", paramBoolean);
      localObject = ((JSONObject)localObject).toString().replaceAll("\\\\", "");
      FileUtils.writeFile(new File(paramMiniAppConfig, "offlineconfig.json").getAbsolutePath(), (String)localObject);
      return;
    }
    catch (Throwable paramMiniAppConfig)
    {
      paramMiniAppConfig.printStackTrace();
    }
  }
  
  static abstract interface DownloadPluginCallback
  {
    public abstract void onPluginDownloadComplete(boolean paramBoolean, @Nullable Throwable paramThrowable, GpkgManager.Info paramInfo);
  }
  
  public static class Info
  {
    public long connectionTimeMs;
    public long contentSize;
    public long dnsTimeMs;
    public long httpStatusCode;
    public boolean isFromReusedConnection;
    public String message;
    @Nullable
    public Info plugin;
    public long queueTimeMs;
    public long receiveTimeMs;
    public boolean success;
    public long timeCostMs;
    public String url;
  }
  
  static final class MergedOnInitListener
    implements GpkgManager.DownloadPluginCallback, GpkgManager.OnInitGpkgListener
  {
    private MiniAppConfig mGameConfig;
    private boolean mGpkgDone;
    private GpkgManager.Info mGpkgDownloadInfo;
    private String mGpkgErrorMsg;
    private MiniGamePkg mGpkgPkg;
    private int mGpkgResCode;
    private final GpkgManager.OnInitGpkgListener mMergedResultListener;
    private boolean mPluginDone;
    private GpkgManager.Info mPluginDownloadInfo;
    private Throwable mPluginError;
    private boolean mPluginSuccess;
    
    MergedOnInitListener(MiniAppConfig paramMiniAppConfig, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener)
    {
      this.mGameConfig = paramMiniAppConfig;
      this.mMergedResultListener = paramOnInitGpkgListener;
    }
    
    private void handleFinish()
    {
      GpkgManager.OnInitGpkgListener localOnInitGpkgListener;
      MiniGamePkg localMiniGamePkg;
      if ((this.mGpkgDone) && (this.mPluginDone))
      {
        if (this.mGpkgDownloadInfo != null) {
          this.mGpkgDownloadInfo.plugin = this.mPluginDownloadInfo;
        }
        if (!this.mPluginSuccess)
        {
          localOnInitGpkgListener = this.mMergedResultListener;
          localMiniGamePkg = this.mGpkgPkg;
          if (this.mPluginError == null) {
            break label105;
          }
        }
      }
      label105:
      for (String str = this.mPluginError.getMessage();; str = "download plugin fail")
      {
        localOnInitGpkgListener.onInitGpkgInfo(2022, localMiniGamePkg, str, this.mGpkgDownloadInfo);
        this.mMergedResultListener.onInitGpkgInfo(this.mGpkgResCode, this.mGpkgPkg, this.mGpkgErrorMsg, this.mGpkgDownloadInfo);
        return;
      }
    }
    
    public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
    {
      this.mMergedResultListener.onDownloadGpkgProgress(paramMiniAppInfo, paramFloat, paramLong);
    }
    
    public void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString, GpkgManager.Info paramInfo)
    {
      try
      {
        this.mGpkgDone = true;
        this.mGpkgResCode = paramInt;
        this.mGpkgPkg = paramMiniGamePkg;
        this.mGpkgErrorMsg = paramString;
        this.mGpkgDownloadInfo = paramInfo;
        handleFinish();
        return;
      }
      finally
      {
        paramMiniGamePkg = finally;
        throw paramMiniGamePkg;
      }
    }
    
    public void onPluginDownloadComplete(boolean paramBoolean, @Nullable Throwable paramThrowable, GpkgManager.Info paramInfo)
    {
      try
      {
        this.mPluginDone = true;
        this.mPluginSuccess = paramBoolean;
        this.mPluginError = paramThrowable;
        this.mPluginDownloadInfo = paramInfo;
        if (paramInfo != null) {
          paramInfo.message = (this.mGameConfig.config.miniGamePluginInfo.name + "/" + this.mGameConfig.config.miniGamePluginInfo.id + " " + paramInfo.message);
        }
        handleFinish();
        return;
      }
      finally {}
    }
  }
  
  public static abstract interface OnInitGpkgListener
  {
    public static final int DEBUG_APK_NOT_EXIST = 2006;
    public static final int DOWNLOAD_PARAM_ERROR = 2023;
    public static final int DOWNLOAD_PKG_CANCEL = 2003;
    public static final int DOWNLOAD_PKG_FAIL = 2004;
    public static final int DOWNLOAD_PLUGIN_FAIL = 2022;
    public static final int DOWNLOAD_SUB_PKG_CANCEL = 2009;
    public static final int DOWNLOAD_SUB_PKG_FAIL = 2010;
    public static final int DOWNLOAD_UNKNOW_ERROR = 2024;
    public static final int EXCEPTION = 2001;
    public static final int GAME_CONFIG_NULL_ERROR = 2002;
    public static final int PKG_DOWNLOAD_URL_NULL = 2025;
    public static final int PKG_FOLD_NOT_EXIST = 2007;
    public static final int RES_SUCC = 0;
    public static final int SUB_PKG_DOWNLOAD_URL_NULL = 2008;
    public static final int UNPACK_PKG_FAIL = 2005;
    public static final int UNPACK_SUB_PKG_FAIL = 2011;
    
    public abstract void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong);
    
    public abstract void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString, @Nullable GpkgManager.Info paramInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.gpkg.GpkgManager
 * JD-Core Version:    0.7.0.1
 */