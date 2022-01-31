import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class dqp
  implements View.OnClickListener
{
  public dqp(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.b, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_set", 0, 0, this.a.c, "", "", "");
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dqp
 * JD-Core Version:    0.7.0.1
 */