package com.tencent.mobileqq.multicard;

import ajjk;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import android.view.ViewParent;
import android.widget.RelativeLayout;

public class MultiCardCustomLayout
  extends RelativeLayout
{
  private boolean coW;
  private View.OnLongClickListener h;
  private GestureDetector mGestureDetector;
  
  public MultiCardCustomLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public MultiCardCustomLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public void Ma(boolean paramBoolean)
  {
    this.coW = paramBoolean;
    if ((this.coW) && (this.mGestureDetector == null)) {
      this.mGestureDetector = new GestureDetector(getContext(), new ajjk(this), new Handler(Looper.getMainLooper()));
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if ((this.coW) && (this.h != null) && (this.mGestureDetector != null))
    {
      this.mGestureDetector.onTouchEvent(paramMotionEvent);
      switch (paramMotionEvent.getActionMasked())
      {
      default: 
        return true;
      }
      getParent().requestDisallowInterceptTouchEvent(true);
      return true;
    }
    return bool;
  }
  
  public void setDispatchTouchEventOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.h = paramOnLongClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardCustomLayout
 * JD-Core Version:    0.7.0.1
 */