package com.tencent.biz.pubaccount.Advertisement.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import aqcx;

public class VerticalPagerView
  extends ViewGroup
{
  protected int aEq;
  public int aEr;
  protected boolean abT;
  protected boolean acS = true;
  protected a b;
  protected b b;
  protected float iq;
  protected float ir;
  protected float is;
  protected float mLastTouchY;
  protected int mOffsetY;
  protected Scroller mScroller = new Scroller(super.getContext());
  protected float mTouchX;
  protected float mTouchY;
  
  public VerticalPagerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public VerticalPagerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean cX(int paramInt)
  {
    return false;
  }
  
  public boolean cY(int paramInt)
  {
    return false;
  }
  
  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      super.postInvalidate();
    }
    for (;;)
    {
      super.computeScroll();
      return;
      if ((!this.abT) && (this.aEq != this.aEr))
      {
        ot(this.aEr);
        if (this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$b != null) {
          this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$b.a(this, super.getChildAt(this.aEr), this.aEr);
        }
        this.aEq = this.aEr;
      }
    }
  }
  
  public void onDestroy()
  {
    this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$b = null;
    this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$a = null;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((super.getChildCount() < 2) || (!this.acS)) {}
    int i;
    do
    {
      do
      {
        return false;
        i = paramMotionEvent.getAction();
        this.mTouchX = paramMotionEvent.getX();
        this.mTouchY = paramMotionEvent.getY();
        if (i == 0)
        {
          this.mOffsetY = ((int)paramMotionEvent.getY());
          this.is = this.mTouchX;
          this.iq = this.mTouchY;
          this.mLastTouchY = this.mTouchY;
          return false;
        }
      } while (i != 2);
      float f1 = Math.abs(this.mTouchX - this.is);
      float f2 = Math.abs(this.mTouchY - this.iq);
      if ((f2 < aqcx.dip2px(super.getContext(), 10.0F)) || (f2 < f1))
      {
        this.mOffsetY = ((int)paramMotionEvent.getY());
        return false;
      }
      i = (int)(paramMotionEvent.getY() - this.mOffsetY);
      if (i > 0)
      {
        if (this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$a != null) {
          return this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$a.cY(this.aEr);
        }
        return cY(this.aEr);
      }
    } while (i >= 0);
    if (this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$a != null) {
      return this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$a.cX(this.aEr);
    }
    return cX(this.aEr);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = super.getChildCount();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      View localView = super.getChildAt(i);
      int m = paramInt4 - paramInt2;
      localView.layout(0, j, paramInt3 - paramInt1, j + m);
      j += m;
      i += 1;
    }
    setCurrentPage(this.aEr);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j = super.getChildCount();
    int i = 0;
    while (i < j)
    {
      super.measureChild(super.getChildAt(i), paramInt1, paramInt2);
      i += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    this.mTouchY = paramMotionEvent.getY();
    if (i == 0)
    {
      this.mOffsetY = ((int)paramMotionEvent.getY());
      this.iq = this.mTouchY;
      this.abT = true;
      this.mLastTouchY = this.mTouchY;
      return true;
    }
    if (i == 2)
    {
      this.mOffsetY = ((int)(paramMotionEvent.getY() - this.mOffsetY));
      i = this.mScroller.getCurrY();
      if (Math.abs(this.mTouchY - this.iq) < aqcx.dip2px(super.getContext(), 10.0F))
      {
        this.mOffsetY = ((int)paramMotionEvent.getY());
        this.ir = (this.mTouchY - this.mLastTouchY);
        this.mLastTouchY = this.mTouchY;
        return false;
      }
      if (i < 0)
      {
        this.mOffsetY = ((int)paramMotionEvent.getY());
        if (this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$b != null) {
          this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$b.J(false, this.aEr);
        }
        this.ir = (this.mTouchY - this.mLastTouchY);
        this.mLastTouchY = this.mTouchY;
        return false;
      }
      if (i > (super.getChildCount() - 1) * super.getHeight())
      {
        this.mOffsetY = ((int)paramMotionEvent.getY());
        if (this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$b != null) {
          this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$b.J(false, this.aEr);
        }
        this.ir = (this.mTouchY - this.mLastTouchY);
        this.mLastTouchY = this.mTouchY;
        return false;
      }
      this.mScroller.startScroll(0, this.mScroller.getFinalY(), 0, -this.mOffsetY, 0);
      this.mOffsetY = ((int)paramMotionEvent.getY());
      super.invalidate();
      if (this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$b != null) {
        this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$b.J(true, this.aEr);
      }
    }
    while ((i != 1) && (i != 3))
    {
      this.ir = (this.mTouchY - this.mLastTouchY);
      this.mLastTouchY = this.mTouchY;
      return super.onTouchEvent(paramMotionEvent);
    }
    float f = Math.abs(this.ir);
    this.mLastTouchY = this.mTouchY;
    i = this.mScroller.getCurrY() - this.aEr * super.getHeight();
    if ((i > super.getHeight() / 4) || ((i > 0) && (f > aqcx.dip2px(super.getContext(), 7.0F))))
    {
      this.aEr += 1;
      if (this.aEr >= super.getChildCount()) {
        this.aEr = (super.getChildCount() - 1);
      }
    }
    for (;;)
    {
      smoothScrollTo(0, this.aEr * super.getHeight());
      this.mOffsetY = ((int)paramMotionEvent.getY());
      this.abT = false;
      if (this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$b == null) {
        break;
      }
      this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$b.J(false, this.aEr);
      break;
      if ((i < -super.getHeight() / 4) || ((i < 0) && (f > aqcx.dip2px(super.getContext(), 5.0F))))
      {
        this.aEr -= 1;
        if (this.aEr < 0) {
          this.aEr = 0;
        }
      }
    }
  }
  
  public void ot(int paramInt) {}
  
  public void setCurrentPage(int paramInt)
  {
    this.aEr = paramInt;
    smoothScrollTo(0, this.aEr * super.getHeight());
  }
  
  public void setCurrentPage(int paramInt1, int paramInt2)
  {
    this.aEr = paramInt1;
    smoothScrollTo(0, this.aEr * super.getHeight(), paramInt2);
  }
  
  public void setEnableChangePage(boolean paramBoolean)
  {
    this.acS = paramBoolean;
  }
  
  public void setOnInterceptTouchListener(a parama)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$a = parama;
  }
  
  public void setOnPagerChangedListener(b paramb)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$b = paramb;
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mScroller.startScroll(this.mScroller.getFinalX(), this.mScroller.getFinalY(), paramInt1, paramInt2, paramInt3);
    super.invalidate();
  }
  
  public void smoothScrollTo(int paramInt1, int paramInt2)
  {
    smoothScrollTo(paramInt1, paramInt2, 250);
  }
  
  public void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3)
  {
    smoothScrollBy(paramInt1 - this.mScroller.getFinalX(), paramInt2 - this.mScroller.getFinalY(), paramInt3);
  }
  
  public static abstract interface a
  {
    public abstract boolean cX(int paramInt);
    
    public abstract boolean cY(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void J(boolean paramBoolean, int paramInt);
    
    public abstract void a(VerticalPagerView paramVerticalPagerView, View paramView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView
 * JD-Core Version:    0.7.0.1
 */