package com.tencent.mobileqq.filemanager.core;

import agkh;
import agll;
import ahau;
import ahau.a;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class OfflineSendWorker$1
  implements Runnable
{
  public OfflineSendWorker$1(agll paramagll) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 2, "OfflineSendWorker run task sessionid[" + this.this$0.c.nSessionId + "],filePath[" + this.this$0.c.getFilePath() + "]");
    }
    if (!aqiw.isNetSupport(BaseApplicationImpl.getContext()))
    {
      agll.a(this.this$0, 0);
      this.this$0.mApp.a().a(this.this$0.c.uniseq, this.this$0.c.nSessionId, this.this$0.c.peerUin, this.this$0.c.peerType, 15, null, 2, null);
      agll.a(this.this$0, 0L, 9004, "NoNetWork");
      agll.b(this.this$0, 0L, 9004, "NoNetWork");
      return;
    }
    this.this$0.mStartTime = System.currentTimeMillis();
    this.this$0.c.status = 2;
    ahau.a locala = new ahau.a();
    locala.bJE = "send_file_number";
    ahau.a(this.this$0.mApp.getCurrentAccountUin(), locala);
    this.this$0.dhI();
    this.this$0.mApp.a().b(true, 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OfflineSendWorker.1
 * JD-Core Version:    0.7.0.1
 */