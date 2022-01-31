import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

class yvz
  extends BroadcastReceiver
{
  private yvz(yvs paramyvs) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (yvs.a(this.a))
    {
      yvs.b(this.a, false);
      yxp.a("GdtMvViewController", "SilentModeReceiver first auto called! so skip!");
    }
    while ((yvs.a(this.a) == null) || (!"android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(paramIntent.getAction()))) {
      return;
    }
    int i = yvs.a(this.a).getRingerMode();
    int j = yvs.a(this.a).getStreamVolume(3);
    yxp.a("GdtMvViewController", "system context mode: " + i + ", streamVolume = " + j);
    switch (i)
    {
    default: 
      yvs.c(this.a, true);
      this.a.a = true;
      yvs.a(this.a).a(true);
    }
    for (;;)
    {
      yvs.a(this.a, j, yvs.b(this.a), false);
      return;
      yvs.c(this.a, false);
      if (j > 0) {
        this.a.a = false;
      }
      yvs.a(this.a).a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yvz
 * JD-Core Version:    0.7.0.1
 */