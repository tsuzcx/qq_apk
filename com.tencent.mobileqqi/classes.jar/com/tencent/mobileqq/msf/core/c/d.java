package com.tencent.mobileqq.msf.core.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.util.QLog;

final class d
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      QLog.d("MSF.C.PushManager:PushCoder", 1, "onReceive action null");
    }
    while (!paramContext.equals("com.tencent.mobileqq.msf.WatchdogForInfoLogin")) {
      return;
    }
    MsfService.getCore().pushManager.h.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.d
 * JD-Core Version:    0.7.0.1
 */