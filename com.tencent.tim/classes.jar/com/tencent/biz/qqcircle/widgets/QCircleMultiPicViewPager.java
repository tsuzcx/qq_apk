package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class QCircleMultiPicViewPager
  extends ViewPager
{
  private int mTouchSlop;
  private float startX;
  private float startY;
  
  public QCircleMultiPicViewPager(Context paramContext)
  {
    super(paramContext);
    initParams();
  }
  
  public QCircleMultiPicViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initParams();
  }
  
  private void initParams()
  {
    this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
  }
  
  public boolean HX()
  {
    return getAdapter().getCount() > 1;
  }
  
  public boolean T(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (getCurrentItem() == 0) {}
    }
    while (getCurrentItem() != getAdapter().getCount() - 1)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
    case 0: 
      for (;;)
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        this.startY = paramMotionEvent.getRawY();
        this.startX = paramMotionEvent.getRawX();
      }
    }
    float f2 = paramMotionEvent.getRawY();
    float f1 = Math.abs(paramMotionEvent.getRawX() - this.startX);
    f2 = Math.abs(f2 - this.startY);
    return (f1 > this.mTouchSlop) || (f2 > this.mTouchSlop);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleMultiPicViewPager
 * JD-Core Version:    0.7.0.1
 */