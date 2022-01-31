package com.tencent.biz.qrcode;

import android.hardware.Camera;
import com.tencent.qphone.base.util.QLog;

public final class AutoFocusManager$AutoFocusThread
  extends Thread
{
  protected AutoFocusManager$AutoFocusThread(AutoFocusManager paramAutoFocusManager) {}
  
  public void run()
  {
    try
    {
      for (;;)
      {
        Thread.sleep(3000L);
        if (!this.a.jdField_a_of_type_Boolean) {
          break;
        }
        try
        {
          this.a.b = true;
          this.a.jdField_a_of_type_AndroidHardwareCamera.autoFocus(this.a);
          if (QLog.isDevelopLevel()) {
            QLog.d(AutoFocusManager.jdField_a_of_type_JavaLangString, 4, "call autoFocus");
          }
        }
        catch (RuntimeException localRuntimeException) {}
      }
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.AutoFocusManager.AutoFocusThread
 * JD-Core Version:    0.7.0.1
 */