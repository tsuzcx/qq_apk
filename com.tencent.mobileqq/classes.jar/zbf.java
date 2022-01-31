import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.gdtad.views.video.GdtVideoCommonView;

public class zbf
  extends BroadcastReceiver
{
  private zbf(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i;
    if (("android.intent.action.HEADSET_PLUG".equals(paramIntent.getAction())) && (paramIntent.hasExtra("state")))
    {
      i = paramIntent.getIntExtra("state", 0);
      if (i != 1) {
        break label42;
      }
      yxp.a("GdtVideoCommonView", "ACTION_HEADSET_PLUG HEADSET on");
    }
    label42:
    do
    {
      do
      {
        return;
      } while (i != 0);
      yxp.a("GdtVideoCommonView", "ACTION_HEADSET_PLUG HEADSET off " + this.a.a);
    } while (!this.a.a);
    GdtVideoCommonView.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zbf
 * JD-Core Version:    0.7.0.1
 */