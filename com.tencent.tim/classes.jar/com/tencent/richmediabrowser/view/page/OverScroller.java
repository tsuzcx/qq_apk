package com.tencent.richmediabrowser.view.page;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.richmediabrowser.animation.AnimateUtils;

public class OverScroller
{
  public static int BOUNCE_DURANTION = 400;
  private static final int DEFAULT_DURATION = 250;
  private static final int FLING_MODE = 1;
  public static final int FLING_MODE_NORMAL = 0;
  public static final int FLING_MODE_SLOW = 1;
  private static final int SCROLL_MODE = 0;
  private static final int SCROLL_MODE_NO_BACK = 2;
  private final boolean mFlywheel;
  private Interpolator mInterpolator;
  private int mMode;
  private final SplineOverScroller mScrollerX;
  private final SplineOverScroller mScrollerY;
  
  public OverScroller(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator, float paramFloat1, float paramFloat2)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this(paramContext, paramInterpolator, paramBoolean);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.mInterpolator = paramInterpolator;
    this.mFlywheel = paramBoolean;
    this.mScrollerX = new SplineOverScroller();
    this.mScrollerY = new SplineOverScroller();
    SplineOverScroller.initFromContext(paramContext);
  }
  
  public void abortAnimation()
  {
    this.mScrollerX.finish();
    this.mScrollerY.finish();
  }
  
  public boolean computeScrollOffset()
  {
    if (isFinished()) {
      return false;
    }
    switch (this.mMode)
    {
    }
    for (;;)
    {
      return true;
      long l = AnimationUtils.currentAnimationTimeMillis() - this.mScrollerX.mStartTime;
      int i = this.mScrollerX.mDuration;
      if (l < i)
      {
        float f = (float)l / i;
        if (this.mInterpolator == null) {}
        for (f = AnimateUtils.viscousFluid(f);; f = this.mInterpolator.getInterpolation(f))
        {
          if (!this.mScrollerX.mFinished) {
            this.mScrollerX.updateScroll(f);
          }
          if (this.mScrollerY.mFinished) {
            break;
          }
          this.mScrollerY.updateScroll(f);
          break;
        }
      }
      abortAnimation();
      continue;
      if ((!this.mScrollerX.mFinished) && (!this.mScrollerX.update()) && (!this.mScrollerX.continueWhenFinishedForNoBack())) {
        this.mScrollerX.finish();
      }
      if ((!this.mScrollerY.mFinished) && (!this.mScrollerY.update()) && (!this.mScrollerY.continueWhenFinishedForNoBack()))
      {
        this.mScrollerY.finish();
        continue;
        if ((!this.mScrollerX.mFinished) && (!this.mScrollerX.update()) && (!this.mScrollerX.continueWhenFinished())) {
          this.mScrollerX.finish();
        }
        if ((!this.mScrollerY.mFinished) && (!this.mScrollerY.update()) && (!this.mScrollerY.continueWhenFinished())) {
          this.mScrollerY.finish();
        }
      }
    }
  }
  
  @Deprecated
  public void extendDuration(int paramInt)
  {
    this.mScrollerX.extendDuration(paramInt);
    this.mScrollerY.extendDuration(paramInt);
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, 0, 0);
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, 1);
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    if ((this.mFlywheel) && (!isFinished()))
    {
      float f1 = this.mScrollerX.mCurrVelocity;
      float f2 = this.mScrollerY.mCurrVelocity;
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.mMode = paramInt11;
      this.mScrollerX.fling(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.mScrollerY.fling(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public void fling(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
    SplineOverScroller.access$602(this.mScrollerX, paramLong);
    SplineOverScroller.access$602(this.mScrollerY, paramLong);
  }
  
  public final void forceFinished(boolean paramBoolean)
  {
    SplineOverScroller.access$002(this.mScrollerX, SplineOverScroller.access$002(this.mScrollerY, paramBoolean));
  }
  
  public float getCurrVelocity()
  {
    return (float)Math.sqrt(this.mScrollerX.mCurrVelocity * this.mScrollerX.mCurrVelocity + this.mScrollerY.mCurrVelocity * this.mScrollerY.mCurrVelocity);
  }
  
  public float getCurrVelocityY()
  {
    return this.mScrollerY.mCurrVelocity;
  }
  
  public final int getCurrX()
  {
    return this.mScrollerX.mCurrentPosition;
  }
  
  public final int getCurrY()
  {
    return this.mScrollerY.mCurrentPosition;
  }
  
  @Deprecated
  public final int getDuration()
  {
    return Math.max(this.mScrollerX.mDuration, this.mScrollerY.mDuration);
  }
  
  public final int getFinalX()
  {
    return this.mScrollerX.mFinal;
  }
  
  public final int getFinalY()
  {
    return this.mScrollerY.mFinal;
  }
  
  public Interpolator getInterpolator()
  {
    return this.mInterpolator;
  }
  
  public final int getStartX()
  {
    return this.mScrollerX.mStart;
  }
  
  public final int getStartY()
  {
    return this.mScrollerY.mStart;
  }
  
  public final boolean isFinished()
  {
    return (this.mScrollerX.mFinished) && (this.mScrollerY.mFinished);
  }
  
  public boolean isOverScrolled()
  {
    return ((!this.mScrollerX.mFinished) && (this.mScrollerX.mState != 0)) || ((!this.mScrollerY.mFinished) && (this.mScrollerY.mState != 0));
  }
  
  public boolean isScrollingInDirection(float paramFloat1, float paramFloat2)
  {
    int i = this.mScrollerX.mFinal;
    int j = this.mScrollerX.mStart;
    int k = this.mScrollerY.mFinal;
    int m = this.mScrollerY.mStart;
    return (!isFinished()) && (Math.signum(paramFloat1) == Math.signum(i - j)) && (Math.signum(paramFloat2) == Math.signum(k - m));
  }
  
  public void notifyHorizontalEdgeReached(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mScrollerX.notifyEdgeReached(paramInt1, paramInt2, paramInt3);
  }
  
  public void notifyVerticalEdgeReached(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mScrollerY.notifyEdgeReached(paramInt1, paramInt2, paramInt3);
  }
  
  @Deprecated
  public void setFinalX(int paramInt)
  {
    this.mScrollerX.setFinalPosition(paramInt);
  }
  
  @Deprecated
  public void setFinalY(int paramInt)
  {
    this.mScrollerY.setFinalPosition(paramInt);
  }
  
  public void setFlingMode(int paramInt)
  {
    this.mScrollerY.setFlingMode(paramInt);
  }
  
  public final void setFriction(float paramFloat)
  {
    this.mScrollerX.setFriction(paramFloat);
    this.mScrollerY.setFriction(paramFloat);
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.mInterpolator = paramInterpolator;
  }
  
  public boolean springBack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mMode = 1;
    boolean bool1 = this.mScrollerX.springback(paramInt1, paramInt3, paramInt4);
    boolean bool2 = this.mScrollerY.springback(paramInt2, paramInt5, paramInt6);
    return (bool1) || (bool2);
  }
  
  public boolean springBack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.mMode = 1;
    boolean bool1 = this.mScrollerX.springback(paramInt1, paramInt3, paramInt4, paramInt7);
    boolean bool2 = this.mScrollerY.springback(paramInt2, paramInt5, paramInt6, paramInt7);
    return (bool1) || (bool2);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    startScroll(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mMode = 0;
    this.mScrollerX.startScroll(paramInt1, paramInt3, paramInt5);
    this.mScrollerY.startScroll(paramInt2, paramInt4, paramInt5);
  }
  
  public int timePassed()
  {
    return (int)(AnimationUtils.currentAnimationTimeMillis() - Math.min(this.mScrollerX.mStartTime, this.mScrollerY.mStartTime));
  }
  
  static class SplineOverScroller
  {
    private static final int BOUNCE = 3;
    private static final int CUBIC = 1;
    private static float DECELERATION_RATE = 0.0F;
    private static final float END_TENSION = 1.0F;
    private static final float GRAVITY = 2000.0F;
    private static final float INFLEXION = 0.35F;
    private static final int NB_SAMPLES = 100;
    private static final float P1 = 0.175F;
    private static final float P2 = 0.35F;
    private static float PHYSICAL_COEF = 0.0F;
    private static final int SCROLL = 4;
    private static final int SPLINE = 0;
    private static final float[] SPLINE_POSITION;
    private static final float[] SPLINE_TIME;
    private static final float START_TENSION = 0.5F;
    private float mCurrVelocity;
    private int mCurrentPosition;
    private float mDeceleration;
    private int mDuration;
    private int mFinal;
    private boolean mFinished = true;
    private float mFlingFriction = ViewConfiguration.getScrollFriction();
    private int mFlingMode = 0;
    private long mLastTime;
    private double mLastVelocity;
    private int mOver;
    private int mSplineDistance;
    private int mSplineDuration;
    private int mStart;
    private long mStartTime;
    private int mState = 0;
    private float mTension;
    private int mVelocity;
    
    static
    {
      float f2 = 0.0F;
      DECELERATION_RATE = (float)(Math.log(0.78D) / Math.log(0.9D));
      SPLINE_POSITION = new float[101];
      SPLINE_TIME = new float[101];
      int i = 0;
      float f1 = 0.0F;
      if (i < 100)
      {
        float f5 = i / 100.0F;
        float f3 = 1.0F;
        label55:
        float f4 = (f3 - f1) / 2.0F + f1;
        float f6 = 3.0F * f4 * (1.0F - f4);
        float f7 = ((1.0F - f4) * 0.175F + 0.35F * f4) * f6 + f4 * f4 * f4;
        if (Math.abs(f7 - f5) < 1.E-005D)
        {
          SPLINE_POSITION[i] = (f4 * (f4 * f4) + f6 * ((1.0F - f4) * 0.5F + f4));
          f3 = 1.0F;
        }
        for (;;)
        {
          f4 = (f3 - f2) / 2.0F + f2;
          f6 = 3.0F * f4 * (1.0F - f4);
          f7 = ((1.0F - f4) * 0.5F + f4) * f6 + f4 * f4 * f4;
          if (Math.abs(f7 - f5) < 1.E-005D)
          {
            SPLINE_TIME[i] = (f4 * (f4 * f4) + ((1.0F - f4) * 0.175F + 0.35F * f4) * f6);
            i += 1;
            break;
            if (f7 > f5)
            {
              f3 = f4;
              break label55;
            }
            f1 = f4;
            break label55;
          }
          if (f7 > f5) {
            f3 = f4;
          } else {
            f2 = f4;
          }
        }
      }
      float[] arrayOfFloat = SPLINE_POSITION;
      SPLINE_TIME[100] = 1.0F;
      arrayOfFloat[100] = 1.0F;
    }
    
    private void adjustDuration(int paramInt1, int paramInt2, int paramInt3)
    {
      float f1 = Math.abs((paramInt3 - paramInt1) / (paramInt2 - paramInt1));
      paramInt1 = (int)(100.0F * f1);
      if (paramInt1 < 100)
      {
        float f2 = paramInt1 / 100.0F;
        float f3 = (paramInt1 + 1) / 100.0F;
        float f4 = SPLINE_TIME[paramInt1];
        float f5 = SPLINE_TIME[(paramInt1 + 1)];
        this.mDuration = ((int)(((f1 - f2) / (f3 - f2) * (f5 - f4) + f4) * this.mDuration));
      }
    }
    
    private double getSplineDeceleration(int paramInt)
    {
      return Math.log(0.35F * Math.abs(paramInt) / (this.mFlingFriction * PHYSICAL_COEF));
    }
    
    private double getSplineFlingDistance(int paramInt)
    {
      double d1 = getSplineDeceleration(paramInt);
      double d2 = DECELERATION_RATE;
      double d3 = this.mFlingFriction * PHYSICAL_COEF;
      return Math.exp(d1 * (DECELERATION_RATE / (d2 - 1.0D))) * d3;
    }
    
    private int getSplineFlingDuration(int paramInt)
    {
      return (int)(Math.exp(getSplineDeceleration(paramInt) / (DECELERATION_RATE - 1.0D)) * 1000.0D);
    }
    
    static void initFromContext(Context paramContext)
    {
      PHYSICAL_COEF = paramContext.getResources().getDisplayMetrics().density * 160.0F * 386.0878F * 0.84F;
    }
    
    private void onEdgeReached()
    {
      long l = this.mStartTime;
      l = this.mDuration + l;
      int i = (int)(this.mDuration / this.mSplineDuration * 100.0F);
      float f1 = 0.0F;
      if (i < 100)
      {
        f1 = i / 100.0F;
        float f2 = (i + 1) / 100.0F;
        float f3 = SPLINE_POSITION[i];
        f1 = (SPLINE_POSITION[(i + 1)] - f3) / (f2 - f1);
      }
      this.mCurrVelocity = (f1 * this.mSplineDistance / this.mSplineDuration * 1000.0F);
      this.mDeceleration = ((float)((this.mCurrVelocity - this.mLastVelocity) / (l - this.mLastTime) * 1000.0D));
      bounce(this.mFinal, this.mOver, (int)this.mCurrVelocity, OverScroller.BOUNCE_DURANTION);
      this.mStartTime = l;
      update();
    }
    
    private void onEdgeReachedNoBack()
    {
      long l = this.mStartTime;
      l = this.mDuration + l;
      int i = (int)(this.mDuration / this.mSplineDuration * 100.0F);
      float f1 = 0.0F;
      if (i < 100)
      {
        f1 = i / 100.0F;
        float f2 = (i + 1) / 100.0F;
        float f3 = SPLINE_POSITION[i];
        f1 = (SPLINE_POSITION[(i + 1)] - f3) / (f2 - f1);
      }
      this.mCurrVelocity = (f1 * this.mSplineDistance / this.mSplineDuration * 1000.0F);
      this.mDeceleration = ((float)((this.mCurrVelocity - this.mLastVelocity) / (l - this.mLastTime) * 1000.0D));
      this.mStartTime = l;
    }
    
    private void startSpringback(int paramInt1, int paramInt2, int paramInt3)
    {
      this.mFinished = false;
      this.mState = 1;
      this.mStart = paramInt1;
      this.mFinal = paramInt2;
      this.mOver = (paramInt2 - paramInt1);
      this.mDuration = OverScroller.BOUNCE_DURANTION;
    }
    
    private void startSpringback(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.mFinished = false;
      this.mState = 1;
      this.mStart = paramInt1;
      this.mFinal = paramInt2;
      this.mOver = (paramInt2 - paramInt1);
      this.mDuration = paramInt4;
    }
    
    void bounce(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      float f2 = 0.09606F * paramInt2 / (1.E-005F * paramInt4);
      if (paramInt3 > 0) {}
      for (float f1 = 10.0F;; f1 = -10.0F)
      {
        if (Math.abs(paramInt3) < f2) {
          f1 = paramInt3 * 10.0F / f2;
        }
        this.mStart = paramInt1;
        this.mFinal = paramInt1;
        this.mVelocity = paramInt3;
        this.mOver = paramInt2;
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mDuration = paramInt4;
        this.mTension = f1;
        this.mCurrentPosition = this.mStart;
        this.mState = 3;
        return;
      }
    }
    
    boolean continueWhenFinished()
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      switch (this.mState)
      {
      }
      for (;;)
      {
        update();
        bool1 = true;
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.mDuration >= this.mSplineDuration);
        onEdgeReached();
      }
    }
    
    boolean continueWhenFinishedForNoBack()
    {
      boolean bool = false;
      switch (this.mState)
      {
      case 2: 
      default: 
        update();
        bool = true;
      }
      return bool;
    }
    
    void extendDuration(int paramInt)
    {
      this.mDuration = ((int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime) + paramInt);
      this.mFinished = false;
    }
    
    void finish()
    {
      this.mCurrentPosition = this.mFinal;
      this.mFinished = true;
    }
    
    void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.mSplineDuration = 0;
      this.mDuration = 0;
      this.mOver = paramInt5;
      this.mFinished = false;
      this.mVelocity = paramInt2;
      this.mCurrVelocity = paramInt2;
      this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
      this.mStart = paramInt1;
      this.mCurrentPosition = paramInt1;
      if ((paramInt1 > paramInt4) || (paramInt1 < paramInt3))
      {
        if (paramInt1 > paramInt4) {}
        for (;;)
        {
          startSpringback(paramInt1, paramInt4, paramInt2);
          return;
          paramInt4 = paramInt3;
        }
      }
      this.mState = 0;
      double d = 0.0D;
      if (paramInt2 != 0)
      {
        if (this.mFlingMode != 1) {
          break label239;
        }
        paramInt5 = getSplineFlingDuration(paramInt2) * 3 / 2;
        this.mSplineDuration = paramInt5;
      }
      for (this.mDuration = paramInt5;; this.mDuration = paramInt5)
      {
        this.mDeceleration = ((float)(getSplineDeceleration(paramInt2) * 1000.0D));
        d = getSplineFlingDistance(paramInt2);
        this.mSplineDistance = ((int)(d * Math.signum(paramInt2)));
        this.mFinal = (this.mSplineDistance + paramInt1);
        if (this.mFinal < paramInt3)
        {
          adjustDuration(this.mStart, this.mFinal, paramInt3);
          this.mFinal = paramInt3;
        }
        if (this.mFinal > paramInt4)
        {
          adjustDuration(this.mStart, this.mFinal, paramInt4);
          this.mFinal = paramInt4;
        }
        this.mLastVelocity = paramInt2;
        this.mLastTime = this.mStartTime;
        return;
        label239:
        paramInt5 = getSplineFlingDuration(paramInt2);
        this.mSplineDuration = paramInt5;
      }
    }
    
    void notifyEdgeReached(int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.mState == 0) {
        if (paramInt1 == paramInt2) {
          bounce(paramInt2, paramInt3, this.mVelocity, OverScroller.BOUNCE_DURANTION);
        }
      }
      while (this.mState != 4)
      {
        return;
        adjustDuration(this.mStart, this.mFinal, this.mCurrentPosition - (paramInt1 - paramInt2));
        this.mOver = paramInt3;
        this.mFinal = paramInt2;
        onEdgeReached();
        return;
      }
      this.mCurrentPosition = 0;
      this.mFinal = 0;
      this.mFinished = true;
    }
    
    void setFinalPosition(int paramInt)
    {
      this.mFinal = paramInt;
      this.mFinished = false;
    }
    
    void setFlingMode(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return;
      }
      this.mFlingMode = paramInt;
    }
    
    void setFriction(float paramFloat)
    {
      this.mFlingFriction = paramFloat;
    }
    
    boolean springback(int paramInt1, int paramInt2, int paramInt3)
    {
      this.mFinished = true;
      this.mFinal = paramInt1;
      this.mStart = paramInt1;
      this.mVelocity = 0;
      this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
      this.mDuration = 0;
      if (paramInt1 < paramInt2) {
        startSpringback(paramInt1, paramInt2, 0);
      }
      while (!this.mFinished)
      {
        return true;
        if (paramInt1 > paramInt3) {
          startSpringback(paramInt1, paramInt3, 0);
        }
      }
      return false;
    }
    
    boolean springback(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.mFinished = true;
      this.mFinal = paramInt1;
      this.mStart = paramInt1;
      this.mVelocity = 0;
      this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
      this.mDuration = 0;
      if (paramInt1 < paramInt2) {
        startSpringback(paramInt1, paramInt2, 0, paramInt4);
      }
      while (!this.mFinished)
      {
        return true;
        if (paramInt1 > paramInt3) {
          startSpringback(paramInt1, paramInt3, 0, paramInt4);
        }
      }
      return false;
    }
    
    void startScroll(int paramInt1, int paramInt2, int paramInt3)
    {
      this.mFinished = false;
      this.mStart = paramInt1;
      this.mFinal = (paramInt1 + paramInt2);
      this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
      this.mDuration = paramInt3;
      this.mDeceleration = 0.0F;
      this.mVelocity = 0;
      this.mState = 4;
    }
    
    boolean update()
    {
      float f2 = 1.0F;
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      long l2 = l1 - this.mStartTime;
      if (l2 > this.mDuration) {
        return false;
      }
      double d;
      switch (this.mState)
      {
      case 2: 
      default: 
        d = 0.0D;
      }
      for (;;)
      {
        int i = this.mStart;
        this.mCurrentPosition = ((int)Math.round(d) + i);
        return true;
        float f3 = (float)l2 / this.mSplineDuration;
        i = (int)(100.0F * f3);
        float f1 = 0.0F;
        if (i < 100)
        {
          f2 = i / 100.0F;
          f1 = (i + 1) / 100.0F;
          float f4 = SPLINE_POSITION[i];
          f1 = (SPLINE_POSITION[(i + 1)] - f4) / (f1 - f2);
          f2 = (f3 - f2) * f1 + f4;
        }
        d = f2 * this.mSplineDistance;
        this.mCurrVelocity = (f1 * this.mSplineDistance / this.mSplineDuration * 1000.0F);
        this.mDeceleration = ((float)((this.mCurrVelocity - this.mLastVelocity) / (l1 - this.mLastTime) * 1000.0D));
        continue;
        d = AnimateUtils.viscousFluid((float)l2 / this.mDuration) * this.mOver;
        continue;
        f1 = (float)l2 / this.mDuration - 1.0F;
        f2 = this.mOver;
        d = (f1 * this.mTension + this.mTension) * (f2 * f1 * f1 * f1 * f1);
      }
    }
    
    void updateScroll(float paramFloat)
    {
      this.mCurrentPosition = (this.mStart + Math.round((this.mFinal - this.mStart) * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.page.OverScroller
 * JD-Core Version:    0.7.0.1
 */