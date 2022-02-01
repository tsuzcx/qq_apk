import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class afuk
  implements View.OnClickListener
{
  public afuk(ExtendFriendCampusFragment paramExtendFriendCampusFragment) {}
  
  public void onClick(View paramView)
  {
    if (!afxx.c(ExtendFriendCampusFragment.a(this.this$0)))
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.action.publishmood");
      avpw.d locald = avpw.d.a();
      locald.cMP = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localIntent.putExtra("qzone_plugin_activity_name", "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
      localIntent.putExtra("uin", locald.cMP);
      localIntent.putExtra("key_from_kuolie", true);
      avpw.b(ExtendFriendCampusFragment.a(this.this$0), locald, localIntent, 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afuk
 * JD-Core Version:    0.7.0.1
 */