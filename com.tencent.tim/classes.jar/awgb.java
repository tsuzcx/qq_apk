import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class awgb
  extends BroadcastReceiver
{
  awgb(awga paramawga) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.qq.syncQunMsg"))
    {
      int i = paramIntent.getIntExtra("com.tencent.qq.unreadcount", 0);
      awga.a(this.this$0, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awgb
 * JD-Core Version:    0.7.0.1
 */