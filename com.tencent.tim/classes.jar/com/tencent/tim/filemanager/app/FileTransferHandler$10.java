package com.tencent.tim.filemanager.app;

import atsq;
import atuh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FileTransferHandler$10
  implements Runnable
{
  public void run()
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + this.Yq + "] Handle upload progress notify. speed=" + this.cWW + " progress =" + this.cWX);
    this.this$0.app.a().d(this.bHa, this.Yq, this.cWW, this.cWX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.app.FileTransferHandler.10
 * JD-Core Version:    0.7.0.1
 */