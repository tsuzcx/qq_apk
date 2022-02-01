package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import aqcx;
import aqho;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import wja;

public class DisableSlideHorizontalListView
  extends HorizontalListView
{
  private BezierSideBarView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView;
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView$a;
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView$b;
  private int aPI;
  private boolean akU;
  private float iq;
  private float is;
  
  public DisableSlideHorizontalListView(Context paramContext)
  {
    super(paramContext);
    this.aPI = ((int)aqho.convertDpToPixel(paramContext, 18.0F));
  }
  
  public DisableSlideHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.aPI = ((int)aqho.convertDpToPixel(paramContext, 18.0F));
  }
  
  private void aNo()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView.aNo();
    }
  }
  
  private void rt(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView != null)
    {
      int i = getMeasuredHeight() / 2;
      int j = wja.dp2px(18.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView.d(paramInt, i - j);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getY();
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DisableSlideHorizontalListView", 2, "dispatchTouchEvent:ACTION_DOWN. mIsPress=" + this.akU);
      }
      this.is = f1;
      this.iq = f3;
      getParent().requestDisallowInterceptTouchEvent(true);
      this.akU = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (i == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DisableSlideHorizontalListView", 2, "dispatchTouchEvent:ACTION_MOVE. mIsPress=" + this.akU);
      }
      float f2 = this.is;
      f3 -= this.iq;
      if ((this.akU) && (Math.abs(f3) * 5.0F > Math.abs(f1 - f2) * 4.0F) && (Math.abs(f3) > aqcx.dip2px(getContext(), 5.0F)))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        rt(getScrollX() - this.aPI);
      }
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      break;
      if ((i == 3) || (i == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DisableSlideHorizontalListView", 2, "dispatchTouchEvent:ACTION_CANCEL or UP. action=" + i + " mIsPress=" + this.akU);
        }
        this.akU = false;
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView$a != null) && (i == 1) && (getScrollX() > this.aPI)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView$a.aNj();
        }
        aNo();
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView$b != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView$b.onAttachedToWindow();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView$b != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView$b.onDetachedFromWindow();
    }
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if (paramInt1 <= 2)
    {
      aNo();
      return;
    }
    rt(paramInt1 - this.aPI);
  }
  
  public void setOnOverScrollListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView$a = parama;
  }
  
  public void setOnViewWindowChangedListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView$b = paramb;
  }
  
  public void setSideBarView(BezierSideBarView paramBezierSideBarView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView = paramBezierSideBarView;
  }
  
  public static abstract interface a
  {
    public abstract void aNj();
  }
  
  public static abstract interface b
  {
    public abstract void onAttachedToWindow();
    
    public abstract void onDetachedFromWindow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView
 * JD-Core Version:    0.7.0.1
 */