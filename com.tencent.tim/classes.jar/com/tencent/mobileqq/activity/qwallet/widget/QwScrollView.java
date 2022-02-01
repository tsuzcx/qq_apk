package com.tencent.mobileqq.activity.qwallet.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.widget.ScrollView;

public class QwScrollView
  extends ScrollView
{
  private boolean isTouchMove;
  private OnQwScrollListener listener;
  
  public QwScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QwScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QwScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.listener != null) {
      this.listener.onScrollChanged(Boolean.valueOf(this.isTouchMove), this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.listener != null) {
      this.listener.onTouch(this, paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 2) {
      this.isTouchMove = true;
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if (paramMotionEvent.getAction() == 1) {
        this.isTouchMove = false;
      }
    }
  }
  
  public void setOnQwScrollListener(OnQwScrollListener paramOnQwScrollListener)
  {
    this.listener = paramOnQwScrollListener;
  }
  
  public static abstract interface OnQwScrollListener
  {
    public abstract void onScrollChanged(Boolean paramBoolean, ScrollView paramScrollView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void onTouch(ScrollView paramScrollView, MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.QwScrollView
 * JD-Core Version:    0.7.0.1
 */