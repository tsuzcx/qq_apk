package com.tencent.mobileqq.filemanager.app;

import aghw;
import agib;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class FileTransferHandler$7$1
  implements Runnable
{
  FileTransferHandler$7$1(FileTransferHandler.7 param7) {}
  
  public void run()
  {
    if (this.a.b.nFileType == 0)
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "Id[" + this.a.b.nSessionId + "]Send CCMsg, but not size and thumb, try download Pic Thumb");
      this.a.this$0.app.a().b(this.a.b, 7);
    }
    while (this.a.b.nFileType != 2) {
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "Id[" + this.a.b.nSessionId + "]Send CCMsg, but not size and thumb, try download Video Thumb");
    this.a.this$0.app.a().a(this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.7.1
 * JD-Core Version:    0.7.0.1
 */