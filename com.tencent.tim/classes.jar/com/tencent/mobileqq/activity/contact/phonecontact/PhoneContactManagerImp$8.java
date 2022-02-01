package com.tencent.mobileqq.activity.contact.phonecontact;

import abdz;
import java.util.List;

class PhoneContactManagerImp$8
  implements Runnable
{
  PhoneContactManagerImp$8(PhoneContactManagerImp paramPhoneContactManagerImp, List paramList) {}
  
  public void run()
  {
    if ((this.val$list != null) && (!this.val$list.isEmpty()))
    {
      this.this$0.a = abdz.a(this.val$list, null, true);
      return;
    }
    this.this$0.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.8
 * JD-Core Version:    0.7.0.1
 */