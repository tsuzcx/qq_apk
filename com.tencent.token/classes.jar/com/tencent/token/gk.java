package com.tencent.token;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;

@TargetApi(11)
public class gk
  extends ValueAnimator
{
  private boolean a = false;
  private float b = 0.0F;
  private float c = 1.0F;
  private long d;
  
  public gk()
  {
    setFloatValues(new float[] { 0.0F, 1.0F });
    addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        gk.a(gk.this);
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        gk.a(gk.this);
      }
    });
  }
  
  private void a()
  {
    a(this.b, this.c);
  }
  
  public void a(float paramFloat)
  {
    this.b = paramFloat;
    a();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    float f1 = Math.min(paramFloat1, paramFloat2);
    paramFloat1 = Math.max(paramFloat1, paramFloat2);
    if (this.a)
    {
      paramFloat2 = paramFloat1;
      if (!this.a) {
        break label68;
      }
    }
    label68:
    for (float f2 = f1;; f2 = paramFloat1)
    {
      setFloatValues(new float[] { paramFloat2, f2 });
      super.setDuration(((float)this.d * (paramFloat1 - f1)));
      return;
      paramFloat2 = f1;
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    a();
  }
  
  public void b(float paramFloat)
  {
    this.c = paramFloat;
    a();
  }
  
  public long getDuration()
  {
    return this.d;
  }
  
  public ValueAnimator setDuration(long paramLong)
  {
    this.d = paramLong;
    a();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gk
 * JD-Core Version:    0.7.0.1
 */