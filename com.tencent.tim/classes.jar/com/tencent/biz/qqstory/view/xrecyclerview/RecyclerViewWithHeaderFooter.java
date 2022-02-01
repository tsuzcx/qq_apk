package com.tencent.biz.qqstory.view.xrecyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rtb;
import rtb.a;

public class RecyclerViewWithHeaderFooter
  extends RecyclerView
{
  private rtb.a a;
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
  
  public void addFooterView(View paramView)
  {
    this.ke.add(paramView);
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
      localObject = new rtb(paramAdapter);
      paramAdapter = this.kd.iterator();
      while (paramAdapter.hasNext()) {
        ((rtb)localObject).co((View)paramAdapter.next());
      }
      paramAdapter = this.ke.iterator();
      while (paramAdapter.hasNext()) {
        ((rtb)localObject).dW((View)paramAdapter.next());
      }
      if (this.a != null) {
        ((rtb)localObject).a(this.a);
      }
    }
    super.setAdapter((RecyclerView.Adapter)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.xrecyclerview.RecyclerViewWithHeaderFooter
 * JD-Core Version:    0.7.0.1
 */