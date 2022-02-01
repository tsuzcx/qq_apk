package com.tencent.mobileqq.filemanager.util;

import agkf;
import ahav;
import ahav.a;
import ahav.f;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

class FileManagerUtil$20$1
  implements Runnable
{
  FileManagerUtil$20$1(FileManagerUtil.20 param20) {}
  
  public void run()
  {
    Object localObject = this.this$0.val$app.a().d(this.this$0.b.fileName, this.this$0.b.fileSize);
    if (QLog.isColorLevel()) {
      QLog.i("CHECK_FILE_EXISTED", 1, "find file size[" + ((List)localObject).size() + "]");
    }
    Iterator localIterator = ((List)localObject).iterator();
    do
    {
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label359;
        }
        localObject = (FileManagerEntity)localIterator.next();
        if (localObject != this.this$0.b)
        {
          long l = new VFSFile(((FileManagerEntity)localObject).getFilePath()).lastModified();
          if (((FileManagerEntity)localObject).localModifyTime == l) {
            break;
          }
          QLog.i("CHECK_FILE_EXISTED", 1, "find exsited file, but local modified,localModifyTime[" + ((FileManagerEntity)localObject).localModifyTime + "], fileModified[" + l + "]");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("CHECK_FILE_EXISTED", 1, ((FileManagerEntity)localObject).fileName + " findFile 10md5[" + ((FileManagerEntity)localObject).str10Md5 + "], sha3[" + ((FileManagerEntity)localObject).strFileSha3 + "], md5[" + ((FileManagerEntity)localObject).strFileMd5 + "]");
      }
    } while (!ahav.b((FileManagerEntity)localObject, this.this$0.b));
    for (;;)
    {
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CHECK_FILE_EXISTED", 1, "cann't find exsited file,entity[" + this.this$0.b.fileName + "]");
        }
        if (this.this$0.a != null) {
          this.this$0.a.JC(false);
        }
        return;
      }
      ahav.a.getExecutor().execute(new FileManagerUtil.20.1.1(this, (FileManagerEntity)localObject));
      return;
      label359:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.20.1
 * JD-Core Version:    0.7.0.1
 */