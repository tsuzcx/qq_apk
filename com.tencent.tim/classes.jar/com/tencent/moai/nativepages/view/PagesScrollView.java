package com.tencent.moai.nativepages.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class PagesScrollView
  extends ScrollView
{
  public static final String TAG = "PagesScrollView";
  private int initialPosition = 0;
  private volatile boolean isStartScrollerTask;
  private float lastX;
  private float lastXTouch;
  private float lastY;
  private float lastYTouch;
  private int middlePosition = 0;
  private int newCheck = 50;
  private PagesScrollViewListener scrollViewListener = null;
  private Runnable scrollerTask = new PagesScrollView.1(this);
  private SwipeBackListener swipeBackListener;
  private float xDistance;
  private float xDistanceTouch;
  private float yDistance;
  private float yDistanceTouch;
  
  public PagesScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PagesScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PagesScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setFadingEdgeLength(0);
  }
  
  public void fling(int paramInt)
  {
    super.fling(paramInt / 3);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.scrollViewListener != null) {
      this.scrollViewListener.onScrollStarted(this.initialPosition);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        this.yDistance = 0.0F;
        this.xDistance = 0.0F;
        this.lastX = paramMotionEvent.getX();
        this.lastY = paramMotionEvent.getY();
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.xDistance += Math.abs(f1 - this.lastX);
      this.yDistance += Math.abs(f2 - this.lastY);
      this.lastX = f1;
      this.lastY = f2;
    } while (this.xDistance <= this.yDistance);
    return false;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Log.i("PagesScrollView", "onTouchEvent");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.yDistanceTouch = 0.0F;
      this.xDistanceTouch = 0.0F;
      this.lastXTouch = paramMotionEvent.getX();
      this.lastYTouch = paramMotionEvent.getY();
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if (f1 - this.lastXTouch > 100.0F)
      {
        this.xDistanceTouch += Math.abs(f1 - this.lastX);
        this.yDistanceTouch += Math.abs(f2 - this.lastY);
        this.lastXTouch = f1;
        this.lastYTouch = f2;
        if ((this.xDistanceTouch >= this.yDistanceTouch * 3.0F) && (this.swipeBackListener != null))
        {
          this.swipeBackListener.swipeBack();
          continue;
          postDelayed(this.scrollerTask, 10L);
        }
      }
    }
  }
  
  public void setScrollViewListener(PagesScrollViewListener paramPagesScrollViewListener)
  {
    this.scrollViewListener = paramPagesScrollViewListener;
  }
  
  public void setSwipeBackListener(SwipeBackListener paramSwipeBackListener)
  {
    this.swipeBackListener = paramSwipeBackListener;
  }
  
  public void startScrollerTask()
  {
    if (!this.isStartScrollerTask)
    {
      this.isStartScrollerTask = true;
      this.initialPosition = getScrollY();
      postDelayed(this.scrollerTask, this.newCheck);
      if (this.scrollViewListener != null) {
        this.scrollViewListener.onScrollStarted(getScrollY());
      }
    }
  }
  
  public void stopScrollerTask()
  {
    removeCallbacks(this.scrollerTask);
    this.isStartScrollerTask = false;
  }
  
  public static abstract interface SwipeBackListener
  {
    public abstract void swipeBack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.view.PagesScrollView
 * JD-Core Version:    0.7.0.1
 */