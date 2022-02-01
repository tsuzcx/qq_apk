package com.tencent.mobileqq.mini.tissue;

import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.minigame.manager.EngineManager;
import com.tencent.mobileqq.minigame.manager.InstalledEngine;
import com.tencent.qqmini.sdk.core.tissue.TissueEnv;
import com.tencent.qqmini.sdk.core.tissue.TissueGlobal;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import cooperation.qzone.util.QZLog;
import java.util.List;

public class TissueEnvImpl
  implements TissueEnv
{
  private static boolean sCheckLibUpdate;
  
  public static String getNativeLibDirInSubProgress()
  {
    ICommonManager localICommonManager = AppLoaderFactory.g().getCommonManager();
    if (localICommonManager == null) {
      return null;
    }
    return localICommonManager.getTissueSoPath();
  }
  
  public static boolean verifyTissueEngine(String paramString)
  {
    ICommonManager localICommonManager = AppLoaderFactory.g().getCommonManager();
    if (localICommonManager == null) {
      return false;
    }
    return localICommonManager.verifyTissueEngine(paramString);
  }
  
  public String getNativeLibDir()
  {
    if (!sCheckLibUpdate)
    {
      localObject = TissueWnsConfig.getBaseLibInfo();
      if (localObject != null) {
        EngineManager.g().installBaseLib((BaseLibInfo)localObject, null);
      }
      sCheckLibUpdate = true;
    }
    Object localObject = EngineManager.g().getEngineList(99);
    if (localObject != null)
    {
      int i = ((List)localObject).size();
      QZLog.i("Tissue", " getInstalledEngineList success " + i);
      if (i > 0)
      {
        localObject = (InstalledEngine)((List)localObject).get(0);
        QZLog.i("Tissue", "verify engine " + localObject);
        if (TissueGlobal.verifyTissueEngine(((InstalledEngine)localObject).engineDir)) {
          return ((InstalledEngine)localObject).engineDir;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tissue.TissueEnvImpl
 * JD-Core Version:    0.7.0.1
 */