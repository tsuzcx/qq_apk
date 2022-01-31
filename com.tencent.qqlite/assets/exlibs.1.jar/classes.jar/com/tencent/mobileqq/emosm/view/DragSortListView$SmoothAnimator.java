package com.tencent.mobileqq.emosm.view;

import android.os.SystemClock;

class DragSortListView$SmoothAnimator
  implements Runnable
{
  private float mA;
  private float mAlpha;
  private float mB;
  private float mC;
  private boolean mCanceled;
  private float mD;
  private float mDurationF;
  protected long mStartTime;
  
  public DragSortListView$SmoothAnimator(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    this.mAlpha = paramFloat;
    this.mDurationF = paramInt;
    paramFloat = 1.0F / (this.mAlpha * 2.0F * (1.0F - this.mAlpha));
    this.mD = paramFloat;
    this.mA = paramFloat;
    this.mB = (this.mAlpha / ((this.mAlpha - 1.0F) * 2.0F));
    this.mC = (1.0F / (1.0F - this.mAlpha));
  }
  
  public void cancel()
  {
    this.mCanceled = true;
  }
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void onUpdate(float paramFloat1, float paramFloat2) {}
  
  public void run()
  {
    if (this.mCanceled) {
      return;
    }
    float f = (float)(SystemClock.uptimeMillis() - this.mStartTime) / this.mDurationF;
    if (f >= 1.0F)
    {
      onUpdate(1.0F, 1.0F);
      onStop();
      return;
    }
    onUpdate(f, transform(f));
    this.this$0.post(this);
  }
  
  public void start()
  {
    this.mStartTime = SystemClock.uptimeMillis();
    this.mCanceled = false;
    onStart();
    this.this$0.post(this);
  }
  
  public float transform(float paramFloat)
  {
    if (paramFloat < this.mAlpha) {
      return this.mA * paramFloat * paramFloat;
    }
    if (paramFloat < 1.0F - this.mAlpha) {
      return this.mB + this.mC * paramFloat;
    }
    return 1.0F - this.mD * (paramFloat - 1.0F) * (paramFloat - 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.SmoothAnimator
 * JD-Core Version:    0.7.0.1
 */