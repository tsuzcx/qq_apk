package com.tencent.mobileqq.msgbackup.transport;

import ajee;
import ajgp;

class MsgBackupNotifier$7
  implements Runnable
{
  MsgBackupNotifier$7(MsgBackupNotifier paramMsgBackupNotifier, boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    ajee.a().a().onSendMessage(this.val$success, this.val$cookie, this.YJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.7
 * JD-Core Version:    0.7.0.1
 */