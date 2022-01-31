import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.qwallet.PayCodeEntryActivity;

public class xfv
  implements View.OnClickListener
{
  public xfv(PayCodeEntryActivity paramPayCodeEntryActivity, xfw paramxfw) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPayCodeEntryActivity.a("payCodeEntry.cheCode2", "actQQWlxclick", "0003");
    paramView = new Intent("com.tencent.mobileqq.action.jtcode");
    paramView.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPayCodeEntryActivity, JumpActivity.class);
    if (!TextUtils.isEmpty(PayCodeEntryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPayCodeEntryActivity))) {
      paramView.putExtra("city_name", PayCodeEntryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPayCodeEntryActivity));
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Xfw.b)) {
      paramView.putExtra("city_code", this.jdField_a_of_type_Xfw.b);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Xfw.a)) {
      paramView.putExtra("ykt_id", this.jdField_a_of_type_Xfw.a);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Xfw.c)) {
      paramView.putExtra("show_name", this.jdField_a_of_type_Xfw.c);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPayCodeEntryActivity.startActivityForResult(paramView, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xfv
 * JD-Core Version:    0.7.0.1
 */