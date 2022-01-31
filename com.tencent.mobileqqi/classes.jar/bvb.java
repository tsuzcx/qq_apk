import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class bvb
  implements View.OnClickListener
{
  public bvb(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, ChatBackgroundSettingActivity.class);
    paramView.putExtra("bg_replace_entrance", 8);
    this.a.startActivity(paramView);
    ReportController.b(this.a.b, "CliOper", "", "", "Trends_tab", "Enter_background", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bvb
 * JD-Core Version:    0.7.0.1
 */