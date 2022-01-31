import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.qphone.base.util.QLog;

public class wwr
  implements Runnable
{
  public wwr(PeakService paramPeakService) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "peak service start MediaScanner.doScan()");
    }
    MediaScanner.a(BaseApplicationImpl.getContext()).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wwr
 * JD-Core Version:    0.7.0.1
 */