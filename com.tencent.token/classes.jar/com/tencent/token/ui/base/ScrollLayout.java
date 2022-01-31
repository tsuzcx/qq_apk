package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Scroller;
import com.tencent.token.m;

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
  private cv j;
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
    this.l = paramContext.obtainStyledAttributes(paramAttributeSet, m.a).getBoolean(0, false);
    this.c = this.d;
    this.f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private void b(int paramInt)
  {
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (getScrollX() != getWidth() * paramInt)
    {
      int m = getWidth();
      int n = getScrollX();
      this.a.startScroll(getScrollX(), getTop(), m * paramInt - n, getTop(), 200);
      this.c = paramInt;
      if (this.j != null) {
        this.j.a(this.c);
      }
      invalidate();
    }
  }
  
  public final void a(int paramInt)
  {
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.c = paramInt;
    scrollTo(paramInt * getWidth(), getTop());
  }
  
  public final void a(cv paramcv)
  {
    this.j = paramcv;
  }
  
  public void computeScroll()
  {
    if (this.a.computeScrollOffset())
    {
      scrollTo(this.a.getCurrX(), this.a.getCurrY());
      postInvalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    if ((m == 2) && (this.e != 0)) {}
    for (;;)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      switch (m)
      {
      }
      while (this.e == 0)
      {
        return false;
        if ((int)Math.abs(this.g - f1) > this.f)
        {
          this.e = 1;
          continue;
          this.g = f1;
          this.h = f2;
          if (this.a.isFinished()) {}
          for (m = 0;; m = 1)
          {
            this.e = m;
            break;
          }
          this.e = 0;
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = 0;
    if (paramBoolean)
    {
      paramInt4 = getChildCount();
      paramInt2 = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getHeight();
      if (this.l) {}
      for (this.i = 0;; this.i = (paramInt2 * 12 / 100)) {
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
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    View.MeasureSpec.getSize(paramInt1);
    View.MeasureSpec.getMode(paramInt1);
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
    if ((f2 < this.i) || (f2 > this.i + this.k)) {
      return false;
    }
    switch (m)
    {
    }
    for (;;)
    {
      return true;
      if (!this.a.isFinished()) {
        this.a.abortAnimation();
      }
      this.g = f1;
      continue;
      m = (int)(this.g - f1);
      if (((this.c == 0) && (m < 0) && (getScrollX() < -getWidth() / 5)) || ((this.c == getChildCount() - 1) && (m > 0) && (getScrollX() > getWidth() / 5 + getWidth() * (getChildCount() - 1)))) {
        break;
      }
      this.g = f1;
      scrollBy(m, 0);
      continue;
      paramMotionEvent = this.b;
      paramMotionEvent.computeCurrentVelocity(1000);
      m = (int)paramMotionEvent.getXVelocity();
      if ((m > 600) && (this.c > 0)) {
        b(this.c - 1);
      }
      for (;;)
      {
        if (this.b != null)
        {
          this.b.recycle();
          this.b = null;
        }
        this.e = 0;
        break;
        if ((m < -600) && (this.c < getChildCount() - 1))
        {
          b(this.c + 1);
        }
        else
        {
          m = getWidth();
          b((getScrollX() + m / 2) / m);
        }
      }
      this.e = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ScrollLayout
 * JD-Core Version:    0.7.0.1
 */