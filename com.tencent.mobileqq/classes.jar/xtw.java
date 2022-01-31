import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.ShortVideoCaptureController;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.shortvideo.util.SVFilterEncodeDoubleCache.SharedMemoryCache;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class xtw
  implements Runnable
{
  public xtw(CameraFilterGLView paramCameraFilterGLView, SVFilterEncodeDoubleCache.SharedMemoryCache paramSharedMemoryCache) {}
  
  public void run()
  {
    Bitmap localBitmap = (Bitmap)PtvFilterUtils.getBitmapFromSharedMem(CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView), CameraFilterGLView.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView), this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache$SharedMemoryCache.a);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache$SharedMemoryCache.a();
    if (TextUtils.isEmpty(CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView)))
    {
      ShortVideoCaptureController.a(3);
      return;
    }
    File localFile = new File(CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView));
    CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView, null);
    for (;;)
    {
      for (;;)
      {
        try
        {
          localObject = new Matrix();
          if (CameraFilterGLView.c(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView) % 180 == 0)
          {
            ((Matrix)localObject).postRotate(CameraFilterGLView.c(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView) + 180);
            ((Matrix)localObject).postScale(-1.0F, 1.0F);
            localObject = CameraUtils.a(Bitmap.createBitmap(localBitmap, 0, 0, CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView), CameraFilterGLView.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView), (Matrix)localObject, true));
            bool = ImageUtil.a((Bitmap)localObject, localFile);
          }
        }
        catch (Throwable localThrowable1)
        {
          Object localObject;
          boolean bool = false;
        }
        try
        {
          localBitmap.recycle();
          ImageUtil.a(BaseApplicationImpl.getContext(), localFile.getAbsolutePath());
          BaseApplicationImpl.sImageCache.put(localFile.getAbsolutePath() + "#short_video_camera_preview_cache", localObject);
          CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView, 90);
          if (!bool) {
            break label279;
          }
          ThreadManager.getUIHandler().post(new xtx(this, localFile));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PtvFilterUtils", 2, "Capture picture failed, cacheSuccess == null.");
          return;
        }
        catch (Throwable localThrowable2)
        {
          label272:
          break label272;
        }
      }
      ((Matrix)localObject).postRotate(CameraFilterGLView.c(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView));
      continue;
      localThrowable1.printStackTrace();
    }
    label279:
    ThreadManager.getUIHandler().post(new xty(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xtw
 * JD-Core Version:    0.7.0.1
 */