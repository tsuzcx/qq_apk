package com.tencent.mobileqq.minigame.ui;

import acfp;
import android.widget.Toast;

class GameActivity$10
  implements Runnable
{
  GameActivity$10(GameActivity paramGameActivity, int paramInt) {}
  
  public void run()
  {
    if (this.val$retCode == 104)
    {
      GameActivity.access$1600(this.this$0);
      return;
    }
    Toast.makeText(this.this$0, acfp.m(2131706704) + this.val$retCode + ")", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.10
 * JD-Core Version:    0.7.0.1
 */