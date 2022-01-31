import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.qphone.base.util.QLog;

public class xou
  implements CameraExceptionHandler.Callback
{
  public xou(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void a(RuntimeException paramRuntimeException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FlowCameraActivity", 2, "[onDispatchThreadException]", paramRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xou
 * JD-Core Version:    0.7.0.1
 */