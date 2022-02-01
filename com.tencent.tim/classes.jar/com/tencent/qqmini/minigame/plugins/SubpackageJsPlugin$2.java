package com.tencent.qqmini.minigame.plugins;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.gpkg.GpkgManager.Info;
import com.tencent.qqmini.minigame.gpkg.GpkgManager.OnInitGpkgListener;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class SubpackageJsPlugin$2
  implements GpkgManager.OnInitGpkgListener
{
  private float lastProgress = 0.0F;
  
  SubpackageJsPlugin$2(SubpackageJsPlugin paramSubpackageJsPlugin, String paramString, RequestEvent paramRequestEvent, int paramInt1, MiniGamePkg paramMiniGamePkg, int paramInt2) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    if (paramFloat - this.lastProgress > 0.01F)
    {
      this.lastProgress = paramFloat;
      paramMiniAppInfo = null;
      if ((SubpackageJsPlugin.access$500(this.this$0) instanceof GameRuntime)) {
        paramMiniAppInfo = ((GameRuntime)SubpackageJsPlugin.access$600(this.this$0)).getGameEngine();
      }
      if (paramMiniAppInfo == null) {
        GameLog.getInstance().e("SubpackageJsPlugin", "loadSubPackage onInitGpkgInfo but ttEngine is null");
      }
    }
    else
    {
      return;
    }
    paramMiniAppInfo.getJsRuntime(1).runOnJsThread(new SubpackageJsPlugin.2.2(this, paramFloat, paramLong));
  }
  
  public void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString, @Nullable GpkgManager.Info paramInfo)
  {
    GameLog.getInstance().i("SubpackageJsPlugin", "loadSubPackage " + this.val$subPackageName + " callback onInitGpkgInfo, resCode:" + paramInt + ", error msg:" + paramString);
    if (paramInt != 0)
    {
      SubpackageJsPlugin.access$100(this.this$0, this.val$req, this.val$loadTaskId, false);
      return;
    }
    if ((SubpackageJsPlugin.access$200(this.this$0) instanceof GameRuntime)) {}
    for (paramString = ((GameRuntime)SubpackageJsPlugin.access$300(this.this$0)).getGameEngine();; paramString = null)
    {
      if (paramString == null)
      {
        GameLog.getInstance().e("SubpackageJsPlugin", "loadSubPackage onInitGpkgInfo but ttEngine is null");
        return;
      }
      paramInfo = paramString.getGameLauncher();
      if (paramMiniGamePkg != null) {}
      for (paramMiniGamePkg = paramMiniGamePkg.getRootPath(this.val$subPackageName);; paramMiniGamePkg = null)
      {
        paramString.getJsRuntime(1).runOnJsThread(new SubpackageJsPlugin.2.1(this, paramInfo, paramMiniGamePkg));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.SubpackageJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */