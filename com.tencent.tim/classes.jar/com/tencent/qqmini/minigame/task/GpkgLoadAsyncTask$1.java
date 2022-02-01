package com.tencent.qqmini.minigame.task;

import android.text.TextUtils;
import com.tencent.qqmini.minigame.gpkg.GpkgManager.Info;
import com.tencent.qqmini.minigame.gpkg.GpkgManager.OnInitGpkgListener;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.ui.LoadingStatus.Builder;
import com.tencent.qqmini.sdk.launcher.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Locale;

class GpkgLoadAsyncTask$1
  implements GpkgManager.OnInitGpkgListener
{
  private float lastProgress = 0.0F;
  
  GpkgLoadAsyncTask$1(GpkgLoadAsyncTask paramGpkgLoadAsyncTask, long paramLong) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    String str = "";
    if (paramFloat - this.lastProgress > 0.1F)
    {
      this.lastProgress = paramFloat;
      str = String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf(100.0F * paramFloat) }) + "%";
      QMLog.i("GpkgLoadAsyncTask", "[Gpkg]" + paramMiniAppInfo.appId + "(" + paramMiniAppInfo.name + "), progress " + str + ", size=" + paramLong);
    }
    if (!TextUtils.isEmpty(str))
    {
      paramMiniAppInfo = new LoadingStatus.Builder().setProgress(paramFloat).build();
      this.this$0.getRuntimeLoader().notifyRuntimeEvent(2001, new Object[] { paramMiniAppInfo });
    }
  }
  
  public void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString, GpkgManager.Info paramInfo)
  {
    GpkgLoadAsyncTask.access$002(this.this$0, paramInfo);
    QMLog.i("GpkgLoadAsyncTask", "[Gpkg] getGpkgInfoByConfig end, resCode=" + paramInt + ", msg=" + paramString + " ,timecost=" + (System.currentTimeMillis() - this.val$startTime));
    if ((paramInt == 0) && (paramMiniGamePkg != null))
    {
      QMLog.i("GpkgLoadAsyncTask", "[Gpkg] getGpkgInfoByConfig appid=" + paramMiniGamePkg.appId + ", appName=" + paramMiniGamePkg.apkgName + " success");
      GpkgLoadAsyncTask.access$102(this.this$0, paramMiniGamePkg);
      GpkgLoadAsyncTask.access$202(this.this$0, null);
      this.this$0.onTaskSucceed();
      return;
    }
    paramInfo = new StringBuilder().append("[Gpkg] getGpkgInfoByConfig appid=");
    if (paramMiniGamePkg != null) {}
    for (paramMiniGamePkg = paramMiniGamePkg.appId;; paramMiniGamePkg = "unknown appid")
    {
      QMLog.e("GpkgLoadAsyncTask", paramMiniGamePkg + ", fail " + paramString);
      GpkgLoadAsyncTask.access$102(this.this$0, null);
      GpkgLoadAsyncTask.access$202(this.this$0, null);
      this.this$0.onTaskFailed(paramInt, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.task.GpkgLoadAsyncTask.1
 * JD-Core Version:    0.7.0.1
 */