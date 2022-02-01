package com.tencent.biz.videostory.widget.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public class CustomHorizontallyScrollRecyclerView
  extends RecyclerView
{
  private float mLastX;
  private float mLastY;
  private LinearLayoutManager mLayoutManager;
  private int mTouchSlop;
  
  public CustomHorizontallyScrollRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CustomHorizontallyScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CustomHorizontallyScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private boolean A(float paramFloat1, float paramFloat2)
  {
    if (this.mLayoutManager == null) {
      this.mLayoutManager = ((LinearLayoutManager)getLayoutManager());
    }
    if (this.mLayoutManager.getChildCount() > 0)
    {
      float f = this.mLastX;
      paramFloat2 -= this.mLastY;
      return (Math.abs(paramFloat2) > this.mTouchSlop) && (Math.abs(paramFloat2) > Math.abs(paramFloat1 - f));
    }
    return false;
  }
  
  private void init()
  {
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.mLastX = paramMotionEvent.getX();
      this.mLastY = paramMotionEvent.getY();
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      if (A(paramMotionEvent.getX(), paramMotionEvent.getY()))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      getParent().requestDisallowInterceptTouchEvent(false);
    }
  }
  
  public void setScrollingTouchSlop(int paramInt)
  {
    super.setScrollingTouchSlop(paramInt);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
      return;
    }
    this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.CustomHorizontallyScrollRecyclerView
 * JD-Core Version:    0.7.0.1
 */