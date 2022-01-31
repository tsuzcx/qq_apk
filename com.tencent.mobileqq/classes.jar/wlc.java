import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class wlc
  implements View.OnClickListener
{
  wlc(wku paramwku, ayop paramayop) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopTipsPopWindow", 2, "mTroopNotifyAdImage onClick--------");
    }
    paramView = new Intent(this.jdField_a_of_type_Wku.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_Ayop.b);
    this.jdField_a_of_type_Wku.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
    awqx.b(this.jdField_a_of_type_Wku.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "bulletin_popUp", "clk_ad", 0, 0, this.jdField_a_of_type_Wku.b, String.valueOf(this.jdField_a_of_type_Wku.jdField_a_of_type_Ayoo.a), "8020205751015455", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wlc
 * JD-Core Version:    0.7.0.1
 */