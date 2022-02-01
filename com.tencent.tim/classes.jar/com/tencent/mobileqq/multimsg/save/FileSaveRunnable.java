package com.tencent.mobileqq.multimsg.save;

import ajlo;
import ajlq;
import android.os.Handler;
import android.os.Message;
import aqhu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dx;
import java.io.File;

public class FileSaveRunnable
  implements Runnable
{
  private ajlq a;
  private File aD;
  private boolean cpi;
  private File destFile;
  private Handler mHandler;
  
  public FileSaveRunnable(File paramFile1, File paramFile2, Handler paramHandler, ajlq paramajlq, boolean paramBoolean)
  {
    this.aD = paramFile1;
    this.destFile = paramFile2;
    this.mHandler = paramHandler;
    this.a = paramajlq;
    this.cpi = paramBoolean;
  }
  
  public void run()
  {
    j = 1;
    int k = 0;
    Object localObject;
    if ((this.aD == null) || (!this.aD.exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PictureSaveRunnable", 2, "save file fail");
      }
      localObject = this.mHandler.obtainMessage(2);
      this.a.errorCode = 10003;
      this.a.errorMessage = ajlo.getErrorMsg(this.a.errorCode);
      ((Message)localObject).obj = this.a;
      this.mHandler.sendMessage((Message)localObject);
      return;
    }
    if ((this.cpi) && (this.destFile != null) && (this.destFile.exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PictureSaveRunnable", 2, "desFile exist");
      }
      localObject = this.mHandler.obtainMessage(3);
      ((Message)localObject).obj = this.a;
      this.mHandler.sendMessage((Message)localObject);
      return;
    }
    for (;;)
    {
      try
      {
        if (this.destFile != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PictureSaveRunnable", 2, "FileSaveRunnable run savePhotoToSysAlbum...destFile=" + this.destFile);
          }
          if (!this.destFile.getParentFile().exists())
          {
            boolean bool = this.destFile.getParentFile().mkdir();
            if (QLog.isColorLevel()) {
              QLog.i("PictureSaveRunnable", 2, "FileSaveRunnable run savePhotoToSysAlbum...destFile.getParentFile() not exist mkdir=" + bool);
            }
          }
        }
        if ((this.destFile == null) || (!dx.copyFile(this.aD, this.destFile))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("PictureSaveRunnable", 2, "savePhotoToSysAlbum...");
        }
        aqhu.cn(BaseApplicationImpl.getContext(), this.destFile.getAbsolutePath());
        i = 1;
        if (i == 0) {
          continue;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PictureSaveRunnable", 2, "save exception = " + localException.getMessage());
        this.a.errorCode = 10005;
        this.a.errorMessage = ajlo.getErrorMsg(this.a.errorCode);
        continue;
        j = 2;
        continue;
        int i = -1;
        continue;
      }
      localObject = this.a;
      if (i == 0) {
        continue;
      }
      i = k;
      ((ajlq)localObject).result = i;
      localObject = this.mHandler.obtainMessage(j);
      ((Message)localObject).obj = this.a;
      this.mHandler.sendMessage((Message)localObject);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("PictureSaveRunnable", 2, "copyFile error");
      }
      this.a.errorCode = 10004;
      this.a.errorMessage = ajlo.getErrorMsg(this.a.errorCode);
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.FileSaveRunnable
 * JD-Core Version:    0.7.0.1
 */