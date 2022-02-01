package com.tencent.qqmini.minigame.gpkg;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.manager.WxapkgUnpacker;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniAppStartState;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class GpkgManager
{
  public static final int NO_PRELOAD = 0;
  public static final int PRELOAD_APPINFI = 1;
  public static final int PRELOAD_GPKG = 2;
  public static final String SUFFIX_TQAPKG = ".tqapkg";
  public static final String SUFFIX_WXAPKG = ".wxapkg";
  public static final String SUFFIX_ZIP = ".zip";
  private static final String TAG = "[minigame] GpkgManager";
  private static final int UNZIP_MAXCOUNT = 3;
  public static volatile long downloadDuration = 0L;
  
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
      QMLog.i("[minigame] GpkgManager", "[Gpkg] checkOfflineResourceContent error:" + DebugUtil.getPrintableStackTrace(paramString));
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
        QMLog.i("[minigame] GpkgManager", "[Gpkg] checkPkgFolderContent error:" + DebugUtil.getPrintableStackTrace(paramString));
      }
    }
    return false;
  }
  
  private static void downloadGpkgByResumableDownloader(MiniAppInfo paramMiniAppInfo, OnInitGpkgListener paramOnInitGpkgListener, String paramString)
  {
    if (paramMiniAppInfo == null)
    {
      if (paramOnInitGpkgListener != null) {
        paramOnInitGpkgListener.onInitGpkgInfo(2002, null, "downloadGpkgByResumableDownloader fail invalid params, game config null", null);
      }
      QMLog.e("[minigame] GpkgManager", "[Gpkg]downloadGpkgByResumableDownloader fail invalid params, game config null");
      return;
    }
    if (!TextUtils.isEmpty(paramMiniAppInfo.appId)) {
      MiniAppStartState.setApkgDownload(paramMiniAppInfo.appId, false);
    }
    long l = System.currentTimeMillis();
    Object localObject1 = null;
    int i = -1;
    String str1;
    Object localObject2;
    Object localObject3;
    String str2;
    if (paramMiniAppInfo.firstPage != null)
    {
      str1 = paramMiniAppInfo.firstPage.subPkgName;
      if (paramMiniAppInfo.subpkgs != null)
      {
        localObject2 = paramMiniAppInfo.subpkgs.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SubPkgInfo)((Iterator)localObject2).next();
          if ((localObject3 != null) && (str1 != null) && (str1.equals(((SubPkgInfo)localObject3).subPkgName))) {
            if (((SubPkgInfo)localObject3).independent == 1)
            {
              str2 = ((SubPkgInfo)localObject3).downloadUrl;
              i = ((SubPkgInfo)localObject3).fileSize;
              localObject2 = localObject1;
              localObject1 = str2;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        localObject1 = paramMiniAppInfo.downloadUrl;
        i = paramMiniAppInfo.fileSize;
        label182:
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (paramOnInitGpkgListener != null) {
            paramOnInitGpkgListener.onInitGpkgInfo(2002, null, "downloadGpkgByResumableDownloader fail invalid params, downloadUrl null", null);
          }
          QMLog.e("[minigame] GpkgManager", "[Gpkg]downloadGpkgByResumableDownloader fail invalid params, downloadUrl null");
          return;
          localObject1 = ((SubPkgInfo)localObject3).downloadUrl;
          i = ((SubPkgInfo)localObject3).fileSize;
        }
      }
      for (;;)
      {
        break;
        if (((String)localObject1).toLowerCase().endsWith(".zip")) {}
        for (str2 = ".zip";; str2 = ".tqapkg")
        {
          str2 = ApkgManager.getPkgRoot(paramMiniAppInfo) + paramMiniAppInfo.appId + '_' + paramMiniAppInfo.version + str2;
          QMLog.i("[minigame] GpkgManager", "[Gpkg]download gpkgUrl=" + (String)localObject1 + " ,subApkUrl=" + (String)localObject2 + " ,independentPath=" + str1 + " ,savePath=" + str2 + " ,fileSize=" + i);
          MiniReportManager.reportEventType(paramMiniAppInfo, 619, "1");
          localObject3 = (DownloaderProxy)ProxyManager.get(DownloaderProxy.class);
          new HashMap(1).put("Connection", "keep-alive");
          ((DownloaderProxy)localObject3).download((String)localObject1, null, str2, 60, new GpkgManager.4(paramMiniAppInfo, paramOnInitGpkgListener, l, str2, paramString, (String)localObject2, str1, i));
          return;
        }
        break label182;
      }
      str1 = null;
      localObject2 = localObject1;
      localObject1 = null;
      continue;
      i = -1;
      str1 = null;
      localObject2 = null;
      localObject1 = null;
    }
  }
  
  public static void downloadSubPack(MiniAppInfo paramMiniAppInfo, MiniGamePkg paramMiniGamePkg, String paramString, OnInitGpkgListener paramOnInitGpkgListener)
  {
    String str2 = paramMiniGamePkg.getRootPath(paramString);
    Object localObject = getSubPkgDownloadUrl(paramMiniAppInfo, paramMiniGamePkg, paramString);
    String str1;
    String str3;
    int i;
    if (localObject != null)
    {
      str1 = ((SubPkgInfo)localObject).downloadUrl;
      str3 = ApkgManager.getApkgFolderPath(paramMiniAppInfo);
      if (localObject == null) {
        break label137;
      }
      i = ((SubPkgInfo)localObject).fileSize;
      label45:
      QMLog.i("[minigame] GpkgManager subpackage", "[Gpkg] downloadSubPack | downPage(subName)=" + paramString + "; subPackDownloadUrl=" + str1 + "; folder:" + str3 + "; fileSize:" + i);
      if (!TextUtils.isEmpty(str3)) {
        break label143;
      }
      if (paramOnInitGpkgListener != null) {
        paramOnInitGpkgListener.onInitGpkgInfo(2007, null, "downloadSubPack but pkg folder not exist", null);
      }
    }
    label137:
    label143:
    do
    {
      return;
      str1 = null;
      break;
      i = -1;
      break label45;
      if (!new File(str3, str2).exists()) {
        break label177;
      }
    } while (paramOnInitGpkgListener == null);
    paramOnInitGpkgListener.onInitGpkgInfo(0, paramMiniGamePkg, "downloadSubPack succeed, sub pkg already exist", null);
    return;
    label177:
    if (!TextUtils.isEmpty(str1))
    {
      if (str1.toLowerCase().endsWith(".zip")) {}
      for (paramString = ".zip";; paramString = ".tqapkg")
      {
        paramString = ApkgManager.getPkgRoot(paramMiniAppInfo) + paramMiniAppInfo.appId + '_' + paramMiniAppInfo.version + "_" + System.nanoTime() + paramString;
        MiniReportManager.reportEventType(paramMiniAppInfo, 613, "1");
        localObject = (DownloaderProxy)ProxyManager.get(DownloaderProxy.class);
        new HashMap(1).put("Connection", "keep-alive");
        ((DownloaderProxy)localObject).download(str1, null, paramString, 60, new GpkgManager.6(paramMiniAppInfo, paramOnInitGpkgListener, paramString, str2, paramMiniGamePkg, i));
        return;
      }
    }
    paramOnInitGpkgListener.onInitGpkgInfo(2008, null, "sub pkg download url empty", null);
  }
  
  /* Error */
  private static String getGpkgFilePath(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokestatic 73	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: ldc 33
    //   13: aload_0
    //   14: invokestatic 333	com/tencent/qqmini/sdk/core/utils/FileUtils:getExtension	(Ljava/lang/String;)Ljava/lang/String;
    //   17: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   20: ifeq +186 -> 206
    //   23: aload_0
    //   24: ldc 33
    //   26: ldc_w 335
    //   29: invokevirtual 339	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   32: astore 6
    //   34: aload_0
    //   35: ldc 33
    //   37: ldc 27
    //   39: invokevirtual 339	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   42: astore 5
    //   44: iconst_0
    //   45: istore_1
    //   46: aconst_null
    //   47: astore_3
    //   48: aload_0
    //   49: aload 6
    //   51: invokestatic 345	com/tencent/qqmini/sdk/core/utils/ZipUtil:unZipFolder	(Ljava/lang/String;Ljava/lang/String;)I
    //   54: ifne +218 -> 272
    //   57: aload 6
    //   59: invokestatic 348	com/tencent/qqmini/sdk/core/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   62: ifeq +210 -> 272
    //   65: aload 6
    //   67: iconst_0
    //   68: iconst_0
    //   69: invokestatic 352	com/tencent/qqmini/sdk/core/utils/FileUtils:getFiles	(Ljava/lang/String;ZI)Ljava/util/ArrayList;
    //   72: astore 4
    //   74: aload 4
    //   76: ifnull +306 -> 382
    //   79: aload 4
    //   81: invokevirtual 358	java/util/ArrayList:size	()I
    //   84: ifle +298 -> 382
    //   87: aload 4
    //   89: invokevirtual 359	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   92: astore 4
    //   94: aload 4
    //   96: invokeinterface 186 1 0
    //   101: ifeq +281 -> 382
    //   104: aload 4
    //   106: invokeinterface 190 1 0
    //   111: checkcast 361	com/tencent/qqmini/sdk/core/utils/FileInfo
    //   114: astore 7
    //   116: ldc 27
    //   118: aload 7
    //   120: invokevirtual 364	com/tencent/qqmini/sdk/core/utils/FileInfo:getPath	()Ljava/lang/String;
    //   123: invokestatic 333	com/tencent/qqmini/sdk/core/utils/FileUtils:getExtension	(Ljava/lang/String;)Ljava/lang/String;
    //   126: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   129: ifne +19 -> 148
    //   132: ldc 30
    //   134: aload 7
    //   136: invokevirtual 364	com/tencent/qqmini/sdk/core/utils/FileInfo:getPath	()Ljava/lang/String;
    //   139: invokestatic 333	com/tencent/qqmini/sdk/core/utils/FileUtils:getExtension	(Ljava/lang/String;)Ljava/lang/String;
    //   142: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   145: ifeq -51 -> 94
    //   148: aload 7
    //   150: invokevirtual 364	com/tencent/qqmini/sdk/core/utils/FileInfo:getPath	()Ljava/lang/String;
    //   153: astore 4
    //   155: aload 4
    //   157: astore_3
    //   158: aload_3
    //   159: astore 4
    //   161: aload_3
    //   162: invokestatic 348	com/tencent/qqmini/sdk/core/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   165: ifeq +110 -> 275
    //   168: new 82	java/io/File
    //   171: dup
    //   172: aload_3
    //   173: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   176: new 82	java/io/File
    //   179: dup
    //   180: aload 5
    //   182: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   185: invokestatic 368	com/tencent/qqmini/sdk/core/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   188: istore_2
    //   189: aload_3
    //   190: astore 4
    //   192: iload_2
    //   193: ifeq +82 -> 275
    //   196: aload 6
    //   198: iconst_0
    //   199: invokestatic 372	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   202: pop2
    //   203: aload 5
    //   205: astore_3
    //   206: aload_3
    //   207: invokestatic 348	com/tencent/qqmini/sdk/core/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   210: ifeq +153 -> 363
    //   213: aload_3
    //   214: astore 4
    //   216: aload_3
    //   217: aload_0
    //   218: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   221: ifne +12 -> 233
    //   224: aload_0
    //   225: iconst_0
    //   226: invokestatic 372	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   229: pop2
    //   230: aload_3
    //   231: astore 4
    //   233: ldc 36
    //   235: new 75	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   242: ldc_w 374
    //   245: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload 4
    //   250: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc_w 376
    //   256: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_0
    //   260: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 127	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: aload 4
    //   271: areturn
    //   272: aload_3
    //   273: astore 4
    //   275: iload_1
    //   276: iconst_1
    //   277: iadd
    //   278: istore_1
    //   279: aload 4
    //   281: astore_3
    //   282: iload_1
    //   283: iconst_3
    //   284: if_icmpge -78 -> 206
    //   287: aload 4
    //   289: astore_3
    //   290: goto -242 -> 48
    //   293: astore 4
    //   295: ldc 36
    //   297: new 75	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   304: ldc_w 378
    //   307: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_0
    //   311: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: ldc_w 380
    //   317: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload 6
    //   322: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc_w 382
    //   328: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: iload_1
    //   332: invokevirtual 245	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: aload 4
    //   340: invokestatic 385	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   343: aload 6
    //   345: iconst_0
    //   346: invokestatic 372	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   349: pop2
    //   350: iload_1
    //   351: iconst_1
    //   352: iadd
    //   353: istore_1
    //   354: aload_3
    //   355: astore 4
    //   357: goto -78 -> 279
    //   360: astore_0
    //   361: aload_0
    //   362: athrow
    //   363: aload_0
    //   364: astore 4
    //   366: goto -133 -> 233
    //   369: astore 4
    //   371: aload 5
    //   373: astore_3
    //   374: goto -79 -> 295
    //   377: astore 4
    //   379: goto -84 -> 295
    //   382: goto -224 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	paramString	String
    //   45	309	1	i	int
    //   188	5	2	bool	boolean
    //   1	373	3	localObject1	Object
    //   72	216	4	localObject2	Object
    //   293	46	4	localThrowable1	Throwable
    //   355	10	4	localObject3	Object
    //   369	1	4	localThrowable2	Throwable
    //   377	1	4	localThrowable3	Throwable
    //   42	330	5	str1	String
    //   32	312	6	str2	String
    //   114	35	7	localFileInfo	com.tencent.qqmini.sdk.core.utils.FileInfo
    // Exception table:
    //   from	to	target	type
    //   161	189	293	java/lang/Throwable
    //   48	74	360	finally
    //   79	94	360	finally
    //   94	148	360	finally
    //   148	155	360	finally
    //   161	189	360	finally
    //   196	203	360	finally
    //   295	350	360	finally
    //   196	203	369	java/lang/Throwable
    //   48	74	377	java/lang/Throwable
    //   79	94	377	java/lang/Throwable
    //   94	148	377	java/lang/Throwable
    //   148	155	377	java/lang/Throwable
  }
  
  public static void getGpkgInfoByConfig(MiniAppInfo paramMiniAppInfo, OnInitGpkgListener paramOnInitGpkgListener)
  {
    if (paramMiniAppInfo == null)
    {
      QMLog.e("[minigame] GpkgManager", "[Gpkg] getGpkgInfoByConfig invalid request, game config null");
      if (paramOnInitGpkgListener != null) {
        paramOnInitGpkgListener.onInitGpkgInfo(2002, null, "getGpkgInfoByConfig invalid request, game config null", null);
      }
      return;
    }
    paramOnInitGpkgListener = new GpkgManager.1(paramMiniAppInfo, paramOnInitGpkgListener);
    ApkgMainProcessManager.queueSubProcessLoadTask(paramMiniAppInfo);
    loadGpkgInMiniProcess(paramMiniAppInfo, paramOnInitGpkgListener);
  }
  
  private static Info getInfoFromDownloadResult(DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    if (paramDownloadResult == null) {
      return null;
    }
    Info localInfo = new Info();
    localInfo.url = paramDownloadResult.url;
    localInfo.timeCostMs = paramDownloadResult.totalTimeMs;
    localInfo.queueTimeMs = paramDownloadResult.queueTimeMs;
    localInfo.connectionTimeMs = paramDownloadResult.connectionTimeMs;
    localInfo.contentSize = paramDownloadResult.contentLength;
    localInfo.dnsTimeMs = paramDownloadResult.dnsTimeMs;
    localInfo.httpStatusCode = paramDownloadResult.httpStatusCode;
    localInfo.message = paramDownloadResult.message;
    localInfo.isFromReusedConnection = paramDownloadResult.isFromReusedConnection;
    localInfo.receiveTimeMs = paramDownloadResult.receiveTimeMs;
    return localInfo;
  }
  
  private static SubPkgInfo getSubPkgDownloadUrl(MiniAppInfo paramMiniAppInfo, MiniGamePkg paramMiniGamePkg, String paramString)
  {
    paramMiniAppInfo = paramMiniAppInfo.subpkgs;
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.size() > 0) && (!TextUtils.isEmpty(paramString)))
    {
      paramMiniAppInfo = paramMiniAppInfo.iterator();
      while (paramMiniAppInfo.hasNext())
      {
        paramMiniGamePkg = (SubPkgInfo)paramMiniAppInfo.next();
        if (paramString.equals(paramMiniGamePkg.subPkgName)) {
          return paramMiniGamePkg;
        }
      }
    }
    return null;
  }
  
  private static void handleGpkgDownloadSuccess(String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo, OnInitGpkgListener paramOnInitGpkgListener, String paramString3, String paramString4, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    File localFile = new File(paramString1);
    MiniReportManager.reportEventType(paramMiniAppInfo, 621, "1");
    boolean bool = WxapkgUnpacker.unpackSync(localFile.getAbsolutePath(), paramString2);
    int i;
    if (bool)
    {
      i = 0;
      MiniReportManager.reportEventType(paramMiniAppInfo, 622, null, null, null, i, "1", 0L, null);
      QMLog.i("[minigame] GpkgManager", "[Gpkg] handleGpkgDownloadSuccess path:" + paramString1 + ",unpack:" + paramString2 + ",hasUnpack:" + bool);
      if (!bool) {
        break label187;
      }
      paramString1 = MiniGamePkg.loadGamePkgFromFolderPath(paramString2, paramString4, paramMiniAppInfo);
      if (paramString3 == null) {
        break label166;
      }
      QMLog.i("[minigame] GpkgManager", "[Gpkg] downloadSubPack after gpk succeed, subApkUrl=" + paramString3);
      downloadSubPack(paramMiniAppInfo, paramString1, paramString3, new GpkgManager.5(paramOnInitGpkgListener));
    }
    label166:
    label187:
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
      SDKMiniProgramLpReportDC04239.reportForSDK(paramMiniAppInfo, "1", null, "page_view", "load_fail", "unpkg_fail", "");
      MiniAppReportManager2.reportPageView("2launch_fail", "unpkg_fail", null, paramMiniAppInfo);
      QMLog.e("[minigame] GpkgManager", "[Gpkg] handleGpkgDownloadSuccess hasUnpack=" + bool);
    } while (paramOnInitGpkgListener == null);
    paramOnInitGpkgListener.onInitGpkgInfo(2005, null, "download pkg succeed but unpack fail", getInfoFromDownloadResult(paramDownloadResult));
  }
  
  public static boolean isGpkgValid(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    do
    {
      return false;
      paramMiniAppInfo = ApkgManager.getApkgFolderPath(paramMiniAppInfo);
    } while (!new File(paramMiniAppInfo).exists());
    return checkPkgFolderContent(paramMiniAppInfo);
  }
  
  public static boolean isOfflineResourceReady(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    do
    {
      return false;
      paramMiniAppInfo = ApkgManager.getApkgFolderPath(paramMiniAppInfo);
    } while ((!new File(paramMiniAppInfo).exists()) || (!checkPkgFolderContent(paramMiniAppInfo)));
    return checkOfflineResourceContent(paramMiniAppInfo);
  }
  
  private static void loadGpkgInMiniProcess(MiniAppInfo paramMiniAppInfo, OnInitGpkgListener paramOnInitGpkgListener)
  {
    performGetGpkgInfoByConfig(paramMiniAppInfo, paramOnInitGpkgListener);
  }
  
  private static void performDownloadGpkg(MiniAppInfo paramMiniAppInfo, OnInitGpkgListener paramOnInitGpkgListener, String paramString)
  {
    if (new File(paramString).exists())
    {
      if (checkPkgFolderContent(paramString))
      {
        QMLog.i("[minigame] GpkgManager", "[Gpkg] checkPkgFolderContent success");
        paramString = MiniGamePkg.loadGamePkgFromFolderPath(paramString, null, paramMiniAppInfo);
        if (paramOnInitGpkgListener != null) {
          paramOnInitGpkgListener.onInitGpkgInfo(0, paramString, "gpkg exist, no need download", null);
        }
        if (!TextUtils.isEmpty(paramMiniAppInfo.appId)) {
          MiniAppStartState.setApkgDownload(paramMiniAppInfo.appId, true);
        }
        return;
      }
      QMLog.i("[minigame] GpkgManager", "[Gpkg] checkPkgFolderContent failed, delete folder:" + paramString);
      FileUtils.delete(paramString, false);
      QMLog.i("[minigame] GpkgManager", "[Gpkg] download gpkg by url1:" + paramMiniAppInfo.downloadUrl);
      downloadGpkgByResumableDownloader(paramMiniAppInfo, paramOnInitGpkgListener, paramString);
      return;
    }
    QMLog.i("[minigame] GpkgManager", "[Gpkg] download gpkg by url2:" + paramMiniAppInfo.downloadUrl);
    downloadGpkgByResumableDownloader(paramMiniAppInfo, paramOnInitGpkgListener, paramString);
  }
  
  private static void performDownloadGpkgPlugin(MiniGamePluginInfo paramMiniGamePluginInfo, DownloadPluginCallback paramDownloadPluginCallback)
  {
    File localFile1 = new File(ApkgManager.getGpkgPluginFolderPath(paramMiniGamePluginInfo));
    if (localFile1.exists())
    {
      if (new File(localFile1, "plugin.js").exists())
      {
        QMLog.i("[minigame] GpkgManager", "[Gpkg] plugin existed:" + localFile1.getAbsolutePath() + " " + paramMiniGamePluginInfo);
        paramDownloadPluginCallback.onPluginDownloadComplete(true, null, null);
        return;
      }
      QMLog.e("[minigame] GpkgManager", "[Gpkg] plugin corrupted:" + localFile1.getAbsolutePath() + " " + paramMiniGamePluginInfo);
    }
    File localFile2;
    try
    {
      localFile2 = File.createTempFile("gpkg_plugin_" + paramMiniGamePluginInfo.id, ".wxapkg");
      if (TextUtils.isEmpty(paramMiniGamePluginInfo.url))
      {
        if (paramDownloadPluginCallback != null) {
          paramDownloadPluginCallback.onPluginDownloadComplete(false, null, null);
        }
        QMLog.e("[minigame] GpkgManager", "[Gpkg] download plugin failed pluginInfo.url null");
        return;
      }
    }
    catch (IOException paramMiniGamePluginInfo)
    {
      paramDownloadPluginCallback.onPluginDownloadComplete(false, paramMiniGamePluginInfo, null);
      return;
    }
    QMLog.i("[minigame] GpkgManager", "[Gpkg] start download plugin to:" + localFile1.getAbsolutePath() + " " + paramMiniGamePluginInfo);
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramMiniGamePluginInfo.url, null, localFile2.getAbsolutePath(), 60, new GpkgManager.3(paramMiniGamePluginInfo, paramDownloadPluginCallback, localFile2, localFile1));
  }
  
  public static void performGetGpkgInfoByConfig(MiniAppInfo paramMiniAppInfo, OnInitGpkgListener paramOnInitGpkgListener)
  {
    MiniReportManager.addCostTimeEventAttachInfo(paramMiniAppInfo, 2, "0");
    if (paramMiniAppInfo == null)
    {
      QMLog.e("[minigame] GpkgManager", "[Gpkg] getGpkgInfoByConfig invalid request, game config null");
      if (paramOnInitGpkgListener != null) {
        paramOnInitGpkgListener.onInitGpkgInfo(2002, null, "getGpkgInfoByConfig invalid request, game config null", null);
      }
      return;
    }
    QMLog.i("[minigame] GpkgManager", "[Gpkg] getGpkgInfoByConfig version:" + paramMiniAppInfo.version + ", appid=" + paramMiniAppInfo.appId + ",size=" + paramMiniAppInfo.fileSize);
    String str = ApkgManager.getApkgFolderPath(paramMiniAppInfo);
    QMLog.i("[minigame] GpkgManager", "[Gpkg] getGpkgInfoByConfig folderPath:" + str);
    if ((paramMiniAppInfo.verType != 3) && ((!paramMiniAppInfo.isSupportOffline) || (paramMiniAppInfo.launchParam.scene == 1011)))
    {
      QMLog.i("[minigame] GpkgManager", "[Gpkg]verType is not online " + paramMiniAppInfo.verType + ", delete path " + str);
      if (new File(str).exists()) {
        FileUtils.delete(str, false);
      }
    }
    paramOnInitGpkgListener = new MergedOnInitListener(paramMiniAppInfo, paramOnInitGpkgListener);
    performDownloadGpkg(paramMiniAppInfo, paramOnInitGpkgListener, str);
    if (paramMiniAppInfo.miniGamePluginInfo != null)
    {
      performDownloadGpkgPlugin(paramMiniAppInfo.miniGamePluginInfo, paramOnInitGpkgListener);
      return;
    }
    QMLog.i("[minigame] GpkgManager", "[Gpkg] game don't have plugin " + paramMiniAppInfo.name + " " + paramMiniAppInfo.appId);
    paramOnInitGpkgListener.onPluginDownloadComplete(true, null, null);
  }
  
  public static boolean pkgExists(MiniAppInfo paramMiniAppInfo)
  {
    return new File(ApkgManager.getApkgFolderPath(paramMiniAppInfo)).exists();
  }
  
  public static void preloadGpkgByConfig(MiniAppInfo paramMiniAppInfo)
  {
    ThreadManager.executeOnNetworkIOThreadPool(new GpkgManager.2(paramMiniAppInfo));
  }
  
  public static void setOfflineResourceContent(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    if (paramMiniAppInfo == null) {}
    do
    {
      return;
      paramMiniAppInfo = ApkgManager.getApkgFolderPath(paramMiniAppInfo);
    } while (!new File(paramMiniAppInfo).exists());
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("offlineResourceReady", paramBoolean);
      localObject = ((JSONObject)localObject).toString().replaceAll("\\\\", "");
      FileUtils.writeFile(new File(paramMiniAppInfo, "offlineconfig.json").getAbsolutePath(), (String)localObject);
      return;
    }
    catch (Throwable paramMiniAppInfo)
    {
      paramMiniAppInfo.printStackTrace();
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
    private MiniAppInfo mGameConfig;
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
    
    MergedOnInitListener(MiniAppInfo paramMiniAppInfo, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener)
    {
      this.mGameConfig = paramMiniAppInfo;
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
          paramInfo.message = (this.mGameConfig.miniGamePluginInfo.name + "/" + this.mGameConfig.miniGamePluginInfo.id + " " + paramInfo.message);
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
    public static final int DOWNLOAD_PKG_CANCEL = 2003;
    public static final int DOWNLOAD_PKG_FAIL = 2004;
    public static final int DOWNLOAD_PLUGIN_FAIL = 2022;
    public static final int DOWNLOAD_SUB_PKG_CANCEL = 2009;
    public static final int DOWNLOAD_SUB_PKG_FAIL = 2010;
    public static final int EXCEPTION = 2001;
    public static final int GAME_CONFIG_NULL_ERROR = 2002;
    public static final int PKG_FOLD_NOT_EXIST = 2007;
    public static final int RES_SUCC = 0;
    public static final int SUB_PKG_DOWNLOAD_URL_NULL = 2008;
    public static final int UNPACK_PKG_FAIL = 2005;
    public static final int UNPACK_SUB_PKG_FAIL = 2011;
    
    public abstract void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong);
    
    public abstract void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString, @Nullable GpkgManager.Info paramInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.GpkgManager
 * JD-Core Version:    0.7.0.1
 */