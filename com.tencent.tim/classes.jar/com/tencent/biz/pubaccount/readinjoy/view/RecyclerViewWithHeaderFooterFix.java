package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import auwr;
import auwz;
import auwz.a;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import njb;
import njc;

public class RecyclerViewWithHeaderFooterFix
  extends RecyclerViewCompat
{
  private auwz.a a;
  private final List<View> kd = new ArrayList();
  private final List<View> ke = new ArrayList();
  public boolean mInterceptTouchEvent;
  
  public RecyclerViewWithHeaderFooterFix(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecyclerViewWithHeaderFooterFix(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecyclerViewWithHeaderFooterFix(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  public void addFooterView(View paramView)
  {
    this.ke.add(paramView);
  }
  
  public void addHeaderView(View paramView)
  {
    this.kd.add(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mInterceptTouchEvent)
    {
      super.onInterceptTouchEvent(paramMotionEvent);
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mInterceptTouchEvent)
    {
      if (paramMotionEvent.getAction() == 1) {
        this.mInterceptTouchEvent = false;
      }
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    Object localObject;
    if (this.kd.size() <= 0)
    {
      localObject = paramAdapter;
      if (this.ke.size() <= 0) {}
    }
    else
    {
      localObject = new njb(this, paramAdapter);
      Iterator localIterator = this.kd.iterator();
      while (localIterator.hasNext()) {
        ((auwz)localObject).co((View)localIterator.next());
      }
      localIterator = this.ke.iterator();
      while (localIterator.hasNext()) {
        ((auwz)localObject).dW((View)localIterator.next());
      }
      ((auwz)localObject).setHasStableIds(paramAdapter.hasStableIds());
      if ((getLayoutManager() instanceof GridLayoutManager))
      {
        paramAdapter = (GridLayoutManager)getLayoutManager();
        paramAdapter.setSpanSizeLookup(new auwr((auwz)localObject, paramAdapter));
      }
      if (this.a != null) {
        ((auwz)localObject).a(this.a);
      }
    }
    super.setAdapter((RecyclerView.Adapter)localObject);
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    super.setLayoutManager(paramLayoutManager);
    if ((getAdapter() != null) && ((getAdapter() instanceof auwz)))
    {
      Object localObject = (auwz)getAdapter();
      if ((getLayoutManager() instanceof GridLayoutManager))
      {
        paramLayoutManager = (GridLayoutManager)getLayoutManager();
        localObject = new auwr((auwz)localObject, paramLayoutManager);
        ((auwr)localObject).setSpanSizeLookup(paramLayoutManager.getSpanSizeLookup());
        paramLayoutManager.setSpanSizeLookup((GridLayoutManager.SpanSizeLookup)localObject);
      }
    }
  }
  
  public void setRecycledViewPool(RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    super.setRecycledViewPool(new njc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RecyclerViewWithHeaderFooterFix
 * JD-Core Version:    0.7.0.1
 */