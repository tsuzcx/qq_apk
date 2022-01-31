package com.nineoldandroids.animation;

public class TimeAnimator
  extends ValueAnimator
{
  private TimeListener mListener;
  private long mPreviousTime = -1L;
  
  void animateValue(float paramFloat) {}
  
  boolean animationFrame(long paramLong)
  {
    long l1 = 0L;
    long l2;
    if (this.mPlayingState == 0)
    {
      this.mPlayingState = 1;
      if (this.mSeekTime < 0L) {
        this.mStartTime = paramLong;
      }
    }
    else if (this.mListener != null)
    {
      l2 = this.mStartTime;
      if (this.mPreviousTime >= 0L) {
        break label92;
      }
    }
    for (;;)
    {
      this.mPreviousTime = paramLong;
      this.mListener.onTimeUpdate(this, paramLong - l2, l1);
      return false;
      this.mStartTime = (paramLong - this.mSeekTime);
      this.mSeekTime = -1L;
      break;
      label92:
      l1 = paramLong - this.mPreviousTime;
    }
  }
  
  void initAnimation() {}
  
  public void setTimeListener(TimeListener paramTimeListener)
  {
    this.mListener = paramTimeListener;
  }
  
  public static abstract interface TimeListener
  {
    public abstract void onTimeUpdate(TimeAnimator paramTimeAnimator, long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.nineoldandroids.animation.TimeAnimator
 * JD-Core Version:    0.7.0.1
 */