import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.utils.CameraUtil;
import com.tencent.mobileqq.widget.CameraFrameLayout;
import com.tencent.qphone.base.util.QLog;

public class hfi
  implements Runnable
{
  public hfi(CameraFrameLayout paramCameraFrameLayout) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      synchronized (CameraFrameLayout.a(this.a))
      {
        CameraFrameLayout.a(this.a, CameraUtil.a());
        if (CameraFrameLayout.a(this.a) == null)
        {
          i = -1;
          long l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("CameraFrameLayout", 2, "openRealtimeBg.open camera cost time:" + (l2 - l1));
          }
          CameraFrameLayout.a(this.a).obtainMessage(1, i, 0).sendToTarget();
          return;
        }
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hfi
 * JD-Core Version:    0.7.0.1
 */