package com.tencent.qqmail.activity.webviewexplorer;

import android.webkit.HttpAuthHandler;
import android.widget.EditText;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class WebViewExplorer$BaseWebViewClient$4
  implements QMUIDialogAction.ActionListener
{
  WebViewExplorer$BaseWebViewClient$4(WebViewExplorer.BaseWebViewClient paramBaseWebViewClient, HttpAuthHandler paramHttpAuthHandler, EditText paramEditText1, EditText paramEditText2) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    this.val$handler.proceed(this.val$usernameEd.getText().toString(), this.val$passwordEd.getText().toString());
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer.BaseWebViewClient.4
 * JD-Core Version:    0.7.0.1
 */