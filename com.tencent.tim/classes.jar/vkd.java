import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.KeepAliveGuideActivity;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vkd
  implements View.OnClickListener
{
  public vkd(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0, KeepAliveGuideActivity.class);
    localIntent.putExtra("GUIDE_FIRST_RUN", 1);
    this.this$0.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vkd
 * JD-Core Version:    0.7.0.1
 */