package com.tencent.tim.filemanager.core;

import aqiw;
import atti;
import attm;
import audw;
import audw.b;
import audx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class FileManagerRSWorker$5
  implements Runnable
{
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      if ("run task sessionid[" + String.valueOf(this.this$0.nSessionId) + "]," + " actionType[" + String.valueOf(this.this$0.actionType) + "], " + "strUin[" + this.this$0.strUin == null) {
        break label347;
      }
      localObject = audx.kZ(this.this$0.strUin);
    }
    for (;;)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, (String)localObject);
      if (aqiw.isNetSupport(BaseApplicationImpl.getContext())) {
        break;
      }
      this.this$0.setStatus(0);
      this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 1, null, 2, null);
      audx.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.aBA, this.this$0.startTime, attm.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, 9004L, "", 0L, 0L, this.this$0.nFileSize, "", "", attm.a(this.this$0), "NoNetWork", null);
      audx.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.bHN, this.this$0.startTime, attm.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, 9004L, "", 0L, 0L, this.this$0.nFileSize, "", "", attm.b(this.this$0), "NoNetWork", null);
      return;
      label347:
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
      localObject = new audw.b();
      ((audw.b)localObject).bJE = "send_file_number";
      audw.a(this.this$0.app.getCurrentAccountUin(), (audw.b)localObject);
      this.this$0.alA();
      continue;
      localObject = new audw.b();
      ((audw.b)localObject).bJE = "rece_file_number";
      audw.a(this.this$0.app.getCurrentAccountUin(), (audw.b)localObject);
      this.this$0.dhp();
      continue;
      this.this$0.dhs();
      continue;
      attm.a(this.this$0);
      continue;
      this.this$0.dhu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.FileManagerRSWorker.5
 * JD-Core Version:    0.7.0.1
 */