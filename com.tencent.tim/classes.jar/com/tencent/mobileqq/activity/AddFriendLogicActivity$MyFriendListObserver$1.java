package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;

class AddFriendLogicActivity$MyFriendListObserver$1
  implements Runnable
{
  AddFriendLogicActivity$MyFriendListObserver$1(AddFriendLogicActivity.a parama, String paramString) {}
  
  public void run()
  {
    ((FriendListHandler)this.b.this$0.app.getBusinessHandler(1)).a(this.val$uin, 0, 3999, "", true, false, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendLogicActivity.MyFriendListObserver.1
 * JD-Core Version:    0.7.0.1
 */