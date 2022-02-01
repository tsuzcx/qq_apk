package com.tencent.mobileqq.werewolves;

import android.os.Handler;

class WereWolvesLoadingView$1
  implements Runnable
{
  WereWolvesLoadingView$1(WereWolvesLoadingView paramWereWolvesLoadingView) {}
  
  public void run()
  {
    if (this.this$0.mProgress >= 100)
    {
      this.this$0.setProgress(100);
      this.this$0.mUIHandler.removeCallbacks(this);
      return;
    }
    WereWolvesLoadingView localWereWolvesLoadingView = this.this$0;
    localWereWolvesLoadingView.mProgress += 3;
    if (this.this$0.mProgress > 100) {
      this.this$0.mProgress = 100;
    }
    this.this$0.setProgress(this.this$0.mProgress);
    this.this$0.mUIHandler.postDelayed(this.this$0.hW, 40L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WereWolvesLoadingView.1
 * JD-Core Version:    0.7.0.1
 */