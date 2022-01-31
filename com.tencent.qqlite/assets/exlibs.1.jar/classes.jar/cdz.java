import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;

public class cdz
  implements View.OnClickListener
{
  public cdz(TroopActivity paramTroopActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      this.a.d();
      return;
    case 2131297691: 
      ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_create", 0, 0, "", "", "", "");
      paramView = (TroopCreateLogic)this.a.app.getManager(29);
      if (paramView != null) {
        paramView.a(this.a, 0);
      }
      this.a.d();
      return;
    case 2131297695: 
      ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_join", 0, 0, "", "", "", "");
      ReportController.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_join", 47, 0, "", "", "", "");
      AddContactsActivity.a(this.a);
      this.a.d();
      return;
    case 2131297856: 
      ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_msgset", 0, 0, "", "", "", "");
      ReportController.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_setting", 0, 0, "", "", "", "");
      paramView = new Intent(this.a, TroopAssisSettingActivity.class);
      this.a.startActivity(paramView);
      this.a.d();
      return;
    case 2131297858: 
      TroopActivity.b(this.a);
      this.a.d();
      return;
    case 2131296897: 
      this.a.onBackPressed();
      return;
    }
    ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right", 0, 0, "", "", "", "");
    ReportController.b(this.a.app, "CliOper", "", "", "Grp", "Clk_grplist_plus", 0, 0, "", "", "", "");
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cdz
 * JD-Core Version:    0.7.0.1
 */