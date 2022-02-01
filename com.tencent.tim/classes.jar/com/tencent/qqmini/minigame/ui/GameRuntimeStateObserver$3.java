package com.tencent.qqmini.minigame.ui;

import android.app.Activity;

class GameRuntimeStateObserver$3
  implements Runnable
{
  GameRuntimeStateObserver$3(GameRuntimeStateObserver paramGameRuntimeStateObserver) {}
  
  public void run()
  {
    if (!GameRuntimeStateObserver.access$200(this.this$0).isFinishing()) {
      GameRuntimeStateObserver.access$200(this.this$0).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.GameRuntimeStateObserver.3
 * JD-Core Version:    0.7.0.1
 */