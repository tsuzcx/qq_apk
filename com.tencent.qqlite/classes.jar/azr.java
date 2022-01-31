import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.NotificationActivity;

public class azr
  extends BroadcastReceiver
{
  public azr(NotificationActivity paramNotificationActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equals("com.tencent.qqlite.closeNotification")) && (NotificationActivity.a(this.a) == 5)) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     azr
 * JD-Core Version:    0.7.0.1
 */