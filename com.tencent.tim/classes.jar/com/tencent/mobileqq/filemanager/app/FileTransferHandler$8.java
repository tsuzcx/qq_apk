package com.tencent.mobileqq.filemanager.app;

import agib;
import aglp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FileTransferHandler$8
  implements Runnable
{
  public FileTransferHandler$8(agib paramagib, long paramLong, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + this.Yq + "]  handle query onlinefile upload progress resp. sucess =" + this.cdr);
    this.this$0.app.a().l(this.bHa, this.Yq, this.cdr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.8
 * JD-Core Version:    0.7.0.1
 */