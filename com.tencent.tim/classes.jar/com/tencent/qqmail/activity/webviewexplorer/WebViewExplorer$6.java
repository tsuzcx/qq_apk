package com.tencent.qqmail.activity.webviewexplorer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.view.QMWebView;

class WebViewExplorer$6
  implements View.OnClickListener
{
  WebViewExplorer$6(WebViewExplorer paramWebViewExplorer) {}
  
  public void onClick(View paramView)
  {
    this.this$0.mWebView.smoothToTop();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer.6
 * JD-Core Version:    0.7.0.1
 */