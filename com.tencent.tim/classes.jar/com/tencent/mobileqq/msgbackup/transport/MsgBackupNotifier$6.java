package com.tencent.mobileqq.msgbackup.transport;

import ajee;
import ajgp;

class MsgBackupNotifier$6
  implements Runnable
{
  MsgBackupNotifier$6(MsgBackupNotifier paramMsgBackupNotifier, int paramInt) {}
  
  public void run()
  {
    ajee.a().a().onTcpConnStateChanged(this.val$state);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.6
 * JD-Core Version:    0.7.0.1
 */