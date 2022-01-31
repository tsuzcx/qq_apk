import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class xaa
  extends BroadcastReceiver
{
  xaa(wzt paramwzt) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      wzt.a(this.a, paramIntent);
      wzt.d(this.a);
      wzt.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xaa
 * JD-Core Version:    0.7.0.1
 */