package com.tencent.biz.pubaccount.readinjoy.engine;

import acbn;
import anbi;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import kxm;

class KandianSubscribeManager$4
  implements Runnable
{
  KandianSubscribeManager$4(KandianSubscribeManager paramKandianSubscribeManager, String paramString1, long paramLong, String paramString2) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    MessageRecord localMessageRecord2 = localQQAppInterface.b().d(acbn.blO, 1008);
    MessageRecord localMessageRecord1;
    if (localMessageRecord2 != null)
    {
      localMessageRecord1 = anbi.d(-1000);
      MessageRecord.copyMessageRecordBaseField(localMessageRecord1, localMessageRecord2);
      localMessageRecord1.msgtype = -1000;
    }
    for (;;)
    {
      KandianSubscribeManager.b(localMessageRecord1, this.ael, this.val$time, this.VD);
      localQQAppInterface.b().b(localMessageRecord1, localQQAppInterface.getCurrentUin());
      return;
      localMessageRecord1 = anbi.d(-1000);
      localMessageRecord1.selfuin = localQQAppInterface.getCurrentAccountUin();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager.4
 * JD-Core Version:    0.7.0.1
 */