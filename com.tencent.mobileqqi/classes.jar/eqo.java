import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.RenMaiQuanTeamListInnerFrame;
import com.tencent.mobileqq.data.CircleGroup;
import com.tencent.mobileqq.statistics.ReportController;

class eqo
  implements View.OnClickListener
{
  eqo(eqn parameqn, CircleGroup paramCircleGroup) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putInt("group_uin", this.jdField_a_of_type_ComTencentMobileqqDataCircleGroup.groupId);
    paramView.putString("group_name", this.jdField_a_of_type_ComTencentMobileqqDataCircleGroup.groupName);
    this.jdField_a_of_type_Eqn.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(7, paramView);
    ReportController.b(this.jdField_a_of_type_Eqn.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Network_circle", "Mutichat_circle_grp", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCircleGroup.groupId), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eqo
 * JD-Core Version:    0.7.0.1
 */