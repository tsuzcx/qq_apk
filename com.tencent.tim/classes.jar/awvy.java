import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.ttpic.util.SensorUtil2;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.3.1;

public class awvy
  implements SurfaceTexture.OnFrameAvailableListener
{
  public awvy(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AECameraGLSurfaceView.a(this.this$0, true);
    if (!AECameraGLSurfaceView.a(this.this$0))
    {
      AECameraGLSurfaceView.b(this.this$0, true);
      axgk.a().acy("onFrameAvailable");
    }
    if (AECameraGLSurfaceView.a(this.this$0) != null) {
      AECameraGLSurfaceView.a(this.this$0).getRotation(AECameraGLSurfaceView.a(this.this$0));
    }
    this.this$0.queueEvent(new AECameraGLSurfaceView.3.1(this));
    this.this$0.requestRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awvy
 * JD-Core Version:    0.7.0.1
 */