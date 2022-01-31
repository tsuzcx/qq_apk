import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;

public class fdt
  extends BroadcastReceiver
{
  private fdt(BaseActivity paramBaseActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
    {
      if ((this.a.d_ != 0) || (!this.a.p) || (this.a.b == null) || (GesturePWDUtils.getGesturePWDState(this.a.a(), this.a.b.a()) != 2) || (GesturePWDUtils.getGesturePWDMode(this.a.a(), this.a.b.a()) != 21) || ((this.a.a() instanceof GesturePWDUnlockActivity)) || ((this.a.a() instanceof LoginActivity)) || (GesturePWDUtils.getGestureLocking(this.a.a()))) {
        break label176;
      }
      this.a.B();
    }
    for (;;)
    {
      BaseActivity.r = false;
      if (QLog.isDevelopLevel()) {
        QLog.d("qqBaseActivity", 4, "onReceive broadcastreceiver.action=" + paramIntent.getAction());
      }
      return;
      label176:
      this.a.c_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fdt
 * JD-Core Version:    0.7.0.1
 */