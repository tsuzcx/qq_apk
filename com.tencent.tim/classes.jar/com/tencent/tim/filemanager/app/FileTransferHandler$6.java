package com.tencent.tim.filemanager.app;

import atsq;
import atuh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FileTransferHandler$6
  implements Runnable
{
  public void run()
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + this.Yq + "]  handle recv onlinefile resp. sucess =" + this.cdr);
    this.this$0.app.a().k(this.bHa, this.Yq, this.cdr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.app.FileTransferHandler.6
 * JD-Core Version:    0.7.0.1
 */