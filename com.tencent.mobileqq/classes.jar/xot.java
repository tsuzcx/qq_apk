import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.qphone.base.util.QLog;

public class xot
  implements CameraCover.PictureCallback
{
  public xot(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void a_(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "onPictureToken path " + paramString);
    }
    this.a.a.b();
    NewFlowCameraActivity.a(this.a, paramString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xot
 * JD-Core Version:    0.7.0.1
 */