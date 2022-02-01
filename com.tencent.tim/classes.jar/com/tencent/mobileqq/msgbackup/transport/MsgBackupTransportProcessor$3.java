package com.tencent.mobileqq.msgbackup.transport;

import ajdt;
import ajee;
import ajgp;
import ajgv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class MsgBackupTransportProcessor$3
  implements Runnable
{
  public MsgBackupTransportProcessor$3(ajgp paramajgp, String paramString) {}
  
  public void run()
  {
    ajee.a().dwC();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    ajgp.a(this.this$0, localBaseApplication);
    this.this$0.dah = 2;
    this.this$0.acp = this.this$0.b.createSession(2, Long.parseLong(this.val$uin), this.this$0.a);
    if (this.this$0.aqz())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "confirmOnlinePush11b MBRROLE_SERVER session is invalidate panic error!");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "createSession end, session = " + this.this$0.acp);
    }
    this.this$0.e = new MsgBackupEndPoint();
    this.this$0.f = new MsgBackupEndPoint();
    int i = this.this$0.b.start(this.this$0.acp, this.this$0.e, this.this$0.f);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "after start called with ret = " + i + ", ipv4 = " + ajgv.ez(this.this$0.e.ipv4) + ", udpport = " + this.this$0.e.port + ", tcpport = " + this.this$0.f.port);
    }
    ajdt.a().dws();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.3
 * JD-Core Version:    0.7.0.1
 */