package com.tencent.av.random;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class RandomController$3
  implements Runnable
{
  RandomController$3(RandomController paramRandomController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "mMatchTimeoutRunnable trigger, show timeOutDialog!");
    }
    this.this$0.mStatus = -1;
    RandomController.a(this.this$0).apK();
    RandomController.c(this.this$0);
    RandomController.a(this.this$0).getHandler().removeCallbacks(RandomController.c(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.random.RandomController.3
 * JD-Core Version:    0.7.0.1
 */