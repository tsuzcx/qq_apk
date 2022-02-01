package com.tencent.qqmail.scroller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;

public class RowScroller
  extends MScroller
{
  public static final float DEFAULT_ACC = 1.5F;
  private float mAccFactor = 1.5F;
  protected int mContentUnitSize = 1;
  protected int mCurrentScreen;
  protected int mDecelerateDuration = 500;
  protected int mDstScreen;
  protected int mFlingVelocity;
  protected int mFlingVelocityX;
  protected int mFlingVelocityY;
  protected Interpolator mInterpolator;
  protected Interpolator mInterpolatorBak;
  protected boolean mIsOvershooting;
  protected int mLastTouchP;
  protected int mLastTouchX;
  protected int mLastTouchY;
  protected RowScrollerListener mListener;
  protected int mMaxOverShootPercent = 49;
  protected int mOldScroll;
  protected int mOverShootPercent;
  protected float mPaddingFactor = 0.5F;
  protected int mScrollingDuration = 1000;
  protected int mTouchDownP;
  protected int mTouchDownScrollP;
  protected int mTouchDownX;
  protected int mTouchDownY;
  boolean mUseEffectorMaxOvershootPercent = true;
  protected FastVelocityTracker mVelocityTracker;
  
  static
  {
    if (!RowScroller.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RowScroller(Context paramContext, RowScrollerListener paramRowScrollerListener)
  {
    this(paramContext, paramRowScrollerListener, null);
  }
  
  public RowScroller(Context paramContext, RowScrollerListener paramRowScrollerListener, FastVelocityTracker paramFastVelocityTracker)
  {
    super(paramContext);
    assert (paramRowScrollerListener != null);
    this.mInterpolatorBak = MScroller.DEFAULT_INTERPOLATOR;
    this.mInterpolator = this.mInterpolatorBak;
    this.mListener = paramRowScrollerListener;
    if (paramFastVelocityTracker != null) {}
    for (;;)
    {
      this.mVelocityTracker = paramFastVelocityTracker;
      return;
      paramFastVelocityTracker = new FastVelocityTracker();
    }
  }
  
  private static float solveOvershootInterpolatorTension(int paramInt)
  {
    float[] arrayOfFloat = new float[11];
    float[] tmp6_5 = arrayOfFloat;
    tmp6_5[0] = 0.0F;
    float[] tmp10_6 = tmp6_5;
    tmp10_6[1] = 1.165295F;
    float[] tmp15_10 = tmp10_6;
    tmp15_10[2] = 1.70154F;
    float[] tmp20_15 = tmp15_10;
    tmp20_15[3] = 2.164294F;
    float[] tmp25_20 = tmp20_15;
    tmp25_20[4] = 2.592389F;
    float[] tmp30_25 = tmp25_20;
    tmp30_25[5] = 3.0F;
    float[] tmp35_30 = tmp30_25;
    tmp35_30[6] = 3.394052F;
    float[] tmp41_35 = tmp35_30;
    tmp41_35[7] = 3.77848F;
    float[] tmp47_41 = tmp41_35;
    tmp47_41[8] = 4.155745F;
    float[] tmp53_47 = tmp47_41;
    tmp53_47[9] = 4.527488F;
    float[] tmp59_53 = tmp53_47;
    tmp59_53[10] = 4.894859F;
    tmp59_53;
    paramInt = Math.max(0, Math.min(paramInt, 49));
    int i = paramInt / 5;
    float f = arrayOfFloat[i];
    return (arrayOfFloat[(i + 1)] - arrayOfFloat[i]) * (paramInt / 5.0F - i) + f;
  }
  
  public void abortAnimation()
  {
    if (this.mState == 1)
    {
      super.abortAnimation();
      onComputeFlingOffset(1.0F);
    }
  }
  
  protected int computeFlingDuration(int paramInt1, int paramInt2)
  {
    return (int)Math.abs(this.mInterpolator.getInterpolation(1.0E-006F) * 1000000.0F * paramInt1 * 1000.0F / paramInt2);
  }
  
  protected int computeRowIndex(int paramInt)
  {
    int j = (Math.abs(paramInt) + this.mContentUnitSize / 2) / this.mContentUnitSize;
    int i = j;
    if (paramInt < 0) {
      i = -j;
    }
    return i;
  }
  
  protected boolean flingToScreen(int paramInt1, int paramInt2)
  {
    return gotoScreen(paramInt1, paramInt2, this.mInterpolatorBak);
  }
  
  public final int getCurrentScreen()
  {
    return this.mCurrentScreen;
  }
  
  public int getDstScreen()
  {
    return this.mDstScreen;
  }
  
  public int getFlingVelocityX()
  {
    return this.mFlingVelocityX;
  }
  
  public int getFlingVelocityY()
  {
    return this.mFlingVelocityY;
  }
  
  public final Interpolator getInterpolator()
  {
    return this.mInterpolatorBak;
  }
  
  public int getTouchDeltaX()
  {
    return this.mLastTouchX - this.mTouchDownX;
  }
  
  public int getTouchDeltaY()
  {
    return this.mLastTouchY - this.mTouchDownY;
  }
  
  public void gotoScreen(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mListener.onScrollStart();
    int i = paramInt2;
    if (paramInt2 < 0) {
      i = this.mScrollingDuration;
    }
    if (paramBoolean) {}
    for (Interpolator localInterpolator = MScroller.DEFAULT_INTERPOLATOR;; localInterpolator = this.mInterpolatorBak)
    {
      gotoScreen(paramInt1, i, localInterpolator);
      return;
    }
  }
  
  protected boolean gotoScreen(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    if (paramInterpolator != null) {}
    int i;
    for (;;)
    {
      this.mInterpolator = paramInterpolator;
      this.mDstScreen = paramInt1;
      i = this.mDstScreen * this.mContentUnitSize - this.mScroll;
      if ((i != 0) || (getCurrentDepth() != 0.0F)) {
        break label89;
      }
      paramInt1 = this.mState;
      if (this.mState != 0)
      {
        this.mState = 0;
        this.mListener.onScrollFinish(getDstScreen());
      }
      if (paramInt1 == 0) {
        break;
      }
      return true;
      paramInterpolator = MScroller.DEFAULT_INTERPOLATOR;
    }
    return false;
    label89:
    paramInt1 = paramInt2;
    if (this.mFlingVelocity != 0)
    {
      paramInt1 = paramInt2;
      if (this.mInterpolator != VISCOUS_FLUID_INTERPOLATOR)
      {
        paramInt1 = Math.min(paramInt2, computeFlingDuration(i, this.mFlingVelocity));
        this.mFlingVelocity = 0;
      }
    }
    onFling(this.mScroll, i, paramInt1);
    this.mListener.onFlingStart();
    return true;
  }
  
  protected void invalidate()
  {
    this.mListener.invalidate();
  }
  
  protected void onComputeFlingOffset(float paramFloat)
  {
    paramFloat = this.mInterpolator.getInterpolation(paramFloat);
    int i;
    if (isFlingFinished())
    {
      i = this.mEndScroll;
      if ((isFlingFinished()) || (paramFloat <= 1.0F)) {
        break label88;
      }
    }
    label88:
    for (boolean bool = true;; bool = false)
    {
      this.mIsOvershooting = bool;
      scrollScreenGroup(i);
      if (isFinished()) {
        this.mListener.onScrollFinish(getDstScreen());
      }
      return;
      i = this.mStartScroll + Math.round(this.mDeltaScroll * paramFloat);
      break;
    }
  }
  
  @SuppressLint({"WrongCall"})
  public boolean onDraw(Canvas paramCanvas)
  {
    invalidateScroll();
    return super.onDraw(paramCanvas);
  }
  
  public void onScroll(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    super.onScroll(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, int paramInt)
  {
    this.mLastTouchX = ((int)paramMotionEvent.getX());
    this.mLastTouchY = ((int)paramMotionEvent.getY());
    if (this.mOrientation == 0) {}
    int j;
    for (int i = this.mLastTouchX;; i = this.mLastTouchY)
    {
      j = this.mLastTouchP;
      this.mLastTouchP = i;
      switch (paramInt)
      {
      default: 
        return false;
      }
    }
    if ((paramMotionEvent.getAction() & 0xFF) == paramInt)
    {
      paramInt = this.mTouchSlop;
      this.mCurrentTouchSlop = paramInt;
      this.mVelocityTracker.addMovement(paramMotionEvent);
      this.mTouchDownP = this.mLastTouchP;
      this.mTouchDownX = this.mLastTouchX;
      this.mTouchDownY = this.mLastTouchY;
      this.mTouchDownScrollP = this.mScroll;
      if (this.mState == 1)
      {
        this.mState = 3;
        this.mListener.onFlingIntercepted();
      }
    }
    for (;;)
    {
      return true;
      paramInt = 0;
      break;
      this.mVelocityTracker.addMovement(paramMotionEvent);
      if ((this.mState != 2) && (Math.abs(this.mLastTouchP - this.mTouchDownP) >= this.mCurrentTouchSlop))
      {
        this.mTouchDownP = this.mLastTouchP;
        this.mTouchDownX = this.mLastTouchX;
        this.mTouchDownY = this.mLastTouchY;
        onScrollStart();
        this.mListener.onScrollStart();
      }
      if (this.mState == 2)
      {
        onScroll((int)((j - i) * this.mAccFactor));
        continue;
        this.mVelocityTracker.addMovement(paramMotionEvent);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
        this.mFlingVelocityX = ((int)this.mVelocityTracker.getXVelocity());
        this.mFlingVelocityY = ((int)this.mVelocityTracker.getYVelocity());
        if (this.mOrientation == 0) {}
        for (paramInt = this.mFlingVelocityX;; paramInt = this.mFlingVelocityY)
        {
          this.mFlingVelocity = paramInt;
          this.mVelocityTracker.clear();
          if (this.mState == 3)
          {
            onScrollStart();
            this.mListener.onScrollStart();
          }
          if ((this.mFlingVelocity <= this.mMinFlingVelocity) || (this.mTouchDownP > i)) {
            break label411;
          }
          flingToScreen(this.mListener.getPreviousMonthRow(), this.mScrollingDuration);
          break;
        }
        label411:
        if ((this.mFlingVelocity >= -this.mMinFlingVelocity) || (this.mTouchDownP < i)) {
          break label452;
        }
        flingToScreen(this.mListener.getNextMonthRow(), this.mScrollingDuration);
      }
    }
    label452:
    this.mFlingVelocity = this.mMinFlingVelocity;
    return flingToScreen(computeRowIndex(this.mScroll), this.mScrollingDuration);
  }
  
  void recycle() {}
  
  protected void scrollScreenGroup(int paramInt)
  {
    this.mOldScroll = this.mScroll;
    this.mScroll = paramInt;
    if (this.mScroll != this.mOldScroll)
    {
      if (this.mOrientation == 0) {
        this.mListener.scrollBy(this.mScroll - this.mOldScroll, 0);
      }
      for (;;)
      {
        paramInt = this.mCurrentScreen;
        this.mCurrentScreen = computeRowIndex(this.mScroll);
        if (this.mCurrentScreen != paramInt) {
          this.mListener.onFirstRowChanged(this.mCurrentScreen, paramInt);
        }
        this.mListener.onScrollChanged(this.mScroll, this.mOldScroll);
        return;
        this.mListener.scrollBy(0, this.mScroll - this.mOldScroll);
      }
    }
    super.scrollScreenGroup(paramInt);
  }
  
  public void setAccFactor(float paramFloat)
  {
    this.mAccFactor = paramFloat;
  }
  
  public void setContentUnitSize(int paramInt)
  {
    this.mContentUnitSize = paramInt;
  }
  
  public void setCurrentScreen(int paramInt)
  {
    abortAnimation();
    this.mDstScreen = paramInt;
    if ((this.mDstScreen == 0) && (this.mScroll == 0))
    {
      paramInt = this.mCurrentScreen;
      this.mCurrentScreen = 0;
      return;
    }
    scrollScreenGroup(this.mDstScreen * this.mContentUnitSize);
  }
  
  public void setDuration(int paramInt)
  {
    this.mScrollingDuration = Math.max(1, paramInt);
  }
  
  public void setEffectorMaxOvershootEnabled(boolean paramBoolean)
  {
    this.mUseEffectorMaxOvershootPercent = paramBoolean;
    setOvershootPercent(this.mMaxOverShootPercent);
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    Interpolator localInterpolator = paramInterpolator;
    if (paramInterpolator == null) {
      localInterpolator = MScroller.DEFAULT_INTERPOLATOR;
    }
    this.mInterpolator = localInterpolator;
    this.mInterpolatorBak = this.mInterpolator;
  }
  
  public void setMaxOvershootPercent(int paramInt)
  {
    this.mMaxOverShootPercent = Math.max(0, Math.min(paramInt, 49));
    setOvershootPercent(this.mMaxOverShootPercent);
  }
  
  public void setOrientation(int paramInt)
  {
    abortAnimation();
    if (paramInt == this.mOrientation) {
      return;
    }
    this.mScroll = 0;
    if (paramInt == 0) {
      this.mListener.scrollBy(0, -this.mListener.getScrollY());
    }
    for (;;)
    {
      this.mOrientation = paramInt;
      updateSize();
      return;
      this.mListener.scrollBy(-this.mListener.getScrollX(), 0);
    }
  }
  
  public void setOvershootPercent(int paramInt)
  {
    if ((!this.mUseEffectorMaxOvershootPercent) && (paramInt != this.mMaxOverShootPercent)) {}
    do
    {
      return;
      paramInt = Math.min(paramInt, this.mMaxOverShootPercent);
    } while (this.mOverShootPercent == paramInt);
    this.mOverShootPercent = paramInt;
    if (paramInt <= 0)
    {
      setInterpolator(DEFAULT_INTERPOLATOR);
      return;
    }
    setInterpolator(new OvershootInterpolator(solveOvershootInterpolatorTension(paramInt)));
  }
  
  protected void updateSize()
  {
    this.mScroll = 0;
    if (this.mOrientation == 0)
    {
      this.mListener.scrollBy(-this.mListener.getScrollX(), 0);
      return;
    }
    this.mListener.scrollBy(0, -this.mListener.getScrollY());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.scroller.RowScroller
 * JD-Core Version:    0.7.0.1
 */