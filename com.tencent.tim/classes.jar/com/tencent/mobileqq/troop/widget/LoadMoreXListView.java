package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import rsn;

public class LoadMoreXListView
  extends XListView
  implements AbsListView.e
{
  public rsn a;
  private int buL = -1;
  private AbsListView.e mOnScrollListener;
  
  public LoadMoreXListView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public LoadMoreXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public LoadMoreXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  protected void bqW()
  {
    LoadMoreLayout localLoadMoreLayout = new LoadMoreLayout(getContext());
    this.a = new rsn(localLoadMoreLayout, getContext().getApplicationContext());
    super.addFooterView(localLoadMoreLayout);
  }
  
  protected void init()
  {
    bqW();
    super.setOnScrollListener(this);
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
    } while (paramInt3 - (paramInt1 + paramInt2) > this.a.tV());
    this.a.ui(true);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void setOnScrollListener(AbsListView.e parame)
  {
    this.mOnScrollListener = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.LoadMoreXListView
 * JD-Core Version:    0.7.0.1
 */