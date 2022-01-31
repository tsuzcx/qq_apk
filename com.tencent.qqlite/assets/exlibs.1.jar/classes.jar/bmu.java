import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

class bmu
  implements DialogInterface.OnClickListener
{
  bmu(bmt parambmt, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bmt.a.finish();
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bmu
 * JD-Core Version:    0.7.0.1
 */