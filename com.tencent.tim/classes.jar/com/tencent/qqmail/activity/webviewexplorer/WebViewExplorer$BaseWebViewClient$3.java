package com.tencent.qqmail.activity.webviewexplorer;

import android.webkit.SslErrorHandler;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class WebViewExplorer$BaseWebViewClient$3
  implements QMUIDialogAction.ActionListener
{
  WebViewExplorer$BaseWebViewClient$3(WebViewExplorer.BaseWebViewClient paramBaseWebViewClient, SslErrorHandler paramSslErrorHandler) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    if (this.val$handler != null) {
      this.val$handler.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer.BaseWebViewClient.3
 * JD-Core Version:    0.7.0.1
 */