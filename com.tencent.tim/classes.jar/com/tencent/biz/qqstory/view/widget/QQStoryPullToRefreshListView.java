package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import aqiw;
import auuo;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipListView;
import rsn;
import rsp;
import txn;

public class QQStoryPullToRefreshListView
  extends SwipListView
  implements auuo, AbsListView.e
{
  protected a a;
  public rsn a;
  private rsp a;
  private String aBW;
  private int buL = -1;
  public PullRefreshHeader e;
  private AbsListView.e mOnScrollListener;
  private View.OnTouchListener n;
  
  public QQStoryPullToRefreshListView(Context paramContext)
  {
    super(paramContext.getApplicationContext());
    this.jdField_a_of_type_Rsp = new rsp(this);
    bwh();
  }
  
  public QQStoryPullToRefreshListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Rsp = new rsp(this);
    bwh();
  }
  
  public QQStoryPullToRefreshListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Rsp = new rsp(this);
    bwh();
  }
  
  private void bwh()
  {
    aTm();
    super.setOnScrollListener(this);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.e.Q(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.e.S(0L);
    if (!aqiw.isNetworkAvailable(getContext().getApplicationContext())) {
      pn(false);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView$a.pullToRefresh();
    }
  }
  
  protected void aTm()
  {
    bqW();
    bwi();
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.e.R(0L);
  }
  
  protected void bqW()
  {
    LoadMoreLayout localLoadMoreLayout = new LoadMoreLayout(getContext());
    this.jdField_a_of_type_Rsn = new rsn(localLoadMoreLayout, getContext().getApplicationContext());
    super.addFooterView(localLoadMoreLayout);
  }
  
  protected void bwi()
  {
    this.e = ((PullRefreshHeader)LayoutInflater.from(super.getContext()).inflate(2131561945, this, false));
    this.e.setTextColor(-1, -1, -1, -1, -1);
    this.e.setHeaderBgDrawable(getResources().getDrawable(2130839645));
    super.setOverScrollHeight(super.getResources().getDimensionPixelSize(2131299308));
    super.setOverScrollHeader(this.e);
    super.setOverScrollListener(this.jdField_a_of_type_Rsp);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    this.e.S(0L);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (paramInt1 == this.buL) {}
    do
    {
      return;
      this.buL = paramInt1;
    } while (paramInt3 - (paramInt1 + paramInt2) > this.jdField_a_of_type_Rsn.tV());
    this.jdField_a_of_type_Rsn.ui(true);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    View.OnTouchListener localOnTouchListener = this.n;
    if (localOnTouchListener != null) {
      localOnTouchListener.onTouch(this, paramMotionEvent);
    }
    return bool;
  }
  
  public void pn(boolean paramBoolean)
  {
    if (this.e == null) {
      return;
    }
    if (paramBoolean) {
      this.e.tT(0);
    }
    for (;;)
    {
      postDelayed(new QQStoryPullToRefreshListView.1(this), 800L);
      return;
      this.e.tT(1);
    }
  }
  
  public void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    if (this.aBW != null)
    {
      if (paramInt == 0) {
        txn.a().stopMonitorScene(this.aBW, false);
      }
    }
    else {
      return;
    }
    txn.a().startMonitorScene(this.aBW);
  }
  
  public void setActTAG(String paramString)
  {
    this.aBW = paramString;
  }
  
  public void setOnScrollListener(AbsListView.e parame)
  {
    this.mOnScrollListener = parame;
  }
  
  public void setOnTouchExtraListener(View.OnTouchListener paramOnTouchListener)
  {
    this.n = paramOnTouchListener;
  }
  
  public void setPullToRefreshListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void pullToRefresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView
 * JD-Core Version:    0.7.0.1
 */