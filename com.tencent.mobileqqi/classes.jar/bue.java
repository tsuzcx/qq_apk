import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class bue
  implements View.OnClickListener
{
  public bue(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).getText().toString().length() > 30)
    {
      paramView = new Dialog(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 2131624405);
      paramView.setContentView(2130903942);
      ((TextView)paramView.findViewById(2131231029)).setText(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131563294));
      ((ProgressBar)paramView.findViewById(2131231028)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131234123)).setImageResource(2130837961);
      paramView.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).getText().toString(), true);
    if (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity))
    {
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.b.a(19)).a(this.jdField_a_of_type_JavaLangString, AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).getText().toString(), this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getIntExtra("stat_option", 0));
      if ("d2g".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getStringExtra("jump_from"))) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.b, "P_CliOper", "Grp_discuss", "", "discuss_set", "send_ask", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.b(2131562875);
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.show();
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 1, 2131562449, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bue
 * JD-Core Version:    0.7.0.1
 */