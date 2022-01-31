import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;

public class cmd
  implements DialogInterface.OnClickListener
{
  public cmd(ForwardOperations paramForwardOperations, int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case -2: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.d) {
        ForwardOperations.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidAppActivity, true, "shareToQQ", this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_Long);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidAppActivity.setResult(1);
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidAppActivity.finish();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("sdk_share", 2, "back call");
        return;
        ForwardOperations.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidAppActivity, false, "shareToQQ", this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_Long);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("sdk_share", 2, "send call");
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.b();
      return;
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      QfavHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), new Intent().putExtra("is_share_flag", true), -1);
      QfavReport.c(this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(0, "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cmd
 * JD-Core Version:    0.7.0.1
 */