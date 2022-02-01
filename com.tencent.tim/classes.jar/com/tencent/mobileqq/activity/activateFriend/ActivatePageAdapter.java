package com.tencent.mobileqq.activity.activateFriend;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.util.WeakReference;

public class ActivatePageAdapter
  extends PagerAdapter
{
  private WeakReference<ViewPager> Z;
  private ArrayList<ActivateBasePage> pY = new ArrayList();
  
  public ActivatePageAdapter(ViewPager paramViewPager)
  {
    this.Z = new WeakReference(paramViewPager);
  }
  
  public void BX(int paramInt)
  {
    if ((this.pY == null) || (this.pY.isEmpty())) {}
    ActivateBasePage localActivateBasePage;
    do
    {
      do
      {
        return;
      } while ((paramInt < 0) || (paramInt >= this.pY.size()));
      localActivateBasePage = (ActivateBasePage)this.pY.get(paramInt);
    } while (localActivateBasePage == null);
    localActivateBasePage.KR();
  }
  
  public void a(ActivateBasePage paramActivateBasePage)
  {
    this.pY.add(paramActivateBasePage);
    notifyDataSetChanged();
  }
  
  public ArrayList<ActivateBasePage> bF()
  {
    return this.pY;
  }
  
  public void bYe()
  {
    if ((this.Z == null) || (this.Z.get() == null)) {
      return;
    }
    ((ViewPager)this.Z.get()).setAdapter(null);
    this.pY.clear();
    ((ViewPager)this.Z.get()).setAdapter(this);
  }
  
  public void destroy()
  {
    Iterator localIterator = this.pY.iterator();
    while (localIterator.hasNext()) {
      ((ActivateBasePage)localIterator.next()).destroy();
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivatePageAdapter", 4, "destroy item");
    }
    paramObject = (ActivateBasePage)this.pY.get(paramInt);
    paramObject.destroy();
    paramViewGroup.removeView(paramObject);
  }
  
  public int getCount()
  {
    return this.pY.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    ActivateBasePage localActivateBasePage = (ActivateBasePage)this.pY.get(paramInt);
    if (localActivateBasePage.getParent() != null)
    {
      ((ViewGroup)localActivateBasePage.getParent()).removeView(localActivateBasePage);
      if (QLog.isColorLevel()) {
        QLog.i("ActivatePageAdapter", 2, "instantiateItem page already has parent pos:" + paramInt);
      }
    }
    try
    {
      paramViewGroup.addView(localActivateBasePage);
      return localActivateBasePage;
    }
    catch (Exception paramViewGroup)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("ActivatePageAdapter", 2, paramViewGroup.getMessage(), paramViewGroup);
    }
    return localActivateBasePage;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void refresh()
  {
    Iterator localIterator = this.pY.iterator();
    while (localIterator.hasNext()) {
      ((ActivateBasePage)localIterator.next()).refresh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivatePageAdapter
 * JD-Core Version:    0.7.0.1
 */