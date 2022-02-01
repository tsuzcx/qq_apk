package com.tencent.mobileqq.minigame.task;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager.Info;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager.OnInitGpkgListener;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader.GameRuntimeProgressListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class GpkgLoadAsyncTask$1
  implements GpkgManager.OnInitGpkgListener
{
  private float lastProgress;
  
  GpkgLoadAsyncTask$1(GpkgLoadAsyncTask paramGpkgLoadAsyncTask, long paramLong) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    String str = "";
    if (paramFloat - this.lastProgress > 0.1F)
    {
      this.lastProgress = paramFloat;
      str = String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf(100.0F * paramFloat) }) + "%";
      QLog.i(GpkgLoadAsyncTask.access$100(this.this$0), 1, "[Gpkg]" + paramMiniAppInfo.appId + "(" + paramMiniAppInfo.name + "), progress " + str + ", size=" + paramLong + ",listener=" + GpkgLoadAsyncTask.access$400(this.this$0));
    }
    if ((!TextUtils.isEmpty(str)) && (GpkgLoadAsyncTask.access$400(this.this$0) != null)) {
      GpkgLoadAsyncTask.access$400(this.this$0).onTaskProgress(this.this$0, paramFloat, "");
    }
  }
  
  public void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString, GpkgManager.Info paramInfo)
  {
    GpkgLoadAsyncTask.access$002(this.this$0, paramInfo);
    QLog.i(GpkgLoadAsyncTask.access$100(this.this$0), 1, "[Gpkg] getGpkgInfoByConfig end, resCode=" + paramInt + ", msg=" + paramString + " ,timecost=" + (System.currentTimeMillis() - this.val$startTime));
    if ((paramInt == 0) && (paramMiniGamePkg != null))
    {
      MiniAppFileManager.getInstance().initFileManager(paramMiniGamePkg, true);
      ThreadManagerV2.excute(new GpkgLoadAsyncTask.1.1(this), 16, null, true);
      QLog.i(GpkgLoadAsyncTask.access$100(this.this$0), 1, "[Gpkg] getGpkgInfoByConfig appid=" + paramMiniGamePkg.appId + ", appName=" + paramMiniGamePkg.apkgName + " success");
      GpkgLoadAsyncTask.access$202(this.this$0, paramMiniGamePkg);
      GpkgLoadAsyncTask.access$302(this.this$0, null);
      if (GpkgLoadAsyncTask.access$400(this.this$0) != null) {
        GpkgLoadAsyncTask.access$400(this.this$0).onTaskProgress(this.this$0, 1.0F, "");
      }
      this.this$0.onTaskSucceed();
      return;
    }
    paramInfo = GpkgLoadAsyncTask.access$100(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder().append("[Gpkg] getGpkgInfoByConfig appid=");
    if (paramMiniGamePkg != null) {}
    for (paramMiniGamePkg = paramMiniGamePkg.appId;; paramMiniGamePkg = "unknown appid")
    {
      QLog.e(paramInfo, 1, paramMiniGamePkg + ", fail " + paramString);
      GpkgLoadAsyncTask.access$202(this.this$0, null);
      GpkgLoadAsyncTask.access$302(this.this$0, null);
      this.this$0.onTaskFailed(paramInt, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.GpkgLoadAsyncTask.1
 * JD-Core Version:    0.7.0.1
 */