package com.tencent.mobileqq.app.automator.step;

import abhe;
import abhh;
import ablp;
import abyv;
import aczo;
import ahbj;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqrb;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.microapp.apkg.UsedAppListManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GetApolloContentUpdateStatus
  extends AsyncStep
{
  public int od()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "[GetApolloContentUpdateStatus]system time" + System.currentTimeMillis() + ",last update time:");
    }
    abhh localabhh = (abhh)this.a.app.getManager(153);
    SharedPreferences localSharedPreferences = this.a.app.getApp().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("last_pull_apollo_content_update_time", 0L);
    aczo localaczo = (aczo)this.a.app.getBusinessHandler(115);
    if ((System.currentTimeMillis() - l > 21600000L) || (System.currentTimeMillis() < l)) {
      if (localaczo != null)
      {
        localaczo.bQ(null);
        localSharedPreferences.edit().putLong("last_pull_apollo_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      abhe.cBB();
      ((abhe)this.a.app.getManager(211)).cBE();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "get game list on login.");
      }
      if (localabhh.Yj()) {
        ((UsedAppListManager)this.a.app.getManager(288)).getUsedAppList();
      }
      abyv.loadSo("login");
      abhh.bfQ = this.a.app.getCurrentAccountUin();
      ablp.cb(this.a.app);
      if (localabhh.jn(this.a.app.getCurrentAccountUin())) {
        ((aqrb)this.a.app.getBusinessHandler(71)).eff();
      }
      if (abhh.aV(this.a.app.getApp())) {
        localabhh.cBW();
      }
      return 7;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "system time" + System.currentTimeMillis() + ",last update time:" + l);
      }
      if (abhh.aV(this.a.app.getApp())) {
        localabhh.o(false, "login check file", 1);
      } else if (ahbj.isFileExists(ApolloUtil.bkb)) {
        abhh.g(this.a.app);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetApolloContentUpdateStatus
 * JD-Core Version:    0.7.0.1
 */