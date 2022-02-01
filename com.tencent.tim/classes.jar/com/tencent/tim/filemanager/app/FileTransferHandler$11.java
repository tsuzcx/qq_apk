package com.tencent.tim.filemanager.app;

import atsq;
import atuh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FileTransferHandler$11
  implements Runnable
{
  public void run()
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + this.Yq + "] upload competed:");
    this.this$0.app.a().b(this.bHa, this.Yq, this.cWY, this.bHb, this.Yr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.app.FileTransferHandler.11
 * JD-Core Version:    0.7.0.1
 */