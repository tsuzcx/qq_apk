import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.qphone.base.util.QLog;

public class xox
  implements Runnable
{
  public xox(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void run()
  {
    if (!this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(2002, "抱歉，摄像头可能被禁止了", false);
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "[@] ERR_CODE_CAMERA_CREATE  黑名单机型,2秒还没有获取到预览帧,可能没有权限");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xox
 * JD-Core Version:    0.7.0.1
 */