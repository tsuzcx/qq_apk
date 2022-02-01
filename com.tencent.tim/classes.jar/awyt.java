import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.d;
import dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.9.1;

public class awyt
  implements AECameraGLSurfaceView.d
{
  awyt(awyk paramawyk) {}
  
  public void w(Bitmap paramBitmap)
  {
    ThreadManager.excute(new VideoStoryCapturePart.9.1(this, paramBitmap), 64, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awyt
 * JD-Core Version:    0.7.0.1
 */