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
import com.tencent.token.global.h;
import com.tmsdk.TMSDKContext;

public class SlidingMenuView
  extends ViewGroup
{
  private static String c = "SlidingMenuView";
  public int a = 0;
  int b = 0;
  private int d = 1;
  private int e;
  private int f = -1;
  private Scroller g;
  private VelocityTracker h;
  private float i;
  private float j;
  private boolean k;
  private int l;
  private ct m;
  
  public SlidingMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlidingMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
    postDelayed(new cs(this), 1L);
  }
  
  private void d()
  {
    this.g = new Scroller(getContext());
    this.e = this.d;
    this.l = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  void a()
  {
    int i1 = getChildCount();
    int n = 0;
    while (n < i1)
    {
      getChildAt(n).setDrawingCacheEnabled(true);
      n += 1;
    }
  }
  
  public void a(int paramInt)
  {
    int n = 1;
    if ((this.a != 1) && (this.m != null)) {
      this.m.a(true);
    }
    a();
    int i1 = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (i1 != this.e) {}
    for (paramInt = n;; paramInt = 0)
    {
      this.f = i1;
      View localView = getFocusedChild();
      if ((localView != null) && (paramInt != 0) && (localView == getChildAt(this.e))) {
        localView.clearFocus();
      }
      n = 0;
      paramInt = 0;
      while (n < i1)
      {
        paramInt += getChildAt(n).getWidth();
        n += 1;
      }
    }
    n = getScrollX();
    this.g.startScroll(getScrollX(), 0, paramInt - n, 0, Math.abs(100) * 2);
    invalidate();
    if (i1 == 0) {
      TMSDKContext.saveActionData(1150082);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    findViewById(2131558950).measure(paramInt1 - getScreenWidth() / 6, paramInt2);
    findViewById(2131558952).measure(paramInt1, paramInt2);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.a != 1) && (this.m != null)) {
      this.m.a(true);
    }
    a();
    int i1 = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (i1 != this.e) {}
    int n;
    for (paramInt = 1;; paramInt = 0)
    {
      this.f = i1;
      View localView = getFocusedChild();
      if ((localView != null) && (paramInt != 0) && (localView == getChildAt(this.e))) {
        localView.clearFocus();
      }
      paramInt = 0;
      n = 0;
      while (paramInt < i1)
      {
        n += getChildAt(paramInt).getWidth();
        paramInt += 1;
      }
    }
    paramInt = n - getScrollX();
    if (paramBoolean) {
      this.g.startScroll(getScrollX(), 0, paramInt, 0, 1);
    }
    for (;;)
    {
      invalidate();
      if (i1 == 0) {
        TMSDKContext.saveActionData(1150082);
      }
      return;
      this.g.startScroll(getScrollX(), 0, paramInt, 0, Math.abs(100) * 2);
    }
  }
  
  void b()
  {
    int i1 = getChildCount();
    int n = 0;
    while (n < i1)
    {
      getChildAt(n).setDrawingCacheEnabled(false);
      n += 1;
    }
  }
  
  protected void c()
  {
    int i6 = getChildCount();
    int i7 = getScrollX();
    int i3 = 0;
    int i4 = 0;
    int i1 = 0;
    int i2 = 0;
    int n = 0;
    for (;;)
    {
      int i5;
      if (i3 < i6)
      {
        i5 = getChildAt(i3).getWidth();
        int i8 = i5 / 2;
        if (i3 != 0) {
          i5 = getChildAt(i3 - 1).getWidth();
        }
        i4 -= i5;
        if ((i7 <= i4) || (i7 >= i8 + i1)) {}
      }
      else
      {
        a(n);
        return;
      }
      i2 += i5;
      i1 += i5;
      n += 1;
      i3 += 1;
    }
  }
  
  public void computeScroll()
  {
    if (this.g.computeScrollOffset()) {
      scrollTo(this.g.getCurrX(), this.g.getCurrY());
    }
    while (this.f == -1) {
      return;
    }
    if (this.m != null) {
      this.m.a(false);
    }
    this.e = Math.max(0, Math.min(this.f, getChildCount() - 1));
    this.f = -1;
    b();
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
      if (getCurrentScreen() > 0)
      {
        a(getCurrentScreen() - 1);
        return true;
      }
    }
    else if ((paramInt == 66) && (getCurrentScreen() < getChildCount() - 1))
    {
      a(getCurrentScreen() + 1);
      return true;
    }
    return super.dispatchUnhandledMove(paramView, paramInt);
  }
  
  public int getCurrentScreen()
  {
    return this.e;
  }
  
  public int getNextScreen()
  {
    return this.f;
  }
  
  protected int getScreenWidth()
  {
    return ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
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
    h.a("onInterceptTouchEvent");
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
      while ((this.e != 0) || (f1 <= getScreenWidth() - getScreenWidth() / 6))
      {
        return false;
        int i2 = (int)Math.abs(f1 - this.i);
        int i3 = (int)Math.abs(f2 - this.j);
        int i1 = this.l;
        if (i2 > i1)
        {
          n = 1;
          label135:
          if (i3 <= i1) {
            break label225;
          }
        }
        label225:
        for (i1 = 1; (n != 0) || (i1 != 0); i1 = 0)
        {
          if ((n != 0) && (i2 > i3))
          {
            this.a = 1;
            if (this.m != null) {
              this.m.a(true);
            }
            a();
          }
          if (!this.k) {
            break;
          }
          this.k = false;
          getChildAt(this.e).cancelLongPress();
          break;
          n = 0;
          break label135;
        }
        h.a("mLastMotionX" + this.i);
        this.i = f1;
        this.j = f2;
        this.k = true;
        if (this.g.isFinished()) {}
        for (n = 0;; n = 1)
        {
          this.a = n;
          break;
        }
        b();
        this.a = 0;
        this.k = false;
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
    a(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.h == null) {
      this.h = VelocityTracker.obtain();
    }
    this.h.addMovement(paramMotionEvent);
    int n = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    switch (n)
    {
    default: 
    case 0: 
    case 2: 
      int i1;
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
      label163:
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
        c();
        break;
        if ((this.e == 0) && (f1 > getScreenWidth() - getScreenWidth() / 6)) {
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
  
  public void setCurrentScreen(int paramInt)
  {
    this.e = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    forceLayout();
    invalidate();
  }
  
  public void setStateChangeListener(ct paramct)
  {
    this.m = paramct;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.SlidingMenuView
 * JD-Core Version:    0.7.0.1
 */