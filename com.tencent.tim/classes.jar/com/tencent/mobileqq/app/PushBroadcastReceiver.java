package com.tencent.mobileqq.app;

import aizb;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

public class PushBroadcastReceiver
  extends QQBroadcastReceiver
{
  private void c(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("tencent.notify.background")) {
      ThreadManager.post(new PushBroadcastReceiver.1(this, paramIntent, paramQQAppInterface), 10, null, false);
    }
    for (;;)
    {
      if ((paramIntent.getAction().equals("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION")) || (paramIntent.getAction().equals("com.tencent.mobileqq.IPADONLINE_CLICK_NOTIFICATION")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("notification", 2, "PushBroadcastReceiver processIntent event : " + paramIntent.getAction());
        }
        ((MessageHandler)paramQQAppInterface.getBusinessHandler(0)).x(BaseApplication.getContext(), paramIntent);
        aizb.dz(paramIntent);
      }
      return;
      if (paramIntent.getAction().equals("tencent.notify.foreground")) {
        ThreadManager.post(new PushBroadcastReceiver.2(this, paramQQAppInterface), 10, null, false);
      }
    }
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    if (((paramIntent.getExtras() == null) || (paramIntent.getExtras().getString("selfuin") != null)) || ((paramAppRuntime != null) && ((paramAppRuntime instanceof QQAppInterface)))) {
      c((QQAppInterface)paramAppRuntime, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.PushBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */