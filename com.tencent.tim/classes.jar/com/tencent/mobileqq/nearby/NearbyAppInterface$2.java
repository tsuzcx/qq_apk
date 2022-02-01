package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.qphone.base.util.QLog;

class NearbyAppInterface$2
  implements Runnable
{
  NearbyAppInterface$2(NearbyAppInterface paramNearbyAppInterface) {}
  
  public void run()
  {
    synchronized (this.this$0.mLock)
    {
      boolean bool = this.this$0.cpJ;
      if (!bool) {}
      try
      {
        DeviceProfileManager.a(this.this$0, 215).i(this.this$0);
        this.this$0.cpJ = true;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NearbyAppInterface", 2, "onDestroy: ", localException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyAppInterface.2
 * JD-Core Version:    0.7.0.1
 */