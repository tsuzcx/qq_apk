import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.TrafficStatActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class bvj
  implements View.OnClickListener
{
  public bvj(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, TrafficStatActivity.class);
    this.a.startActivity(paramView);
    ReportController.b(this.a.b, "CliOper", "", "", "Setting_tab", "Clk_traffic_statistics", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bvj
 * JD-Core Version:    0.7.0.1
 */