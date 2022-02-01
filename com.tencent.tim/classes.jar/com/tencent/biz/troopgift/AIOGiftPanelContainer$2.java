package com.tencent.biz.troopgift;

import apqk;
import apsz;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import smx;
import smy;
import xyi;
import xys;
import ydz;

public class AIOGiftPanelContainer$2
  implements Runnable
{
  public AIOGiftPanelContainer$2(smx paramsmx, long paramLong, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int j = 4;
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel.time", 2, "begin run time= " + (l - this.CW));
    }
    apqk localapqk = (apqk)this.this$0.mBaseChatPie.app.getManager(223);
    apsz localapsz = (apsz)this.this$0.mBaseChatPie.app.getManager(113);
    int i;
    if (this.bxP == 4)
    {
      i = 6;
      if (!(this.this$0.mBaseChatPie instanceof xys)) {
        break label159;
      }
      j = 11;
      i = 8;
    }
    for (;;)
    {
      localapsz.a("OidbSvc.0x6c3", 1731, 1, this.this$0.mBaseChatPie.sessionInfo.troopUin, 2, i, j, new smy(this, localapsz, l, localapqk));
      return;
      i = 1;
      break;
      label159:
      if ((this.this$0.mBaseChatPie instanceof xyi)) {
        i = 9;
      } else if ((this.this$0.mBaseChatPie instanceof ydz)) {
        i = 10;
      } else {
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.troopgift.AIOGiftPanelContainer.2
 * JD-Core Version:    0.7.0.1
 */