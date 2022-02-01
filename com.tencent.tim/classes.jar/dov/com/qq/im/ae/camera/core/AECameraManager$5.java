package dov.com.qq.im.ae.camera.core;

import aasq;
import android.graphics.SurfaceTexture;
import awwa;
import axiy;

public class AECameraManager$5
  implements Runnable
{
  public AECameraManager$5(awwa paramawwa, SurfaceTexture paramSurfaceTexture, aasq paramaasq) {}
  
  public void run()
  {
    if (!awwa.a(this.this$0))
    {
      axiy.e("AECameraManager", "startCameraPreview EXIT: camera NOT created");
      return;
    }
    if (awwa.b(this.this$0))
    {
      axiy.e("AECameraManager", "startCameraPreview EXIT: camera is already previewing");
      return;
    }
    awwa.a(this.this$0, this.g, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.5
 * JD-Core Version:    0.7.0.1
 */