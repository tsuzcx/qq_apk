import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraOperator;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter;
import com.tencent.mobileqq.activity.richmedia.ShortVideoCaptureController;
import com.tencent.qphone.base.util.QLog;

public class xrx
  implements Runnable
{
  public xrx(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    String str = this.a.e;
    NewFlowCameraActivity.a(this.a);
    ShortVideoCaptureController.a(str, NewFlowCameraOperator.a);
    this.a.q = 0;
    if (QLog.isColorLevel()) {
      QLog.d(".photo", 2, "shot photo with capture from video");
    }
    NewFlowCameraActivity.a(this.a);
    if (this.a.a == null) {}
    for (str = "";; str = this.a.a.a())
    {
      FlowCameraMqqAction.a("", "0X80075BE", str, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xrx
 * JD-Core Version:    0.7.0.1
 */