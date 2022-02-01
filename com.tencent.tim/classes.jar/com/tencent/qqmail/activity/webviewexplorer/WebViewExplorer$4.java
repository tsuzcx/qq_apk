package com.tencent.qqmail.activity.webviewexplorer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.QMWebView;

class WebViewExplorer$4
  implements View.OnClickListener
{
  WebViewExplorer$4(WebViewExplorer paramWebViewExplorer) {}
  
  public void onClick(View paramView)
  {
    this.this$0.topBar.getButtonLeft().setSelected(true);
    this.this$0.mWebView.stopLoading();
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer.4
 * JD-Core Version:    0.7.0.1
 */