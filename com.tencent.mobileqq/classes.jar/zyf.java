import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewPresenter;
import com.tencent.qphone.base.util.QLog;

public class zyf
  implements Runnable
{
  public zyf(ARVideoRecordUIControllerImpl paramARVideoRecordUIControllerImpl) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("showVideoRecordButton inner run +");
      if (ARVideoRecordUIControllerImpl.a(this.a) == null) {
        break label81;
      }
    }
    label81:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("ARVideoRecordUIControllerImpl", 2, bool);
      if (ARVideoRecordUIControllerImpl.a(this.a) != null)
      {
        ARVideoRecordUIControllerImpl.a(this.a).a();
        ARVideoRecordUIControllerImpl.a(this.a).a(0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zyf
 * JD-Core Version:    0.7.0.1
 */