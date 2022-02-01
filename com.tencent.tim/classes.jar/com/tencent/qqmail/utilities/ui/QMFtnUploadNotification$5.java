package com.tencent.qqmail.utilities.ui;

import android.util.Log;

class QMFtnUploadNotification$5
  implements Runnable
{
  QMFtnUploadNotification$5(QMFtnUploadNotification paramQMFtnUploadNotification) {}
  
  public void run()
  {
    QMFtnUploadNotification.access$400(this.this$0);
    QMNotificationConstructor.getInstance().clearFtnUploadNotify();
    Log.d("yahuang", "notify-state clear st: " + QMFtnUploadNotification.access$500(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMFtnUploadNotification.5
 * JD-Core Version:    0.7.0.1
 */