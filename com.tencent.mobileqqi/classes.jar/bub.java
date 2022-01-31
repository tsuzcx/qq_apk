import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class bub
  implements View.OnClickListener
{
  public bub(AddFriendVerifyActivity paramAddFriendVerifyActivity, EditText paramEditText, String paramString1, int paramInt, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if ("".equals(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131561421), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.d());
      return;
    }
    if (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity))
    {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.b.a(1)).a(this.jdField_a_of_type_JavaLangString, AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity), true, (byte)0, this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getIntExtra("sub_source_id", 0), this.b, (byte)0, null, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getStringExtra("troop_uin"), false, null);
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131562449), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bub
 * JD-Core Version:    0.7.0.1
 */