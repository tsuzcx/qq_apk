package com.tencent.widget.pull2refresh;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import auwr;
import auwz;
import auwz.a;
import auwz.b;
import auxd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecyclerViewWithHeaderFooter
  extends RecyclerViewCompat
{
  private auwz.a a;
  private auwz.b b;
  private final List<View> kd = new ArrayList();
  private final List<View> ke = new ArrayList();
  public boolean mInterceptTouchEvent;
  
  public RecyclerViewWithHeaderFooter(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecyclerViewWithHeaderFooter(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecyclerViewWithHeaderFooter(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean W(View paramView)
  {
    return this.kd.contains(paramView);
  }
  
  public void addFooterView(View paramView)
  {
    this.ke.add(paramView);
  }
  
  public void addHeaderView(View paramView)
  {
    this.kd.add(paramView);
  }
  
  public void al(View paramView)
  {
    this.kd.remove(paramView);
  }
  
  public int getHeaderViewsCount()
  {
    if (this.kd != null) {
      return this.kd.size();
    }
    return 0;
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
      localObject = new auwz(paramAdapter);
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
      if (this.b != null) {
        ((auwz)localObject).setOnBindHeaderObserver(this.b);
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
  
  public void setOnBindHeaderObserver(auwz.b paramb)
  {
    this.b = paramb;
    if ((getAdapter() instanceof auwz)) {
      ((auwz)getAdapter()).setOnBindHeaderObserver(paramb);
    }
  }
  
  public void setRecycledViewPool(RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    super.setRecycledViewPool(new auxd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter
 * JD-Core Version:    0.7.0.1
 */