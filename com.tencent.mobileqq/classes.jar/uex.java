import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.statistics.ReportTask;

public class uex
  implements View.OnClickListener
{
  public uex(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.g();
    new ReportTask(this.a.app).a("dc00899").b("Grp_online").c("mber_list").d("clk_more").a(new String[] { this.a.b }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uex
 * JD-Core Version:    0.7.0.1
 */