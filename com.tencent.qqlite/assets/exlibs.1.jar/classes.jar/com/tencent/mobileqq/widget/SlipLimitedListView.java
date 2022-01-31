package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class SlipLimitedListView
  extends SlideDetectListView
{
  private Rect a = new Rect();
  
  public SlipLimitedListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    int i;
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      i = 0;
    }
    for (;;)
    {
      View localView;
      if (i < paramView.getChildCount())
      {
        localView = paramView.getChildAt(i);
        if ((localView instanceof WorkSpaceView))
        {
          paramView = (WorkSpaceView)localView;
          paramView.getGlobalVisibleRect(this.a);
        }
      }
      else
      {
        return (paramView.isShown()) && (this.a.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()));
      }
      if (((localView instanceof ViewGroup)) && (a((ViewGroup)localView, paramMotionEvent))) {
        return true;
      }
      i += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2)) && (a(this, paramMotionEvent))) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlipLimitedListView
 * JD-Core Version:    0.7.0.1
 */