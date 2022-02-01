import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class iik
{
  private iik.a a;
  private VideoAppInterface mApp;
  
  public iik(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
  }
  
  public void register()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      this.a = new iik.a();
      if (this.mApp != null) {
        this.mApp.getApplication().getApplicationContext().registerReceiver(this.a, localIntentFilter);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void unregister()
  {
    try
    {
      if ((this.mApp != null) && (this.a != null)) {
        this.mApp.getApplication().getApplicationContext().unregisterReceiver(this.a);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  static class a
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent == null) {}
      do
      {
        return;
        paramContext = paramIntent.getAction();
        if (paramContext.equals("android.intent.action.SCREEN_ON"))
        {
          QLog.d("GScreenActionMonitor", 1, "avideo ACTION_SCREEN_ON");
          return;
        }
        if (paramContext.equals("android.intent.action.SCREEN_OFF"))
        {
          QLog.d("GScreenActionMonitor", 1, "avideo ACTION_SCREEN_OFF");
          ikp.r(19, 1L);
          return;
        }
        if (paramContext.equals("android.intent.action.USER_PRESENT"))
        {
          QLog.d("GScreenActionMonitor", 1, "avideACTION_USER_PRESENT");
          ikp.r(19, 2L);
          return;
        }
      } while (!paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
      paramContext = paramIntent.getStringExtra("reason");
      QLog.d("GScreenActionMonitor", 1, "avideo ACTION_CLOSE_SYSTEM_DIALOGS, reason[" + paramContext + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iik
 * JD-Core Version:    0.7.0.1
 */