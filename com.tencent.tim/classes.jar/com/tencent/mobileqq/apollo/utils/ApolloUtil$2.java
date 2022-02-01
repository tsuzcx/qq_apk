package com.tencent.mobileqq.apollo.utils;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class ApolloUtil$2
  implements Runnable
{
  ApolloUtil$2(ChatMessage paramChatMessage) {}
  
  public void run()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null)
    {
      localObject = (QQMessageFacade)((AppRuntime)localObject).getManager(20);
      if (localObject != null) {
        ((QQMessageFacade)localObject).a(this.b.frienduin, this.b.istroop, this.b.uniseq, "extStr", this.b.extStr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloUtil.2
 * JD-Core Version:    0.7.0.1
 */