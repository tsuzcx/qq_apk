import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.DataLineHandler;

public class zcb
  extends BroadcastReceiver
{
  public zcb(DataLineHandler paramDataLineHandler) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext.equalsIgnoreCase("android.intent.action.MEDIA_UNMOUNTED")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_UNMOUNTABLE")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_EJECT")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_REMOVED"))) {
      this.a.d(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zcb
 * JD-Core Version:    0.7.0.1
 */