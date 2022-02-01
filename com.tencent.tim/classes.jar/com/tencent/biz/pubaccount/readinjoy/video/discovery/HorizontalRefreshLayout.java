package com.tencent.biz.pubaccount.readinjoy.video.discovery;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import aqcx;
import nae;

public class HorizontalRefreshLayout
  extends FrameLayout
{
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryHorizontalRefreshLayout$a;
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryHorizontalRefreshLayout$b;
  private int aWT;
  private int aWU;
  private int aWV;
  private int aWW;
  private int aWX = aqcx.dip2px(getContext(), 25.0F);
  private float kc;
  private float ke;
  private View mHeaderView;
  private int mLastX;
  private View mTargetView;
  
  public HorizontalRefreshLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HorizontalRefreshLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void aUT()
  {
    int i;
    if (this.mTargetView == null) {
      i = 0;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!localView.equals(this.mHeaderView)) {
          this.mTargetView = localView;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void aUU()
  {
    if ((this.mTargetView != null) && (this.mHeaderView != null))
    {
      this.mTargetView.animate().translationX(0.0F).setDuration(500L).setListener(new nae(this)).start();
      this.mHeaderView.animate().translationX(this.aWT).setDuration(500L).start();
    }
  }
  
  private void cX(View paramView)
  {
    if (paramView != null)
    {
      this.mHeaderView = paramView;
      ((FrameLayout.LayoutParams)this.mHeaderView.getLayoutParams()).gravity = 8388613;
      addView(this.mHeaderView, 0);
    }
  }
  
  public boolean Fd()
  {
    return ViewCompat.canScrollHorizontally(this.mTargetView, 1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.aWV = i;
      this.mLastX = i;
      this.aWW = j;
      if (i > this.aWX)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      else
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        continue;
        int k = i - this.aWV;
        int m = this.aWW;
        this.aWV = i;
        this.mLastX = i;
        if (Math.abs(k) >= Math.abs(j - m))
        {
          if ((this.mHeaderView != null) && (k < 0) && (!Fd()))
          {
            getParent().requestDisallowInterceptTouchEvent(true);
            return true;
          }
          getParent().requestDisallowInterceptTouchEvent(true);
        }
        else
        {
          getParent().requestDisallowInterceptTouchEvent(false);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() == 0) {}
    do
    {
      return;
      if (this.mTargetView != null) {
        break;
      }
      aUT();
    } while (this.mTargetView == null);
    if (this.mHeaderView != null) {
      this.mHeaderView.setTranslationX(this.aWT);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mHeaderView != null)
    {
      this.aWT = this.mHeaderView.getMeasuredWidth();
      this.aWU = this.aWT;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.mLastX = i;
      continue;
      int j = this.mLastX;
      this.mLastX = i;
      this.kc = ((i - j) * (1.0F - Math.abs(this.kc / this.aWU)) + this.kc);
      if (this.kc >= 0.0F)
      {
        this.kc = 0.0F;
        this.mTargetView.setTranslationX(0.0F);
        return false;
      }
      if (this.kc <= -this.aWU)
      {
        this.kc = (-this.aWU);
        this.mTargetView.setTranslationX(this.kc);
        this.mHeaderView.setTranslationX(this.aWT + this.kc);
        return false;
      }
      this.mTargetView.setTranslationX(this.kc);
      this.mHeaderView.setTranslationX(this.aWT + this.kc);
      this.ke = Math.abs(this.kc / this.aWT);
      return false;
      this.aWV = 0;
      this.mLastX = 0;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryHorizontalRefreshLayout$a != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryHorizontalRefreshLayout$a.a(this.ke, this.mHeaderView, this);
      }
      aUU();
    }
  }
  
  public void setOnDraggingListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryHorizontalRefreshLayout$a = parama;
  }
  
  public void setRefreshHeader(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryHorizontalRefreshLayout$b = paramb;
    cX(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryHorizontalRefreshLayout$b.c(this));
  }
  
  public static abstract interface a
  {
    public abstract void a(float paramFloat, View paramView, HorizontalRefreshLayout paramHorizontalRefreshLayout);
  }
  
  public static abstract interface b
  {
    public abstract View c(ViewGroup paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.discovery.HorizontalRefreshLayout
 * JD-Core Version:    0.7.0.1
 */