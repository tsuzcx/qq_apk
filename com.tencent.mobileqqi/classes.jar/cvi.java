import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;

public class cvi
  extends BroadcastReceiver
{
  public cvi(GesturePWDUnlockActivity paramGesturePWDUnlockActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getLongExtra("timeid", 0L) > this.a.a) && (!this.a.isFinishing())) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cvi
 * JD-Core Version:    0.7.0.1
 */