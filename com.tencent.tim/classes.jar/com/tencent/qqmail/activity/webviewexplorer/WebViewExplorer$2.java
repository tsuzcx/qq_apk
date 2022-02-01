package com.tencent.qqmail.activity.webviewexplorer;

import com.tencent.qqmail.account.watcher.AccountLoginWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class WebViewExplorer$2
  implements AccountLoginWatcher
{
  WebViewExplorer$2(WebViewExplorer paramWebViewExplorer) {}
  
  public void onError(int paramInt1, long paramLong, QMNetworkError paramQMNetworkError, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    WebViewExplorer.access$300(this.this$0, new WebViewExplorer.2.2(this, paramInt1));
  }
  
  public void onProcess(int paramInt, long paramLong) {}
  
  public void onSuccess(int paramInt, long paramLong, boolean paramBoolean)
  {
    WebViewExplorer.access$200(this.this$0, new WebViewExplorer.2.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer.2
 * JD-Core Version:    0.7.0.1
 */