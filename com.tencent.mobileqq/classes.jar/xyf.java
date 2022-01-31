import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.qphone.base.util.QLog;

public class xyf
  implements Camera.AutoFocusCallback
{
  public xyf(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".photo", 2, "shot photo with custom camera focus " + paramBoolean);
    }
    NewFlowCameraReporter.a(paramBoolean);
    NewFlowCameraActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xyf
 * JD-Core Version:    0.7.0.1
 */