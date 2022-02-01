package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class CustomViewPager
  extends ViewPager
{
  public float mLastX;
  public float mLastY;
  float mStartDragX;
  public float mf;
  public float mg;
  float xB;
  
  public CustomViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public CustomViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getCurrentItem()
  {
    if ((getAdapter() instanceof VideoPlayerPagerAdapter))
    {
      VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = (VideoPlayerPagerAdapter)getAdapter();
      int i = super.getCurrentItem();
      return localVideoPlayerPagerAdapter.dlI + (i - 50);
    }
    return super.getCurrentItem();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int j;
    int i;
    if ((getAdapter() instanceof VideoPlayerPagerAdapter))
    {
      VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = (VideoPlayerPagerAdapter)getAdapter();
      j = super.getCurrentItem() - 50 + localVideoPlayerPagerAdapter.dlI;
      i = localVideoPlayerPagerAdapter.jG.size();
    }
    for (;;)
    {
      switch (paramMotionEvent.getAction())
      {
      case 1: 
      default: 
        bool = super.onInterceptTouchEvent(paramMotionEvent);
      }
      label136:
      do
      {
        float f;
        do
        {
          return bool;
          this.xB = paramMotionEvent.getX();
          break;
          f = paramMotionEvent.getX();
          if ((this.xB >= f) || (j > 0)) {
            break label136;
          }
        } while (!QLog.isColorLevel());
        QLog.d("CustomViewPager", 2, " 右滑到头");
        return false;
        if ((this.xB <= f) || (j < i - 1)) {
          break label169;
        }
      } while (!QLog.isColorLevel());
      QLog.d("CustomViewPager", 2, " 左滑到头");
      return false;
      label169:
      return super.onInterceptTouchEvent(paramMotionEvent);
      i = 0;
      j = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
    case 0: 
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        this.mg = 0.0F;
        this.mf = 0.0F;
        this.mLastX = paramMotionEvent.getX();
        this.mLastY = paramMotionEvent.getY();
        this.mStartDragX = this.mLastX;
      }
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    this.mf += Math.abs(f1 - this.mLastX);
    this.mg += Math.abs(f2 - this.mLastY);
    this.mLastX = f1;
    this.mLastY = f2;
    if (this.mf <= this.mg)
    {
      getParent().requestDisallowInterceptTouchEvent(false);
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCurrentItem(int paramInt)
  {
    if ((getAdapter() instanceof VideoPlayerPagerAdapter))
    {
      super.setCurrentItem(paramInt + 50 - ((VideoPlayerPagerAdapter)getAdapter()).dlI);
      return;
    }
    super.setCurrentItem(paramInt);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    if ((getAdapter() instanceof VideoPlayerPagerAdapter))
    {
      super.setCurrentItem(paramInt + 50 - ((VideoPlayerPagerAdapter)getAdapter()).dlI, paramBoolean);
      return;
    }
    super.setCurrentItem(paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.CustomViewPager
 * JD-Core Version:    0.7.0.1
 */