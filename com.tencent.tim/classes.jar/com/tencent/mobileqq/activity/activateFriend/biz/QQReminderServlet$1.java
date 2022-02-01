package com.tencent.mobileqq.activity.activateFriend.biz;

import android.os.Bundle;
import mqq.observer.BusinessObserver;
import wih;

public class QQReminderServlet$1
  implements Runnable
{
  public QQReminderServlet$1(wih paramwih, BusinessObserver paramBusinessObserver, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    this.val$observer.onReceive(this.val$type, this.val$isSuccess, this.val$data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.QQReminderServlet.1
 * JD-Core Version:    0.7.0.1
 */