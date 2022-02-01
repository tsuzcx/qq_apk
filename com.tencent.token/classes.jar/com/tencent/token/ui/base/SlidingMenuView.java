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
import com.tencent.token.global.g;
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
  private a m;
  
  public SlidingMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlidingMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
    postDelayed(new Runnable()
    {
      public void run()
      {
        SlidingMenuView localSlidingMenuView = SlidingMenuView.this;
        localSlidingMenuView.scrollTo(localSlidingMenuView.findViewById(2131165653).getWidth(), 0);
      }
    }, 1L);
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
    int n = this.a;
    int i1 = 1;
    if (n != 1)
    {
      localObject = this.m;
      if (localObject != null) {
        ((a)localObject).a(true);
      }
    }
    a();
    paramInt = Math.min(paramInt, getChildCount() - 1);
    n = 0;
    int i2 = Math.max(0, paramInt);
    if (i2 != this.e) {
      paramInt = i1;
    } else {
      paramInt = 0;
    }
    this.f = i2;
    Object localObject = getFocusedChild();
    if ((localObject != null) && (paramInt != 0) && (localObject == getChildAt(this.e))) {
      ((View)localObject).clearFocus();
    }
    paramInt = 0;
    while (n < i2)
    {
      paramInt += getChildAt(n).getWidth();
      n += 1;
    }
    n = getScrollX();
    this.g.startScroll(getScrollX(), 0, paramInt - n, 0, Math.abs(100) * 2);
    invalidate();
    if (i2 == 0) {
      TMSDKContext.saveActionData(1150082);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    findViewById(2131165653).measure(paramInt1 - getScreenWidth() / 6, paramInt2);
    findViewById(2131165994).measure(paramInt1, paramInt2);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int i1 = this.a;
    int n = 1;
    if (i1 != 1)
    {
      localObject = this.m;
      if (localObject != null) {
        ((a)localObject).a(true);
      }
    }
    a();
    paramInt = Math.min(paramInt, getChildCount() - 1);
    i1 = 0;
    int i2 = Math.max(0, paramInt);
    if (i2 != this.e) {
      paramInt = n;
    } else {
      paramInt = 0;
    }
    this.f = i2;
    Object localObject = getFocusedChild();
    if ((localObject != null) && (paramInt != 0) && (localObject == getChildAt(this.e))) {
      ((View)localObject).clearFocus();
    }
    n = 0;
    paramInt = i1;
    while (paramInt < i2)
    {
      n += getChildAt(paramInt).getWidth();
      paramInt += 1;
    }
    paramInt = n - getScrollX();
    if (paramBoolean) {
      this.g.startScroll(getScrollX(), 0, paramInt, 0, 1);
    } else {
      this.g.startScroll(getScrollX(), 0, paramInt, 0, Math.abs(100) * 2);
    }
    invalidate();
    if (i2 == 0) {
      TMSDKContext.saveActionData(1150082);
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
    int i5 = getChildCount();
    int i6 = getScrollX();
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int n = 0;
    while (i1 < i5)
    {
      int i4 = getChildAt(i1).getWidth();
      int i7 = i4 / 2;
      if (i1 != 0) {
        i4 = getChildAt(i1 - 1).getWidth();
      }
      i3 -= i4;
      if ((i6 > i3) && (i6 < i7 + i2)) {
        break;
      }
      i2 += i4;
      n += 1;
      i1 += 1;
    }
    a(n);
  }
  
  public void computeScroll()
  {
    if (this.g.computeScrollOffset())
    {
      scrollTo(this.g.getCurrX(), this.g.getCurrY());
      return;
    }
    if (this.f != -1)
    {
      a locala = this.m;
      if (locala != null) {
        locala.a(false);
      }
      this.e = Math.max(0, Math.min(this.f, getChildCount() - 1));
      this.f = -1;
      b();
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
    g.a("onInterceptTouchEvent");
    int n = paramMotionEvent.getAction();
    if ((n == 2) && (this.a != 0)) {
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (n)
    {
    default: 
      break;
    case 2: 
      int i2 = (int)Math.abs(f1 - this.i);
      int i3 = (int)Math.abs(f2 - this.j);
      int i1 = this.l;
      if (i2 > i1) {
        n = 1;
      } else {
        n = 0;
      }
      if (i3 > i1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((n != 0) || (i1 != 0))
      {
        if ((n != 0) && (i2 > i3))
        {
          this.a = 1;
          paramMotionEvent = this.m;
          if (paramMotionEvent != null) {
            paramMotionEvent.a(true);
          }
          a();
        }
        if (this.k)
        {
          this.k = false;
          getChildAt(this.e).cancelLongPress();
        }
      }
      break;
    case 1: 
    case 3: 
      b();
      this.a = 0;
      this.k = false;
      break;
    case 0: 
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("mLastMotionX");
      paramMotionEvent.append(this.i);
      g.a(paramMotionEvent.toString());
      this.i = f1;
      this.j = f2;
      this.k = true;
      this.a = (this.g.isFinished() ^ true);
    }
    return (this.e == 0) && (f1 > getScreenWidth() - getScreenWidth() / 6);
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
        paramInt3 = localView.getMeasuredWidth() + paramInt2;
        localView.layout(paramInt2, 0, paramInt3, localView.getMeasuredHeight());
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
    int i1;
    switch (n)
    {
    default: 
      return true;
    case 3: 
      this.a = 0;
      return true;
    case 2: 
      if ((int)Math.abs(f1 - this.i) > this.l) {
        n = 1;
      } else {
        n = 0;
      }
      if (n != 0)
      {
        this.a = 1;
        n = (int)(this.i - f1);
        this.i = f1;
        if (n < 0)
        {
          if (getScrollX() > 0)
          {
            scrollBy(Math.max(-getScrollX(), n), 0);
            return true;
          }
        }
        else if (n > 0)
        {
          i1 = getChildAt(getChildCount() - 1).getRight() - getScrollX() - getWidth();
          if (i1 > 0)
          {
            scrollBy(Math.min(i1, n), 0);
            return true;
          }
        }
      }
      break;
    case 1: 
      if (this.a == 1)
      {
        paramMotionEvent = this.h;
        paramMotionEvent.computeCurrentVelocity(1000);
        n = (int)paramMotionEvent.getXVelocity();
        if (n > 1000)
        {
          i1 = this.e;
          if (i1 > 0)
          {
            a(i1 - 1);
            break label285;
          }
        }
        if ((n < -1000) && (this.e < getChildCount() - 1)) {
          a(this.e + 1);
        } else {
          c();
        }
        paramMotionEvent = this.h;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.recycle();
          this.h = null;
        }
      }
      else if ((this.e == 0) && (f1 > getScreenWidth() - getScreenWidth() / 6))
      {
        a(1);
      }
      this.a = 0;
      return true;
    case 0: 
      label285:
      if (!this.g.isFinished()) {
        this.g.abortAnimation();
      }
      this.i = f1;
    }
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
  
  public void setStateChangeListener(a parama)
  {
    this.m = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.SlidingMenuView
 * JD-Core Version:    0.7.0.1
 */