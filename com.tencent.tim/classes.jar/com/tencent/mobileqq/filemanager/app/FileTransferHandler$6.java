package com.tencent.mobileqq.filemanager.app;

import agib;
import aglp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FileTransferHandler$6
  implements Runnable
{
  public FileTransferHandler$6(agib paramagib, long paramLong, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + this.Yq + "]  handle recv onlinefile resp. sucess =" + this.cdr);
    this.this$0.app.a().k(this.bHa, this.Yq, this.cdr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.6
 * JD-Core Version:    0.7.0.1
 */