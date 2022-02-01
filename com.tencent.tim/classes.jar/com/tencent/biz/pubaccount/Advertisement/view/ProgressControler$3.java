package com.tencent.biz.pubaccount.Advertisement.view;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;
import jxs;

public class ProgressControler$3
  extends TimerTask
{
  public ProgressControler$3(jxs paramjxs) {}
  
  public void run()
  {
    jxs localjxs = this.this$0;
    localjxs.mCurrentTime += 50L;
    if (this.this$0.mCurrentTime >= this.this$0.mEndTime)
    {
      this.this$0.mCurrentTime = this.this$0.mEndTime;
      if (this.this$0.mTimer != null) {
        this.this$0.mTimer.cancel();
      }
    }
    this.this$0.mUIHandler.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.ProgressControler.3
 * JD-Core Version:    0.7.0.1
 */