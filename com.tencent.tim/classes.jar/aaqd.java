import android.os.MessageQueue.IdleHandler;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.qphone.base.util.QLog;

public class aaqd
  implements MessageQueue.IdleHandler
{
  public aaqd(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public boolean queueIdle()
  {
    if (anii.isFoundProduct(anii.KEY_NOT_CALLBACK_WHEN_SCREENOFF_MODEL)) {
      this.this$0.CG(true);
    }
    for (;;)
    {
      if ((this.this$0.bwR) && (this.this$0.a != null)) {
        this.this$0.a.onResume();
      }
      this.this$0.c.onResume();
      this.this$0.fg.setEnabled(false);
      if (QLog.isColorLevel()) {
        QLog.i("PEAK_CAMERA", 2, "Added camera view.");
      }
      return false;
      this.this$0.cwp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaqd
 * JD-Core Version:    0.7.0.1
 */