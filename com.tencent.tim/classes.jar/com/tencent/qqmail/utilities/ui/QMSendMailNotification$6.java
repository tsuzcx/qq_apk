package com.tencent.qqmail.utilities.ui;

import com.tencent.qqmail.utilities.thread.Threads;

class QMSendMailNotification$6
  implements Runnable
{
  QMSendMailNotification$6(QMSendMailNotification paramQMSendMailNotification) {}
  
  public void run()
  {
    QMSendMailNotification.access$500(this.this$0);
    Threads.runOnMainThread(new QMSendMailNotification.6.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMSendMailNotification.6
 * JD-Core Version:    0.7.0.1
 */