package mqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class QQBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject3 = null;
    Object localObject4 = (MobileQQ)paramContext.getApplicationContext();
    ((MobileQQ)localObject4).onActivityCreate(this, paramIntent);
    AppRuntime localAppRuntime = ((MobileQQ)localObject4).waitAppRuntime(null);
    Object localObject1;
    int i;
    if (paramIntent != null)
    {
      localObject1 = null;
      i = -1;
    }
    try
    {
      localObject2 = paramIntent.getStringExtra("k_pcactive_uin");
      localObject1 = localObject2;
      int j = paramIntent.getIntExtra("k_pcactive_retryIndex", -1);
      i = j;
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label65:
      break label65;
    }
    if ((!TextUtils.isEmpty(localObject1)) && (!"0".equals(localObject1)))
    {
      QLog.d("QQBroadcastReceiver", 1, "PCActive:active qq process");
      ((MobileQQ)localObject4).isPCActive = true;
      ((MobileQQ)localObject4).reportPCActive(localObject1, i);
      if (!SettingCloneUtil.readValue((Context)localObject4, localAppRuntime.getAccount(), null, "pcactive_has_notice", false)) {
        SettingCloneUtil.writeValue((Context)localObject4, localAppRuntime.getAccount(), null, "pcactive_notice_key", true);
      }
      if (!localAppRuntime.isLogin())
      {
        QLog.d("QQBroadcastReceiver", 1, "PCActive:Account is not login");
        localObject4 = localAppRuntime.getApplication().getAllAccounts();
        localObject2 = localObject3;
        if (localObject4 != null) {
          localObject2 = (SimpleAccount)((List)localObject4).get(0);
        }
        if ((localObject2 != null) && (localObject1.equals(((SimpleAccount)localObject2).getUin())) && (((SimpleAccount)localObject2).isLogined()))
        {
          QLog.d("QQBroadcastReceiver", 1, "PCActive:Show Notification");
          localAppRuntime.login((SimpleAccount)localObject2);
          localObject2 = new Intent("com.tencent.qqlite.closeNotification");
          ((Intent)localObject2).putExtra("uin", localObject1);
          paramContext.sendBroadcast((Intent)localObject2);
        }
      }
    }
    onReceive(localAppRuntime, paramContext, paramIntent);
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     mqq.app.QQBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */