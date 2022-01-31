import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ywg
  extends BroadcastReceiver
{
  private ywg(ywe paramywe) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
    if (i == 3) {}
    for (boolean bool = true;; bool = false)
    {
      yxs.a("VolumeBroadcastReceiver", "VolumeBroadcastReceiver action type = " + paramIntent.getAction() + ", isStreamMusic = " + bool + ", streamType = " + i);
      if (("android.media.VOLUME_CHANGED_ACTION".equals(paramIntent.getAction())) && (bool) && (ywe.a(this.a) != null)) {
        ywe.a(this.a).a(new Object[0]);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ywg
 * JD-Core Version:    0.7.0.1
 */