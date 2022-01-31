import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.qwallet.PayCodeEntryActivity;

public class wxa
  implements View.OnClickListener
{
  public wxa(PayCodeEntryActivity paramPayCodeEntryActivity, wxb paramwxb) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPayCodeEntryActivity.a("payCodeEntry.cheCode2", "actQQWlxclick", "0003");
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
 * Qualified Name:     wxa
 * JD-Core Version:    0.7.0.1
 */