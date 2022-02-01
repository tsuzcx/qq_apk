package com.tencent.mobileqq.lyric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ScrollView;
import android.widget.Scroller;
import java.util.Timer;

public class LyricViewScroll
  extends ScrollView
{
  protected Timer H;
  private a a;
  protected volatile boolean cmv;
  private volatile boolean mIsScrolling;
  protected volatile int mLastY;
  private volatile boolean mScrollEnable = true;
  protected Scroller mScroller;
  
  public LyricViewScroll(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mScroller = new Scroller(paramContext, new AccelerateDecelerateInterpolator());
  }
  
  public void Qp(int paramInt)
  {
    if (!this.mIsScrolling)
    {
      paramInt -= this.mLastY;
      if (paramInt != 0)
      {
        this.mScroller.startScroll(this.mScroller.getFinalX(), this.mLastY, 0, paramInt, 500);
        this.mLastY = this.mScroller.getFinalY();
        invalidate();
      }
    }
  }
  
  public void Qq(int paramInt)
  {
    if (!this.mIsScrolling)
    {
      this.mScroller.forceFinished(true);
      this.mLastY = paramInt;
      scrollTo(0, paramInt);
    }
  }
  
  public boolean ak(MotionEvent paramMotionEvent)
  {
    if (!this.mScrollEnable) {
      return true;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      Log.v("LyricViewScroll", "default:" + paramMotionEvent.getAction());
    }
    for (;;)
    {
      try
      {
        this.mScroller.forceFinished(true);
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent)
      {
        Log.e("LyricViewScroll", paramMotionEvent.toString());
      }
      Log.v("LyricViewScroll", "onTouchEvent -> ACTION_DOWN");
      this.mIsScrolling = true;
      if ((this.cmv) && (this.H != null))
      {
        this.H.cancel();
        this.cmv = false;
        continue;
        this.mIsScrolling = true;
        if (this.a != null)
        {
          this.a.Qo(getScrollY());
          continue;
          Log.v("LyricViewScroll", "onTouchEvent -> ACTION_UP");
          if (!this.cmv)
          {
            this.cmv = true;
            this.H = new Timer();
            this.H.scheduleAtFixedRate(new LyricViewScroll.1(this), 100L, 100L);
            continue;
            Log.v("LyricViewScroll", "onTouchEvent -> ACTION_CANCEL");
            this.mLastY = getScrollY();
            this.a.Qn(this.mLastY);
            this.mIsScrolling = false;
            if ((this.cmv) && (this.H != null))
            {
              this.H.cancel();
              this.cmv = false;
            }
          }
        }
      }
    }
    return false;
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if ((this.mScroller.computeScrollOffset()) && (!this.mIsScrolling))
    {
      smoothScrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      postInvalidate();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.mScrollEnable = paramBoolean;
  }
  
  public void setScrollListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void Qn(int paramInt);
    
    public abstract void Qo(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewScroll
 * JD-Core Version:    0.7.0.1
 */