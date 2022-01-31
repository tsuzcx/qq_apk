import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

class ywc
  extends BroadcastReceiver
{
  private ywc(yvv paramyvv) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (yvv.a(this.a))
    {
      yvv.b(this.a, false);
      yxs.a("GdtMvViewController", "SilentModeReceiver first auto called! so skip!");
    }
    while ((yvv.a(this.a) == null) || (!"android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(paramIntent.getAction()))) {
      return;
    }
    int i = yvv.a(this.a).getRingerMode();
    int j = yvv.a(this.a).getStreamVolume(3);
    yxs.a("GdtMvViewController", "system context mode: " + i + ", streamVolume = " + j);
    switch (i)
    {
    default: 
      yvv.c(this.a, true);
      this.a.a = true;
      yvv.a(this.a).a(true);
    }
    for (;;)
    {
      yvv.a(this.a, j, yvv.b(this.a), false);
      return;
      yvv.c(this.a, false);
      if (j > 0) {
        this.a.a = false;
      }
      yvv.a(this.a).a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ywc
 * JD-Core Version:    0.7.0.1
 */