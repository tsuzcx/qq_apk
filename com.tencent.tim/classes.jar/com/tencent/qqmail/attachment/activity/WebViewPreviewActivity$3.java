package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WebViewPreviewActivity$3
  implements View.OnClickListener
{
  WebViewPreviewActivity$3(WebViewPreviewActivity paramWebViewPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    WebViewPreviewActivity.access$000(this.this$0, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.WebViewPreviewActivity.3
 * JD-Core Version:    0.7.0.1
 */