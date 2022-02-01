import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.a;
import com.tencent.qphone.base.util.QLog;

public class aarv
  implements CameraCover.a
{
  public aarv(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void AE(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "onPictureToken path " + paramString);
    }
    this.this$0.mCamera.dQk();
    NewFlowCameraActivity.a(this.this$0, paramString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aarv
 * JD-Core Version:    0.7.0.1
 */