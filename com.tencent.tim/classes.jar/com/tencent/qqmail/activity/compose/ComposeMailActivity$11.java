package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.observer.QMNotification;

class ComposeMailActivity$11
  implements View.OnClickListener
{
  ComposeMailActivity$11(ComposeMailActivity paramComposeMailActivity) {}
  
  public void onClick(View paramView)
  {
    if (ComposeMailActivity.access$600(this.this$0) != ComposeCommUI.QMSendType.t_SEND_GROUP_MAIL) {
      QMNotification.postNotification("focus_addr_edittext", Boolean.valueOf(false));
    }
    ComposeMailActivity.access$700(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.11
 * JD-Core Version:    0.7.0.1
 */