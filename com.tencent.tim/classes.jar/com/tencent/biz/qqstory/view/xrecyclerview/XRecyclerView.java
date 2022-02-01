package com.tencent.biz.qqstory.view.xrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import rsn;
import rtf;

public class XRecyclerView
  extends FrameLayout
{
  private RecyclerViewWithHeaderFooter a;
  private rsn c;
  
  public XRecyclerView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public XRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  public XRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private void bqW()
  {
    LoadMoreLayout localLoadMoreLayout = new LoadMoreLayout(getContext());
    this.c = new rsn(localLoadMoreLayout, getContext());
    this.a.addFooterView(localLoadMoreLayout);
    this.a.setOnScrollListener(new rtf(this));
  }
  
  private void initView(Context paramContext)
  {
    this.a = ((RecyclerViewWithHeaderFooter)LayoutInflater.from(paramContext).inflate(2131561946, this).findViewById(2131377573));
    bqW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.xrecyclerview.XRecyclerView
 * JD-Core Version:    0.7.0.1
 */