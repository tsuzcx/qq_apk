import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity;
import com.tencent.mobileqq.activity.GesturePWDGuideActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vcs
  implements View.OnClickListener
{
  public vcs(GesturePWDGuideActivity paramGesturePWDGuideActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a, GesturePWDCreateActivity.class);
    this.a.startActivityForResult(localIntent, 999);
    this.a.overridePendingTransition(2130772009, 2130772002);
    anot.a(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_Gesture_password", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vcs
 * JD-Core Version:    0.7.0.1
 */