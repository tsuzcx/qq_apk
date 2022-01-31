package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

public class NotificationDeleteReceiver
  extends QQBroadcastReceiver
{
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    QLog.d("NotificationDeleteReceiver", 2, "NotificationDeleteReceiver");
    ReportController.b((QQAppInterface)paramAppRuntime, "CliOper", "", "", "0X80046A6", "0X80046A6", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NotificationDeleteReceiver
 * JD-Core Version:    0.7.0.1
 */