package com.tencent.gdtad.views.viewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class GdtViewPagerAdapter<T extends View>
  extends PagerAdapter
{
  private List<T> viewList;
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.viewList.get(paramInt));
  }
  
  public int getCount()
  {
    return this.viewList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.addView((View)this.viewList.get(paramInt));
    return this.viewList.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.viewpager.GdtViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */