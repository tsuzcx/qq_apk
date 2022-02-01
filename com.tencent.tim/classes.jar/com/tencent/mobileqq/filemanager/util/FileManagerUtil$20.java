package com.tencent.mobileqq.filemanager.util;

import ahav.f;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public final class FileManagerUtil$20
  implements Runnable
{
  public FileManagerUtil$20(FileManagerEntity paramFileManagerEntity, ahav.f paramf, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.b == null)
    {
      QLog.w("CHECK_FILE_EXISTED", 1, "checkFileExisted: entity is null");
      if (this.a != null) {
        this.a.JC(false);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("CHECK_FILE_EXISTED", 1, "checkFile 10md5[" + this.b.str10Md5 + "], sha3[" + this.b.strFileSha3 + "], md5[" + this.b.strFileMd5 + "]");
      }
    } while ((this.b.nFileType != 0) && (this.b.nFileType != 2));
    new Handler(Looper.getMainLooper()).post(new FileManagerUtil.20.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.20
 * JD-Core Version:    0.7.0.1
 */