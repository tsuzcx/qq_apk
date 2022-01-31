import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateEnterActivity;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class eie
  implements ActionSheet.OnButtonClickListener
{
  public eie(NearbyTroopsActivity paramNearbyTroopsActivity) {}
  
  public void a(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      TroopCreateEnterActivity.a(this.a, 2, 51);
      this.a.v();
      ReportController.b(this.a.app, "P_CliOper", "Grp_nearby", "", "right", "create", 0, 0, "", "", "", "");
      return;
    }
    AddContactsActivity.a(this.a);
    this.a.v();
    ReportController.b(this.a.app, "P_CliOper", "Grp_nearby", "", "right", "find", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eie
 * JD-Core Version:    0.7.0.1
 */