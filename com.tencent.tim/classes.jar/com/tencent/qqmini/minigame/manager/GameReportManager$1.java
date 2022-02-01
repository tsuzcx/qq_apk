package com.tencent.qqmini.minigame.manager;

import android.os.Bundle;
import com.tencent.qqmini.minigame.GameRuntimeLoader;

class GameReportManager$1
  implements Runnable
{
  GameReportManager$1(GameReportManager paramGameReportManager) {}
  
  public void run()
  {
    if (!GameReportManager.access$000(this.this$0)) {
      new Bundle().putParcelable("app_config", GameReportManager.access$100(this.this$0).getMiniAppInfo());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.GameReportManager.1
 * JD-Core Version:    0.7.0.1
 */