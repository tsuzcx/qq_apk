import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.statistics.ReportController;

class eqe
  implements View.OnClickListener
{
  eqe(eqc parameqc, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putInt("friend_team_id", ((Groups)this.jdField_a_of_type_Eqc.getItem(this.jdField_a_of_type_Int)).group_id);
    paramView.putString("group_name", ((Groups)this.jdField_a_of_type_Eqc.getItem(this.jdField_a_of_type_Int)).group_name);
    this.jdField_a_of_type_Eqc.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(6, paramView);
    ReportController.b(this.jdField_a_of_type_Eqc.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "5", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eqe
 * JD-Core Version:    0.7.0.1
 */