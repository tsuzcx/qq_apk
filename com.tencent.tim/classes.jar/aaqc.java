import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.qphone.base.util.QLog;

public class aaqc
  extends BroadcastReceiver
{
  public aaqc(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "receive ACTION_START_VIDEO_CHAT.");
      }
      paramContext = BaseActivity2.$(this.this$0.a, 2131367243);
      if (paramContext != null) {
        this.this$0.a.removeView(paramContext);
      }
      if ((this.this$0.c != null) && (this.this$0.c.a != null)) {
        this.this$0.c.a.dQh();
      }
      if (this.this$0.aNE) {
        this.this$0.cws();
      }
      if ((this.this$0.bwR) && (this.this$0.bwP)) {
        this.this$0.CH(false);
      }
      this.this$0.cwl();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaqc
 * JD-Core Version:    0.7.0.1
 */