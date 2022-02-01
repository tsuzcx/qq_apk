package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import rre;
import rrf;

public class EmptySupportViewPager
  extends ViewPager
{
  public Set<Pair<View, Boolean>> aO = new HashSet();
  private DataSetObserver e = new rre(this);
  private ViewPager.OnPageChangeListener mOnPageChangeListener = new rrf(this);
  public List<ViewPager.OnPageChangeListener> mOnPageChangeListeners;
  
  public EmptySupportViewPager(Context paramContext)
  {
    super(paramContext);
    super.setOnPageChangeListener(this.mOnPageChangeListener);
  }
  
  public EmptySupportViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnPageChangeListener(this.mOnPageChangeListener);
  }
  
  public void addOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.mOnPageChangeListeners == null) {
      this.mOnPageChangeListeners = new ArrayList();
    }
    this.mOnPageChangeListeners.add(paramOnPageChangeListener);
  }
  
  public void clearOnPageChangeListeners()
  {
    if (this.mOnPageChangeListeners != null) {
      this.mOnPageChangeListeners.clear();
    }
  }
  
  public void removeOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.mOnPageChangeListeners != null) {
      this.mOnPageChangeListeners.remove(paramOnPageChangeListener);
    }
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    PagerAdapter localPagerAdapter = super.getAdapter();
    if (localPagerAdapter != null) {
      localPagerAdapter.unregisterDataSetObserver(this.e);
    }
    super.setAdapter(paramPagerAdapter);
    if (paramPagerAdapter != null)
    {
      paramPagerAdapter.registerDataSetObserver(this.e);
      this.e.onChanged();
    }
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    throw new RuntimeException("please use addOnPageChangeListener instead");
  }
  
  public void xR(int paramInt)
  {
    Iterator localIterator = this.aO.iterator();
    if (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if (((Boolean)localPair.second).booleanValue()) {}
      int i;
      switch (paramInt)
      {
      default: 
        i = paramInt;
      }
      for (;;)
      {
        ((View)localPair.first).setVisibility(i);
        break;
        i = 0;
        continue;
        i = 8;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.EmptySupportViewPager
 * JD-Core Version:    0.7.0.1
 */