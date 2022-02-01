package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import apgw;
import rpq;

public class DotStyleNavBar
  extends LinearLayout
{
  private int dUf;
  private int mCurrentIndex;
  private ViewPager.OnPageChangeListener mOnPageChangeListener;
  private ViewPager mViewPager;
  
  public DotStyleNavBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public DotStyleNavBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void WI(int paramInt)
  {
    this.dUf = paramInt;
    removeAllViews();
    dZv();
  }
  
  private void dZv()
  {
    int j = rpq.dip2px(getContext(), 8.0F);
    int k = rpq.dip2px(getContext(), 3.0F);
    int i = 0;
    if (i < this.dUf)
    {
      ImageView localImageView = new ImageView(getContext());
      if (i == this.mCurrentIndex) {
        localImageView.setImageResource(2130849846);
      }
      for (;;)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, j);
        localLayoutParams.leftMargin = k;
        localLayoutParams.rightMargin = k;
        addView(localImageView, localLayoutParams);
        i += 1;
        break;
        localImageView.setImageResource(2130849847);
      }
    }
  }
  
  private void update()
  {
    int i = 0;
    if (i < this.dUf)
    {
      ImageView localImageView = (ImageView)getChildAt(i);
      if (i == this.mCurrentIndex) {
        localImageView.setImageResource(2130849846);
      }
      for (;;)
      {
        i += 1;
        break;
        localImageView.setImageResource(2130849847);
      }
    }
    postInvalidate();
  }
  
  public void setCurrent(int paramInt)
  {
    if (paramInt + 1 > this.dUf) {
      paramInt = this.dUf - 1;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      this.mCurrentIndex = i;
      update();
      return;
    }
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.mOnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.mViewPager = paramViewPager;
    WI(this.mViewPager.getAdapter().getCount());
    this.mViewPager.setOnPageChangeListener(new apgw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.DotStyleNavBar
 * JD-Core Version:    0.7.0.1
 */