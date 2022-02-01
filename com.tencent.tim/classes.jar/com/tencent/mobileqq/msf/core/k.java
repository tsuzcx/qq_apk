package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.net.a.f;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

final class k
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext)) {
      if (QLog.isColorLevel()) {
        QLog.d(i.b, 2, "onReceive broadcastreceiver.action null");
      }
    }
    for (;;)
    {
      return;
      QLog.d(i.b, 1, "onReceive broadcastreceiver.action = " + paramContext);
      boolean bool;
      if (paramContext.equals("android.intent.action.SCREEN_OFF"))
      {
        i.c = false;
        ak.V = -1;
        ak.W.set(false);
        if ((com.tencent.mobileqq.msf.core.a.a.r()) || (i.f()))
        {
          i.g().removeMessages(10000);
          i.g().sendEmptyMessageDelayed(10000, com.tencent.mobileqq.msf.core.a.a.p());
        }
        for (;;)
        {
          try
          {
            bool = com.tencent.mobileqq.msf.core.a.a.aQ();
            if (!bool) {
              break;
            }
            try
            {
              MsfService.core.sender.I.c().c();
              return;
            }
            catch (Exception paramContext) {}
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(i.b, 2, "failed to call adaptorcontroller screenoff ", paramContext);
            return;
          }
          catch (Exception paramContext)
          {
            QLog.d(i.b, 1, "onReceive ScreenOff to controller failed " + paramContext.toString(), paramContext);
            return;
          }
          i.d += 1;
          if (i.d == BaseConstants.checkExpiresLogScreenOffCount) {
            i.h();
          }
        }
      }
      if (paramContext.equals("android.intent.action.SCREEN_ON"))
      {
        i.c = true;
        i.g().removeMessages(10000);
        try
        {
          bool = com.tencent.mobileqq.msf.core.a.a.aQ();
          if (bool)
          {
            try
            {
              MsfService.core.sender.I.c().d();
              return;
            }
            catch (Exception paramContext) {}
            if (QLog.isColorLevel())
            {
              QLog.d(i.b, 2, "failed to call adaptorcontroller screenon ", paramContext);
              return;
            }
          }
        }
        catch (Exception paramContext)
        {
          QLog.d(i.b, 1, "onReceive ScreenOn to controller failed " + paramContext.toString(), paramContext);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.k
 * JD-Core Version:    0.7.0.1
 */