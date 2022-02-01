package com.tencent.mobileqq.msgbackup.transport;

import ajee;
import ajgp;

class MsgBackupNotifier$1
  implements Runnable
{
  MsgBackupNotifier$1(MsgBackupNotifier paramMsgBackupNotifier, boolean paramBoolean) {}
  
  public void run()
  {
    ajee.a().a().onUdpDetected(this.val$success);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.1
 * JD-Core Version:    0.7.0.1
 */