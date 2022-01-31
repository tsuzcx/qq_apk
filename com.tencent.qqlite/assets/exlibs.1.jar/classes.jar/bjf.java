import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class bjf
  implements View.OnClickListener
{
  public bjf(SetTroopAdminsActivity paramSetTroopAdminsActivity) {}
  
  public void onClick(View paramView)
  {
    if ((SetTroopAdminsActivity.a(this.a) > 0) && (SetTroopAdminsActivity.a(this.a) <= SetTroopAdminsActivity.a(this.a).size()))
    {
      QQToast.a(this.a, 1, String.format(this.a.getString(2131362868), new Object[] { Integer.valueOf(SetTroopAdminsActivity.a(this.a)) }), 0).b(this.a.getTitleBarHeight());
      return;
    }
    paramView = new Intent(this.a, TroopMemberListActivity.class);
    paramView.putExtra("troop_code", SetTroopAdminsActivity.a(this.a));
    paramView.putExtra("troop_uin", SetTroopAdminsActivity.b(this.a));
    paramView.putExtra("param_from", 2);
    this.a.startActivityForResult(paramView, 0);
    try
    {
      ReportController.b(this.a.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, SetTroopAdminsActivity.a(this.a), "3", "0", "");
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bjf
 * JD-Core Version:    0.7.0.1
 */