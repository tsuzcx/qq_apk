import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class bnv
  implements DialogInterface.OnClickListener
{
  bnv(bnu parambnu, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.e(this.jdField_a_of_type_Bnu.a.getApplicationContext()))
    {
      this.jdField_a_of_type_Bnu.a.a.h(this.jdField_a_of_type_Bnu.a.c);
      this.jdField_a_of_type_Bnu.a.a(0, 2131363671, 0);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
      }
      return;
      this.jdField_a_of_type_Bnu.a.a(this.jdField_a_of_type_Bnu.a.getString(2131363450));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bnv
 * JD-Core Version:    0.7.0.1
 */