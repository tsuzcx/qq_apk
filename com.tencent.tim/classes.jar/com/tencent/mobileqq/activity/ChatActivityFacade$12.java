package com.tencent.mobileqq.activity;

import ajkw;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

public final class ChatActivityFacade$12
  implements Runnable
{
  public ChatActivityFacade$12(boolean paramBoolean1, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, boolean paramBoolean2) {}
  
  public void run()
  {
    try
    {
      if (this.aTn)
      {
        ((ajkw)this.h.getManager(166)).b(this.h, this.e, false);
        return;
      }
      if (this.aTo)
      {
        this.h.b().B(this.e);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ChatActivityFacade", 1, "life circle2:", localException);
      return;
    }
    this.h.b().a(this.e, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.12
 * JD-Core Version:    0.7.0.1
 */