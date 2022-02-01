package com.tencent.qqmail.activity.vipcontacts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.protocol.DataCollector;

class VIPContactsOtherFragment$6
  implements View.OnClickListener
{
  VIPContactsOtherFragment$6(VIPContactsOtherFragment paramVIPContactsOtherFragment) {}
  
  public void onClick(View paramView)
  {
    DataCollector.logEvent("Event_Contact_Click_Add_Vip");
    QMContactManager.sharedInstance().setVip(VIPContactsAdapter.getSelectContacts(), true);
    VIPContactsAdapter.clearSelectContacts();
    VIPContactsOtherFragment.access$300(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsOtherFragment.6
 * JD-Core Version:    0.7.0.1
 */