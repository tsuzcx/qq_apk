package com.tencent.qqmail.scroller;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public abstract class MScroller
{
  protected static final Interpolator DEFAULT_INTERPOLATOR = new DecelerateInterpolator(1.5F);
  protected static final float EPSILON = 1.0E-006F;
  protected static final int FINISHED = 0;
  public static final int HORIZONTAL = 0;
  protected static final int MAX_FRAME_TIME = 48;
  protected static final float NANOTIME_DIV = 1.0E+009F;
  protected static final float ONE_OVER_EPSILON = 1000000.0F;
  protected static final float ONE_OVER_NANOTIME_DIV = 1.0E-009F;
  private static final float ONE_OVER_SMOOTHING_CONSTANT;
  protected static final int ON_FLING = 1;
  protected static final int ON_SCROLL = 2;
  protected static final Interpolator SIN_INTERPOLATOR;
  private static final float SMOOTHING_CONSTANT = (float)(0.016D / Math.log(0.75D));
  private static final float SMOOTHING_SPEED = 0.75F;
  protected static final int TO_SCROLL = 3;
  public static final int VERTICAL = 1;
  protected static final Interpolator VISCOUS_FLUID_INTERPOLATOR;
  protected int mCurrentTouchSlop;
  protected boolean mDeferScrollUpdate = true;
  protected int mDeltaScroll;
  protected float mDepth;
  protected boolean mDepthEnabled = false;
  protected long mDepthUpdateTime;
  protected int mEndScroll;
  private boolean mFirstSmooth;
  private int mFlingDuration;
  private float mFlingDurationReciprocal;
  private int mFlingPassedTime;
  private float mFlingProgress;
  private long mFlingStartTime;
  protected int mMaxFlingVelocity;
  protected int mMinFlingVelocity;
  protected int mOrientation;
  protected int mScroll;
  private boolean mScrollComputed;
  private float mSmoothingTime;
  protected int mStartScroll;
  protected int mState;
  protected int mTouchSlop;
  
  static
  {
    ONE_OVER_SMOOTHING_CONSTANT = 1.0F / SMOOTHING_CONSTANT;
    VISCOUS_FLUID_INTERPOLATOR = new ViscousFluidInterpolater();
    SIN_INTERPOLATOR = new SinInterpolater();
  }
  
  protected MScroller(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ViewConfiguration.get(paramContext);
      this.mTouchSlop = paramContext.getScaledTouchSlop();
      this.mMinFlingVelocity = (paramContext.getScaledMinimumFlingVelocity() * 4);
      this.mMaxFlingVelocity = paramContext.getScaledMaximumFlingVelocity();
      return;
    }
    this.mTouchSlop = ViewConfiguration.getTouchSlop();
    this.mMinFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() * 4);
    this.mMaxFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
  }
  
  public void abortAnimation()
  {
    if (this.mState == 1) {
      this.mState = 0;
    }
  }
  
  public boolean computeScrollOffset()
  {
    boolean bool1 = false;
    if (this.mScrollComputed)
    {
      if (this.mState != 0)
      {
        invalidate();
        bool1 = true;
      }
      return bool1;
    }
    this.mScrollComputed = true;
    long l;
    int i;
    switch (this.mState)
    {
    case 0: 
    case 3: 
    default: 
      return false;
    case 1: 
      l = AnimationUtils.currentAnimationTimeMillis();
      this.mFlingPassedTime = timePassed(l);
      if (this.mFlingPassedTime >= this.mFlingDuration)
      {
        this.mFlingPassedTime = this.mFlingDuration;
        if ((!this.mDepthEnabled) || (this.mDepth <= 0.0F)) {
          this.mState = 0;
        }
      }
      if ((this.mDepthEnabled) && (l >= this.mDepthUpdateTime))
      {
        i = (int)(l - this.mDepthUpdateTime);
        this.mDepthUpdateTime = l;
        this.mDepth = Math.max(0.0F, this.mDepth - i / 200.0F);
        onDepthChanged();
      }
      this.mFlingProgress = (this.mFlingPassedTime * this.mFlingDurationReciprocal);
      onComputeFlingOffset(this.mFlingProgress);
      return true;
    }
    float f1;
    if (this.mDeferScrollUpdate)
    {
      i = this.mEndScroll - this.mScroll;
      if ((i > 1) || (i < -1))
      {
        float f3 = 1.0E-009F * (float)System.nanoTime();
        float f2 = (float)Math.exp((f3 - this.mSmoothingTime) * ONE_OVER_SMOOTHING_CONSTANT);
        f1 = f2;
        if (this.mFirstSmooth)
        {
          this.mFirstSmooth = false;
          f1 = f2 * 0.5F;
        }
        f2 = this.mScroll;
        scrollScreenGroup(Math.round(f1 * i + f2));
        this.mSmoothingTime = f3;
      }
    }
    for (bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (this.mDepthEnabled)
      {
        bool2 = bool1;
        if (this.mDepth < 1.0F)
        {
          l = AnimationUtils.currentAnimationTimeMillis();
          i = (int)(l - this.mDepthUpdateTime);
          this.mDepthUpdateTime = l;
          f1 = this.mDepth;
          this.mDepth = Math.min(1.0F, i / 200.0F + f1);
          onDepthChanged();
          bool2 = bool1;
          if (!bool1)
          {
            invalidate();
            bool2 = true;
          }
        }
      }
      return bool2;
    }
  }
  
  public float getCurrentDepth()
  {
    if (this.mDepthEnabled)
    {
      float f = 1.0F - this.mDepth;
      return 1.0F - f * f;
    }
    return 0.0F;
  }
  
  public final int getOrientation()
  {
    return this.mOrientation;
  }
  
  public final int getScroll()
  {
    return this.mScroll;
  }
  
  protected void invalidate() {}
  
  public void invalidateScroll()
  {
    this.mScrollComputed = false;
  }
  
  public final boolean isFinished()
  {
    return this.mState == 0;
  }
  
  protected final boolean isFlingFinished()
  {
    return this.mFlingPassedTime >= this.mFlingDuration;
  }
  
  protected void onComputeFlingOffset(float paramFloat) {}
  
  protected void onDepthChanged() {}
  
  public boolean onDraw(Canvas paramCanvas)
  {
    return false;
  }
  
  protected void onFling(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mState = 1;
    this.mFlingProgress = 0.0F;
    this.mFlingDuration = paramInt3;
    this.mFlingStartTime = -1L;
    this.mStartScroll = paramInt1;
    this.mDeltaScroll = paramInt2;
    this.mEndScroll = (paramInt1 + paramInt2);
    this.mFlingDurationReciprocal = (1.0F / this.mFlingDuration);
    this.mDepthUpdateTime = (AnimationUtils.currentAnimationTimeMillis() + 100L);
    invalidateScroll();
    invalidate();
  }
  
  protected void onScroll(int paramInt)
  {
    this.mEndScroll += paramInt;
    if (this.mDeferScrollUpdate)
    {
      this.mFirstSmooth = true;
      this.mSmoothingTime = ((float)System.nanoTime() * 1.0E-009F);
      invalidate();
      return;
    }
    scrollScreenGroup(this.mEndScroll);
  }
  
  protected void onScrollStart()
  {
    if (this.mState == 0) {
      this.mDepthUpdateTime = AnimationUtils.currentAnimationTimeMillis();
    }
    this.mState = 2;
    this.mEndScroll = this.mScroll;
    this.mSmoothingTime = ((float)System.nanoTime() * 1.0E-009F);
    this.mScrollComputed = false;
    invalidate();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, int paramInt)
  {
    return false;
  }
  
  protected void scrollScreenGroup(int paramInt)
  {
    invalidate();
  }
  
  public void setDepthEnabled(boolean paramBoolean)
  {
    this.mDepthEnabled = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    this.mOrientation = paramInt;
  }
  
  public void setScroll(int paramInt)
  {
    this.mScroll = paramInt;
  }
  
  public final int timePassed(long paramLong)
  {
    if (this.mFlingStartTime == -1L)
    {
      this.mFlingStartTime = paramLong;
      return 0;
    }
    return (int)(paramLong - this.mFlingStartTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.scroller.MScroller
 * JD-Core Version:    0.7.0.1
 */