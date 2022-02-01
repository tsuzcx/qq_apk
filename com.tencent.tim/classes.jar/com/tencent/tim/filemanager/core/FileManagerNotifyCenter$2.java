package com.tencent.tim.filemanager.core;

import agkf;
import agkh;
import ahav;
import anaz;
import atti;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class FileManagerNotifyCenter$2
  implements Runnable
{
  public FileManagerNotifyCenter$2(atti paramatti, FileManagerEntity paramFileManagerEntity, int paramInt) {}
  
  public void run()
  {
    if ((this.b.mContext != null) && ((this.b.mContext instanceof String)) && ("DeceptiveProgressed".equalsIgnoreCase((String)this.b.mContext)))
    {
      QLog.i("FileManagerNotifyCenter<FileAssistant>", 1, "id:" + this.b.nSessionId + " DeceptiveProgressed return");
      return;
    }
    QLog.i("Bug", 1, "id:" + this.b.nSessionId + " do DeceptiveProgress");
    this.b.status = 2;
    this.b.fProgress = 0.0F;
    this.this$0.a(this.b.uniseq, this.b.nSessionId, this.b.peerUin, this.b.peerType, 16, null, 14, null);
    for (;;)
    {
      if (this.b.fProgress >= 0.95F)
      {
        this.b.fProgress = 1.0F;
        this.this$0.app.a().b(true, 3, null);
      }
      try
      {
        Thread.sleep(50L);
        if (this.b.fProgress < 1.0F) {
          continue;
        }
        this.b.fProgress = 1.0F;
        this.b.fProgress = 0.0F;
        this.b.status = 1;
        this.b.mContext = new String("DeceptiveProgressed");
        QLog.i("FileManagerNotifyCenter<FileAssistant>", 1, "id:" + this.b.nSessionId + " set DeceptiveProgressed");
        switch (this.cXo)
        {
        default: 
          this.this$0.app.a().b(true, 3, null);
          ahav.jS(this.b.nSessionId);
          this.b.lastSuccessTime = anaz.gQ();
          this.this$0.app.a().u(this.b);
          return;
          FileManagerEntity localFileManagerEntity = this.b;
          localFileManagerEntity.fProgress = ((float)(localFileManagerEntity.fProgress + 0.05D));
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
          continue;
          this.b.setCloudType(3);
          this.b.status = 1;
          this.this$0.a(this.b.uniseq, this.b.nSessionId, this.b.peerUin, this.b.peerType, 14, new Object[] { this.b.getFilePath(), Long.valueOf(this.b.fileSize), Boolean.valueOf(true), this.b.strServerPath }, 0, null);
          continue;
          this.this$0.a(this.b.uniseq, this.b.nSessionId, this.b.peerUin, this.b.peerType, 14, new Object[] { this.b.getFilePath(), Long.valueOf(this.b.fileSize), Boolean.valueOf(true), this.b.strServerPath }, 0, null);
          continue;
          this.this$0.app.a().b(true, 34, new Object[] { this.b.WeiYunFileId, Long.valueOf(this.b.nSessionId) });
          continue;
          this.this$0.app.a().b(true, 33, new Object[] { this.b.Uuid });
          continue;
          this.this$0.app.a().b(true, 53, new Object[] { this.b.Uuid });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.FileManagerNotifyCenter.2
 * JD-Core Version:    0.7.0.1
 */