package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

public class TouchableLinearLayout
  extends LinearLayout
{
  private View.OnTouchListener mTouchListener;
  
  public TouchableLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public TouchableLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public TouchableLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mTouchListener != null) {
      this.mTouchListener.onTouch(this, paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.mTouchListener = paramOnTouchListener;
    super.setOnTouchListener(paramOnTouchListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TouchableLinearLayout
 * JD-Core Version:    0.7.0.1
 */