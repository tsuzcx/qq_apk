package com.tencent.mobileqq.webview.swift;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;

public class SwiftReuseTouchWebView
  extends TouchWebView
{
  private static SwiftReuseTouchWebView b;
  public static int sPoolSize;
  private static final Object sPoolSync = new Object();
  private SwiftReuseTouchWebView a;
  private int aIq;
  public int flag = 0;
  
  private SwiftReuseTouchWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public static SwiftReuseTouchWebView a(Context paramContext)
  {
    SwiftReuseTouchWebView localSwiftReuseTouchWebView = null;
    synchronized (sPoolSync)
    {
      QLog.i("SwiftReuseTouchWebView", 1, "sPool acquire:" + b);
      if (b != null)
      {
        localSwiftReuseTouchWebView = b;
        b = localSwiftReuseTouchWebView.a;
        localSwiftReuseTouchWebView.a = null;
        sPoolSize -= 1;
      }
      if (localSwiftReuseTouchWebView == null) {
        return new SwiftReuseTouchWebView(new MutableContextWrapper(paramContext));
      }
    }
    localSwiftReuseTouchWebView.clearHistory();
    localSwiftReuseTouchWebView.flag = 1;
    localSwiftReuseTouchWebView.aIq += 1;
    localSwiftReuseTouchWebView.onResume();
    ((MutableContextWrapper)localSwiftReuseTouchWebView.getContext()).setBaseContext(paramContext);
    return localSwiftReuseTouchWebView;
  }
  
  public void Th(boolean paramBoolean)
  {
    int i = 0;
    synchronized (sPoolSync)
    {
      if (sPoolSize < 4)
      {
        this.a = b;
        b = this;
        sPoolSize += 1;
        i = 1;
      }
      if (i != 0)
      {
        ((MutableContextWrapper)getContext()).setBaseContext(BaseApplicationImpl.sApplication);
        if (!paramBoolean)
        {
          resetForReuse();
          onPause();
        }
        return;
      }
    }
    super.destroy();
  }
  
  public boolean canGoBack()
  {
    if (1 == this.flag)
    {
      Object localObject = copyBackForwardList();
      if ((localObject != null) && (((WebBackForwardList)localObject).getSize() > 0))
      {
        localObject = ((WebBackForwardList)localObject).getItemAtIndex(0);
        if ((localObject != null) && ("about:blank".equals(((WebHistoryItem)localObject).getUrl()))) {
          return super.canGoBackOrForward(-2);
        }
      }
      return super.canGoBack();
    }
    return super.canGoBack();
  }
  
  public void destroy()
  {
    if (this.aIq > 3)
    {
      super.destroy();
      return;
    }
    if (!"about:blank".equals(getUrl())) {}
    try
    {
      stopLoading();
      loadUrlOriginal("about:blank");
      clearHistory();
      clearView();
      new Handler(Looper.getMainLooper()).postDelayed(new SwiftReuseTouchWebView.1(this), 1000L);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("SwiftReuseTouchWebView", 1, "destroy error:" + localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView
 * JD-Core Version:    0.7.0.1
 */