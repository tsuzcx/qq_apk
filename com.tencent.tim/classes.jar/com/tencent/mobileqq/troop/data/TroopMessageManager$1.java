package com.tencent.mobileqq.troop.data;

import acms;
import apdd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;

public class TroopMessageManager$1
  implements Runnable
{
  public TroopMessageManager$1(apdd paramapdd, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    Object localObject = (acms)apdd.a(this.this$0).getBusinessHandler(20);
    if (localObject != null)
    {
      localObject = ((acms)localObject).a();
      if (localObject != null) {
        ((TroopBatchAddFriendMgr)localObject).a(this.bQk, this.aMs, this.dTu, this.aqZ, this.ara);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopMessageManager.1
 * JD-Core Version:    0.7.0.1
 */