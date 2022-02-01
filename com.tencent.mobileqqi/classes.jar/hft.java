import com.tencent.mobileqq.widget.CameraFrameLayout;
import com.tencent.mobileqq.widget.CameraFrameLayoutProxy;
import com.tencent.qphone.base.util.QLog;

public class hft
  implements Runnable
{
  public hft(CameraFrameLayoutProxy paramCameraFrameLayoutProxy) {}
  
  public void run()
  {
    if ((CameraFrameLayoutProxy.a(this.a) != null) && (!CameraFrameLayoutProxy.a(this.a).a())) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CameraFrameLayoutProxy", 2, "mShouldStartRealtimeBg:" + this.a.a);
      }
    } while ((!this.a.a) || (this.a.b));
    if (QLog.isColorLevel()) {
      QLog.d("CameraFrameLayoutProxy", 2, "openRealtimeBg");
    }
    CameraFrameLayoutProxy.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hft
 * JD-Core Version:    0.7.0.1
 */