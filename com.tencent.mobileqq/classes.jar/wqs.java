import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.subscribe.event.UserStateUpdateEvent;
import com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment;

public class wqs
  extends BroadcastReceiver
{
  private wqs(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (TextUtils.equals(paramIntent.getAction(), "action_reload_get_main_page")))
    {
      SubscribePersonalDetailFragment.b(this.a, false);
      wpt.a().a(new UserStateUpdateEvent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wqs
 * JD-Core Version:    0.7.0.1
 */