package com.tencent.qqmail.utilities.ui;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.JBTitleBarWebView2;
import com.tencent.qqmail.view.TitleBarWebView2;

class QMScaleWebViewController$QMScaleWebViewJavascriptInterface$3
  implements Runnable
{
  QMScaleWebViewController$QMScaleWebViewJavascriptInterface$3(QMScaleWebViewController.QMScaleWebViewJavascriptInterface paramQMScaleWebViewJavascriptInterface) {}
  
  public void run()
  {
    if (QMScaleWebViewController.access$000(this.this$1.this$0) != null) {}
    try
    {
      if ((QMScaleWebViewController.access$000(this.this$1.this$0) instanceof JBTitleBarWebView2))
      {
        ((JBTitleBarWebView2)QMScaleWebViewController.access$000(this.this$1.this$0)).loadedContent();
        QMScaleWebViewController.access$000(this.this$1.this$0).scrollTo(0, 0);
      }
      QMScaleWebViewController.access$000(this.this$1.this$0).setVerticalScrollBarEnabled(true);
      QMScaleWebViewController.access$000(this.this$1.this$0).setHorizontalScrollBarEnabled(true);
      QMScaleWebViewController.access$000(this.this$1.this$0).setZoomEnabled(true);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "QMScaleWebViewCtrlr", localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMScaleWebViewController.QMScaleWebViewJavascriptInterface.3
 * JD-Core Version:    0.7.0.1
 */