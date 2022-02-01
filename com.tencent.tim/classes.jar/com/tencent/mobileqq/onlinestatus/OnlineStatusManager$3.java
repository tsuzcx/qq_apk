package com.tencent.mobileqq.onlinestatus;

import aktp;
import com.tencent.qphone.base.util.QLog;

public class OnlineStatusManager$3
  implements Runnable
{
  public OnlineStatusManager$3(aktp paramaktp) {}
  
  public void run()
  {
    aktp.a(this.this$0, true);
    QLog.d("OnlineStatusManager", 1, "cancel background runnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusManager.3
 * JD-Core Version:    0.7.0.1
 */