import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class aebc
  extends BroadcastReceiver
{
  aebc(aebb paramaebb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (paramContext != null)
      {
        if ((!paramContext.equals("com.tencent.mobileqq.intent.logout")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) && (!paramContext.equals("mqq.intent.action.FORCE_LOGOUT")) && (!paramContext.equals("mqq.intent.action.LOGOUT"))) {
          break label57;
        }
        this.b.ff();
      }
    }
    label57:
    while ((!paramContext.equals("mqq.intent.action.LOGIN")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED"))) {
      return;
    }
    this.b.cOY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aebc
 * JD-Core Version:    0.7.0.1
 */