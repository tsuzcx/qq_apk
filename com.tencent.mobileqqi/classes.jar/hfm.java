import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.utils.CameraUtil;
import com.tencent.mobileqq.widget.CameraFrameLayout;

public class hfm
  implements Runnable
{
  public hfm(CameraFrameLayout paramCameraFrameLayout) {}
  
  public void run()
  {
    synchronized (CameraFrameLayout.a(this.a))
    {
      if (CameraFrameLayout.a(this.a) != null)
      {
        CameraUtil.a(CameraFrameLayout.a(this.a));
        CameraFrameLayout.a(this.a, null);
      }
      CameraFrameLayout.a(this.a).obtainMessage(2).sendToTarget();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hfm
 * JD-Core Version:    0.7.0.1
 */