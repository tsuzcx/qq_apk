import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vjz
  implements View.OnClickListener
{
  public vjz(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0, TroopAssisSettingActivity.class);
    this.this$0.startActivity(localIntent);
    anot.a(this.this$0.app, "CliOper", "", "", "Setting_tab", "Clk_msginfor_grp", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vjz
 * JD-Core Version:    0.7.0.1
 */