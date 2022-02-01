package com.tencent.qqmail.scroller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;

public class ScreenScroller
  extends MScroller
{
  public static final float DEFAULT_ACC = 1.0F;
  private float mAccFactor = 1.0F;
  protected PorterDuffColorFilter mColorFilter;
  protected int mCurrentScreen;
  protected boolean mCycloid;
  protected int mDecelerateDuration = 500;
  protected int mDstScreen;
  protected ScreenScrollerEffector mEffector;
  protected int mFlingVelocity;
  protected int mFlingVelocityX;
  protected int mFlingVelocityY;
  protected Interpolator mInterpolator;
  protected Interpolator mInterpolatorBak;
  protected boolean mIsOvershooting;
  protected int mLastTouchP;
  protected int mLastTouchX;
  protected int mLastTouchY;
  protected ScreenScrollerListener mListener;
  protected int mMaxOverShootPercent = 49;
  protected int mOldScroll;
  protected int mOverShootPercent;
  protected float mPaddingFactor = 0.5F;
  protected int mScreenOffsetY;
  protected int mScrollingDuration = 1000;
  protected int mTouchDownP;
  protected int mTouchDownScreen;
  protected int mTouchDownScrollP;
  protected int mTouchDownX;
  protected int mTouchDownY;
  boolean mUseEffectorMaxOvershootPercent = true;
  protected FastVelocityTracker mVelocityTracker;
  
  static
  {
    if (!ScreenScroller.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ScreenScroller(Context paramContext, ScreenScrollerListener paramScreenScrollerListener)
  {
    this(paramContext, paramScreenScrollerListener, null);
  }
  
  public ScreenScroller(Context paramContext, ScreenScrollerListener paramScreenScrollerListener, FastVelocityTracker paramFastVelocityTracker)
  {
    super(paramContext);
    assert (paramScreenScrollerListener != null);
    this.mInterpolatorBak = MScroller.DEFAULT_INTERPOLATOR;
    this.mInterpolator = this.mInterpolatorBak;
    this.mListener = paramScreenScrollerListener;
    if (paramFastVelocityTracker != null) {}
    for (;;)
    {
      this.mVelocityTracker = paramFastVelocityTracker;
      return;
      paramFastVelocityTracker = new FastVelocityTracker();
    }
  }
  
  private static void copyScrollerAttributes(ScreenScroller paramScreenScroller1, ScreenScroller paramScreenScroller2)
  {
    paramScreenScroller2.mDstScreen = paramScreenScroller1.getDstScreen();
    paramScreenScroller2.mScreenOffsetY = paramScreenScroller1.mScreenOffsetY;
    paramScreenScroller2.mPaddingFactor = paramScreenScroller1.mPaddingFactor;
    paramScreenScroller2.mOrientation = paramScreenScroller1.mOrientation;
    paramScreenScroller2.mTouchSlop = paramScreenScroller1.mTouchSlop;
    paramScreenScroller2.mMinFlingVelocity = paramScreenScroller1.mMinFlingVelocity;
    paramScreenScroller2.mMaxFlingVelocity = paramScreenScroller1.mMaxFlingVelocity;
    paramScreenScroller2.mVelocityTracker = paramScreenScroller1.mVelocityTracker;
    paramScreenScroller2.setInterpolator(paramScreenScroller1.getInterpolator());
    paramScreenScroller2.setDuration(paramScreenScroller1.mScrollingDuration);
    paramScreenScroller2.setEffector(paramScreenScroller1.mEffector);
    paramScreenScroller2.setDepthEnabled(paramScreenScroller1.mDepthEnabled);
    paramScreenScroller2.setMaxOvershootPercent(paramScreenScroller1.mOverShootPercent);
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
  
  protected int computeDstDelta(int paramInt1, int paramInt2)
  {
    return this.mListener.getScreenTopByIndex(this.mDstScreen) - this.mScroll;
  }
  
  protected int computeFlingDuration(int paramInt1, int paramInt2)
  {
    return (int)Math.abs(this.mInterpolator.getInterpolation(1.0E-006F) * 1000000.0F * paramInt1 * 1000.0F / paramInt2);
  }
  
  protected int computeScreenIndex(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    int i = this.mListener.getFirstVisiableScreenIndex(paramInt);
    int j = this.mListener.getScreenTopByIndex(i);
    int k = this.mListener.getScreenSizeByIndex(i);
    return i + (int)((paramInt - j) / (k / 2.0F));
  }
  
  protected boolean flingToScreen(int paramInt1, int paramInt2)
  {
    Interpolator localInterpolator = this.mInterpolatorBak;
    return gotoScreen(paramInt1, paramInt2, MScroller.VISCOUS_FLUID_INTERPOLATOR);
  }
  
  public final int getCurrentScreen()
  {
    return this.mCurrentScreen;
  }
  
  public final int getCurrentScreenOffset()
  {
    int i = this.mScroll;
    return this.mListener.getScreenTopByIndex(this.mCurrentScreen) - i;
  }
  
  public int getDrawingScreenA()
  {
    int j = this.mCurrentScreen;
    int i = j;
    if (getCurrentScreenOffset() > 0) {
      i = j - 1;
    }
    return i;
  }
  
  public int getDrawingScreenB()
  {
    int j = this.mCurrentScreen;
    int i = j;
    if (getCurrentScreenOffset() < 0) {
      i = j + 1;
    }
    return i;
  }
  
  public int getDstScreen()
  {
    return this.mDstScreen;
  }
  
  public final ScreenScrollerEffector getEffector()
  {
    return this.mEffector;
  }
  
  public int getFirstVisiableScreenSize()
  {
    int i = this.mListener.getFirstVisiableScreenIndex(this.mScroll);
    return this.mListener.getScreenSizeByIndex(i);
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
  
  public int getNextScreen()
  {
    return this.mCurrentScreen + 1;
  }
  
  public int getPreviousScreen()
  {
    return this.mCurrentScreen - 1;
  }
  
  public int getTouchDeltaX()
  {
    return this.mLastTouchX - this.mTouchDownX;
  }
  
  public int getTouchDeltaY()
  {
    return this.mLastTouchY - this.mTouchDownY;
  }
  
  public int getTouchDownScreen()
  {
    return this.mTouchDownScreen;
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
  
  public boolean gotoScreen(int paramInt)
  {
    this.mListener.onScrollStart();
    this.mDstScreen = paramInt;
    paramInt = -this.mScroll;
    this.mTouchDownScreen = this.mCurrentScreen;
    return scrollScreen(paramInt, this.mDecelerateDuration, MScroller.DEFAULT_INTERPOLATOR);
  }
  
  protected boolean gotoScreen(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    if (paramInterpolator != null) {}
    for (Interpolator localInterpolator = paramInterpolator;; localInterpolator = MScroller.DEFAULT_INTERPOLATOR)
    {
      this.mInterpolator = localInterpolator;
      this.mDstScreen = paramInt1;
      scrollScreen(computeDstDelta(this.mScroll, this.mDstScreen), paramInt2, paramInterpolator);
      return true;
    }
  }
  
  public boolean gotoStartScreen()
  {
    this.mListener.onScrollStart();
    this.mDstScreen = 0;
    int i = -this.mScroll;
    this.mTouchDownScreen = this.mCurrentScreen;
    return scrollScreen(i, this.mDecelerateDuration, MScroller.DEFAULT_INTERPOLATOR);
  }
  
  protected void invalidate()
  {
    this.mListener.invalidate();
  }
  
  public boolean isCircular()
  {
    return this.mCycloid;
  }
  
  protected void onComputeFlingOffset(float paramFloat)
  {
    paramFloat = this.mInterpolator.getInterpolation(paramFloat);
    int i;
    if (isFlingFinished())
    {
      i = this.mEndScroll;
      if ((isFlingFinished()) || (paramFloat <= 1.0F)) {
        break label104;
      }
    }
    label104:
    for (boolean bool = true;; bool = false)
    {
      this.mIsOvershooting = bool;
      scrollScreenGroup(i);
      if (isFinished())
      {
        if (this.mEffector != null) {
          this.mEffector.updateRandomEffect();
        }
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
    return (this.mEffector != null) && (this.mEffector.onDraw(paramCanvas));
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
      this.mTouchDownScreen = this.mCurrentScreen;
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
            break label416;
          }
          flingToScreen(this.mTouchDownScreen - 1, this.mScrollingDuration);
          break;
        }
        label416:
        if ((this.mFlingVelocity >= -this.mMinFlingVelocity) || (this.mTouchDownP < i)) {
          break label454;
        }
        flingToScreen(this.mTouchDownScreen + 1, this.mScrollingDuration);
      }
    }
    label454:
    this.mFlingVelocity = this.mMinFlingVelocity;
    return flingToScreen(computeScreenIndex(this.mScroll), this.mScrollingDuration);
  }
  
  void recycle() {}
  
  protected boolean scrollScreen(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    if (paramInterpolator != null) {}
    for (;;)
    {
      this.mInterpolator = paramInterpolator;
      if ((paramInt1 != 0) || (getCurrentDepth() != 0.0F)) {
        break label67;
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
    label67:
    int i = paramInt2;
    if (this.mFlingVelocity != 0)
    {
      i = paramInt2;
      if (this.mInterpolator != VISCOUS_FLUID_INTERPOLATOR)
      {
        i = Math.min(paramInt2, computeFlingDuration(paramInt1, this.mFlingVelocity));
        this.mFlingVelocity = 0;
      }
    }
    onFling(this.mScroll, paramInt1, i);
    this.mListener.onFlingStart();
    return true;
  }
  
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
        this.mCurrentScreen = computeScreenIndex(this.mScroll);
        if (this.mCurrentScreen != paramInt) {
          this.mListener.onScreenChanged(this.mCurrentScreen, paramInt);
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
  
  public void setBackgroundColorFilter(int paramInt)
  {
    int i = paramInt;
    if (paramInt >>> 24 == 0) {
      i = 0;
    }
    if (i == 0)
    {
      this.mColorFilter = null;
      return;
    }
    this.mColorFilter = new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_OVER);
  }
  
  public void setCurrentScreen(int paramInt)
  {
    abortAnimation();
    this.mDstScreen = paramInt;
    if ((this.mDstScreen == 0) && (this.mScroll == 0))
    {
      paramInt = this.mCurrentScreen;
      this.mCurrentScreen = 0;
      if (this.mCurrentScreen != paramInt) {
        this.mListener.onScreenChanged(this.mCurrentScreen, paramInt);
      }
      return;
    }
    scrollScreenGroup(this.mListener.getScreenTopByIndex(this.mDstScreen));
  }
  
  public void setDuration(int paramInt)
  {
    this.mScrollingDuration = Math.max(1, paramInt);
  }
  
  public void setEffector(ScreenScrollerEffector paramScreenScrollerEffector)
  {
    ScreenScrollerEffector localScreenScrollerEffector = this.mEffector;
    this.mEffector = paramScreenScrollerEffector;
    if ((localScreenScrollerEffector != this.mEffector) && (localScreenScrollerEffector != null)) {
      localScreenScrollerEffector.onDetach();
    }
    if (this.mEffector != null) {
      this.mEffector.onAttach(this.mListener);
    }
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
      int i = paramInt;
      if (this.mUseEffectorMaxOvershootPercent)
      {
        i = paramInt;
        if (paramInt == this.mMaxOverShootPercent)
        {
          i = paramInt;
          if (this.mEffector != null) {
            i = Math.min(paramInt, this.mEffector.getMaxOvershootPercent());
          }
        }
      }
      paramInt = Math.min(i, this.mMaxOverShootPercent);
    } while (this.mOverShootPercent == paramInt);
    this.mOverShootPercent = paramInt;
    if (paramInt <= 0)
    {
      setInterpolator(DEFAULT_INTERPOLATOR);
      return;
    }
    setInterpolator(new OvershootInterpolator(solveOvershootInterpolatorTension(paramInt)));
  }
  
  public void setPadding(float paramFloat)
  {
    abortAnimation();
    if (this.mPaddingFactor == paramFloat) {
      return;
    }
    this.mPaddingFactor = Math.max(0.0F, Math.min(paramFloat, 0.5F));
    scrollScreenGroup(this.mListener.getScreenTopByIndex(getDstScreen()));
  }
  
  public void setScreenCount(int paramInt)
  {
    float f = this.mPaddingFactor;
    this.mPaddingFactor = -1.0F;
    setPadding(f);
  }
  
  public void setScreenOffsetY(int paramInt)
  {
    this.mScreenOffsetY = paramInt;
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
 * Qualified Name:     com.tencent.qqmail.scroller.ScreenScroller
 * JD-Core Version:    0.7.0.1
 */