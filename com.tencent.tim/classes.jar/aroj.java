import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.QLog;

public class aroj
  extends BroadcastReceiver
{
  public aroj(AgentActivity paramAgentActivity, String paramString1, Bundle paramBundle, String paramString2, boolean paramBoolean) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "registerExpiredReceiver onReceive null == intent");
    }
    do
    {
      return;
      paramContext = paramIntent.getStringExtra("serviceCmd");
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "registerExpiredReceiver onReceive serviceCmd=", paramContext });
    } while (!"QQConnectLogin.pre_auth".equals(paramContext));
    AgentActivity.a(this.this$0);
    AgentActivity.a(this.this$0, this.cBm, this.val$bundle, this.val$appid, this.dcy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aroj
 * JD-Core Version:    0.7.0.1
 */