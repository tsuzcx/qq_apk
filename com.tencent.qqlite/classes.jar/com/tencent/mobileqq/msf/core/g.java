package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

final class g
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext)) {
      if (QLog.isColorLevel()) {
        QLog.d(f.a, 2, "onReceive broadcastreceiver.action null");
      }
    }
    do
    {
      do
      {
        return;
        QLog.d(f.a, 1, "onReceive broadcastreceiver.action = " + paramContext);
        if (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
          break;
        }
        f.b = false;
        l.D = -1;
        l.E.set(false);
        f.c += 1;
      } while (f.c != BaseConstants.checkExpiresLogScreenOffCount);
      f.b();
      return;
    } while (!paramContext.equals("android.intent.action.SCREEN_ON"));
    f.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.g
 * JD-Core Version:    0.7.0.1
 */