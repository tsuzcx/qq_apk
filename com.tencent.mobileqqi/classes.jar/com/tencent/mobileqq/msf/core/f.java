package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

final class f
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext)) {
      if (QLog.isColorLevel()) {
        QLog.d(e.a, 2, "onReceive broadcastreceiver.action null");
      }
    }
    do
    {
      do
      {
        return;
        QLog.d(e.a, 1, "onReceive broadcastreceiver.action = " + paramContext);
        if (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
          break;
        }
        e.b = false;
        l.t = -1;
        l.u.set(false);
        e.c += 1;
      } while (e.c != BaseConstants.checkExpiresLogScreenOffCount);
      e.b();
      return;
    } while (!paramContext.equals("android.intent.action.SCREEN_ON"));
    e.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.f
 * JD-Core Version:    0.7.0.1
 */