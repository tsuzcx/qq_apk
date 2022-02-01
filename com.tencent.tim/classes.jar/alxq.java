import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;

public class alxq
  implements anim.b
{
  public alxq(CameraCaptureView paramCameraCaptureView) {}
  
  public void bm(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onAutoFocusCallback single tap focus " + paramBoolean1 + ", camera2:" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      CameraCaptureView.a(this.this$0, true);
      return;
    }
    CameraCaptureView.b.dQq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alxq
 * JD-Core Version:    0.7.0.1
 */