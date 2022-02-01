package com.tencent.mobileqq.filemanager.app;

import agib;
import aglp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FileTransferHandler$5
  implements Runnable
{
  public void run()
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + this.Yt + "]  handle cmd 0x211-0x1.save to weiyun");
    this.this$0.app.a().q(this.bHa, this.Yt, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.5
 * JD-Core Version:    0.7.0.1
 */