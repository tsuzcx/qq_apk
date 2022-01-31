import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;

public class egn
  implements View.OnClickListener
{
  public egn(TroopActivity paramTroopActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      this.a.e();
      return;
    case 2131232632: 
      ReportController.b(this.a.b, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_create", 0, 0, "", "", "", "");
      paramView = (TroopCreateLogic)this.a.b.getManager(30);
      if (paramView != null) {
        paramView.a(this.a, 0);
      }
      this.a.e();
      return;
    case 2131232634: 
      ReportController.b(this.a.b, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_join", 0, 0, "", "", "", "");
      ReportController.b(this.a.b, "CliOper", "", "", "Grp", "grplist_plus_join", 47, 0, "", "", "", "");
      TroopQQBrowserHelper.a(this.a, this.a.b.a());
      this.a.e();
      return;
    case 2131232636: 
      ReportController.b(this.a.b, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_msgset", 0, 0, "", "", "", "");
      ReportController.b(this.a.b, "CliOper", "", "", "Grp", "grplist_plus_setting", 0, 0, "", "", "", "");
      paramView = new Intent(this.a, TroopAssisSettingActivity.class);
      this.a.startActivity(paramView);
      this.a.e();
      return;
    case 2131232638: 
      TroopActivity.b(this.a);
      this.a.e();
      return;
    case 2131231456: 
      this.a.onBackPressed();
      return;
    }
    ReportController.b(this.a.b, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right", 0, 0, "", "", "", "");
    if (this.a.a.getVisibility() == 0)
    {
      this.a.e();
      return;
    }
    ReportController.b(this.a.b, "CliOper", "", "", "Grp", "Clk_grplist_plus", 0, 0, "", "", "", "");
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     egn
 * JD-Core Version:    0.7.0.1
 */