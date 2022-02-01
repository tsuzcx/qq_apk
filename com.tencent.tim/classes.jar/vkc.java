import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vkc
  implements View.OnClickListener
{
  public vkc(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0.getActivity(), SoundAndVibrateActivity.class);
    this.this$0.startActivity(localIntent);
    anot.a(this.this$0.app, "CliOper", "", "", "0X800403C", "0X800403C", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vkc
 * JD-Core Version:    0.7.0.1
 */