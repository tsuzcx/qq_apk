package com.tencent.mobileqq.msgbackup.transport;

import ajee;
import ajgp;

class MsgBackupNotifier$10
  implements Runnable
{
  MsgBackupNotifier$10(MsgBackupNotifier paramMsgBackupNotifier, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    ajee.a().a().onRecvProgress(this.acj, this.MA, this.ack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.10
 * JD-Core Version:    0.7.0.1
 */