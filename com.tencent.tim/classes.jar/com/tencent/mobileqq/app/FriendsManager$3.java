package com.tencent.mobileqq.app;

import acff;

public class FriendsManager$3
  implements Runnable
{
  public FriendsManager$3(acff paramacff) {}
  
  public void run()
  {
    this.this$0.init();
    acff.a(this.this$0, "buildGroupList2");
    ((FriendListHandler)acff.a(this.this$0).getBusinessHandler(1)).notifyUI(103, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendsManager.3
 * JD-Core Version:    0.7.0.1
 */