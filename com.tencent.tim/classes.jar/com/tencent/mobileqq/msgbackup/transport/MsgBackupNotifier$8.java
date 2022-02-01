package com.tencent.mobileqq.msgbackup.transport;

import ajee;
import ajgp;

class MsgBackupNotifier$8
  implements Runnable
{
  MsgBackupNotifier$8(MsgBackupNotifier paramMsgBackupNotifier, int paramInt1, int paramInt2, int paramInt3, String paramString, long paramLong) {}
  
  public void run()
  {
    ajee.a().a().onRecvMessage(this.diV, this.val$port, this.qA, this.val$data, this.val$cookie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.8
 * JD-Core Version:    0.7.0.1
 */