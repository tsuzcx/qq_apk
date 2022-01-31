import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class xix
  extends BroadcastReceiver
{
  xix(xiq paramxiq) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      xiq.a(this.a, paramIntent);
      xiq.d(this.a);
      xiq.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xix
 * JD-Core Version:    0.7.0.1
 */