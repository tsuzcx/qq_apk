package com.tencent.widget;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public abstract class OneViewPagerAdapter
  extends PagerAdapter
  implements ViewPager.OnPageChangeListener
{
  SparseArray<View> bG = new SparseArray();
  private int etT = 0;
  ViewPager mViewPager;
  
  public OneViewPagerAdapter(ViewPager paramViewPager)
  {
    this.mViewPager = paramViewPager;
  }
  
  public void abk(int paramInt)
  {
    if (paramInt >= getCount()) {}
    View localView;
    do
    {
      return;
      localView = (View)this.bG.get(paramInt);
    } while (localView == null);
    k(localView, paramInt);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
    this.bG.remove(paramInt);
  }
  
  public abstract View getView(int paramInt);
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = getView(paramInt);
    if (localObject == null) {
      localObject = new FrameLayout(paramViewGroup.getContext());
    }
    for (;;)
    {
      if (((ViewPager)paramViewGroup).getCurrentItem() == paramInt) {
        k(localObject, paramInt);
      }
      paramViewGroup.addView((View)localObject);
      this.bG.put(paramInt, localObject);
      return localObject;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public abstract void k(Object paramObject, int paramInt);
  
  public abstract void l(Object paramObject, int paramInt);
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.etT = paramInt;
    if (this.etT == 0)
    {
      int i = this.mViewPager.getCurrentItem();
      paramInt = 0;
      while (paramInt < this.bG.size())
      {
        int j = this.bG.keyAt(paramInt);
        if (j != i)
        {
          View localView = (View)this.bG.valueAt(paramInt);
          if (localView != null) {
            l(localView, j);
          }
        }
        paramInt += 1;
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.etT == 1)
    {
      if (paramInt1 >= this.mViewPager.getCurrentItem()) {
        break label25;
      }
      abk(paramInt1);
    }
    label25:
    while (paramInt1 != this.mViewPager.getCurrentItem()) {
      return;
    }
    abk(paramInt1 + 1);
  }
  
  public void onPageSelected(int paramInt)
  {
    abk(paramInt);
    int i = 0;
    while (i < this.bG.size())
    {
      int j = this.bG.keyAt(i);
      if (j != paramInt)
      {
        View localView = (View)this.bG.valueAt(i);
        if (localView != null) {
          l(localView, j);
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.OneViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */