package com.tencent.mobileqq.troop.quickat.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.qphone.base.util.QLog;
import wja;

public class AtPanelTouchController
  extends LinearLayout
{
  private float Ar;
  private boolean EX;
  private a a;
  private boolean cRJ;
  private boolean cRK = true;
  boolean cRL = false;
  private int dfU;
  private boolean mScrollToBottom;
  private Scroller mScroller;
  private int mode = 1;
  
  public AtPanelTouchController(@NonNull Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public AtPanelTouchController(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public AtPanelTouchController(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private int Ca()
  {
    int i = 0;
    int k;
    for (int j = 0; i < getChildCount(); j = k)
    {
      View localView = getChildAt(i);
      k = j;
      if (localView.getVisibility() == 0) {
        k = j + localView.getHeight();
      }
      i += 1;
    }
    this.dfU = j;
    return j / 3;
  }
  
  private void init()
  {
    this.mScroller = new Scroller(getContext());
  }
  
  public static boolean k(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == null) {}
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    do
    {
      return false;
      i = (int)paramMotionEvent.getRawY();
      j = (int)paramMotionEvent.getRawX();
      paramMotionEvent = new int[2];
      paramView.getLocationOnScreen(paramMotionEvent);
      k = paramMotionEvent[0];
      m = paramMotionEvent[1];
      n = paramView.getMeasuredWidth();
      i1 = paramView.getMeasuredHeight();
    } while ((i < m) || (i > i1 + m) || (j < k) || (j > n + k));
    return true;
  }
  
  private boolean o(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.cRJ) {
      return true;
    }
    if ((!this.cRK) || (k(paramView, paramMotionEvent)))
    {
      this.cRJ = true;
      return true;
    }
    return false;
  }
  
  public float J(float paramFloat)
  {
    if (this.cRL) {}
    int i;
    int j;
    for (float f = 0.0F;; f = 20.0F)
    {
      i = wja.dp2px(f, getContext().getResources());
      j = (int)(getScrollY() + paramFloat);
      if (j >= i) {
        break;
      }
      return paramFloat;
    }
    if (j >= i)
    {
      if (this.a != null) {
        this.a.scrollToTop();
      }
      return i - getScrollY();
    }
    return 0.0F;
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if ((this.mScroller != null) && (this.mScroller.computeScrollOffset()))
    {
      scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      invalidate();
    }
    do
    {
      do
      {
        return;
      } while (!this.mScrollToBottom);
      this.mScrollToBottom = false;
    } while (this.a == null);
    this.a.VO(this.mode);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if ((!o(getChildAt(0), paramMotionEvent)) && (this.mode != 1)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    float f1 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      this.EX = false;
      this.Ar = paramMotionEvent.getY();
      super.dispatchTouchEvent(paramMotionEvent);
      return true;
      float f2 = -(f1 - this.Ar);
      float f3 = J(f2);
      if (QLog.isColorLevel()) {
        QLog.d("UUUU", 2, "NKSS=" + f3 + " differ=" + f2);
      }
      if ((this.cRJ) && (f3 != 0.0F)) {
        scrollBy(0, (int)f3);
      }
      for (;;)
      {
        if (Math.abs(f2) > 5.0F) {
          this.EX = true;
        }
        if (this.a != null)
        {
          paramMotionEvent = this.a;
          if (getScrollY() > 0) {
            bool = true;
          }
          paramMotionEvent.QR(bool);
        }
        this.Ar = f1;
        return true;
        if (f3 > 0.0F) {
          scrollBy(0, (int)f3);
        }
      }
      this.cRJ = false;
      if (!this.EX) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
      if (-getScrollY() < Ca()) {}
      for (int i = 1;; i = 0)
      {
        if (i != 1) {
          break label303;
        }
        jX(0);
        break;
      }
      label303:
      if (this.a != null)
      {
        this.mScrollToBottom = true;
        jX(-this.dfU);
      }
    }
  }
  
  public void jX(int paramInt)
  {
    if (this.mScroller != null)
    {
      this.mScroller.startScroll(0, getScrollY(), 0, paramInt - getScrollY());
      invalidate();
      return;
    }
    scrollTo(0, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setAtPanelTouchListener(a parama)
  {
    this.a = parama;
  }
  
  public void setControlLitTongue(boolean paramBoolean)
  {
    this.cRK = paramBoolean;
  }
  
  public void setDisableMinScrollY(boolean paramBoolean)
  {
    this.cRL = paramBoolean;
  }
  
  public void setMode(int paramInt)
  {
    this.mode = paramInt;
  }
  
  public void smoothScrollTo(int paramInt1, int paramInt2)
  {
    if (this.mScroller != null)
    {
      this.mScroller.startScroll(0, getScrollY(), 0, paramInt1 - getScrollY(), paramInt2);
      invalidate();
      return;
    }
    scrollTo(0, paramInt1);
  }
  
  public static abstract interface a
  {
    public abstract void QR(boolean paramBoolean);
    
    public abstract void VO(int paramInt);
    
    public abstract void scrollToTop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController
 * JD-Core Version:    0.7.0.1
 */