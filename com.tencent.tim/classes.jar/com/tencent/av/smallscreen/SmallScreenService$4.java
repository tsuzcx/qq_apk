package com.tencent.av.smallscreen;

import com.tencent.qphone.base.util.QLog;

class SmallScreenService$4
  implements Runnable
{
  SmallScreenService$4(SmallScreenService paramSmallScreenService, long paramLong) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SmallScreenService", 4, "hideStateRunnable, sCanSendStateDelayFlag[" + SmallScreenService.Vy + "]");
    }
    if (SmallScreenService.Vy) {
      this.this$0.A(this.kQ, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenService.4
 * JD-Core Version:    0.7.0.1
 */