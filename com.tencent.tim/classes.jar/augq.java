import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.mail.MailPluginRecentMsg;

class augq
  extends BroadcastReceiver
{
  augq(augo paramaugo) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("cmd");
    if (QLog.isColorLevel()) {
      QLog.d("MailPluginManager", 2, "mMailPluginBroadcastReceiver onReceive cmd = " + paramContext);
    }
    int i;
    if ("bindmail".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("mailAccount");
      i = paramIntent.getIntExtra("mailAccountType", 1);
      ((augm)augo.a(this.this$0).getBusinessHandler(179)).n(augo.a(this.this$0).getLongAccountUin(), paramContext, i);
    }
    do
    {
      do
      {
        do
        {
          return;
          if ("unbindmail".equals(paramContext))
          {
            paramContext = paramIntent.getStringExtra("mailAccount");
            ((augm)augo.a(this.this$0).getBusinessHandler(179)).bd(augo.a(this.this$0).getLongAccountUin(), paramContext);
            return;
          }
          if (!"getMailUnreadNum".equals(paramContext)) {
            break;
          }
          i = paramIntent.getIntExtra("unreadNum", 0);
          paramContext = paramIntent.getStringExtra("email");
          paramIntent = augo.a(this.this$0).getApp().getResources().getString(2131695617);
          if (QLog.isColorLevel()) {
            QLog.d("MailPluginManager", 2, "mMailPluginBroadcastReceiver onReceive getMailUnreadNum sender = " + paramContext + ", unReadNum = " + i);
          }
        } while (i <= 0);
        paramContext = new MailPluginRecentMsg(paramContext, paramContext, "", paramIntent, paramIntent);
        this.this$0.a(paramContext, i);
        return;
        if ("preloadfinish".equals(paramContext))
        {
          augo.a(this.this$0, true);
          this.this$0.euS();
          if ((augo.a(this.this$0) != null) && (augo.a(this.this$0).isShowing()))
          {
            augo.a(this.this$0).dismiss();
            this.this$0.g(BaseActivity.sTopActivity, augo.a(this.this$0), augo.b(this.this$0));
            return;
          }
          augt.a().a(augo.a(this.this$0), "cmd_get_unread", null);
          return;
        }
      } while (!"reportClick".equals(paramContext));
      paramContext = paramIntent.getStringExtra("tValue");
      if (QLog.isColorLevel()) {
        QLog.d("MailPluginManager", 2, "mMailPluginBroadcastReceiver onReceive reportClick tValue = " + paramContext);
      }
    } while (TextUtils.isEmpty(paramContext));
    paramIntent.getIntExtra("entrance", 0);
    paramIntent.getIntExtra("reserve1", 0);
    paramIntent.getIntExtra("reserve2", 0);
    paramIntent.getIntExtra("reserve3", 0);
    paramIntent.getIntExtra("reserve4", 0);
    paramIntent.getStringExtra("reserve5");
    paramIntent.getStringExtra("reserve6");
    paramIntent.getStringExtra("reserve7");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     augq
 * JD-Core Version:    0.7.0.1
 */