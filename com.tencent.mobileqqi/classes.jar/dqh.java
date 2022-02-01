import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class dqh
  implements DialogInterface.OnClickListener
{
  dqh(dqg paramdqg, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.e(this.jdField_a_of_type_Dqg.a.getApplicationContext()))
    {
      this.jdField_a_of_type_Dqg.a.a.h(this.jdField_a_of_type_Dqg.a.c);
      this.jdField_a_of_type_Dqg.a.a(0, 2131562648, 0);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
      }
      return;
      this.jdField_a_of_type_Dqg.a.a(2, 2131562488, 1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dqh
 * JD-Core Version:    0.7.0.1
 */