import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

public final class xrm
  implements Runnable
{
  public xrm(QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void run()
  {
    int i = TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).size();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "0", "0X80064CB", "0X80064CB", 0, 0, "" + this.jdField_a_of_type_Int, "" + i, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xrm
 * JD-Core Version:    0.7.0.1
 */