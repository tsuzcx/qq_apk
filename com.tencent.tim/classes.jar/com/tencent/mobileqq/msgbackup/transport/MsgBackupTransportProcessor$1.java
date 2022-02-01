package com.tencent.mobileqq.msgbackup.transport;

import ajdt;
import ajgp;
import ajgv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class MsgBackupTransportProcessor$1
  implements Runnable
{
  public MsgBackupTransportProcessor$1(ajgp paramajgp, String paramString) {}
  
  public void run()
  {
    try
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      ajgp.a(this.this$0, localBaseApplication);
      this.this$0.dah = 1;
      this.this$0.acp = this.this$0.b.createSession(1, Long.parseLong(this.val$uin), this.this$0.a);
      if (this.this$0.aqz())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "startAsClient session is invalidate panic error!");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup", 2, "createSession end, operator = " + this.this$0.acp);
        }
        this.this$0.c = new MsgBackupEndPoint();
        this.this$0.d = new MsgBackupEndPoint();
        int i = this.this$0.b.start(this.this$0.acp, this.this$0.c, this.this$0.d);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup", 2, "after start as client called with ret = " + i + ", ipv4 = " + ajgv.ez(this.this$0.c.ipv4) + ", udpport = " + this.this$0.c.port + ", tcpport = " + this.this$0.d.port);
        }
        ajdt.a().dws();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MsgBackup", 1, "startAsClient occur error", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.1
 * JD-Core Version:    0.7.0.1
 */