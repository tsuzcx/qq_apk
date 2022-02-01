package com.tencent.mobileqq.activity.contact.phonecontact;

import aevy;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;

public class PhoneContactManagerImp$1
  implements Runnable
{
  PhoneContactManagerImp$1(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    PhoneContactManagerImp.a(this.this$0, this.this$0.pS());
    PhoneContactManagerImp.a(this.this$0);
    this.this$0.KG = this.this$0.pref.getLong("key_contacts_switches", 0L);
    if (PhoneContactManagerImp.a(this.this$0) != null) {
      aevy localaevy = (aevy)PhoneContactManagerImp.a(this.this$0).getManager(41);
    }
    this.this$0.Uy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.1
 * JD-Core Version:    0.7.0.1
 */