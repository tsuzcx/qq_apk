import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class xja
  extends BroadcastReceiver
{
  xja(xit paramxit) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      xit.a(this.a, paramIntent);
      xit.d(this.a);
      xit.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xja
 * JD-Core Version:    0.7.0.1
 */