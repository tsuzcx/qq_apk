import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class srz
  extends BroadcastReceiver
{
  srz(srs paramsrs) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      srs.a(this.this$0, paramIntent);
      srs.d(this.this$0);
      srs.c(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     srz
 * JD-Core Version:    0.7.0.1
 */