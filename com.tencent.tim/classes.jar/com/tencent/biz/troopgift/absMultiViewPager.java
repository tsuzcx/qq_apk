package com.tencent.biz.troopgift;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public abstract class absMultiViewPager
  extends ViewPager
  implements AdapterView.OnItemClickListener
{
  protected ViewPagerAdapter a;
  protected a a;
  protected int byt;
  protected ArrayList<View> js = new ArrayList();
  protected ArrayList<Object> mData = new ArrayList();
  protected AdapterView.OnItemClickListener mOnItemClickListener;
  protected ViewPager.OnPageChangeListener mOnPageChangeListener;
  
  public absMultiViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public absMultiViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static ArrayList<Object> a(ArrayList<Object> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > paramArrayList.size()) || (paramInt2 > paramArrayList.size())) {
      throw new IndexOutOfBoundsException("subArrayList exception, start or end is large than src list size. src size:" + paramArrayList.size() + ", start:" + paramInt1 + ", end:" + paramInt2);
    }
    ArrayList localArrayList = new ArrayList();
    while (paramInt1 < paramInt2)
    {
      localArrayList.add(paramArrayList.get(paramInt1));
      paramInt1 += 1;
    }
    return localArrayList;
  }
  
  public void bzI()
  {
    this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$ViewPagerAdapter = new ViewPagerAdapter();
    setAdapter(this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$ViewPagerAdapter);
    this.js.clear();
    int j = ul();
    if (this.byt != j)
    {
      eI(this.byt, j);
      this.byt = j;
    }
    int i = 0;
    while (i < j)
    {
      this.js.add(z(i));
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$ViewPagerAdapter.setData(this.js);
    this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$ViewPagerAdapter.notifyDataSetChanged();
    if (this.mOnPageChangeListener != null) {
      this.mOnPageChangeListener.onPageSelected(0);
    }
  }
  
  protected void eI(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$a != null) {
      this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$a.ai(paramInt1, paramInt2, getCurrentItem());
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.mOnItemClickListener != null) {
      this.mOnItemClickListener.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void setData(ArrayList<Object> paramArrayList)
  {
    this.mData = paramArrayList;
    bzI();
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mOnItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.mOnPageChangeListener = paramOnPageChangeListener;
    super.setOnPageChangeListener(paramOnPageChangeListener);
  }
  
  public void setOnPagerSizeChangeListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$a = parama;
  }
  
  public abstract int ul();
  
  public abstract View z(int paramInt);
  
  public static class ViewPagerAdapter
    extends PagerAdapter
  {
    protected ArrayList<View> js = new ArrayList();
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)this.js.get(paramInt));
    }
    
    public int getCount()
    {
      return this.js.size();
    }
    
    public ArrayList<View> getData()
    {
      return this.js;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup.addView((View)this.js.get(paramInt));
      return this.js.get(paramInt);
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == (View)paramObject;
    }
    
    public void setData(ArrayList<View> paramArrayList)
    {
      this.js = paramArrayList;
    }
  }
  
  public static abstract interface a
  {
    public abstract void ai(int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.troopgift.absMultiViewPager
 * JD-Core Version:    0.7.0.1
 */