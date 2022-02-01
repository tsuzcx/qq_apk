package com.tencent.qqmail.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebViewClassic.TitleBarDelegate;
import com.tencent.qqmail.utilities.log.QMLog;

public class JBTitleBarWebView2
  extends TitleBarWebView2
  implements WebViewClassic.TitleBarDelegate
{
  private static final long INTERVAL = 10000L;
  private static final long SCROLL_ACTION_INTERVAL = 200L;
  private static final int SCROLL_TO_TOP = 1;
  private ScrollToTopHandler mScrollToTopHandler = null;
  private long scrollToTopTime = 0L;
  
  public JBTitleBarWebView2(Context paramContext)
  {
    super(paramContext);
  }
  
  public JBTitleBarWebView2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public JBTitleBarWebView2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean continueScrollToTop()
  {
    return System.currentTimeMillis() - this.scrollToTopTime < 10000L;
  }
  
  public int getTitleHeight()
  {
    if (this.mTitleBar != null) {
      return this.mTitleBar.getHeight();
    }
    return 0;
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    super.loadData(paramString1, paramString2, paramString3);
    startScrollToTop();
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    startScrollToTop();
  }
  
  public void loadedContent()
  {
    this.scrollToTopTime = (System.currentTimeMillis() - 10000L + 1000L);
  }
  
  protected void onDetachedFromWindow()
  {
    try
    {
      super.onDetachedFromWindow();
      stopScrollToTop();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        QMLog.log(5, TAG, "onDetachedFromWindow", localIllegalArgumentException);
      }
    }
  }
  
  public void onSetEmbeddedTitleBar(View paramView) {}
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.mTitleBar != null) && (continueScrollToTop()))
      {
        super.scrollTo(paramInt1, 0);
        return;
      }
      this.mScrollToTopHandler = null;
      super.scrollTo(paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      stopScrollToTop();
    }
  }
  
  public void setEmbeddedTitleBarCompat(View paramView)
  {
    super.setEmbeddedTitleBarCompat(paramView);
    startScrollToTop();
  }
  
  public void startScrollToTop()
  {
    if (this.mScrollToTopHandler == null)
    {
      this.mScrollToTopHandler = new ScrollToTopHandler(null);
      this.mScrollToTopHandler.sendEmptyMessageDelayed(1, 200L);
    }
    this.scrollToTopTime = System.currentTimeMillis();
  }
  
  public void stopScrollToTop()
  {
    this.scrollToTopTime = (System.currentTimeMillis() - 10000L - 1000L);
    this.mScrollToTopHandler = null;
  }
  
  class ScrollToTopHandler
    extends Handler
  {
    private ScrollToTopHandler() {}
    
    public void handleMessage(Message paramMessage)
    {
      if ((paramMessage.what == 1) && (JBTitleBarWebView2.this.continueScrollToTop())) {
        sendEmptyMessageDelayed(1, 200L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.JBTitleBarWebView2
 * JD-Core Version:    0.7.0.1
 */