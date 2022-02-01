import com.tencent.mobileqq.webprocess.WebProcessManager.a;
import com.tencent.qphone.base.util.QLog;

final class wjc
  implements WebProcessManager.a
{
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebAccelerator", 2, "preStart QWeb Process");
      }
      wis.bYp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wjc
 * JD-Core Version:    0.7.0.1
 */