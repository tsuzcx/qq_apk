import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class xc
  implements View.OnClickListener
{
  public xc(AddFriendVerifyActivity paramAddFriendVerifyActivity, EditText paramEditText, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    if ("".equals(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131363403), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getTitleBarHeight());
      return;
    }
    if (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity))
    {
      paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app.a(1);
      String str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getStringExtra("extra");
      String str2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getIntExtra("sub_source_id", 0);
      String str3 = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getStringExtra("src_name");
      paramView.a(AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity), str1, this.jdField_a_of_type_Int, (byte)0, str2, this.b, i, false, null, false, null, str3);
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131363527), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     xc
 * JD-Core Version:    0.7.0.1
 */