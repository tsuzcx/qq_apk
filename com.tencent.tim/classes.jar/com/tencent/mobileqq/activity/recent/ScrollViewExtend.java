package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.widget.ScrollView;

public class ScrollViewExtend
  extends ScrollView
{
  private float fu;
  private float fw;
  private float xDistance;
  private float yDistance;
  
  public ScrollViewExtend(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScrollViewExtend(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrollViewExtend(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    try
    {
      setFillViewport(true);
      setFadingEdgeLength(0);
      setHorizontalFadingEdgeEnabled(false);
      setVerticalFadingEdgeEnabled(false);
      setHorizontalScrollBarEnabled(false);
      setVerticalScrollBarEnabled(false);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        this.yDistance = 0.0F;
        this.xDistance = 0.0F;
        this.fu = paramMotionEvent.getX();
        this.fw = paramMotionEvent.getY();
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.xDistance += Math.abs(f1 - this.fu);
      this.yDistance += Math.abs(f2 - this.fw);
      this.fu = f1;
      this.fw = f2;
    } while (this.xDistance <= this.yDistance);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.ScrollViewExtend
 * JD-Core Version:    0.7.0.1
 */