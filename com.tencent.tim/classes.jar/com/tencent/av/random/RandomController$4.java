package com.tencent.av.random;

import com.tencent.qphone.base.util.QLog;

class RandomController$4
  implements Runnable
{
  RandomController$4(RandomController paramRandomController) {}
  
  public void run()
  {
    if (RandomController.c(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "mRandomPushTimeoutRunnable trigger, request room owner!");
      }
      RandomController.a(this.this$0).v(RandomController.b(this.this$0), this.this$0.mK);
      this.this$0.apF();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("RandomController", 2, "mRoomOwnerEnable == false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.random.RandomController.4
 * JD-Core Version:    0.7.0.1
 */