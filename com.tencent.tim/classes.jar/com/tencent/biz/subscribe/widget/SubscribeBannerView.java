package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import sim;
import wja;

public class SubscribeBannerView
  extends BaseWidgetView
{
  private static int bxk = ImmersiveUtils.dpToPx(20.0F);
  private BannerAdapter jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$BannerAdapter;
  private DotsIndicator jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$DotsIndicator;
  private ViewPager mViewPager;
  
  public SubscribeBannerView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public SubscribeBannerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void d(FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$DotsIndicator = new DotsIndicator(getContext());
    paramFrameLayout = new FrameLayout.LayoutParams(-2, -2);
    paramFrameLayout.gravity = 81;
    addView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$DotsIndicator, paramFrameLayout);
  }
  
  public void P(Object paramObject) {}
  
  public void destroy()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$BannerAdapter != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$BannerAdapter.getDataList().clear();
    }
    if (this.mViewPager != null) {
      this.mViewPager.setAdapter(null);
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.mViewPager = new ViewPager(getContext());
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    paramContext.bottomMargin = bxk;
    this.mViewPager.setLayoutParams(paramContext);
    this.mViewPager.setOffscreenPageLimit(3);
    this.mViewPager.setOnPageChangeListener(new sim(this));
    ((FrameLayout)paramView).addView(this.mViewPager);
    d((FrameLayout)paramView);
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public void setAdapter(BannerAdapter paramBannerAdapter)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$BannerAdapter = paramBannerAdapter;
    if (this.mViewPager != null) {
      this.mViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$BannerAdapter);
    }
  }
  
  public void setBannerHeight(int paramInt)
  {
    if (getLayoutParams() != null)
    {
      getLayoutParams().height = (bxk + paramInt);
      requestLayout();
    }
  }
  
  public void setDatas(List paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$BannerAdapter != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$BannerAdapter.cl((ArrayList)paramList);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$DotsIndicator != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$DotsIndicator.removeAllViews();
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$DotsIndicator.yv(paramList.size());
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$DotsIndicator.setDotsSelected(0);
      }
    }
  }
  
  public static abstract class BannerAdapter
    extends PagerAdapter
  {
    private final ArrayList mDataList = new ArrayList();
    private int pW;
    private final LinkedList<View> y = new LinkedList();
    
    protected abstract View a(View paramView, Object paramObject);
    
    public View b(ViewGroup paramViewGroup, int paramInt)
    {
      Object localObject;
      if (this.mDataList.size() > 1)
      {
        localObject = this.mDataList.get(paramInt % this.mDataList.size());
        if (this.y.size() <= 0) {
          break label76;
        }
      }
      label76:
      for (View localView = (View)this.y.removeFirst();; localView = g(paramViewGroup))
      {
        paramViewGroup.addView(localView);
        return a(localView, localObject);
        localObject = this.mDataList.get(0);
        break;
      }
    }
    
    public void cl(ArrayList paramArrayList)
    {
      this.mDataList.clear();
      notifyDataSetChanged();
      if (paramArrayList != null)
      {
        this.mDataList.addAll(paramArrayList);
        notifyDataSetChanged();
      }
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramObject = (View)paramObject;
      paramViewGroup.removeView(paramObject);
      this.y.add(paramObject);
    }
    
    protected abstract View g(ViewGroup paramViewGroup);
    
    public int getCount()
    {
      if (this.mDataList.size() > 1) {
        return 2147483647;
      }
      return this.mDataList.size();
    }
    
    public ArrayList getDataList()
    {
      return this.mDataList;
    }
    
    public int getItemPosition(Object paramObject)
    {
      if (this.pW > 0)
      {
        this.pW -= 1;
        return -2;
      }
      return super.getItemPosition(paramObject);
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public void notifyDataSetChanged()
    {
      this.pW = getCount();
      super.notifyDataSetChanged();
    }
  }
  
  public static class DotsIndicator
    extends LinearLayout
  {
    public int aBa;
    public int aWH = 2130839224;
    public int aWK;
    public int aWL;
    
    public DotsIndicator(Context paramContext)
    {
      super();
      init();
    }
    
    private void init()
    {
      this.aWK = wja.dp2px(10.0F, getResources());
      this.aBa = wja.dp2px(7.0F, getResources());
      this.aWL = wja.dp2px(7.0F, getResources());
      setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }
    
    public void setDotsSelected(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= getChildCount())) {
        return;
      }
      int i = 0;
      label15:
      View localView;
      if (i < getChildCount())
      {
        localView = getChildAt(i);
        if (i != paramInt) {
          break label46;
        }
        localView.setSelected(true);
      }
      for (;;)
      {
        i += 1;
        break label15;
        break;
        label46:
        localView.setSelected(false);
      }
    }
    
    public void yv(int paramInt)
    {
      if (paramInt > 1)
      {
        int i = 0;
        while (i < paramInt)
        {
          View localView = new View(getContext());
          localView.setBackgroundResource(this.aWH);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.aBa, this.aWL);
          localLayoutParams.setMargins(this.aWK, 0, 0, 0);
          localView.setLayoutParams(localLayoutParams);
          addView(localView);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeBannerView
 * JD-Core Version:    0.7.0.1
 */