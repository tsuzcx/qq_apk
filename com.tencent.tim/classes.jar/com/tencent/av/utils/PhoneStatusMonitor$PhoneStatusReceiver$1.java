package com.tencent.av.utils;

import com.tencent.qphone.base.util.QLog;
import jkf;
import jkf.a;
import jkf.b;
import jkg;

public class PhoneStatusMonitor$PhoneStatusReceiver$1
  implements Runnable
{
  public PhoneStatusMonitor$PhoneStatusReceiver$1(jkf.b paramb, String paramString) {}
  
  public void run()
  {
    boolean bool = jkg.isCalling(this.b.this$0.mContext);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, String.format("PhoneStatusReceiver, isCallingRunnable end, action[%s], mIsCalling[%s], isCalling[%s]", new Object[] { this.val$action, Boolean.valueOf(this.b.this$0.mIsCalling), Boolean.valueOf(bool) }));
    }
    if ((this.b.this$0.mIsCalling) && (!bool))
    {
      this.b.this$0.mIsCalling = false;
      if (this.b.this$0.a != null) {
        this.b.this$0.a.onCallStateChanged(false);
      }
    }
    do
    {
      do
      {
        return;
      } while ((this.b.this$0.mIsCalling) || (!bool));
      this.b.this$0.mIsCalling = true;
    } while (this.b.this$0.a == null);
    this.b.this$0.a.onCallStateChanged(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusReceiver.1
 * JD-Core Version:    0.7.0.1
 */