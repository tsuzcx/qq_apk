import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

class yml
  extends BroadcastReceiver
{
  private yml(yme paramyme) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (yme.a(this.a))
    {
      yme.b(this.a, false);
      yny.a("GdtMvViewController", "SilentModeReceiver first auto called! so skip!");
    }
    while ((yme.a(this.a) == null) || (!"android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(paramIntent.getAction()))) {
      return;
    }
    int i = yme.a(this.a).getRingerMode();
    int j = yme.a(this.a).getStreamVolume(3);
    yny.a("GdtMvViewController", "system context mode: " + i + ", streamVolume = " + j);
    switch (i)
    {
    default: 
      yme.c(this.a, true);
      this.a.a = true;
      yme.a(this.a).a(true);
    }
    for (;;)
    {
      yme.a(this.a, j, yme.b(this.a), false);
      return;
      yme.c(this.a, false);
      if (j > 0) {
        this.a.a = false;
      }
      yme.a(this.a).a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yml
 * JD-Core Version:    0.7.0.1
 */