package com.tencent.qqmail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class TouchFrameLayout
  extends FrameLayout
{
  private boolean mAbleConsume = false;
  
  public TouchFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public TouchFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TouchFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mAbleConsume)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      paramMotionEvent = (Boolean)getTag();
      if (paramMotionEvent != null) {
        return paramMotionEvent.booleanValue();
      }
      return bool;
    }
    return false;
  }
  
  public void setAbleConsume(boolean paramBoolean)
  {
    this.mAbleConsume = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.TouchFrameLayout
 * JD-Core Version:    0.7.0.1
 */