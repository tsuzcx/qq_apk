import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.tim.call.activity.CallActivity;

public class atcz
  extends BroadcastReceiver
{
  public atcz(CallActivity paramCallActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("android.intent.action.TIME_SET".equals(paramContext)) || ("android.intent.action.TIMEZONE_CHANGED".equals(paramContext)) || ("android.intent.action.DATE_CHANGED".equals(paramContext))) {
      this.this$0.etd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atcz
 * JD-Core Version:    0.7.0.1
 */