import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;

public class bsw
  implements View.OnClickListener
{
  public bsw(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!PhoneNumLoginImpl.a().a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a)) {}
    while ((this.a.jdField_b_of_type_AndroidAppDialog != null) && (this.a.jdField_b_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    AccountManageActivity.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bsw
 * JD-Core Version:    0.7.0.1
 */