package com.tencent.mobileqq.minigame.ui;

import aeaz.b;
import android.os.Bundle;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin.AddColorSignListener;
import com.tencent.qphone.base.util.QLog;

class GameActivity$26
  extends aeaz.b
{
  GameActivity$26(GameActivity paramGameActivity) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    QLog.e("[minigame] GameActivity", 1, "[ColorNote exist]");
    if (GameActivity.access$3800(this.this$0) != null)
    {
      GameActivity.access$3800(this.this$0).onAddColorSign(paramBoolean);
      GameActivity.access$3802(this.this$0, null);
    }
    if (this.this$0.doNotMoveTaskToBackThisTime)
    {
      this.this$0.doNotMoveTaskToBackThisTime = false;
      return;
    }
    this.this$0.doOnBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.26
 * JD-Core Version:    0.7.0.1
 */