package com.tencent.qqmail.activity.webviewexplorer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CardWebViewExplorer$1
  implements View.OnClickListener
{
  CardWebViewExplorer$1(CardWebViewExplorer paramCardWebViewExplorer) {}
  
  public void onClick(View paramView)
  {
    this.this$0.onBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.CardWebViewExplorer.1
 * JD-Core Version:    0.7.0.1
 */