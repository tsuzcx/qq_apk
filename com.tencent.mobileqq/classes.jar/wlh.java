import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.HashMap;

public class wlh
  implements View.OnClickListener
{
  public wlh(TroopActivity paramTroopActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    default: 
      this.a.b();
      return;
    case 2131363245: 
    case 2131363994: 
    case 2131363995: 
      if (this.a.a != null)
      {
        paramView = new Intent();
        if (!this.a.a.isEmpty()) {
          bool = true;
        }
        paramView.putExtra("isDataChanged", bool);
        this.a.setResult(-1, paramView);
      }
      this.a.onBackPressed();
      return;
    }
    ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right", 0, 0, "", "", "", "");
    if (this.a.a())
    {
      this.a.b();
      return;
    }
    ReportController.b(this.a.app, "CliOper", "", "", "Grp", "Clk_grplist_plus", 0, 0, "", "", "", "");
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wlh
 * JD-Core Version:    0.7.0.1
 */