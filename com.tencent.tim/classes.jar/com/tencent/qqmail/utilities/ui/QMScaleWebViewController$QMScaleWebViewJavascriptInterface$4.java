package com.tencent.qqmail.utilities.ui;

import android.view.ViewGroup;
import com.tencent.qqmail.utilities.log.QMLog;

class QMScaleWebViewController$QMScaleWebViewJavascriptInterface$4
  implements Runnable
{
  QMScaleWebViewController$QMScaleWebViewJavascriptInterface$4(QMScaleWebViewController.QMScaleWebViewJavascriptInterface paramQMScaleWebViewJavascriptInterface) {}
  
  public void run()
  {
    QMLog.log(4, "QMScaleWebViewCtrlr", "toolbar showToolBar:" + QMScaleWebViewController.access$600(this.this$1.this$0));
    if (QMScaleWebViewController.access$600(this.this$1.this$0) != null) {
      QMScaleWebViewController.access$600(this.this$1.this$0).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMScaleWebViewController.QMScaleWebViewJavascriptInterface.4
 * JD-Core Version:    0.7.0.1
 */