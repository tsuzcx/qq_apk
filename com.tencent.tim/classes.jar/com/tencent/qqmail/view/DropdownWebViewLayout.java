package com.tencent.qqmail.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;

public class DropdownWebViewLayout
  extends FrameLayout
{
  public static final int DROPDOWN_ANIMATION_DURING = 200;
  public static final int STATUS_PULL_TO_REFRESH = 0;
  @Deprecated
  public static final int STATUS_REFRESHING = 2;
  public static final int STATUS_REFRESH_FINISHED = 3;
  @Deprecated
  public static final int STATUS_RELEASE_TO_REFRESH = 1;
  private static final String TAG = DropdownWebViewLayout.class.getSimpleName();
  private boolean ableToPull = true;
  private int currentStatus = 3;
  private View header;
  private Scroller mScroller;
  private double mTopMarginRatio = 0.75D;
  private MotionEvent mousedownEvent = null;
  private OnPullListener onPullListener = null;
  private int touchSlop;
  private TitleBarWebView2 webView;
  private float yDown;
  
  public DropdownWebViewLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DropdownWebViewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.touchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mScroller = new Scroller(paramContext);
  }
  
  private boolean canPulled()
  {
    if (getResources().getConfiguration().orientation == 2) {}
    while (getHeight() / 4 < -getScrollY()) {
      return true;
    }
    return false;
  }
  
  private boolean dispatchChildTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mousedownEvent != null)
    {
      super.dispatchTouchEvent(this.mousedownEvent);
      this.mousedownEvent = null;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  private void setWebView(WebView paramWebView)
  {
    if (this.header == null)
    {
      this.header = LayoutInflater.from(getContext()).inflate(2131559849, null, false);
      super.addView(this.header, -1, new FrameLayout.LayoutParams(-1, -2));
    }
    if (this.webView != null)
    {
      removeView(this.webView);
      this.webView.removeAllViews();
      this.webView.destroy();
      this.webView = null;
    }
    this.webView = ((TitleBarWebView2)paramWebView);
    if (this.webView != null) {
      super.addView(this.webView, -1, new FrameLayout.LayoutParams(-1, -1));
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof WebView))
    {
      setWebView((WebView)paramView);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      invalidate();
    }
    super.computeScroll();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = getResources().getConfiguration().orientation;
    if ((this.ableToPull) && (i != 2))
    {
      switch (paramMotionEvent.getAction())
      {
      case 1: 
      default: 
        i = (int)(paramMotionEvent.getRawY() - this.yDown);
        if (this.currentStatus != 0) {
          break label371;
        }
        if (canPulled()) {
          if (this.onPullListener != null)
          {
            this.header.setVisibility(4);
            this.onPullListener.onPulled(this.header, this.webView, i);
            smoothScrollTo(0, 0);
          }
        }
        break;
      }
      for (this.currentStatus = 3;; this.currentStatus = 3)
      {
        this.mousedownEvent = null;
        do
        {
          do
          {
            do
            {
              return true;
              this.yDown = paramMotionEvent.getRawY();
              this.mousedownEvent = null;
              dispatchChildTouchEvent(paramMotionEvent);
              return true;
              i = (int)(paramMotionEvent.getRawY() - this.yDown);
            } while (this.currentStatus == 1);
            if (this.currentStatus == 0)
            {
              if (i <= 0)
              {
                this.currentStatus = 3;
                smoothScrollTo(0, 0);
                i = paramMotionEvent.getAction();
                paramMotionEvent.setAction(0);
                dispatchChildTouchEvent(paramMotionEvent);
                paramMotionEvent.setAction(i);
                return dispatchChildTouchEvent(paramMotionEvent);
              }
              smoothScrollTo(0, (int)(-i * this.mTopMarginRatio));
              this.onPullListener.onPullStatus(canPulled());
              return true;
            }
          } while (this.currentStatus == 2);
          if ((i <= 1) || (this.webView == null) || (this.webView.getScrollY() != 0) || (this.webView.isSelectingAndTop()) || (paramMotionEvent.getPointerCount() != 1)) {
            break;
          }
          this.header.setVisibility(0);
          i = paramMotionEvent.getAction();
          paramMotionEvent.setAction(3);
          dispatchChildTouchEvent(paramMotionEvent);
          paramMotionEvent.setAction(i);
          this.currentStatus = 0;
        } while (this.onPullListener == null);
        this.onPullListener.onStartPull(this.header);
        return true;
        return dispatchChildTouchEvent(paramMotionEvent);
        smoothScrollTo(0, 0);
      }
      label371:
      return dispatchChildTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public int getWebViewScrollY()
  {
    if (this.webView != null) {
      return this.webView.getScrollY();
    }
    return 0;
  }
  
  public void invalidateWebView()
  {
    if (this.webView != null) {
      this.webView.invalidate();
    }
  }
  
  public boolean isDropdown()
  {
    return this.currentStatus == 3;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.header != null) {
      ((FrameLayout.LayoutParams)this.header.getLayoutParams()).topMargin = (-this.header.getMeasuredHeight());
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void release()
  {
    this.webView = null;
    this.header = null;
  }
  
  public void scrollToWebView(int paramInt)
  {
    if (this.webView != null) {
      this.webView.scrollTo(this.webView.getScrollX(), paramInt);
    }
  }
  
  public void setAbleToPull(boolean paramBoolean)
  {
    this.ableToPull = paramBoolean;
  }
  
  public void setOnPullListener(OnPullListener paramOnPullListener)
  {
    this.onPullListener = paramOnPullListener;
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2)
  {
    this.mScroller.startScroll(this.mScroller.getFinalX(), this.mScroller.getFinalY(), paramInt1, paramInt2);
    invalidate();
  }
  
  public void smoothScrollTo(int paramInt1, int paramInt2)
  {
    smoothScrollBy(paramInt1 - this.mScroller.getFinalX(), paramInt2 - this.mScroller.getFinalY());
  }
  
  public static abstract interface OnPullListener
  {
    public abstract void onPullStatus(boolean paramBoolean);
    
    public abstract int onPulled(View paramView, WebView paramWebView, int paramInt);
    
    public abstract void onStartPull(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.DropdownWebViewLayout
 * JD-Core Version:    0.7.0.1
 */