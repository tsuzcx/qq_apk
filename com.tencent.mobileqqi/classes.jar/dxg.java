import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

public class dxg
  implements View.OnClickListener
{
  public dxg(TroopMemberListActivity paramTroopMemberListActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.d)
    {
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.h == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.i > 0)) || (TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity) == 2))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getIntent();
        paramView.putExtra("member_uin", "0");
        paramView.putExtra("member_display_name", this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.setResult(-1, paramView);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.finish();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.h == 2) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.b, "CliOper", "", "", "0X800621D", "0X800621D", 0, 0, "", "", "", "");
        }
        return;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, "该讨论组@全体成员次数今天已达上限，请改日重试", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a.getHeight());
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.n))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.n, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a.getHeight());
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, "现在无法发送@All消息", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dxg
 * JD-Core Version:    0.7.0.1
 */