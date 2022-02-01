import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class zzm
  extends BroadcastReceiver
{
  zzm(zzf paramzzf) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      zzf.a(this.a, paramIntent);
      zzf.d(this.a);
      zzf.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzm
 * JD-Core Version:    0.7.0.1
 */