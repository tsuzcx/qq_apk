package com.tencent.mobileqq.onlinestatus.music;

import akun;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class OnlineStatusHandler$2
  implements Runnable
{
  public OnlineStatusHandler$2(akun paramakun, String paramString) {}
  
  public void run()
  {
    ((FriendListHandler)this.this$0.app.getBusinessHandler(1)).bE(this.val$uin, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler.2
 * JD-Core Version:    0.7.0.1
 */