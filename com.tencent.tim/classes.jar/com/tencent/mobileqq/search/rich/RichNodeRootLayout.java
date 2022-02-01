package com.tencent.mobileqq.search.rich;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.LinearLayout;

public class RichNodeRootLayout
  extends LinearLayout
{
  private a a;
  private boolean bgE;
  private GestureDetector mGestureDetector;
  
  public RichNodeRootLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public RichNodeRootLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public RichNodeRootLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mGestureDetector != null) {
      this.mGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.a != null) {
      this.a.dOv();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    if (this.bgE)
    {
      i = paramMotionEvent.getActionMasked();
      if (i != 0) {
        break label32;
      }
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      label32:
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void setDisableParentReturn(boolean paramBoolean)
  {
    this.bgE = paramBoolean;
  }
  
  public void setEventHandler(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void dOv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.RichNodeRootLayout
 * JD-Core Version:    0.7.0.1
 */