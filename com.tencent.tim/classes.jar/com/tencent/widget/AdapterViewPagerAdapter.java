package com.tencent.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import ausu;
import auuq;

public class AdapterViewPagerAdapter
  extends PagerAdapter
{
  private auuq jdField_a_of_type_Auuq;
  private a jdField_a_of_type_ComTencentWidgetAdapterViewPagerAdapter$a;
  private b jdField_a_of_type_ComTencentWidgetAdapterViewPagerAdapter$b;
  private SparseArray<AdapterView> dV = new SparseArray();
  private Context mContext;
  
  public AdapterViewPagerAdapter(Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_Auuq = new auuq(paramBaseAdapter, paramInt);
    this.jdField_a_of_type_Auuq.registerDataSetObserver(new ausu(this));
  }
  
  public AdapterView a(int paramInt)
  {
    Object localObject2 = (AdapterView)this.dV.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (this.jdField_a_of_type_ComTencentWidgetAdapterViewPagerAdapter$a != null) {
        localObject1 = this.jdField_a_of_type_ComTencentWidgetAdapterViewPagerAdapter$a.a(this.mContext, paramInt);
      }
    }
    else
    {
      if (localObject1 != null)
      {
        localObject2 = new auuq(this.jdField_a_of_type_Auuq.c(), this.jdField_a_of_type_Auuq.OS());
        ((auuq)localObject2).setCurrentPage(paramInt);
        ((AdapterView)localObject1).setAdapter((Adapter)localObject2);
        this.dV.put(paramInt, localObject1);
      }
      return localObject1;
    }
    throw new IllegalArgumentException("setAdapterViewFactory should be invoked first!");
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterViewPagerAdapter$a = parama;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAdapterViewPagerAdapter$b != null)
    {
      this.jdField_a_of_type_ComTencentWidgetAdapterViewPagerAdapter$b.a(paramViewGroup, (View)paramObject, paramInt);
      return;
    }
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Auuq.OT();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AdapterView localAdapterView = a(paramInt);
    if (localAdapterView == null) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentWidgetAdapterViewPagerAdapter$b != null) {
      return this.jdField_a_of_type_ComTencentWidgetAdapterViewPagerAdapter$b.a(paramViewGroup, localAdapterView, paramInt);
    }
    paramViewGroup.addView(localAdapterView);
    return localAdapterView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public static abstract interface a
  {
    public abstract AdapterView a(Context paramContext, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract View a(ViewGroup paramViewGroup, AdapterView paramAdapterView, int paramInt);
    
    public abstract void a(ViewGroup paramViewGroup, View paramView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.widget.AdapterViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */