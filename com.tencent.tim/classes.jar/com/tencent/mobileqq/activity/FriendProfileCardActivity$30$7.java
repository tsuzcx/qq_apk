package com.tencent.mobileqq.activity;

import acfp;
import alcn;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import uzn;

public class FriendProfileCardActivity$30$7
  implements Runnable
{
  public FriendProfileCardActivity$30$7(uzn paramuzn) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.this$0.app.getManager(11);
    if (!localPhoneContactManagerImp.ac(this.a.this$0.a.e.contactName, this.a.this$0.a.e.uin))
    {
      this.a.this$0.aWB = true;
      if (localPhoneContactManagerImp.ad(this.a.this$0.a.e.contactName, this.a.this$0.a.e.uin))
      {
        QQToast.a(this.a.this$0.getApplicationContext(), 2, acfp.m(2131706599), 0).show();
        return;
      }
      QQToast.a(this.a.this$0.getApplicationContext(), 1, acfp.m(2131706629), 0).show();
      return;
    }
    QQToast.a(this.a.this$0.getApplicationContext(), acfp.m(2131706589), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.30.7
 * JD-Core Version:    0.7.0.1
 */