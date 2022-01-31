import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.qwallet.PayCodeEntryActivity;

public class wwz
  implements View.OnClickListener
{
  public wwz(PayCodeEntryActivity paramPayCodeEntryActivity, wxb paramwxb) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPayCodeEntryActivity.a("payCodeEntry.cheCode", "actQQWlxclick", "0002");
    paramView = new Intent("com.tencent.mobileqq.action.jtcode");
    paramView.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPayCodeEntryActivity, JumpActivity.class);
    if (!TextUtils.isEmpty(PayCodeEntryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPayCodeEntryActivity))) {
      paramView.putExtra("city_name", PayCodeEntryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPayCodeEntryActivity));
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Wxb.b)) {
      paramView.putExtra("city_code", this.jdField_a_of_type_Wxb.b);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Wxb.a)) {
      paramView.putExtra("ykt_id", this.jdField_a_of_type_Wxb.a);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Wxb.c)) {
      paramView.putExtra("show_name", this.jdField_a_of_type_Wxb.c);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPayCodeEntryActivity.startActivityForResult(paramView, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wwz
 * JD-Core Version:    0.7.0.1
 */