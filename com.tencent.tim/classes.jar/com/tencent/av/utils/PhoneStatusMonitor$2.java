package com.tencent.av.utils;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import jkf;
import jkg;

public class PhoneStatusMonitor$2
  implements Runnable
{
  public PhoneStatusMonitor$2(jkf paramjkf) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "onCallStateChanged isCallingRunnable run");
    }
    if ((this.this$0.mContext != null) && (!jkg.isCalling(this.this$0.mContext)) && (this.this$0.mHandler != null)) {
      this.this$0.mHandler.post(new PhoneStatusMonitor.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor.2
 * JD-Core Version:    0.7.0.1
 */