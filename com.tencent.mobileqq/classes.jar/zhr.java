import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public final class zhr
  implements Runnable
{
  public zhr(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0, 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zhr
 * JD-Core Version:    0.7.0.1
 */