package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;

class ComposeContactsActivity$19
  implements View.OnClickListener
{
  ComposeContactsActivity$19(ComposeContactsActivity paramComposeContactsActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.gotoRTXContactList();
    DataCollector.logEvent("Event_RTX_Compose_Contact_Click");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeContactsActivity.19
 * JD-Core Version:    0.7.0.1
 */