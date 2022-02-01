package com.tencent.qqmail.utilities.keepalive;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.oss.KvHelper;

final class KeepAliveManager$10
  implements DialogInterface.OnShowListener
{
  KeepAliveManager$10(int paramInt) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    QMLog.log(4, "KeepAliveManager", "guide show");
    KeepAliveManager.access$102(true);
    KeepAliveManager.access$1000();
    switch (this.val$reason)
    {
    }
    for (;;)
    {
      KvHelper.showGuide(new double[0]);
      return;
      KvHelper.guideShowReasonExistShortTime(new double[0]);
      continue;
      KvHelper.guideShowReasonDelay(new double[0]);
      continue;
      KvHelper.guideLessScheduledJob(new double[0]);
      continue;
      KvHelper.guideShowReasonAddAccount(new double[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.keepalive.KeepAliveManager.10
 * JD-Core Version:    0.7.0.1
 */