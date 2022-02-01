package com.tencent.biz.subscribe.other.story;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import rpq;
import sfg;

public class StoryGameSelectorPagerAdapter
  extends PagerAdapter
  implements ViewPager.OnPageChangeListener, View.OnClickListener
{
  private Queue<View> A = new LinkedList();
  private final int OE = 0;
  private a a;
  private List<sfg> mData = new ArrayList();
  private ViewPager mViewPager;
  
  protected void a(b paramb, int paramInt)
  {
    paramb.position = paramInt;
    sfg localsfg = (sfg)this.mData.get(paramInt);
    rpq.a(paramb.nY, localsfg.mIconUrl, this.OE, this.OE, this.mViewPager.getContext().getResources().getDrawable(2130847398), null);
    if ((paramInt == this.mViewPager.getCurrentItem()) || (localsfg.MG()))
    {
      paramb.pN.setVisibility(8);
      return;
    }
    paramb.pN.setVisibility(0);
  }
  
  protected View c(ViewGroup paramViewGroup, int paramInt)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561132, paramViewGroup, false);
  }
  
  protected View d(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.A.isEmpty())
    {
      paramViewGroup = c(paramViewGroup, paramInt);
      paramViewGroup.setTag(new b(paramViewGroup));
      paramViewGroup.setOnClickListener(this);
    }
    for (;;)
    {
      if (paramViewGroup != null) {
        a((b)paramViewGroup.getTag(), paramInt);
      }
      return paramViewGroup;
      paramViewGroup = (View)this.A.poll();
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    ((b)paramObject.getTag()).nY.setImageDrawable(null);
    this.A.offer(paramObject);
    paramViewGroup.removeView(paramObject);
  }
  
  public int getCount()
  {
    return this.mData.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = d(paramViewGroup, paramInt);
    if (localView != null) {
      paramViewGroup.addView(localView);
    }
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onClick(View paramView)
  {
    b localb = (b)paramView.getTag();
    if (this.a != null) {
      this.a.o(localb.position, paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.a != null) {
      this.a.yt(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramInt, (sfg)this.mData.get(paramInt));
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, sfg paramsfg);
    
    public abstract void o(int paramInt, View paramView);
    
    public abstract void yt(int paramInt);
  }
  
  static class b
  {
    public ImageView nY;
    public View pN;
    public int position = -1;
    public View rootView;
    
    public b(View paramView)
    {
      this.rootView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.StoryGameSelectorPagerAdapter
 * JD-Core Version:    0.7.0.1
 */