import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssistSetGuideActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class dog
  implements View.OnClickListener
{
  public dog(TroopAssistSetGuideActivity paramTroopAssistSetGuideActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131234640: 
      TroopAssistSetGuideActivity.a(this.a);
      ReportController.b(this.a.b, "CliOper", "", "", "Grp_helper", "Clk_not_set", 0, 0, "", "", "", "");
      return;
    }
    TroopAssistSetGuideActivity.b(this.a);
    ReportController.b(this.a.b, "CliOper", "", "", "Grp_helper", "Clk_quiet_mode", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dog
 * JD-Core Version:    0.7.0.1
 */