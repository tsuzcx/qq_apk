import QQService.SvcDevLoginInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class cul
  implements View.OnClickListener
{
  public cul(LoginInfoActivity paramLoginInfoActivity, Button paramButton, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity, this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getString(2131562452), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.d());
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.b, "CliOper", "", "", "My_eq", "Kick_off_PC", 0, 0, "", "", "", "");
    paramView = (SvcDevLoginInfo)this.jdField_a_of_type_AndroidWidgetButton.getTag();
    if (paramView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.b.getSubAccountKey(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.b.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.b.getAccount(), new cum(this, paramView));
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getString(2131561765), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cul
 * JD-Core Version:    0.7.0.1
 */