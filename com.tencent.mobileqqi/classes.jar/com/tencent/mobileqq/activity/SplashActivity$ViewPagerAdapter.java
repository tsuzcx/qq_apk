package com.tencent.mobileqq.activity;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.Frame;

public class SplashActivity$ViewPagerAdapter
  extends PagerAdapter
{
  public SplashActivity$ViewPagerAdapter(SplashActivity paramSplashActivity) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return 3;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return super.getItemPosition(paramObject);
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return this.a.getString(2131561808);
    case 1: 
      return this.a.getString(2131561870);
    case 2: 
      return this.a.getString(2131562048);
    }
    return this.a.getString(2131562894);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramViewGroup.addView(localView);
      return localView;
      localView = SplashActivity.a(this.a, Conversation.class).a();
      continue;
      localView = SplashActivity.b(this.a, Contacts.class).a();
      continue;
      localView = SplashActivity.c(this.a, Leba.class).a();
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SplashActivity.ViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */