package com.tencent.mobileqq.imaxad;

import aibd;
import aibe;
import aibg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import jxc;

public class ImaxAdRecentUserManager$1
  implements Runnable
{
  public ImaxAdRecentUserManager$1(aibe paramaibe, boolean paramBoolean, QQAppInterface paramQQAppInterface, jxc paramjxc, RecentUser paramRecentUser) {}
  
  public void run()
  {
    if (this.cjI) {
      aibd.a().a(this.val$app, this.b);
    }
    if ((this.b != null) && (QLog.isColorLevel())) {
      QLog.d("ImaxAdvertisement", 2, "doDeleteItem disk  uin:" + this.a.uin);
    }
    aibg.gm(this.val$app.getCurrentUin(), this.a.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager.1
 * JD-Core Version:    0.7.0.1
 */