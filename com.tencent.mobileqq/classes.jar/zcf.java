import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class zcf
  extends BroadcastReceiver
{
  zcf(zby paramzby) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      zby.a(this.a, paramIntent);
      zby.d(this.a);
      zby.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zcf
 * JD-Core Version:    0.7.0.1
 */