package com.tencent.mobileqq.activity.contacts.troop;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;

class ContactsTroopAdapter$4
  implements Runnable
{
  ContactsTroopAdapter$4(ContactsTroopAdapter paramContactsTroopAdapter) {}
  
  public void run()
  {
    ((TroopManager)this.this$0.mApp.getManager(52)).eg();
    this.this$0.mApp.runOnUiThread(new ContactsTroopAdapter.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter.4
 * JD-Core Version:    0.7.0.1
 */