import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.qphone.base.util.QLog;

public class xrf
  implements Runnable
{
  public xrf(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    if (!this.a.n)
    {
      this.a.a.a(2002, "抱歉，摄像头可能被禁止了", false);
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "[@] ERR_CODE_CAMERA_CREATE  黑名单机型,2秒还没有获取到预览帧,可能没有权限");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xrf
 * JD-Core Version:    0.7.0.1
 */