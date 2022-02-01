import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class asez
  extends BroadcastReceiver
{
  asez(asey paramasey) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = "tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction());
    asev.d("CallingStateMonitor", String.format("onVideoChattingStateChanged isChatting=%s", new Object[] { Boolean.valueOf(bool) }));
    if (asey.a(this.b) != null) {
      asey.a(this.b).Uy(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asez
 * JD-Core Version:    0.7.0.1
 */