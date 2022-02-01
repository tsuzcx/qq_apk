package com.tencent.mobileqq.vashealth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import aqtw;
import aqtz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class StepAlarmReceiver
  extends BroadcastReceiver
{
  static String cxi;
  long atP = 7200000L;
  int ecT = 1000;
  QQAppInterface mApp;
  
  public StepAlarmReceiver(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public void destroy()
  {
    this.mApp = null;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!aqtz.aFD()) {
      QLog.e("StepAlarmReceiver", 1, "onReceive:step counter not support");
    }
    do
    {
      do
      {
        do
        {
          return;
          paramContext = paramIntent.getAction();
          if (!"action_sport_timer1".equals(paramContext)) {
            break;
          }
        } while ((!aqtw.mG(2)) || (this.mApp == null));
        ThreadManager.post(new StepAlarmReceiver.1(this), 5, null, true);
        return;
        if (!"action_sport_timer2".equals(paramContext)) {
          break;
        }
      } while (this.mApp == null);
      ((aqtz)this.mApp.getManager(260)).efG();
      return;
    } while (!"StepAlarmReceiver_long_time_report".equals(paramContext));
    QLog.i("StepAlarmReceiver", 1, "StepAlarmReceiver_long_time_report!");
    if (!paramIntent.getBooleanExtra("VerifyResult", true)) {
      aqtw.dZ(-1000, "verifyFailed");
    }
    ThreadManager.post(new StepAlarmReceiver.2(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.StepAlarmReceiver
 * JD-Core Version:    0.7.0.1
 */