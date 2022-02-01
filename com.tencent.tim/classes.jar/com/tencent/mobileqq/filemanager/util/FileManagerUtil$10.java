package com.tencent.mobileqq.filemanager.util;

import ahbj;
import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import dz;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class FileManagerUtil$10
  implements Runnable
{
  public FileManagerUtil$10(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (ahbj.fileExistsAndNotEmpty(this.fe)) {}
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = dz.a(this.val$filePath, this.val$w, this.val$h);
    } while (localBitmap == null);
    try
    {
      ahbj.f(localBitmap, this.fe);
      localBitmap.recycle();
      int i = dz.l(this.val$filePath);
      dz.e(this.fe, i);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail FileNotFoundException:" + localFileNotFoundException.getMessage());
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail IOException:" + localIOException.getMessage());
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail OutOfMemoryError:" + localOutOfMemoryError.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.10
 * JD-Core Version:    0.7.0.1
 */