package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;

public final class TroopUtils$2
  implements Runnable
{
  public TroopUtils$2(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    if (this.val$app != null) {
      ((TroopManager)this.val$app.getManager(52)).i(this.j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUtils.2
 * JD-Core Version:    0.7.0.1
 */