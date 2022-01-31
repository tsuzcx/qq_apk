import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;

public class cqa
  extends BroadcastReceiver
{
  private cqa(BaseActivity2 paramBaseActivity2) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
    {
      BaseActivity2.h = false;
      GesturePWDUtils.setAppForground(paramContext, BaseActivity2.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cqa
 * JD-Core Version:    0.7.0.1
 */