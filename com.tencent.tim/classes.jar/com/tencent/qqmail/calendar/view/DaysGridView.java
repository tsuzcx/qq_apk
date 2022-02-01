package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.GridView;

public class DaysGridView
  extends GridView
{
  public DaysGridView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DaysGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DaysGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public AbsDayView findSelectedView()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      AbsDayView localAbsDayView = (AbsDayView)getChildAt(i);
      if ((localAbsDayView.getContentVisiblity() == 0) && (localAbsDayView.hasSelected())) {
        return localAbsDayView;
      }
      i += 1;
    }
    return null;
  }
  
  public AbsDayView findTodayView()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      AbsDayView localAbsDayView = (AbsDayView)getChildAt(i);
      if ((localAbsDayView.getContentVisiblity() == 0) && (localAbsDayView.mIsToday)) {
        return localAbsDayView;
      }
      i += 1;
    }
    return null;
  }
  
  public AbsDayView getFirstDayView()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      AbsDayView localAbsDayView = (AbsDayView)getChildAt(i);
      if (localAbsDayView.getContentVisiblity() == 0) {
        return localAbsDayView;
      }
      i += 1;
    }
    return null;
  }
  
  public int getMonth()
  {
    return ((DaysGridAdapter)getAdapter()).getMonth();
  }
  
  public AbsDayView getSelectView()
  {
    return ((DaysGridAdapter)getAdapter()).getSelectView();
  }
  
  public int getYear()
  {
    return ((DaysGridAdapter)getAdapter()).getYear();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    requestLayout();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l1 = System.currentTimeMillis();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    long l2 = System.currentTimeMillis();
    Log.i("wuziyi", "DaysGridView onLayout:" + (l2 - l1));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.DaysGridView
 * JD-Core Version:    0.7.0.1
 */