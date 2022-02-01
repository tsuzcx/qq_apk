package com.tencent.mobileqq.app;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class QQAppInterface$22
  implements Runnable
{
  QQAppInterface$22(QQAppInterface paramQQAppInterface, long paramLong, Intent paramIntent) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.val$startTime;
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.broadcast", 2, "runNext, ThreadManager.excute, cost=" + (l1 - l2));
    }
    QQAppInterface.e(this.this$0, this.val$intent);
    this.this$0.aG.decrementAndGet();
    QQAppInterface.cv(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.22
 * JD-Core Version:    0.7.0.1
 */