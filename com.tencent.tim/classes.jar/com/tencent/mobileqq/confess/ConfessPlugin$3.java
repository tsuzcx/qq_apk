package com.tencent.mobileqq.confess;

import com.tencent.qphone.base.util.QLog;
import rwt;

class ConfessPlugin$3
  implements Runnable
{
  ConfessPlugin$3(ConfessPlugin paramConfessPlugin, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      rwt.ez(this.aIT, this.bvD);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("ConfessPlugin", 1, "showQQToast error: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessPlugin.3
 * JD-Core Version:    0.7.0.1
 */