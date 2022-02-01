package com.tencent.qqmail.utilities.ui;

import android.view.ViewGroup;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.TitleBarWebView2;

class QMScaleWebViewController$4
  implements Runnable
{
  QMScaleWebViewController$4(QMScaleWebViewController paramQMScaleWebViewController, TitleBarWebView2 paramTitleBarWebView2) {}
  
  public void run()
  {
    ViewGroup localViewGroup = (ViewGroup)this.val$webView.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(this.val$webView);
    }
    try
    {
      this.val$webView.stopLoading();
      this.val$webView.clearCache(true);
      this.val$webView.destroy();
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMScaleWebViewCtrlr", "webview destroy failed!\n" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMScaleWebViewController.4
 * JD-Core Version:    0.7.0.1
 */