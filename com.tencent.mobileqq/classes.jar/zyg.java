import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewPresenter;

public class zyg
  implements Runnable
{
  public zyg(ARVideoRecordUIControllerImpl paramARVideoRecordUIControllerImpl) {}
  
  public void run()
  {
    if (ARVideoRecordUIControllerImpl.a(this.a) != null)
    {
      ARVideoRecordUIControllerImpl.a(this.a).a(0);
      ARVideoRecordUIControllerImpl.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zyg
 * JD-Core Version:    0.7.0.1
 */