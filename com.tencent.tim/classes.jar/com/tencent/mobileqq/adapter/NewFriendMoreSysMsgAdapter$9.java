package com.tencent.mobileqq.adapter;

import abfd;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import ytv;
import yue;

public class NewFriendMoreSysMsgAdapter$9
  implements Runnable
{
  public NewFriendMoreSysMsgAdapter$9(abfd paramabfd, ytv paramytv) {}
  
  public void run()
  {
    ((PhoneContactManagerImp)this.this$0.mApp.getManager(11)).a(((yue)this.b).a);
    this.this$0.mApp.runOnUiThread(new NewFriendMoreSysMsgAdapter.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.9
 * JD-Core Version:    0.7.0.1
 */