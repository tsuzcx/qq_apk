package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Scroller;
import com.tencent.token.rr.a;

public class ScrollLayout
  extends ViewGroup
{
  private Scroller a;
  private VelocityTracker b;
  private int c;
  private int d = 0;
  private int e = 0;
  private int f;
  private float g;
  private float h;
  private int i;
  private a j;
  private int k;
  private boolean l;
  
  public ScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = new Scroller(paramContext);
    this.l = paramContext.obtainStyledAttributes(paramAttributeSet, rr.a.scrolllayout).getBoolean(0, false);
    this.c = this.d;
    this.f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private void a(int paramInt)
  {
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (getScrollX() != getWidth() * paramInt)
    {
      int m = getWidth();
      int n = getScrollX();
      this.a.startScroll(getScrollX(), getTop(), m * paramInt - n, getTop(), 200);
      this.c = paramInt;
      a locala = this.j;
      if (locala != null) {
        locala.a(this.c);
      }
      invalidate();
    }
  }
  
  public void computeScroll()
  {
    if (this.a.computeScrollOffset())
    {
      scrollTo(this.a.getCurrX(), this.a.getCurrY());
      postInvalidate();
    }
  }
  
  public int getCurScreen()
  {
    return this.c;
  }
  
  protected int getScreenHeight()
  {
    return ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getHeight();
  }
  
  protected int getScreenWidth()
  {
    return ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    if ((m == 2) && (this.e != 0)) {
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (m)
    {
    default: 
      break;
    case 2: 
      if ((int)Math.abs(this.g - f1) > this.f) {
        this.e = 1;
      }
      break;
    case 1: 
    case 3: 
      this.e = 0;
      break;
    case 0: 
      this.g = f1;
      this.h = f2;
      this.e = (this.a.isFinished() ^ true);
    }
    return this.e != 0;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      paramInt4 = getChildCount();
      paramInt2 = getScreenHeight();
      paramBoolean = this.l;
      paramInt1 = 0;
      if (paramBoolean) {
        this.i = 0;
      } else {
        this.i = (paramInt2 * 12 / 100);
      }
      for (paramInt2 = 0; paramInt1 < paramInt4; paramInt2 = paramInt3)
      {
        View localView = getChildAt(paramInt1);
        paramInt3 = paramInt2;
        if (localView.getVisibility() != 8)
        {
          this.k = localView.getMeasuredHeight();
          localView.layout(paramInt2, this.i, getWidth() + paramInt2, this.i + this.k);
          paramInt3 = paramInt2 + getWidth();
        }
        paramInt1 += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int n = getChildCount();
    int m = 0;
    while (m < n)
    {
      getChildAt(m).measure(paramInt1, paramInt2);
      m += 1;
    }
    scrollTo(this.c * getWidth(), getTop());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b == null) {
      this.b = VelocityTracker.obtain();
    }
    this.b.addMovement(paramMotionEvent);
    int m = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int n = this.i;
    if (f2 >= n)
    {
      if (f2 > n + this.k) {
        return false;
      }
      switch (m)
      {
      default: 
        return true;
      case 3: 
        this.e = 0;
        return true;
      case 2: 
        m = (int)(this.g - f1);
        if ((this.c == 0) && (m < 0) && (getScrollX() < -getWidth() / 5)) {
          return false;
        }
        if ((this.c == getChildCount() - 1) && (m > 0) && (getScrollX() > getWidth() / 5 + getWidth() * (getChildCount() - 1))) {
          return false;
        }
        this.g = f1;
        scrollBy(m, 0);
        return true;
      case 1: 
        paramMotionEvent = this.b;
        paramMotionEvent.computeCurrentVelocity(1000);
        m = (int)paramMotionEvent.getXVelocity();
        if (m > 600)
        {
          n = this.c;
          if (n > 0)
          {
            a(n - 1);
            break label310;
          }
        }
        if ((m < -600) && (this.c < getChildCount() - 1))
        {
          a(this.c + 1);
        }
        else
        {
          m = getWidth();
          a((getScrollX() + m / 2) / m);
        }
        label310:
        paramMotionEvent = this.b;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.recycle();
          this.b = null;
        }
        this.e = 0;
        return true;
      }
      if (!this.a.isFinished()) {
        this.a.abortAnimation();
      }
      this.g = f1;
      return true;
    }
    return false;
  }
  
  public void setOnScrollListner(a parama)
  {
    this.j = parama;
  }
  
  public void setToScreen(int paramInt)
  {
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.c = paramInt;
    scrollTo(paramInt * getWidth(), getTop());
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ScrollLayout
 * JD-Core Version:    0.7.0.1
 */