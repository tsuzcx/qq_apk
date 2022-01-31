import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

public class tte
  implements PopupMenuDialog.OnClickActionListener
{
  public tte(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    boolean bool = false;
    switch (paramMenuItem.a)
    {
    default: 
      return;
    case 0: 
      paramMenuItem = this.a;
      if (!this.a.d) {
        bool = true;
      }
      paramMenuItem.d = bool;
      TroopAssistantManager.a().b(this.a.app, this.a.d);
      return;
    }
    paramMenuItem = new Intent(this.a, TroopAssisSettingActivity.class);
    paramMenuItem.setFlags(67108864);
    this.a.startActivity(paramMenuItem);
    ReportController.b(this.a.app, "P_CliOper", "Grp_msg", "", "help_list", "Clk_set", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tte
 * JD-Core Version:    0.7.0.1
 */