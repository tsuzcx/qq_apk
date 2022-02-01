package com.tencent.mobileqq.msgbackup.transport;

import ajee;
import ajgp;

class MsgBackupNotifier$9
  implements Runnable
{
  MsgBackupNotifier$9(MsgBackupNotifier paramMsgBackupNotifier, long paramLong1, String paramString, long paramLong2, long paramLong3, long paramLong4) {}
  
  public void run()
  {
    ajee.a().a().onRecvStart(this.acj, this.val$url, this.acn, this.MA, this.YJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.9
 * JD-Core Version:    0.7.0.1
 */