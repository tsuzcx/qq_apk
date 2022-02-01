package com.tencent.TMG.opengl.gesturedetectors;

import android.content.Context;
import android.view.MotionEvent;

public class ShoveGestureDetector
  extends TwoFingerGestureDetector
{
  private float mCurrAverageY;
  private final OnShoveGestureListener mListener;
  private float mPrevAverageY;
  private boolean mSloppyGesture;
  
  public ShoveGestureDetector(Context paramContext, OnShoveGestureListener paramOnShoveGestureListener)
  {
    super(paramContext);
    this.mListener = paramOnShoveGestureListener;
  }
  
  public float getShovePixelsDelta()
  {
    return this.mCurrAverageY - this.mPrevAverageY;
  }
  
  protected void handleInProgressEvent(int paramInt, MotionEvent paramMotionEvent)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      updateStateByEvent(paramMotionEvent);
      if (!this.mSloppyGesture) {
        this.mListener.onShoveEnd(this);
      }
      resetState();
      return;
      if (!this.mSloppyGesture) {
        this.mListener.onShoveEnd(this);
      }
      resetState();
      return;
      updateStateByEvent(paramMotionEvent);
    } while ((this.mCurrPressure / this.mPrevPressure <= 0.67F) || (Math.abs(getShovePixelsDelta()) <= 0.5F) || (!this.mListener.onShove(this)));
    this.mPrevEvent.recycle();
    this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
  }
  
  protected void handleStartProgressEvent(int paramInt, MotionEvent paramMotionEvent)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            resetState();
            this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
            this.mTimeDelta = 0L;
            updateStateByEvent(paramMotionEvent);
            this.mSloppyGesture = isSloppyGesture(paramMotionEvent);
          } while (this.mSloppyGesture);
          this.mGestureInProgress = this.mListener.onShoveBegin(this);
          return;
        } while (!this.mSloppyGesture);
        this.mSloppyGesture = isSloppyGesture(paramMotionEvent);
      } while (this.mSloppyGesture);
      this.mGestureInProgress = this.mListener.onShoveBegin(this);
      return;
    } while (this.mSloppyGesture);
  }
  
  protected boolean isSloppyGesture(MotionEvent paramMotionEvent)
  {
    if (super.isSloppyGesture(paramMotionEvent)) {}
    double d;
    do
    {
      return true;
      d = Math.abs(Math.atan2(this.mCurrFingerDiffY, this.mCurrFingerDiffX));
    } while (((0.0D >= d) || (d >= 0.3499999940395355D)) && ((2.789999961853027D >= d) || (d >= 3.141592653589793D)));
    return false;
  }
  
  protected void resetState()
  {
    super.resetState();
    this.mSloppyGesture = false;
    this.mPrevAverageY = 0.0F;
    this.mCurrAverageY = 0.0F;
  }
  
  protected void updateStateByEvent(MotionEvent paramMotionEvent)
  {
    super.updateStateByEvent(paramMotionEvent);
    MotionEvent localMotionEvent = this.mPrevEvent;
    float f = localMotionEvent.getY(0);
    this.mPrevAverageY = ((localMotionEvent.getY(1) + f) / 2.0F);
    this.mCurrAverageY = ((paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
  }
  
  public static abstract interface OnShoveGestureListener
  {
    public abstract boolean onShove(ShoveGestureDetector paramShoveGestureDetector);
    
    public abstract boolean onShoveBegin(ShoveGestureDetector paramShoveGestureDetector);
    
    public abstract void onShoveEnd(ShoveGestureDetector paramShoveGestureDetector);
  }
  
  public static class SimpleOnShoveGestureListener
    implements ShoveGestureDetector.OnShoveGestureListener
  {
    public boolean onShove(ShoveGestureDetector paramShoveGestureDetector)
    {
      return false;
    }
    
    public boolean onShoveBegin(ShoveGestureDetector paramShoveGestureDetector)
    {
      return true;
    }
    
    public void onShoveEnd(ShoveGestureDetector paramShoveGestureDetector) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.opengl.gesturedetectors.ShoveGestureDetector
 * JD-Core Version:    0.7.0.1
 */