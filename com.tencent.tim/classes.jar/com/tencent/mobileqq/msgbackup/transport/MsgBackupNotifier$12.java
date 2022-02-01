package com.tencent.mobileqq.msgbackup.transport;

import ajee;
import ajgp;

class MsgBackupNotifier$12
  implements Runnable
{
  MsgBackupNotifier$12(MsgBackupNotifier paramMsgBackupNotifier, long paramLong, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    ajee.a().a().onHttpRequest(this.acl, this.diV, this.val$port, this.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.12
 * JD-Core Version:    0.7.0.1
 */