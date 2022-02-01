package com.tencent.mobileqq.msgbackup.transport;

import ajee;
import ajgp;

class MsgBackupNotifier$2
  implements Runnable
{
  MsgBackupNotifier$2(MsgBackupNotifier paramMsgBackupNotifier, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    ajee.a().a().onUdpPortChanged(this.diX, this.val$port);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.2
 * JD-Core Version:    0.7.0.1
 */