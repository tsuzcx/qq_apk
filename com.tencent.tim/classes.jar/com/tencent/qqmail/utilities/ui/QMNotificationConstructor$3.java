package com.tencent.qqmail.utilities.ui;

class QMNotificationConstructor$3
  implements Runnable
{
  boolean isCancel = false;
  
  QMNotificationConstructor$3(QMNotificationConstructor paramQMNotificationConstructor) {}
  
  public void run()
  {
    if (!this.isCancel)
    {
      this.isCancel = true;
      this.this$0.clearNotify();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMNotificationConstructor.3
 * JD-Core Version:    0.7.0.1
 */