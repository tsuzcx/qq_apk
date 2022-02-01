package com.tencent.qqmail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class ObservableRelativeLayout
  extends RelativeLayout
{
  private static final String TAG = "tagorewang:ObservableRelativeLayout";
  private boolean mAttachedToWindow = false;
  private OnLayoutChangedListener mListener;
  
  public ObservableRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ObservableRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ObservableRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean isAttachedToWindowCompat()
  {
    return this.mAttachedToWindow;
  }
  
  protected void onAttachedToWindow()
  {
    Log.d("tagorewang:ObservableRelativeLayout", "onAttachedToWindow");
    super.onAttachedToWindow();
    this.mAttachedToWindow = true;
    if (this.mListener != null) {
      this.mListener.onAttachedToWindow();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Log.d("tagorewang:ObservableRelativeLayout", "onDetachedFromWindow");
    super.onDetachedFromWindow();
    this.mAttachedToWindow = false;
    if (this.mListener != null)
    {
      Log.d("tagorewang:ObservableRelativeLayout", "afterDetachedFromWindow");
      this.mListener.afterDetachedFromWindow();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      Log.w("tagorewang:ObservableRelativeLayout", "onInterceptTouchEvent null event");
    }
    while (WindowCheckTask.filterTouchEventForSecurity(paramMotionEvent)) {
      return true;
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.mListener != null))
    {
      Log.d("tagorewang:ObservableRelativeLayout", "onLayoutChanged");
      this.mListener.onLayoutChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    Log.d("tagorewang:ObservableRelativeLayout", "onVisibilityChanged");
    super.onVisibilityChanged(paramView, paramInt);
    if (this.mListener != null) {
      this.mListener.onVisibilityChanged(paramView, paramInt);
    }
  }
  
  public void setOnLayoutChangedListener(OnLayoutChangedListener paramOnLayoutChangedListener)
  {
    this.mListener = paramOnLayoutChangedListener;
  }
  
  public static class OnLayoutChangedAdapter
    implements ObservableRelativeLayout.OnLayoutChangedListener
  {
    public void afterDetachedFromWindow() {}
    
    public void onAttachedToWindow() {}
    
    public void onLayoutChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public void onVisibilityChanged(View paramView, int paramInt) {}
  }
  
  public static abstract interface OnLayoutChangedListener
  {
    public abstract void afterDetachedFromWindow();
    
    public abstract void onAttachedToWindow();
    
    public abstract void onLayoutChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void onVisibilityChanged(View paramView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.ObservableRelativeLayout
 * JD-Core Version:    0.7.0.1
 */