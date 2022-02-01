package com.tencent.qqmail.utilities.ui;

import com.tencent.qqmail.view.TitleBarWebView2;

class QMScaleWebViewController$QMScaleWebViewJavascriptInterface$1
  implements Runnable
{
  QMScaleWebViewController$QMScaleWebViewJavascriptInterface$1(QMScaleWebViewController.QMScaleWebViewJavascriptInterface paramQMScaleWebViewJavascriptInterface, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    synchronized (this.val$result)
    {
      if (QMScaleWebViewController.access$000(this.this$1.this$0) != null)
      {
        this.val$result[0] = QMScaleWebViewController.access$000(this.this$1.this$0).getScale();
        this.val$result.notify();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMScaleWebViewController.QMScaleWebViewJavascriptInterface.1
 * JD-Core Version:    0.7.0.1
 */