import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public final class hdw
  implements Runnable
{
  public hdw(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    String str1 = null;
    if (QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), new String[] { this.jdField_a_of_type_JavaLangString })) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561614);
    }
    for (String str2 = "0";; str2 = "1")
    {
      if (str1 != null) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2, str1, 0).b(this.jdField_a_of_type_Int);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Fast_launch", "Fast_launch_creat", 0, 0, this.b, str2, "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hdw
 * JD-Core Version:    0.7.0.1
 */