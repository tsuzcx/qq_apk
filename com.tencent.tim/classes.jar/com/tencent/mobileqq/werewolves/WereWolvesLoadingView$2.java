package com.tencent.mobileqq.werewolves;

import android.os.Handler;

class WereWolvesLoadingView$2
  implements Runnable
{
  WereWolvesLoadingView$2(WereWolvesLoadingView paramWereWolvesLoadingView) {}
  
  public void run()
  {
    if ((this.this$0.mProgress > 90) || (this.this$0.isStop)) {
      return;
    }
    WereWolvesLoadingView localWereWolvesLoadingView1 = this.this$0;
    localWereWolvesLoadingView1.mProgress += 1;
    localWereWolvesLoadingView1 = this.this$0;
    WereWolvesLoadingView localWereWolvesLoadingView2 = this.this$0;
    int i = localWereWolvesLoadingView2.mProgress;
    localWereWolvesLoadingView2.mProgress = (i + 1);
    localWereWolvesLoadingView1.setProgress(i);
    i = (int)(2.222222F * this.this$0.mProgress + 100.0F);
    this.this$0.mUIHandler.postDelayed(this, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WereWolvesLoadingView.2
 * JD-Core Version:    0.7.0.1
 */