package com.tencent.token;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;

@TargetApi(11)
public final class atb
  extends ValueAnimator
{
  private boolean a = false;
  private float b = 0.0F;
  private float c = 1.0F;
  private long d;
  
  public atb()
  {
    setFloatValues(new float[] { 0.0F, 1.0F });
    addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        atb.a(atb.this);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        atb.a(atb.this);
      }
    });
  }
  
  private void a()
  {
    a(this.b, this.c);
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    float f1 = Math.min(paramFloat1, paramFloat2);
    paramFloat1 = Math.max(paramFloat1, paramFloat2);
    if (this.a) {
      paramFloat2 = paramFloat1;
    } else {
      paramFloat2 = f1;
    }
    float f2;
    if (this.a) {
      f2 = f1;
    } else {
      f2 = paramFloat1;
    }
    setFloatValues(new float[] { paramFloat2, f2 });
    super.setDuration(((float)this.d * (paramFloat1 - f1)));
  }
  
  public final void a(float paramFloat)
  {
    this.b = paramFloat;
    a();
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    a();
  }
  
  public final void b(float paramFloat)
  {
    this.c = paramFloat;
    a();
  }
  
  public final long getDuration()
  {
    return this.d;
  }
  
  public final ValueAnimator setDuration(long paramLong)
  {
    this.d = paramLong;
    a();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.atb
 * JD-Core Version:    0.7.0.1
 */