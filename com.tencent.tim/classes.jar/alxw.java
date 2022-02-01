import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.mobileqq.richmedia.capture.view.FollowCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.FollowCaptureView.1.1;

public class alxw
  implements SurfaceTexture.OnFrameAvailableListener
{
  public alxw(FollowCaptureView paramFollowCaptureView) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    FollowCaptureView.a(this.this$0, paramSurfaceTexture);
    this.this$0.queueEvent(new FollowCaptureView.1.1(this, paramSurfaceTexture));
    if (!FollowCaptureView.a(this.this$0)) {
      FollowCaptureView.a(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alxw
 * JD-Core Version:    0.7.0.1
 */