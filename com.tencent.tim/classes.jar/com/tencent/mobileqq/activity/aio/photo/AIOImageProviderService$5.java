package com.tencent.mobileqq.activity.aio.photo;

import acei;
import acfx;
import anot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AccountNotMatchException;

class AIOImageProviderService$5
  implements Runnable
{
  AIOImageProviderService$5(AIOImageProviderService paramAIOImageProviderService, long paramLong) {}
  
  public void run()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.this$0.myUin);
      ChatMessage localChatMessage = this.this$0.a(this.rJ);
      QQMessageFacade localQQMessageFacade;
      if (localChatMessage != null)
      {
        localQQMessageFacade = localQQAppInterface.b();
        if (!acfx.W(localChatMessage)) {
          break label157;
        }
        acfx.Q(localChatMessage);
        break label180;
      }
      for (;;)
      {
        localQQMessageFacade.a(localChatMessage.frienduin, localChatMessage.istroop, localChatMessage.uniseq, "extStr", localChatMessage.extStr);
        if (QLog.isColorLevel()) {
          QLog.d("Q.hotchat", 2, "makeFlashPicReaded,uin:" + this.this$0.friendUin + ",type:" + localChatMessage.istroop + ",extStr" + localChatMessage.extStr);
        }
        anot.a(localQQAppInterface, "CliOper", "", "", "0X8005979", "0X8005979", 0, 0, "", "", "", "");
        return;
        label157:
        acei.Q(localChatMessage);
        Iterator localIterator = localQQMessageFacade.k(localChatMessage.frienduin, localChatMessage.msgtype).iterator();
        label180:
        if (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if (localMessageRecord.uniseq != this.rJ) {
            break;
          }
          acei.Q(localMessageRecord);
        }
      }
      return;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      QLog.d("Q.hotchat", 2, "setFlashPicReaded，account no match exception");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.5
 * JD-Core Version:    0.7.0.1
 */