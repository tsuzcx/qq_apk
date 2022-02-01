package com.tencent.push;

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

public abstract class b
  extends d
{
  private float a = -1.0F;
  private float b = -1.0F;
  private int c;
  private int d;
  private int e = 0;
  
  private TranslateAnimation a(int paramInt)
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
  
  protected final View a(Context paramContext)
  {
    View localView = b();
    paramContext = localView;
    if (localView != null)
    {
      if (!localView.isClickable()) {
        localView.setClickable(true);
      }
      localView.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          boolean bool = false;
          if (paramAnonymousMotionEvent != null) {
            switch (paramAnonymousMotionEvent.getAction())
            {
            default: 
              return false;
            case 2: 
              float f1 = Math.abs(paramAnonymousMotionEvent.getX() - b.b(b.this));
              float f2 = Math.abs(paramAnonymousMotionEvent.getY() - b.c(b.this));
              int j = 2;
              if (f1 >= f2)
              {
                if (f1 > b.d(b.this))
                {
                  if (paramAnonymousMotionEvent.getX() > b.b(b.this))
                  {
                    i = 1;
                    j = 3;
                    break label160;
                  }
                  i = 1;
                  break label160;
                }
              }
              else if (b.c(b.this) - paramAnonymousMotionEvent.getY() > b.e(b.this))
              {
                i = 1;
                j = 1;
                break label160;
              }
              int i = 0;
              if (i != 0)
              {
                b.a(b.this, j);
                paramAnonymousView = b.this;
                paramAnonymousView.b(b.b(paramAnonymousView, b.a(paramAnonymousView)));
                b.this.a(false);
                return true;
              }
              break;
            case 1: 
              if (b.a(b.this) != 0) {
                bool = true;
              }
              return bool;
            case 0: 
              label160:
              b.a(b.this, paramAnonymousMotionEvent.getX());
              b.b(b.this, paramAnonymousMotionEvent.getY());
            }
          }
          return false;
        }
      });
      paramContext = localView;
      if (h())
      {
        paramContext = new FrameLayout(this.o);
        paramContext.addView(localView);
        paramContext.setBackgroundResource(2131100070);
      }
    }
    return paramContext;
  }
  
  protected void a()
  {
    this.c = e.a(this.o, 40.0F);
    this.d = (e.c() / 4);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -this.o.getResources().getDimensionPixelOffset(2131034209), 0.0F);
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setInterpolator(new Interpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        double d1 = Math.pow(2.0D, -10.0F * paramAnonymousFloat);
        double d2 = paramAnonymousFloat - 0.1F;
        Double.isNaN(d2);
        double d3 = 0.4F;
        Double.isNaN(d3);
        return (float)(d1 * Math.sin(d2 * 6.283185307179586D / d3) + 1.0D);
      }
    });
    a(localTranslateAnimation);
    b(a(1));
    super.a();
  }
  
  protected abstract View b();
  
  protected abstract int c();
  
  protected boolean h()
  {
    return true;
  }
  
  protected WindowManager.LayoutParams i()
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
 * Qualified Name:     com.tencent.push.b
 * JD-Core Version:    0.7.0.1
 */