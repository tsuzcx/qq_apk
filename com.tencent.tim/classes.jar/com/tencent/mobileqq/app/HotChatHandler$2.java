package com.tencent.mobileqq.app;

import acfv;
import ajry;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class HotChatHandler$2
  implements Runnable
{
  public HotChatHandler$2(acfv paramacfv, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if ((!ajry.a().bdN) && (!ajry.a().cpX))
    {
      if ((!this.bHI) || (this.xw.isEmpty())) {
        break label110;
      }
      localHotChatInfo = (HotChatInfo)this.xw.get(0);
    }
    label110:
    while (ajry.a().GB() != 1) {
      try
      {
        long l = Long.parseLong(localHotChatInfo.troopUin);
        ajry.a().a(1, null, l, localHotChatInfo.name);
        return;
      }
      catch (Exception localException)
      {
        HotChatInfo localHotChatInfo;
        while (!QLog.isColorLevel()) {}
        QLog.e("HotChatHandler", 2, "handleGetMyHostChatListRespError hc.troopUin: " + localHotChatInfo.troopUin);
        return;
      }
    }
    ajry.a().dyZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatHandler.2
 * JD-Core Version:    0.7.0.1
 */