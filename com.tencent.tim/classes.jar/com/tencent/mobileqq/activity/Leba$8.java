package com.tencent.mobileqq.activity;

import aurf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;

class Leba$8
  implements Runnable
{
  Leba$8(Leba paramLeba) {}
  
  public void run()
  {
    try
    {
      if (WebProcessManager.aFS())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.leba", 2, "checkPreloadGameCenter");
        }
        Leba.b(this.this$0);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.leba", 2, "checkPreloadGameCenter, send message delay");
      }
      if (this.this$0.app != null)
      {
        WebProcessManager localWebProcessManager = (WebProcessManager)this.this$0.app.getManager(13);
        if ((localWebProcessManager != null) && (localWebProcessManager.aFT()) && (this.this$0.e != null))
        {
          this.this$0.e.removeMessages(1134010);
          this.this$0.e.sendEmptyMessageDelayed(1134010, 100L);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("Q.lebatab.leba", 1, "checkPreloadGameCenter exception, e=", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.8
 * JD-Core Version:    0.7.0.1
 */