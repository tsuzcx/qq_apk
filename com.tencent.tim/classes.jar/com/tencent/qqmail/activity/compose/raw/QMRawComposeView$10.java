package com.tencent.qqmail.activity.compose.raw;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.richeditor.QMEditText;

class QMRawComposeView$10
  implements View.OnClickListener
{
  QMRawComposeView$10(QMRawComposeView paramQMRawComposeView) {}
  
  public void onClick(View paramView)
  {
    QMRawComposeView.access$300(this.this$0).requestFocus();
    ((InputMethodManager)this.this$0.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
    this.this$0.postDelayed(new QMRawComposeView.10.1(this), 1000L);
    this.this$0.scrollClickChange(QMRawComposeView.access$300(this.this$0), false);
    QMNotification.postNotification("focus_addr_edittext", Boolean.valueOf(false));
    Log.v("baihan", "contentContainer click, post Notification,false");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.raw.QMRawComposeView.10
 * JD-Core Version:    0.7.0.1
 */