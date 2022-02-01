package com.tencent.qqmail.view.listscroller;

import android.graphics.Matrix;

class ScrollContacTextView$1
  implements Runnable
{
  ScrollContacTextView$1(ScrollContacTextView paramScrollContacTextView) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    if (this.this$0.mCircleStartTime == 0L)
    {
      this.this$0.mCircleStartTime = l1;
      this.this$0.looperSelf();
      return;
    }
    long l2 = l1 - this.this$0.mCircleStartTime;
    ScrollContacTextView localScrollContacTextView;
    if (l2 > this.this$0.mCircleDuration)
    {
      if ((l1 - this.this$0.mPauseStartTime > this.this$0.mPauseDuration) || ((this.this$0.mCirclrCount & 0x3) < 3))
      {
        this.this$0.mCircleStartTime = l1;
        localScrollContacTextView = this.this$0;
        localScrollContacTextView.mCirclrCount += 1;
      }
      this.this$0.looperSelf();
      return;
    }
    this.this$0.mPauseStartTime = l1;
    float f1 = (float)l2 * 4.0F / this.this$0.mCircleDuration;
    float f2;
    if (f1 < 1.0001D)
    {
      localScrollContacTextView = this.this$0;
      f2 = this.this$0.mCenterDegree;
      localScrollContacTextView.mCurDegree = (f1 * (this.this$0.mEndDegree - this.this$0.mCenterDegree) + f2);
    }
    for (;;)
    {
      this.this$0.mMatrix.setRotate(this.this$0.mCurDegree, this.this$0.mDrawLeftHalfWidth, this.this$0.mDrawLeftHalfHeight);
      this.this$0.looperSelf();
      this.this$0.invalidate();
      return;
      if (f1 < 2.001F)
      {
        localScrollContacTextView = this.this$0;
        f2 = this.this$0.mCenterDegree;
        localScrollContacTextView.mCurDegree = ((2.0F - f1) * (this.this$0.mEndDegree - this.this$0.mCenterDegree) + f2);
      }
      else if (f1 < 3.001F)
      {
        localScrollContacTextView = this.this$0;
        f2 = this.this$0.mCenterDegree;
        localScrollContacTextView.mCurDegree = ((f1 - 2.0F) * (this.this$0.mStartDegree - this.this$0.mCenterDegree) + f2);
      }
      else
      {
        localScrollContacTextView = this.this$0;
        f2 = this.this$0.mCenterDegree;
        localScrollContacTextView.mCurDegree = ((4.0F - f1) * (this.this$0.mStartDegree - this.this$0.mCenterDegree) + f2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.listscroller.ScrollContacTextView.1
 * JD-Core Version:    0.7.0.1
 */