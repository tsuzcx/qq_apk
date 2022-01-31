import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.qwallet.PayCodeEntryActivity;

public class xae
  implements View.OnClickListener
{
  public xae(PayCodeEntryActivity paramPayCodeEntryActivity, xag paramxag) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPayCodeEntryActivity.a("payCodeEntry.cheCode", "actQQWlxclick", "0002");
    paramView = new Intent("com.tencent.mobileqq.action.jtcode");
    paramView.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPayCodeEntryActivity, JumpActivity.class);
    if (!TextUtils.isEmpty(PayCodeEntryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPayCodeEntryActivity))) {
      paramView.putExtra("city_name", PayCodeEntryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPayCodeEntryActivity));
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Xag.b)) {
      paramView.putExtra("city_code", this.jdField_a_of_type_Xag.b);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Xag.a)) {
      paramView.putExtra("ykt_id", this.jdField_a_of_type_Xag.a);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Xag.c)) {
      paramView.putExtra("show_name", this.jdField_a_of_type_Xag.c);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPayCodeEntryActivity.startActivityForResult(paramView, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xae
 * JD-Core Version:    0.7.0.1
 */