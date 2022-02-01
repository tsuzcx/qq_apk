import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class tsv
  extends BroadcastReceiver
{
  tsv(tsu paramtsu) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (tsu.a(this.a) != null))
      {
        if (!paramContext.equals("homekey")) {
          break label55;
        }
        tsu.a(this.a).a();
      }
    }
    label55:
    while (!paramContext.equals("recentapps")) {
      return;
    }
    tsu.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tsv
 * JD-Core Version:    0.7.0.1
 */