package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import zsz;

public final class ChatActivityFacade$11
  implements Runnable
{
  public ChatActivityFacade$11(String paramString, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      String str = this.val$url;
      int i = this.a.cZ;
      QQAppInterface localQQAppInterface = this.val$app;
      zsz.a(new String[] { str }, i, false, false, -1, localQQAppInterface);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.11
 * JD-Core Version:    0.7.0.1
 */