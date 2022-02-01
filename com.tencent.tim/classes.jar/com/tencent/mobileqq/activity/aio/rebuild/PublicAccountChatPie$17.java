package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import ycd;

public class PublicAccountChatPie$17
  implements Runnable
{
  public PublicAccountChatPie$17(ycd paramycd, List paramList) {}
  
  public void run()
  {
    try
    {
      Iterator localIterator = this.qw.iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        this.this$0.app.b().a(this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ, localChatMessage.uniseq, "extStr", localChatMessage.extStr);
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.TAG, 2, "saveReadedToDB uin=" + this.this$0.sessionInfo.aTl + " uniseq=" + localChatMessage.uniseq + " extstr=" + localChatMessage.extStr);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(this.this$0.TAG, 4, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.17
 * JD-Core Version:    0.7.0.1
 */