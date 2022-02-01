package com.tencent.mobileqq.filemanager.app;

import aghw;
import agib;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class FileTransferHandler$12
  implements Runnable
{
  public FileTransferHandler$12(agib paramagib, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    if (this.b.nFileType == 0)
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "Id[" + this.b.nSessionId + "]Send CCMsg, but not size and thumb, try download Pic Thumb");
      this.this$0.app.a().b(this.b, 7);
    }
    while (this.b.nFileType != 2) {
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "Id[" + this.b.nSessionId + "]Send CCMsg, but not size and thumb, try download Video Thumb");
    this.this$0.app.a().b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.12
 * JD-Core Version:    0.7.0.1
 */