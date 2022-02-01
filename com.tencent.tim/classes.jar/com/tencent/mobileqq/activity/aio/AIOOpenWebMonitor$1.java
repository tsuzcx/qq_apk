package com.tencent.mobileqq.activity.aio;

import anpc;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class AIOOpenWebMonitor$1
  implements Runnable
{
  public AIOOpenWebMonitor$1(QQAppInterface paramQQAppInterface, int paramInt, String paramString, long paramLong) {}
  
  public void run()
  {
    if (this.val$qqApp == null) {}
    do
    {
      do
      {
        return;
        if (this.bNC != 1) {
          break;
        }
        localObject = ((TroopManager)this.val$qqApp.getManager(52)).b(this.aSl);
      } while (localObject == null);
      HashMap localHashMap = new HashMap(3);
      localHashMap.put("m_num", ((TroopInfo)localObject).wMemberNum + "");
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "AIOWebTC", false, 0L, 0L, localHashMap, "", false);
      localObject = this.val$qqApp.b().f(this.aSl, this.bNC);
    } while (localObject == null);
    Object localObject = ((List)localObject).iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (((ChatMessage)((Iterator)localObject).next()).msgUid != this.HJ);
    for (int i = 1;; i = 2)
    {
      localObject = new HashMap(3);
      ((HashMap)localObject).put("m_i", i + "");
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "AIOWebmsgposition", false, 0L, 0L, (HashMap)localObject, "", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor.1
 * JD-Core Version:    0.7.0.1
 */