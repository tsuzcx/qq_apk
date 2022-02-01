import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class aiag
  extends BroadcastReceiver
{
  private final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
  private final String SYSTEM_DIALOG_REASON_KEY = "reason";
  
  aiag(aiae paramaiae) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("VideoItemEventManager", 2, "onReceive ===>" + paramContext);
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      paramContext = aiae.a(this.b).iterator();
      while (paramContext.hasNext()) {
        ((aiae.a)paramContext.next()).KO(false);
      }
    }
    if ("android.intent.action.SCREEN_ON".equals(paramContext))
    {
      paramContext = aiae.a(this.b).iterator();
      while (paramContext.hasNext()) {
        ((aiae.a)paramContext.next()).KO(true);
      }
    }
    if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
    {
      paramContext = aiae.a(this.b).iterator();
      while (paramContext.hasNext()) {
        ((aiae.a)paramContext.next()).KP(true);
      }
    }
    if ("tencent.av.v2q.StopVideoChat".equals(paramContext))
    {
      paramContext = aiae.a(this.b).iterator();
      while (paramContext.hasNext()) {
        ((aiae.a)paramContext.next()).KP(false);
      }
    }
    if ("VolumeBtnDown".equals(paramIntent.getAction()))
    {
      paramContext = aiae.a(this.b).iterator();
      while (paramContext.hasNext()) {
        ((aiae.a)paramContext.next()).drJ();
      }
    }
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if (paramContext != null) {
        break label294;
      }
    }
    for (;;)
    {
      return;
      label294:
      if (paramContext.equals("homekey"))
      {
        paramContext = aiae.a(this.b).iterator();
        while (paramContext.hasNext())
        {
          ((aiae.a)paramContext.next()).drI();
          QLog.d("VideoItemEventManager", 2, "onReceive ===>homekey press");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiag
 * JD-Core Version:    0.7.0.1
 */