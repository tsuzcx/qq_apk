package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import ankt;

public class NestViewPager
  extends QQViewPager
{
  private boolean ast;
  private int mTouchDownX;
  private int mTouchDownY;
  
  public NestViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public NestViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.mTouchDownX = ((int)(paramMotionEvent.getX() + 0.5F));
      this.mTouchDownY = ((int)(paramMotionEvent.getY() + 0.5F));
      this.ast = true;
      i = 0;
      if (i != 0) {}
    }
    try
    {
      boolean bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramMotionEvent)
    {
      int j;
      int k;
      return false;
    }
    if (i == 2)
    {
      i = (int)(paramMotionEvent.getX() + 0.5F);
      j = (int)(paramMotionEvent.getY() + 0.5F);
      i = Math.abs(i - this.mTouchDownX);
      j = Math.abs(j - this.mTouchDownY);
      k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      if ((!this.ast) || (i <= k)) {
        break label184;
      }
      if ((j / i >= 0.6F) || (this.mTouchDownX <= (int)(ankt.SCREEN_WIDTH * 0.1F))) {
        break label192;
      }
    }
    label184:
    label192:
    for (i = 1;; i = 0)
    {
      this.ast = false;
      break;
      if ((i == 1) || (i == 3)) {
        this.ast = false;
      }
      i = 0;
      break;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {}
    for (;;)
    {
      try
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent) {}
      if ((i == 1) || (i == 3)) {
        this.ast = false;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NestViewPager
 * JD-Core Version:    0.7.0.1
 */