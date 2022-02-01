package com.tencent.qqmail.utilities.ui;

import com.tencent.qqmail.view.TitleBarWebView2;

class QMScaleWebViewController$6
  implements Runnable
{
  QMScaleWebViewController$6(QMScaleWebViewController paramQMScaleWebViewController, String paramString) {}
  
  public void run()
  {
    if (QMScaleWebViewController.access$000(this.this$0) != null) {
      QMScaleWebViewController.access$000(this.this$0).loadUrl("javascript:" + this.val$jsCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMScaleWebViewController.6
 * JD-Core Version:    0.7.0.1
 */