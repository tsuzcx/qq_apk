import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class aweu
  extends BroadcastReceiver
{
  aweu(awet paramawet) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.qq.syncSecretShuoshuoMsg"))
    {
      int i = paramIntent.getIntExtra("com.tencent.qq.syncSecretShuoshuoMsgType", 0);
      awet.a(this.b, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aweu
 * JD-Core Version:    0.7.0.1
 */