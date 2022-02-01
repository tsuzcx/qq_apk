package com.tencent.qqmail.activity.webviewexplorer;

import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;

class WebViewExplorer$1
  implements QMUnlockFolderPwdWatcher
{
  WebViewExplorer$1(WebViewExplorer paramWebViewExplorer) {}
  
  public void onCancel(int paramInt1, int paramInt2) {}
  
  public void onDismiss(int paramInt1, int paramInt2) {}
  
  public void onError(int paramInt1, int paramInt2)
  {
    WebViewExplorer.access$100(this.this$0, new WebViewExplorer.1.2(this));
  }
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    WebViewExplorer.access$000(this.this$0, new WebViewExplorer.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer.1
 * JD-Core Version:    0.7.0.1
 */