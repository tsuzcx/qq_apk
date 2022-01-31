import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class yrs
  extends BroadcastReceiver
{
  private yrs(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = true;
    if (GdtVideoCommonView.d(this.a))
    {
      GdtVideoCommonView.c(this.a, false);
      yny.a("GdtVideoCommonView", "SilentModeReceiver first auto called! so skip!");
    }
    while ((GdtVideoCommonView.a(this.a) == null) || (!"android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(paramIntent.getAction()))) {
      return;
    }
    int i = GdtVideoCommonView.a(this.a).getRingerMode();
    int j = GdtVideoCommonView.a(this.a).getStreamVolume(3);
    yny.a("GdtVideoCommonView", "system context mode: " + i);
    switch (i)
    {
    default: 
      this.a.b = true;
      GdtVideoCommonView.d(this.a, false);
      GdtVideoCommonView.a(this.a).setOutputMute(true);
      GdtVideoCommonView.a(this.a, j, this.a.a, false);
      return;
    }
    this.a.b = false;
    if (j > 0) {
      GdtVideoCommonView.d(this.a, true);
    }
    paramContext = GdtVideoCommonView.a(this.a);
    if (!GdtVideoCommonView.e(this.a)) {}
    for (;;)
    {
      paramContext.setOutputMute(bool);
      break;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yrs
 * JD-Core Version:    0.7.0.1
 */