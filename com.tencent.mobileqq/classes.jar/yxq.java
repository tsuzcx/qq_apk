import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class yxq
  extends BroadcastReceiver
{
  yxq(yxj paramyxj) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      yxj.a(this.a, paramIntent);
      yxj.d(this.a);
      yxj.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yxq
 * JD-Core Version:    0.7.0.1
 */