package com.tencent.mobileqq.activity.contact.newfriend;

import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import yrx;
import ytp;

public class ContactMatchBuilder$1
  implements Runnable
{
  public ContactMatchBuilder$1(yrx paramyrx) {}
  
  public void run()
  {
    ((PhoneContactManagerImp)this.this$0.mApp.getManager(11)).a(((ytp)this.this$0.a).a);
    ThreadManager.getUIHandler().post(new ContactMatchBuilder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.ContactMatchBuilder.1
 * JD-Core Version:    0.7.0.1
 */