import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

public class ugd
  implements View.OnClickListener
{
  public ugd(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (TroopMemberListActivity.ATroopMember)paramView.getTag();
    if (paramView != null)
    {
      QZoneHelper.a(this.a, QZoneHelper.UserInfo.a(), paramView.a, 0, 0, 0);
      ReportController.b(this.a.app, "dc00899", "Grp_Qzone", "", "mber_list", "clk_qzone", 0, 0, this.a.b, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ugd
 * JD-Core Version:    0.7.0.1
 */