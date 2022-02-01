package com.tencent.mobileqq.limitchat;

import ahwa;
import aine;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public final class LimitChatUtil$1
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, "clearAioCacheAndDBMsg start");
    }
    Iterator localIterator = this.val$app.b().a(this.val$uin, this.val$type, this.abK).iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (aine.aE(localChatMessage)) {
        if (-4023 == localChatMessage.msgtype) {
          this.val$app.b().a(this.val$uin, this.val$type, localChatMessage.msgtype, localChatMessage.uniseq);
        } else if ((localChatMessage.isSend()) && (localChatMessage.extraflag == 32768)) {
          this.val$app.b().t(this.val$uin, this.val$type, localChatMessage.uniseq);
        } else if (((localChatMessage instanceof MessageForUniteGrayTip)) && (aine.kf(((MessageForUniteGrayTip)localChatMessage).tipParam.dbK))) {
          this.val$app.b().t(this.val$uin, this.val$type, localChatMessage.uniseq);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, "clearAioCacheAndDBMsg end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.limitchat.LimitChatUtil.1
 * JD-Core Version:    0.7.0.1
 */