package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class ContactFilterHistoryMailFragment$1
  implements View.OnClickListener
{
  ContactFilterHistoryMailFragment$1(ContactFilterHistoryMailFragment paramContactFilterHistoryMailFragment, ContactFilterHistoryMailFragment.DataHolder paramDataHolder) {}
  
  public void onClick(View paramView)
  {
    UITableItemView localUITableItemView = (UITableItemView)paramView;
    ContactFilterHistoryMailFragment.DataHolder localDataHolder = this.val$d;
    boolean bool;
    if (!this.val$d.mChecked)
    {
      bool = true;
      localDataHolder.mChecked = bool;
      localUITableItemView.setChecked(this.val$d.mChecked);
      if (this.val$d.mChecked)
      {
        if (this.val$d.email == null) {
          break label79;
        }
        DataCollector.logEvent("Event_Contact_HistoryMail_Filter_Emails");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      label79:
      if (this.val$d.mAcc != null) {
        DataCollector.logEvent("Event_Contact_HistoryMail_Filter_Accounts");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactFilterHistoryMailFragment.1
 * JD-Core Version:    0.7.0.1
 */