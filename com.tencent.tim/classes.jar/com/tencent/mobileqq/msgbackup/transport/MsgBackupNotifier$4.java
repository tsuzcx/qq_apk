package com.tencent.mobileqq.msgbackup.transport;

import ajee;
import ajgp;

class MsgBackupNotifier$4
  implements Runnable
{
  MsgBackupNotifier$4(MsgBackupNotifier paramMsgBackupNotifier, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    ajee.a().a().onVersoPortChanged(this.diX, this.val$port);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.4
 * JD-Core Version:    0.7.0.1
 */