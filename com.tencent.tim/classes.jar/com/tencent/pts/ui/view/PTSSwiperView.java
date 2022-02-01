package com.tencent.pts.ui.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.support.PagerSnapHelper;
import com.tencent.pts.support.RecyclerViewCompat;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSRecyclerViewAdapter;
import com.tencent.pts.ui.PTSRecyclerViewAdapter.PTSViewHolder;
import com.tencent.pts.ui.vnode.PTSNodeSwiper;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSValueConvertUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class PTSSwiperView
  extends RelativeLayout
  implements IView
{
  private static final String TAG = "PTSSwiperView";
  private PTSSwiperRecyclerViewAdapter mAdapter;
  private boolean mAutoPlay = false;
  private int mAutoPlayDuration = 500;
  private int mAutoPlayInterval = 5000;
  private Runnable mAutoPlayRunnable = new PTSSwiperView.2(this);
  private boolean mCircularAutoPlay = false;
  private List<PTSNodeInfo> mDataList = new ArrayList();
  private LinearLayout mIndicatorContainer;
  private int mIndicatorFocusedColor = -16777216;
  private GradientDrawable mIndicatorFocusedDrawable;
  private float mIndicatorGap = PTSValueConvertUtil.dp2px(4.0F);
  private float mIndicatorHeight = PTSValueConvertUtil.dp2px(3.0F);
  private float mIndicatorMarginBottom = PTSValueConvertUtil.dp2px(12.0F);
  private int mIndicatorNormalColor = 1275068416;
  private GradientDrawable mIndicatorNormalDrawable;
  private float mIndicatorRadius = PTSValueConvertUtil.dp2px(2.5F);
  private float mIndicatorWidth = PTSValueConvertUtil.dp2px(16.0F);
  private PTSPagerSnapHelper mPagerSnapHelper;
  private PTSSwiperRecyclerView mRecyclerView;
  
  public PTSSwiperView(PTSNodeSwiper paramPTSNodeSwiper)
  {
    super(paramPTSNodeSwiper.getContext());
    init(paramPTSNodeSwiper);
  }
  
  private void init(PTSNodeSwiper paramPTSNodeSwiper)
  {
    Context localContext = paramPTSNodeSwiper.getContext();
    this.mAdapter = new PTSSwiperRecyclerViewAdapter(paramPTSNodeSwiper.getAppInstance());
    this.mRecyclerView = new PTSSwiperRecyclerView(localContext);
    this.mRecyclerView.setAdapter(this.mAdapter);
    paramPTSNodeSwiper = new LinearLayoutManager(localContext);
    paramPTSNodeSwiper.setOrientation(0);
    this.mRecyclerView.setLayoutManager(paramPTSNodeSwiper);
    paramPTSNodeSwiper = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.mRecyclerView, paramPTSNodeSwiper);
    this.mIndicatorContainer = new LinearLayout(localContext);
    paramPTSNodeSwiper = new RelativeLayout.LayoutParams(-2, -2);
    paramPTSNodeSwiper.addRule(14);
    paramPTSNodeSwiper.addRule(12);
    this.mIndicatorContainer.setPadding(0, 0, 0, (int)this.mIndicatorMarginBottom);
    addView(this.mIndicatorContainer, paramPTSNodeSwiper);
    this.mPagerSnapHelper = new PTSPagerSnapHelper(null);
    this.mPagerSnapHelper.attachToRecyclerView(this.mRecyclerView);
    this.mPagerSnapHelper.setEventListener(new PTSSwiperView.1(this));
  }
  
  private void onIndicatorSelected(int paramInt)
  {
    int j = this.mIndicatorContainer.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = this.mIndicatorContainer.getChildAt(i);
      if (i == paramInt) {}
      for (GradientDrawable localGradientDrawable = this.mIndicatorFocusedDrawable;; localGradientDrawable = this.mIndicatorNormalDrawable)
      {
        localView.setBackgroundDrawable(localGradientDrawable);
        i += 1;
        break;
      }
    }
  }
  
  private void resetIndicator()
  {
    int i = 0;
    if (this.mIndicatorContainer.getVisibility() != 0) {}
    for (;;)
    {
      return;
      int m = this.mAdapter.getRealItemCount();
      int k = this.mIndicatorContainer.getChildCount();
      if (m <= 1)
      {
        while (i < k)
        {
          this.mIndicatorContainer.getChildAt(i).setVisibility(8);
          i += 1;
        }
      }
      else
      {
        if (m > k)
        {
          Context localContext = this.mIndicatorContainer.getContext();
          int n = (int)this.mIndicatorWidth;
          int i1 = (int)this.mIndicatorHeight;
          i = k;
          if (i < m)
          {
            View localView = new View(localContext);
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(n, i1);
            int j;
            if (i == 0)
            {
              j = 0;
              label128:
              localLayoutParams.leftMargin = j;
              if (this.mIndicatorFocusedDrawable == null) {
                this.mIndicatorFocusedDrawable = new GradientDrawable();
              }
              if (this.mIndicatorNormalDrawable == null) {
                this.mIndicatorNormalDrawable = new GradientDrawable();
              }
              this.mIndicatorNormalDrawable.setColor(this.mIndicatorNormalColor);
              this.mIndicatorFocusedDrawable.setColor(this.mIndicatorFocusedColor);
              this.mIndicatorFocusedDrawable.setCornerRadius(this.mIndicatorRadius);
              this.mIndicatorNormalDrawable.setCornerRadius(this.mIndicatorRadius);
              if (i != 0) {
                break label258;
              }
            }
            label258:
            for (GradientDrawable localGradientDrawable = this.mIndicatorFocusedDrawable;; localGradientDrawable = this.mIndicatorNormalDrawable)
            {
              localView.setBackgroundDrawable(localGradientDrawable);
              this.mIndicatorContainer.addView(localView, localLayoutParams);
              i += 1;
              break;
              j = (int)this.mIndicatorGap;
              break label128;
            }
          }
        }
        i = 0;
        while (i < m)
        {
          this.mIndicatorContainer.getChildAt(i).setVisibility(0);
          i += 1;
        }
        i = m;
        while (i < k)
        {
          this.mIndicatorContainer.getChildAt(i).setVisibility(8);
          i += 1;
        }
      }
    }
  }
  
  private void switchAutoPlay(boolean paramBoolean)
  {
    this.mRecyclerView.removeCallbacks(this.mAutoPlayRunnable);
    if (paramBoolean) {
      this.mRecyclerView.postDelayed(this.mAutoPlayRunnable, this.mAutoPlayInterval);
    }
  }
  
  public void onBindNodeInfo(PTSNodeInfo paramPTSNodeInfo)
  {
    if (paramPTSNodeInfo == null) {
      return;
    }
    this.mDataList.clear();
    this.mDataList.addAll(paramPTSNodeInfo.getChildren());
    this.mAdapter.setData(this.mDataList);
    resetIndicator();
    switchAutoPlay(this.mAutoPlay);
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    this.mAutoPlay = paramBoolean;
    this.mRecyclerView.setAutoPlay(paramBoolean);
    PTSSwiperRecyclerView localPTSSwiperRecyclerView = this.mRecyclerView;
    if (this.mAutoPlay) {}
    for (Runnable localRunnable = this.mAutoPlayRunnable;; localRunnable = null)
    {
      localPTSSwiperRecyclerView.setAutoPlayRunnable(localRunnable);
      return;
    }
  }
  
  public void setAutoPlayDuration(int paramInt)
  {
    this.mAutoPlayDuration = paramInt;
  }
  
  public void setAutoPlayInterval(int paramInt)
  {
    this.mAutoPlayInterval = paramInt;
    this.mRecyclerView.setAutoPlayInterval(paramInt);
  }
  
  public void setCircularAutoPlay(boolean paramBoolean)
  {
    this.mCircularAutoPlay = paramBoolean;
  }
  
  public void setIndicatorFocusedColor(int paramInt)
  {
    this.mIndicatorFocusedColor = paramInt;
  }
  
  public void setIndicatorGap(float paramFloat)
  {
    this.mIndicatorGap = PTSValueConvertUtil.dp2px(paramFloat);
  }
  
  public void setIndicatorHeight(float paramFloat)
  {
    this.mIndicatorHeight = PTSValueConvertUtil.dp2px(paramFloat);
  }
  
  public void setIndicatorMarginBottom(float paramFloat)
  {
    this.mIndicatorMarginBottom = PTSValueConvertUtil.dp2px(paramFloat);
    PTSLog.i("PTSSwiperView", "[setIndicatorMarginBottom], bottom = " + this.mIndicatorMarginBottom + ", bottom dp = " + paramFloat);
    this.mIndicatorContainer.setPadding(0, 0, 0, (int)this.mIndicatorMarginBottom);
  }
  
  public void setIndicatorNormalColor(int paramInt)
  {
    this.mIndicatorNormalColor = paramInt;
  }
  
  public void setIndicatorRadius(float paramFloat)
  {
    this.mIndicatorRadius = PTSValueConvertUtil.dp2px(paramFloat);
  }
  
  public void setIndicatorVisible(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = this.mIndicatorContainer;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      return;
    }
  }
  
  public void setIndicatorWidth(float paramFloat)
  {
    this.mIndicatorWidth = PTSValueConvertUtil.dp2px(paramFloat);
  }
  
  static class PTSPagerSnapHelper
    extends PagerSnapHelper
  {}
  
  static class PTSSwiperRecyclerView
    extends RecyclerViewCompat
  {
    private boolean autoPlay = false;
    private int autoPlayInterval = 5000;
    private Runnable autoPlayRunnable;
    
    public PTSSwiperRecyclerView(Context paramContext)
    {
      super();
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return super.dispatchTouchEvent(paramMotionEvent);
        removeCallbacks(this.autoPlayRunnable);
        continue;
        if (this.autoPlay) {
          postDelayed(this.autoPlayRunnable, this.autoPlayInterval);
        }
      }
    }
    
    public void setAutoPlay(boolean paramBoolean)
    {
      this.autoPlay = paramBoolean;
    }
    
    public void setAutoPlayInterval(int paramInt)
    {
      this.autoPlayInterval = paramInt;
    }
    
    public void setAutoPlayRunnable(Runnable paramRunnable)
    {
      this.autoPlayRunnable = paramRunnable;
    }
  }
  
  static class PTSSwiperRecyclerViewAdapter
    extends PTSRecyclerViewAdapter
  {
    private boolean isInfiniteLoop = true;
    
    public PTSSwiperRecyclerViewAdapter(PTSAppInstance paramPTSAppInstance)
    {
      super();
    }
    
    public int getItemCount()
    {
      if (this.isInfiniteLoop) {
        return 2147483647;
      }
      return getRealItemCount();
    }
    
    public int getItemViewType(int paramInt)
    {
      return super.getItemViewType(getRealPosition(paramInt));
    }
    
    public int getRealItemCount()
    {
      return super.getItemCount();
    }
    
    public int getRealPosition(int paramInt)
    {
      int i = paramInt;
      if (this.isInfiniteLoop)
      {
        int j = getRealItemCount();
        i = paramInt;
        if (j > 0) {
          i = paramInt % j;
        }
      }
      return i;
    }
    
    public void onBindViewHolder(@NonNull PTSRecyclerViewAdapter.PTSViewHolder paramPTSViewHolder, int paramInt)
    {
      super.onBindViewHolder(paramPTSViewHolder, getRealPosition(paramInt));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramPTSViewHolder, paramInt, getItemId(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSSwiperView
 * JD-Core Version:    0.7.0.1
 */