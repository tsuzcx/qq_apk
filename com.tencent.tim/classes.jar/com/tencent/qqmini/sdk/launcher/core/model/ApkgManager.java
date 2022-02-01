package com.tencent.qqmini.sdk.launcher.core.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import java.io.File;

public class ApkgManager
{
  private static final String TAG = "ApkgManager";
  private static volatile ApkgManager sInstance;
  
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
      return RootPath.access$000();
    }
    if (paramMiniAppInfo.launchParam.isFlutterMode) {
      return RootPath.access$100();
    }
    return RootPath.access$200();
  }
  
  public static class RootPath
  {
    private static String PATH_APKG_TISSUE_ROOT = null;
    private static String PATH_GAMEPKG_ROOT = null;
    private static String PATH_WXAPKG_ROOT = null;
    
    private static String getAppPkgRoot()
    {
      if (PATH_WXAPKG_ROOT == null) {
        PATH_WXAPKG_ROOT = getRoot() + "/mini/";
      }
      return PATH_WXAPKG_ROOT;
    }
    
    private static String getGamePkgRoot()
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
    
    private static String getTissuePkgRoot()
    {
      if (PATH_APKG_TISSUE_ROOT == null) {
        PATH_APKG_TISSUE_ROOT = getRoot() + "/mini_tissue/";
      }
      return PATH_APKG_TISSUE_ROOT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.model.ApkgManager
 * JD-Core Version:    0.7.0.1
 */