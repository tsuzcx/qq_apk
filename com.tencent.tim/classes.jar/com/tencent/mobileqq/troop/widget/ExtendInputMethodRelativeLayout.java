package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;

public class ExtendInputMethodRelativeLayout
  extends InputMethodRelativeLayout
{
  private a a;
  
  public ExtendInputMethodRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if ((this.a == null) || (!this.a.onDown(paramMotionEvent))) {}
    }
    else {
      while ((this.a != null) && (this.a.n(paramMotionEvent))) {
        return true;
      }
    }
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return true;
  }
  
  public void setOnDownListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract boolean n(MotionEvent paramMotionEvent);
    
    public abstract boolean onDown(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.ExtendInputMethodRelativeLayout
 * JD-Core Version:    0.7.0.1
 */