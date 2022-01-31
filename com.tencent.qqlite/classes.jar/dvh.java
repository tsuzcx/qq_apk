import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.IGetVideoCallback;
import com.tencent.qphone.base.util.QLog;

public final class dvh
  implements Runnable
{
  public dvh(String paramString, int paramInt1, boolean paramBoolean, FileManagerUtil.IGetVideoCallback paramIGetVideoCallback, int paramInt2, int paramInt3) {}
  
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
        localMediaMetadataRetriever.setDataSource(this.jdField_a_of_type_JavaLangString);
        long l = this.jdField_a_of_type_Int;
        if (this.jdField_a_of_type_Int <= 0) {
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
          localRuntimeException4.release();
          localObject1 = null;
        }
        catch (RuntimeException localRuntimeException1)
        {
          localObject2 = null;
        }
        continue;
      }
      catch (RuntimeException localRuntimeException2)
      {
        localRuntimeException2 = localRuntimeException2;
        try
        {
          localRuntimeException4.release();
          localObject3 = null;
        }
        catch (RuntimeException localRuntimeException3)
        {
          localObject4 = null;
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
      catch (RuntimeException localRuntimeException4)
      {
        continue;
      }
      try
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        Object localObject4;
        localRuntimeException4.release();
        label117:
        throw localBitmap2;
        if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IGetVideoCallback != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IGetVideoCallback.a(localBitmap2);
          return;
        }
        float f;
        label172:
        Matrix localMatrix;
        if (localBitmap2.getWidth() < localBitmap2.getHeight())
        {
          f = this.b / localBitmap2.getWidth();
          localMatrix = new Matrix();
          localMatrix.setScale(f, f);
        }
        for (;;)
        {
          try
          {
            localBitmap3 = FileManagerUtil.a(localMatrix, localBitmap2, this.b, this.c);
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IGetVideoCallback == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IGetVideoCallback.a(localBitmap3);
            return;
          }
          catch (Exception localException)
          {
            Bitmap localBitmap3;
            QLog.e("FileManagerUtil", 1, "transfrom bitmap fail, Exception:" + localException.toString());
          }
          f = this.c / localBitmap3.getHeight();
          break label172;
          Object localObject5 = null;
        }
      }
      catch (RuntimeException localRuntimeException5)
      {
        break label117;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dvh
 * JD-Core Version:    0.7.0.1
 */