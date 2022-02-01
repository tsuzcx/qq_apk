package com.tencent.mobileqq.extendfriend.limitchat;

import acff;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class ExtendFriendLimitChatMatchFragment$7
  implements Runnable
{
  ExtendFriendLimitChatMatchFragment$7(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment) {}
  
  public void run()
  {
    if (ExtendFriendLimitChatMatchFragment.a(this.this$0) != null)
    {
      acff localacff = (acff)ExtendFriendLimitChatMatchFragment.a(this.this$0).app.getManager(51);
      ExtendFriendLimitChatMatchFragment.a(this.this$0, localacff.b(ExtendFriendLimitChatMatchFragment.a(this.this$0).app.getCurrentAccountUin()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment.7
 * JD-Core Version:    0.7.0.1
 */