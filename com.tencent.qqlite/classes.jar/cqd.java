import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;

public class cqd
  extends BroadcastReceiver
{
  private cqd(BaseActivity paramBaseActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
    {
      if ((this.a.d_ != 0) || (!this.a.t) || (this.a.app == null) || (GesturePWDUtils.getGesturePWDState(this.a.getActivity(), this.a.app.a()) != 2) || (GesturePWDUtils.getGesturePWDMode(this.a.getActivity(), this.a.app.a()) != 21) || ((this.a.getActivity() instanceof GesturePWDUnlockActivity)) || ((this.a.getActivity() instanceof LoginActivity)) || (GesturePWDUtils.getGestureLocking(this.a.getActivity()))) {
        break label176;
      }
      this.a.w();
    }
    for (;;)
    {
      BaseActivity.isUnLockSuccess = false;
      if (QLog.isDevelopLevel()) {
        QLog.d("qqBaseActivity", 4, "onReceive broadcastreceiver.action=" + paramIntent.getAction());
      }
      return;
      label176:
      this.a.b_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cqd
 * JD-Core Version:    0.7.0.1
 */