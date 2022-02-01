package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;
import qfm;

public class NewProgressControler$3
  extends TimerTask
{
  public NewProgressControler$3(qfm paramqfm) {}
  
  public void run()
  {
    qfm localqfm = this.this$0;
    localqfm.mCurrentTime += 50L;
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
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.NewProgressControler.3
 * JD-Core Version:    0.7.0.1
 */