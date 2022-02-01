package com.tencent.mobileqq.activity.contact.newfriend;

import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import ysy;
import yue;

public class PhoneContactAddBuilder$1
  implements Runnable
{
  public PhoneContactAddBuilder$1(ysy paramysy) {}
  
  public void run()
  {
    ((PhoneContactManagerImp)this.this$0.mApp.getManager(11)).a(((yue)this.this$0.a).a);
    this.this$0.mApp.runOnUiThread(new PhoneContactAddBuilder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.PhoneContactAddBuilder.1
 * JD-Core Version:    0.7.0.1
 */