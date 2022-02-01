package com.tencent.mobileqq.apollo.debug.log;

import abkq;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class CmGameDebugLogPagerAdapter
  extends PagerAdapter
{
  List<abkq> le = new ArrayList();
  List<String> wk = new ArrayList();
  
  public CmGameDebugLogPagerAdapter(List<abkq> paramList, List<String> paramList1)
  {
    this.le = paramList;
    this.wk = paramList1;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.le.size();
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return (CharSequence)this.wk.get(paramInt);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = ((abkq)this.le.get(paramInt)).getView();
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.log.CmGameDebugLogPagerAdapter
 * JD-Core Version:    0.7.0.1
 */