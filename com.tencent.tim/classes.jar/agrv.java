import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class agrv
  extends BroadcastReceiver
{
  agrv(agrt paramagrt) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.media.AUDIO_BECOMING_NOISY")) {
      this.this$0.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agrv
 * JD-Core Version:    0.7.0.1
 */