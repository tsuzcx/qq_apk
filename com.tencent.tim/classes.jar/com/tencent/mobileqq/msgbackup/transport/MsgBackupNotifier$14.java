package com.tencent.mobileqq.msgbackup.transport;

import ajee;
import ajgp;

class MsgBackupNotifier$14
  implements Runnable
{
  MsgBackupNotifier$14(MsgBackupNotifier paramMsgBackupNotifier, long paramLong1, boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong2) {}
  
  public void run()
  {
    ajee.a().a().onSendComplete(this.acj, this.val$success, this.val$errCode, this.val$path, this.diT, this.diU, this.YJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.14
 * JD-Core Version:    0.7.0.1
 */