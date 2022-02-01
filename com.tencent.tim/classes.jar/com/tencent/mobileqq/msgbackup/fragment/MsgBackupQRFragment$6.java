package com.tencent.mobileqq.msgbackup.fragment;

import ajdt;
import ajee;
import mqq.os.MqqHandler;

class MsgBackupQRFragment$6
  implements Runnable
{
  MsgBackupQRFragment$6(MsgBackupQRFragment paramMsgBackupQRFragment) {}
  
  public void run()
  {
    ajee localajee = ajee.a();
    String str = localajee.b().xj();
    if (str != null)
    {
      localajee.Mt(str);
      this.this$0.t.postDelayed(this, 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment.6
 * JD-Core Version:    0.7.0.1
 */