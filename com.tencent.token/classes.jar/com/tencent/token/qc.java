package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;

public abstract class qc
  extends qe
{
  float o = -1.0F;
  float p = -1.0F;
  int q;
  int r;
  int s = 0;
  
  static TranslateAnimation a(int paramInt)
  {
    TranslateAnimation localTranslateAnimation;
    switch (paramInt)
    {
    default: 
      localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
      break;
    case 3: 
      localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F);
      break;
    case 2: 
      localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, -1.0F, 1, 0.0F, 1, 0.0F);
    }
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setFillAfter(true);
    return localTranslateAnimation;
  }
  
  protected void a()
  {
    this.q = qf.a(this.A, 40.0F);
    this.r = (qf.b() / 4);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -this.A.getResources().getDimensionPixelOffset(2131034209), 0.0F);
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setInterpolator(new Interpolator()
    {
      public final float getInterpolation(float paramAnonymousFloat)
      {
        double d1 = Math.pow(2.0D, -10.0F * paramAnonymousFloat);
        double d2 = paramAnonymousFloat - 0.1F;
        Double.isNaN(d2);
        return (float)(d1 * Math.sin(d2 * 6.283185307179586D / 0.4000000059604645D) + 1.0D);
      }
    });
    this.u = localTranslateAnimation;
    this.v = a(1);
    super.a();
  }
  
  protected abstract View b();
  
  protected abstract int c();
  
  protected final View g()
  {
    View localView = b();
    Object localObject = localView;
    if (localView != null)
    {
      if (!localView.isClickable()) {
        localView.setClickable(true);
      }
      localView.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if (paramAnonymousMotionEvent != null) {
            switch (paramAnonymousMotionEvent.getAction())
            {
            default: 
              return false;
            case 2: 
              float f = Math.abs(paramAnonymousMotionEvent.getX() - qc.this.o);
              if (f >= Math.abs(paramAnonymousMotionEvent.getY() - qc.this.p))
              {
                if (f > qc.this.r)
                {
                  if (paramAnonymousMotionEvent.getX() > qc.this.o)
                  {
                    j = 1;
                    i = 3;
                    break label159;
                  }
                  j = 1;
                  i = 2;
                  break label159;
                }
              }
              else if (qc.this.p - paramAnonymousMotionEvent.getY() > qc.this.q)
              {
                j = 1;
                i = 1;
                break label159;
              }
              int j = 0;
              int i = 0;
              if (j != 0)
              {
                paramAnonymousView = qc.this;
                paramAnonymousView.s = i;
                paramAnonymousView.v = qc.a(paramAnonymousView.s);
                qc.this.a(false);
                return true;
              }
              break;
            case 1: 
              return qc.this.s != 0;
            case 0: 
              label159:
              qc.this.o = paramAnonymousMotionEvent.getX();
              qc.this.p = paramAnonymousMotionEvent.getY();
            }
          }
          return false;
        }
      });
      localObject = new FrameLayout(this.A);
      ((FrameLayout)localObject).addView(localView);
      ((FrameLayout)localObject).setBackgroundResource(2131100071);
    }
    return localObject;
  }
  
  protected final WindowManager.LayoutParams h()
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (Build.VERSION.SDK_INT >= 26) {
      localLayoutParams.type = 2038;
    } else {
      localLayoutParams.type = 2003;
    }
    localLayoutParams.format = 1;
    localLayoutParams.flags = 40;
    localLayoutParams.gravity = 48;
    localLayoutParams.height = c();
    return localLayoutParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qc
 * JD-Core Version:    0.7.0.1
 */