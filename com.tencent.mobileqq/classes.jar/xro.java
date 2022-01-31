import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.qphone.base.util.QLog;

public class xro
  implements CameraExceptionHandler.Callback
{
  public xro(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void a(RuntimeException paramRuntimeException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "[onDispatchThreadException]", paramRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xro
 * JD-Core Version:    0.7.0.1
 */