package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import anot;
import ausb;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

public class NotificationDeleteReceiver
  extends QQBroadcastReceiver
{
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    QLog.d("NotificationDeleteReceiver", 2, "NotificationDeleteReceiver");
    anot.a((QQAppInterface)paramAppRuntime, "CliOper", "", "", "0X80046A6", "0X80046A6", 0, 0, "", "", "", "");
    paramContext = paramIntent.getStringExtra("uin");
    int i = paramIntent.getIntExtra("param_notifyid", 0);
    if (QLog.isColorLevel()) {
      QLog.i("NotificationDeleteReceiver", 2, "onReceive: invoked.  notifyId: " + i + " friendOrTroopUin: " + paramContext);
    }
    if ((i >= 512) && (i <= 522)) {
      ausb.a((QQAppInterface)paramAppRuntime).Zz(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.NotificationDeleteReceiver
 * JD-Core Version:    0.7.0.1
 */