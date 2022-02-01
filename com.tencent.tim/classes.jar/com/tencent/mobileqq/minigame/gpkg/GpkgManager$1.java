package com.tencent.mobileqq.minigame.gpkg;

import android.os.SystemClock;
import com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

final class GpkgManager$1
  implements GpkgManager.OnInitGpkgListener
{
  GpkgManager$1(long paramLong, MiniAppConfig paramMiniAppConfig, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadGpkgProgress(paramMiniAppInfo, paramFloat, paramLong);
    }
  }
  
  public void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString, GpkgManager.Info paramInfo)
  {
    GpkgManager.Info localInfo = paramInfo;
    if (paramInfo == null) {
      localInfo = new GpkgManager.Info();
    }
    if (localInfo.timeCostMs == 0L) {
      localInfo.timeCostMs = (SystemClock.uptimeMillis() - this.val$startTime);
    }
    ApkgMainProcessManager.removeSubProcessLoadTask(this.val$gameConfig);
    if (this.val$listener != null) {
      this.val$listener.onInitGpkgInfo(paramInt, paramMiniGamePkg, paramString, localInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.gpkg.GpkgManager.1
 * JD-Core Version:    0.7.0.1
 */