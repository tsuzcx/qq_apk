import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.qphone.base.util.QLog;

public class xyg
  implements CameraCover.PictureCallback
{
  public xyg(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
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
 * Qualified Name:     xyg
 * JD-Core Version:    0.7.0.1
 */