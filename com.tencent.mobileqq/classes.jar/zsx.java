import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qphone.base.util.QLog;

public final class zsx
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!paramIntent.getAction().equals("android.intent.action.SCREEN_ON")) {
            break;
          }
          SosoInterface.b(true);
        } while (!QLog.isColorLevel());
        QLog.i("SOSO.LBS", 2, "onReceive action is screen on.");
        return;
      } while (!paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"));
      SosoInterface.b(false);
      SosoInterface.a().sendEmptyMessage(1002);
    } while (!QLog.isColorLevel());
    QLog.i("SOSO.LBS", 2, "onReceive action is screen off.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zsx
 * JD-Core Version:    0.7.0.1
 */