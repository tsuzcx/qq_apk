package com.tencent.biz.pubaccount.readinjoy.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import auwt;
import auwt.a;
import auwy;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.pull2refresh.XLoadMoreLayout;
import nht;
import nhu;
import nhv;
import npy;

public class ReadInjoyXRecyclerView
  extends AbsPullToRefreshViewFix
  implements auwt.a, auwy
{
  public static int aYQ = 1001;
  private auwt jdField_a_of_type_Auwt;
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView$a;
  protected RecyclerViewWithHeaderFooterFix a;
  private XLoadMoreLayout jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout;
  public boolean aso = true;
  private ThreadLocal<Boolean> m = new nhu(this);
  private Handler mHandler = new nht(this, Looper.getMainLooper());
  private int mLastScrollState = 0;
  private int mScrollX;
  private int mScrollY;
  
  public ReadInjoyXRecyclerView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ReadInjoyXRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ReadInjoyXRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void aXh()
  {
    this.mHandler.removeMessages(aYQ);
    this.mHandler.sendEmptyMessageDelayed(aYQ, 1500L);
  }
  
  private boolean i(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView instanceof b)) {
      return ((b)paramView).z(paramMotionEvent);
    }
    if ((paramView instanceof HorizontalListView))
    {
      Rect localRect = new Rect();
      paramView.getHitRect(localRect);
      return localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return false;
  }
  
  private void init()
  {
    a(this);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout = new XLoadMoreLayout(getContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix = new ReadInjoyXRecyclerView.3(this, getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix, localLayoutParams);
    this.jdField_a_of_type_Auwt = new auwt(this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout, getContext());
    this.jdField_a_of_type_Auwt.uh(true);
    this.jdField_a_of_type_Auwt.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix.addFooterView(this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix.addOnScrollListener(new nhv(this));
  }
  
  public boolean B(View paramView)
  {
    boolean bool = ((Boolean)this.m.get()).booleanValue();
    this.m.set(Boolean.valueOf(false));
    if ((this.jdField_a_of_type_Npy != null) && (paramView == this.jdField_a_of_type_Npy.d(this)))
    {
      this.jdField_a_of_type_Npy.pY(bool);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView$a != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView$a.a(this, bool);
      }
    }
    return true;
  }
  
  @TargetApi(14)
  protected boolean Fi()
  {
    return !this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix.canScrollVertically(-1);
  }
  
  @TargetApi(14)
  protected boolean Fj()
  {
    return !this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix.canScrollVertically(1);
  }
  
  public void M(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Npy != null) && (paramView == this.jdField_a_of_type_Npy.d(this))) {
      this.jdField_a_of_type_Npy.ag(paramInt, this.ob);
    }
  }
  
  public boolean R(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView$a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView$a.a(this, 0);
    }
    return true;
  }
  
  public RecyclerViewWithHeaderFooterFix a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix;
  }
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  public void aCB()
  {
    if (this.jdField_a_of_type_Npy != null) {
      this.jdField_a_of_type_Npy.aCB();
    }
    pn(true);
  }
  
  public void aXi() {}
  
  public void aXj()
  {
    this.m.set(Boolean.valueOf(true));
    tl(1);
  }
  
  public void aXk()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix.stopScroll();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix.scrollToPosition(0);
  }
  
  public void ad(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XRecyclerView", 2, "loadMoreComplete(): hasMoreData=" + paramBoolean2);
    }
    this.jdField_a_of_type_Auwt.ax(paramBoolean1, paramBoolean2);
    this.jdField_a_of_type_Auwt.uh(paramBoolean2);
  }
  
  protected View an()
  {
    View localView = this.jdField_a_of_type_Npy.d(this);
    if ((this.jdField_a_of_type_Npy instanceof ReadInJoySkinAnimManager))
    {
      setPullHeaderBgDrawable(new ColorDrawable(Color.parseColor("#F7F7F7")));
      return localView;
    }
    setPullHeaderBgDrawable(getResources().getDrawable(2130839645));
    return localView;
  }
  
  protected View ao()
  {
    return null;
  }
  
  public void dd(View paramView)
  {
    if ((this.jdField_a_of_type_Npy != null) && (paramView == this.jdField_a_of_type_Npy.d(this))) {
      this.jdField_a_of_type_Npy.ag(100, this.ob);
    }
  }
  
  protected void pm(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.aso = paramBoolean;
      return;
    }
  }
  
  public void pn(boolean paramBoolean)
  {
    super.pn(paramBoolean);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView$a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView$a.aCB();
    }
  }
  
  protected void pp(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix.mInterceptTouchEvent = paramBoolean;
  }
  
  public void q(View paramView, boolean paramBoolean) {}
  
  protected int qr()
  {
    return this.jdField_a_of_type_Npy.qC();
  }
  
  public void setRefreshCallback(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView$a = parama;
  }
  
  public void t(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Npy != null)
    {
      aXh();
      this.jdField_a_of_type_Npy.t(paramBoolean, paramString);
    }
  }
  
  protected boolean z(MotionEvent paramMotionEvent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix.getLayoutManager();
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      localObject = (StaggeredGridLayoutManager)localObject;
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)localObject).findFirstVisibleItemPositions(arrayOfInt);
      return i(((StaggeredGridLayoutManager)localObject).findViewByPosition(arrayOfInt[0]), paramMotionEvent);
    }
    if ((localObject instanceof LinearLayoutManager))
    {
      localObject = (LinearLayoutManager)localObject;
      return i(((LinearLayoutManager)localObject).findViewByPosition(((LinearLayoutManager)localObject).findFirstVisibleItemPosition()), paramMotionEvent);
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(ReadInjoyXRecyclerView paramReadInjoyXRecyclerView, int paramInt);
    
    public abstract void a(ReadInjoyXRecyclerView paramReadInjoyXRecyclerView, boolean paramBoolean);
    
    public abstract void aCB();
  }
  
  public static abstract interface b
  {
    public abstract boolean z(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView
 * JD-Core Version:    0.7.0.1
 */