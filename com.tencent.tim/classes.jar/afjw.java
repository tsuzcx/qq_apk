import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.MessengerService.a;
import com.tencent.qphone.base.util.QLog;

public class afjw
  extends BroadcastReceiver
{
  public afjw(MessengerService.a parama, MessengerService paramMessengerService, Bundle paramBundle) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((TextUtils.isEmpty(paramContext)) || (!TextUtils.equals(paramContext, "mqq.intent.action.DEVLOCK_ROAM"))) {
      return;
    }
    paramContext = this.val$service.getApplicationContext();
    if (paramContext != null) {
      paramContext.unregisterReceiver(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.web.MessengerService", 2, "openDevLock unregisterReceiver context: " + paramContext);
    }
    paramContext = new Bundle(paramIntent.getExtras());
    this.val$reqbundle.putBundle("response", paramContext);
    this.val$service.cp(this.val$reqbundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afjw
 * JD-Core Version:    0.7.0.1
 */