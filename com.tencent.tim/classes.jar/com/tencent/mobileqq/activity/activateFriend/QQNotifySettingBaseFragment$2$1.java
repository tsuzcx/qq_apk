package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import Wallet.AcsSubNoticeRsp;
import aafv;
import acof;
import android.os.Bundle;
import anot;
import aqiw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.FakeUrl;
import whn;
import wht;
import whu;
import wii;

public class QQNotifySettingBaseFragment$2$1
  implements Runnable
{
  public QQNotifySettingBaseFragment$2$1(wht paramwht, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject = (AcsSubNoticeRsp)this.val$bundle.getSerializable("rsp");
    if (localObject == null)
    {
      this.a.a.bn(3, "system error");
      return;
    }
    int i = ((AcsSubNoticeRsp)localObject).ret_code;
    String str = ((AcsSubNoticeRsp)localObject).err_str;
    QLog.i(QQNotifySettingBaseFragment.access$100(), 1, "QQReminderServlet.sendSubscribeReminder retCode: " + i + " msg: " + str);
    switch (i)
    {
    }
    for (;;)
    {
      this.a.a.bn(i, str);
      return;
      localObject = ((AcsSubNoticeRsp)localObject).msg;
      QLog.i(QQNotifySettingBaseFragment.access$100(), 1, "QQReminderServlet.sendSubscribeReminder subscribe succ acsMsg: " + localObject);
      if ((localObject != null) && (whn.isToday(((AcsMsg)localObject).notice_time * 1000L))) {
        QQNotifySettingBaseFragment.a(this.a.a).e((AcsMsg)localObject);
      }
      boolean bool = aqiw.isNetSupport(this.a.a.getActivity());
      QLog.i(QQNotifySettingBaseFragment.access$100(), 1, "QQReminderServlet.sendSubscribeReminder isNerSupport: " + bool);
      if (bool)
      {
        if (QQNotifySettingBaseFragment.a(this.a.a) == null) {
          break label383;
        }
        localObject = (acof)QQNotifySettingBaseFragment.a(this.a.a).getManager(85);
        if (localObject != null)
        {
          bool = ((acof)localObject).aY(true);
          QLog.i(QQNotifySettingBaseFragment.access$100(), 1, "QQReminderServlet.sendSubscribeReminder prepare open notify switch isOpened: " + bool);
          if (!bool)
          {
            QLog.i(QQNotifySettingBaseFragment.access$100(), 1, "QQReminderServlet.sendSubscribeReminder setQQReminderSwitch");
            ((acof)localObject).bM(true, true);
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(QQNotifySettingBaseFragment.access$100(), 2, "do report: QQnotice.set.add");
        }
        anot.a(null, "P_CliOper", "QQnotice", "", "", "QQnotice.set.add", 0, 0, "", "", QQNotifySettingBaseFragment.a(this.a.a), QQNotifySettingBaseFragment.b(this.a.a));
        break;
        label383:
        bool = aafv.Wi();
        QLog.i(QQNotifySettingBaseFragment.access$100(), 1, "QQReminderServlet.sendSubscribeReminder prepare open notify switch isOpened: " + bool);
        if (!bool)
        {
          QLog.i(QQNotifySettingBaseFragment.access$100(), 1, "QQReminderServlet.sendSubscribeReminder setQQReminderSwitch");
          aafv.Ch(true);
        }
      }
      if (QQNotifySettingBaseFragment.a(this.a.a) != null) {
        QQNotifySettingBaseFragment.a(this.a.a).onFakePros("", ((AcsSubNoticeRsp)localObject).err_str, new whu(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment.2.1
 * JD-Core Version:    0.7.0.1
 */