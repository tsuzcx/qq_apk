import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;

public class voq
  extends BroadcastReceiver
{
  public voq(QQMapActivity paramQQMapActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equals("android.intent.action.SCREEN_OFF")) && (!this.a.aZI) && (!this.a.hasStoped) && (GesturePWDUtils.getGesturePWDState(this.a, this.a.uin) == 2) && (GesturePWDUtils.getGesturePWDMode(this.a, this.a.uin) == 21))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqbaseactivity", 2, "qqmapactivity.start lock. receive lock.");
      }
      paramContext = new Intent(this.a, GesturePWDUnlockActivity.class);
      QQMapActivity.a(this.a, paramContext);
      this.a.hasStoped = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     voq
 * JD-Core Version:    0.7.0.1
 */