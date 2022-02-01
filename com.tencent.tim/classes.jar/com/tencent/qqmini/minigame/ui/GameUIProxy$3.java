package com.tencent.qqmini.minigame.ui;

import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager;

class GameUIProxy$3
  implements Runnable
{
  GameUIProxy$3(GameUIProxy paramGameUIProxy, MiniAppInfo paramMiniAppInfo, Activity paramActivity, String paramString, long paramLong) {}
  
  public void run()
  {
    if (GameUIProxy.access$200(this.this$0) != null) {
      GameUIProxy.access$200(this.this$0).setLoadingAdStatus(2);
    }
    MiniLoadingAdManager.getInstance().updateLoadingAdLayoutAndShow(this.val$miniAppInfo, this.val$activity, true, this.val$adJson, this.val$aid, new GameUIProxy.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.GameUIProxy.3
 * JD-Core Version:    0.7.0.1
 */