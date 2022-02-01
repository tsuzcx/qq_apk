import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class uhu
{
  private int mCurrX;
  private int mCurrY;
  public final float mDeceleration;
  private float mDeltaX;
  private float mDeltaY;
  private int mDuration;
  private float mDurationReciprocal;
  private int mFinalX;
  private int mFinalY;
  private boolean mFinished = true;
  private Interpolator mInterpolator;
  private int mMaxX;
  private int mMaxY;
  private int mMinX;
  private int mMinY;
  private int mMode;
  private long mStartTime;
  private int mStartX;
  private int mStartY;
  private float mVelocity;
  private float mViscousFluidNormalize;
  private float mViscousFluidScale;
  private float oV = 0.0F;
  private float oW = 1.0F;
  
  public uhu(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public uhu(Context paramContext, Interpolator paramInterpolator)
  {
    this.mInterpolator = paramInterpolator;
    this.mDeceleration = (paramContext.getResources().getDisplayMetrics().density * 800.0F * 386.0878F * ViewConfiguration.getScrollFriction());
  }
  
  private float viscousFluid(float paramFloat)
  {
    paramFloat = this.mViscousFluidScale * paramFloat;
    if (paramFloat < 1.0F) {}
    for (paramFloat -= 1.0F - (float)Math.exp(-paramFloat);; paramFloat = (1.0F - (float)Math.exp(1.0F - paramFloat)) * (1.0F - 0.3678795F) + 0.3678795F) {
      return paramFloat * this.mViscousFluidNormalize;
    }
  }
  
  public void abortAnimation()
  {
    this.mCurrX = this.mFinalX;
    this.mCurrY = this.mFinalY;
    this.mFinished = true;
  }
  
  public int b(boolean paramBoolean, int paramInt)
  {
    int i = (int)Math.sqrt(paramInt * 2 * this.mDeceleration);
    paramInt = i;
    if (paramBoolean) {
      paramInt = -i;
    }
    return paramInt;
  }
  
  public boolean computeScrollOffset()
  {
    if (this.mFinished) {
      return false;
    }
    int i = (int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
    if (i < this.mDuration) {
      switch (this.mMode)
      {
      }
    }
    for (;;)
    {
      return true;
      float f = i * this.mDurationReciprocal;
      if (this.mInterpolator == null) {}
      for (f = viscousFluid(f);; f = this.mInterpolator.getInterpolation(f))
      {
        this.mCurrX = (this.mStartX + Math.round(this.mDeltaX * f));
        i = this.mStartY;
        this.mCurrY = (Math.round(f * this.mDeltaY) + i);
        if ((this.mCurrX != this.mFinalX) || (this.mCurrY != this.mFinalY)) {
          break;
        }
        this.mFinished = true;
        break;
      }
      f = i / 1000.0F;
      f = this.mVelocity * f - f * (this.mDeceleration * f) / 2.0F;
      this.mCurrX = (this.mStartX + Math.round(this.oV * f));
      this.mCurrX = Math.min(this.mCurrX, this.mMaxX);
      this.mCurrX = Math.max(this.mCurrX, this.mMinX);
      i = this.mStartY;
      this.mCurrY = (Math.round(f * this.oW) + i);
      this.mCurrY = Math.min(this.mCurrY, this.mMaxY);
      this.mCurrY = Math.max(this.mCurrY, this.mMinY);
      if ((this.mCurrX == this.mFinalX) && (this.mCurrY == this.mFinalY))
      {
        this.mFinished = true;
        continue;
        this.mCurrX = this.mFinalX;
        this.mCurrY = this.mFinalY;
        this.mFinished = true;
      }
    }
  }
  
  public int eH(int paramInt)
  {
    return (int)(paramInt * paramInt / (2.0F * this.mDeceleration));
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    float f2 = 1.0F;
    this.mMode = 1;
    this.mFinished = false;
    float f3 = (float)Math.hypot(paramInt3, paramInt4);
    this.mVelocity = f3;
    this.mDuration = ((int)(1000.0F * f3 / this.mDeceleration));
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mStartX = paramInt1;
    this.mStartY = paramInt2;
    if (f3 == 0.0F)
    {
      f1 = 1.0F;
      this.oV = f1;
      if (f3 != 0.0F) {
        break label236;
      }
    }
    label236:
    for (float f1 = f2;; f1 = paramInt4 / f3)
    {
      this.oW = f1;
      paramInt3 = (int)(f3 * f3 / (2.0F * this.mDeceleration));
      this.mMinX = paramInt5;
      this.mMaxX = paramInt6;
      this.mMinY = paramInt7;
      this.mMaxY = paramInt8;
      this.mFinalX = (Math.round(paramInt3 * this.oV) + paramInt1);
      this.mFinalX = Math.min(this.mFinalX, this.mMaxX);
      this.mFinalX = Math.max(this.mFinalX, this.mMinX);
      this.mFinalY = (Math.round(paramInt3 * this.oW) + paramInt2);
      this.mFinalY = Math.min(this.mFinalY, this.mMaxY);
      this.mFinalY = Math.max(this.mFinalY, this.mMinY);
      return;
      f1 = paramInt3 / f3;
      break;
    }
  }
  
  public final int getCurrX()
  {
    return this.mCurrX;
  }
  
  public final int getCurrY()
  {
    return this.mCurrY;
  }
  
  public final boolean isFinished()
  {
    return this.mFinished;
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    startScroll(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mMode = 0;
    this.mFinished = false;
    this.mDuration = paramInt5;
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mStartX = paramInt1;
    this.mStartY = paramInt2;
    this.mFinalX = (paramInt1 + paramInt3);
    this.mFinalY = (paramInt2 + paramInt4);
    this.mDeltaX = paramInt3;
    this.mDeltaY = paramInt4;
    this.mDurationReciprocal = (1.0F / this.mDuration);
    this.mViscousFluidScale = 8.0F;
    this.mViscousFluidNormalize = 1.0F;
    this.mViscousFluidNormalize = (1.0F / viscousFluid(1.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uhu
 * JD-Core Version:    0.7.0.1
 */