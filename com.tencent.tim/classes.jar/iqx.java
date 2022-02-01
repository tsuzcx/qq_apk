import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class iqx
{
  private final iqx.a a;
  private final iqx.a b;
  private final boolean mFlywheel;
  private Interpolator mInterpolator;
  private int mMode;
  
  public iqx(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public iqx(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public iqx(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.mInterpolator = paramInterpolator;
    this.mFlywheel = paramBoolean;
    this.a = new iqx.a();
    this.b = new iqx.a();
    iqx.a.initFromContext(paramContext);
  }
  
  public void abortAnimation()
  {
    this.a.finish();
    this.b.finish();
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
      long l = AnimationUtils.currentAnimationTimeMillis() - iqx.a.a(this.a);
      int i = iqx.a.c(this.a);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.mInterpolator == null) {}
        for (f = iqy.viscousFluid(f);; f = this.mInterpolator.getInterpolation(f))
        {
          this.a.updateScroll(f);
          this.b.updateScroll(f);
          break;
        }
      }
      abortAnimation();
      continue;
      if ((!iqx.a.a(this.a)) && (!this.a.update()) && (!this.a.continueWhenFinished())) {
        this.a.finish();
      }
      if ((!iqx.a.a(this.b)) && (!this.b.update()) && (!this.b.continueWhenFinished())) {
        this.b.finish();
      }
    }
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    if ((this.mFlywheel) && (!isFinished()))
    {
      float f1 = iqx.a.a(this.a);
      float f2 = iqx.a.a(this.b);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.mMode = 1;
      this.a.fling(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.b.fling(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public final void forceFinished(boolean paramBoolean)
  {
    iqx.a.a(this.a, iqx.a.a(this.b, paramBoolean));
  }
  
  public final int getCurrX()
  {
    return iqx.a.a(this.a);
  }
  
  public final int getFinalX()
  {
    return iqx.a.b(this.a);
  }
  
  public final boolean isFinished()
  {
    return (iqx.a.a(this.a)) && (iqx.a.a(this.b));
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mMode = 0;
    this.a.startScroll(paramInt1, paramInt3, paramInt5);
    this.b.startScroll(paramInt2, paramInt4, paramInt5);
  }
  
  static class a
  {
    private static float DECELERATION_RATE;
    private static float PHYSICAL_COEF;
    private static final float[] SPLINE_POSITION;
    private static final float[] SPLINE_TIME;
    private float mCurrVelocity;
    private int mCurrentPosition;
    private float mDeceleration;
    private int mDuration;
    private int mFinal;
    private boolean mFinished = true;
    private float mFlingFriction = ViewConfiguration.getScrollFriction();
    private int mOver;
    private int mSplineDistance;
    private int mSplineDuration;
    private int mStart;
    private long mStartTime;
    private int mState = 0;
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
    
    private static float j(int paramInt)
    {
      if (paramInt > 0) {
        return -2000.0F;
      }
      return 2000.0F;
    }
    
    private void k(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int k = 1;
      if ((paramInt1 > paramInt2) && (paramInt1 < paramInt3))
      {
        Log.e("OverScroller", "startAfterEdge called from a valid position");
        this.mFinished = true;
        return;
      }
      int i;
      int j;
      label43:
      int m;
      if (paramInt1 > paramInt3)
      {
        i = 1;
        if (i == 0) {
          break label78;
        }
        j = paramInt3;
        m = paramInt1 - j;
        if (m * paramInt4 < 0) {
          break label84;
        }
      }
      for (;;)
      {
        if (k == 0) {
          break label90;
        }
        y(paramInt1, j, paramInt4);
        return;
        i = 0;
        break;
        label78:
        j = paramInt2;
        break label43;
        label84:
        k = 0;
      }
      label90:
      if (getSplineFlingDistance(paramInt4) > Math.abs(m))
      {
        if (i != 0)
        {
          if (i == 0) {
            break label137;
          }
          paramInt3 = paramInt1;
        }
        for (;;)
        {
          fling(paramInt1, paramInt4, paramInt2, paramInt3, this.mOver);
          return;
          paramInt2 = paramInt1;
          break;
        }
      }
      label137:
      startSpringback(paramInt1, j, paramInt4);
    }
    
    private void onEdgeReached()
    {
      float f2 = this.mVelocity * this.mVelocity / (Math.abs(this.mDeceleration) * 2.0F);
      float f3 = Math.signum(this.mVelocity);
      float f1 = f2;
      if (f2 > this.mOver)
      {
        this.mDeceleration = (-f3 * this.mVelocity * this.mVelocity / (this.mOver * 2.0F));
        f1 = this.mOver;
      }
      this.mOver = ((int)f1);
      this.mState = 2;
      int i = this.mStart;
      if (this.mVelocity > 0) {}
      for (;;)
      {
        this.mFinal = ((int)f1 + i);
        this.mDuration = (-(int)(1000.0F * this.mVelocity / this.mDeceleration));
        return;
        f1 = -f1;
      }
    }
    
    private void startSpringback(int paramInt1, int paramInt2, int paramInt3)
    {
      this.mFinished = false;
      this.mState = 1;
      this.mStart = paramInt1;
      this.mFinal = paramInt2;
      paramInt1 -= paramInt2;
      this.mDeceleration = j(paramInt1);
      this.mVelocity = (-paramInt1);
      this.mOver = Math.abs(paramInt1);
      this.mDuration = ((int)(Math.sqrt(paramInt1 * -2.0D / this.mDeceleration) * 1000.0D));
    }
    
    private void x(int paramInt1, int paramInt2, int paramInt3)
    {
      float f1 = -paramInt3 / this.mDeceleration;
      float f2 = (float)Math.sqrt((paramInt3 * paramInt3 / 2.0F / Math.abs(this.mDeceleration) + Math.abs(paramInt2 - paramInt1)) * 2.0D / Math.abs(this.mDeceleration));
      this.mStartTime -= (int)((f2 - f1) * 1000.0F);
      this.mStart = paramInt2;
      this.mVelocity = ((int)(-this.mDeceleration * f2));
    }
    
    private void y(int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt3 == 0) {}
      for (int i = paramInt1 - paramInt2;; i = paramInt3)
      {
        this.mDeceleration = j(i);
        x(paramInt1, paramInt2, paramInt3);
        onEdgeReached();
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
        this.mStart = this.mFinal;
        this.mVelocity = ((int)this.mCurrVelocity);
        this.mDeceleration = j(this.mVelocity);
        this.mStartTime += this.mDuration;
        onEdgeReached();
        continue;
        this.mStartTime += this.mDuration;
        startSpringback(this.mFinal, this.mStart, 0);
      }
    }
    
    void finish()
    {
      this.mCurrentPosition = this.mFinal;
      this.mFinished = true;
    }
    
    void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.mOver = paramInt5;
      this.mFinished = false;
      this.mVelocity = paramInt2;
      this.mCurrVelocity = paramInt2;
      this.mSplineDuration = 0;
      this.mDuration = 0;
      this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
      this.mStart = paramInt1;
      this.mCurrentPosition = paramInt1;
      if ((paramInt1 > paramInt4) || (paramInt1 < paramInt3)) {
        k(paramInt1, paramInt3, paramInt4, paramInt2);
      }
      do
      {
        return;
        this.mState = 0;
        double d = 0.0D;
        if (paramInt2 != 0)
        {
          paramInt5 = getSplineFlingDuration(paramInt2);
          this.mSplineDuration = paramInt5;
          this.mDuration = paramInt5;
          d = getSplineFlingDistance(paramInt2);
        }
        this.mSplineDistance = ((int)(d * Math.signum(paramInt2)));
        this.mFinal = (this.mSplineDistance + paramInt1);
        if (this.mFinal < paramInt3)
        {
          adjustDuration(this.mStart, this.mFinal, paramInt3);
          this.mFinal = paramInt3;
        }
      } while (this.mFinal <= paramInt4);
      adjustDuration(this.mStart, this.mFinal, paramInt4);
      this.mFinal = paramInt4;
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
    }
    
    boolean update()
    {
      long l = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
      if (l > this.mDuration) {
        return false;
      }
      double d = 0.0D;
      switch (this.mState)
      {
      }
      for (;;)
      {
        int i = this.mStart;
        this.mCurrentPosition = ((int)Math.round(d) + i);
        return true;
        float f3 = (float)l / this.mSplineDuration;
        i = (int)(100.0F * f3);
        float f2 = 1.0F;
        float f1 = 0.0F;
        if (i < 100)
        {
          f2 = i / 100.0F;
          f1 = (i + 1) / 100.0F;
          f4 = SPLINE_POSITION[i];
          f1 = (SPLINE_POSITION[(i + 1)] - f4) / (f1 - f2);
          f2 = (f3 - f2) * f1 + f4;
        }
        d = f2 * this.mSplineDistance;
        this.mCurrVelocity = (f1 * this.mSplineDistance / this.mSplineDuration * 1000.0F);
        continue;
        f1 = (float)l / 1000.0F;
        this.mCurrVelocity = (this.mVelocity + this.mDeceleration * f1);
        f2 = this.mVelocity;
        d = f1 * (this.mDeceleration * f1) / 2.0F + f2 * f1;
        continue;
        f1 = (float)l / this.mDuration;
        f2 = f1 * f1;
        f3 = Math.signum(this.mVelocity);
        d = this.mOver * f3 * (3.0F * f2 - 2.0F * f1 * f2);
        float f4 = this.mOver;
        this.mCurrVelocity = ((-f1 + f2) * (f3 * f4 * 6.0F));
      }
    }
    
    void updateScroll(float paramFloat)
    {
      this.mCurrentPosition = (this.mStart + Math.round((this.mFinal - this.mStart) * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iqx
 * JD-Core Version:    0.7.0.1
 */