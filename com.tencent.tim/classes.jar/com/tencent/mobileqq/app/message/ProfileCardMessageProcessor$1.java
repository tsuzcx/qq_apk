package com.tencent.mobileqq.app.message;

import acri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class ProfileCardMessageProcessor$1
  implements Runnable
{
  public ProfileCardMessageProcessor$1(acri paramacri) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(acri.a(this.this$0).getAccount())) {
      ((FriendListHandler)acri.b(this.this$0).getBusinessHandler(1)).DG(acri.c(this.this$0).getAccount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.ProfileCardMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */