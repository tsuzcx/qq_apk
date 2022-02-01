package com.tencent.qqmail.utilities.ui;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMScaleWebViewController$1
  implements View.OnClickListener
{
  QMScaleWebViewController$1(QMScaleWebViewController paramQMScaleWebViewController) {}
  
  public void onClick(View paramView)
  {
    Log.v("webview_js_log", "click");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMScaleWebViewController.1
 * JD-Core Version:    0.7.0.1
 */