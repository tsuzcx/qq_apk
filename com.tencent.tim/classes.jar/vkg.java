import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class vkg
  extends BroadcastReceiver
{
  public vkg(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive"))
    {
      paramContext = paramIntent.getStringExtra("uin");
      NotifyPushSettingActivity.a(this.this$0, paramContext);
    }
    do
    {
      do
      {
        return;
        if (!paramContext.equals("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive")) {
          break;
        }
        paramContext = paramIntent.getStringExtra("uin");
        paramIntent.getBooleanExtra("configPCActive", false);
      } while (!this.this$0.app.getAccount().equals(paramContext));
      return;
    } while (!paramContext.equals("com.tencent.mobileqq.activity.NotifyPushSettingActivity.HelloLiveMessage"));
    paramContext = paramIntent.getStringExtra("uin");
    NotifyPushSettingActivity.b(this.this$0, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vkg
 * JD-Core Version:    0.7.0.1
 */