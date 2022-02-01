package com.tencent.av.ui.funchat.filter;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import igd;
import jgk;

@TargetApi(9)
public class EffectCycleViewPager
  extends ViewPager
{
  SparseArray<View> W = new SparseArray();
  private a a;
  protected b a;
  
  public EffectCycleViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EffectCycleViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  View getCurrentView()
  {
    int i = getCurrentItem();
    return (View)this.W.get(i);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager$b = new b(paramPagerAdapter);
    super.setAdapter(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager$b);
    setCurrentItem(1);
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager$a = new a(paramOnPageChangeListener, getCurrentItem());
    super.setOnPageChangeListener(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager$a);
  }
  
  class a
    implements ViewPager.OnPageChangeListener
  {
    private ViewPager.OnPageChangeListener b;
    private int position;
    
    public a(ViewPager.OnPageChangeListener paramOnPageChangeListener, int paramInt)
    {
      this.b = paramOnPageChangeListener;
      this.position = paramInt;
    }
    
    public void onPageScrollStateChanged(int paramInt)
    {
      if (paramInt == 0)
      {
        if (this.position != EffectCycleViewPager.this.a.getCount() - 1) {
          break label57;
        }
        igd.aJ("EffectCycleViewPager", "onPageScrollStateChanged 00:1");
        EffectCycleViewPager.this.setCurrentItem(1, false);
      }
      for (;;)
      {
        if (this.b != null) {
          this.b.onPageScrollStateChanged(paramInt);
        }
        return;
        label57:
        if (this.position == 0)
        {
          igd.aJ("EffectCycleViewPager", "onPageScrollStateChanged 11:" + (EffectCycleViewPager.this.a.getCount() - 2));
          EffectCycleViewPager.this.setCurrentItem(EffectCycleViewPager.this.a.getCount() - 2, false);
        }
      }
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      if (this.b != null) {
        this.b.onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
    }
    
    public void onPageSelected(int paramInt)
    {
      this.position = paramInt;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onPageSelected, pos[").append(paramInt).append("], mSelectListener[");
        if (this.b == null) {
          break label91;
        }
      }
      label91:
      for (boolean bool = true;; bool = false)
      {
        QLog.w("EffectCycleViewPager", 1, bool + "]");
        if (this.b != null)
        {
          paramInt = EffectCycleViewPager.this.a.cE(paramInt);
          this.b.onPageSelected(paramInt);
        }
        return;
      }
    }
  }
  
  public class b
    extends PagerAdapter
  {
    private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
    
    public b(PagerAdapter paramPagerAdapter)
    {
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = paramPagerAdapter;
      paramPagerAdapter.registerDataSetObserver(new jgk(this, EffectCycleViewPager.this));
    }
    
    int cE(int paramInt)
    {
      if (paramInt == 0) {
        return this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount() - 1;
      }
      if (paramInt == this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount() + 1) {
        return 0;
      }
      return paramInt - 1;
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      int i = cE(paramInt);
      EffectCycleViewPager.this.W.remove(paramInt);
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.destroyItem(paramViewGroup, i, paramObject);
    }
    
    public int getCount()
    {
      int i = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount();
      if (i > 0) {
        return i + 2;
      }
      return 0;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      int i = cE(paramInt);
      paramViewGroup = (View)this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.instantiateItem(paramViewGroup, i);
      EffectCycleViewPager.this.W.put(paramInt, paramViewGroup);
      return paramViewGroup;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.isViewFromObject(paramView, paramObject);
    }
    
    public void notifyDataSetChanged()
    {
      EffectCycleViewPager.this.setCurrentItem(1);
      super.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectCycleViewPager
 * JD-Core Version:    0.7.0.1
 */