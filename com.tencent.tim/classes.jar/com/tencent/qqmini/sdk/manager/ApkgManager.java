package com.tencent.qqmini.sdk.manager;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.manager.WxapkgUnpacker;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniAppStartState;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class ApkgManager
{
  public static final String MINI_APP_MAIN_PKG = "/__APP__/";
  public static final String MINI_GAME_PERSISTENT_SP_KEY = "persistent";
  public static final String MINI_GAME_PERSISTENT_SP_NAME = "persistent_debug_version_";
  public static final String SUFFIX_WXAPKG = ".qapkg";
  private static final String TAG = "ApkgManager";
  public static volatile long downloadDuration = 0L;
  private static volatile ApkgManager sInstance;
  private String subRoot = "";
  
  private void deleteOldPkg(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    ThreadManager.executeOnDiskIOThreadPool(new ApkgManager.4(this, paramMiniAppInfo, paramString));
  }
  
  private void downloadApkgByResumableDownloader(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, OnGetApkgInfoListener paramOnGetApkgInfoListener, String paramString)
  {
    String str;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (paramMiniAppInfo.firstPage != null)
    {
      str = paramMiniAppInfo.firstPage.subPkgName;
      localObject2 = paramMiniAppInfo.subpkgs.iterator();
      localObject1 = null;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SubPkgInfo)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((SubPkgInfo)localObject3).subPkgName != null) && (((SubPkgInfo)localObject3).subPkgName.equals(str))) {
          if (((SubPkgInfo)localObject3).independent == 1)
          {
            localObject3 = ((SubPkgInfo)localObject3).downloadUrl;
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = paramMiniAppInfo.downloadUrl;
      }
      downloadApkgByResumableDownloader(paramMiniAppInfo, paramBoolean, paramOnGetApkgInfoListener, paramString, (String)localObject3, (String)localObject2, str);
      return;
      localObject1 = paramMiniAppInfo.firstPage.pagePath;
      for (;;)
      {
        break;
      }
      str = null;
      localObject2 = localObject1;
      localObject1 = null;
      continue;
      str = null;
      localObject2 = null;
      localObject1 = null;
    }
  }
  
  private void downloadApkgByResumableDownloader(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, OnGetApkgInfoListener paramOnGetApkgInfoListener, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = RootPath.getAppPkgRoot() + paramMiniAppInfo.appId + '_' + paramMiniAppInfo.version + ".qapkg";
    long l = System.currentTimeMillis();
    if (TextUtils.isEmpty(paramString2)) {
      if (paramOnGetApkgInfoListener != null)
      {
        paramOnGetApkgInfoListener.onGetApkgInfo(null, 1, "apkUrl is Null!");
        QMLog.e("ApkgManager", "downloadApkgByResumableDownloader apkUrl is null!");
      }
    }
    do
    {
      return;
      MiniReportManager.reportEventType(paramMiniAppInfo, 619, "0");
      ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString2, null, str, 60, new ApkgManager.2(this, paramOnGetApkgInfoListener, str, paramString1, paramMiniAppInfo, paramString3, paramString4, l));
    } while (!paramBoolean);
    deleteOldPkg(paramMiniAppInfo, paramString1);
  }
  
  public static String getApkgFolderPath(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {
      return "";
    }
    if (paramMiniAppInfo.verType == 3) {
      return getPkgRoot(paramMiniAppInfo) + MD5Utils.toMD5(paramMiniAppInfo.appId) + "_" + paramMiniAppInfo.versionId;
    }
    return getPkgRoot(paramMiniAppInfo) + paramMiniAppInfo.appId + "_debug";
  }
  
  private void getApkgInfoByConfig(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, OnGetApkgInfoListener paramOnGetApkgInfoListener)
  {
    if (paramMiniAppInfo == null) {}
    Object localObject;
    for (;;)
    {
      return;
      localObject = paramMiniAppInfo.version;
      QMLog.d("ApkgManager", "getApkgInfoByConfig version:" + (String)localObject);
      localObject = getApkgFolderPath(paramMiniAppInfo);
      if (paramMiniAppInfo.verType != 3)
      {
        QMLog.d("ApkgManager", "verType is not online, delete unPackFolderPath." + paramMiniAppInfo.verType);
        if (new File((String)localObject).exists()) {
          FileUtils.delete((String)localObject, false);
        }
      }
      if (paramMiniAppInfo.launchParam.isFlutterMode) {
        try
        {
          String str = (String)localObject + "_maintmp";
          if (new File(str).exists())
          {
            ApkgInfo localApkgInfo = ApkgInfo.loadApkgInfoFromFolderPath(str, null, paramMiniAppInfo);
            if (localApkgInfo == null) {
              continue;
            }
            QMLog.i("ApkgManager", "apkg has download in main process. folder:" + str);
            MiniAppStartState.setApkgDownload(paramMiniAppInfo.appId, true);
            if (paramOnGetApkgInfoListener == null) {
              continue;
            }
            paramOnGetApkgInfoListener.onGetApkgInfo(localApkgInfo, 0, "加载成功");
          }
        }
        catch (Throwable localThrowable)
        {
          QMLog.e("ApkgManager", "", localThrowable);
        }
      }
    }
    if (new File((String)localObject).exists())
    {
      localObject = ApkgInfo.loadApkgInfoFromFolderPath((String)localObject, null, paramMiniAppInfo);
      if (localObject != null)
      {
        MiniAppStartState.setApkgDownload(paramMiniAppInfo.appId, true);
        if (paramOnGetApkgInfoListener != null) {
          paramOnGetApkgInfoListener.onGetApkgInfo((ApkgInfo)localObject, 0, "");
        }
        if (paramMiniAppInfo.launchParam == null) {
          break label320;
        }
      }
      label320:
      for (paramOnGetApkgInfoListener = paramMiniAppInfo.launchParam.entryPath;; paramOnGetApkgInfoListener = "")
      {
        MiniAppReportManager2.reportPageView("cache_apkg_hit", "hit", paramOnGetApkgInfoListener, paramMiniAppInfo);
        return;
        if (paramOnGetApkgInfoListener == null) {
          break;
        }
        paramOnGetApkgInfoListener.onGetApkgInfo(null, 1, "ApkgInfo init failed");
        break;
      }
    }
    MiniAppStartState.setApkgDownload(paramMiniAppInfo.appId, false);
    downloadApkgByResumableDownloader(paramMiniAppInfo, paramBoolean, paramOnGetApkgInfoListener, (String)localObject);
    if (paramMiniAppInfo.launchParam != null) {}
    for (paramOnGetApkgInfoListener = paramMiniAppInfo.launchParam.entryPath;; paramOnGetApkgInfoListener = "")
    {
      MiniAppReportManager2.reportPageView("cache_apkg_hit", "unhit", paramOnGetApkgInfoListener, paramMiniAppInfo);
      return;
    }
  }
  
  public static String getGpkgPluginFolderPath(MiniGamePluginInfo paramMiniGamePluginInfo)
  {
    return RootPath.getGamePkgRoot() + MD5Utils.toMD5(paramMiniGamePluginInfo.id) + "_plugin_" + paramMiniGamePluginInfo.version;
  }
  
  public static ApkgManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new ApkgManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static String getPkgRoot(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo.isEngineTypeMiniGame()) {
      return RootPath.getGamePkgRoot();
    }
    if (paramMiniAppInfo.launchParam.isFlutterMode) {
      return RootPath.getTissuePkgRoot();
    }
    return RootPath.getAppPkgRoot();
  }
  
  private String getSubPkgDownloadUrl(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    paramMiniAppInfo = paramMiniAppInfo.subpkgs;
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.size() > 0) && (!TextUtils.isEmpty(paramString)))
    {
      paramMiniAppInfo = paramMiniAppInfo.iterator();
      while (paramMiniAppInfo.hasNext())
      {
        SubPkgInfo localSubPkgInfo = (SubPkgInfo)paramMiniAppInfo.next();
        if (paramString.equals(localSubPkgInfo.subPkgName)) {
          return localSubPkgInfo.downloadUrl;
        }
      }
    }
    return null;
  }
  
  private void handleApkgDownloadSuccess(String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo, String paramString3, String paramString4, OnGetApkgInfoListener paramOnGetApkgInfoListener)
  {
    MiniReportManager.reportEventType(paramMiniAppInfo, 621, "0");
    boolean bool = WxapkgUnpacker.unpackSync(new File(paramString1).getAbsolutePath(), paramString2);
    int i;
    if (bool)
    {
      i = 0;
      MiniReportManager.reportEventType(paramMiniAppInfo, 622, null, null, null, i);
      if (!bool) {
        break label127;
      }
      paramString1 = ApkgInfo.loadApkgInfoFromFolderPath(paramString2, paramString4, paramMiniAppInfo);
      if ((paramString3 == null) || (paramString1 == null)) {
        break label93;
      }
      downloadSubPack(paramString1, paramMiniAppInfo, paramString3, new ApkgManager.3(this, paramOnGetApkgInfoListener));
    }
    label93:
    label127:
    while (paramOnGetApkgInfoListener == null)
    {
      do
      {
        return;
        i = 1;
        break;
      } while (paramOnGetApkgInfoListener == null);
      if (paramString1 != null)
      {
        paramOnGetApkgInfoListener.onGetApkgInfo(paramString1, 0, "");
        return;
      }
      paramOnGetApkgInfoListener.onGetApkgInfo(paramString1, 1, "apkginfo is null");
      return;
    }
    paramOnGetApkgInfoListener.onGetApkgInfo(null, 3, "解包失败");
  }
  
  private void onInitApkgInfo(OnInitApkgListener paramOnInitApkgListener, int paramInt, ApkgInfo paramApkgInfo, String paramString)
  {
    QMLog.d("ApkgManager", "onInitApkgInfo :" + paramInt + "|" + paramString);
    if (paramOnInitApkgListener != null) {
      paramOnInitApkgListener.onInitApkgInfo(paramInt, paramApkgInfo, paramString);
    }
  }
  
  public static boolean pkgExists(MiniAppInfo paramMiniAppInfo)
  {
    return new File(getApkgFolderPath(paramMiniAppInfo)).exists();
  }
  
  public void downloadSubPack(ApkgInfo paramApkgInfo, MiniAppInfo paramMiniAppInfo, String paramString, OnInitApkgListener paramOnInitApkgListener)
  {
    String str2 = getApkgFolderPath(paramMiniAppInfo);
    String str1;
    if ("/__APP__/".equals(paramString))
    {
      this.subRoot = "";
      str1 = paramMiniAppInfo.downloadUrl;
      QMLog.d("ApkgManager", "downloadSubPack | downPage=" + paramString + "; subPackDownloadUrl=" + str1);
      if (!TextUtils.isEmpty(str1)) {
        break label118;
      }
      QMLog.e("ApkgManager", "subPackDownloadUrl is null, return.");
      if (paramOnInitApkgListener != null) {
        paramOnInitApkgListener.onInitApkgInfo(1, paramApkgInfo, null);
      }
    }
    label118:
    do
    {
      return;
      this.subRoot = paramApkgInfo.getRootPath(paramString);
      str1 = getSubPkgDownloadUrl(paramMiniAppInfo, this.subRoot);
      break;
      if (("/__APP__/".equals(paramString)) || (!new File(str2, this.subRoot).exists())) {
        break label162;
      }
    } while (paramOnInitApkgListener == null);
    paramOnInitApkgListener.onInitApkgInfo(0, paramApkgInfo, null);
    return;
    label162:
    if (!TextUtils.isEmpty(str1))
    {
      str2 = RootPath.getAppPkgRoot() + paramMiniAppInfo.appId + '_' + paramMiniAppInfo.version + ".qapkg";
      MiniReportManager.reportEventType(paramMiniAppInfo, 613, paramString, null, null, 0, "0", 0L, null);
      ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(str1, null, str2, 60, new ApkgManager.5(this, paramOnInitApkgListener, paramApkgInfo, paramMiniAppInfo, paramString, str2));
      return;
    }
    paramOnInitApkgListener.onInitApkgInfo(1, paramApkgInfo, null);
  }
  
  public void getApkgInfoByConfig(MiniAppInfo paramMiniAppInfo, OnInitApkgListener paramOnInitApkgListener)
  {
    getApkgInfoByConfig(paramMiniAppInfo, true, paramOnInitApkgListener);
  }
  
  public void getApkgInfoByConfig(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, OnInitApkgListener paramOnInitApkgListener)
  {
    long l = System.currentTimeMillis();
    MiniReportManager.reportEventType(paramMiniAppInfo, 12, null, null, null, 0);
    getApkgInfoByConfig(paramMiniAppInfo, paramBoolean, new ApkgManager.1(this, paramOnInitApkgListener, l, paramMiniAppInfo));
  }
  
  public static abstract interface OnGetApkgInfoListener
  {
    public abstract void onGetApkgInfo(ApkgInfo paramApkgInfo, int paramInt, String paramString);
  }
  
  public static abstract interface OnInitApkgListener
  {
    public static final int RES_DOWNLOAD_CANCEL = 4;
    public static final int RES_DOWNLOAD_FAIL = 2;
    public static final int RES_FAIL = 1;
    public static final int RES_SUCC = 0;
    public static final int RES_UNPACK_FAIL = 3;
    
    public abstract void onInitApkgInfo(int paramInt, ApkgInfo paramApkgInfo, String paramString);
  }
  
  public static class RootPath
  {
    private static String PATH_APKG_TISSUE_ROOT = null;
    private static String PATH_GAMEPKG_ROOT = null;
    private static String PATH_WXAPKG_ROOT = null;
    
    public static String getAppPkgRoot()
    {
      if (PATH_WXAPKG_ROOT == null) {
        PATH_WXAPKG_ROOT = getRoot() + "/mini/";
      }
      return PATH_WXAPKG_ROOT;
    }
    
    public static String getGamePkgRoot()
    {
      if (PATH_GAMEPKG_ROOT == null) {
        PATH_GAMEPKG_ROOT = getRoot() + "/minigame/";
      }
      return PATH_GAMEPKG_ROOT;
    }
    
    public static String getRoot()
    {
      return AppLoaderFactory.g().getMiniAppEnv().getContext().getFilesDir().getPath();
    }
    
    public static String getTissuePkgRoot()
    {
      if (PATH_APKG_TISSUE_ROOT == null) {
        PATH_APKG_TISSUE_ROOT = getRoot() + "/mini_tissue/";
      }
      return PATH_APKG_TISSUE_ROOT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.ApkgManager
 * JD-Core Version:    0.7.0.1
 */