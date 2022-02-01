package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.protocol.DataCollector;
import moai.fragment.app.FragmentActivity;

class ContactDetailFragment$5$1
  implements Runnable
{
  ContactDetailFragment$5$1(ContactDetailFragment.5 param5) {}
  
  public void run()
  {
    DataCollector.logEvent("Event_Black_White_Name_List_Detail_Click_Remove");
    this.this$1.this$0.getActivity().setResult(-1, null);
    this.this$1.this$0.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactDetailFragment.5.1
 * JD-Core Version:    0.7.0.1
 */