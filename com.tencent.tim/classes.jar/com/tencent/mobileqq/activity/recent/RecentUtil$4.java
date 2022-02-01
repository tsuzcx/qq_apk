package com.tencent.mobileqq.activity.recent;

import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import oan;

public final class RecentUtil$4
  implements Runnable
{
  public RecentUtil$4(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    List localList = oan.a().b(this.val$app);
    int i;
    int j;
    label19:
    Object localObject;
    if (localList == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return;
      }
      localObject = (TroopBarData)localList.get(j);
      if (localObject != null) {
        break label58;
      }
    }
    for (;;)
    {
      j += 1;
      break label19;
      i = localList.size();
      break;
      label58:
      localObject = this.val$app.b().a(((TroopBarData)localObject).mUin, 1008);
      if (localObject != null) {
        oan.a().f(this.val$app, ((QQMessageFacade.Message)localObject).time);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentUtil.4
 * JD-Core Version:    0.7.0.1
 */