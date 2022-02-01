package com.tencent.mobileqq.mini.apkg;

import aagd;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ApkgConfigHolder
  implements Serializable
{
  private static final String CONFIG_NAME = ".ApkgConfigs";
  private static final String TAG = "ApkgConfigHolder";
  private static final long serialVersionUID = 1L;
  private Map<String, ApkgConfigWrapper> mApkgConfigs = new HashMap();
  private Map<String, ApkgConfigWrapper> mDebugApkgConfigs = new HashMap();
  private transient byte[] mSaveLock;
  private transient String mSavePath;
  
  private static String getConfigPath(AppRuntime paramAppRuntime)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramAppRuntime.getApplication().getFilesDir().getPath());
    localStringBuilder.append("/mini/").append(paramAppRuntime.getAccount()).append("/");
    localStringBuilder.append(".ApkgConfigs");
    return localStringBuilder.toString();
  }
  
  public static ApkgConfigHolder readConfig(QQAppInterface paramQQAppInterface)
  {
    String str = getConfigPath(paramQQAppInterface);
    try
    {
      paramQQAppInterface = (ApkgConfigHolder)aagd.o(str);
      Object localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        localObject = new ApkgConfigHolder();
      }
      ((ApkgConfigHolder)localObject).mSavePath = str;
      ((ApkgConfigHolder)localObject).mSaveLock = new byte[0];
      if (((ApkgConfigHolder)localObject).mDebugApkgConfigs == null) {
        ((ApkgConfigHolder)localObject).mDebugApkgConfigs = new HashMap();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApkgConfigHolder", 2, "readApkgConfigHolder:" + localObject);
      }
      return localObject;
    }
    catch (Throwable paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
        paramQQAppInterface = null;
      }
    }
  }
  
  public static void removeRes(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      PreloadManager.e(paramMiniAppInfo.downloadUrl, false, 0);
      FileUtils.delete(ApkgManager.getApkgFolderPath(paramMiniAppInfo), false);
    }
  }
  
  public MiniAppInfo getConfig(String paramString)
  {
    paramString = (ApkgConfigWrapper)this.mApkgConfigs.get(paramString);
    if (paramString != null) {
      return paramString.apkgConfig;
    }
    return null;
  }
  
  public void saveConfig()
  {
    ThreadManager.getFileThreadHandler().post(new ApkgConfigHolder.1(this));
  }
  
  public void updateConfig(List<MiniAppInfo> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MiniAppInfo localMiniAppInfo = (MiniAppInfo)localIterator.next();
        if ((localMiniAppInfo != null) && (!TextUtils.isEmpty(localMiniAppInfo.appId))) {
          if (localMiniAppInfo.verType == 3)
          {
            paramList = (ApkgConfigWrapper)this.mDebugApkgConfigs.get(localMiniAppInfo.appId);
            this.mDebugApkgConfigs.put(localMiniAppInfo.appId, new ApkgConfigWrapper(localMiniAppInfo));
          }
          else
          {
            ApkgConfigWrapper localApkgConfigWrapper = (ApkgConfigWrapper)this.mApkgConfigs.get(localMiniAppInfo.appId);
            paramList = localApkgConfigWrapper;
            if (localApkgConfigWrapper == null)
            {
              paramList = new ApkgConfigWrapper();
              this.mApkgConfigs.put(localMiniAppInfo.appId, new ApkgConfigWrapper(localMiniAppInfo));
            }
            paramList.updateConfig(localMiniAppInfo);
          }
        }
      }
      saveConfig();
    }
  }
  
  public static class ApkgConfigWrapper
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public MiniAppInfo apkgConfig;
    public List<MiniAppInfo> oldConfigs;
    
    public ApkgConfigWrapper() {}
    
    public ApkgConfigWrapper(MiniAppInfo paramMiniAppInfo)
    {
      this.apkgConfig = paramMiniAppInfo;
    }
    
    public void updateConfig(MiniAppInfo paramMiniAppInfo)
    {
      MiniAppInfo localMiniAppInfo = this.apkgConfig;
      this.apkgConfig = paramMiniAppInfo;
      if ((localMiniAppInfo != null) && (localMiniAppInfo.version != paramMiniAppInfo.version))
      {
        if (this.oldConfigs == null) {
          this.oldConfigs = new LinkedList();
        }
        this.oldConfigs.add(paramMiniAppInfo);
        if (this.oldConfigs.size() > 1)
        {
          paramMiniAppInfo = (MiniAppInfo)this.oldConfigs.get(0);
          this.oldConfigs.remove(0);
          ApkgConfigHolder.removeRes(paramMiniAppInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgConfigHolder
 * JD-Core Version:    0.7.0.1
 */