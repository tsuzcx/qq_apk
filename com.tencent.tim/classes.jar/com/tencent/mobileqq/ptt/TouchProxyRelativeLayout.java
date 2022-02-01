package com.tencent.mobileqq.ptt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class TouchProxyRelativeLayout
  extends RelativeLayout
{
  public a a;
  
  public TouchProxyRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public TouchProxyRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TouchProxyRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    a locala = this.a;
    boolean bool1 = false;
    if (locala != null) {
      bool1 = locala.an(paramMotionEvent);
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = super.dispatchTouchEvent(paramMotionEvent);
    }
    return bool2;
  }
  
  public static abstract interface a
  {
    public abstract boolean an(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.TouchProxyRelativeLayout
 * JD-Core Version:    0.7.0.1
 */