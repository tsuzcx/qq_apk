package com.tencent.mobileqq.ar.ARPromotion;

import adbn;
import com.tencent.av.avgesture.AVGestureWrapper;
import com.tencent.qphone.base.util.QLog;

public class ARTransferDoorLogicManager$4
  implements Runnable
{
  public ARTransferDoorLogicManager$4(adbn paramadbn) {}
  
  public void run()
  {
    try
    {
      AVGestureWrapper.clearCache();
      this.this$0.cPP();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        QLog.i(adbn.TAG, 2, "AVGestureWrapper.clearCache failed. UnsatisfiedLinkError. err = " + localUnsatisfiedLinkError.getMessage());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i(adbn.TAG, 2, "AVGestureWrapper.clearCache failed. err = " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.4
 * JD-Core Version:    0.7.0.1
 */