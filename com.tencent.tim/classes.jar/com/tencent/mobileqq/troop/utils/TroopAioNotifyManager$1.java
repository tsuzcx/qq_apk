package com.tencent.mobileqq.troop.utils;

import acms;
import apro;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public final class TroopAioNotifyManager$1
  implements Runnable
{
  public TroopAioNotifyManager$1(QQAppInterface paramQQAppInterface, String paramString, acms paramacms) {}
  
  public void run()
  {
    List localList = apro.e(this.val$app, this.Uf);
    localList = apro.a(this.val$app, new ArrayList(), localList);
    this.g.notifyUI(95, true, new Object[] { this.Uf, localList });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAioNotifyManager.1
 * JD-Core Version:    0.7.0.1
 */