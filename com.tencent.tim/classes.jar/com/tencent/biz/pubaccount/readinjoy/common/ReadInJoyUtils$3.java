package com.tencent.biz.pubaccount.readinjoy.common;

import aqiw;
import awit;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import kxm;

public final class ReadInJoyUtils$3
  implements Runnable
{
  public ReadInJoyUtils$3(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((this.val$app == null) || (!this.val$app.isLogin())) {
      return;
    }
    if (aqiw.isWifiEnabled(this.val$app.getApp()))
    {
      kxm.O(this.val$app);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "handConversationToShow is wifi");
      }
    }
    if (!awit.S(this.val$app))
    {
      kxm.L(this.val$app);
      awit.B(this.val$app);
    }
    if (awit.N(this.val$app))
    {
      awit.r(this.val$app, false);
      ((KandianMergeManager)this.val$app.getManager(162)).aIL();
    }
    for (;;)
    {
      ((KandianSubscribeManager)this.val$app.getManager(280)).aJb();
      ((KandianDailyManager)this.val$app.getManager(296)).aIu();
      return;
      ((KandianMergeManager)this.val$app.getManager(162)).aIK();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.3
 * JD-Core Version:    0.7.0.1
 */