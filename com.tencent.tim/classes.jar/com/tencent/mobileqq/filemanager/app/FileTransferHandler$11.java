package com.tencent.mobileqq.filemanager.app;

import agib;
import aglp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FileTransferHandler$11
  implements Runnable
{
  public FileTransferHandler$11(agib paramagib, long paramLong1, String paramString1, int paramInt, String paramString2, long paramLong2) {}
  
  public void run()
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + this.Yq + "] upload competed:");
    this.this$0.app.a().b(this.bHa, this.Yq, this.cWY, this.bHb, this.Yr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.11
 * JD-Core Version:    0.7.0.1
 */