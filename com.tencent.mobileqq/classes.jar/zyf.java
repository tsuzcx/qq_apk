import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class zyf
  implements View.OnClickListener
{
  public zyf(AddFriendVerifyActivity paramAddFriendVerifyActivity, EditText paramEditText, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    if ("".equals(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim())) {
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131624505), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getTitleBarHeight());
    }
    for (;;)
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.b), String.valueOf(this.c), "", "");
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077B4  sourceId = " + this.b + " subSourceId = " + this.c);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.c)) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 1, "", "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(this.b, this.jdField_a_of_type_Int);
      return;
      if (badq.d(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity))
      {
        paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app.a(1);
        String str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getStringExtra("extra");
        String str2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
        int i = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getIntExtra("sub_source_id", 0);
        String str3 = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getStringExtra("src_name");
        paramView.a(AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity), str1, this.jdField_a_of_type_Int, (byte)0, str2, this.b, i, false, null, false, null, str3, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getBundleExtra("flc_extra_param"));
      }
      else
      {
        bbmy.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131628948), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     zyf
 * JD-Core Version:    0.7.0.1
 */