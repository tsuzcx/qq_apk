import com.tencent.mobileqq.widget.CameraFrameLayout;
import com.tencent.mobileqq.widget.CameraPreview;

public class hfg
  implements Runnable
{
  public hfg(CameraFrameLayout paramCameraFrameLayout) {}
  
  public void run()
  {
    if (CameraFrameLayout.a(this.a) != null) {
      CameraFrameLayout.a(this.a).a(this.a.getWidth(), this.a.getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hfg
 * JD-Core Version:    0.7.0.1
 */