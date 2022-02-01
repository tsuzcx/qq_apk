import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vuy
  implements View.OnClickListener
{
  public vuy(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    SoundAndVibrateActivity.a(this.a, "CHANNEL_ID_SHOW_BADGE");
    anpc.report("My_settings_message_notification_shock_null");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vuy
 * JD-Core Version:    0.7.0.1
 */