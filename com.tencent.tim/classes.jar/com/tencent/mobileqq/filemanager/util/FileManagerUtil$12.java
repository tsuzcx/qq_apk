package com.tencent.mobileqq.filemanager.util;

import ahav;
import ahav.b;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public final class FileManagerUtil$12
  implements Runnable
{
  public FileManagerUtil$12(String paramString, int paramInt1, boolean paramBoolean, ahav.b paramb, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    MediaMetadataRetriever localMediaMetadataRetriever;
    if (Build.VERSION.SDK_INT >= 10) {
      localMediaMetadataRetriever = new MediaMetadataRetriever();
    }
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(this.val$videoPath);
        long l = this.cYZ;
        if (this.cYZ <= 0) {
          l = 5000000L;
        }
        localBitmap1 = localMediaMetadataRetriever.getFrameAtTime(l, 2);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Bitmap localBitmap1;
        localIllegalArgumentException = localIllegalArgumentException;
        try
        {
          localException5.release();
          localObject1 = null;
        }
        catch (Exception localException1)
        {
          localObject2 = null;
        }
        continue;
      }
      catch (RuntimeException localRuntimeException)
      {
        localRuntimeException = localRuntimeException;
        try
        {
          localException5.release();
          localObject3 = null;
        }
        catch (Exception localException2)
        {
          localObject4 = null;
        }
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError = localOutOfMemoryError;
        try
        {
          localException5.release();
          localObject5 = null;
        }
        catch (Exception localException3)
        {
          localObject6 = null;
        }
        continue;
      }
      finally {}
      try
      {
        localMediaMetadataRetriever.release();
        if (localBitmap1 == null) {
          return;
        }
      }
      catch (Exception localException5)
      {
        continue;
      }
      try
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        localException5.release();
        label138:
        throw localBitmap2;
        if ((!this.cfV) && (this.a != null))
        {
          this.a.p(localBitmap2);
          return;
        }
        float f;
        label193:
        Matrix localMatrix;
        if (localBitmap2.getWidth() < localBitmap2.getHeight())
        {
          f = this.val$width / localBitmap2.getWidth();
          localMatrix = new Matrix();
          localMatrix.setScale(f, f);
        }
        for (;;)
        {
          try
          {
            localBitmap3 = ahav.b(localMatrix, localBitmap2, this.val$width, this.val$height);
            if (this.a == null) {
              break;
            }
            this.a.p(localBitmap3);
            return;
          }
          catch (Exception localException4)
          {
            Bitmap localBitmap3;
            QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception:" + localException4.toString());
          }
          f = this.val$height / localBitmap3.getHeight();
          break label193;
          Object localObject7 = null;
        }
      }
      catch (Exception localException6)
      {
        break label138;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.12
 * JD-Core Version:    0.7.0.1
 */