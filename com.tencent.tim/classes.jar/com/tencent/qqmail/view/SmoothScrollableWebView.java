package com.tencent.qqmail.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.Scroller;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;

public class SmoothScrollableWebView
  extends WebView
{
  protected Scroller mScroller;
  
  public SmoothScrollableWebView(Context paramContext)
  {
    super(paramContext);
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
    if ((!QMApplicationContext.enableAccelerating) && (Build.VERSION.SDK_INT >= 11)) {
      setLayerType(1, null);
    }
    QMLog.log(4, "SmoothScrollableWebView", "HARDWARD_ACCELERATED: " + QMApplicationContext.enableAccelerating);
  }
  
  public SmoothScrollableWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
    if ((!QMApplicationContext.enableAccelerating) && (Build.VERSION.SDK_INT >= 11)) {
      setLayerType(1, null);
    }
    QMLog.log(4, "SmoothScrollableWebView", "HARDWARD_ACCELERATED: " + QMApplicationContext.enableAccelerating);
  }
  
  public void computeScroll()
  {
    try
    {
      if ((this.mScroller != null) && (this.mScroller.computeScrollOffset()))
      {
        scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
        postInvalidate();
      }
      super.computeScroll();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 < 0) {
      this.mScroller.startScroll(getScrollX(), getScrollY(), paramInt1, paramInt2);
    }
    for (;;)
    {
      invalidate();
      return;
      this.mScroller.startScroll(getScrollX(), getScrollY(), paramInt1, paramInt2, paramInt3);
    }
  }
  
  protected void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mScroller != null)
    {
      this.mScroller.abortAnimation();
      this.mScroller = null;
    }
    this.mScroller = new Scroller(getContext());
    smoothScrollBy(paramInt1 - getScrollX(), paramInt2 - getScrollY(), paramInt3);
  }
  
  public void smoothToTop()
  {
    if (getScrollY() != 0) {
      smoothScrollTo(getScrollX(), 0, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.SmoothScrollableWebView
 * JD-Core Version:    0.7.0.1
 */