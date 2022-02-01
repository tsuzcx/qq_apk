package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ViewPagerCompat
  extends ViewPager
{
  private b a;
  private List<a> mAdapterChangeListeners;
  private boolean mIsScrollable = true;
  private List<ViewPager.OnPageChangeListener> mOnPageChangeListeners;
  
  public ViewPagerCompat(Context paramContext)
  {
    super(paramContext);
    baC();
  }
  
  public ViewPagerCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    baC();
  }
  
  private void baC()
  {
    this.a = new b(null);
    super.setOnPageChangeListener(this.a);
  }
  
  public void a(a parama)
  {
    if (this.mAdapterChangeListeners == null) {
      this.mAdapterChangeListeners = new ArrayList();
    }
    this.mAdapterChangeListeners.add(parama);
  }
  
  public void addOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.mOnPageChangeListeners == null) {
      this.mOnPageChangeListeners = new ArrayList();
    }
    this.mOnPageChangeListeners.add(paramOnPageChangeListener);
  }
  
  public void b(a parama)
  {
    if (this.mAdapterChangeListeners != null) {
      this.mAdapterChangeListeners.remove(parama);
    }
  }
  
  public void clearOnPageChangeListeners()
  {
    if (this.mOnPageChangeListeners != null) {
      this.mOnPageChangeListeners.clear();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mIsScrollable) {
      try
      {
        boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mIsScrollable) {
      try
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
    }
    return false;
  }
  
  public void removeOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.mOnPageChangeListeners != null) {
      this.mOnPageChangeListeners.remove(paramOnPageChangeListener);
    }
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    PagerAdapter localPagerAdapter = getAdapter();
    super.setAdapter(paramPagerAdapter);
    if ((this.mAdapterChangeListeners != null) && (!this.mAdapterChangeListeners.isEmpty()))
    {
      int j = this.mAdapterChangeListeners.size();
      int i = 0;
      while (i < j)
      {
        ((a)this.mAdapterChangeListeners.get(i)).a(this, localPagerAdapter, paramPagerAdapter);
        i += 1;
      }
    }
  }
  
  @Deprecated
  public final void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    QLog.e("ViewPagerCompat", 2, "ViewPagerCompat#setOnPageChangeListener had been deprecated !", new IllegalAccessException("call addOnPageChangeListener instead !"));
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.mIsScrollable = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void a(ViewPager paramViewPager, PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2);
  }
  
  class b
    implements ViewPager.OnPageChangeListener
  {
    private b() {}
    
    public void onPageScrollStateChanged(int paramInt)
    {
      if (ViewPagerCompat.a(ViewPagerCompat.this) != null)
      {
        Iterator localIterator = ViewPagerCompat.a(ViewPagerCompat.this).iterator();
        while (localIterator.hasNext()) {
          ((ViewPager.OnPageChangeListener)localIterator.next()).onPageScrollStateChanged(paramInt);
        }
      }
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      if (ViewPagerCompat.a(ViewPagerCompat.this) != null)
      {
        Iterator localIterator = ViewPagerCompat.a(ViewPagerCompat.this).iterator();
        while (localIterator.hasNext()) {
          ((ViewPager.OnPageChangeListener)localIterator.next()).onPageScrolled(paramInt1, paramFloat, paramInt2);
        }
      }
    }
    
    public void onPageSelected(int paramInt)
    {
      if (ViewPagerCompat.a(ViewPagerCompat.this) != null)
      {
        Iterator localIterator = ViewPagerCompat.a(ViewPagerCompat.this).iterator();
        while (localIterator.hasNext()) {
          ((ViewPager.OnPageChangeListener)localIterator.next()).onPageSelected(paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat
 * JD-Core Version:    0.7.0.1
 */