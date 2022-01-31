import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public final class xlg
  implements Runnable
{
  public xlg(QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void run()
  {
    String str = "0X80067EA";
    ServiceAccountFolderManager localServiceAccountFolderManager = ServiceAccountFolderManager.a();
    int i = localServiceAccountFolderManager.b();
    int j = localServiceAccountFolderManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (j == 1) {
      str = "0X80067E8";
    }
    for (;;)
    {
      long l = localServiceAccountFolderManager.a();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "Pb_account_lifeservice", "", str, str, 0, 0, "" + l, "" + j, "" + i, String.valueOf(this.jdField_a_of_type_Int + 1));
      return;
      if (j == 2) {
        str = "0X80067E9";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xlg
 * JD-Core Version:    0.7.0.1
 */