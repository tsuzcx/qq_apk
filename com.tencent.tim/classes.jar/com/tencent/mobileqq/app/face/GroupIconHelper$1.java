package com.tencent.mobileqq.app.face;

import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

class GroupIconHelper$1
  implements Runnable
{
  GroupIconHelper$1(GroupIconHelper paramGroupIconHelper, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.val$app.addObserver(this.this$0);
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.val$app.getManager(11);
    if (localPhoneContactManagerImp != null) {
      localPhoneContactManagerImp.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.GroupIconHelper.1
 * JD-Core Version:    0.7.0.1
 */