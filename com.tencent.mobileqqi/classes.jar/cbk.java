import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class cbk
  implements DialogInterface.OnClickListener
{
  public cbk(AuthDevActivity paramAuthDevActivity, String paramString, ArrayList paramArrayList, int paramInt, boolean paramBoolean, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.getString(2131562452), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.d());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "OnClick.begin to delAuthDev");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.b, "CliOper", "", "", "My_eq_lock", "My_eq_lock_delete", 0, 0, "", "", "", "");
    if (EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long)) {
      AuthDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.devlock.AuthDevActivity", 2, "OnClick.delAuthDev fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cbk
 * JD-Core Version:    0.7.0.1
 */