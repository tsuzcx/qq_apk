import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class jmg
{
  private static float END_TENSION;
  private static final float[] SPLINE;
  private static float START_TENSION = 0.4F;
  private static float sViscousFluidNormalize = 1.0F / viscousFluid(1.0F);
  private static float sViscousFluidScale;
  private final jmg.a a;
  private final jmg.a b;
  private final boolean mFlywheel;
  private final Interpolator mInterpolator;
  private int mMode;
  
  static
  {
    END_TENSION = 1.0F - START_TENSION;
    SPLINE = new float[101];
    float f1 = 0.0F;
    int i = 0;
    if (i <= 100)
    {
      float f4 = i / 100.0F;
      float f2 = 1.0F;
      for (;;)
      {
        float f3 = (f2 - f1) / 2.0F + f1;
        float f5 = 3.0F * f3 * (1.0F - f3);
        float f6 = ((1.0F - f3) * START_TENSION + END_TENSION * f3) * f5 + f3 * f3 * f3;
        if (Math.abs(f6 - f4) < 1.E-005D)
        {
          SPLINE[i] = (f3 * f3 * f3 + f5);
          i += 1;
          break;
        }
        if (f6 > f4) {
          f2 = f3;
        } else {
          f1 = f3;
        }
      }
    }
    SPLINE[100] = 1.0F;
    sViscousFluidScale = 8.0F;
    sViscousFluidNormalize = 1.0F;
  }
  
  public jmg(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public jmg(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public jmg(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.mInterpolator = paramInterpolator;
    this.mFlywheel = paramBoolean;
    this.a = new jmg.a();
    this.b = new jmg.a();
    jmg.a.initFromContext(paramContext);
  }
  
  public static float viscousFluid(float paramFloat)
  {
    paramFloat = sViscousFluidScale * paramFloat;
    if (paramFloat < 1.0F) {}
    for (paramFloat -= 1.0F - (float)Math.exp(-paramFloat);; paramFloat = (1.0F - (float)Math.exp(1.0F - paramFloat)) * (1.0F - 0.3678795F) + 0.3678795F) {
      return paramFloat * sViscousFluidNormalize;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    if ((this.mFlywheel) && (!isFinished()))
    {
      float f1 = jmg.a.a(this.a);
      float f2 = jmg.a.a(this.b);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.mMode = 1;
      this.a.b(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9, paramInt11);
      this.b.b(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10, paramInt12);
      return;
    }
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
      long l = AnimationUtils.currentAnimationTimeMillis() - jmg.a.a(this.a);
      int i = jmg.a.b(this.a);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.mInterpolator == null) {}
        for (f = viscousFluid(f);; f = this.mInterpolator.getInterpolation(f))
        {
          if (!jmg.a.a(this.a)) {
            this.a.updateScroll(f);
          }
          if (jmg.a.a(this.b)) {
            break;
          }
          this.b.updateScroll(f);
          break;
        }
      }
      abortAnimation();
      continue;
      if ((!jmg.a.a(this.a)) && (!this.a.update()) && (!this.a.continueWhenFinished())) {
        this.a.finish();
      }
      if ((!jmg.a.a(this.b)) && (!this.b.update()) && (!this.b.continueWhenFinished())) {
        this.b.finish();
      }
    }
  }
  
  public final int getCurrX()
  {
    return jmg.a.a(this.a);
  }
  
  public final boolean isFinished()
  {
    return (jmg.a.a(this.a)) && (jmg.a.a(this.b));
  }
  
  public final void setFriction(float paramFloat)
  {
    this.a.setFriction(paramFloat);
    this.b.setFriction(paramFloat);
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
      bounce(this.mFinal, this.mOver, (int)this.mCurrVelocity, 400);
      this.mStartTime = l;
      update();
    }
    
    private void startSpringback(int paramInt1, int paramInt2, int paramInt3)
    {
      this.mFinished = false;
      this.mState = 1;
      this.mStart = paramInt1;
      this.mFinal = paramInt2;
      this.mOver = (paramInt2 - paramInt1);
      this.mDuration = 400;
    }
    
    void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
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
        paramInt5 = getSplineFlingDuration(paramInt2);
        this.mSplineDuration = paramInt5;
        this.mDuration = paramInt5;
        this.mDeceleration = ((float)(getSplineDeceleration(paramInt2) * 1000.0D));
        d = getSplineFlingDistance(paramInt2);
      }
      this.mSplineDistance = ((int)(d * Math.signum(paramInt2)));
      this.mFinal = (this.mSplineDistance + paramInt1);
      if (this.mFinal < paramInt3)
      {
        adjustDuration(this.mStart, this.mFinal, paramInt3);
        this.mFinal = paramInt3;
      }
      do
      {
        for (;;)
        {
          this.mLastVelocity = paramInt2;
          this.mLastTime = this.mStartTime;
          return;
          if (this.mFinal <= paramInt4) {
            break;
          }
          adjustDuration(this.mStart, this.mFinal, paramInt4);
          this.mFinal = paramInt4;
        }
      } while ((this.mSplineDistance == 0) || (paramInt6 <= 0) || (this.mFinal % paramInt6 == 0));
      if (paramInt2 > 0)
      {
        paramInt3 = this.mFinal / paramInt6 * paramInt6;
        paramInt4 = (this.mFinal / paramInt6 + 1) * paramInt6;
        if ((Math.abs(paramInt4 - this.mFinal) < Math.abs(this.mFinal - paramInt3)) || (paramInt3 < paramInt1)) {
          this.mFinal = paramInt4;
        }
      }
      for (;;)
      {
        this.mSplineDistance = (this.mFinal - paramInt1);
        break;
        this.mFinal = paramInt3;
        continue;
        paramInt3 = this.mFinal / paramInt6 * paramInt6;
        paramInt4 = (this.mFinal / paramInt6 - 1) * paramInt6;
        if ((Math.abs(paramInt4 - this.mFinal) < Math.abs(this.mFinal - paramInt3)) || (paramInt3 > paramInt1)) {
          this.mFinal = paramInt4;
        } else {
          this.mFinal = paramInt3;
        }
      }
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
    
    void finish()
    {
      this.mCurrentPosition = this.mFinal;
      this.mFinished = true;
    }
    
    void setFriction(float paramFloat)
    {
      this.mFlingFriction = paramFloat;
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
        d = jmg.viscousFluid((float)l2 / this.mDuration) * this.mOver;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jmg
 * JD-Core Version:    0.7.0.1
 */