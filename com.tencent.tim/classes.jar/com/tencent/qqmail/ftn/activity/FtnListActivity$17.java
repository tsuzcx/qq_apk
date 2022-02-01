package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.utilities.ui.QMFtnUploadNotification;
import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;

class FtnListActivity$17
  implements Runnable
{
  FtnListActivity$17(FtnListActivity paramFtnListActivity) {}
  
  public void run()
  {
    QMFtnUploadNotification.getInstance().clearErrorNotification();
    QMNotificationConstructor.getInstance().clearAllFtn();
    QMNotificationConstructor.getInstance().clearFtnUploadNotify();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.17
 * JD-Core Version:    0.7.0.1
 */