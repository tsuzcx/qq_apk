import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.qphone.base.util.QLog;

public class advu
  extends BroadcastReceiver
{
  public advu(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicAvatarRecordActivity", 2, "receive ACTION_START_VIDEO_CHAT.");
      }
      paramContext = BaseActivity2.$(this.this$0.b, 2131367243);
      if (paramContext != null) {
        this.this$0.b.removeView(paramContext);
      }
      if ((this.this$0.c != null) && (this.this$0.c.a != null)) {
        this.this$0.c.a.dQh();
      }
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     advu
 * JD-Core Version:    0.7.0.1
 */