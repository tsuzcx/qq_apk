package com.tencent.qqmail.utilities.keepalive;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import moai.oss.KvHelper;

final class KeepAliveManager$15
  implements DialogInterface.OnShowListener
{
  public void onShow(DialogInterface paramDialogInterface)
  {
    QMLog.log(4, "KeepAliveManager", "notification guide show");
    KeepAliveManager.access$102(true);
    SPManager.getEditor("keep_alive_info").putLong("last_show_notification_guide_time", System.currentTimeMillis()).apply();
    KvHelper.showNotificationGuide(new double[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.keepalive.KeepAliveManager.15
 * JD-Core Version:    0.7.0.1
 */