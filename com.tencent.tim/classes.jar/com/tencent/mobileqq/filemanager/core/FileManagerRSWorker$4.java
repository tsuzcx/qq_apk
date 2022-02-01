package com.tencent.mobileqq.filemanager.core;

import agkh;
import agkl;
import ahau;
import ahau.a;
import ahav;
import anaz;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class FileManagerRSWorker$4
  implements Runnable
{
  public FileManagerRSWorker$4(agkl paramagkl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Running RSWorker:" + anaz.gQ());
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      if ("run task sessionid[" + String.valueOf(this.this$0.nSessionId) + "]," + " actionType[" + String.valueOf(this.this$0.actionType) + "], " + "strUin[" + this.this$0.strUin == null) {
        break label380;
      }
      localObject = ahav.kZ(this.this$0.strUin);
    }
    for (;;)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, (String)localObject);
      if (aqiw.isNetSupport(BaseApplicationImpl.getContext())) {
        break;
      }
      this.this$0.setStatus(0);
      this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 1, null, 2, null);
      ahav.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.aBA, this.this$0.startTime, agkl.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, 9004L, "", 0L, 0L, this.this$0.nFileSize, "", "", agkl.a(this.this$0), "NoNetWork", null);
      ahav.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.bHN, this.this$0.startTime, agkl.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, 9004L, "", 0L, 0L, this.this$0.nFileSize, "", "", agkl.b(this.this$0), "NoNetWork", null);
      return;
      label380:
      if ("null], filePath[" + this.this$0.strFilePath != null) {
        localObject = this.this$0.strFilePath;
      } else {
        localObject = "null], uniseq[" + String.valueOf(this.this$0.uniseq) + "]";
      }
    }
    this.this$0.startTime = System.currentTimeMillis();
    this.this$0.YF = 0L;
    this.this$0.c.status = 2;
    switch (this.this$0.actionType)
    {
    }
    for (;;)
    {
      this.this$0.app.a().b(true, 3, null);
      return;
      localObject = new ahau.a();
      ((ahau.a)localObject).bJE = "send_file_number";
      ahau.a(this.this$0.app.getCurrentAccountUin(), (ahau.a)localObject);
      this.this$0.alA();
      continue;
      localObject = new ahau.a();
      ((ahau.a)localObject).bJE = "rece_file_number";
      ahau.a(this.this$0.app.getCurrentAccountUin(), (ahau.a)localObject);
      this.this$0.dhp();
      continue;
      this.this$0.dhs();
      continue;
      agkl.a(this.this$0);
      continue;
      this.this$0.dhu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.4
 * JD-Core Version:    0.7.0.1
 */