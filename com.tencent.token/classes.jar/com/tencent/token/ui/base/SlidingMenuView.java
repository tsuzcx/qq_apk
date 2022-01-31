package com.tencent.token.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Scroller;

public class SlidingMenuView
  extends ViewGroup
{
  private static String c = "SlidingMenuView";
  public int a = 0;
  int b = 0;
  private int d = 1;
  private int e = this.d;
  private int f = -1;
  private Scroller g = new Scroller(getContext());
  private VelocityTracker h;
  private float i;
  private float j;
  private boolean k;
  private int l = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private da m;
  
  public SlidingMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlidingMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    postDelayed(new cz(this), 1L);
  }
  
  public final int a()
  {
    return this.e;
  }
  
  public final void a(int paramInt)
  {
    int i1 = 1;
    if ((this.a != 1) && (this.m != null)) {
      this.m.a(true);
    }
    int i2 = getChildCount();
    int n = 0;
    while (n < i2)
    {
      getChildAt(n).setDrawingCacheEnabled(true);
      n += 1;
    }
    i2 = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (i2 != this.e) {}
    for (paramInt = i1;; paramInt = 0)
    {
      this.f = i2;
      View localView = getFocusedChild();
      if ((localView != null) && (paramInt != 0) && (localView == getChildAt(this.e))) {
        localView.clearFocus();
      }
      n = 0;
      paramInt = 0;
      while (n < i2)
      {
        paramInt += getChildAt(n).getWidth();
        n += 1;
      }
    }
    n = getScrollX();
    this.g.startScroll(getScrollX(), 0, paramInt - n, 0, Math.abs(100) * 2);
    invalidate();
  }
  
  public final void a(da paramda)
  {
    this.m = paramda;
  }
  
  public final int b()
  {
    return this.f;
  }
  
  public void computeScroll()
  {
    if (this.g.computeScrollOffset()) {
      scrollTo(this.g.getCurrX(), this.g.getCurrY());
    }
    for (;;)
    {
      return;
      if (this.f != -1)
      {
        if (this.m != null) {
          this.m.a(false);
        }
        this.e = Math.max(0, Math.min(this.f, getChildCount() - 1));
        this.f = -1;
        int i1 = getChildCount();
        int n = 0;
        while (n < i1)
        {
          getChildAt(n).setDrawingCacheEnabled(false);
          n += 1;
        }
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int n = getScrollX();
    super.dispatchDraw(paramCanvas);
    paramCanvas.translate(n, 0.0F);
  }
  
  public boolean dispatchUnhandledMove(View paramView, int paramInt)
  {
    if (paramInt == 17)
    {
      if (this.e > 0)
      {
        a(this.e - 1);
        return true;
      }
    }
    else if ((paramInt == 66) && (this.e < getChildCount() - 1))
    {
      a(this.e + 1);
      return true;
    }
    return super.dispatchUnhandledMove(paramView, paramInt);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int n = 0;
    while (n < getChildCount())
    {
      View localView = getChildAt(n);
      localView.setFocusable(true);
      localView.setClickable(true);
      n += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = paramMotionEvent.getAction();
    if ((n == 2) && (this.a != 0)) {}
    for (;;)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      switch (n)
      {
      }
      while ((this.e != 0) || (f1 <= ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth() - ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth() / 6))
      {
        return false;
        n = (int)Math.abs(f1 - this.i);
        int i1 = (int)Math.abs(f2 - this.j);
        int i2 = this.l;
        if (n > i2 * 5)
        {
          n = 1;
          label165:
          if (i1 <= i2) {
            break label253;
          }
        }
        label253:
        for (i1 = 1; (n != 0) || (i1 != 0); i1 = 0)
        {
          if (n == 0) {
            break label259;
          }
          this.a = 1;
          if (this.m != null) {
            this.m.a(true);
          }
          i1 = getChildCount();
          n = 0;
          while (n < i1)
          {
            getChildAt(n).setDrawingCacheEnabled(true);
            n += 1;
          }
          n = 0;
          break label165;
        }
        label259:
        if (this.k)
        {
          this.k = false;
          getChildAt(this.e).cancelLongPress();
          continue;
          this.i = f1;
          this.j = f2;
          this.k = true;
          if (this.g.isFinished()) {}
          for (n = 0;; n = 1)
          {
            this.a = n;
            break;
          }
          i1 = getChildCount();
          n = 0;
          while (n < i1)
          {
            getChildAt(n).setDrawingCacheEnabled(false);
            n += 1;
          }
          this.a = 0;
          this.k = false;
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = getChildCount();
    paramInt1 = 0;
    for (paramInt2 = 0; paramInt1 < paramInt4; paramInt2 = paramInt3)
    {
      View localView = getChildAt(paramInt1);
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        paramInt3 = localView.getMeasuredWidth();
        localView.layout(paramInt2, 0, paramInt2 + paramInt3, localView.getMeasuredHeight());
        paramInt3 = paramInt2 + paramInt3;
      }
      paramInt1 += 1;
    }
    this.b = paramInt2;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    findViewById(2131296641).measure(paramInt1 - ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth() / 6, paramInt2);
    findViewById(2131296643).measure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.h == null) {
      this.h = VelocityTracker.obtain();
    }
    this.h.addMovement(paramMotionEvent);
    int n = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    label163:
    int i1;
    switch (n)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          return true;
          if (!this.g.isFinished()) {
            this.g.abortAnimation();
          }
          this.i = f1;
          return true;
          if ((int)Math.abs(f1 - this.i) > this.l) {}
          for (n = 1; n != 0; n = 0)
          {
            this.a = 1;
            n = (int)(this.i - f1);
            this.i = f1;
            if (n >= 0) {
              break label163;
            }
            if (getScrollX() <= 0) {
              break;
            }
            scrollBy(Math.max(-getScrollX(), n), 0);
            return true;
          }
        } while (n <= 0);
        i1 = getChildAt(getChildCount() - 1).getRight() - getScrollX() - getWidth();
      } while (i1 <= 0);
      scrollBy(Math.min(i1, n), 0);
      return true;
    case 1: 
      if (this.a == 1)
      {
        paramMotionEvent = this.h;
        paramMotionEvent.computeCurrentVelocity(1000);
        n = (int)paramMotionEvent.getXVelocity();
        if ((n > 1000) && (this.e > 0))
        {
          a(this.e - 1);
          if (this.h != null)
          {
            this.h.recycle();
            this.h = null;
          }
        }
      }
      for (;;)
      {
        this.a = 0;
        return true;
        if ((n < -1000) && (this.e < getChildCount() - 1))
        {
          a(this.e + 1);
          break;
        }
        int i5 = getChildCount();
        int i6 = getScrollX();
        int i2 = 0;
        int i3 = 0;
        i1 = 0;
        n = 0;
        while (i2 < i5)
        {
          int i4 = getChildAt(i2).getWidth();
          int i7 = i4 / 2;
          if (i2 != 0) {
            i4 = getChildAt(i2 - 1).getWidth();
          }
          i3 -= i4;
          if ((i6 > i3) && (i6 < i7 + i1)) {
            break;
          }
          i1 += i4;
          n += 1;
          i2 += 1;
        }
        a(n);
        break;
        if ((this.e == 0) && (f1 > ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth() - ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth() / 6)) {
          a(1);
        }
      }
    }
    this.a = 0;
    return true;
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    super.scrollTo(paramInt1, paramInt2);
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.SlidingMenuView
 * JD-Core Version:    0.7.0.1
 */