import android.os.MessageQueue.IdleHandler;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.qphone.base.util.QLog;

public class xpc
  implements MessageQueue.IdleHandler
{
  public xpc(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public boolean queueIdle()
  {
    if (CameraCompatibleList.d(CameraCompatibleList.b)) {
      this.a.b(true);
    }
    for (;;)
    {
      if ((this.a.g) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onResume();
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
      this.a.c.setEnabled(false);
      if (QLog.isColorLevel()) {
        QLog.i("PEAK_CAMERA", 2, "Added camera view.");
      }
      return false;
      this.a.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xpc
 * JD-Core Version:    0.7.0.1
 */