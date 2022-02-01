package com.tencent.tim.filemanager.core;

import aqiw;
import atti;
import atud;
import audw;
import audw.b;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class OfflineSendWorker$1
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 2, "OfflineSendWorker run task sessionid[" + atud.a(this.this$0).nSessionId + "],filePath[" + atud.a(this.this$0).getFilePath() + "]");
    }
    if (!aqiw.isNetSupport(BaseApplicationImpl.getContext()))
    {
      atud.a(this.this$0, 0);
      atud.a(this.this$0).a().a(atud.a(this.this$0).uniseq, atud.a(this.this$0).nSessionId, atud.a(this.this$0).peerUin, atud.a(this.this$0).peerType, 15, null, 2, null);
      atud.a(this.this$0, 0L, 9004, "NoNetWork");
      atud.b(this.this$0, 0L, 9004, "NoNetWork");
      return;
    }
    atud.a(this.this$0, System.currentTimeMillis());
    atud.a(this.this$0).status = 2;
    audw.b localb = new audw.b();
    localb.bJE = "send_file_number";
    audw.a(atud.a(this.this$0).getCurrentAccountUin(), localb);
    atud.a(this.this$0);
    atud.a(this.this$0).a().b(true, 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.OfflineSendWorker.1
 * JD-Core Version:    0.7.0.1
 */