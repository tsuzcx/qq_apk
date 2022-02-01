import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class aieh
  extends BroadcastReceiver
{
  aieh(aidx paramaidx) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("close.activity".equals(paramContext)) {
      if (aidx.a(this.a) != null) {
        aidx.a(this.a).finish();
      }
    }
    while ((!"close.loading".equals(paramContext)) || (this.a.m == null)) {
      return;
    }
    this.a.m.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aieh
 * JD-Core Version:    0.7.0.1
 */