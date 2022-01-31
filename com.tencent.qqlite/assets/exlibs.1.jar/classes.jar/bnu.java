import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class bnu
  implements View.OnClickListener
{
  public bnu(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_set", 0, 0, this.a.c, "", "", "");
    this.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bnu
 * JD-Core Version:    0.7.0.1
 */