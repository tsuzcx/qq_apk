import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.provider.Settings.System;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;

public class cfg
  extends BroadcastReceiver
{
  public cfg(Conversation paramConversation) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("android.intent.action.TIME_SET".equals(paramContext)) || ("android.intent.action.TIMEZONE_CHANGED".equals(paramContext)) || ("android.intent.action.DATE_CHANGED".equals(paramContext)))
    {
      paramContext = Settings.System.getString(this.a.a().getContentResolver(), "date_format");
      if (Conversation.a(this.a) != null)
      {
        TimeManager.a().a();
        if (paramContext != null)
        {
          TimeManager.a().a(paramContext);
          TimeManager.a().a();
        }
        if (Conversation.a(this.a))
        {
          Conversation.a(this.a, 1014, 0L, false);
          this.a.k();
        }
      }
      SubAccountAssistantImpl.a().a(paramContext);
      if (this.a.a != null)
      {
        paramContext = this.a.a.a(TroopAssistantActivity.class);
        if (paramContext != null) {
          paramContext.sendEmptyMessage(2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cfg
 * JD-Core Version:    0.7.0.1
 */