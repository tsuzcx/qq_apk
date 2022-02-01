import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.open.agent.AgentActivity;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class aron
  extends BroadcastReceiver
{
  public aron(AgentActivity paramAgentActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.this$0.getAppInterface() != null) {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "-->onReceive, intent.getAction(): " + paramIntent.getAction());
    }
    if ("action_login_sucess".equals(paramIntent.getAction())) {
      if (AgentActivity.a(this.this$0) != null)
      {
        paramContext = artw.a(paramIntent, "login_success_uin");
        if (!TextUtils.isEmpty(paramContext)) {
          AgentActivity.a(this.this$0).putExtra("login_success_uin", paramContext);
        }
        if (AgentActivity.a(this.this$0).getIntExtra("intent_router", 0) != 1) {
          break label299;
        }
        PublicFragmentActivity.b.startForResult(this.this$0, AgentActivity.a(this.this$0), PublicFragmentActivityForOpenSDK.class, OpenAuthorityFragment.class, 0);
      }
    }
    for (;;)
    {
      if ((AgentActivity.a(this.this$0)) && (!this.this$0.a.isLogin()))
      {
        paramContext = this.this$0.a.getAccount();
        QLog.i("SDK_LOGIN.AgentActivity", 1, "mLoginReceiver() OpenSDKAppinterface not login, logined uin= " + paramContext);
        paramIntent = this.this$0.a.getApplication().getAllAccounts();
        if ((paramIntent != null) && (paramIntent.size() > 0) && (!TextUtils.isEmpty(paramContext)))
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            SimpleAccount localSimpleAccount = (SimpleAccount)paramIntent.next();
            if (paramContext.equals(localSimpleAccount.getUin()))
            {
              this.this$0.a.login(localSimpleAccount);
              QLog.i("SDK_LOGIN.AgentActivity", 1, "mLoginReceiver() OpenSDKAppinterface do login uin= " + paramContext);
            }
          }
        }
      }
      this.this$0.unregisterReceiver(this);
      return;
      label299:
      this.this$0.startActivityForResult(AgentActivity.a(this.this$0), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aron
 * JD-Core Version:    0.7.0.1
 */