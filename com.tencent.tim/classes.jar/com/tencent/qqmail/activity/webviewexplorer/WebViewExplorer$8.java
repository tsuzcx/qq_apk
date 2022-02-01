package com.tencent.qqmail.activity.webviewexplorer;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WebViewExplorer$8
  implements View.OnClickListener
{
  WebViewExplorer$8(WebViewExplorer paramWebViewExplorer) {}
  
  public void onClick(View paramView)
  {
    this.this$0.isWebViewSafeBarCloseClick = true;
    this.this$0.webViewSafeBar.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer.8
 * JD-Core Version:    0.7.0.1
 */