package com.tencent.qqmail.activity.reademl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.view.TitleBarWebView2;

class QMReadEmlActivity$11
  implements View.OnClickListener
{
  QMReadEmlActivity$11(QMReadEmlActivity paramQMReadEmlActivity) {}
  
  public void onClick(View paramView)
  {
    if (QMReadEmlActivity.access$2800(this.this$0).getWebView() != null) {
      QMReadEmlActivity.access$2800(this.this$0).getWebView().smoothToToolBar();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.11
 * JD-Core Version:    0.7.0.1
 */