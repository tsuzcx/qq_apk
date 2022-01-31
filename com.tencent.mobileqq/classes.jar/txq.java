import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class txq
  implements View.OnClickListener
{
  public txq(TroopMemberListActivity paramTroopMemberListActivity, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, TroopMemberListActivity.class);
    paramView.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.b);
    paramView.putExtra("param_from", 15);
    paramView.putExtra("param_seq_days", TroopMemberListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity));
    paramView.putExtra("param_seq_name", TroopMemberListActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity));
    paramView.putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.startActivityForResult(paramView, 4);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, "dc00899", "Grp_mber", "", "mber_list", "clk_inacentry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.b, "" + this.b, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     txq
 * JD-Core Version:    0.7.0.1
 */