import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

public class xuh
  implements Runnable
{
  public xuh(CameraGLSurfaceView paramCameraGLSurfaceView) {}
  
  public void run()
  {
    CameraGLSurfaceView.a(this.a).sendFirstFrameMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xuh
 * JD-Core Version:    0.7.0.1
 */