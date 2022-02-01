package com.tencent.qqmail.attachment.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class CustomViewPager
  extends ViewPager
{
  private boolean isPagingEnabled = true;
  
  public CustomViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean isPagingEnable()
  {
    return this.isPagingEnabled;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.isPagingEnabled) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.isPagingEnabled) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public void setPagingEnable(boolean paramBoolean)
  {
    this.isPagingEnabled = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.view.CustomViewPager
 * JD-Core Version:    0.7.0.1
 */