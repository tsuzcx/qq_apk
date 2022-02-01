package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class UpScrollHideView
  extends FrameLayout
{
  private a a;
  private int mActivePointerId = -1;
  private int mDeltaY;
  private float mLastMotionY;
  
  public UpScrollHideView(Context paramContext)
  {
    super(paramContext, null);
  }
  
  public UpScrollHideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842880);
  }
  
  public UpScrollHideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        return true;
        this.mLastMotionY = paramMotionEvent.getY();
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        continue;
        int i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if (i != -1)
        {
          float f = paramMotionEvent.getY(i);
          this.mDeltaY = ((int)(this.mLastMotionY - f));
          if (this.mDeltaY > 0) {
            scrollTo(0, this.mDeltaY);
          }
        }
      }
    }
    if (this.mDeltaY > getHeight())
    {
      setVisibility(8);
      if (this.a != null) {
        this.a.ejj();
      }
    }
    for (;;)
    {
      this.mActivePointerId = -1;
      break;
      scrollTo(0, 0);
    }
  }
  
  public void setOnViewHideListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void ejj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.UpScrollHideView
 * JD-Core Version:    0.7.0.1
 */