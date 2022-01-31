import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class cqc
  extends BroadcastReceiver
{
  public cqc(BrowserAppInterface paramBrowserAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if (localObject == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!((String)localObject).equals("com.tencent.process.exit")) {
            break label296;
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
      localObject = paramContext.getStringArrayList("procNameList");
    } while ((!BrowserAppInterface.a(paramContext.getString("verify"), (ArrayList)localObject)) || (!BrowserAppInterface.a((ArrayList)localObject, MobileQQ.getContext())));
    try
    {
      MsfServiceSdk.get().unRegisterMsfService();
      MsfServiceSdk.get().unbindMsfService();
      if (QLog.isColorLevel()) {
        QLog.d(BrowserAppInterface.b, 2, "qq_mode_foreground=" + paramIntent.getBooleanExtra("qq_mode_foreground", false));
      }
      if (paramIntent.getBooleanExtra("qq_mode_foreground", false))
      {
        if (QLog.isColorLevel()) {
          QLog.d(BrowserAppInterface.b, 2, "restart web process");
        }
        paramContext = new Intent();
        paramContext.setAction("com.tencent.mobileqq.webprocess.restart_web_process");
        BaseApplicationImpl.getContext().sendBroadcast(paramContext);
        BrowserAppInterface.a(this.a);
        return;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.d(BrowserAppInterface.b, 2, "exit web process");
      }
      BrowserAppInterface.a(this.a);
      return;
    }
    label296:
    this.a.getApplication().otherProcessExit(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cqc
 * JD-Core Version:    0.7.0.1
 */