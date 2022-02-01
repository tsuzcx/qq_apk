package com.tencent.av.utils;

import android.os.Handler;
import jkr;
import jks;

public class QQFrameByFrameAnimation$1
  implements Runnable
{
  public QQFrameByFrameAnimation$1(jks paramjks) {}
  
  public void run()
  {
    if ((this.this$0.aAE > 0) && (this.this$0.mFrames >= this.this$0.aAE)) {
      this.this$0.stop();
    }
    do
    {
      do
      {
        return;
        if ((this.this$0.mRepeatCount > 0) && (this.this$0.mFrames / this.this$0.cU.length >= this.this$0.mRepeatCount))
        {
          this.this$0.stop();
          return;
        }
        this.this$0.axv();
        this.this$0.mHandler.postDelayed(this, this.this$0.mDuration);
      } while (this.this$0.b == null);
      this.this$0.b.avc();
    } while ((this.this$0.cU.length <= 0) || (this.this$0.mFrames % this.this$0.cU.length != 0));
    this.this$0.b.avb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.utils.QQFrameByFrameAnimation.1
 * JD-Core Version:    0.7.0.1
 */