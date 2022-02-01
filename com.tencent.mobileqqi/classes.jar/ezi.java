import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

public class ezi
  extends BroadcastReceiver
{
  public ezi(BrowserAppInterface paramBrowserAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (str == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!str.equals("com.tencent.process.exit")) {
            break label192;
          }
          paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
          if (paramContext.size() < 1) {
            break;
          }
          paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
          if (QLog.isColorLevel()) {
            QLog.d(BrowserAppInterface.b, 2, "runningActivity=" + paramContext);
          }
        } while ((paramContext != null) && (paramContext.length() > 0) && ((paramContext.contains("com.pay")) || (paramContext.contains("com.tenpay"))));
        paramContext = paramIntent.getExtras();
      } while (paramContext == null);
      paramIntent = paramContext.getStringArrayList("procNameList");
    } while ((!BrowserAppInterface.a(paramContext.getString("verify"), paramIntent)) || (!BrowserAppInterface.a(paramIntent, MobileQQ.getContext())));
    try
    {
      MsfServiceSdk.get().unRegisterMsfService();
      MsfServiceSdk.get().unbindMsfService();
      new ezj(this).start();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    label192:
    this.a.getApplication().otherProcessExit(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ezi
 * JD-Core Version:    0.7.0.1
 */