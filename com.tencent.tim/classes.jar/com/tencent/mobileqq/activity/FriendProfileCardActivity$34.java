package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;

class FriendProfileCardActivity$34
  implements Runnable
{
  FriendProfileCardActivity$34(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "checkUpdateExtendInfo, requeset time out, start add friend :" + FriendProfileCardActivity.d(this.this$0));
    }
    if (!FriendProfileCardActivity.d(this.this$0))
    {
      FriendProfileCardActivity.a(this.this$0, true);
      FriendProfileCardActivity.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.34
 * JD-Core Version:    0.7.0.1
 */