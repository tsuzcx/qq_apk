package com.tencent.mobileqq.msgbackup.transport;

import ajee;
import ajgp;

class MsgBackupNotifier$11
  implements Runnable
{
  MsgBackupNotifier$11(MsgBackupNotifier paramMsgBackupNotifier, long paramLong1, String paramString1, int paramInt1, String paramString2, byte[] paramArrayOfByte, int paramInt2, int paramInt3, long paramLong2) {}
  
  public void run()
  {
    ajee.a().a().onRecvComplete(this.acj, this.val$url, this.val$errCode, this.val$path, this.eN, this.diT, this.diU, this.YJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.11
 * JD-Core Version:    0.7.0.1
 */