package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.protocol.DataCollector;

class ContactDetailFragment$9
  implements View.OnClickListener
{
  ContactDetailFragment$9(ContactDetailFragment paramContactDetailFragment) {}
  
  public void onClick(View paramView)
  {
    ContactsHistoryMailListFragment localContactsHistoryMailListFragment = new ContactsHistoryMailListFragment(ContactDetailFragment.access$100(this.this$0).clone());
    this.this$0.startFragment(localContactsHistoryMailListFragment);
    DataCollector.logEvent("Event_Contact_Click_Go_HistoryMail");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactDetailFragment.9
 * JD-Core Version:    0.7.0.1
 */