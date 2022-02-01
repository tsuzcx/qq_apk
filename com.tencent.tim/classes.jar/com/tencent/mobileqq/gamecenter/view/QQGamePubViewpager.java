package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

public class QQGamePubViewpager
  extends ViewPager
{
  private ViewGroup ba;
  
  public QQGamePubViewpager(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQGamePubViewpager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.ba != null) {
      this.ba.requestDisallowInterceptTouchEvent(true);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.ba != null) {
      this.ba.requestDisallowInterceptTouchEvent(true);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.ba != null) {
      this.ba.requestDisallowInterceptTouchEvent(true);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setNestedpParent(ViewGroup paramViewGroup)
  {
    this.ba = paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager
 * JD-Core Version:    0.7.0.1
 */