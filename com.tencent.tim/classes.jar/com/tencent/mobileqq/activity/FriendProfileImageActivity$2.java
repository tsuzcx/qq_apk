package com.tencent.mobileqq.activity;

import acff;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import mqq.os.MqqHandler;
import vbi;

class FriendProfileImageActivity$2
  implements Runnable
{
  FriendProfileImageActivity$2(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((acff)this.this$0.app.getManager(51)).a(this.this$0.a.toUin);
    if (localExtensionInfo != null) {
      ThreadManager.getUIHandler().post(new FriendProfileImageActivity.2.1(this, localExtensionInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.2
 * JD-Core Version:    0.7.0.1
 */