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
  private Rect Q = new Rect();
  
  public SlipLimitedListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2)) && (p(this, paramMotionEvent))) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected boolean p(View paramView, MotionEvent paramMotionEvent)
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
          paramView.getGlobalVisibleRect(this.Q);
        }
      }
      else
      {
        return (paramView.isShown()) && (this.Q.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()));
      }
      if (((localView instanceof ViewGroup)) && (p((ViewGroup)localView, paramMotionEvent))) {
        return true;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlipLimitedListView
 * JD-Core Version:    0.7.0.1
 */