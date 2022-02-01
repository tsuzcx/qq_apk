package com.tencent.qqmail.activity.webviewexplorer;

import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.thread.Threads;

class WebViewExplorer$3
  implements ICallBack
{
  WebViewExplorer$3(WebViewExplorer paramWebViewExplorer) {}
  
  public void callback(Object paramObject)
  {
    Threads.runOnMainThread(new WebViewExplorer.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer.3
 * JD-Core Version:    0.7.0.1
 */