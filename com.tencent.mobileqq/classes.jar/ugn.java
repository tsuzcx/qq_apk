import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.webprocess.WebProcessManager.WebProcessStartListener;
import com.tencent.qphone.base.util.QLog;

public final class ugn
  implements WebProcessManager.WebProcessStartListener
{
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebAccelerator", 2, "preStart QWeb Process");
      }
      AIOOpenWebMonitor.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ugn
 * JD-Core Version:    0.7.0.1
 */