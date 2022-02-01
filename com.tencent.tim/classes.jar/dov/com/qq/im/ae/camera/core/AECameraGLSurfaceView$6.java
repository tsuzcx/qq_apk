package dov.com.qq.im.ae.camera.core;

import android.graphics.Bitmap;
import aqhq;
import aqhu;
import awvv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.h;
import java.io.File;
import java.io.IOException;

class AECameraGLSurfaceView$6
  implements Runnable
{
  AECameraGLSurfaceView$6(AECameraGLSurfaceView paramAECameraGLSurfaceView, Bitmap paramBitmap) {}
  
  public void run()
  {
    String str = AECameraGLSurfaceView.a(this.this$0).bZj + "/" + System.currentTimeMillis() + ".jpg";
    aqhq.UD(str);
    File localFile = new File(str);
    try
    {
      aqhu.a(this.gb, localFile);
      aqhu.cn(BaseApplicationImpl.getContext(), localFile.getAbsolutePath());
      AECameraGLSurfaceView.a(this.this$0, new CameraCaptureView.h(0, 0, str, null, AECameraGLSurfaceView.a(this.this$0)));
      this.gb.recycle();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        AECameraGLSurfaceView.a(this.this$0, new CameraCaptureView.h(0, -1, str, null, AECameraGLSurfaceView.a(this.this$0)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.6
 * JD-Core Version:    0.7.0.1
 */