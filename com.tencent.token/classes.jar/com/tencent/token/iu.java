package com.tencent.token;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public abstract class iu
  implements View.OnAttachStateChangeListener, View.OnTouchListener
{
  private final float a;
  private final int b;
  final View c;
  private final int d;
  private Runnable e;
  private Runnable f;
  private boolean g;
  private int h;
  private final int[] i = new int[2];
  
  public iu(View paramView)
  {
    this.c = paramView;
    paramView.setLongClickable(true);
    paramView.addOnAttachStateChangeListener(this);
    this.a = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.b = ViewConfiguration.getTapTimeout();
    this.d = ((this.b + ViewConfiguration.getLongPressTimeout()) / 2);
  }
  
  private void e()
  {
    Runnable localRunnable = this.f;
    if (localRunnable != null) {
      this.c.removeCallbacks(localRunnable);
    }
    localRunnable = this.e;
    if (localRunnable != null) {
      this.c.removeCallbacks(localRunnable);
    }
  }
  
  public abstract hx a();
  
  protected boolean b()
  {
    hx localhx = a();
    if ((localhx != null) && (!localhx.d())) {
      localhx.b();
    }
    return true;
  }
  
  protected boolean c()
  {
    hx localhx = a();
    if ((localhx != null) && (localhx.d())) {
      localhx.c();
    }
    return true;
  }
  
  final void d()
  {
    e();
    View localView = this.c;
    if (localView.isEnabled())
    {
      if (localView.isLongClickable()) {
        return;
      }
      if (!b()) {
        return;
      }
      localView.getParent().requestDisallowInterceptTouchEvent(true);
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      localView.onTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      this.g = true;
      return;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool3 = this.g;
    boolean bool1;
    int j;
    boolean bool2;
    if (bool3)
    {
      paramView = this.c;
      Object localObject = a();
      if ((localObject != null) && (((hx)localObject).d()))
      {
        localObject = (is)((hx)localObject).e();
        if ((localObject != null) && (((is)localObject).isShown()))
        {
          MotionEvent localMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
          int[] arrayOfInt = this.i;
          paramView.getLocationOnScreen(arrayOfInt);
          localMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
          paramView = this.i;
          ((View)localObject).getLocationOnScreen(paramView);
          localMotionEvent.offsetLocation(-paramView[0], -paramView[1]);
          bool1 = ((is)localObject).a(localMotionEvent, this.h);
          localMotionEvent.recycle();
          j = paramMotionEvent.getActionMasked();
          if ((j != 1) && (j != 3)) {
            j = 1;
          } else {
            j = 0;
          }
          if ((bool1) && (j != 0)) {
            j = 1;
          } else {
            j = 0;
          }
        }
        else
        {
          j = 0;
        }
      }
      else
      {
        j = 0;
      }
      if ((j == 0) && (c())) {
        bool2 = false;
      } else {
        bool2 = true;
      }
    }
    else
    {
      paramView = this.c;
      if (paramView.isEnabled()) {
        switch (paramMotionEvent.getActionMasked())
        {
        default: 
          break;
        case 2: 
          j = paramMotionEvent.findPointerIndex(this.h);
          if (j >= 0)
          {
            float f1 = paramMotionEvent.getX(j);
            float f2 = paramMotionEvent.getY(j);
            float f3 = this.a;
            float f4 = -f3;
            if ((f1 >= f4) && (f2 >= f4) && (f1 < paramView.getRight() - paramView.getLeft() + f3) && (f2 < paramView.getBottom() - paramView.getTop() + f3)) {
              j = 1;
            } else {
              j = 0;
            }
            if (j == 0)
            {
              e();
              paramView.getParent().requestDisallowInterceptTouchEvent(true);
              j = 1;
            }
          }
          break;
        case 1: 
        case 3: 
          e();
          break;
        case 0: 
          this.h = paramMotionEvent.getPointerId(0);
          if (this.e == null) {
            this.e = new a();
          }
          paramView.postDelayed(this.e, this.b);
          if (this.f == null) {
            this.f = new b();
          }
          paramView.postDelayed(this.f, this.d);
        }
      }
      j = 0;
      if ((j != 0) && (b())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 = bool1;
      if (bool1)
      {
        long l = SystemClock.uptimeMillis();
        paramView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        this.c.onTouchEvent(paramView);
        paramView.recycle();
        bool2 = bool1;
      }
    }
    this.g = bool2;
    if (!bool2) {
      return bool3;
    }
    return true;
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.g = false;
    this.h = -1;
    paramView = this.e;
    if (paramView != null) {
      this.c.removeCallbacks(paramView);
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      ViewParent localViewParent = iu.this.c.getParent();
      if (localViewParent != null) {
        localViewParent.requestDisallowInterceptTouchEvent(true);
      }
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      iu.this.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.iu
 * JD-Core Version:    0.7.0.1
 */