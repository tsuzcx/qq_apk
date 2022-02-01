package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;

public class CustomHorizontalScrollView
  extends HorizontalScrollView
{
  int efx;
  int efy = 3;
  Handler mHandler = new Handler();
  int mHorizontalSpacing = (int)(this.sG + 0.5D);
  int mItemWidth = (int)(this.sG * 70.0F + 0.5D);
  float mLastX;
  float mLastY;
  Runnable mRunnable = new CustomHorizontalScrollView.1(this);
  int mScreenWidth = getResources().getDisplayMetrics().widthPixels;
  int mScrollX = -1;
  float sG = getResources().getDisplayMetrics().density;
  
  public CustomHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CustomHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
      return bool;
    case 0: 
      getParent().requestDisallowInterceptTouchEvent(true);
      this.mLastX = f1;
      this.mLastY = f2;
      return bool;
    }
    if (((this.efy * Math.abs(f1 - this.mLastX) > Math.abs(f2 - this.mLastY)) || ((f1 == this.mLastX) && (f2 == this.mLastY))) && (getScrollX() != 0))
    {
      getParent().requestDisallowInterceptTouchEvent(true);
      return bool;
    }
    getParent().requestDisallowInterceptTouchEvent(false);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      View localView = getChildAt(0);
      if (localView != null) {
        this.efx = localView.getMeasuredWidth();
      }
      this.mHandler.postDelayed(this.mRunnable, 5L);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      super.setOverScrollMode(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomHorizontalScrollView
 * JD-Core Version:    0.7.0.1
 */