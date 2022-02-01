package com.tencent.qqmini.minigame.ui;

import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class GameRuntimeStateObserver$5
  implements Runnable
{
  GameRuntimeStateObserver$5(GameRuntimeStateObserver paramGameRuntimeStateObserver) {}
  
  public void run()
  {
    if (GameRuntimeStateObserver.access$300(this.this$0) != null) {
      GameRuntimeStateObserver.access$300(this.this$0).hide();
    }
    if ((GameRuntimeStateObserver.access$400(this.this$0) != null) && (GameRuntimeStateObserver.access$400(this.this$0).launchParam != null)) {
      MiniGameAdBannerPopup.checkShouldShow(GameRuntimeStateObserver.access$200(this.this$0), GameRuntimeStateObserver.access$400(this.this$0).appId, GameRuntimeStateObserver.access$400(this.this$0).launchParam.scene);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.GameRuntimeStateObserver.5
 * JD-Core Version:    0.7.0.1
 */