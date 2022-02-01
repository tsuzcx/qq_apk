package com.tencent.qqmail.activity.webviewexplorer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BasicWebViewExplorer$3
  implements View.OnClickListener
{
  BasicWebViewExplorer$3(BasicWebViewExplorer paramBasicWebViewExplorer) {}
  
  public void onClick(View paramView)
  {
    this.this$0.showMoreDialogPopup(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.BasicWebViewExplorer.3
 * JD-Core Version:    0.7.0.1
 */