package com.tencent.biz.pubaccount.readinjoy.video.discovery;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.PageTransformer;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import aqcx;
import java.lang.ref.WeakReference;
import java.util.List;
import wja;

public class BannerView
  extends FrameLayout
  implements ViewPager.OnPageChangeListener
{
  private AutoSidleTimer jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$AutoSidleTimer;
  private BannerViewAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter;
  private DotsIndicator jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator;
  private int aDC = 1;
  private int aWG = 81;
  public int aWH = 2130843928;
  int aWI = aqcx.dip2px(getContext(), 25.0F);
  private boolean aqU = true;
  private Context mContext;
  private int mCurrentPosition;
  private float mLastX;
  private float mLastY;
  private ViewPager.OnPageChangeListener mPageChangeListener;
  private int mTimeInterval = 3500;
  protected ViewPager mViewPager;
  
  public BannerView(@NonNull Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public BannerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public BannerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void aUP()
  {
    if ((this.aqU) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.isEmpty()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$AutoSidleTimer != null))
    {
      if (this.mCurrentPosition != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.qk() - 1) {
        break label72;
      }
      this.mCurrentPosition = 1;
      this.mViewPager.setCurrentItem(this.mCurrentPosition, false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$AutoSidleTimer.post();
    }
    label72:
    while ((!this.aqU) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$AutoSidleTimer == null)) {
      return;
    }
    this.mCurrentPosition += 1;
    this.mViewPager.setCurrentItem(this.mCurrentPosition);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$AutoSidleTimer.postDelayed(this.mTimeInterval);
  }
  
  private boolean dY(int paramInt)
  {
    return (paramInt == 0) || (paramInt == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.qk() - 1);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mViewPager = new ViewPager(this.mContext);
    this.mViewPager.setOnPageChangeListener(this);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.mViewPager.setLayoutParams(paramContext);
  }
  
  private void sY(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter != null)
    {
      if (paramInt != 0) {
        break label37;
      }
      this.mCurrentPosition = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.qk() - 2);
      this.mViewPager.setCurrentItem(this.mCurrentPosition, false);
    }
    label37:
    while (paramInt != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.qk() - 1) {
      return;
    }
    this.mCurrentPosition = 1;
    this.mViewPager.setCurrentItem(this.mCurrentPosition, false);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      stop();
      continue;
      start();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.ql() > 1)) {
      switch (paramMotionEvent.getAction())
      {
      case 1: 
      default: 
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.mLastX = paramMotionEvent.getX();
      this.mLastY = paramMotionEvent.getY();
      if (this.mLastX > this.aWI)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      else
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        return false;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        if (Math.abs(f1 - this.mLastX) >= Math.abs(f2 - this.mLastY)) {
          getParent().requestDisallowInterceptTouchEvent(true);
        } else {
          getParent().requestDisallowInterceptTouchEvent(false);
        }
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.mPageChangeListener != null) {
      this.mPageChangeListener.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.ql() == 1);
      if ((this.mPageChangeListener != null) && (!dY(paramInt1))) {
        this.mPageChangeListener.onPageScrolled(paramInt1 - 1, paramFloat, paramInt2);
      }
    } while ((!dY(paramInt1)) || (paramInt2 != 0));
    sY(paramInt1);
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter == null) {}
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.ql() == 1) {
      return;
    }
    if ((this.mPageChangeListener != null) && (!dY(paramInt))) {
      this.mPageChangeListener.onPageSelected(paramInt - 1);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter != null))
    {
      if (paramInt != 0) {
        break label86;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator.setDotsSelected(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.qk() - 3);
    }
    for (;;)
    {
      this.mCurrentPosition = paramInt;
      return;
      label86:
      if (paramInt == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.qk() - 1) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator.setDotsSelected(0);
      } else {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator.setDotsSelected(paramInt - 1);
      }
    }
  }
  
  public void setAdapter(BannerViewAdapter paramBannerViewAdapter)
  {
    if ((paramBannerViewAdapter == null) || (paramBannerViewAdapter.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter = paramBannerViewAdapter;
    if ((this.aqU) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$AutoSidleTimer == null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$AutoSidleTimer = new AutoSidleTimer(this);
      stop();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.ql() > 1)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator.removeAllViews();
      }
      this.mCurrentPosition = 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator = new DotsIndicator(this.mContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.ql(), this.aWG);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator.aWH = this.aWH;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator.aUQ();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator.setDotsSelected(this.mCurrentPosition - 1);
    }
    for (;;)
    {
      this.mViewPager.setOffscreenPageLimit(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.qk());
      this.mViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter);
      this.mViewPager.setCurrentItem(this.mCurrentPosition);
      this.mViewPager.setOverScrollMode(2);
      removeAllViews();
      addView(this.mViewPager);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.ql() <= 1) {
        break;
      }
      addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator);
      return;
      this.mCurrentPosition = 0;
    }
  }
  
  public void setDotsGravity(int paramInt)
  {
    if ((paramInt != 81) && (paramInt != 8388691) && (paramInt != 8388693)) {
      return;
    }
    this.aWG = paramInt;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    if (this.mViewPager != null) {
      this.mViewPager.setOffscreenPageLimit(paramInt);
    }
  }
  
  public void setPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.mPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setPageTransformer(boolean paramBoolean, ViewPager.PageTransformer paramPageTransformer)
  {
    if (this.mViewPager != null) {
      this.mViewPager.setPageTransformer(paramBoolean, paramPageTransformer);
    }
  }
  
  public void setTimeInterval(int paramInt)
  {
    if (paramInt > 0) {
      this.mTimeInterval = paramInt;
    }
  }
  
  public void start()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.ql() <= 1)) {}
    while ((this.aDC == 0) || (!this.aqU)) {
      return;
    }
    this.aDC = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$AutoSidleTimer.startTimer(this.mTimeInterval);
  }
  
  public void stop()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.ql() <= 1)) {}
    while ((this.aDC == 1) || (!this.aqU)) {
      return;
    }
    this.aDC = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$AutoSidleTimer.stopTimer();
  }
  
  static class AutoSidleTimer
    extends Handler
    implements Runnable
  {
    private WeakReference<BannerView> cs;
    
    public AutoSidleTimer(BannerView paramBannerView)
    {
      super();
      this.cs = new WeakReference(paramBannerView);
    }
    
    public void post()
    {
      postDelayed(0);
    }
    
    public void postDelayed(int paramInt)
    {
      if (paramInt == 0)
      {
        post(this);
        return;
      }
      postDelayed(this, paramInt);
    }
    
    public void run()
    {
      if ((this.cs != null) && (this.cs.get() != null)) {
        BannerView.a((BannerView)this.cs.get());
      }
    }
    
    public void startTimer(int paramInt)
    {
      if ((this.cs != null) && (this.cs.get() != null))
      {
        removeCallbacks(this);
        postDelayed(paramInt);
      }
    }
    
    public void stopTimer()
    {
      if ((this.cs != null) && (this.cs.get() != null)) {
        removeCallbacks(this);
      }
    }
  }
  
  public static abstract class BannerViewAdapter<T, V extends View>
    extends PagerAdapter
  {
    private SparseArray<V> as;
    protected List<T> mData;
    
    public abstract V a(int paramInt, T paramT);
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      if ((paramObject instanceof View)) {
        paramViewGroup.removeView((View)paramObject);
      }
    }
    
    public int getCount()
    {
      return qk();
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      View localView = obtainView(paramInt);
      if ((localView != null) && (paramViewGroup != null)) {
        paramViewGroup.addView(localView);
      }
      return localView;
    }
    
    public boolean isEmpty()
    {
      return (this.mData == null) || (this.mData.size() == 0);
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public V obtainView(int paramInt)
    {
      View localView = (View)this.as.get(paramInt);
      if ((localView == null) && (ql() > 1)) {
        if (paramInt == 0)
        {
          localObject = this.mData.get(this.mData.size() - 1);
          localObject = a(paramInt, localObject);
          this.as.put(paramInt, localObject);
        }
      }
      do
      {
        do
        {
          return localObject;
          if (paramInt == this.mData.size() + 1)
          {
            localObject = this.mData.get(0);
            break;
          }
          localObject = this.mData.get(paramInt - 1);
          break;
          localObject = localView;
        } while (localView != null);
        localObject = localView;
      } while (ql() != 1);
      Object localObject = a(paramInt, this.mData.get(0));
      this.as.put(paramInt, localObject);
      return localObject;
    }
    
    public int qk()
    {
      int i = 1;
      if ((this.mData == null) || (this.mData.size() == 0)) {
        i = 0;
      }
      while (this.mData.size() == 1) {
        return i;
      }
      return this.mData.size() + 2;
    }
    
    public int ql()
    {
      if (this.mData != null) {
        return this.mData.size();
      }
      return 0;
    }
  }
  
  public static class DotsIndicator
    extends LinearLayout
  {
    public int aBa;
    public int aWH;
    public int aWJ;
    public int aWK;
    public int aWL;
    public int aWM;
    private Context mContext;
    
    public DotsIndicator(Context paramContext)
    {
      this(paramContext, 0, 81);
    }
    
    public DotsIndicator(Context paramContext, int paramInt1, int paramInt2)
    {
      super();
      f(paramContext, paramInt1, paramInt2);
    }
    
    private void f(Context paramContext, int paramInt1, int paramInt2)
    {
      this.mContext = paramContext;
      this.aWM = paramInt1;
      this.aWJ = wja.dp2px(6.0F, getResources());
      this.aWK = wja.dp2px(10.0F, getResources());
      this.aBa = wja.dp2px(7.0F, getResources());
      this.aWL = wja.dp2px(7.0F, getResources());
      paramContext = new FrameLayout.LayoutParams(-2, -2);
      paramContext.bottomMargin = this.aWJ;
      paramContext.gravity = paramInt2;
      setLayoutParams(paramContext);
    }
    
    public void aUQ()
    {
      if (this.aWM > 1)
      {
        int i = 0;
        while (i < this.aWM)
        {
          View localView = new View(this.mContext);
          localView.setBackgroundResource(this.aWH);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.aBa, this.aWL);
          localLayoutParams.setMargins(this.aWK, 0, 0, 0);
          localView.setLayoutParams(localLayoutParams);
          addView(localView);
          i += 1;
        }
      }
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.discovery.BannerView
 * JD-Core Version:    0.7.0.1
 */