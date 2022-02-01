package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.minigame.utils.GameActivityStatusWatcher.OnWatcherActionListener;
import com.tencent.qphone.base.util.QLog;

class GameActivity$11
  implements GameActivityStatusWatcher.OnWatcherActionListener
{
  GameActivity$11(GameActivity paramGameActivity) {}
  
  public void onHomePressed()
  {
    QLog.e("[minigame] GameActivity", 1, "home pressed!");
    this.this$0.notifyGameStop();
  }
  
  public void onRecentTaskPressed()
  {
    QLog.e("[minigame] GameActivity", 1, "rencent task to front!");
    this.this$0.notifyGameStop();
  }
  
  public void onScreenOff()
  {
    QLog.e("[minigame] GameActivity", 1, "screen off");
    this.this$0.notifyGameStop();
  }
  
  public void onShowMonitorView(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onReceive action action.qq.miniapp.show.monitorview, ");
    if (paramBoolean) {}
    for (String str = "show";; str = "hide")
    {
      QLog.d("[minigame] GameActivity", 1, str + " monitor view!");
      if (GameActivity.access$1700(this.this$0) != paramBoolean) {
        GameActivity.access$1702(this.this$0, this.this$0.clickMonitorPanel());
      }
      if (GameActivity.access$1800(this.this$0) == null) {
        GameActivity.access$1900(this.this$0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.11
 * JD-Core Version:    0.7.0.1
 */