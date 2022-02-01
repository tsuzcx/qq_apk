package com.tencent.mobileqq.msgbackup.fragment;

import ajgp;
import android.os.Message;
import android.os.SystemClock;
import mqq.os.MqqHandler;

class MsgBackupBaseFragment$6
  implements Runnable
{
  MsgBackupBaseFragment$6(MsgBackupBaseFragment paramMsgBackupBaseFragment) {}
  
  public void run()
  {
    if (!ajgp.b().aqA())
    {
      if (SystemClock.elapsedRealtime() - this.this$0.aci > 30000L)
      {
        Message localMessage = this.this$0.mUIHandler.obtainMessage(10009);
        this.this$0.mUIHandler.sendMessage(localMessage);
        this.this$0.t.removeCallbacks(this);
        return;
      }
      this.this$0.t.postDelayed(this, 1000L);
      return;
    }
    this.this$0.t.removeCallbacks(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment.6
 * JD-Core Version:    0.7.0.1
 */