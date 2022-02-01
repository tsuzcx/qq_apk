package com.tencent.mobileqq.activity.activateFriend.biz;

import acof;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ReminderAlarmReceiver
  extends BroadcastReceiver
{
  private static final String TAG = ReminderAlarmReceiver.class.getSimpleName();
  private QQAppInterface mApp;
  
  public ReminderAlarmReceiver(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("notification_alram_action".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("msg");
      paramIntent = paramIntent.getStringExtra("msg_id");
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "---" + paramContext + "---msgId---" + paramIntent);
      }
      ((acof)this.mApp.getManager(85)).fh(paramContext, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderAlarmReceiver
 * JD-Core Version:    0.7.0.1
 */