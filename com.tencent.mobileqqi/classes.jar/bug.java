import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class bug
  implements View.OnClickListener
{
  public bug(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).getText().toString().trim();
    if (TextUtils.isEmpty(paramView))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.isFinishing()) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131561421), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.d());
      }
      return;
    }
    if (paramView.length() > 30)
    {
      paramView = new Dialog(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 2131624405);
      paramView.setContentView(2130903942);
      ((TextView)paramView.findViewById(2131231029)).setText(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131563294));
      ((ProgressBar)paramView.findViewById(2131231028)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131234122)).setImageResource(2130837961);
      paramView.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(paramView, true);
    if (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity))
    {
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.b.a(19)).a(this.jdField_a_of_type_JavaLangString, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getIntExtra("stat_option", 0));
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.b(2131562875);
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.show();
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 1, 2131562449, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bug
 * JD-Core Version:    0.7.0.1
 */