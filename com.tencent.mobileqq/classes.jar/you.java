import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class you
  implements View.OnClickListener
{
  you(yom paramyom, bbnq parambbnq) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopTipsPopWindow", 2, "mTroopNotifyAdImage onClick--------");
    }
    paramView = new Intent(this.jdField_a_of_type_Yom.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_Bbnq.b);
    this.jdField_a_of_type_Yom.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
    azmj.b(this.jdField_a_of_type_Yom.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "bulletin_popUp", "clk_ad", 0, 0, this.jdField_a_of_type_Yom.b, String.valueOf(this.jdField_a_of_type_Yom.jdField_a_of_type_Bbnp.a), "8020205751015455", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     you
 * JD-Core Version:    0.7.0.1
 */