import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class ube
  implements View.OnClickListener
{
  public ube(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    TroopAssistantActivity.a(this.a);
    ReportController.b(this.a.app, "dc00899", "Grp_msg", "", "helper-guide", "Clk_close", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ube
 * JD-Core Version:    0.7.0.1
 */