package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class IgnoreTouchXViewPager
  extends XViewPager
{
  private boolean aDz;
  
  public IgnoreTouchXViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public IgnoreTouchXViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean E(MotionEvent paramMotionEvent)
  {
    this.aDz = true;
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    this.aDz = false;
    return bool;
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.aDz) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.aDz) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.IgnoreTouchXViewPager
 * JD-Core Version:    0.7.0.1
 */