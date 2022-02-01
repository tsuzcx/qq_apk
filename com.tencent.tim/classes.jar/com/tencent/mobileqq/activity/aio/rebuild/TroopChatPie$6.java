package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.SystemClock;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.b;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import ton;
import top;
import wkk;

class TroopChatPie$6
  implements Runnable
{
  TroopChatPie$6(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    int j = 0;
    Object localObject = this.this$0.app.a(this.this$0.sessionInfo.cZ).l(this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ);
    int k;
    int i;
    label92:
    int m;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (((List)localObject).size() > 3) {
        break label165;
      }
      k = ((List)localObject).size();
      Iterator localIterator = ((List)localObject).iterator();
      i = 0;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if (localMessageRecord != null) {
            if (localMessageRecord.msgtype == -2058)
            {
              m = j + 1;
              j = i;
              i = m;
              label140:
              if (j < k) {
                break label183;
              }
              if (QLog.isColorLevel()) {
                QLog.i(this.this$0.TAG, 2, "AIO has more than 3 normal message, so return!");
              }
            }
          }
        }
      }
    }
    label165:
    label183:
    do
    {
      do
      {
        return;
        k = 3;
        break;
        m = i + 1;
        i = j;
        j = m;
        break label140;
        m = j;
        j = i;
        i = m;
        break label92;
      } while (j <= ((List)localObject).size() / 2);
      if (QLog.isColorLevel()) {
        QLog.i(this.this$0.TAG, 2, "now pull more message for troop!");
      }
      TroopChatPie.a(this.this$0, SystemClock.uptimeMillis());
      ((wkk)TroopChatPie.a(this.this$0).context).fU(TroopChatPie.a(this.this$0));
      TroopChatPie.b(this.this$0).aQi = top.V((List)localObject);
      TroopChatPie.c(this.this$0).aQj = true;
    } while (TroopChatPie.d(this.this$0).bCT != 0);
    localObject = TroopChatPie.e(this.this$0);
    ((QQMessageFacade.b)localObject).bCT += 1;
    this.this$0.app.b().a(this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ, 15, TroopChatPie.f(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.6
 * JD-Core Version:    0.7.0.1
 */