import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.qphone.base.util.QLog;

public class cth
  extends BroadcastReceiver
{
  private cth(GuardManager paramGuardManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "received with " + paramContext);
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext)) {
      if (GuardManager.a(this.a) > 0L) {
        this.a.a(false);
      }
    }
    while ((!"android.intent.action.SCREEN_ON".equals(paramContext)) || (GuardManager.a(this.a) != 0L) || (!GuardManager.a(this.a))) {
      return;
    }
    GuardManager.a(this.a, SystemClock.uptimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cth
 * JD-Core Version:    0.7.0.1
 */