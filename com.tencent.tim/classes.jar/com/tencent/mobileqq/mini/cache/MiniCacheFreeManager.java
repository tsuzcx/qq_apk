package com.tencent.mobileqq.mini.cache;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import aqhq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.MiniAppSubProcessorInfo;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MiniCacheFreeManager
{
  private static final String TAG = "MiniCacheFreeManager";
  
  private static void clearAllFileCaches()
  {
    MiniAppFileManager.getInstance().clearAllCache();
  }
  
  private static void clearAllPkgs()
  {
    aqhq.delete(ApkgManager.PATH_GAMEPKG_ROOT, false);
    aqhq.delete(ApkgManager.PATH_WXAPKG_ROOT, false);
    aqhq.delete(ApkgManager.PATH_APKG_TISSUE_ROOT, false);
  }
  
  private static void clearAllStorageCache()
  {
    try
    {
      aqhq.delete(BaseApplication.getContext().getCacheDir() + "/mini", false);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniCacheFreeManager", 1, "clearAllStorageCache failed", localException);
    }
  }
  
  private static void clearAuthSp(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    while (!BaseApplicationImpl.getApplication().getSharedPreferences(paramMiniAppInfo.appId + "_" + paramString, 4).edit().clear().commit()) {
      return;
    }
    QLog.i("MiniCacheFreeManager", 1, "clearAuthSp finish. " + paramMiniAppInfo.appId);
  }
  
  private static void clearAuthSp(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)) && (BaseApplicationImpl.getApplication().getSharedPreferences(paramString2 + "_" + paramString1, 4).edit().clear().commit())) {
      QLog.i("MiniCacheFreeManager", 1, "clearAuthSp finish. " + paramString2);
    }
  }
  
  private static void clearDebugSp()
  {
    StorageUtil.getPreference().edit().clear().commit();
  }
  
  private static void clearDebugSp(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    while (!StorageUtil.getPreference().edit().putBoolean(paramMiniAppInfo.appId + "_debug", false).commit()) {
      return;
    }
    QLog.i("MiniCacheFreeManager", 1, "clearDebugSp finish. " + paramMiniAppInfo.appId);
  }
  
  private static void clearDebugSp(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (StorageUtil.getPreference().edit().putBoolean(paramString + "_debug", false).commit())) {
      QLog.i("MiniCacheFreeManager", 1, "clearDebugSp finish. " + paramString);
    }
  }
  
  private static void clearFileCache(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {
      return;
    }
    MiniAppFileManager.getInstance().clearFileCache(paramMiniAppInfo.appId);
    QLog.i("MiniCacheFreeManager", 1, "clearFileCache finish. " + paramMiniAppInfo.appId);
  }
  
  private static void clearFileCache(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      MiniAppFileManager.getInstance().clearFileCache(paramString);
      QLog.i("MiniCacheFreeManager", 1, "clearFileCache finish. " + paramString);
    }
  }
  
  private static void clearPkg(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    String str;
    do
    {
      return;
      str = ApkgManager.getApkgFolderPath(paramMiniAppInfo);
    } while (!new File(str).exists());
    aqhq.delete(str, false);
    QLog.i("MiniCacheFreeManager", 1, "clearPkg finish: " + paramMiniAppInfo.appId);
  }
  
  private static void clearPkg(String paramString)
  {
    String str = ApkgManager.PATH_GAMEPKG_ROOT;
    Object localObject1 = MD5.toMD5(paramString);
    Object localObject2 = new File(str);
    int j;
    int i;
    if (((File)localObject2).isDirectory())
    {
      localObject2 = ((File)localObject2).list();
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = localObject2[i];
        if ((!TextUtils.isEmpty(localCharSequence)) && (localCharSequence.startsWith((String)localObject1)))
        {
          QLog.d("MiniCacheFreeManager", 1, "clearPkg delete pkg : " + localCharSequence);
          FileUtils.delete(str + localCharSequence, false);
        }
        i += 1;
      }
    }
    str = ApkgManager.PATH_WXAPKG_ROOT;
    paramString = MD5.toMD5(paramString);
    localObject1 = new File(str);
    if (((File)localObject1).isDirectory())
    {
      localObject1 = ((File)localObject1).list();
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).startsWith(paramString)))
        {
          QLog.d("MiniCacheFreeManager", 1, "clearPkg delete pkg : " + (String)localObject2);
          FileUtils.delete(str + (String)localObject2, false);
        }
        i += 1;
      }
    }
  }
  
  private static void clearStorageCache(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {}
    do
    {
      return;
      paramString = Storage.open(BaseApplicationImpl.getApplication().getBaseContext(), paramString, paramMiniAppInfo.appId);
    } while (paramString == null);
    paramString.clearStorage();
    QLog.i("MiniCacheFreeManager", 1, "clearStorageCache finish. " + paramMiniAppInfo.appId);
  }
  
  private static void clearStorageCache(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      paramString1 = Storage.open(BaseApplicationImpl.getApplication().getBaseContext(), paramString1, paramString2);
      if (paramString1 != null)
      {
        paramString1.clearStorage();
        QLog.i("MiniCacheFreeManager", 1, "clearStorageCache finish. " + paramString2);
      }
    }
  }
  
  public static void freeCache(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    freeCache(paramString, paramMiniAppInfo, true);
  }
  
  public static void freeCache(String paramString, MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    freeCache(paramString, paramMiniAppInfo, paramBoolean, null);
  }
  
  public static void freeCache(String paramString, MiniAppInfo paramMiniAppInfo, boolean paramBoolean, ThreadExcutor.IThreadListener paramIThreadListener)
  {
    ThreadManagerV2.excute(new MiniCacheFreeManager.2(paramMiniAppInfo, paramString, paramBoolean), 16, paramIThreadListener, true);
  }
  
  public static void freeCache(String paramString1, String paramString2, boolean paramBoolean, ThreadExcutor.IThreadListener paramIThreadListener)
  {
    ThreadManagerV2.excute(new MiniCacheFreeManager.3(paramString2, paramString1, paramBoolean), 16, paramIThreadListener, true);
  }
  
  public static void freeCache(boolean paramBoolean, ThreadExcutor.IThreadListener paramIThreadListener)
  {
    ThreadManagerV2.excute(new MiniCacheFreeManager.4(), 16, paramIThreadListener, true);
  }
  
  public static void freeCacheDialog(Activity paramActivity, String paramString1, MiniAppInfo paramMiniAppInfo, String paramString2)
  {
    AppBrandTask.runTaskOnUiThread(new MiniCacheFreeManager.1(paramActivity, paramString2, paramString1, paramMiniAppInfo));
  }
  
  private static void killSelf(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    AppBrandLaunchManager.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo;
    do
    {
      return;
      localMiniAppSubProcessorInfo = AppBrandLaunchManager.g().getCacheApp(paramMiniAppInfo);
    } while (localMiniAppSubProcessorInfo == null);
    AppBrandLaunchManager.g().forceKillProcess(localMiniAppSubProcessorInfo);
    QLog.i("MiniCacheFreeManager", 1, "kill process. " + paramMiniAppInfo.appId + "; " + localMiniAppSubProcessorInfo.processName);
  }
  
  private static void killSelf(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      AppBrandLaunchManager.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = AppBrandLaunchManager.g().getCacheApp(paramString);
      if (localMiniAppSubProcessorInfo != null)
      {
        AppBrandLaunchManager.g().forceKillProcess(localMiniAppSubProcessorInfo);
        QLog.i("MiniCacheFreeManager", 1, "kill process. " + paramString + "; " + localMiniAppSubProcessorInfo.processName);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.MiniCacheFreeManager
 * JD-Core Version:    0.7.0.1
 */