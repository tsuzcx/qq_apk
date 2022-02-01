import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class atym
  extends BroadcastReceiver
{
  atym(atyk paramatyk) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.media.AUDIO_BECOMING_NOISY")) {
      this.this$0.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atym
 * JD-Core Version:    0.7.0.1
 */