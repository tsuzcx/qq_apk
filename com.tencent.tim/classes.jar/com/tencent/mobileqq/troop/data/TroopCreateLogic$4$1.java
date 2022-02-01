package com.tencent.mobileqq.troop.data;

import acms;
import apbc;
import apbc.d;
import apbg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class TroopCreateLogic$4$1
  implements Runnable
{
  public TroopCreateLogic$4$1(apbg paramapbg, String paramString, TroopInfo paramTroopInfo, int paramInt) {}
  
  public void run()
  {
    ((acms)this.a.c.app.getBusinessHandler(20)).Fa(this.Uf);
    TroopInfo localTroopInfo = ((TroopManager)this.a.c.app.getManager(52)).b(this.Uf);
    if (localTroopInfo == null) {
      localTroopInfo = this.c;
    }
    for (;;)
    {
      Object localObject;
      int j;
      int i;
      if (localTroopInfo != null)
      {
        localTroopInfo.dwGroupClassExt = this.a.c.a.classify;
        localTroopInfo.mRichFingerMemo = this.a.c.a.cnO;
        localObject = this.a.c.a.location.split("\\|");
        if (localObject.length != 4) {
          break label323;
        }
        j = (int)(Float.valueOf(localObject[1]).floatValue() * 1000000.0F);
        i = (int)(Float.valueOf(localObject[2]).floatValue() * 1000000.0F);
      }
      for (;;)
      {
        localTroopInfo.troopLat = j;
        localTroopInfo.troopLon = i;
        localTroopInfo.isNewTroop = true;
        localTroopInfo.hasSetNewTroopHead = false;
        localTroopInfo.hasSetNewTroopName = false;
        localTroopInfo.wMemberNum = this.aJh;
        localTroopInfo.wMemberNumClient = localTroopInfo.wMemberNum;
        localTroopInfo.troopowneruin = this.a.c.app.getCurrentAccountUin();
        localTroopInfo.troopCreateTime = (System.currentTimeMillis() / 1000L);
        if (QLog.isColorLevel()) {
          QLog.d("TroopCreateLogic", 2, "onGetTroopCreate wMemberNumClient:" + localTroopInfo.wMemberNumClient + "  wMemberNum:" + localTroopInfo.wMemberNum + " troopUin:" + localTroopInfo.troopuin);
        }
        this.c.dwAdditionalFlag = 1L;
        localObject = (TroopManager)this.a.c.app.getManager(52);
        if (localObject != null) {
          ((TroopManager)localObject).i(localTroopInfo);
        }
        return;
        label323:
        i = 0;
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopCreateLogic.4.1
 * JD-Core Version:    0.7.0.1
 */