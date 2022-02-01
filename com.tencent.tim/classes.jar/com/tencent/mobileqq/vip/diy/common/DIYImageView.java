package com.tencent.mobileqq.vip.diy.common;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class DIYImageView
  extends FrameLayout
{
  private ImageView Fn;
  
  public DIYImageView(Context paramContext)
  {
    super(paramContext);
    this.Fn = new ImageView(paramContext);
    addView(this.Fn);
  }
  
  public ImageView A()
  {
    return this.Fn;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.common.DIYImageView
 * JD-Core Version:    0.7.0.1
 */