import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.activity.QQMapActivity.MapRuntime;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class beb
  extends BroadcastReceiver
{
  public beb(QQMapActivity.MapRuntime paramMapRuntime) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 1;
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    for (;;)
    {
      return;
      int i;
      if (paramContext.equals("com.tencent.process.exit"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQMapActivity", 2, "receive kill map process broadcast");
        }
        paramContext = paramIntent.getExtras().getStringArrayList("procNameList");
        if ((!QQMapActivity.a(paramIntent.getExtras().getString("verify"), paramContext)) || (!QQMapActivity.a(paramContext, MobileQQ.getContext()))) {
          break label144;
        }
        i = j;
      }
      while (i != 0)
      {
        Process.killProcess(Process.myPid());
        return;
        i = j;
        if (!paramContext.equals("mqql.intent.action.ACCOUNT_CHANGED"))
        {
          i = j;
          if (!paramContext.equals("mqql.intent.action.LOGOUT"))
          {
            i = j;
            if (!paramContext.equals("mqql.intent.action.EXIT_" + MobileQQ.getMobileQQ().getPackageName())) {
              label144:
              i = 0;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     beb
 * JD-Core Version:    0.7.0.1
 */