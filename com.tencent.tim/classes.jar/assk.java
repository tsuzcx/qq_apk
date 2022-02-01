import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class assk
  extends BroadcastReceiver
{
  public assk(OpenSDKAppInterface paramOpenSDKAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("OpenSDKAppInterface", 2, "onReceive: invoked.  intent: " + paramIntent + " action: " + paramContext);
    }
    if ((paramContext != null) && (paramContext.equals("mqq.intent.action.ACCOUNT_KICKED"))) {
      OpenSDKAppInterface.a(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     assk
 * JD-Core Version:    0.7.0.1
 */