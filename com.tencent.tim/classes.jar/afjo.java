import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.MessengerService.a;
import com.tencent.qphone.base.util.QLog;

public class afjo
  extends acje
{
  public afjo(MessengerService.a parama, Bundle paramBundle, MessengerService paramMessengerService, boolean paramBoolean) {}
  
  public void m(boolean paramBoolean, String paramString)
  {
    int i = 1;
    super.m(paramBoolean, paramString);
    try
    {
      Object localObject = new Bundle();
      if (paramBoolean) {}
      for (;;)
      {
        ((Bundle)localObject).putInt("retCode", i);
        this.val$reqbundle.putBundle("response", (Bundle)localObject);
        this.val$service.cp(this.val$reqbundle);
        if (QLog.isColorLevel()) {
          QLog.d("MessengerService$IncomingHandler", 2, "IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW success! isFollow: " + this.tT + "  uin: " + paramString);
        }
        localObject = new Intent("com.tencent.mobileqq.PublicAccountObserver");
        ((Intent)localObject).putExtra("action", "follow");
        ((Intent)localObject).putExtra("isSuccess", paramBoolean);
        ((Intent)localObject).putExtra("uin", paramString);
        this.val$service.getApplicationContext().sendBroadcast((Intent)localObject);
        rwv.a().a(new FollowUpdateEvent(1, paramString));
        return;
        i = 0;
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("MessengerService$IncomingHandler", 2, "IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW failed! " + QLog.getStackTraceString(paramString));
    }
  }
  
  public void v(boolean paramBoolean, String paramString)
  {
    int i = 0;
    super.v(paramBoolean, paramString);
    try
    {
      Object localObject = new Bundle();
      if (paramBoolean) {
        i = 1;
      }
      ((Bundle)localObject).putInt("retCode", i);
      this.val$reqbundle.putBundle("response", (Bundle)localObject);
      this.val$service.cp(this.val$reqbundle);
      if (QLog.isColorLevel()) {
        QLog.d("MessengerService$IncomingHandler", 2, "IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW failed! isFollow: " + this.tT + "  uin: " + paramString);
      }
      localObject = new Intent("com.tencent.mobileqq.PublicAccountObserver");
      ((Intent)localObject).putExtra("action", "unFollow");
      ((Intent)localObject).putExtra("isSuccess", paramBoolean);
      ((Intent)localObject).putExtra("uin", paramString);
      this.val$service.getApplicationContext().sendBroadcast((Intent)localObject);
      rwv.a().a(new FollowUpdateEvent(0, paramString));
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("MessengerService$IncomingHandler", 2, "IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW failed! " + QLog.getStackTraceString(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afjo
 * JD-Core Version:    0.7.0.1
 */