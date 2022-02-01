package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;

public class QQViewPager
  extends ViewPager
{
  private byte A = 0;
  private final int FA;
  private boolean dbl;
  private boolean disable;
  private int downX;
  private int downY;
  
  public QQViewPager(Context paramContext)
  {
    super(paramContext);
    this.FA = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public QQViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.FA = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private void TO(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQViewPager", 2, "doInterceptTouchEvent : " + paramBoolean);
      }
      localViewGroup.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private void Z(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 > this.FA) || (paramFloat2 > this.FA)) {
      if ((paramFloat1 <= this.FA) || (paramFloat2 / paramFloat1 >= 0.6F)) {
        break label79;
      }
    }
    label79:
    for (this.A = 1;; this.A = 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQViewPager", 2, "judgeScrollDirection : mSlideDir -> " + this.A);
      }
      return;
    }
  }
  
  private void af(MotionEvent paramMotionEvent)
  {
    int i;
    int j;
    if (this.disable)
    {
      i = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return;
        this.downX = i;
        this.downY = j;
        return;
        if (this.A == 0) {
          Z(Math.abs(i - this.downX), Math.abs(j - this.downY));
        }
      } while (this.A != 1);
      TO(true);
      return;
    }
    this.A = 0;
    TO(false);
  }
  
  public void TN(boolean paramBoolean)
  {
    this.dbl = paramBoolean;
  }
  
  public void hy(boolean paramBoolean)
  {
    this.disable = paramBoolean;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.disable) {
      af(paramMotionEvent);
    }
    for (;;)
    {
      try
      {
        boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent)
      {
        int i;
        paramMotionEvent.printStackTrace();
      }
      if (this.dbl)
      {
        i = paramMotionEvent.getAction();
        if (i == 0) {
          TO(true);
        } else if ((i == 1) || (i == 3)) {
          TO(false);
        }
      }
    }
    return false;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    af(paramMotionEvent);
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQViewPager
 * JD-Core Version:    0.7.0.1
 */