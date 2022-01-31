import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class dun
  implements ActionSheet.OnButtonClickListener
{
  public dun(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    boolean bool = false;
    switch (paramInt)
    {
    }
    for (;;)
    {
      TroopAssistantActivity.a(this.a).dismiss();
      return;
      paramView = this.a;
      if (!TroopAssistantActivity.a(this.a)) {
        bool = true;
      }
      TroopAssistantActivity.a(paramView, bool);
      TroopAssistantManager.a().b(this.a.b, TroopAssistantActivity.a(this.a));
      continue;
      paramView = new Intent(this.a, TroopAssisSettingActivity.class);
      paramView.setFlags(67108864);
      this.a.startActivity(paramView);
      ReportController.b(this.a.b, "P_CliOper", "Grp_msg", "", "help_list", "Clk_set", 0, 0, "", "", "", "");
      continue;
      TroopAssistantManager.a().a(this.a.b, false);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dun
 * JD-Core Version:    0.7.0.1
 */