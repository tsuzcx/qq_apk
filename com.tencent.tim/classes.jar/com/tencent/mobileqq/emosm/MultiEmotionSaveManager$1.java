package com.tencent.mobileqq.emosm;

import afge;
import afgt;
import ajlo;
import android.os.Handler;
import android.os.Message;
import aqhu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dx;
import java.io.File;

public class MultiEmotionSaveManager$1
  implements Runnable
{
  public MultiEmotionSaveManager$1(afgt paramafgt, File paramFile1, File paramFile2, String paramString, afge paramafge) {}
  
  public void run()
  {
    j = 1;
    int k = 0;
    for (;;)
    {
      try
      {
        if (this.au != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MultiEmotionSaveManager", 2, "savePhotoToSysAlbum...destFile=" + this.au);
          }
          if (!this.au.getParentFile().exists())
          {
            boolean bool = this.au.getParentFile().mkdir();
            if (QLog.isColorLevel()) {
              QLog.i("MultiEmotionSaveManager", 2, "savePhotoToSysAlbum...destFile.getParentFile() not exist mkdir=" + bool);
            }
          }
        }
        if ((this.au == null) || (!dx.copyFile(this.U, this.au))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("MultiEmotionSaveManager", 2, "savePhotoToSysAlbum...path=" + this.val$filePath);
        }
        aqhu.cn(BaseApplicationImpl.getContext(), this.au.getAbsolutePath());
        i = 1;
        if (i == 0) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MultiEmotionSaveManager", 2, "save exception = " + localException.getMessage());
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
      ((afge)localObject).result = i;
      localObject = afgt.a(this.this$0).obtainMessage(j);
      ((Message)localObject).obj = this.a;
      afgt.a(this.this$0).sendMessage((Message)localObject);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("MultiEmotionSaveManager", 2, "copyFile error destFile = " + this.au.getAbsolutePath());
      }
      this.a.errorCode = 10004;
      this.a.errorMessage = ajlo.getErrorMsg(this.a.errorCode);
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.MultiEmotionSaveManager.1
 * JD-Core Version:    0.7.0.1
 */