import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class uhg
  extends BroadcastReceiver
{
  uhg(uhf paramuhf) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (uhf.a(this.a) != null))
      {
        if (!paramContext.equals("homekey")) {
          break label55;
        }
        uhf.a(this.a).a();
      }
    }
    label55:
    while (!paramContext.equals("recentapps")) {
      return;
    }
    uhf.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhg
 * JD-Core Version:    0.7.0.1
 */