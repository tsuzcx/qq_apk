package com.tencent.biz.troopgift;

import android.os.Handler;
import aqgv;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;
import snf;

class TroopGiftPanel$5
  implements Runnable
{
  TroopGiftPanel$5(TroopGiftPanel paramTroopGiftPanel, AppInterface paramAppInterface, String paramString1, String paramString2, Handler paramHandler) {}
  
  public void run()
  {
    if (((TroopManager)this.b.getManager(52)).b(this.Uf, this.aFl) != null)
    {
      String str = aqgv.h((QQAppInterface)this.b, this.Uf, this.aFl);
      this.bz.post(new TroopGiftPanel.5.1(this, str));
      return;
    }
    QLog.e("TroopGiftPanel", 1, "last receiver is not in troop, troopUin=" + this.Uf + ", memberUin=" + this.aFl);
    snf.cO(this.Uf, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.5
 * JD-Core Version:    0.7.0.1
 */