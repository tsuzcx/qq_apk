package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;

public class ReminderViewPager
  extends ViewPager
{
  private int lastX = -1;
  private int lastY = -1;
  
  public ReminderViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReminderViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        i = (int)paramMotionEvent.getRawX();
        j = (int)paramMotionEvent.getRawY();
        switch (paramMotionEvent.getAction())
        {
        case 1: 
        case 3: 
          return super.dispatchTouchEvent(paramMotionEvent);
        }
      }
      catch (Throwable paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
        return false;
      }
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      if (Math.abs(i - this.lastX) + 0 >= Math.abs(j - this.lastY) + 0) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      for (;;)
      {
        this.lastX = i;
        this.lastY = j;
        break;
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderViewPager
 * JD-Core Version:    0.7.0.1
 */