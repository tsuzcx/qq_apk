package com.tencent.mobileqq.msgbackup.fragment;

import ajdt;
import ajee;
import android.os.Message;
import aqiw;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class MsgBackupQRFragment$2
  implements Runnable
{
  MsgBackupQRFragment$2(MsgBackupQRFragment paramMsgBackupQRFragment) {}
  
  public void run()
  {
    boolean bool;
    if (aqiw.getSystemNetwork(this.this$0.getActivity()) == 1)
    {
      bool = true;
      if (bool != MsgBackupQRFragment.a(this.this$0))
      {
        MsgBackupQRFragment.a(this.this$0, bool);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupQRFragment", 2, "mMigrateQrNetStateRunnable: enable = " + bool);
        }
        if (!bool) {
          break label195;
        }
        if ((MsgBackupQRFragment.b(this.this$0)) || (MsgBackupQRFragment.c(this.this$0))) {
          break label168;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupQRFragment", 2, "mMigrateQrNetStateRunnable startServerProxy is not called! current wifi is connected so called it");
        }
        ajee.a().LV(false);
        label112:
        Message localMessage = this.this$0.mUIHandler.obtainMessage(10013);
        this.this$0.mUIHandler.sendMessage(localMessage);
        MsgBackupQRFragment.b(this.this$0, true);
      }
    }
    for (;;)
    {
      this.this$0.t.postDelayed(this, 500L);
      return;
      bool = false;
      break;
      label168:
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "mMigrateQrNetStateRunnable startServerProxy is called!");
      }
      ajee.a().b().LS(false);
      break label112;
      label195:
      MsgBackupQRFragment.a(this.this$0, false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment.2
 * JD-Core Version:    0.7.0.1
 */