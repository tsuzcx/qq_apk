package com.tencent.qqmail.utilities.ui;

import android.util.Log;
import com.tencent.qqmail.view.TitleBarWebView2;

class QMScaleWebViewController$QMScaleWebViewJavascriptInterface$2
  implements Runnable
{
  QMScaleWebViewController$QMScaleWebViewJavascriptInterface$2(QMScaleWebViewController.QMScaleWebViewJavascriptInterface paramQMScaleWebViewJavascriptInterface) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("resetContentHeight2: ");
    if (QMScaleWebViewController.access$000(this.this$1.this$0) != null) {}
    for (Integer localInteger = Integer.valueOf(QMScaleWebViewController.access$000(this.this$1.this$0).hashCode());; localInteger = null)
    {
      Log.d("QMScaleWebView", localInteger);
      if (QMScaleWebViewController.access$000(this.this$1.this$0) != null) {
        QMScaleWebViewController.access$000(this.this$1.this$0).resetContentHeight2();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMScaleWebViewController.QMScaleWebViewJavascriptInterface.2
 * JD-Core Version:    0.7.0.1
 */