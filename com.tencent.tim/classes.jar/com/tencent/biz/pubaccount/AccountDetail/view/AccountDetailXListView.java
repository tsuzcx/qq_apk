package com.tencent.biz.pubaccount.AccountDetail.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqcx;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;

public class AccountDetailXListView
  extends XListView
  implements AbsListView.e, Runnable
{
  public boolean AJ = true;
  private a a;
  public b a;
  protected int aDC = 0;
  protected int aDD;
  protected int aDE;
  protected boolean abT;
  float dy = 0.0F;
  protected RelativeLayout ey;
  private int initialPosition;
  protected float iq;
  protected float ir;
  protected float mLastTouchY;
  protected int mOffsetY;
  protected float mTouchY;
  protected TextView nI;
  private int newCheck = 100;
  protected ProgressBar z;
  
  public AccountDetailXListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AccountDetailXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public AccountDetailXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void aAb()
  {
    if ((yv()) && (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView$b != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailXListView", 2, "loadingMore");
      }
      this.ey.setVisibility(0);
      this.z.setVisibility(0);
      this.nI.setText(2131689615);
      op(0);
      this.aDC = 1;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView$b.d(this);
    }
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    initFooterView();
    this.aDE = paramContext.getResources().getDisplayMetrics().heightPixels;
    setOnScrollListener(this);
  }
  
  private void initFooterView()
  {
    this.ey = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131560182, this, false));
    this.z = ((ProgressBar)this.ey.findViewById(2131373845));
    this.nI = ((TextView)this.ey.findViewById(2131373846));
    addFooterView(this.ey, null, false);
    setFooterDividersEnabled(false);
  }
  
  private void op(int paramInt)
  {
    if (this.ey != null) {
      this.ey.setPadding(this.ey.getPaddingLeft(), 0, this.ey.getPaddingRight(), paramInt);
    }
  }
  
  private boolean yv()
  {
    if (getAdapter() == null) {}
    while ((getFooterViewsCount() <= 0) || (getLastVisiblePosition() != getAdapter().getCount() - 1)) {
      return false;
    }
    return true;
  }
  
  public void aAc()
  {
    if (this.ey != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailXListView", 2, "loadMoreFail");
      }
      this.ey.setVisibility(0);
      this.nI.setText(2131689614);
      this.z.setVisibility(8);
      op(0);
      this.aDC = 0;
    }
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView$b = null;
  }
  
  public void lA(boolean paramBoolean)
  {
    if (this.ey != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailXListView", 2, "loadMoreComplete hasMoreData = " + paramBoolean);
      }
      this.aDC = 0;
      if (!paramBoolean)
      {
        this.nI.setText(2131689616);
        this.z.setVisibility(8);
        this.ey.setVisibility(0);
        this.AJ = false;
      }
    }
    else
    {
      return;
    }
    this.ey.setVisibility(8);
  }
  
  public void lz(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.ey == null) {
        initFooterView();
      }
      if (getFooterViewsCount() <= 0) {
        addFooterView(this.ey);
      }
    }
    while ((this.ey == null) || (getFooterViewsCount() <= 0)) {
      return;
    }
    removeFooterView(this.ey);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.aDD < 0) && (this.ey != null))
    {
      this.aDD = this.ey.getHeight();
      op(-this.aDD);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.aDC == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.AJ)) {
      aAb();
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
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if (i == 2)
      {
        this.mOffsetY = ((int)(paramMotionEvent.getY() - this.mOffsetY));
        if (Math.abs(this.mTouchY - this.iq) < aqcx.dip2px(super.getContext(), 10.0F))
        {
          this.mOffsetY = ((int)paramMotionEvent.getY());
          this.ir = (this.mTouchY - this.mLastTouchY);
          this.mLastTouchY = this.mTouchY;
        }
      }
      else if (paramMotionEvent.getAction() == 1)
      {
        this.dy = Math.abs(this.ir);
        this.mLastTouchY = this.mTouchY;
        this.mOffsetY = ((int)paramMotionEvent.getY());
        this.abT = false;
        this.ir = (this.mTouchY - this.mLastTouchY);
        this.mLastTouchY = this.mTouchY;
        this.initialPosition = getScrollY();
        removeCallbacks(this);
        postDelayed(this, this.newCheck);
      }
    }
  }
  
  public void run()
  {
    int i = getScrollY();
    if (this.initialPosition - i == 0)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView$a != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView$a.ol((int)this.dy);
      }
      return;
    }
    this.initialPosition = getScrollY();
    postDelayed(this, this.newCheck);
  }
  
  public void setOnEndScrollListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView$a = parama;
  }
  
  public void setRefreshCallback(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView$b = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void ol(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void d(ListView paramListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView
 * JD-Core Version:    0.7.0.1
 */