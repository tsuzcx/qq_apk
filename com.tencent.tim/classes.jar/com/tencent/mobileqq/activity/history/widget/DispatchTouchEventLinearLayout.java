package com.tencent.mobileqq.activity.history.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class DispatchTouchEventLinearLayout
  extends LinearLayout
{
  private a a;
  
  public DispatchTouchEventLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public DispatchTouchEventLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DispatchTouchEventLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null) {
      this.a.S(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setOnDispatchListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void S(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.widget.DispatchTouchEventLinearLayout
 * JD-Core Version:    0.7.0.1
 */