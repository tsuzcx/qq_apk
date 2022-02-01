import android.os.Build.VERSION;
import android.os.MessageQueue.IdleHandler;
import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.qphone.base.util.QLog;

public class advw
  implements MessageQueue.IdleHandler
{
  public advw(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity) {}
  
  public boolean queueIdle()
  {
    if (anii.isFoundProduct(anii.KEY_NOT_CALLBACK_WHEN_SCREENOFF_MODEL)) {
      this.this$0.CG(true);
    }
    for (;;)
    {
      if (this.this$0.a != null) {
        this.this$0.a.onResume();
      }
      this.this$0.c.onResume();
      DynamicAvatarRecordActivity.a(this.this$0);
      if (Build.VERSION.SDK_INT < 14) {
        this.this$0.ad = aqha.a(this.this$0, 230).setMessage(acfp.m(2131705347)).setPositiveButton(this.this$0.getString(2131695681), new advx(this));
      }
      try
      {
        this.this$0.ad.setCancelable(false);
        this.this$0.ad.show();
        if (QLog.isColorLevel()) {
          QLog.i("PEAK_CAMERA", 2, "Added camera view.");
        }
        return false;
        this.this$0.CG(false);
      }
      catch (WindowManager.BadTokenException localBadTokenException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 2, "", localBadTokenException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     advw
 * JD-Core Version:    0.7.0.1
 */