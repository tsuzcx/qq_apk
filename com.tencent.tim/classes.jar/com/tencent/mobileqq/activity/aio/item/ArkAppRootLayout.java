package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import wzq;

public class ArkAppRootLayout
  extends RelativeLayout
{
  private a a;
  private boolean bgE;
  private GestureDetector mGestureDetector;
  
  public ArkAppRootLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ArkAppRootLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public ArkAppRootLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mGestureDetector = new GestureDetector(paramContext, new wzq(this));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mGestureDetector != null) {
      this.mGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
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
  
  public void setCallback(a parama)
  {
    this.a = parama;
  }
  
  public void setDisableParentReturn(boolean paramBoolean)
  {
    this.bgE = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void cdB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout
 * JD-Core Version:    0.7.0.1
 */