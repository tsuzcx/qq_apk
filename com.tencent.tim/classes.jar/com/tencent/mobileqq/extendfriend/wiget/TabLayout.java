package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class TabLayout
  extends HorizontalScrollView
{
  private a a;
  private LinearLayout iN;
  protected float mLastX;
  protected float mLastY;
  protected float mf;
  protected float mg;
  
  public TabLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setOverScrollMode(2);
    setHorizontalScrollBarEnabled(false);
    this.iN = new LinearLayout(getContext());
    this.iN.setOrientation(0);
    addView(this.iN, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public void a(a parama)
  {
    int i = 1;
    int k = 0;
    int m;
    if (parama != null)
    {
      m = parama.getCount();
      if (m > 0) {
        break label23;
      }
    }
    for (;;)
    {
      return;
      label23:
      this.a = parama;
      this.iN.removeAllViews();
      int j;
      if (m <= parama.DC())
      {
        setFillViewport(true);
        j = 0;
      }
      while (k < m)
      {
        View localView = parama.L(k);
        if (localView != null)
        {
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, -1, i);
          Rect localRect = parama.c(k);
          localLayoutParams.leftMargin = localRect.left;
          localLayoutParams.topMargin = localRect.top;
          localLayoutParams.rightMargin = localRect.right;
          localLayoutParams.bottomMargin = localRect.bottom;
          this.iN.addView(localView, localLayoutParams);
        }
        k += 1;
        continue;
        j = parama.DD();
        setFillViewport(false);
        i = 0;
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.mg = 0.0F;
      this.mf = 0.0F;
      this.mLastX = paramMotionEvent.getX();
      this.mLastY = paramMotionEvent.getY();
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.mf += Math.abs(f1 - this.mLastX);
      this.mg += Math.abs(f2 - this.mLastY);
      this.mLastX = f1;
      this.mLastY = f2;
      if (this.mf <= this.mg) {
        getParent().requestDisallowInterceptTouchEvent(false);
      } else {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
    }
  }
  
  public ViewGroup j()
  {
    return this.iN;
  }
  
  public static abstract interface a
  {
    public abstract int DC();
    
    public abstract int DD();
    
    public abstract View L(int paramInt);
    
    public abstract Rect c(int paramInt);
    
    public abstract int getCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.TabLayout
 * JD-Core Version:    0.7.0.1
 */