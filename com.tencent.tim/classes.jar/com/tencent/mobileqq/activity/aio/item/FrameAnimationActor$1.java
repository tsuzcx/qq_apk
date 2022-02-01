package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import xbt;
import xbt.a;

public class FrameAnimationActor$1
  implements Runnable
{
  public void run()
  {
    if (this.this$0.mView == null) {}
    do
    {
      return;
      if ((this.this$0.mCurrentFrameIndex == 0) && (this.this$0.a != null)) {
        this.this$0.a.onStart();
      }
      if (this.this$0.mCurrentFrameIndex < this.this$0.hs.length) {
        break;
      }
      this.this$0.mView.setBackgroundResource(this.this$0.hs[this.this$0.bSX]);
    } while (this.this$0.a == null);
    this.this$0.a.onEnd();
    return;
    this.this$0.mView.setBackgroundResource(this.this$0.hs[this.this$0.mCurrentFrameIndex]);
    if (this.this$0.a != null) {
      this.this$0.a.Dd(this.this$0.mCurrentFrameIndex);
    }
    this.this$0.mView.postDelayed(xbt.a(this.this$0), this.this$0.mInterval);
    xbt localxbt = this.this$0;
    localxbt.mCurrentFrameIndex += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FrameAnimationActor.1
 * JD-Core Version:    0.7.0.1
 */