import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalDetailFragment;
import com.tencent.biz.subscribe.event.UserStateUpdateEvent;
import mqq.util.WeakReference;

public class txd
  extends BroadcastReceiver
{
  private WeakReference<QCirclePersonalDetailFragment> a;
  
  public txd(QCirclePersonalDetailFragment paramQCirclePersonalDetailFragment)
  {
    this.a = new WeakReference(paramQCirclePersonalDetailFragment);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = (QCirclePersonalDetailFragment)this.a.get();
    if ((paramContext != null) && (paramIntent != null) && (TextUtils.equals(paramIntent.getAction(), "action_reload_get_main_page")) && (paramIntent.hasExtra("uin")) && (paramIntent.getStringExtra("uin").equals(QCirclePersonalDetailFragment.a(paramContext))))
    {
      QCirclePersonalDetailFragment.a(paramContext, false);
      QCirclePersonalDetailFragment.b(paramContext, false);
      yiw.a().a(new UserStateUpdateEvent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txd
 * JD-Core Version:    0.7.0.1
 */