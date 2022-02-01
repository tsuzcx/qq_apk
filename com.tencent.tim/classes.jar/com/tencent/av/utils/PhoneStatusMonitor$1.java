package com.tencent.av.utils;

import android.content.Context;
import jkf;
import jkg;

public class PhoneStatusMonitor$1
  implements Runnable
{
  public PhoneStatusMonitor$1(jkf paramjkf, Context paramContext) {}
  
  public void run()
  {
    jkg.listen(this.val$context, this.this$0.mPhoneStateListener, 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor.1
 * JD-Core Version:    0.7.0.1
 */