package mqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class QQBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    MobileQQ localMobileQQ = (MobileQQ)paramContext.getApplicationContext();
    if (paramIntent != null) {}
    try
    {
      paramIntent.putExtra("k_suicide_reborn", true);
      localMobileQQ.onActivityCreate(null, paramIntent);
      onReceive(localMobileQQ.waitAppRuntime(null), paramContext, paramIntent);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     mqq.app.QQBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */