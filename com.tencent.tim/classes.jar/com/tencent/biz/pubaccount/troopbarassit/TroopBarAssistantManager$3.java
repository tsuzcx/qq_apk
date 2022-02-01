package com.tencent.biz.pubaccount.troopbarassit;

import aalb;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import oan;
import ocp;
import tog;

public class TroopBarAssistantManager$3
  implements Runnable
{
  public TroopBarAssistantManager$3(oan paramoan, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    tog localtog = this.val$app.a();
    Object localObject1 = this.val$app.b();
    if ((localtog == null) || (localObject1 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopBarAssistantManager", 2, "clearAllSubscriptionUnreadMsgLite getConversationFacade fail");
      }
      return;
    }
    label192:
    for (;;)
    {
      synchronized (this.this$0.aF)
      {
        if (this.this$0.mDataList != null)
        {
          Iterator localIterator = this.this$0.mDataList.iterator();
          if (localIterator.hasNext())
          {
            TroopBarData localTroopBarData = (TroopBarData)localIterator.next();
            localObject1 = localTroopBarData.mLatestMessage;
            if (localObject1 != null) {
              break label192;
            }
            localObject1 = this.val$app.b().d(localTroopBarData.mUin, 1008);
            if ((localObject1 == null) || (localtog.A(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop) <= 0)) {
              continue;
            }
            int i = ocp.e(this.val$app, ((MessageRecord)localObject1).frienduin);
            aalb.l(this.val$app, ((MessageRecord)localObject1).frienduin, i);
            localtog.h(((MessageRecord)localObject1).frienduin, i, true);
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager.3
 * JD-Core Version:    0.7.0.1
 */