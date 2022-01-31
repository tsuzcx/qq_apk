import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.qphone.base.util.QLog;

public class xnv
  implements Camera.AutoFocusCallback
{
  public xnv(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".photo", 2, "single tap focus " + paramBoolean);
    }
    NewFlowCameraReporter.a(paramBoolean);
    if (paramBoolean)
    {
      NewFlowCameraActivity.h(this.a, true);
      return;
    }
    this.a.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xnv
 * JD-Core Version:    0.7.0.1
 */