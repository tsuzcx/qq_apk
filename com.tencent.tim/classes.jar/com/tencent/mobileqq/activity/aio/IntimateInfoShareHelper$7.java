package com.tencent.mobileqq.activity.aio;

import com.tencent.qphone.base.util.QLog;
import rwt;
import wlh;

public class IntimateInfoShareHelper$7
  implements Runnable
{
  public IntimateInfoShareHelper$7(wlh paramwlh, int paramInt1, int paramInt2) {}
  
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
      QLog.d("IntimateInfoShareHelper", 1, "showQQToast error: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.7
 * JD-Core Version:    0.7.0.1
 */