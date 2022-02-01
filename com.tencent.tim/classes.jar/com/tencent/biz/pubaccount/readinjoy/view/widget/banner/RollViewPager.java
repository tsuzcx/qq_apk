package com.tencent.biz.pubaccount.readinjoy.view.widget.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.PageTransformer;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import apue;
import atau.a;
import nsn;

public class RollViewPager
  extends ViewPager
{
  private String TAG = "BannerAdapter";
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager$a;
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager$b;
  protected nsn a;
  private int count;
  protected float lg;
  protected float lh;
  private float mHeightWeight = 1.0F;
  protected float mLastX;
  protected float mLastY;
  private ViewPager.PageTransformer mPageTransformer;
  protected int mTouchSlop;
  private float mWidthWeight = 1.0F;
  
  public RollViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RollViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d(paramContext, paramAttributeSet);
  }
  
  private void d(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rM);
    this.mWidthWeight = paramAttributeSet.getFloat(1, 1.0F);
    this.mHeightWeight = paramAttributeSet.getFloat(0, 1.0F);
    paramAttributeSet.recycle();
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    int j = getCurrentItem();
    if (this.mPageTransformer != null)
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = getChildCount();
      }
      this.mPageTransformer.transformPage(paramView, i - j);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = Math.abs(f1 - this.mLastX);
    float f4 = Math.abs(f2 - this.mLastY);
    switch (paramMotionEvent.getAction())
    {
    default: 
      return bool2;
    case 0: 
    case 261: 
      this.count = this.jdField_a_of_type_Nsn.ju();
      requestDisallowInterceptTouchEvent(true);
      this.mLastX = f1;
      this.lg = f1;
      this.mLastY = f2;
      this.lh = f2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager$a != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager$a.tP(0);
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    case 2: 
      if (this.count <= 1)
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        bool1 = bool3;
      }
      for (;;)
      {
        this.mLastX = f1;
        this.mLastY = f2;
        return bool1;
        if ((f3 < f4) && (Math.abs(f2 - this.lh) > this.mTouchSlop)) {
          getParent().requestDisallowInterceptTouchEvent(false);
        }
        for (;;)
        {
          if ((f3 <= f4) || (Math.abs(f1 - this.lg) <= this.mTouchSlop)) {
            break label280;
          }
          bool1 = super.dispatchTouchEvent(paramMotionEvent);
          break;
          getParent().requestDisallowInterceptTouchEvent(true);
        }
        label280:
        requestDisallowInterceptTouchEvent(false);
        bool1 = bool3;
      }
    }
    requestDisallowInterceptTouchEvent(false);
    bool2 = super.dispatchTouchEvent(paramMotionEvent);
    if ((Math.abs(f1 - this.lg) < this.mTouchSlop) && (Math.abs(f2 - this.lh) < this.mTouchSlop))
    {
      requestDisallowInterceptTouchEvent(false);
      performClick();
    }
    for (;;)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager$a == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager$a.tP(1);
      return bool1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager$b != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager$b.baE();
      }
      bool1 = bool2;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      apue.m("avatarWallViewPager", "ote_pointerindex_out_of_range", paramMotionEvent.toString(), "", "", "");
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if ((this.mWidthWeight == 1.0F) && (this.mHeightWeight != 1.0F))
    {
      paramInt2 = (int)(paramInt1 * this.mHeightWeight);
      getLayoutParams().height = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      setMeasuredDimension(paramInt1, paramInt2);
    }
    while ((this.mWidthWeight == 1.0F) || (this.mHeightWeight != 1.0F)) {
      return;
    }
    paramInt1 = (int)(paramInt2 * this.mWidthWeight);
    getLayoutParams().width = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      apue.m("avatarWallViewPager", "te_pointerindex_out_of_range", paramMotionEvent.toString(), "", "", "");
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    super.setAdapter(paramPagerAdapter);
    this.jdField_a_of_type_Nsn = ((nsn)paramPagerAdapter);
  }
  
  public void setOnTouchStateChangeListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager$a = parama;
  }
  
  public void setOnUserFling(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager$b = paramb;
  }
  
  public void setPageTransformer(boolean paramBoolean, ViewPager.PageTransformer paramPageTransformer)
  {
    this.mPageTransformer = paramPageTransformer;
    super.setPageTransformer(paramBoolean, paramPageTransformer);
  }
  
  public static abstract interface a
  {
    public abstract void tP(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void baE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.banner.RollViewPager
 * JD-Core Version:    0.7.0.1
 */