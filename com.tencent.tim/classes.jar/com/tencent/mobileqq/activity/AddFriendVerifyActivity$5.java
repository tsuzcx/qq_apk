package com.tencent.mobileqq.activity;

import acff;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AddFriendVerifyActivity$5
  implements Runnable
{
  AddFriendVerifyActivity$5(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString) {}
  
  public void run()
  {
    String str = ((acff)this.this$0.app.getManager(51)).ji(AddFriendVerifyActivity.a(this.this$0));
    ThreadManager.getUIHandler().post(new AddFriendVerifyActivity.5.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.5
 * JD-Core Version:    0.7.0.1
 */