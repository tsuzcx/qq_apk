package com.tencent.mobileqq.activity.contact.phonecontact;

import com.tencent.qphone.base.util.QLog;

class PhoneContactManagerImp$5
  implements Runnable
{
  PhoneContactManagerImp$5(PhoneContactManagerImp paramPhoneContactManagerImp, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("checkUpdateBindStateAndListIgnoreBindState [forced:%s, isQueryAll:%s, from:%s]", new Object[] { Boolean.valueOf(this.boW), Boolean.valueOf(this.boX), Integer.valueOf(this.val$from) }));
    }
    PhoneContactManagerImp.a(this.this$0, this.boW, this.boX, this.val$from);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.5
 * JD-Core Version:    0.7.0.1
 */