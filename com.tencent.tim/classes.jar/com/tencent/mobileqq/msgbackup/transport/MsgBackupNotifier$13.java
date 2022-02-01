package com.tencent.mobileqq.msgbackup.transport;

import ajee;
import ajgp;

class MsgBackupNotifier$13
  implements Runnable
{
  MsgBackupNotifier$13(MsgBackupNotifier paramMsgBackupNotifier, long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, int paramInt3, long paramLong5) {}
  
  public void run()
  {
    ajee.a().a().onSendProgress(this.acj, this.val$path, this.acm, this.MA, this.diW, this.ack, this.diT, this.diU, this.YJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.13
 * JD-Core Version:    0.7.0.1
 */