package com.tencent.av.utils;

import com.tencent.qphone.base.util.QLog;
import jkf;
import jkf.a;

class PhoneStatusMonitor$2$1
  implements Runnable
{
  PhoneStatusMonitor$2$1(PhoneStatusMonitor.2 param2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "onCallStateChanged isCallingRunnable run end  mIsCalling: " + this.a.this$0.mIsCalling);
    }
    if (this.a.this$0.mIsCalling)
    {
      this.a.this$0.mIsCalling = false;
      if (this.a.this$0.a != null) {
        this.a.this$0.a.onCallStateChanged(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor.2.1
 * JD-Core Version:    0.7.0.1
 */