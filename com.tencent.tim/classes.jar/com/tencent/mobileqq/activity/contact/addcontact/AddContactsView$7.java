package com.tencent.mobileqq.activity.contact.addcontact;

import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

class AddContactsView$7
  implements Runnable
{
  AddContactsView$7(AddContactsView paramAddContactsView) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.this$0.app.getManager(11);
    ContactBindedActivity.a(this.this$0.app, 222, localPhoneContactManagerImp.bT());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.7
 * JD-Core Version:    0.7.0.1
 */