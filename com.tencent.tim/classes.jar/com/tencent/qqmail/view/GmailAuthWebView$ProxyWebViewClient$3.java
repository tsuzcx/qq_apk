package com.tencent.qqmail.view;

import android.webkit.SslErrorHandler;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class GmailAuthWebView$ProxyWebViewClient$3
  implements QMUIDialogAction.ActionListener
{
  GmailAuthWebView$ProxyWebViewClient$3(GmailAuthWebView.ProxyWebViewClient paramProxyWebViewClient, SslErrorHandler paramSslErrorHandler) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    if (this.val$handler != null) {
      this.val$handler.proceed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.GmailAuthWebView.ProxyWebViewClient.3
 * JD-Core Version:    0.7.0.1
 */