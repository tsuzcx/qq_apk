package com.tencent.widget;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public abstract interface PageIndicator
  extends ViewPager.OnPageChangeListener
{
  public abstract void a();
  
  public abstract void setCurrentItem(int paramInt);
  
  public abstract void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener);
  
  public abstract void setViewPager(ViewPager paramViewPager);
  
  public abstract void setViewPager(ViewPager paramViewPager, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.PageIndicator
 * JD-Core Version:    0.7.0.1
 */