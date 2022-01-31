import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;

public class vwf
  extends BroadcastReceiver
{
  private vwf(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
      PublicAccountChatPie.a(this.a, 1);
    }
    while (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
      return;
    }
    PublicAccountChatPie.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vwf
 * JD-Core Version:    0.7.0.1
 */