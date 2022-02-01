package com.tencent.qqmail.notificationshortcut;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qqmail.launcher.third.LaunchShortCutActivity;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.processutil.ProcessUtils;
import moai.oss.KvHelper;

public class ShortCutNotificationBroadcastReceiver
  extends BroadcastReceiver
{
  public static final String TAG = "DeleteNotificationBroadcastReceiver";
  
  private void closeNotificationPanel(Context paramContext)
  {
    paramContext.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("PENDINGINTENT_TYPE_EXTRA_KEY", -1);
    switch (i)
    {
    }
    for (;;)
    {
      closeNotificationPanel(paramContext);
      QMLog.log(4, "DeleteNotificationBroadcastReceiver", "onReceive " + i + " thread " + ProcessUtils.getProcessName(paramContext));
      return;
      paramContext.startActivity(LaunchShortCutActivity.createIntentForComposeMail(paramContext));
      KvHelper.notificationPanelComposeMail(new double[0]);
      continue;
      paramContext.startActivity(LaunchShortCutActivity.createIntentForComposeNote(paramContext));
      KvHelper.notificationPanelComposeNote(new double[0]);
      continue;
      paramContext.startActivity(LaunchShortCutActivity.createIntentForScan(paramContext));
      KvHelper.notificationPanelScan(new double[0]);
      continue;
      paramContext.startActivity(LaunchShortCutActivity.createIntentForCalendar(paramContext));
      KvHelper.notificationPanelCalendar(new double[0]);
      continue;
      paramContext.startActivity(LaunchShortCutActivity.createIntentForSetting(paramContext));
      KvHelper.notificationPanelSetting(new double[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.notificationshortcut.ShortCutNotificationBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */