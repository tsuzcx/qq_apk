import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

public class xxn
  implements Runnable
{
  public xxn(CameraGLSurfaceView paramCameraGLSurfaceView) {}
  
  public void run()
  {
    CameraGLSurfaceView.a(this.a).sendFirstFrameMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xxn
 * JD-Core Version:    0.7.0.1
 */