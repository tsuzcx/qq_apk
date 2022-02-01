package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

public class MonitorSizeChangeHSV
  extends HorizontalScrollView
{
  private a b;
  
  public MonitorSizeChangeHSV(Context paramContext)
  {
    super(paramContext);
  }
  
  public MonitorSizeChangeHSV(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean canScroll()
  {
    boolean bool2 = false;
    View localView = getChildAt(0);
    boolean bool1 = bool2;
    if (localView != null)
    {
      int i = localView.getWidth();
      bool1 = bool2;
      if (getWidth() < i + getPaddingLeft() + getPaddingLeft()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewGroup localViewGroup;
    if (canScroll())
    {
      if (paramMotionEvent.getAction() != 0) {
        break label37;
      }
      localViewGroup = (ViewGroup)getParent();
      if (localViewGroup != null) {
        localViewGroup.requestDisallowInterceptTouchEvent(true);
      }
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      label37:
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
      {
        localViewGroup = (ViewGroup)getParent();
        if (localViewGroup != null) {
          localViewGroup.requestDisallowInterceptTouchEvent(false);
        }
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.b != null) {
      this.b.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setOnSizeChangeCallback(a parama)
  {
    this.b = parama;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      super.setOverScrollMode(2);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MonitorSizeChangeHSV
 * JD-Core Version:    0.7.0.1
 */