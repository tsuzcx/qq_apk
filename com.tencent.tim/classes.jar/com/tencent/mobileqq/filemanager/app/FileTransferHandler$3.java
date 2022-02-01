package com.tencent.mobileqq.filemanager.app;

import agib;
import agkf;
import agne;
import ahav;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class FileTransferHandler$3
  implements Runnable
{
  public FileTransferHandler$3(agib paramagib, String paramString, int paramInt, short paramShort, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    FileManagerEntity localFileManagerEntity = this.this$0.app.a().a(this.SO, this.cWZ);
    if (localFileManagerEntity != null)
    {
      localFileManagerEntity.msgSeq = this.ae;
      localFileManagerEntity.msgUid = this.HJ;
      localFileManagerEntity.msgTime = this.Wc;
      this.this$0.app.a().C(localFileManagerEntity);
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "online change to offline, update offline msg seq , uid and msgTime" + ahav.d(localFileManagerEntity));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.3
 * JD-Core Version:    0.7.0.1
 */