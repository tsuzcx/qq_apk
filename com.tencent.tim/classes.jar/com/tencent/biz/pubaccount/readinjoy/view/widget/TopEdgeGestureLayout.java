package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import aqcx;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;

public class TopEdgeGestureLayout
  extends TopGestureLayout
{
  private int bce;
  private int bcf;
  private float jM;
  private float jN;
  
  public TopEdgeGestureLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TopEdgeGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopEdgeGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    doInit();
  }
  
  private void doInit()
  {
    this.bce = aqcx.dip2px(getContext(), 25.0F);
    this.bcf = ViewConfiguration.getTouchSlop();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jM = paramMotionEvent.getY();
      this.jN = paramMotionEvent.getX();
    }
    while (paramMotionEvent.getAction() != 2) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i = getWidth();
    if (((this.jN < this.bce) || (Math.abs(i - this.jN) < this.bce)) && (Math.abs(this.jN - paramMotionEvent.getX()) > this.bcf)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.TopEdgeGestureLayout
 * JD-Core Version:    0.7.0.1
 */