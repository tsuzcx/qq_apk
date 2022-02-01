package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

public class HScrollView
  extends HorizontalScrollView
  implements Runnable
{
  private a a;
  private int ccd = -9999999;
  private Handler mHandler = new Handler();
  private int scrollType = 1;
  
  public HScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.scrollType = 2;
      this.a.yL(this.scrollType);
      this.mHandler.removeCallbacks(this);
      continue;
      this.mHandler.post(this);
    }
  }
  
  public void run()
  {
    if (getScrollX() == this.ccd)
    {
      this.scrollType = 1;
      if (this.a != null) {
        this.a.yL(this.scrollType);
      }
      this.mHandler.removeCallbacks(this);
      return;
    }
    this.scrollType = 3;
    if (this.a != null) {
      this.a.yL(this.scrollType);
    }
    this.ccd = getScrollX();
    this.mHandler.postDelayed(this, 50L);
  }
  
  public void setOnScrollListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void yL(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.HScrollView
 * JD-Core Version:    0.7.0.1
 */